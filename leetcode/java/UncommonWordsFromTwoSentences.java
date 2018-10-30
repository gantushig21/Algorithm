import java.util.*;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();

        String[] words = (A + " " + B).trim().split("\\s+");
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        List<String> uncommon = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : map.entrySet())
            if (pair.getValue() == 1)
                uncommon.add(pair.getKey());

        return uncommon.toArray(new String[uncommon.size()]);
    }

    public static void main(String[] args) {
        UncommonWordsFromTwoSentences problem = new UncommonWordsFromTwoSentences();

        // String A = "this apple is sweet", B = "this apple is sour";
        String A = "apple apple", B = "banana";
        System.out.println(Arrays.toString(problem.uncommonFromSentences(A, B)));
    }
}