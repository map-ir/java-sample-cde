import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;

public class Main {

    public static void main(String[] args) {

        String targetUrl = "https://map.ir/search";
        URL url;
        try {
            url = new URL(targetUrl);

            StringBuilder response = new StringBuilder();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);


            Request request = new Request("text", 31.556, 56.45);
            String requestData = request.toString();

            try(OutputStream os = conn.getOutputStream()) {
                byte[] input = requestData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),
                    StandardCharsets.UTF_8));
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            rd.close();
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject)parser.parse(response.toString());
            ObjectMapper mapper = new ObjectMapper();
            SearchService searchService = mapper.readValue(response.toString(), SearchService.class);
            System.out.println(obj);
            System.out.println(searchService.count);
            System.out.println(searchService.value[0].Text);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
