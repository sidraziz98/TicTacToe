/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt;

/**
 *
 * @author Sidra Aziz 14809
 */

//creates an AI agent using MiniMax Algorithm 


public class MiniMax {


//returns 1 if the player wins, 2 if it looses , 3 if the game draws, 4 if the game should continue    
public int checkWin(char[][] board){

        for(int i = 0 ; i < 3 ; i++) {
            if (board[i][0] == 'x' && board[i][1] == 'x' && board[i][2] == 'x' )
                return 2 ;
            if (board[i][0] == 'o' && board[i][1] == 'o' && board[i][2] == 'o' )
                return 1 ;
            if (board[0][i] == 'x' && board[1][i] == 'x' && board[2][i] == 'x' )
                return 2 ;
            if (board[0][i] == 'o' && board[1][i] == 'o' && board[2][i] == 'o' )
                return 1 ;
        }

        if (board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x' )
            return 2 ;
        if (board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o' )
            return 1 ;
        if (board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x' )
            return 2 ;
        if (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o' )
            return 1 ;

        for(int i = 0 ; i < 3 ; i++) {              //continue if blank anywhere
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return 4 ;
            }
        }
        return 3 ;                                  //draw
    }

  //backbone of the algorithm, uses recursion 
  //hueristic where win = 10 , loose = -10 , draw = 0 ;
  //uses the character o
    public int minimax(char[][] board , int depth , int turn ) {

        int winner = checkWin(board);
        if (winner != 4) {
            if (winner == 1)
                return 10;
            if (winner == 2)
                return -10;
            else return 0;
        } else {
            if (turn == 1) {
                int max = -100000;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                       if (board[i][j] == ' ') {
                           board[i][j] = 'o' ;
                           int score = minimax(board , depth + 1 , 2) ;
                           board[i][j] = ' ' ;
                           if (score > max)
                               max = score ;
                       }
                    }
                }
                return max ;
            }
            else {
                int min = 100000 ;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == ' ') {
                            board[i][j] = 'x' ;
                            int score = minimax(board , depth + 1 , 1) ;
                            board[i][j] = ' ' ;
                            if (score < min)
                                min = score ;
                        }
                    }
                }
                return min ;

            }
        }
    }

}
