/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt;
import java.util.*;
/**
 *
 * @author Sidra Aziz 14809
 */
//this class makes the two AI agents compete with eachohter
//the result will always be draw becuase the agents use a similar technique to search for the path to be taken
//axcept that alphaBeta is faster 
public class GamePlay {

    char[][] board = new char[3][3];
    int currentPlayer;
    int indexI = 0;
    int indexj = 0;
    AlphaBeta a = new AlphaBeta(); //calls minimax agent
    MiniMax m = new MiniMax();     //calls alphaBeta agent
    Boolean xWins, oWins;
   
    //sets the board and randomly chooses either of the AI agents for the first turn 
    GamePlay() {
        xWins = false;
        oWins = false;
       
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                board[i][j] = ' ';
          
            }
        }

        double x = Math.random();
        System.out.println("x is "+x);
        if (x < 0.5) {
            currentPlayer = 1;                                       //alphabeta
        } else {
            currentPlayer = 2;                                         //minimax
        }
   

    }
    
    //checks if x has won the game xwins = true ;
    //checks if o has won the game owins = true ;
   
    public boolean gameCheck() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == 'x' && board[i][1] == 'x' && board[i][2] == 'x') {
                xWins = true;
                return true;
            }
            if (board[i][0] == 'o' && board[i][1] == 'o' && board[i][2] == 'o') {
                oWins = true;
                return true;
            }
            if (board[0][i] == 'x' && board[1][i] == 'x' && board[2][i] == 'x') {
                xWins = true;
                return true;
            }
            if (board[0][i] == 'o' && board[1][i] == 'o' && board[2][i] == 'o') {
                oWins = true;
                return true;
            }
        }

        if (board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x') {
            xWins = true;
            return true;
        }
        if (board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o') {
            oWins = true;
            return true;
        }
        if (board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x') {
            xWins = true;
            return true;
        }
        if (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o') {
            oWins = true;
            return true;
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    System.out.print("_ ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    //calls upon either minimax or alphabeta according to their turns
    
    public void BestChoice(int x) {
        if (x == 1) { //for alphabetas turn
            int max = -100000;
            indexI = 0;
            indexj = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'x';
                        int score = a.alphabeta(board, 0, 2, -100000, 100000);
                        board[i][j] = ' ';
                        if (score > max) {
                            max = score;
                            indexI = i;
                            indexj = j;
                        } else if (score == max) {
                            double a = Math.random();
                            if (a < 0.5) {
                                max = score;
                                indexI = i;
                                indexj = j;
                            }
                        }
                    }
                }
            }
            board[indexI][indexj] = 'x';
        } else { //for minimax's turn
            int max = -100000;
            indexI = 0;
            indexj = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'o';
                        int score = m.minimax(board, 0, 2);
                        board[i][j] = ' ';
                        if (score > max) {
                            max = score;
                            indexI = i;
                            indexj = j;
                        } else if (score == max) {
                            double a = Math.random();
                            if (a < 0.5) {
                                max = score;
                                indexI = i;
                                indexj = j;
                            }
                        }
                    }
                }
            }
            board[indexI][indexj] = 'o';
        }
    }

//    public static void main(String[] args) {
//
//    }
}
