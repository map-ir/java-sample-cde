import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Request {

//    main request object
    JSONObject requestData;

    public Request(String text, Double center_lat, Double center_lon) {
        requestData = new JSONObject();
        requestData.put("text", text);
        JSONObject geom = new JSONObject();
        JSONArray geomCoordinates = new JSONArray();
        geomCoordinates.add(0, center_lon);
        geomCoordinates.add(1, center_lat);
        geom.put("type", "Point");
        geom.put("coordinates", geomCoordinates);
        requestData.put("location", geom);
    }

    public String toString() {
        return requestData.toString();
    }
}
