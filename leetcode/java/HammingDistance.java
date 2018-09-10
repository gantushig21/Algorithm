import java.util.*;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int value = x ^ y;
        int count = 0;
        while (value > 0) {
            if ((value & 1) == 1) count++;
            value >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        HammingDistance problem = new HammingDistance();

        Scanner input = new Scanner(System.in);

        System.out.println(problem.hammingDistance(input.nextInt(), input.nextInt()));

        input.close();
    }
}