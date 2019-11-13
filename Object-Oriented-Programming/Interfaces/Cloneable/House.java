import java.util.Date;

public class House implements Cloneable, Comparable<House> {
    private int id;
    private double area;
    private Date whenBuilt;

    public House(int id, double area) {
        this.id = id;
        this.area = area;
        whenBuilt = new Date();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        House houseClone = (House) super.clone();

        houseClone.whenBuilt = (Date) (whenBuilt.clone());
        return houseClone;
    }

    @Override
    public int compareTo(House o) {
        if (area > o.area)
            return 1;
        if (area < o.area)
            return -1;

        return 0;
    }

    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public Date getWhenBuilt() {
        return whenBuilt;
    }
}