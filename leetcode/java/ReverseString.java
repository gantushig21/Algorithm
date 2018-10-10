
public class ReverseString {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        ReverseString problem = new ReverseString();

        String s = "A man, a plan, a canal: Panama";

        System.out.println(problem.reverseString(s));
    }
}