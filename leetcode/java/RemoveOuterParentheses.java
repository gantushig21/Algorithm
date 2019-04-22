import java.util.*;

public class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder answer = new StringBuilder();
        char[] arr = S.toCharArray();

        int valid = 0;
        for (char ch : arr) {
            if (ch == '(' && valid++ > 0) answer.append(ch);
            if (ch == ')' && valid-- > 1) answer.append(ch);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        RemoveOuterParentheses problem = new RemoveOuterParentheses();
        
        System.out.println(problem.removeOuterParentheses("(()())(())(()(()))"));
    }
}