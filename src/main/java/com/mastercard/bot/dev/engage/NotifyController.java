// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.mastercard.bot.dev.engage;

import com.microsoft.bot.builder.MessageFactory;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.integration.Configuration;

import com.microsoft.bot.schema.ConversationReference;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;


@RestController
public class NotifyController {

    private final BotFrameworkHttpAdapter adapter;

    private ConversationReferences conversationReferences;
    private String appId;


    @Autowired
    public NotifyController(
        BotFrameworkHttpAdapter withAdapter,
        Configuration withConfiguration,
        ConversationReferences withReferences
    ) {
        adapter = withAdapter;
        conversationReferences = withReferences;
        appId = withConfiguration.getProperty("MicrosoftAppId");
    }



    @GetMapping("/")
    public String hello(){
        return "Application is up and running";
    }
    @PostMapping("/notify")
    public void eventHook(@RequestBody String message){
        System.out.println("Incoming message in POST method "+ message);
        //Incoming message in POST method {"customerId":"6003429825","eventType":"started","eventId":"1654682552760-373bdfa558c6a004a01e1501","payload":{},"webhookData":{}}

        JSONObject json = new JSONObject(message);

        String eventType = json.getString("eventType");
        if(eventType.equals("ping")){
            System.out.println("pinging");
        }
        //String eventId = json.getString("eventId");
        //String customerId = json.getString("customerId");

        if(eventType.equals("added")|| eventType.equals("done")){

            for(ConversationReference reference : conversationReferences.values()){
                adapter.continueConversation(
                        appId, reference, turnContext -> sendSuggestedActions(turnContext))
                        .thenApply(result -> null);
            }
        }



    }

    @GetMapping("/callback")
    public ResponseEntity<Object> processItems(@RequestParam(value = "code") String code) {
        try {
           NetworkCall.onBoardToken(code);
            for (ConversationReference reference : conversationReferences.values()) {
                adapter.continueConversation(
                        appId, reference, turnContext -> sendSuggestedActions(turnContext))
                                .thenApply(result -> null);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  null;
    }

    private static CompletableFuture<Void> sendSuggestedActions(TurnContext turnContext) {
        return turnContext.sendActivity(
                MessageFactory.text("Account linking successfully completed, what would you like to do?")
        ).thenApply(sendResult -> null);
    }



}
