// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.mastercard.bot.dev.engage;

import com.codepoetics.protonpack.collectors.CompletableFutures;
import com.microsoft.bot.builder.ActivityHandler;
import com.microsoft.bot.builder.MessageFactory;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.integration.ClasspathPropertiesConfiguration;
import com.microsoft.bot.integration.Configuration;
import com.microsoft.bot.schema.ActionTypes;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.CardAction;
import com.microsoft.bot.schema.ChannelAccount;
import com.microsoft.bot.schema.ConversationReference;
import com.microsoft.bot.schema.SuggestedActions;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Bot extends ActivityHandler {


    private final EngageRecognizer luisRecognizer;



    Configuration withConfiguration = new ClasspathPropertiesConfiguration();
    String baseUrl = withConfiguration.getProperty("baseUrl");
    String clientId = withConfiguration.getProperty("client_Id");
    String redirectUrl = withConfiguration.getProperty("redirect");
   // String  location=  baseUrl+"client_id="+clientId+"&scope=accounts%20offline_access%20payments:inbound%20payments:outbound&redirect_uri="+redirectUrl+"&response_type=code";

    private final String welcomeMessage = "Welcome to Finicity open banking chat bot \r\n Continue by linking account/s to the chat bot";

    private ConversationReferences conversationReferences;

    public Bot(EngageRecognizer luisRecognizer, ConversationReferences withReferences) {
        this.luisRecognizer = luisRecognizer;
        conversationReferences = withReferences;
    }

    @Override
    protected CompletableFuture<Void> onMessageActivity(TurnContext turnContext) {
        addConversationReference(turnContext.getActivity());
        String activityMessage = turnContext.getActivity().getText();
        if(activityMessage.equals("balance")){

            String accounts = FinicityNetwork.getAccounts();
            return turnContext
                    .sendActivity(MessageFactory.text(accounts))
                    .thenCompose(resourceResponse -> homeActivity(turnContext))
                    .thenApply(result -> null);

        }
        else if(activityMessage.equals("transaction")){
            String transactions = FinicityNetwork.getTransactions();

            return turnContext
                    .sendActivity(MessageFactory.text(transactions))
                    .thenCompose(resourceResponse -> homeActivity(turnContext))
                    .thenApply(result -> null);
        }
/*        if(activityMessage.equals("Checking Account") || activityMessage.equals("Direct Debit")){
            String transactions = NetworkCall.getTransactions(turnContext.getActivity().getText());
            return turnContext
                    .sendActivity(MessageFactory.text(transactions))
                    .thenCompose(resourceResponse -> homeActivity(turnContext))
                    .thenApply(result -> null);
        }
            return luisRecognizer.recognize(turnContext).thenCompose(luisResult -> {

              String returnValue = luisResult.getTopScoringIntent().intent;
              if(returnValue.equals("GetBalance")){
                  String accounts = NetworkCall.getAccounts();
                  if(accounts.equals("invalid response"))
                  {
                      return turnContext.sendActivity(MessageFactory.text("Invalid response, please try again")).thenApply(sendResult -> null);
                  }
                  return turnContext
                          .sendActivity(MessageFactory.text((accounts)))
                          .thenCompose(resourceResponse -> homeActivity(turnContext))
                          .thenApply(result -> null);
                }
              else if(returnValue.equals("GetTransaction")){
                  String transactions = NetworkCall.getAccountList();
                  return turnContext
                          .sendActivity(MessageFactory.text("Seems you want to check your previous transactions."))
                          .thenCompose(resourceResponse -> accountCard(turnContext, transactions))
                          .thenApply(result -> null);
              }
              else{
                  return turnContext.sendActivity(MessageFactory.text("Text not recognized, please try again")).thenApply(sendResult -> null);
              }
            });*/
        return turnContext.sendActivity(MessageFactory.text("Text not recognized, please try again")).thenApply(sendResult -> null);

    }

    @Override
    protected CompletableFuture<Void> onMembersAdded(
        List<ChannelAccount> membersAdded,
        TurnContext turnContext
    ) {
        FinicityNetwork.getAccessToken();
        return membersAdded.stream()
            .filter(
                // Greet anyone that was not the target (recipient) of this message.
                member -> !StringUtils
                    .equals(member.getId(), turnContext.getActivity().getRecipient().getId())
            )
            .map(channel -> turnContext.sendActivity(MessageFactory.text(welcomeMessage)))
            .collect(CompletableFutures.toFutureList())
                .thenCompose(resourceResponses -> welcomeCard(turnContext))
            .thenApply(resourceResponses -> null);
    }

    @Override
    protected CompletableFuture<Void> onConversationUpdateActivity(TurnContext turnContext) {
        addConversationReference(turnContext.getActivity());
        return super.onConversationUpdateActivity(turnContext);
    }

    // adds a ConversationReference to the shared Map.
    private void addConversationReference(Activity activity) {
        ConversationReference conversationReference = activity.getConversationReference();
        conversationReferences.put(conversationReference.getUser().getId(), conversationReference);
    }


    private  CompletableFuture<Void> welcomeCard(TurnContext turnContext){
        String location = "";
        try{
          String response =  FinicityNetwork.generateUrl();
         location = new JSONObject(response).getString("link");
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

       Activity reply = MessageFactory.text("");
       CardAction welcomeDetails = new CardAction();
       welcomeDetails.setDisplayText("Display Text");
       welcomeDetails.setTitle("Link Account/s");
       welcomeDetails.setValue(location);
       welcomeDetails.setType(ActionTypes.OPEN_URL);
       SuggestedActions actions = new SuggestedActions();
       actions.setActions(Arrays.asList(welcomeDetails));
       reply.setSuggestedActions(actions);
       return turnContext.sendActivity(reply).thenApply(sendResult -> null);
    }

    private static CompletableFuture<Void> homeActivity(TurnContext turnContext)
    {
        return turnContext.sendActivity(MessageFactory.text("What would you like to do? ")).thenApply(sendResult -> null);
    }

    private CompletableFuture<Void> accountCard(TurnContext turnContext, String accounts){
        Activity message = MessageFactory.text("Which account would you like to use ?");
        List<String> accountList = Stream.of(accounts.split(",")).collect(Collectors.toList());

        List<CardAction> cardActions = new ArrayList<>();
        for (String account : accountList){
            CardAction accountDetails = new CardAction();
            accountDetails.setTitle(account);
            accountDetails.setType(ActionTypes.IM_BACK);
            accountDetails.setValue(account);
            cardActions.add(accountDetails);
        }

       SuggestedActions actions = new SuggestedActions();
       actions.setActions(cardActions);
       message.setSuggestedActions(actions);
       return turnContext.sendActivity(message).thenApply(sendResult -> null);
    }

}
