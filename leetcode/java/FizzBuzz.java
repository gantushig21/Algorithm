import java.util.*;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        HashMap<Integer, String> divisors = new HashMap<Integer, String>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };

        for (int i = 1; i <= n; i++) {
            String str = "";
            for (Integer key : divisors.keySet())
                if (i % key == 0)
                    str += divisors.get(key);

            str = str.equals("") ? Integer.toString(i) : str;
            list.add(str);
        }

        return list;
    }

    public static void main(String[] args) {
        FizzBuzz problem = new FizzBuzz();

        List<String> list = problem.fizzBuzz(15);
        for (String element : list)
            System.out.println(element);
    }
}