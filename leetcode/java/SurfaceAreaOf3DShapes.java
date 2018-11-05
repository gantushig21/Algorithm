
public class SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        int area = 0;
        int N = grid.length;
        int[][] plus = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] > 0) {
                    for (int q = 0; q < 4; q++) {
                        int x = i + plus[q][0];
                        int y = j + plus[q][1];
                        int neighbour = (x == -1 || x == N || y == -1 || y == N) ? 0 : grid[x][y];
                        area += Math.max(grid[i][j] - neighbour, 0);
                    }
                    area += 2;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        SurfaceAreaOf3DShapes problem = new SurfaceAreaOf3DShapes();

        // int[][] grid = new int[][] { { 1, 2 }, { 3, 4 } };
        int[][] grid = new int[][] { { 2, 2, 2 }, { 2, 1, 2 }, { 2, 2, 2 } };
        System.out.println(problem.surfaceArea(grid));
    }
}