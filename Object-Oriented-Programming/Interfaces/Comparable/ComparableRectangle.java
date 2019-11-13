import java.math.*;

public class ComparableRectangle extends Rectangle implements Comparable<ComparableRectangle> {
    public ComparableRectangle(double width, double height) {
        super(width, height);
    }

    @Override
    public int compareTo(ComparableRectangle o) {
        if (getArea() > o.getArea())
            return 1;
        if (getArea() < o.getArea())
            return -1;

        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Area: " + getArea();
    }
}