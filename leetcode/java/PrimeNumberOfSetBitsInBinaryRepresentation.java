
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19 };
        boolean[] isPrime = new boolean[20];
        for (int prime : primes)
            isPrime[prime] = true;

        int answer = 0;
        for (int i = L; i <= R; i++)
            answer += isPrime[Integer.bitCount(i)] ? 1 : 0;

        return answer;
    }

    public static void main(String[] args) {
        PrimeNumberOfSetBitsInBinaryRepresentation problem = new PrimeNumberOfSetBitsInBinaryRepresentation();

        // System.out.println(problem.countPrimeSetBits(10, 15));
        System.out.println(problem.countPrimeSetBits(6, 10));
    }
}