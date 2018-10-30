
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0, x, y;
        int[][] plus = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    for (int q = 0; q < 4; q++) {
                        x = i + plus[q][0];
                        y = j + plus[q][1];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length)
                            perimeter -= grid[x][y];
                    }
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        IslandPerimeter problem = new IslandPerimeter();

        int[][] grid = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };

        System.out.println(problem.islandPerimeter(grid));
    }
}