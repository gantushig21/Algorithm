import java.util.*;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        String[] splitted;
        int number, dotIndex;
        String key;
        for (String string : cpdomains) {
            splitted = string.split("\\s+");
            number = Integer.parseInt(splitted[0]);
            key = splitted[1];
            while (key != "") {
                Integer value = map.get(key);
                if (value != null)
                    map.put(key, value + number);
                else
                    map.put(key, number);
                dotIndex = key.indexOf(".");
                if (dotIndex >= 0)
                    key = key.substring(dotIndex + 1);
                else
                    key = "";
            }
        }

        List<String> ans = new ArrayList<>();
        Set<Map.Entry<String, Integer>> st = map.entrySet();
        for (Map.Entry<String, Integer> me : st)
            ans.add(me.getValue() + " " + me.getKey());

        return ans;
    }

    public static void main(String[] args) {
        SubdomainVisitCount problem = new SubdomainVisitCount();

        // String[] test = new String[] { "9001 discuss.leetcode.com" };
        String[] test = new String[] { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };

        System.out.println(Arrays.toString(problem.subdomainVisits(test).toArray()));
    }
}