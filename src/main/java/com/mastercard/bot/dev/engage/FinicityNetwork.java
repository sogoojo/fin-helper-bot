package com.mastercard.bot.dev.engage;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;

public class FinicityNetwork {

    final static String customerId = "6003496880";
    final static String finicityAppKey = "f36c6e62eb6e932d09455749a4baf091";
    final static String partnerId ="2445583971273";
    final static  String webHook = "https://cf29-173-208-98-232.ngrok.io/notify";
    final static String consumerId = "0bf46322c167b562e6cbed9d40e19a4c";

     static String token ="";
    public static String getAccessToken(){
        try{
            String requestJson = "{\n" +
                    "    \"partnerId\": \"2445583971273\",\n" +
                    "    \"partnerSecret\": \"DZnDTKIRF1UKL3hK0ZSR\"\n" +
                    "}";
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(MediaType.parse("application/json"),  requestJson);
            Request request = new Request.Builder()
                    .url("https://api.finicity.com/aggregation/v2/partners/authentication")
                    .addHeader("Accept", "application/json")
                    .addHeader("Finicity-App-Key",finicityAppKey)
                    .post(body)
                    .build();
            Call call = client.newCall(request);
            Response response = call.execute();

            int responseCode = response.code();
            if (responseCode != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + responseCode);
            }
            String returnValue = response.body().string();
            response.close();
           return new JSONObject(returnValue).getString("token");

        }catch (Exception ex){
            ex.printStackTrace();
        }
      return "Invalid Response";
    }

    public static String generateUrl() throws IOException {
        try{
        String  accessToken =  getAccessToken();
        token = accessToken;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("partnerId", partnerId);
        jsonObject.put("customerId", customerId);
        jsonObject.put("language", "en");
        jsonObject.put("consumerId", consumerId);
        jsonObject.put("webhook", webHook);
        jsonObject.put("webhookContentType", "application/json");
        jsonObject.put("singleUseUrl", false);
        jsonObject.put("fromDate",1607450357);

            RequestBody body = RequestBody.create(MediaType.parse("application/json"),  jsonObject.toString());

            OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.finicity.com/connect/v2/generate")
                .addHeader("Finicity-App-Token", accessToken)
                .addHeader("Finicity-App-Key", "f36c6e62eb6e932d09455749a4baf091")
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String retVal = response.body().string();
        int responseCode = response.code();
            if (responseCode != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + responseCode);
            }
            response.close();
            return retVal;
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return "invalid response";
    }

    public static String getTransactions(){
        try{
            String accountId ="6005433847";
            String url = "https://api.finicity.com/aggregation/v3/customers/"+customerId+"/accounts/"+accountId+"/transactions?fromDate=1000000000&toDate=1607450357&includePending=true";
            System.out.println("url print "+ url);
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Accept", "application/json")
                    .addHeader("Finicity-App-Token", token)
                    .addHeader("Finicity-App-Key", finicityAppKey)
                    .build();

            Call call = client.newCall(request);
            Response response = call.execute();
            String retVal = response.body().string();
            int responseCode = response.code();
            if(responseCode != 200){
                throw new RuntimeException("Failed : HTTP error code : " + responseCode);
            }
            response.close();
            return parseTransactions(retVal);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "invalid response";
    }

/*    JSONArray jsonArray = new JSONObject(json).getJSONArray("transactions");
         System.out.println(jsonArray.length());
         jsonArray.iterator().forEachRemaining(jsonItems -> {
        System.out.println(jsonItems);

        JSONObject jsonObject = new JSONObject(jsonItems.toString());
         JSONObject paymentItem = jsonObject.getJSONObject("categorization");  // object getter
        String category = paymentItem.getString("category");

    });*/


    private static String parseTransactions(String json){
        StringBuilder stb = new StringBuilder();
        stb.append("-- Last Transactions --");
        stb.append("\r\n");
        stb.append("------");
        stb.append("\r\n");
        try{
            JSONArray jsonArray = new JSONObject(json).getJSONArray("transactions");
           jsonArray.iterator().forEachRemaining(transaction -> {
               JSONObject transactionObject = new JSONObject(transaction.toString());
               System.out.println(transaction);
               stb.append(transactionObject.getBigInteger("transactionDate"));
               stb.append("\r\n");
               stb.append("Amount: ");
               stb.append(transactionObject.getFloat("amount"));
               stb.append("\r\n");
               JSONObject paymentItem = transactionObject.getJSONObject("categorization");
               stb.append("Balance: ");
               stb.append(paymentItem.getString("category"));
               stb.append("\r\n");
               stb.append("Description: ");
               stb.append(transactionObject.getString("description"));
               stb.append("\r\n");
               stb.append("------");
               stb.append("\r\n");
           });

        } catch (Exception ex){
            ex.printStackTrace();
        }
        return stb.toString();
    }
    public static String getAccounts() {
        try {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.finicity.com/aggregation/v1/customers/"+customerId+"/accounts")
                    .addHeader("Accept", "application/json")
                    .addHeader("Finicity-App-Key", finicityAppKey)
                    .addHeader("Finicity-App-Token", token)
                     .build();

            Call call = client.newCall(request);
            Response response = call.execute();
            String retVal = response.body().string();
            int responseCode = response.code();
            if (responseCode != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + responseCode);
            }
            response.close();
            return parseAccountData(retVal);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "invalid response";
    }

/*    JSONArray jsonArray = new JSONObject(jsonString).getJSONArray("accounts");

          jsonArray.iterator().forEachRemaining(item -> {
        JSONObject jsonObject = new JSONObject(item.toString());
        Float accountBalance =  jsonObject.getFloat("balance");
        String accountType = jsonObject.getString("accountNickname");
        String currency  = jsonObject.getString("currency");
         String status = jsonObject.getString("status");



    });*/

    private static String parseAccountData(String json){
        StringBuilder stb = new StringBuilder();
        try{
            JSONArray jsonArray = new JSONObject(json).getJSONArray("accounts");
            jsonArray.iterator().forEachRemaining(account -> {
                JSONObject jsonObject = new JSONObject(account.toString());
                stb.append("Account Number - "+ jsonObject.getString("accountNumberDisplay"));
                stb.append("\r\n");
                stb.append("Account type  - " + jsonObject.getString("accountNickname") + "\r\n Currency - " +  jsonObject.getString("currency"));
                stb.append("\r\n");
                stb.append("Balance - " + jsonObject.getFloat("balance"));
                stb.append("\r\n");
                stb.append("------");
                stb.append("\r\n");
            });
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return stb.toString();
    }
}
