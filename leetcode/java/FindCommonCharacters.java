import java.util.*;

public class FindCommonCharacters {
    // public List<String> commonChars(String[] A) {
    //     List<String> result = new ArrayList<>();

    //     Map<Character, Integer> map = new HashMap<>();
    //     for (char ch : A[0].toCharArray())
    //         map.put(ch, map.getOrDefault(ch, 0) + 1);

    //     for (int i = 1; i < A.length; i++) 
    //         map = getMin(map, A[i].toCharArray());

    //     for (Character key : map.keySet()) {
    //         int value = map.get(key);
    //         for (int i = 0; i < value; i++)
    //             result.add(key + "");
    //     }

    //     return result;
    // }

    // public Map<Character, Integer> getMin(Map<Character, Integer> map, char[] word) {
    //     Map<Character, Integer> current = new HashMap<>();
    //     for (int i = 0; i < word.length; i++) 
    //         current.put(word[i], current.getOrDefault(word[i], 0) + 1);

    //     Map<Character, Integer> minMap = new HashMap<>();
    //     for (Character key: map.keySet()) {
    //         if (current.containsKey(key)) {
    //             minMap.put(key, Math.min(map.get(key), current.get(key)));
    //         }
    //     }

    //     return minMap;
    // }

    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();

        int[] minArr = new int[26];
        Arrays.fill(minArr, Integer.MAX_VALUE);

        for (String word : A) {
            int[] count = new int[26];
            for (char ch : word.toCharArray()) 
                count[ch - 97]++;

            for (int i = 0; i< 26; i++)
                minArr[i] = Math.min(minArr[i], count[i]);
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minArr[i]; j++) 
                result.add((char) (i + 97) + "");
        }

        return result;
    }

    public static void main(String[] args) {
        FindCommonCharacters problem = new FindCommonCharacters();

        String[] test1 = new String[]{"bella","label","roller"};
        List<String> answer = problem.commonChars(test1);
        System.out.println(Arrays.toString(answer.toArray(new String[answer.size()])));
    } 
}