
public class BinaryGap {
    public int binaryGap(int N) {
        int longestDistance = 0;
        int last = -1;

        for (int i = 0; i < 32; i++) {
            if (((N >> i) & 1) > 0) {
                if (last >= 0)
                    longestDistance = Math.max(longestDistance, i - last);
                last = i;
            }
        }
        return longestDistance;
    }

    public static void main(String[] args) {
        BinaryGap problem = new BinaryGap();

        System.out.println(problem.binaryGap(222));
    }
}