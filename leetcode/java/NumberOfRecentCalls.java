import java.util.*;

public class NumberOfRecentCalls {
    class RecentCounter {
        private Queue<Integer> queue = new LinkedList<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            queue.add(t);
            while (queue.peek() < t - 3000)
                queue.remove();

            return queue.size();
        }
    }

    public void run() {
        int[] arr = new int[] { 1, 100, 3001, 3002 };

        RecentCounter recentCounter = new RecentCounter();
        for (int num : arr)
            System.out.println(recentCounter.ping(num));
    }

    public static void main(String[] args) {
        NumberOfRecentCalls problem = new NumberOfRecentCalls();
        problem.run();
    }
}