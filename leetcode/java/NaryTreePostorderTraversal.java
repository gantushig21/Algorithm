import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal {
    // List<Integer> list = new ArrayList<>();

    // public List<Integer> postorder(Node root) {
    // if (root == null)
    // return list;

    // for (Node child : root.children)
    // postorder(child);

    // list.add(root.val);

    // return list;
    // }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (Node child : root.children)
                stack.add(child);
        }

        Collections.reverse(list);
        return list;
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

        List<Integer> list = postorder(root);
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
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
        NaryTreePostorderTraversal problem = new NaryTreePostorderTraversal();

        problem.run();
    }
}