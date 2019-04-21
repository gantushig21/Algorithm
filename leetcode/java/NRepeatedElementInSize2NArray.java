import java.util.*;

public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for (int a : A) {
            if (map.get(a) != null) return a;
            map.put(a, true);
        }

        return 0;    
    }
    public static void main(String[] args) {
        NRepeatedElementInSize2NArray problem = new NRepeatedElementInSize2NArray();

        int[] A = new int[]{1, 2, 3, 3};

        System.out.println(problem.repeatedNTimes(A));
    }
}