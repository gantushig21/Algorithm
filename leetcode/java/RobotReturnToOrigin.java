import java.util.*;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') x--;
            else if (move == 'D') x++;
            else if (move == 'L') y--;
            else y++;
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        RobotReturnToOrigin problem = new RobotReturnToOrigin();

        Scanner input = new Scanner(System.in);

        System.out.println(problem.judgeCircle(input.next()));

        input.close();
    }
}