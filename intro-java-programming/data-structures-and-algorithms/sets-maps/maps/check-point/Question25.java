import java.util.*;

public class Question25 {
    public static void main(String[] args) {
        List list = Collections.unmodifiableList(Arrays.asList("Chicago", "Boston"));

        list.remove("Dallas");
        
        System.out.println(list);
    }
}