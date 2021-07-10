package com.leetcode.amazon;

// Top Amazon Questions
// tag:
public class TicTacToe {

    int[][] board;
    int[] players = new int[]{1, 2};
    int[][] dir = new int[][]{
            // horizontal
            {0, -1}, {0, 1},
            // vertical
            {-1, 0}, {1, 0},
            // diagonal
            {-1, -1}, {1, 1},
            // reverse diagonal
            {-1, 1}, {1, -1}
    };

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        board = new int[n][n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        // Time complexity: O(n)
        // Space complexity: O(n^2)

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return 0;
        }

        // Get player
        int p = players[(player + 1) % 2];

        // board
        board[row][col] = p;

        int max = 1;
        for (int i = 0; i < dir.length; i += 2) {
            // check horizontal
            // west 0
            // east 1

            // check vertical
            // north 2
            // south 3

            // check diagonal
            // northwest 4
            // southeast 5

            // check reverse diagonal
            // northeast 6
            // southwest 7

            max = Math.max(max, 1
                    + checkNum(row + dir[i][0], col + dir[i][1], p, dir[i])
                    + checkNum(row + dir[i + 1][0], col + dir[i + 1][1], p, dir[i + 1]));
        }

        if (max == board.length) {
            return p;
        }

        return 0;
    }

    private int checkNum(int row, int col, int player, int[] dir) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || dir == null || dir.length < 2
                || board[row][col] != player) {
            return 0;
        }

        return 1 + checkNum(row + dir[0], col + dir[1], player, dir);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            sb.append("|");
            for (int j = 0; j < board[0].length; j++) {
                switch (board[i][j]) {
                    case 1:
                        sb.append("X");
                        break;
                    case 2:
                        sb.append("O");
                        break;
                    case 0:
                    default:
                        sb.append(" ");
                        break;
                }
                sb.append("|");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);

        // Example 1
        int result = ticTacToe.move(0, 0, 1);
        result = ticTacToe.move(0, 2, 2);
        result = ticTacToe.move(2, 2, 1);
        result = ticTacToe.move(1, 1, 2);
        result = ticTacToe.move(2, 0, 1);
        result = ticTacToe.move(1, 0, 2);
        result = ticTacToe.move(2, 1, 1);
        System.out.println("=================");
        System.out.println(ticTacToe);
        System.out.println("=================");

        // Example 2
        ticTacToe = new TicTacToe(2);
        result = ticTacToe.move(0, 0, 2);
        result = ticTacToe.move(1, 1, 1);
        result = ticTacToe.move(0, 1, 2);
        System.out.println("=================");
        System.out.println(ticTacToe);
        System.out.println("=================");

        // Example 3
        ticTacToe = new TicTacToe(4);
        result = ticTacToe.move(0, 3, 1);
        result = ticTacToe.move(3, 3, 2);
        result = ticTacToe.move(3, 0, 1);
        result = ticTacToe.move(0, 0, 2);
        result = ticTacToe.move(2, 1, 1);
        result = ticTacToe.move(2, 2, 2);
        result = ticTacToe.move(1, 2, 1);
        System.out.println("=================");
        System.out.println(ticTacToe);
        System.out.println("=================");

        // Example 4
        ticTacToe = new TicTacToe(3);
        result = ticTacToe.move(0, 0, 1);
        result = ticTacToe.move(0, 1, 1);
        result = ticTacToe.move(0, 2, 1);
        System.out.println("=================");
        System.out.println(ticTacToe);
        System.out.println("=================");
    }
}

// Better solution
// Time complexity: O(1)
// Space complexity: O(n)
//    int[] rows;
//    int[] cols;
//    int diagonal;
//    int antiDiagonal;
//
//    public TicTacToe(int n) {
//        rows = new int[n];
//        cols = new int[n];
//    }
//
//    public int move(int row, int col, int player) {
//        int currentPlayer = (player == 1) ? 1 : -1;
//        // update currentPlayer in rows and cols arrays
//        rows[row] += currentPlayer;
//        cols[col] += currentPlayer;
//        // update diagonal
//        if (row == col) {
//            diagonal += currentPlayer;
//        }
//        //update anti diagonal
//        if (col == (cols.length - row - 1)) {
//            antiDiagonal += currentPlayer;
//        }
//        int n = rows.length;
//        // check if the current player wins
//        if (Math.abs(rows[row]) == n ||
//                Math.abs(cols[col]) == n ||
//                Math.abs(diagonal) == n ||
//                Math.abs(antiDiagonal) == n) {
//            return player;
//        }
//        // No one wins
//        return 0;
//    }