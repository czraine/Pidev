/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Random;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Nasr
 */
public class test {

    String body;
String code = "0";
    String Cbase = "http://localhost/demo/Success.php?code="+code;
    

    public String GetCode(String cg , String code) throws IOException, ParseException {
  String Slink = Cbase + code+"&";
  String amount = cg+"000";
URL url = new URL("https://developers.flouci.com/api/generate_payment");
HttpURLConnection con = (HttpURLConnection) url.openConnection();
con.setRequestProperty("Content-Type", "application/json");
con.setRequestMethod("POST");
con.setDoOutput(true);
        
String body = "{\"app_token\":\"b148099d-4dd1-4d3c-8d14-857246fd9d1f\",\"app_secret\":\"baf8335f-6c77-4fcd-bae0-2cd9c406fb6d\",\"accept_card\":\"true\",\"amount\":\""+amount+"\",\"success_link\":\"" + Slink + "\",\"fail_link\":\"http://localhost/demo/Fail.php\",\"session_timeout_secs\":\"7200\",\"developer_tracking_id\":\"0816ecca-58bc-4752-a024-8e734e3d8b64\"}";
byte[] outputBytes = body.getBytes("UTF-8");
OutputStream os = con.getOutputStream();
os.write(outputBytes);
           int responseCode = con.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            System.out.println(" we have information ");
          
BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
} 
in.close();
              JSONParser parser = new JSONParser();
        JSONObject obj = new JSONObject();
        JSONObject locationlist = new JSONObject();
        locationlist = (JSONObject) parser.parse(String.valueOf(response));

        String res = String.valueOf(locationlist);
        return res;
 }  
  
 

 

    }

    public String searchMe(String me, String findin) {
        String stopf = "success";

        int j = me.indexOf(stopf) - 3;
        int i = me.indexOf(findin);

        if (i > 0) {
            System.out.println(me.substring(i + findin.length() + 3, j));

            return me.substring(i, me.length());
        } else {
            System.out.println("string not found");
            return "string not found";
        }
    }
    
    public int RandomCodeGenerator() {

        Random random = new Random();
        int randomCode = random.nextInt(900000) + 100000;
        System.out.println("Random code: " + randomCode);
        return randomCode;
    }


}
