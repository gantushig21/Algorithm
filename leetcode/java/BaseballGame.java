import java.util.*;

public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> scores = new Stack<>();

        for (String op : ops) {
            if (op.equals("+")) {
                int head = scores.pop();
                int newHead = head + scores.peek();
                scores.push(head);
                scores.push(newHead);
            } else if (op.equals("D"))
                scores.push(2 * scores.peek());
            else if (op.equals("C"))
                scores.pop();
            else
                scores.push(Integer.parseInt(op));
        }

        int total = 0;
        while (!scores.isEmpty())
            total += scores.pop();

        return total;
    }

    public static void main(String[] args) {
        BaseballGame problem = new BaseballGame();

        // String[] list = new String[] { "5", "2", "C", "D", "+" };
        String[] list = new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" };

        System.out.println(problem.calPoints(list));
    }
}