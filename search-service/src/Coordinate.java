import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinate {
    @JsonProperty("lat")
    Double lat;
    @JsonProperty("lon")
    Double lon;
}
