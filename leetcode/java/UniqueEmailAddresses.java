import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        String local, domain;
        int plus, at;
        for (String email : emails) {
            at = email.indexOf("@");
            domain = email.substring(at);
            local = email.substring(0, at).replaceAll("\\.", "");

            plus = local.indexOf("+");
            if (plus > -1)
                local = local.substring(0, plus);

            set.add(local + domain);
        }

        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = new String[] { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com" };

        UniqueEmailAddresses problem = new UniqueEmailAddresses();

        System.out.println(problem.numUniqueEmails(emails));
    }
}