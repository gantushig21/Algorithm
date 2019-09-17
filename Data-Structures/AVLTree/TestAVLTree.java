public class TestAVLTree {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>(new Integer[] { 25, 20, 5 });

        System.out.print("After inserting 25, 20, 5: ");
        printTree(tree);
    }

    public static void printTree(BST tree) {
        System.out.print("\nInorder (sorted): ");
        tree.inorder();
    }
}