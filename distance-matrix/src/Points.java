import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Points {

    public List<Point> points;

    public Points() {
        points = new ArrayList<Point>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public String toString() {
        String queryString = "";
        StringJoiner joiner = new StringJoiner("|");
        for (Point point: points) {
            String pointQuery = "";
            pointQuery = point.id + "," + point.lat + "," + point.lon;
            joiner.add(pointQuery);
        }

        return joiner.toString();
    }

    public  class Point {
        String id;
        Double lat;
        Double lon;

        public Point(String id, Double lat, Double lon) {
            this.id = id;
            this.lat = lat;
            this.lon = lon;
        }
    }
}
