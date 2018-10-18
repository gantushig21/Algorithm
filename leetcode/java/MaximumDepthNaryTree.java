import java.util.*;

public class MaximumDepthNaryTree {

    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        int maxDepth = 0;
        for (Node child : root.children)
            maxDepth = Math.max(maxDepth, maxDepth(child));

        return maxDepth + 1;
    }

    public void run() {
        Node five = new Node(5, new ArrayList<>());

        Node six = new Node(6, new ArrayList<>());

        List<Node> childrenOfThree = new ArrayList<>();
        childrenOfThree.add(five);
        childrenOfThree.add(six);

        Node three = new Node(3, childrenOfThree);
        Node two = new Node(2, new ArrayList<>());
        Node four = new Node(4, new ArrayList<>());

        List<Node> childrenOfOne = new ArrayList<>();
        childrenOfOne.add(three);
        childrenOfOne.add(two);
        childrenOfOne.add(four);

        Node root = new Node(1, childrenOfOne);

        System.out.println(maxDepth(root));
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        MaximumDepthNaryTree problem = new MaximumDepthNaryTree();

        problem.run();
    }
}