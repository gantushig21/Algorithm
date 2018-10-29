import java.util.*;

public class LeafSimilarTrees {
    public ArrayList<Integer> list1 = new ArrayList<>();
    public ArrayList<Integer> list2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getLeaves(root1, list1);
        getLeaves(root2, list2);

        return list1.equals(list2);
    }

    public void getLeaves(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;
        getLeaves(root.left, list);
        getLeaves(root.right, list);

        if (root.left == null && root.right == null)
            list.add(root.val);
    }

    public void run() {
        TreeNode root = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        root.left = five;
        root.right = one;
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        five.left = six;
        five.right = two;
        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8);
        one.left = nine;
        one.right = eight;
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        two.left = seven;
        two.right = four;

        System.out.println(leafSimilar(root, root));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        LeafSimilarTrees problem = new LeafSimilarTrees();

        problem.run();
    }
}