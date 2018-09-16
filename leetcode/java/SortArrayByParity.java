import java.util.*;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for (int i = 0 ; i < A.length; i++) {
            if (A[i] % 2 == 1) odd.add(A[i]);
                else even.add(A[i]);
        }
        even.addAll(odd);
        return even.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 1, 2, 4};

        SortArrayByParity sortArray = new SortArrayByParity();

        System.out.println(Arrays.toString(sortArray.sortArrayByParity(A)));

    }
}