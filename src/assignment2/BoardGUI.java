/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
// import statements
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;    
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * @author      Danqing Chen <tutu990329 @ gmail.com>

 */

public class BoardGUI {
    public Board board;
    private JPanel boardPanel;
    private JButton[][] buttons;
    private int x1, y1;
    private int x2,y2 ;// starting and ending position of the clicking
    public JFrame frame;
    private int boardSize;
    private boolean Click_start=true;
 
    public BoardGUI(int boardSize) {// creating a new board
         // class body
        board = new Board(boardSize);
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(board.getBoardSize(), board.getBoardSize()));
        buttons = new JButton[board.getBoardSize()][board.getBoardSize()];
        for (int i = 0; i < board.getBoardSize(); ++i) {
            for (int j = 0; j < board.getBoardSize(); ++j) {
                JButton button = new JButton();
                button.addActionListener(new ButtonListener(i, j));
                button.setPreferredSize(new Dimension(80, 40));
                buttons[i][j] = button;
                boardPanel.add(button);
                if(board.board[i][j] instanceof White){
                    button.setBackground(Color.WHITE);
                    if(board.board[i][j].click==0)
                    {
                        button.setText("click");
                    }else
                    {
                        button.setText("");
                    }
                }else if(board.board[i][j] instanceof Black){
                    button.setBackground(Color.BLACK);
                      if(board.board[i][j].click==0)
                    {
                        button.setText("click");
                    }else
                    {
                        button.setText("");
                    }
                }
                else
                {
                    button.setBackground(Color.GRAY);
                    button.setText("");
                }
            }
        }
    }
    /**
 * refreshing the board                    
 * @param  none         (3)
 * @return none
 */

    public void refresh() {
        for (int i = 0; i < board.getBoardSize(); ++i) {
            for (int j = 0; j < board.getBoardSize(); ++j) {
                JButton button = buttons[i][j];
                
                if (board.board[i][j] instanceof White) {
                    button.setBackground(Color.WHITE);
                       if(board.board[i][j].click==0)
                    {
                        button.setText("click");
                    }else
                    {
                        button.setText("");
                    }
                } else if (board.board[i][j] instanceof Black){
                    button.setBackground(Color.BLACK);
                     if(board.board[i][j].click==0)
                    {
                        button.setText("click");
                    }else
                    {
                        button.setText("");
                    }
                }
                else
                { button.setBackground(Color.GRAY);
                    button.setText("");
                }
            }
}
        if (board.isOver()) {
            
           if (board.White_win())
           {
               JOptionPane.showMessageDialog(frame,
                "Game is over, White Knight won! ");
                       
           }
           else if(board.Black_win())
           {
               JOptionPane.showMessageDialog(frame,
                "Game is over, Black Knight won! ");
                     
           }
           else if(board.isFull())
              {
               JOptionPane.showMessageDialog(frame,
                "Game is over, no more field, it is a tie ");
           }    
        }
    }
   
/**
 * return boardPanel
 * @param: none    
 * @return none
 */
    public JPanel getBoardPanel() {
        return boardPanel;
    }
    


    class ButtonListener implements ActionListener {
        // class body

        private int x, y;
        
        /**
 * constructor
 * @param  x,y: integer representing the position of the button          (3)
 * @return constructor
 */

        public ButtonListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

            /**
 * event listener to handle the click event
 * @param  none
 * @return none
 */
        @Override
        public void actionPerformed(ActionEvent e) {
              
            if (board.turn==true)// it is the White knight's turn 
            {
                if(!board.isOver()&&Click_start&& board.board[x][y] instanceof White&& board.board[x][y].click==0)// we choose which one to move
                {                                                                     // and we can only move the white one
                    Click_start=!Click_start;
                    x1=x;
                    y1=y;
                   // after this it cannot be clicked
                    
                }else if(!board.isOver()&&!Click_start&& board.board[x][y] instanceof Unoccupied)
                {
                    
                    Click_start=!Click_start; // next time we will have to choose the one to move
                    x2=x;
                    y2=y;
                    if(((Math.abs(x2-x1)==1)&&(Math.abs(y2-y1)==2))||((Math.abs(x2-x1)==2)&&(Math.abs(y2-y1)==1)))
                    {
                        board.board[x1][y1] = new White(Color.WHITE);
                        board.board[x2][y2] = new White(Color.WHITE);
                        board.turn=!board.turn;
                     
                         board.board[x1][y1].click=1;
                    }
                 }
            }else {
                if(!board.isOver()&&Click_start&& board.board[x][y] instanceof Black&& board.board[x][y].click==0)// we choose which one to move
                {                                                                     // and we can only move the white one
                    Click_start=!Click_start;
                    x1=x;
                    y1=y;
                }else if(!board.isOver()&&!Click_start&& board.board[x][y] instanceof Unoccupied)
                {
                    Click_start=!Click_start; // next time we will have to choose the one to move
                    x2=x;
                    y2=y;
                    if(((Math.abs(x2-x1)==1)&&(Math.abs(y2-y1)==2))||((Math.abs(x2-x1)==2)&&(Math.abs(y2-y1)==1)))
                    {
                        board.board[x1][y1] = new Black(Color.BLACK);
                        board.board[x2][y2] = new Black(Color.BLACK);
                        board.turn=!board.turn;
                         board.board[x1][y1].click=1;
                    }
                 }
            }
                refresh();
            }
        }
    
}
    

    

