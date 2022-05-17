package com.mastercard.bot.dev.engage;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.util.Date;

public class MainTest {
static String  token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIzNWI2OGQ4Zi04YjY4LTRiMjEtOTcwNy05MTFkMGYyOGUyYjUiLCJjbGllbnRJZCI6ImFpaWFlbmdhZ2UtNGY1ZWU3MTUtNzk2MS00MDcwLWI4ZmMtNjRkYjVlMmQxYWVmIiwicm9sZSI6IkNsaWVudFVzZXIiLCJzZXNzaW9uSWQiOiJiYmE5YTk5ZS1kNjI5LTRkZTEtYWZkNy1mODIwYWM2ZWRlZjAiLCJzY29wZXMiOiJBY2NvdW50cyBPZmZsaW5lQWNjZXNzIEluYm91bmRQYXltZW50cyBPdXRib3VuZFBheW1lbnRzIiwibmJmIjoxNjUyMTk5OTQ4LCJleHAiOjE2NTIyMDM1NDgsImlhdCI6MTY1MjE5OTk0OH0.nBKUHo9CE6WURpfAMz3zja8jlEadE5o7RUD65KoSmZo";

    private static final String BASE_URL = "https://api-sandbox.aiia.eu/v1/accounts/MzViNjhkOGYtOGI2OC00YjIxLTk3MDctOTExZDBmMjhlMmI1fERLX1Rlc3RCYW5rfFJPS0huNkdXVEVzMHdCeng1d01zTEhiWVU2UXpXNHEyNEh2OVJuRmVsUUkuOWEzZDRhMDRjMmVm/transactions?pageSize=5";


     public static void main(String[] args) {




    }

    private void parseBalanceResponse()
    {
        String response = "{\"accounts\":[{\"accountProvider\":{\"id\":\"DK_TestBank\",\"name\":\"Test Bank\"},\"available\":{\"currency\":\"DKK\",\"value\":4843.34},\"availableBalance\":4843.34,\"booked\":{\"currency\":\"DKK\",\"value\":4843.34},\"bookedBalance\":4843.34,\"currency\":\"DKK\",\"features\":{\"paymentFrom\":true,\"paymentTo\":true,\"psdPaymentAccount\":true,\"queryable\":true},\"id\":\"MzViNjhkOGYtOGI2OC00YjIxLTk3MDctOTExZDBmMjhlMmI1fERLX1Rlc3RCYW5rfFJPS0huNkdXVEVzMHdCeng1d01zTEhiWVU2UXpXNHEyNEh2OVJuRmVsUUkuOWEzZDRhMDRjMmVm\",\"isOrphaned\":false,\"lastSynchronized\":\"2022-05-12T10:01:57.176011500Z\",\"name\":\"Checking Account\",\"number\":{\"bban\":\"0001-204386946\",\"bbanParsed\":{\"accountNumber\":\"204386946\",\"bankCode\":\"0001\"},\"bbanType\":\"DK\",\"card\":null,\"iban\":\"DK9200001204386946\"},\"owner\":\"Christian Thomsen\",\"syncStatus\":\"Finished\",\"type\":\"Consumption\",\"verifiedForPayments\":false,\"groupId\":null,\"groupName\":null},{\"accountProvider\":{\"id\":\"DK_TestBank\",\"name\":\"Test Bank\"},\"available\":{\"currency\":\"DKK\",\"value\":614.03},\"availableBalance\":614.03,\"booked\":{\"currency\":\"DKK\",\"value\":614.03},\"bookedBalance\":614.03,\"currency\":\"DKK\",\"features\":{\"paymentFrom\":true,\"paymentTo\":true,\"psdPaymentAccount\":true,\"queryable\":true},\"id\":\"MzViNjhkOGYtOGI2OC00YjIxLTk3MDctOTExZDBmMjhlMmI1fERLX1Rlc3RCYW5rfEJmRlpMRDZMY3EtU0FIYTdVbFI3NVlwbzFFNU93QXpkVjQ4bWs1Mkt3QWMuYjI3ZGJiMWY0NzJk\",\"isOrphaned\":false,\"lastSynchronized\":\"2022-05-12T10:01:58.240118100Z\",\"name\":\"Direct Debit\",\"number\":{\"bban\":\"0001-245787654\",\"bbanParsed\":{\"accountNumber\":\"245787654\",\"bankCode\":\"0001\"},\"bbanType\":\"DK\",\"card\":null,\"iban\":\"DK5200001245787654\"},\"owner\":\"Christian Thomsen\",\"syncStatus\":\"Finished\",\"type\":\"Consumption\",\"verifiedForPayments\":false,\"groupId\":null,\"groupName\":null}]}\n";


    }

}
