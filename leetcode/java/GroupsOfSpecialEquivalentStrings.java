import java.util.*;

public class GroupsOfSpecialEquivalentStrings {
    // public String sortString(String part) {
    // char[] letters = part.toCharArray();

    // Arrays.sort(letters);

    // return new String(letters);
    // }

    // public String getSortedStrings(String word) {
    // String even = "";
    // String odd = "";
    // for (int i = 0; i < word.length(); i++) {
    // if (i % 2 == 0)
    // even += word.charAt(i);
    // else
    // odd += word.charAt(i);
    // }

    // return sortString(odd) + sortString(even);
    // }

    // public int numSpecialEquivGroups(String[] A) {
    // Set<String> set = new HashSet<String>();

    // for (int i = 0; i < A.length; i++)
    // set.add(getSortedStrings(A[i]));

    // return set.size();
    // }

    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<String>();

        for (String s : A) {
            int[] count = new int[52];
            for (int i = 0; i < s.length(); i++)
                count[s.charAt(i) - 'a' + 26 * (i % 2)]++;

            set.add(Arrays.toString(count));
        }

        return set.size();
    }

    public static void main(String[] args) {
        // String[] A = new String[] { "abc", "acb", "bac", "bca", "cab", "cba" };
        String[] A = new String[] { "abcd", "cdab", "adcb", "cbad" };

        GroupsOfSpecialEquivalentStrings problem = new GroupsOfSpecialEquivalentStrings();

        System.out.println(problem.numSpecialEquivGroups(A));
    }
}