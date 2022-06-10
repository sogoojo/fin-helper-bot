package com.mastercard.bot.dev.engage;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigInteger;

public class QuickTest {

     public static void main(String[] args) throws Exception{
       // transactions();
       //String response =  FinicityNetwork.getAccounts();
       // FinicityNetwork.getAccessToken();

         String url = FinicityNetwork.generateUrl();
         System.out.println("Generated url - "+ url);

     }

     public static void transactions(){
         String json = "{\n" +
                 "    \"found\": 19,\n" +
                 "    \"displaying\": 19,\n" +
                 "    \"moreAvailable\": \"false\",\n" +
                 "    \"fromDate\": \"1000000000\",\n" +
                 "    \"toDate\": \"1607450357\",\n" +
                 "    \"sort\": \"desc\",\n" +
                 "    \"transactions\": [\n" +
                 "        {\n" +
                 "            \"id\": 7693729879,\n" +
                 "            \"amount\": 12.05,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan credit 340\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1607169600,\n" +
                 "            \"transactionDate\": 1607169600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Income\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN CREDIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729858,\n" +
                 "            \"amount\": -11.25,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan debit 330\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1606305600,\n" +
                 "            \"transactionDate\": 1606305600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Shopping\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN DEBIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729871,\n" +
                 "            \"amount\": 11.15,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan credit 320\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1605441600,\n" +
                 "            \"transactionDate\": 1605441600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Income\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN CREDIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729848,\n" +
                 "            \"amount\": -11.05,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan debit 310\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1604577600,\n" +
                 "            \"transactionDate\": 1604577600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Shopping\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN DEBIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729883,\n" +
                 "            \"amount\": 10.26,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan credit 300\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1603713600,\n" +
                 "            \"transactionDate\": 1603713600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Income\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN CREDIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729904,\n" +
                 "            \"amount\": -10.16,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan debit 290\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1602849600,\n" +
                 "            \"transactionDate\": 1602849600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Shopping\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN DEBIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729909,\n" +
                 "            \"amount\": 10.06,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan credit 280\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1601985600,\n" +
                 "            \"transactionDate\": 1601985600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Income\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN CREDIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729853,\n" +
                 "            \"amount\": -9.26,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan debit 270\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1601121600,\n" +
                 "            \"transactionDate\": 1601121600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Shopping\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN DEBIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729859,\n" +
                 "            \"amount\": 9.16,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan credit 260\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1600257600,\n" +
                 "            \"transactionDate\": 1600257600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Income\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN CREDIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729850,\n" +
                 "            \"amount\": -9.06,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan debit 250\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1599393600,\n" +
                 "            \"transactionDate\": 1599393600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Shopping\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN DEBIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729872,\n" +
                 "            \"amount\": 8.27,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan credit 240\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1598529600,\n" +
                 "            \"transactionDate\": 1598529600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Income\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN CREDIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729902,\n" +
                 "            \"amount\": -8.17,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan debit 230\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1597665600,\n" +
                 "            \"transactionDate\": 1597665600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Shopping\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN DEBIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729869,\n" +
                 "            \"amount\": 8.07,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan credit 220\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1596801600,\n" +
                 "            \"transactionDate\": 1596801600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Income\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN CREDIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729846,\n" +
                 "            \"amount\": -7.28,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan debit 210\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1595937600,\n" +
                 "            \"transactionDate\": 1595937600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Shopping\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN DEBIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729896,\n" +
                 "            \"amount\": 7.18,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan credit 200\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1595073600,\n" +
                 "            \"transactionDate\": 1595073600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Income\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN CREDIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729889,\n" +
                 "            \"amount\": -7.08,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan debit 190\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1594209600,\n" +
                 "            \"transactionDate\": 1594209600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Shopping\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN DEBIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729903,\n" +
                 "            \"amount\": 6.28,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan credit 180\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1593345600,\n" +
                 "            \"transactionDate\": 1593345600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Income\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN CREDIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729908,\n" +
                 "            \"amount\": -6.18,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan debit 170\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1592481600,\n" +
                 "            \"transactionDate\": 1592481600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Shopping\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN DEBIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 7693729884,\n" +
                 "            \"amount\": 6.08,\n" +
                 "            \"accountId\": 6005433847,\n" +
                 "            \"customerId\": 6003496880,\n" +
                 "            \"status\": \"active\",\n" +
                 "            \"description\": \"Autoloan credit 160\",\n" +
                 "            \"memo\": \"walmart\",\n" +
                 "            \"interestAmount\": 78.00,\n" +
                 "            \"principalAmount\": 45690.00,\n" +
                 "            \"escrowAmount\": 459.00,\n" +
                 "            \"postedDate\": 1591617600,\n" +
                 "            \"transactionDate\": 1591617600,\n" +
                 "            \"createdDate\": 1654693865,\n" +
                 "            \"categorization\": {\n" +
                 "                \"normalizedPayeeName\": \"Walmart\",\n" +
                 "                \"category\": \"Income\",\n" +
                 "                \"bestRepresentation\": \"AUTOLOAN CREDIT WALMART\",\n" +
                 "                \"country\": \"USA\"\n" +
                 "            }\n" +
                 "        }\n" +
                 "    ]\n" +
                 "}";


         JSONArray jsonArray = new JSONObject(json).getJSONArray("transactions");
         System.out.println(jsonArray.length());
         jsonArray.iterator().forEachRemaining(jsonItems -> {
             System.out.println(jsonItems);

             JSONObject jsonObject = new JSONObject(jsonItems.toString());
             Float amount = jsonObject.getFloat("amount");
             String description = jsonObject.getString("description");
             JSONObject paymentItem = jsonObject.getJSONObject("categorization");  // object getter
             String category = paymentItem.getString("category");
             BigInteger transactionDate = jsonObject.getBigInteger("transactionDate");

         });

     }

