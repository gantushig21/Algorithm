import java.util.*;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        for (int i = A.length - 3; i >= 0; i--)
            if (A[i] + A[i + 1] > A[i + 2]) return A[i] + A[i + 1] + A[i + 2];

        return 0;
    }
    public static void main(String[] args) {
        LargestPerimeterTriangle problem = new LargestPerimeterTriangle();

        int[] A = new int[]{2,1,2};
        System.out.println(problem.largestPerimeter(A));
    }
}