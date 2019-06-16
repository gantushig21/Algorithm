import java.util.*;

public class Question7 {
    public static void main(String[] args) {
        LinkedHashSet<String> set1 = new LinkedHashSet<>();

        set1.add("New York");

        LinkedHashSet<String> set2 = set1;
        LinkedHashSet<String> set3 =
            (LinkedHashSet<String>)(set1.clone());
        set1.add("Atlanta");

        System.out.println("set1 is " + set1);
        System.out.println("set2 is " + set2);
        System.out.println("set3 is " + set3);
    }
}