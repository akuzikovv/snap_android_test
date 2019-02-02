package androidAutomation.pages;


import models.User;
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

    public void  getUserInfo() {
        restTemplate = new RestTemplate();
             restTemplate.getForObject(API_BASE, User.class);
    }


        public static void call_me() throws Exception {
            String url = "https://randomuser.me/api/";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
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
            System.out.println(response.toString());
            restTemplate = new RestTemplate();

        }
    }

