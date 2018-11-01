
public class IncreasingOrderSearchTree {
    TreeNode current;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = new TreeNode(0);

        current = newRoot;
        inorder(root);

        return newRoot.right;
    }

    public void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        node.left = null;
        current.right = node;
        current = node;
        inorder(node.right);
    }

    public void run() {
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        five.left = three;
        five.right = six;
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        three.left = two;
        three.right = four;
        TreeNode eight = new TreeNode(8);
        six.right = eight;
        TreeNode one = new TreeNode(1);
        two.left = one;
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        eight.left = seven;
        eight.right = nine;

        increasingBST(five);
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
        IncreasingOrderSearchTree problem = new IncreasingOrderSearchTree();

        problem.run();
    }
}