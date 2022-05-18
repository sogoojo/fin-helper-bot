// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.mastercard.bot.dev.engage;

import com.codepoetics.protonpack.collectors.CompletableFutures;
import com.microsoft.bot.builder.ActivityHandler;
import com.microsoft.bot.builder.ConversationState;
import com.microsoft.bot.builder.MessageFactory;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.builder.UserState;
import com.microsoft.bot.schema.ActionTypes;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.CardAction;
import com.microsoft.bot.schema.ChannelAccount;
import com.microsoft.bot.schema.ConversationReference;
import com.microsoft.bot.schema.SuggestedActions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class Bot extends ActivityHandler {
    @Value("${server.port:3978}")
    private int port;

    private final EngageRecognizer luisRecognizer;
    private ConversationState conversationState;
    private UserState userState;


    static String baseurl = "https://api-sandbox.aiia.eu/v1/oauth/connect?";
     //static String client_id = "aiiaengage-4f5ee715-7961-4070-b8fc-64db5e2d1aef";
   // static String client_redirect_url ="http://localhost:3978/callback";
     static String client_id = "bankap-81d9ced0-f810-427f-8f4e-21765917c947";
      static String client_redirect_url = "https://fin-chatbot.azurewebsites.net/callback";
            static String  location=  baseurl+"client_id="+client_id+"&scope=accounts%20offline_access%20payments:inbound%20payments:outbound&redirect_uri="+client_redirect_url+"&response_type=code";
    static String accountOptions = "What would you like to view? \r\n Balance or last 5 Transactions?";


    private final String welcomeMessage = "Welcome to aiia open banking chat bot \r\n Continue by linking account/s to the chat bot";

    private ConversationReferences conversationReferences;

    public Bot(EngageRecognizer luisRecognizer, ConversationReferences withReferences) {
        this.luisRecognizer = luisRecognizer;
        conversationReferences = withReferences;
    }

    @Override
    protected CompletableFuture<Void> onMessageActivity(TurnContext turnContext) {
        addConversationReference(turnContext.getActivity());

       // String text = turnContext.getActivity().getText().trim();

            return luisRecognizer.recognize(turnContext).thenCompose(luisResult -> {

              String returnValue = luisResult.getTopScoringIntent().intent;
               System.out.println("Return value from intent "+ returnValue);
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
                  System.out.println("Transactions was called");
                  String transactions = NetworkCall.getTransactions();
                  return turnContext
                          .sendActivity(MessageFactory.text(transactions))
                          .thenCompose(resourceResponse -> homeActivity(turnContext))
                          .thenApply(result -> null);
              }
              else{

                  return turnContext.sendActivity(MessageFactory.text("Text not recognized, please try again")).thenApply(sendResult -> null);
              }
            });
    }

    @Override
    protected CompletableFuture<Void> onMembersAdded(
        List<ChannelAccount> membersAdded,
        TurnContext turnContext
    ) {

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


    private static CompletableFuture<Void> welcomeCard(TurnContext turnContext){
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

}
