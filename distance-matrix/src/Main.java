import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        String targetUrl = "https://map.ir/distancematrix";
        URL url;
        String queryParam = "?";
        try {
            Points origins = new Points();
            origins.addPoint(origins.new Point("origin_1", (double) 35.712580, (double) 51.368895));
            origins.addPoint(origins.new Point("origin_2", (double) 35.713580, (double) 51.368895));
            queryParam += "origins=" + origins.toString();
            Points destinations = new Points();
            destinations.addPoint(destinations.new Point("destination_1", (double) 35.714580, (double) 51.368895));
            destinations.addPoint(destinations.new Point("destination_2", (double) 35.715580, (double) 51.368895));
            queryParam += "&destinations=" + destinations.toString();

            targetUrl = targetUrl + queryParam;
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

            System.out.println(response);
            System.out.println(obj.get("duration"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
