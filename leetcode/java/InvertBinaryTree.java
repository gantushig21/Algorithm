
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public void run() {
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        four.left = two;
        four.right = seven;

        two.left = new TreeNode(1);
        two.right = new TreeNode(3);

        seven.left = new TreeNode(6);
        seven.right = new TreeNode(9);

        invertTree(four);
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
        InvertBinaryTree problem = new InvertBinaryTree();

        problem.run();
    }
}