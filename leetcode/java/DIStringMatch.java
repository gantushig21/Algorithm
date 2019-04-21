import java.util.*;

public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int l = S.length();
        int[] a = new int[l + 1];
        int low = 0, high = l;

        for (int i = 0; i < l; i++) {
            if (S.charAt(i) == 'I') a[i] = low++;
                else a[i] = high--;
        }
        a[l] = high;

        return a;
    }
    public static void main(String[] args) {
        DIStringMatch solution = new DIStringMatch();
        
        String S = "IDID";

        System.out.println(Arrays.toString(solution.diStringMatch(S)));
    }
}