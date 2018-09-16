import java.util.*;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> arr = new ArrayList<>();

        int temp;
        for (int i = left; i <= right; i++) {
            temp = i;
            while (temp != 0 && temp % 10 != 0) {
                if (i % (temp % 10) != 0) break;
                temp /= 10;
            }
            if (temp == 0) arr.add(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int left = 1, right = 22;

        SelfDividingNumbers problem = new SelfDividingNumbers();

        System.out.println(problem.selfDividingNumbers(left, right).toString());
    }
}