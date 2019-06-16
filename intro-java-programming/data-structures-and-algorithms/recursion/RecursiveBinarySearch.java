import java.util.*;

public class RecursiveBinarySearch {
    public static int recursiveBinarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;

        return recursiveBinarySearch(list, low, high, key);
    }

    private static int recursiveBinarySearch(int[] list, int low, int high, int key) {
        if (low > high)
            return -1;

        int middle = (low + high) / 2;

        if (list[middle] == key) return middle;
        if (list[middle] < key) return recursiveBinarySearch(list, low + 1, high, key);
        return recursiveBinarySearch(list, low, high - 1, key);
    }

    public static void main(String[] args) {
        int[] list = {14, 3, 11, 22, 56, 32};

        Arrays.sort(list);
        System.out.println(recursiveBinarySearch(list, 56));
    }
}