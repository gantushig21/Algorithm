import java.util.*;
import java.util.stream.*;

public class ShortestDistanceToACharacter {
    // public int[] shortestToChar(String S, char C) {
    // int[] answer = new int[S.length()];

    // Queue<Integer> q = new LinkedList<>();
    // for (int i = 0; i < S.length(); i++) {
    // if (S.charAt(i) == C) {
    // answer[i] = 1;
    // q.add(i);
    // }
    // }

    // while (!q.isEmpty()) {
    // int current = q.poll();
    // if (current + 1 < S.length() && answer[current + 1] == 0) {
    // answer[current + 1] = answer[current] + 1;
    // q.add(current + 1);
    // }
    // if (current - 1 >= 0 && answer[current - 1] == 0) {
    // answer[current - 1] = answer[current] + 1;
    // q.add(current - 1);
    // }
    // }

    // for (int i = 0; i < answer.length; i++)
    // answer[i]--;
    // return answer;
    // }

    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] answer = new int[n];
        int index = -n;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C)
                index = i;
            answer[i] = i - index;
        }

        index = 2 * n;
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == C)
                index = i;
            answer[i] = Math.min(answer[i], index - i);
        }

        return answer;
    }

    public static void main(String[] args) {
        ShortestDistanceToACharacter problem = new ShortestDistanceToACharacter();

        String S = "loveleetcode";
        char C = 'e';

        System.out.println(Arrays.toString(problem.shortestToChar(S, C)));
    }
}