     public static void miniStatement() {

        String jsonString = "{\n" +
                "    \"accounts\": [\n" +
                "        {\n" +
                "            \"id\": \"6005433847\",\n" +
                "            \"number\": \"8000008888\",\n" +
                "            \"accountNumberDisplay\": \"8888\",\n" +
                "            \"name\": \"Auto Loan\",\n" +
                "            \"balance\": -608.19,\n" +
                "            \"type\": \"loan\",\n" +
                "            \"status\": \"active\",\n" +
                "            \"customerId\": \"6003496880\",\n" +
                "            \"institutionId\": \"101732\",\n" +
                "            \"balanceDate\": 1654687182,\n" +
                "            \"createdDate\": 1654687182,\n" +
                "            \"lastUpdatedDate\": 1654687213,\n" +
                "            \"currency\": \"USD\",\n" +
                "            \"institutionLoginId\": 6002670115,\n" +
                "            \"displayPosition\": 1,\n" +
                "            \"financialinstitutionAccountStatus\": \"OPEN\",\n" +
                "            \"accountNickname\": \"Auto Loan\",\n" +
                "            \"marketSegment\": \"personal\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"6005433848\",\n" +
                "            \"number\": \"2000005555\",\n" +
                "            \"accountNumberDisplay\": \"5555\",\n" +
                "            \"name\": \"Home Mortgage\",\n" +
                "            \"balance\": -608.19,\n" +
                "            \"type\": \"mortgage\",\n" +
                "            \"status\": \"active\",\n" +
                "            \"customerId\": \"6003496880\",\n" +
                "            \"institutionId\": \"101732\",\n" +
                "            \"balanceDate\": 1654687182,\n" +
                "            \"createdDate\": 1654687182,\n" +
                "            \"lastUpdatedDate\": 1654687213,\n" +
                "            \"currency\": \"USD\",\n" +
                "            \"institutionLoginId\": 6002670115,\n" +
                "            \"displayPosition\": 7,\n" +
                "            \"financialinstitutionAccountStatus\": \"OPEN\",\n" +
                "            \"accountNickname\": \"Home Mortgage\",\n" +
                "            \"marketSegment\": \"personal\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"6005433849\",\n" +
                "            \"number\": \"2000004444\",\n" +
                "            \"accountNumberDisplay\": \"4444\",\n" +
                "            \"name\": \"Roth IRA\",\n" +
                "            \"balance\": 608.19,\n" +
                "            \"type\": \"investment\",\n" +
                "            \"status\": \"active\",\n" +
                "            \"customerId\": \"6003496880\",\n" +
                "            \"institutionId\": \"101732\",\n" +
                "            \"balanceDate\": 1654687182,\n" +
                "            \"createdDate\": 1654687182,\n" +
                "            \"lastUpdatedDate\": 1654687213,\n" +
                "            \"currency\": \"USD\",\n" +
                "            \"institutionLoginId\": 6002670115,\n" +
                "            \"detail\": {},\n" +
                "            \"displayPosition\": 3,\n" +
                "            \"financialinstitutionAccountStatus\": \"OPEN\",\n" +
                "            \"accountNickname\": \"Roth IRA\",\n" +
                "            \"marketSegment\": \"personal\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"6005433850\",\n" +
                "            \"number\": \"0000000000\",\n" +
                "            \"accountNumberDisplay\": \"0000\",\n" +
                "            \"name\": \"Brokerage\",\n" +
                "            \"balance\": 608.19,\n" +
                "            \"type\": \"investment\",\n" +
                "            \"status\": \"active\",\n" +
                "            \"customerId\": \"6003496880\",\n" +
                "            \"institutionId\": \"101732\",\n" +
                "            \"balanceDate\": 1654687182,\n" +
                "            \"createdDate\": 1654687182,\n" +
                "            \"lastUpdatedDate\": 1654687213,\n" +
                "            \"currency\": \"USD\",\n" +
                "            \"institutionLoginId\": 6002670115,\n" +
                "            \"detail\": {},\n" +
                "            \"displayPosition\": 8,\n" +
                "            \"financialinstitutionAccountStatus\": \"OPEN\",\n" +
                "            \"accountNickname\": \"Brokerage\",\n" +
                "            \"marketSegment\": \"personal\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"6005433851\",\n" +
                "            \"number\": \"8000006666\",\n" +
                "            \"accountNumberDisplay\": \"6666\",\n" +
                "            \"name\": \"Line of Credit\",\n" +
                "            \"balance\": -608.19,\n" +
                "            \"type\": \"lineOfCredit\",\n" +
                "            \"status\": \"active\",\n" +
                "            \"customerId\": \"6003496880\",\n" +
                "            \"institutionId\": \"101732\",\n" +
                "            \"balanceDate\": 1654687182,\n" +
                "            \"createdDate\": 1654687182,\n" +
                "            \"lastUpdatedDate\": 1654687213,\n" +
                "            \"currency\": \"USD\",\n" +
                "            \"institutionLoginId\": 6002670115,\n" +
                "            \"displayPosition\": 4,\n" +
                "            \"financialinstitutionAccountStatus\": \"OPEN\",\n" +
                "            \"accountNickname\": \"Line of Credit\",\n" +
                "            \"marketSegment\": \"personal\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"6005433852\",\n" +
                "            \"number\": \"4100007777\",\n" +
                "            \"accountNumberDisplay\": \"7777\",\n" +
                "            \"name\": \"Credit Card\",\n" +
                "            \"balance\": 608.19,\n" +
                "            \"type\": \"creditCard\",\n" +
                "            \"status\": \"active\",\n" +
                "            \"customerId\": \"6003496880\",\n" +
                "            \"institutionId\": \"101732\",\n" +
                "            \"balanceDate\": 1654687182,\n" +
                "            \"createdDate\": 1654687182,\n" +
                "            \"lastUpdatedDate\": 1654687213,\n" +
                "            \"currency\": \"USD\",\n" +
                "            \"institutionLoginId\": 6002670115,\n" +
                "            \"displayPosition\": 2,\n" +
                "            \"financialinstitutionAccountStatus\": \"OPEN\",\n" +
                "            \"accountNickname\": \"Credit Card\",\n" +
                "            \"marketSegment\": \"personal\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"6005433853\",\n" +
                "            \"number\": \"1000002222\",\n" +
                "            \"accountNumberDisplay\": \"2222\",\n" +
                "            \"name\": \"Savings\",\n" +
                "            \"balance\": 608.19,\n" +
                "            \"type\": \"savings\",\n" +
                "            \"status\": \"active\",\n" +
                "            \"customerId\": \"6003496880\",\n" +
                "            \"institutionId\": \"101732\",\n" +
                "            \"balanceDate\": 1654687182,\n" +
                "            \"createdDate\": 1654687182,\n" +
                "            \"lastUpdatedDate\": 1654687213,\n" +
                "            \"currency\": \"USD\",\n" +
                "            \"institutionLoginId\": 6002670115,\n" +
                "            \"displayPosition\": 6,\n" +
                "            \"financialinstitutionAccountStatus\": \"OPEN\",\n" +
                "            \"accountNickname\": \"Savings\",\n" +
                "            \"marketSegment\": \"personal\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"6005433854\",\n" +
                "            \"number\": \"1000001111\",\n" +
                "            \"accountNumberDisplay\": \"1111\",\n" +
                "            \"name\": \"Checking\",\n" +
                "            \"balance\": 608.19,\n" +
                "            \"type\": \"checking\",\n" +
                "            \"status\": \"active\",\n" +
                "            \"customerId\": \"6003496880\",\n" +
                "            \"institutionId\": \"101732\",\n" +
                "            \"balanceDate\": 1654687182,\n" +
                "            \"createdDate\": 1654687182,\n" +
                "            \"lastUpdatedDate\": 1654687213,\n" +
                "            \"currency\": \"USD\",\n" +
                "            \"institutionLoginId\": 6002670115,\n" +
                "            \"displayPosition\": 5,\n" +
                "            \"financialinstitutionAccountStatus\": \"OPEN\",\n" +
                "            \"accountNickname\": \"Checking\",\n" +
                "            \"marketSegment\": \"personal\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

         JSONArray jsonArray = new JSONObject(jsonString).getJSONArray("accounts");

          jsonArray.iterator().forEachRemaining(item -> {
             JSONObject jsonObject = new JSONObject(item.toString());
            Float accountBalance =  jsonObject.getFloat("balance");
            String accountType = jsonObject.getString("accountNickname");
            String currency  = jsonObject.getString("currency");
            String accountNumber = jsonObject.getString("accountNumberDisplay");
            String status = jsonObject.getString("status");

           System.out.println("Account Balance  "+ accountBalance+ "\n");
            System.out.println("Account Type "+ accountType + "\n");
            System.out.println("currency "+ currency + "\n");
            System.out.println("account number "+ accountNumber +"\n");
            System.out.println("Status "+ status + "\n");

          });



    }
}
