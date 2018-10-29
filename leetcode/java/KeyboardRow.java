import java.util.*;

public class KeyboardRow {
    // public String[] findWords(String[] words) {
    // String[] rows = new String[] { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
    // int[] index = new int[26];
    // for (int i = 0; i < rows.length; i++) {
    // char[] letters = rows[i].toCharArray();
    // for (int j = 0; j < letters.length; j++)
    // index[letters[j] - 'a'] = i;
    // }
    // List<String> list = new ArrayList<>();

    // int i;
    // for (String word : words) {
    // char[] letters = word.toLowerCase().toCharArray();
    // for (i = 1; i < letters.length; i++)
    // if (index[letters[0] - 'a'] != index[letters[i] - 'a'])
    // break;

    // if (i == letters.length)
    // list.add(word);
    // }

    // return list.toArray(new String[list.size()]);
    // }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();

        for (String word : words)
            if (word.toLowerCase().matches("[qwertyuiop]+|[asdfghjkl]+|[zxcvbnm]+"))
                list.add(word);

        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        KeyboardRow problem = new KeyboardRow();

        String[] words = new String[] { "Hello", "Alaska", "Dad", "Peace" };

        System.out.println(Arrays.toString(problem.findWords(words)));
    }
}