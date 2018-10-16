import java.util.*;

public class NaryTreePreorderTraversal {
    // List<Integer> list = new ArrayList<>();

    // public List<Integer> preorder(Node root) {
    //     if (root == null) return list;
    //     list.add(root.val);
    //     for (Node node : root.children)
    //         preorder(node);
        
    //     return list;
    // }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }

        return list;
    }    

    public void run() {
        Node five = new Node(5, new ArrayList<>());
        Node six = new Node(6, new ArrayList<>());
        Node two = new Node(2, new ArrayList<>());
        Node four = new Node(4, new ArrayList<>());

        List<Node> childrenOfThree = new ArrayList<>(Arrays.asList(five, six));
        Node three = new Node(3, childrenOfThree);

        List<Node> childrenOfRoot = new ArrayList<>(Arrays.asList(three, two, four));
        Node root = new Node(1, childrenOfRoot);

        List<Integer> ans = preorder(root);
        for (Integer value : ans)
            System.out.print(value + " ");
        System.out.println();
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        NaryTreePreorderTraversal problem = new NaryTreePreorderTraversal();

        problem.run();
    }
}