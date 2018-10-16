import java.util.*;

public class SmallestRangeI {
    public int smallestRange(int[] A, int K) {
        int maxI = 0, minI = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[maxI]) maxI = i;
            if (A[i] < A[minI]) minI = i;
        }

        int difference = A[maxI] - A[minI];
        return difference > 2 * K ? difference - 2 * K : 0;
    }
    public static void main(String[] args) {
        SmallestRangeI problem = new SmallestRangeI();

        // int[] A = new int[]{1, 3, 6};
        // int k = 3;
        // int[] A = new int[]{0, 10};
        // int k = 2;
        int[] A = new int[]{1};
        int k = 0;

        System.out.println(problem.smallestRange(A, k));
    }
}