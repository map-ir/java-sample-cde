import com.fasterxml.jackson.annotation.JsonProperty;

public class Value {
    @JsonProperty("Text")
    String text;
    @JsonProperty("Title")
    String title;
    @JsonProperty("Address")
    String address;
    @JsonProperty("Province")
    String province;
    @JsonProperty("City")
    String city;
    @JsonProperty("Type")
    String type;
    @JsonProperty("FClass")
    String fclass;
    @JsonProperty("Coordinate")
    Coordinate coordinate;
}
