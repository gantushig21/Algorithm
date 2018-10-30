
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int row = 1; row < matrix.length; row++)
            for (int column = 1; column < matrix[0].length; column++)
                if (matrix[row][column] != matrix[row - 1][column - 1])
                    return false;

        return true;
    }

    public static void main(String[] args) {
        ToeplitzMatrix problem = new ToeplitzMatrix();

        int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
        // int[][] matrix = new int[][] { { 1, 2 }, { 2, 2 } };

        System.out.println(problem.isToeplitzMatrix(matrix));
    }
}