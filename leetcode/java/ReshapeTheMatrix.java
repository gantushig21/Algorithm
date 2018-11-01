import java.util.Arrays;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        int m = nums[0].length;
        if (n * m != r * c)
            return nums;

        int[][] newMatrix = new int[r][c];
        for (int i = 0; i < n * m; i++)
            newMatrix[i / c][i % c] = nums[i / m][i % m];

        return newMatrix;

    }

    public static void main(String[] args) {
        ReshapeTheMatrix problem = new ReshapeTheMatrix();

        int[][] nums = new int[][] { { 1, 2 }, { 3, 4 } };
        int r = 1, c = 4;
        int[][] newMatrix = problem.matrixReshape(nums, r, c);

        System.out.println(Arrays.deepToString(newMatrix));
    }
}