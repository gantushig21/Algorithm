import java.util.*;

//          Time complexity                     Space Complexity
//   Best           Average       Worst           Worst
//   O(n)	        O(n^2)	      O(n^2)	       O(1)

public class InsertionSort {

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index;
            int currentElement = arr[i];
            for (index = i - 1; index >= 0 && arr[index] > currentElement; index--)
                arr[index + 1] = arr[index];

            arr[index + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        insertionSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        input.close();

    }
}