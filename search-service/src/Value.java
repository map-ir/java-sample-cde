import com.fasterxml.jackson.annotation.JsonProperty;

public class Value {
    @JsonProperty("Text")
    String Text;
    @JsonProperty("Title")
    String Title;
    @JsonProperty("Address")
    String Address;
    @JsonProperty("Province")
    String Province;
    @JsonProperty("City")
    String City;
    @JsonProperty("Type")
    String Type;
    @JsonProperty("FClass")
    String FClass;
    @JsonProperty("Coordinate")
    Coordinate Coordinate;
}
