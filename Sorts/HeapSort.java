import java.util.*;

//          Time complexity                     Space Complexity
//   Best           Average       Worst           Worst
//   O(n logn)	  O(n logn)     O(n logn)	      O(1)

public class HeapSort {

    static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, arr.length, i);

        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int currentIndex) {
        int largest = currentIndex;
        int leftIndex = currentIndex * 2 + 1;
        int rightIndex = currentIndex * 2 + 2;

        if (leftIndex < n && arr[leftIndex] > arr[largest])
            largest = leftIndex;

        if (rightIndex < n && arr[rightIndex] > arr[largest])
            largest = rightIndex;

        if (largest != currentIndex) {
            int temp = arr[largest];
            arr[largest] = arr[currentIndex];
            arr[currentIndex] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        heapSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        input.close();

    }
}