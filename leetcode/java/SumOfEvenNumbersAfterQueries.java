import java.util.*;

public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] response = new int[queries.length];

        int sum = 0, index = 0;
        for (int a : A)
            if (a % 2 == 0) sum += a;

        for (int[] query : queries) {
            if (A[query[1]] % 2 == 0) sum -= A[query[1]];
            A[query[1]] += query[0];
            if (A[query[1]] % 2 == 0) sum += A[query[1]];

            response[index++] = sum;
        }

        return response;
    }
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4};
        int[][] queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};

        SumOfEvenNumbersAfterQueries problem = new SumOfEvenNumbersAfterQueries();

        System.out.println(Arrays.toString(problem.sumEvenAfterQueries(A, queries)));
    }
}