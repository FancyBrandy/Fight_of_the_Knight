/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
//import statement
import java.awt.Color;
/**
 *
 * @author Danqing Chen
 */
public class Board {
    // class body
    Knight[][] board;
    private int boardSize;
    boolean turn=true;// indicating that it is the turn of the white knight

    /**
 * constructor of the board class, 
 * it takes a size parameter and create a board based on the size
 * @param  boardSize: int
 * @return: constructor
 */
    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new Knight[this.boardSize][this.boardSize];
        for (int i = 0; i < this.boardSize; ++i) {
            for (int j = 0; j < this.boardSize; ++j) {
                if (i==0&&j==0){
                    board[i][j]=new Black(Color.BLACK);
                   board[i][j].click=0;
                }else if(i==0&&j==(boardSize-1)){
                    board[i][j]=new White(Color.WHITE);
                    board[i][j].click=0;
                }else if(i==(boardSize-1)&&j==0){
                    board[i][j]=new White(Color.WHITE);
                    board[i][j].click=0;
                }else if(i==(boardSize-1)&&j==(boardSize-1)){
                    board[i][j]=new Black(Color.BLACK);
                    board[i][j].click=0;
                }else{
                    board[i][j]=new Unoccupied(Color.GRAY);
                    board[i][j].click=1;
                }
            }
        }
    }
    /**
 * to see if the White knight won or not
 * @param: none
 * @return: a boolean value indicating whether the white knight has won or not
 */
    public boolean White_win()
    {
         for (int i = 0; i < this.boardSize; i++) {
            for(int j=0;j<this.boardSize-3;j++)
            {
                if(board[i][j] instanceof White){
                    if((board[i][j+1] instanceof White)&&(board[i][j+2] instanceof White)&&(board[i][j+3] instanceof White)){
                       
                    return true;
                }
                }
            }
        }
         for (int i = 0; i < this.boardSize; i++) {
            for(int j=0;j<this.boardSize-3;j++)
            {
                if(board[j][i] instanceof White){
                    if((board[j+1][i] instanceof White)&&(board[j+2][i] instanceof White)&&(board[j+3][i] instanceof White)){
                        
                    return true;
                }
                }
            }
        }
         return false;
    }
        /**
 * to see if the Black knight won or not
 * @param: none
 * @return: a boolean value indicating whether the Black knight has won or not
 */

     public boolean Black_win()
    {
        
         for (int i = 0; i < this.boardSize; ++i) {
            for(int j=0;j<this.boardSize-3;j++)
            {
                if(board[i][j] instanceof Black){
                    if((board[i][j+1] instanceof Black)&&(board[i][j+2] instanceof Black)&&(board[i][j+3] instanceof Black)){
                    return true;
                }
                }
            }
        }
         for (int i = 0; i < this.boardSize; ++i) {
            for(int j=0;j<this.boardSize-3;j++)
            {
                if(board[j][i] instanceof Black){
                    if((board[j+1][i] instanceof Black)&&(board[j+2][i] instanceof Black)&&(board[j+3][i] instanceof Black)){
                    return true;
                }
                }
            }
        }
         return false;
    }
         /**
 * to see if the board is full or not
 * @param: none
 * @return: a boolean value indicating whether the board is full or not
 */
    public boolean isFull()
    {
         for (int i = 0; i < this.boardSize; ++i) {
            for(int j=0;j<this.boardSize;j++)
            {
                if(board[i][j] instanceof Unoccupied)
                    return false;
            }
          }
         return true;
    }
    
    
        /**
 * to see if the game is over or not
 * the game is over when one of the following 3 senerio happens:
 * 1.white knight wins, 2. black knight wins, 3. the board is full
 * @param: none
 * @return: a boolean value indicating whether the game is over or not
 */
     
    public boolean isOver()//the game is over when either side wins or whent all of the fields are being occupied
    {
        if (White_win())
            return true;
        else if(Black_win())
            return true;
        else if (isFull())
        {
           return true;
        }else
            return false;
   
    }
        /**
 * get the size of the board
 * @param: none
 * @return: an integer indicating the size of the board
 */
    public int getBoardSize()
    {
        return boardSize;
    }
    
}
