public class AvailableCapturesForRook {
    public int search(char[][] board, int x, int y, int xPlus, int yPlus) {
        while (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != 'B') {
            if (board[x][y] == 'p') return 1;
            x += xPlus;
            y += yPlus;
        }
        return 0;
    }

    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == 'R') return search(board, i, j, -1, 0) + search(board, i, j, 0, 1) + 
                    search(board, i, j, 1, 0) + search(board, i, j, 0, -1);
        
        return 0;
    }
    public static void main(String[] args) {
        AvailableCapturesForRook solution = new AvailableCapturesForRook();

        char[][] board = new char[][]{
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', 'p', '.', '.', '.', '.'},
            {'.', '.', '.', 'R', '.', '.', '.', 'p'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', 'p', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        int answer = solution.numRookCaptures(board);

        System.out.println(answer);
    }
}