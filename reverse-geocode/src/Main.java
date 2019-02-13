import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;

public class Main {

    public static void main(String[] args) {

        String targetUrl = "https://map.ir/reverse?lat=35.53448433732464&lon=51.46575313638093";
        URL url;
        try {
            url = new URL(targetUrl);

            StringBuilder response = new StringBuilder();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),
                    StandardCharsets.UTF_8));
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            rd.close();
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject)parser.parse(response.toString());
            System.out.println(obj);
            System.out.println(obj.get("postal_address"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
