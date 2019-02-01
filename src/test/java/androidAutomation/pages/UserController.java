package androidAutomation.pages;


import com.google.gson.JsonObject;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserController {
    private static RestTemplate restTemplate;
    private final String API_BASE = "https://randomuser.me/api/";

    public UserController() {
        restTemplate = new RestTemplate();
    }

    public User getUserInfo(String email , String timezone, String description) {
        try {
            return restTemplate.getForObject(API_BASE + email + timezone + description, User.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }





        public static void call_me() throws Exception {
            String url = "https://randomuser.me/api/";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
//            con.setRequestProperty("User-Agent", "Mozilla/5.0");
//            int responseCode = con.getResponseCode();
//            System.out.println("\nSending 'GET' request to URL : " + url);
//            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print in String
            System.out.println(response.toString());
            //Read JSON response and print
            JsonObject myResponse = new JsonObject();
            response.toString();
            System.out.println("result after Reading JSON Response");
            System.out.println("email- "+myResponse.get("email"));
            System.out.println("timezone- "+myResponse.get("timezone"));
            System.out.println("description- "+myResponse.get("description"));
            System.out.println("name- "+myResponse.get("name"));

        }
    }

