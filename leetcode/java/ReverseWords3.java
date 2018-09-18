import java.util.*;

public class ReverseWords3 {
    public String reverseWords(String words) {
        char[] letters = (words + " ").toCharArray();

        int start = 0;
        for (int i = 1; i < letters.length; i++) {
            if (letters[i] == ' ') {
                reverse(start, i - 1, letters);
                start = i + 1;
            }
        }

        return String.valueOf(letters).trim();
    }

    public void reverse(int start, int finish, char[] letters) {
        char temp;
        for (int i = start; i <= start + (finish - start) / 2; i++) {
            temp = letters[i];
            letters[i] = letters[finish - i + start];
            letters[finish - i + start] = temp;
        }
    }

    public static void main(String[] args) {
        String words = "";

        ReverseWords3 problem = new ReverseWords3();

        System.out.println(problem.reverseWords(words));
    }
}