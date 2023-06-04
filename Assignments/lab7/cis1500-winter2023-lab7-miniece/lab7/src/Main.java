import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Get ready to play Tic Tac Toe!");

        boolean p1 = true;

        boolean gameEnded = false;
        while (!gameEnded) {
            clearBoard(board);
            if (p1) {
                System.out.println("Player 1, it's your turn.");
            } else {
                System.out.println("Player 2, it's your turn.");
            }

            char turn = '-';
            if (p1) {
                turn = 'x';
            } else {
                turn = 'o';
            }

            int row = 0;
            int column = 0;

            while (true) {
                System.out.print("Enter a row number (0, 1, or 2): ");
                row = keyboard.nextInt();
                System.out.print("Enter a column number (0, 1, or 2): ");
                column = keyboard.nextInt();

                if (row < 0 || column < 0 || row > 2 || column > 2) {
                    System.out.println("This position does not exist, try again.");
                } else if (board[row][column] != ' ') {
                    System.out.println("This spot is already filled.");
                } else {
                    break;
                }
            }
            board[row][column] = turn;

            if (playerWon(board) == 'x') {
                System.out.println("Player 1 has won!");
                gameEnded = true;
            } else if (playerWon(board) == 'o') {
                System.out.println("Player 2 has won!");
                gameEnded = true;
            } else {
                if (boardFull(board)) {
                    System.out.println("It's a tie, so you both lose.");
                    gameEnded = true;
                } else {
                    p1 = !p1;
                }
            }
        }
        clearBoard(board);
    }

    public static void clearBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(board[i][j]);
            }
            System.out.println();
        }
    }

    public static char playerWon(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0];
            }
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
                return board[0][j];
            }
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return board[0][0];
        }
        if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != ' ') {
            return board[2][0];
        }
        return ' ';
    }

    public static boolean boardFull(char[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}