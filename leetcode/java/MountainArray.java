import java.util.*;

public class MountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int low = 0, high = A.length - 1;

        while (low < high) {
            int middle = (low + high) / 2;
            if (A[middle] < A[middle + 1]) low = middle + 1;
                else high = middle;
        }

        return low;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0, 2, 1, 0};

        MountainArray problem = new MountainArray();

        System.out.println(problem.peakIndexInMountainArray(A));
    }
}