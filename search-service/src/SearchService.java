import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONPropertyIgnore;

import java.util.List;

public class SearchService {
    @JsonProperty("odata.count")
    Integer count;
    @JsonProperty("value")
    Value[] value;

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
}
