import java.util.*;

//          Time complexity                     Space Complexity
//   Best           Average       Worst           Worst
//   O(n)	        O(n^2)	      O(n^2)	       O(1)

public class BubbleSort {

    static void bubbleSort(int[] arr) {
        boolean available = true;
        int n = arr.length;
        while (available) {
            n--;
            available = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    available = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        bubbleSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        input.close();

    }
}