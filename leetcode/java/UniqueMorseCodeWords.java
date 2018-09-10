import java.util.*;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();

        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
            "....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."};

        for (String word: words) {
            String morseOfWord = "";
            for (char letter: word.toCharArray()) 
                morseOfWord += morse[letter - 'a'];
            set.add(morseOfWord);
        }

        return set.size();
    }

    public static void main(String[] args) {    
        UniqueMorseCodeWords problem = new UniqueMorseCodeWords();

        String[] words = new String[]{"gin", "zen", "gig", "msg"};

        System.out.println(problem.uniqueMorseRepresentations(words));
    }
}