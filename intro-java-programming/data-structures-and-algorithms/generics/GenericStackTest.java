import java.util.*;

public class GenericStackTest {
    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();

        stack.push("London");
        stack.push("Paris");
        stack.push("Berlin");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    } 
}