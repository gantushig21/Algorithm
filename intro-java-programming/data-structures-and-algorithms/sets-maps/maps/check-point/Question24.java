import java.util.*;

public class Question24 {
    public static void main(String[] args) {
        Set<String> set = Collections.singleton("Chicago");

        set.add("Dallas");
        
        System.out.println(set);
    }
}