import java.util.*;

public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int[][] transformedA = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) 
            for (int j = 0; j < A[0].length; j++)
                transformedA[j][i] = A[i][j];

        return transformedA;        
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        TransposeMatrix problem = new TransposeMatrix();

        int[][] matrix = problem.transpose(A);

        for (int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));
    }
}