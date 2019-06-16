import java.util.*;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        int value = L <= root.val  && root.val <= R ? root.val : 0;

        return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R) + value;
    }

    public void run(Integer[] nodes, int L, int R) {
        TreeNode root = createNode(nodes, 0);

        System.out.println(rangeSumBST(root, L, R));
    }

    public TreeNode createNode(Integer[] nodes, int current) {
        if (current >= nodes.length || nodes[current] == null) return null;

        TreeNode node = new TreeNode(nodes[current]);

        node.left = createNode(nodes, current * 2 + 1);
        node.right = createNode(nodes, current * 2 + 2);

        return node;
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
        RangeSumOfBST problem = new RangeSumOfBST();

        Integer[] nodes = new Integer[]{10,5,15,3,7,13,18,1,null,6};
        problem.run(nodes, 6, 10);
    }
}