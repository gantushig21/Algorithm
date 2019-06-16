import java.util.*;

public class MonotonicArray {
    // public boolean isMonotonic(int[] A) {
    //     int direction = 0;
    //     for (int i = 1; i < A.length; i++) {
    //         int compare = Integer.compare(A[i - 1], A[i]);
    //         if (compare != 0) {
    //             if (compare != direction && direction != 0)
    //                 return false;
    //             direction = compare;
    //         }
    //     }
    //     return true;
    // }
    public boolean isMonotonic(int[] A) {
        int direction = 0;
        for (int i = 1; i < A.length; i++) {
            int compare = Integer.compare(A[i - 1], A[i]);
            if (compare != 0) {
                if (compare != direction && direction != 0)
                    return false;
                direction = compare;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        MonotonicArray problem = new MonotonicArray();

        // int[] A = new int[]{1, 2, 2, 4};
        int[] A = new int[]{6, 5, 4, 4};
        // int[] A = new int[]{1, 3, 2};
        System.out.println(problem.isMonotonic(A));
    }
}