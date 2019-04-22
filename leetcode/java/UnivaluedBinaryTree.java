import java.util.*;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root === null) return true;

        boolean left = true, right = true;
        if (root.left) {
            if (root.val != root.left.val) return false;
            left = isUnivalTree(root.left);
        }
        if (root.right) {
            if (root.val != root.right.val) return false;
            right = isUnivalTree(root.right);
        }

        return left && right;

    }

    public void run() {
        TreeNode root = new TreeNode(1);

        System.out.println(root.val);
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
        UnivaluedBinaryTree problem = new UnivaluedBinaryTree();

        problem.run();
    }
}