import java.util.*;

//          Time complexity                     Space Complexity
//   Best           Average       Worst           Worst
//   O(n logn)	  O(n logn)     O(n logn)	      O(n)

public class MergeSort {

    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;

            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);

            merge(arr, low, middle, high);
        }
    }

    static void merge(int[] arr, int low, int middle, int high) {
        int[] firstHalf = new int[middle - low + 1];
        int[] secondHalf = new int[high - middle];

        for (int i = low; i <= middle; i++)
            firstHalf[i - low] = arr[i];

        for (int i = middle + 1; i <= high; i++)
            secondHalf[i - middle - 1] = arr[i];

        int i = 0, j = 0, index = low;
        while (i < firstHalf.length && j < secondHalf.length) {
            if (firstHalf[i] < secondHalf[j]) {
                arr[index++] = firstHalf[i];
                i++;
            } else {
                arr[index++] = secondHalf[j];
                j++;
            }
        }

        while (i < firstHalf.length)
            arr[index++] = firstHalf[i++];

        while (j < secondHalf.length)
            arr[index++] = secondHalf[j++];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        input.close();

    }
}