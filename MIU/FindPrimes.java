import java.util.*;

public class FindPrimes {
    static int primeCount(int start, int end) {
        int count = 0;
        for (int number = start; number <= end; number++) {
            boolean isPrime = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) 
                count++;
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt(), b = input.nextInt();

        int answer = primeCount(a, b);

        System.out.println("Count => " + answer);
        input.close();
    }
}