import java.util.*;
import java.io.*;

class CompareY implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        if (p1.y == p2.y)
            return p1.x - p2.x;
        return p1.y - p2.y;
    }
}

class Pair {
    public Point first, second;

    public Pair(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    public double getDistance() {
        return Math.sqrt((first.x - second.x) * (first.x - second.x) + (first.y - second.y) * (first.y - second.y));
    }

    public String toString() {
        return first + " " + second;
    }
}

class Point implements Comparable<Point> {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point p) {
        if (x == p.x)
            return y - p.y;
        return x - p.x;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class DivideAndConquer {
    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    public static Pair bruteForce(Point[] points, int low, int high) {
        Point p1 = points[low];
        Point p2 = points[low + 1];
        double minDistance = distance(p1, p2);
        double distance = 0.0;

        for (int i = low; i < high; i++) {
            for (int j = i + 1; j <= high; j++) {
                distance = distance(points[i], points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                    p1 = points[i];
                    p2 = points[j];
                }
            }
        }

        return new Pair(p1, p2);
    }

    public static Pair divideAndConquer(Point[] points, Point[] pointsOrderedOnY, int low, int high) {
        if (high - low <= 3)
            return bruteForce(points, low, high);

        int middle = (low + high) / 2;

        Pair p1 = divideAndConquer(points, pointsOrderedOnY, low, middle);
        Pair p2 = divideAndConquer(points, pointsOrderedOnY, middle + 1, high);

        double d = Math.min(p1.getDistance(), p2.getDistance());

        List<Point> stripL = new ArrayList<>();
        List<Point> stripR = new ArrayList<>();
        double midX = points[middle].x;
        for (Point p : pointsOrderedOnY) {
            if (p.x <= midX && midX - p.x <= d)
                stripL.add(p);
            else if (midX < p.x && p.x - midX <= d)
                stripR.add(p);
        }

        Pair p3 = null;
        int i = 0;
        for (Point p : stripL) {
            while (i < stripR.size() && stripR.get(i).y <= p.y - d)
                i++;

            int j = i;
            while (j < stripR.size() && Math.abs(p.y - stripR.get(j).y) <= d) {
                if (distance(p, stripR.get(j)) < d) {
                    d = distance(p, stripR.get(j));
                    p3 = new Pair(p, stripR.get(j));
                }
                j++;
            }
        }

        if (p3 != null)
            return p3;

        if (d == p1.getDistance())
            return p1;

        return p2;
    }

    public static Pair closest(Point[] points) {
        Arrays.sort(points);
        Point[] pointsOrderedOnY = new Point[points.length];
        System.arraycopy(points, 0, pointsOrderedOnY, 0, points.length);

        Arrays.sort(pointsOrderedOnY, new CompareY());

        return divideAndConquer(points, pointsOrderedOnY, 0, points.length - 1);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("inputDivideAndConquer.txt"));

        int n = input.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = input.nextInt(), y = input.nextInt();
            points[i] = new Point(x, y);
        }

        Pair pair = closest(points);

        System.out.println(pair + ": " + pair.getDistance());

        input.close();
    }
}