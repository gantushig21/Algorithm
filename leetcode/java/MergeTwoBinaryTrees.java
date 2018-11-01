import java.util.*;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    public void printTree(TreeNode t) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(t);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
            System.out.println(node.val);
        }
    }

    public void run() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        printTree(mergeTrees(t1, t2));
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
        MergeTwoBinaryTrees problem = new MergeTwoBinaryTrees();

        problem.run();
    }
}