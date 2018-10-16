import java.util.*;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return NULL;

        if (root.val == val) return root;

        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);

        if (left != null) return left;
        return right;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        SearchInABinarySearchTree problem = new SearchInABinarySearchTree();

        System.out.println(problem.searchBST(root, 2).val);
    }
}