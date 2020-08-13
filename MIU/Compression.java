import java.util.*;

public class Compression {
    static int[] clusterCompression(int[] arr) {
        int numberOfCluster = 1;
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1] != arr[i]) numberOfCluster++;

        int[] ans = new int[numberOfCluster];

        ans[0] = arr[0];
        int index = 1;
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1] != arr[i]) ans[index++] = arr[i];

        return ans;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int[] ans = clusterCompression(arr);
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");

        System.out.println();
        input.close();
    }
}