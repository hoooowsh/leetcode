package medium;

public class GameOfLife_289 {
    public static void main(String[] args) {

    }

    public static void gameOfLife(int[][] board) {
        // 0 -> 1 : 2
        // 1 -> 0 : 3
        // 0 -> 0 : 4
        // 1 -> 1 : 5
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[] result = count(board, i, j);
                setNum(board, i, j, result[0], result[1]);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int temp = board[i][j];
                if (temp == 2) {
                    board[i][j] = 1;
                } else if (temp == 3) {
                    board[i][j] = 0;
                } else if (temp == 4) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static int[] count(int[][] board, int row, int col) {
        int[] result = new int[2];
        int live = 0;
        int dead = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || i == row && j == col) {
                    continue;
                } else {
                    if (board[i][j] % 2 == 0) {
                        dead++;
                    } else {
                        live++;
                    }
                }
            }
        }
        result[0] = live;
        result[1] = dead;
        return result;
    }

    public static void setNum(int[][] board, int row, int col, int live, int dead) {
        if (board[row][col] == 1) {
            if (live < 2 || live > 3) {
                board[row][col] = 3;
            } else {
                board[row][col] = 5;
            }
        } else {
            if (live == 3) {
                board[row][col] = 2;
            } else {
                board[row][col] = 4;
            }
        }
    }
}
