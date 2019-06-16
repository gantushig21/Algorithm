import java.util.*;

public class RecursiveSelectionSort {
    public static void sort(double[] list) {
        sort(list, 0, list.length - 1);
    }

    private static void sort(double[] list, int low, int high) {
        if (low < high) {
            int indexOfMin = low;
            double min = list[low];
            for (int i = low + 1; i <= high; i++) {
                if (list[i] < min) {
                    min = list[i];
                    indexOfMin = i;
                }
            }
            list[indexOfMin] = list[low];
            list[low] = min;

            sort(list, low + 1, high);
        }
    }

    public static void main(String[] args) {
        double[] list = {0.9, 0.34, 0.56, 0.11, 0.78};

        sort(list);
        for (double element : list)
            System.out.println(element);
    }
}