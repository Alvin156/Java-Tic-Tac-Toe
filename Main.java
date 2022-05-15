import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
        boolean turn = true;
        char letter;
        int row = 0;
        int column;

        while (true) {
            printBoard(board);

            if (isWinner(board, 'X')) {
                System.out.println("X wins!");
                break;
            } else if (isWinner(board, 'O')) {
                System.out.println("O wins");
                break;
            }

            if (turn) letter = 'X';
            else letter = 'O';

            Scanner scanner = new Scanner(System.in);
            System.out.println("Player: " + letter + ".");
            System.out.print("Enter your position: ");
            String userInput = scanner.nextLine();

            char _userRow = userInput.charAt(0);

            if (_userRow == 'A') row = 0;
            else if (_userRow == 'B') row = 1;
            else if (_userRow == 'C') row = 2;

            column = Integer.parseInt((String.valueOf(userInput.charAt(1)))) - 1;

            if (!(board[row][column] == ' ')) {
                System.out.println("That position is already taken.");
                continue;
            }

            board[row][column] = letter;

            turn = !turn;
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + " | " +  board[0][1] + " | " + board[0][2]);
        System.out.println("---------");
        System.out.println(board[1][0] + " | " +  board[1][1] + " | " + board[1][2]);
        System.out.println("---------");
        System.out.println(board[2][0] + " | " +  board[2][1] + " | " + board[2][2]);
    }

    private static boolean isWinner(char[][] board, char letter) {

        if ((board[0][0] == letter && board[0][1] == letter && board[0][2] == letter) ||
            (board[1][0] == letter && board[1][1] == letter && board[1][2] == letter) ||
            (board[2][0] == letter && board[2][1] == letter && board[2][2] == letter) ||

            (board[0][0] == letter && board[1][0] == letter && board[2][0] == letter) ||
            (board[0][1] == letter && board[1][1] == letter && board[2][1] == letter) ||
            (board[0][2] == letter && board[1][2] == letter && board[2][2] == letter) ||

            (board[0][0] == letter && board[1][1] == letter && board[2][2] == letter) ||
            (board[0][2] == letter && board[1][1] == letter && board[2][0] == letter)) {
            return true;
        }
        return false;
    }
}
