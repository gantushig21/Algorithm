import java.util.*;

public class Question9 {
    public static void main(String[] args) {
        Set<GeometricObject> set = new HashSet<>();

        String str1 = "Home";
        String str2 = "Home";

        System.out.println("Hashcode of str1: " + str1.hashCode());
        System.out.println("Hashcode of str2: " + str2.hashCode());

        String s1 = new String("Home");
        String s2 = new String("Home");

        System.out.println("Hashcode of s1: " + s1.hashCode());
        System.out.println("Hashcode of s2: " + s2.hashCode());

        Circle circle1 = new Circle(40);
        Circle circle2 = new Circle(40);

        System.out.println("Hashcode of circle1: " + circle1.hashCode());
        System.out.println("Hashcode of circle2: " + circle2.hashCode());

        set.add(new Rectangle(4, 5));
        set.add(circle1);
        set.add(circle2);
        set.add(new Rectangle(4, 1));

        System.out.println("A sorted set of geometric objects");
        for (GeometricObject element: set)
            System.out.println("area = " + element.getArea());
    }
}