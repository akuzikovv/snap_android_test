package androidAutomation.pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonParse {
    private static JSONParser parser = new JSONParser();
    private static URL urlObject;
    private static StringBuffer response;


    @Test
    public void parseJson() throws IOException, ParseException {
        String url = "https://randomuser.me/api/";
        urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
        JSONArray resultsObject = (JSONArray) parser.parse(jsonObject.get("results").toString());
        JSONObject userDetailsObject = (JSONObject) parser.parse(resultsObject.get(0).toString());
        JSONObject locationObject = (JSONObject) parser.parse(userDetailsObject.get("location").toString());
        JSONObject timezoneObject = (JSONObject) parser.parse(locationObject.get("timezone").toString());
        String email = userDetailsObject.get("email").toString();
        String description = timezoneObject.get("description").toString();
        System.out.println("User email: " + email + "\n" + "Description: " + description);

    }

//    @Test
//    public void parseJson2() throws IOException, ParseException {
//        String url = "https://randomuser.me/api/";
//        urlObject = new URL(url);
//        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
//        connection.setRequestMethod("GET");
//        int responseCode = connection.getResponseCode();//get Response Code
//        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        String inputLine;
//        response = new StringBuffer();
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//        JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
//        JSONArray resultsObject = (JSONArray) parser.parse(jsonObject.get("results").toString());
//        JSONObject userDetailsObject = (JSONObject) parser.parse(resultsObject.get(0).toString());
//        JSONObject locationObject = (JSONObject) parser.parse(userDetailsObject.get("location").toString());
//        JSONObject timezonObject = (JSONObject) parser.parse(locationObject.get("timezone").toString());
//
//        String name = userDetailsObject.get("name").toString();
//        String email = userDetailsObject.get("email").toString();
//        String timezone = locationObject.getOrDefault("timezone", 0).toString();
//        String description = timezonObject.get("description").toString();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);
//        System.out.println("User name: " + name + "\n" + "User email: " + email + "\n" + "Description: " + description);
//
//    }


}
