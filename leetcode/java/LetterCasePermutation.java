import java.util.*;

public class LetterCasePermutation {
    // public List<String> letterCasePermutation(String S) {
    //     List<String> list = new ArrayList<>();
        
    //     int count = 1;
    //     List<Integer> indexes = new ArrayList<>();

    //     for (int i = 0; i < S.length(); i++) {
    //         if (Character.isLetter(S.charAt(i))) { 
    //             count *= 2;
    //             indexes.add(i);
    //         }
    //     }

    //     for (int i = 0; i < count; i++) {
    //         StringBuilder word = new StringBuilder(S);
    //         for (int j = 0; j < indexes.size(); j++) {
    //             char temp = word.charAt(indexes.get(j));
    //             if ((1 << j & i) > 0) word.setCharAt(indexes.get(j), (char) (temp < 91 ? temp + 32 : temp - 32));
    //         }
    //         list.add(word.toString());
    //     }

    //     return list;
    // }

    // public List<String> letterCasePermutation(String S) {
    //     if (S == null)
    //         return new LinkedList<>();

    //     Queue<String> queue = new LinkedList<>();
    //     queue.offer(S);

    //     for (int i = 0; i < S.length(); i++) {
    //         if (Character.isDigit(S.charAt(i))) continue;

    //         int size = queue.size();
    //         for (int j = 0; j < size; j++) {
    //             char[] current = queue.poll().toCharArray();

    //             current[i] = Character.toUpperCase(current[i]);
    //             queue.offer(String.valueOf(current));

    //             current[i] = Character.toLowerCase(current[i]);
    //             queue.offer(String.valueOf(current));
    //         }
    //     }

    //     return new LinkedList<>(queue);
    // }

    public List<String> letterCasePermutation(String S) {
        if (S == null)
            return new LinkedList<>();

        List<String> response = new LinkedList<>();
        DFS(0, response, S.toCharArray());

        return response;
    }

    public void DFS(int index, List<String> response, char[] word) {
        if (index == word.length) {
            response.add(String.valueOf(word));
            return;
        }

        if (Character.isDigit(word[index])) {
            DFS(index + 1, response, word);
            return;
        }
        
        word[index] = Character.toUpperCase(word[index]);
        DFS(index + 1, response, word);

        word[index] = Character.toLowerCase(word[index]);
        DFS(index + 1, response, word);
    }

    public static void main(String[] args) {
        LetterCasePermutation problem = new LetterCasePermutation();

        List<String> list = problem.letterCasePermutation("a1b2");

        for (String word : list)
            System.out.println(word);
    }
}