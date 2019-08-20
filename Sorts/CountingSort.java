import java.util.*;

//          Time complexity                     Space Complexity
//   Best           Average       Worst           Worst
//   O(n + k)	  O(n + k)     O(n + k)	      O(n + k)

public class CountingSort {

    static int[] countingSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++)
            count[arr[i] - min]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        int[] sortedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sortedArr[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        arr = countingSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        input.close();
    }
}