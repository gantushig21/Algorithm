public class Trie {
    static final int ALPHABET_SIZE = 26;
    static TrieNode root;

    static class TrieNode {
        public TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        public boolean isEndOfWord;

        public TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < children.length; i++)
                children[i] = null;
        }
    }

    static void insert(String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null)
                current.children[index] = new TrieNode();

            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    static boolean search(String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null)
                return false;
            current = current.children[index];
        }

        return current != null && current.isEndOfWord;
    }

    static TrieNode delete(String key) {
        return delete(root, key, 0);
    }

    static boolean hasChild(TrieNode node) {
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null)
                return true;
        }
        return false;
    }

    static TrieNode delete(TrieNode node, String key, int depth) {
        if (node == null)
            return null;

        if (depth == key.length()) {
            node.isEndOfWord = false;

            if (!hasChild(node))
                node = null;

            return node;
        }

        int index = key.charAt(depth) - 'a';
        node.children[index] = delete(node.children[index], key, depth + 1);

        if (!hasChild(node) && !node.isEndOfWord)
            root = null;

        return root;
    }

    public static void main(String[] args) {
        String[] keys = { "the", "a", "there", "answer", "any", "by", "bye", "their", "hero", "heroplane" };

        String[] outputs = { "Not present in trie", "Present in trie" };

        root = new TrieNode();

        for (String key : keys)
            insert(key);

        delete("heroplane");
        String[] tests = { "the", "these", "their", "thaw", "hero" };
        for (String word : tests) {
            int index = search(word) ? 1 : 0;
            System.out.println(word + " --- " + outputs[index]);
        }

    }
}