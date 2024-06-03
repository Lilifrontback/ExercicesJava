//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
      // System.out.println("Where do you want to play (1-9)?");

        printBoard(board);

        while (true) {
            playerTurn(board, scanner);
            if (isGameFinished(board)){
                break;
            };
            printBoard(board);
            computerTurn(board);
            if (isGameFinished(board)){
                break;
            };

            printBoard(board);
        }

    }

    private static boolean hasConstantWon (char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) ) {
            return true;

        }

    return false;



    }

    private static boolean isGameFinished(char[][] board) {
        if (hasConstantWon(board, 'X')) {
            printBoard(board);

            System.out.println("Player wins!");
            return true;
        }
        if (hasConstantWon(board, 'O')) {
            printBoard(board);

            System.out.println("Computer wins!");
            return true;
        }

        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j <board[i].length; j++) {
                if(board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("Game ended in a tie !");

        return true;
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) {

                break;
            }
        }
        System.out.println("Computer choose " + computerMove);

        placeMove(board, Integer.toString(computerMove), 'O');
    }

    private static boolean isValidMove (char [][] board, String position) {

        switch (position) {
            case "1":
               return board[0][0] == ' ';
            case "2":
                return board[0][1] == ' ';
            case "3":
                return board[0][2] == ' ';
            case "4":
                return board[1][0] == ' ';
            case "5":
                return board[1][1] == ' ';
            case "6":
                return board[1][2] == ' ';
            case "7":
                return board[2][0] ==' ';
            case "8":
                return board[2][1] == ' ';
            case "9":
                return board[2][2] == ' ';
            default:
                return false;
        }
    }

    private static void playerTurn(char[][] board, Scanner scanner) {
        String userInput;
        while (true){
            System.out.println("Where do you want to play (1-9)?");
            userInput = scanner.nextLine();
            if (isValidMove(board, userInput)){
                break;
            } else {
                System.out.println(userInput + " is not a valid move");

            }
       // System.out.println(userInput);

        }

        placeMove(board, userInput, 'X');

    }

    private static void placeMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}