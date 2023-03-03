package roadrevel.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class CurrencyConverter {

    public Double converti(String Cfrom, String Cto, Double am) throws MalformedURLException, IOException, ParseException {
        /*URL url = new URL("https://api.apilayer.com/exchangerates_data/convert?to=TND&from=EUR&amount=" + am);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setInstanceFollowRedirects(false);
        conn.setRequestProperty("apikey", "VQZ62qtrLk5jSBOvy6u2wx4eU0ZL4412");
        conn.connect();*/
        URLConnection conn = new URL("https://api.apilayer.com/exchangerates_data/convert?to=" + Cto + "&from=" + Cfrom + "&amount=" + am).openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        conn.setRequestProperty("apikey", "VQZ62qtrLk5jSBOvy6u2wx4eU0ZL4412");
        conn.connect();

        StringBuilder informationString = new StringBuilder();
        Scanner myscanner = new Scanner(conn.getInputStream());
        JSONObject obj = new JSONObject();
        String res;
        while (myscanner.hasNext()) {
            res = myscanner.nextLine();
            System.out.println(" toString res baaa3  " + res);

            informationString.append(res);
        }

        JSONParser parser = new JSONParser();
        myscanner.close();
        JSONObject locationlist = new JSONObject();
        locationlist = (JSONObject) parser.parse(String.valueOf(informationString));
        System.out.println(" toString res suuuuuuuuuui  " + locationlist);
        Double resa = (Double) locationlist.get("result");

        return resa;
        /*
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            System.out.println(" we have information ");
            StringBuilder informationString = new StringBuilder();
            Scanner myscanner = new Scanner(url.openStream());
            JSONParser parser = new JSONParser();
            JSONObject obj = new JSONObject();
            String res;
            while (myscanner.hasNext()) {
                res = myscanner.nextLine();
                System.out.println(" toString res baaa3  " + res);
                res = myscanner.nextLine();
            }
            myscanner.close();
        }*/
    }

    public JSONObject Symbols() throws MalformedURLException, IOException, ParseException {
        URLConnection conn = new URL("https://api.apilayer.com/exchangerates_data/symbols").openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        conn.setRequestProperty("apikey", "VQZ62qtrLk5jSBOvy6u2wx4eU0ZL4412");
        conn.connect();
        StringBuilder informationString = new StringBuilder();
        Scanner myscanner = new Scanner(conn.getInputStream());
        JSONObject obj = new JSONObject();
        String res;
        while (myscanner.hasNext()) {
            res = myscanner.nextLine();
            System.out.println(" toString res baaa3  " + res);

            informationString.append(res);
        }

        JSONParser parser = new JSONParser();
        myscanner.close();
        JSONObject locationlist = new JSONObject();
        locationlist = (JSONObject) parser.parse(String.valueOf(informationString));
        System.out.println(" toString res suuuuuuuuuui  " + locationlist);
        Double resa = (Double) locationlist.get("result");

        try {
            locationlist = (JSONObject) parser.parse(String.valueOf(informationString));

            return locationlist;

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());

        }
        return null;

    }

    public List<String> SymbolList() throws IOException, MalformedURLException, ParseException {
        try {
            CurrencyConverter pm = new CurrencyConverter();
            List<String> list = new ArrayList<String>();

            JSONObject sym = pm.Symbols();
            System.out.println(" talking about weather in genral  " + sym);
            JSONObject tempeture = (JSONObject) sym.get("symbols");
            System.out.println(tempeture);
            Set<String> Csymbols = new HashSet<String>();
            Csymbols = tempeture.keySet();
            Iterator itr = Csymbols.iterator();
            while (itr.hasNext()) {
                list.add((String) itr.next());
                System.out.println(" talking about tempture  " + itr.next());
            }
            return list;
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
