
public class GoatLatin {
    public String toGoatLatin(String S) {
        String ma = "ma";
        String answer = "";
        for (String word : S.split(" ")) {
            char letter = word.charAt(0);

            if (!isVowel(letter))
                word = word.substring(1) + letter;

            ma += "a";
            answer += " " + word + ma;
        }

        return answer.substring(1);
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U';
    }

    public static void main(String[] args) {
        GoatLatin problem = new GoatLatin();

        // String S = "I speak Goat Latin";
        String S = "The quick brown fox jumped over the lazy dog";
        System.out.println(problem.toGoatLatin(S));
    }
}