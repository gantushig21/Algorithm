
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int last, current = -1;

        do {
            last = current;
            current = n & 1;
            n = n >> 1;
        } while (n > 0 && last != current);

        return last != current;
    }

    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits problem = new BinaryNumberWithAlternatingBits();

        System.out.println(problem.hasAlternatingBits(10));
    }
}