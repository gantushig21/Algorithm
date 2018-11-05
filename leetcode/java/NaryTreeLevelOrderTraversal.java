import java.util.*;

public class NaryTreeLevelOrderTraversal {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        DFS(root, 0);

        return lists;
    }

    public void DFS(Node current, int level) {
        if (current == null)
            return;

        if (lists.size() <= level)
            lists.add(new ArrayList<Integer>());
        lists.get(level).add(current.val);

        for (Node node : current.children)
            DFS(node, level + 1);
    }

    public void run() {
        List<Node> childrenOfThree = new ArrayList<>();
        childrenOfThree.add(new Node(5, new ArrayList<Node>()));
        childrenOfThree.add(new Node(6, new ArrayList<Node>()));
        Node three = new Node(3, childrenOfThree);

        List<Node> childrenOfOne = new ArrayList<>();
        childrenOfOne.add(three);
        childrenOfOne.add(new Node(2, new ArrayList<Node>()));
        childrenOfOne.add(new Node(4, new ArrayList<Node>()));

        Node one = new Node(1, childrenOfOne);

        List<List<Integer>> answer = levelOrder(one);
        for (List<Integer> list : answer)
            System.out.println(Arrays.toString(list.toArray(new Integer[list.size()])));

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
    };

    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal problem = new NaryTreeLevelOrderTraversal();
        problem.run();
    }
}