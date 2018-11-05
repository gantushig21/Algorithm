import java.util.Stack;

public class ReverseOnlyLetters {
    // public String reverseOnlyLetters(String S) {
    // char[] chars = S.toCharArray();

    // int low = 0, high = chars.length - 1;
    // char temp;
    // while (low < high) {
    // while (low < chars.length && !Character.isLetter(chars[low]))
    // low++;
    // while (high >= 0 && !Character.isLetter(chars[high]))
    // high--;

    // if (low < high) {
    // temp = chars[low];
    // chars[low] = chars[high];
    // chars[high] = temp;
    // low++;
    // high--;
    // }
    // }

    // return String.valueOf(chars);
    // }

    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        Stack<Character> letters = new Stack<>();

        for (char ch : chars)
            if (Character.isLetter(ch))
                letters.push(ch);

        StringBuilder str = new StringBuilder();
        for (char ch : chars) {
            if (Character.isLetter(ch))
                str.append(letters.pop());
            else
                str.append(ch);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        ReverseOnlyLetters problem = new ReverseOnlyLetters();

        // String S = "Test1ng-Leet=code-Q!";
        // String S = "a-bC-dEf-ghIj";
        String S = "7_28";
        System.out.println(problem.reverseOnlyLetters(S));
    }
}