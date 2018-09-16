import java.util.*;
import java.util.stream.IntStream;

public class ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        int maxRow, maxCol, area = 0;

        for (int i = 0; i < grid.length; i++) {
            maxRow = 0;
            maxCol = 0;
            for (int j = 0; j < grid[0].length; j++) {
                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
                if (grid[i][j] != 0) area++;
            }
            area += maxRow + maxCol;
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2}, {3, 4}};

        ProjectionAreaOf3DShapes problem = new ProjectionAreaOf3DShapes();

        System.out.println(problem.projectionArea(grid));
    }
}