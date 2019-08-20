import java.util.*;

//          Time complexity                     Space Complexity
//   Best           Average       Worst           Worst
// O(n log(n))	  O(n log(n))	  O(n^2)	    O(log(n))

public class QuickSort {

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int index = low - 1;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                index++;
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

        int temp = arr[high];
        arr[high] = arr[index + 1];
        arr[index + 1] = temp;

        return index + 1;
    }

    static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int index = partition(arr, low, high);

            sort(arr, low, index - 1);
            sort(arr, index + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        input.close();

    }
}