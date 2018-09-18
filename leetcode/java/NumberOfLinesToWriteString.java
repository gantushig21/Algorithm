import java.util.*;

public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int length = 0, index, lines = 1;
        for (int i = 0; i < S.length(); i++) {
            index = S.charAt(i) - 'a';
            if (length + widths[index] > 100) {
                length = 0;
                lines++;
            }
            length += widths[index];
        }   
        return new int[]{lines, length};
    }

    public static void main(String[] args) {
        NumberOfLinesToWriteString problem = 
            new NumberOfLinesToWriteString();

        int[] widths = new int[]{4,10,10,10,10,10,10,10,10,10,
            10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "bbbcccdddaaa";

        int[] ans = problem.numberOfLines(widths, S);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}