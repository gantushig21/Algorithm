
public class NumberComplement {
    public int findComplement(int num) {
        return (Integer.highestOneBit(num) << 1) - num - 1;
    }

    public static void main(String[] args) {
        NumberComplement problem = new NumberComplement();

        System.out.println(problem.findComplement(5));
    }
}