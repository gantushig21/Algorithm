import java.util.*;

public class LongestUncommonSubsequence {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        LongestUncommonSubsequence problem = new LongestUncommonSubsequence();

        String s1 = "aba";
        String s2 = "cdc";
        System.out.println(problem.findLUSlength(s1, s2));
    }
}