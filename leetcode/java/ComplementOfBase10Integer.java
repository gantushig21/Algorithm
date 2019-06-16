import java.util.*;

public class ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;

        int i = 0;
        while (1 << i <= N)
            i++;

        return (1 << i) - 1 - N;
    }
    public static void main(String[] args) {
        ComplementOfBase10Integer problem = new ComplementOfBase10Integer();

        System.out.println(problem.bitwiseComplement(0));
    }
}