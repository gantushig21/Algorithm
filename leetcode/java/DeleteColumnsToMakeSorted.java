import java.util.*;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] A) {
        int l = A[0].length();
        int ans = 0;

        for (int i = 0; i < l; i++) {
            for (int j = 1; j < A.length; j++)
                if (A[j - 1].charAt(i) > A[j].charAt(i)) {
                    ans++;
                    break;
                }
        }
        return ans;
    }
    public static void main(String[] args) {
        DeleteColumnsToMakeSorted solution = new DeleteColumnsToMakeSorted();

        String[] A = new String[]{"zyx","wvu","tsr"};

        System.out.println(solution.minDeletionSize(A));
    }
}