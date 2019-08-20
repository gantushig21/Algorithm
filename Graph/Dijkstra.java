import java.util.*;

// Time complexity
// O(E + logV)

public class Dijkstra {
    private Set<Integer> used;
    private int[] dist;
    private PriorityQueue<Node> queue;
    private int n;
    private List<List<Node>> map;

    public Dijkstra(int n) {
        this.n = n;
        used = new HashSet<>();
        dist = new int[n];
        queue = new PriorityQueue<>(n, new Node());
    }

    public void shortestPath(List<List<Node>> map, int start) {
        this.map = map;

        for (int i = 0; i < dist.length; i++)
            dist[i] = Integer.MAX_VALUE;

        queue.add(new Node(start, 0));
        dist[start] = 0;
        while (used.size() != n) {
            Node u = queue.poll();

            used.add(u.node);

            visitNeighbours(u.node);
        }
    }

    private void visitNeighbours(int u) {
        for (int i = 0; i < map.get(u).size(); i++) {
            Node v = map.get(u).get(i);

            if (!used.contains(v.node)) {
                if (dist[v.node] > dist[u] + v.weight)
                    dist[v.node] = dist[u] + v.weight;

                queue.add(new Node(v.node, dist[v.node]));
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<List<Node>> map = new ArrayList<List<Node>>();
        int n = input.nextInt();
        int m = input.nextInt();
        for (int i = 0; i < n; i++) {
            List<Node> item = new ArrayList<>();
            map.add(item);
        }
        for (int i = 0; i < m; i++) {
            int v = input.nextInt(), u = input.nextInt(), w = input.nextInt();
            map.get(v).add(new Node(u, w));
            map.get(u).add(new Node(v, w));
        }
        int start = input.nextInt();

        Dijkstra dijkstra = new Dijkstra(n);
        dijkstra.shortestPath(map, start);

        for (int i = 0; i < dijkstra.dist.length; i++)
            System.out.println(i + " => " + dijkstra.dist[i]);

        input.close();
    }
}

class Node implements Comparator<Node> {
    public int node;
    public int weight;

    public Node() {
    }

    public Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compare(Node n1, Node n2) {
        if (n1.weight < n2.weight)
            return -1;
        if (n1.weight > n2.weight)
            return 1;
        return 0;
    }
}