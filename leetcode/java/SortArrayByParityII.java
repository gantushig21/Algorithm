import java.util.Arrays;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int[] arr = new int[A.length];
        int even = 0, odd = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0)
                arr[2 * even++] = A[i];
            else
                arr[1 + 2 * odd++] = A[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] A = new int[] { 4, 2, 5, 7 };

        SortArrayByParityII problem = new SortArrayByParityII();

        int[] arr = problem.sortArrayByParityII(A);

        System.out.println(Arrays.toString(arr));
    }
}