import java.util.Scanner;

public class Main {

    static int[][] board = new int[4][4];

    public static void main(String[] args) {

        createBoard();
        if (solveBoard(board)) {
            System.out.println("\n\nSolution->");
            printBoard(board);
        } else {
            System.out.println("Invalid board input!");
        }
    }

    public static boolean solveBoard(int[][] board) {
        for (int row=0;row<board.length;row++) {
            for (int col=0;col<board[row].length;col++) {
                if (board[row][col] == 0) {
                    for (int num=1;num<=4;num++) {
                        if (isValidMove(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveBoard(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidMove(int[][] board, int row, int col, int num) {
        for (int i=0;i<board.length;i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int sr = row - row % 2;
        int sc = col - col % 2;

        for (int i=sr;i<sr+2;i++) {
            for (int j=sc;j<sc+2;j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void createBoard() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter SUDOKU numbers (enter ZERO -> '0' for blanks)");
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++) {
                board[i][j] = in.nextInt();
            }
        }
    }

    public static void printBoard(int[][] board) {
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}