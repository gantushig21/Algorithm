import java.util.*;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int[][] pairs = new int[K][2];
        
        int size = points.length;
        double[] distances = new double[size];
        for (int i = 0; i < size; i++) 
            distances[i] = distance(points[i]);
        
        
        Arrays.sort(distances);
        int count = 0;

        for (int i = 0; i < size; i++) 
            if (distance(points[i]) <= distances[K - 1]) pairs[count++] = points[i];

        return pairs;
    }

    public int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    public static void main(String[] args) {
        KClosestPointsToOrigin problem = new KClosestPointsToOrigin();

        int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        int[][] pairs = problem.kClosest(points, 2);

        for (int[] pair: pairs) 
            System.out.println(pair[0] + " " + pair[1]);
    } 
}