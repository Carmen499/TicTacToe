package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static int row;
    public static int col;
    public static Scanner scan = new Scanner(System.in);
    public static char[][] board = new char[3][3];
    public static char turn = 'X';


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
        Play();

    }

    public static void Play() {
        boolean playing = true;
        PrintBoard();
        while (playing) {

            System.out.println("Please enter a row and a column, values must be between 1-3: ");

            try {
                row = scan.nextInt() - 1;   // starting the count from 1 and not 0
                col = scan.nextInt() - 1;
                board[row][col] = turn;
            } catch (Exception e) {
                System.out.println("Invalid Option, input must be an integer");
                scan.nextInt();
            }

            if (GameOver(row, col)) {
                playing = false;
                System.out.println("Game Over " + turn + " wins");
            }

            PrintBoard();
            if (turn == 'X')
                turn = 'O';
            else
                turn = 'X';
        }
    }

    public static void PrintBoard(){
        for(int i = 0; i < 3; i++) {
            System.out.println();
            for(int j = 0; j< 3; j++){
                if(j==0)                // This give me an "| " on the left had side when the loop starts from 0
                    System.out.print("| ");
                System.out.print(board[i][j] + " | ");

            }
        }
        System.out.println();

    }

    public static boolean GameOver (int rMove, int cMove){
        //Check HORIZONTAL WIN
        if(board[0][cMove] == board[1][cMove]
                && board[0][cMove] == board[2][cMove])
            return true;
        // Check  VERTICAL WIN
        if(board[rMove][0] == board[rMove][1]
                && board[rMove][0] == board[rMove][2])
            return true;

        // Check DIAGONAL WIN
        if(board[0][0] == board [1][1]
                && board [0][0] == board[2][2]
                && board [1][1] != '_')
            return true;
        if(board[0][2] == board[1][1]
                && board[0][2]== board[2][0]
                && board[1][1] != '_')
            return true;

        return false;
    }

}
