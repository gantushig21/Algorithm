import java.util.Comparator;
import java.io.Serializable;;

public class GeometricObjectComparator implements Comparator<GeometricObject>, Serializable {
    public int compare(GeometricObject o1, GeometricObject o2) {
        if (o1.getArea() > o2.getArea())
            return 1;
        if (o1.getArea() < o2.getArea())
            return -1;
        return 0;
    }
}