import java.util.*;

public class AverageOfLevelsInBinaryTree {
    Map<Integer, Detail> map = new HashMap<>();

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();

        DFS(root, 1);
        for (Detail detail : map.values())
            averages.add(detail.sum / detail.count);

        return averages;
    }

    public void DFS(TreeNode root, int level) {
        if (root == null)
            return;

        Detail detail = map.getOrDefault(level, new Detail());
        detail.sum += root.val;
        detail.count++;

        map.put(level, detail);

        DFS(root.left, level + 1);
        DFS(root.right, level + 1);
    }

    public class Detail {
        Double sum = 0.0;
        Double count = 0.0;
    }

    public void run() {
        TreeNode three = new TreeNode(3);
        three.left = new TreeNode(9);
        three.right = new TreeNode(20);
        three.right.left = new TreeNode(15);
        three.right.right = new TreeNode(7);

        System.out.println(Arrays.toString(averageOfLevels(three).toArray(new Double[0])));
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
        AverageOfLevelsInBinaryTree problem = new AverageOfLevelsInBinaryTree();

        problem.run();
    }
}