import java.util.*;

public class MoreThanKTimes {
    static private class Element {
        public int value, count;

        public Element(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    static void moreThanK(int[] arr, int k) {
        Element[] temp = new Element[k - 1];
        for (int i = 0; i < k - 1; i++)
            temp[i] = new Element(Integer.MIN_VALUE, 0);

        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            for (; j < k - 1; j++) {
                if (temp[j].value == arr[i]) {
                    temp[j].count++;
                    break;
                }
            }
            if (j == k - 1) {
                for (j = 0; j < k - 1; j++) {
                    if (temp[j].count == 0) {
                        temp[j].value = arr[i];
                        temp[j].count = 1;
                        break;
                    }
                }

                if (j == k - 1) {
                    for (j = 0; j < k - 1; j++)
                        temp[j].count--;
                }
            }
        }
        for (int j = 0; j < k - 1; j++) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (temp[j].value == arr[i])
                    count++;
            }
            System.out.println("Number: " + temp[j].value + " Count: " + count);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 4, 5, 6, 7, 8, 4, 4 };

        moreThanK(arr1, 2);
    }
}