import java.util.*;

public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int count = -1;
        int[][] matrix = new int[R * C][2];
        boolean[][] used = new boolean[R][C];
        int[][] plus = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{r0, c0});
        used[r0][c0] = true;

        while (!queue.isEmpty()) {
            Integer[] top = queue.poll();

            count++;
            matrix[count][0] = top[0];
            matrix[count][1] = top[1];

            for (int i = 0; i < plus.length; i++) {
                int x = top[0] + plus[i][0];
                int y = top[1] + plus[i][1];
                if (x >= 0 && x < R && y >= 0 && y < C && !used[x][y]) {
                    queue.offer(new Integer[]{x, y});
                    used[x][y] = true;
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        MatrixCellsInDistanceOrder problem = new MatrixCellsInDistanceOrder();
        
        int[][] matrix = problem.allCellsDistOrder(2, 3, 1, 2);
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}