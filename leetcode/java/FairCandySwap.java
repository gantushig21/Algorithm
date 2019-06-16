import java.util.*;

public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;

        for (int a: A) 
            sumA += a;

        Set<Integer> set = new HashSet<>();
        for (int b: B) {
            sumB += b;
            set.add(b);
        }

        int diff = (sumB - sumA) / 2;
        for (int a: A) 
            if (set.contains(a + diff)) return new int[]{a, a + diff};

        return new int[2];
    }
    // public int[] fairCandySwap(int[] A, int[] B) {
    //     Map<Integer, Boolean> map = new HashMap<>();

    //     int sumA = 0;
    //     for (int a: A) 
    //         sumA += a;

    //     int sumB = 0;
    //     for (int b: B) {
    //         sumB += b;
    //         map.put(b, true);
    //     }

    //     int diff = (sumB - sumA) / 2;
    //     for (int a: A) 
    //         if (map.get(a + diff) != null) return new int[]{a, a + diff};

    //     return new int[2];
    // }
    // public int[] fairCandySwap(int[] A, int[] B) {
    //     Boolean[] exists = new Boolean[100001];

    //     Arrays.fill(exists, false);

    //     int sumA = 0;
    //     for (int a: A) 
    //         sumA += a;

    //     int sumB = 0;
    //     for (int b: B) {
    //         sumB += b;
    //         exists[b] = true;
    //     }

    //     int diff = (sumB - sumA) / 2;
    //     for (int a: A) 
    //         if (a + diff > -1 && a + diff < 100001 && exists[a + diff]) return new int[]{a, a + diff};

    //     return new int[2];
    // }
    public static void main(String[] args) {
        FairCandySwap problem = new FairCandySwap();

        int[] A = new int[]{1, 2, 5};
        int[] B = new int[]{2, 4};

        System.out.println(Arrays.toString(problem.fairCandySwap(A, B)));
    }
}