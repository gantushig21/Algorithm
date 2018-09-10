import java.util.*;

public class ToLowerCase {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ToLowerCase problem = new ToLowerCase();

        System.out.println(problem.toLowerCase(input.next()));

        input.close();
    }
}