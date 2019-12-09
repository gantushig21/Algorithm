import java.util.*;

public class KthOfTwoArray {
    static int getKthSmallestRecursive(int[] arr1, int n, int[] arr2, int m, int k) {
        if (k > n + m)
            return -1;

        if (n == 0)
            return arr2[k - 1];

        if (m == 0)
            return arr1[k - 1];

        if (k == 1)
            return Math.min(arr1[0], arr2[0]);

        int i = Math.min(n, k / 2);
        int j = Math.min(m, k / 2);
        if (arr1[i - 1] > arr2[j - 1]) {
            int[] temp = Arrays.copyOfRange(arr2, j, m);
            return getKthSmallestRecursive(arr1, n, temp, m - j, k - j);
        }

        int[] temp = Arrays.copyOfRange(arr1, i, n);
        return getKthSmallestRecursive(temp, n - i, arr2, m, k - i);
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 6, 7, 9 };
        int[] arr2 = { 1, 4, 8, 10 };
        int k = 9;

        int smallest = getKthSmallestRecursive(arr1, arr1.length, arr2, arr2.length, k);
        System.out.println("The kth smallest element is: " + smallest);
    }
}