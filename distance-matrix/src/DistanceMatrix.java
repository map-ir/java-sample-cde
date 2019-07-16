import java.util.List;

public class DistanceMatrix {
    List<Distance> distances;
    List<Duration> duration;
    List<Meta> origins;
    List<Meta> destinations;

    public class Distance {
        String origin_index;
        String destination_index;
        Double distance;
    }

    public class Duration {
        String origin_index;
        String destination_index;
        Double duration;
    }

    public class Meta {
        String name;
        String province_name;
        String county_name;
        String district_title;
        String ruraldistrict_title;
        String suburb_title;
        String neighbourhood_title;
    }
}
