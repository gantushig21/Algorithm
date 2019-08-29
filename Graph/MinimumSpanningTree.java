import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    public int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge e1) {
        return this.weight - e1.weight;
    }
}

class Subset {
    public int parent, rank;

    public Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}

public class MinimumSpanningTree {
    public Edge[] edge;
    public int V, E;
    public Subset[] subset;

    public MinimumSpanningTree(int V, Edge[] edge) {
        this.V = V;
        this.E = edge.length;
        this.edge = edge;

        subset = new Subset[V];
        for (int i = 0; i < V; i++)
            subset[i] = new Subset(i, 0);
    }

    public int getParentOfSubset(int v) {
        while (subset[v].parent != v)
            v = subset[v].parent;

        return v;
    }

    public void union(int parentV, int parentU) {
        if (subset[parentV].rank < subset[parentU].rank)
            subset[parentV].parent = parentU;
        else if (subset[parentV].rank > subset[parentU].rank)
            subset[parentU].parent = parentV;
        else {
            subset[parentU].parent = parentV;
            subset[parentV].rank++;
        }
    }

    public int kruskalMST() {
        Arrays.sort(edge);

        List<Edge> treeEdge = new ArrayList<>();

        int index = -1;
        while (treeEdge.size() < V - 1) {
            index++;

            int parentV = getParentOfSubset(edge[index].src);
            int parentU = getParentOfSubset(edge[index].dest);

            if (parentV != parentU) {
                union(parentV, parentU);
                treeEdge.add(edge[index]);
            }
        }

        int result = 0;
        for (Edge e : treeEdge) {
            result += e.weight;
            // System.out.println(e.src + " " + e.dest + " " + e.weight);
        }

        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("inputMST.txt"));

        int V = input.nextInt();
        int E = input.nextInt();
        Edge[] edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            int v = input.nextInt(), u = input.nextInt(), w = input.nextInt();
            edge[i] = new Edge(v - 1, u - 1, w);
        }

        MinimumSpanningTree graph = new MinimumSpanningTree(V, edge);
        System.out.println(graph.kruskalMST());

        input.close();
    }
}