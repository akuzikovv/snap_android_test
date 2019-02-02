package androidAutomation.pages;

import models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Run {
    private UserController userController;
    private final String API_BASE = "https://randomuser.me/api/";

    @Before
    public void setUp() {
        userController = new UserController();
    }

//    @Test
//    public void testUserInfoResponse() {
//        User remoteUser = userController.getUserInfo();
//        System.out.println(remoteUser);
//
//    }

    @Test
    public void parseJson() throws IOException, ParseException {
        String url = "https://randomuser.me/api/";
        URL object1 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) object1.openConnection();
        connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        Object obj2 = new JSONParser().parse(response.toString());
        JSONObject jsonObject = (JSONObject) obj2;
        jsonObject.getOrDefault("results",0);

        String results =  jsonObject.get("results").toString();

        Object obj3 = new JSONParser().parse(results);
        JSONArray jsonObject2 = (JSONArray) obj3;
        jsonObject2.get(0);
        Object obj4 = new JSONParser().parse(jsonObject2.get(0).toString());
        JSONObject jsonObject3 = (JSONObject) obj4;
        String results3 =  jsonObject3.get("name").toString();

        System.out.println(results3);
    }

    @Test
    public void  getUserInfo() {
       RestTemplate  restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(API_BASE, User.class);
        System.out.println(user);

        // Считываем json
//        Object obj = new JsonParser().parse(user.toString()); // Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));
// Кастим obj в JSONObject
//        JSONPObject jo = (JSONPObject) obj;
// Достаём firstName and lastName
//        String firstName = (String) jo.getValue("email");
//        String lastName = (String) jo.get("lastName");
//        System.out.println("fio: " + firstName + " " + lastName);
// Достаем массив номеров
//        JSONArray phoneNumbersArr = (JSONArray) jo.get("phoneNumbers");
//        Iterator phonesItr = phoneNumbersArr.iterator();
//        System.out.println("phoneNumbers:");
// Выводим в цикле данные массива
//        while (phonesItr.hasNext()) {
//            JSONObject test = (JSONObject) phonesItr.next();
//            System.out.println("- type: " + test.get("type") + ", phone: " + test.get("number"));
//        }



    }

    @Test
    public void testgetall() throws Exception {
        try {
            userController.call_me();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
