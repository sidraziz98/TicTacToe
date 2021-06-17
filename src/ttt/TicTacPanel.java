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
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;


//this is the class containing the main method that must be run using gui that calls other classess for the game to play
//add all the pictures to the src of the project for the code to work correctly

public class TicTacPanel extends JPanel {

    GamePlay game = new GamePlay();
    JButton  AIvsAI;
    JLabel title, outcomeX, outcomeO, outcomeD;
    Boolean w = false;
    GridBagConstraints gbcOutcomeX, gbcOutcomeO, gbcOutcomeD;
    Color pink = new Color(243, 204, 207);
    Color grey = new Color(150, 150, 150);
    int xpos, ypos;
    int draw = 0;
   
 
   //constructor adds all jcomponents except the winning outcomes , x's and o's
    public TicTacPanel() throws Exception { 
        //add bg color
        setBackground(pink);
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        setLayout(new GridBagLayout());
        xpos = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        ypos = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        
        //add title gif
        java.net.URL title_URL = getClass().getResource("/Title.gif");
        ImageIcon imgIcon1 = new ImageIcon(title_URL);
        imgIcon1 = new ImageIcon(imgIcon1.getImage().getScaledInstance((int)(xpos * 0.40278), (int)(ypos * 0.12889), java.awt.Image.SCALE_DEFAULT));
        title = new JLabel(imgIcon1);
        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.insets = new Insets((int)(ypos * 0.022223), 0, 0, 0);
        gbcTitle.gridx = 0;
        gbcTitle.gridy = 0;
        gbcTitle.anchor = GridBagConstraints.NORTH;
        gbcTitle.weightx = 0.5;
        gbcTitle.weighty = 1.0;
        add(title, gbcTitle);

        //add outcome gif at end
        // if O wins
        java.net.URL finalo_URL = getClass().getResource("/finalo.gif");
        ImageIcon imgIcon3 = new ImageIcon(finalo_URL);
        imgIcon3 = new ImageIcon(imgIcon3.getImage().getScaledInstance((int)(xpos * 0.319445), (int)(ypos * 0.51112), java.awt.Image.SCALE_DEFAULT));
        outcomeO = new JLabel(imgIcon3);
        gbcOutcomeO = new GridBagConstraints();
        gbcOutcomeO.insets = new Insets((int)(ypos * 0.055556), 0, 0, 0);
        gbcOutcomeO.gridx = 0;
        gbcOutcomeO.gridy = 0;
        gbcOutcomeO.anchor = GridBagConstraints.CENTER;
        gbcOutcomeO.weightx = 0.5;
        gbcOutcomeO.weighty = 1.0;
        // if X wins
        java.net.URL finalx_URL = getClass().getResource("/finalx.gif");
        ImageIcon imgIcon4 = new ImageIcon(finalx_URL);
        imgIcon4 = new ImageIcon(imgIcon4.getImage().getScaledInstance((int)(xpos * 0.319445), (int)(ypos * 0.51112), java.awt.Image.SCALE_DEFAULT));
        outcomeX = new JLabel(imgIcon4);
        gbcOutcomeX = new GridBagConstraints();
        gbcOutcomeX.insets = new Insets(0, 0, 0, 0);
        gbcOutcomeX.gridx = 0;
        gbcOutcomeX.gridy = 0;
        gbcOutcomeX.anchor = GridBagConstraints.CENTER;
        gbcOutcomeX.weightx = 0.5;
        gbcOutcomeX.weighty = 1.0;
        // draw
        java.net.URL draw_URL = getClass().getResource("/draw.gif");
        ImageIcon imgIcon6 = new ImageIcon(draw_URL);
        imgIcon6 = new ImageIcon(imgIcon6.getImage().getScaledInstance((int)(xpos * 0.319445), (int)(ypos * 0.51112), java.awt.Image.SCALE_DEFAULT));
        outcomeD = new JLabel(imgIcon6);
        gbcOutcomeD = new GridBagConstraints();
        gbcOutcomeD.insets = new Insets(0, 0, 0, 0);
        gbcOutcomeD.gridx = 0;
        gbcOutcomeD.gridy = 0;
        gbcOutcomeD.anchor = GridBagConstraints.CENTER;
        gbcOutcomeD.weightx = 0.5;
        gbcOutcomeD.weighty = 1.0;

        //add AIvsAI button
        java.net.URL AIvsAI_URL = getClass().getResource("/AIvsAI.png");
        ImageIcon imgIcon2 = new ImageIcon(AIvsAI_URL);
        imgIcon2 = new ImageIcon(imgIcon2.getImage().getScaledInstance((int)(xpos * 0.104167), (int)(ypos * 0.063334), java.awt.Image.SCALE_DEFAULT));
         AIvsAI = new JButton("", imgIcon2);
         AIvsAI.setBorderPainted(false);
         AIvsAI.setContentAreaFilled(false);
         AIvsAI.setOpaque(false);
         AIvsAI.setBackground(new Color(0,0,0,0));
         AIvsAI.setBackground(new Color(0,0,0,0));
        GridBagConstraints gbcAIvsAI = new GridBagConstraints();
        gbcAIvsAI.insets = new Insets(0, 0, 6, 0);
        gbcAIvsAI.gridx = 0;
        gbcAIvsAI.gridy = 0;
        gbcAIvsAI.anchor = GridBagConstraints.SOUTH;
        gbcAIvsAI.weightx = 0.5;
        gbcAIvsAI.weighty = 1.0;
        add(AIvsAI, gbcAIvsAI);
        

        setVisible(true);
        //to allow the gui to work while the bg coding does its work
        Timer timer2 = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent f) {
                w = true;
                repaint();
                ((Timer) f.getSource()).stop();
            }
        });

        final Timer timerAIvsAI = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                game.display();
                draw++;
//                System.out.println(draw);
                if (game.currentPlayer == 1) {
                    game.BestChoice(1);
                    game.currentPlayer = 2;
                } else {
                    game.BestChoice(2);
                    game.currentPlayer = 1;
                }

                if (game.gameCheck() == true || (draw == 9 && game.gameCheck() == false)) {
                    
                    game.display();
                    timer2.start();
                    ((Timer) e.getSource()).stop();
                    
                }
            }
        });

        AIvsAI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             
                Object src = evt.getSource();
                if (src instanceof JButton) {
                    w = false ;
                    if (game.xWins == true) {
                        remove(outcomeX);
                    } else if (game.oWins == true) {
                        remove(outcomeO);
                    } else {
                        remove(outcomeD);
                    }
                    draw = 0;
                    game = new GamePlay();
                    for (int i = 0; i < 9; i++) {
                        repaint();
                        if (game.gameCheck() == false) {
                            timerAIvsAI.start();
                        }
                        if (game.gameCheck() == true) {
                            break;
                        }
                    }
                }
            }
        });

   }
    //paintComponent - this does the drawing and graphics
    //also adds the winning outcomes , x's and o's 
    public void paintComponent(Graphics page) {

        super.paintComponent(page);                            //to update panel
        if (w == false) {
            //add borders
            xpos = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            ypos = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            java.net.URL O_URL = getClass().getResource("/o.png");
            ImageIcon imgIconO = new ImageIcon(O_URL);
            Image O = imgIconO.getImage();
            java.net.URL X_URL = getClass().getResource("/x.png");
            ImageIcon imgIconX = new ImageIcon(X_URL);
            Image X = imgIconX.getImage();
            page.setColor(Color.white);
            page.fillRect(0, 0, xpos, (int) (ypos * 0.15556));
            //page.fillRect(0, (int) (ypos * 0.75556), xpos, (int)(ypos * 0.111111));
            page.fillRect(0, (int)(ypos * 0.7656), xpos, (int)(ypos * 2));
            xpos = (int)(xpos * 0.340278);
            ypos = (int)(ypos * 0.2223);
            
            //create game board - 2-by-2 parallel lines
            page.setColor(grey);
            //vertical lines
            page.fillRoundRect((int)(xpos * 1.285715), ypos, (int)(xpos * 0.0408164), (int)(ypos * 2.2), (int)(xpos * 0.0204082), (int)(ypos * 0.05));
            page.fillRoundRect((int)(xpos * 1.59184), ypos, (int)(xpos * 0.0408164), (int)(ypos * 2.2), (int)(xpos * 0.0204082), (int)(ypos * 0.05));
            //horizontal lines
            page.fillRoundRect(xpos, (int)(ypos * 1.7), (int)(xpos * 0.89796), (int)(ypos * 0.1), (int)(xpos * 0.0204082), (int)(ypos * 0.05));
            page.fillRoundRect(xpos, (int)(ypos * 2.45), (int)(xpos * 0.89796), (int)(ypos * 0.1), (int)(xpos * 0.0204082), (int)(ypos * 0.05));

            //convert data from array into grid
                
            if (game != null) {
                int mulx = (int)(xpos * 0.3129252);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (game.board[i][j] == 'x') {
                            //draw X
                            page.drawImage(X, (int)(xpos * 1.0734694) + j * mulx, (int)(ypos * 1.125) + i * mulx, (int)(xpos * 0.128572), (int)(ypos * 0.42), this);
                        } else if (game.board[i][j] == 'o') {
                            //draw O
                            page.drawImage(O, (int)(xpos * 1.0734694) + j * mulx, (int)(ypos * 1.15) + i * mulx,  (int)(xpos * 0.157143), (int)(ypos * 0.4), this);
                        }
                    }
                }
                page.setFont(new Font("Serif", Font.PLAIN, 40));
                page.setColor(Color.black);
                if (game.currentPlayer == 1) {
                    page.drawString("turn", (int)(xpos * 0.636735),(int)(ypos * 2.5) );
                } else {
                    page.drawString("turn", (int)(xpos * 2.17755) , (int)(ypos * 2.5));
                }
            }

            //player icons
            page.setFont(new Font("Serif", Font.PLAIN, 40));
            page.setColor(Color.black);
            //player1
            page.drawString("Player", (int)(xpos * 0.60204),(int)(ypos * 1.85) );
            page.drawImage(X, (int)(xpos * 0.63265), (int)(ypos * 1.925), (int)(xpos * 0.128572), (int)(ypos * 0.42), this);
            //player2
            page.drawString("Player", (int)(xpos * 2.132654), (int)(ypos * 1.85));
            page.drawImage(O,(int)(xpos * 2.14898) , (int)(ypos * 1.93), (int)(xpos * 0.157143), (int)(ypos * 0.4) , this);
            
        } else {
            setBackground(pink);
            setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
            int xpos = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            int ypos = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            page.setColor(Color.white);
            page.fillRect(0, 0, xpos,(int)(ypos * 0.15555));
            page.fillRect(0, (int)(ypos * 0.7656), xpos,(int)(ypos * 2 ));

            this.setLocation(0, 0);
            if (game.xWins == true) {
                add(outcomeX, gbcOutcomeX);
            }
            if (game.oWins == true) {
                add(outcomeO, gbcOutcomeO);
            }
            if (draw == 9 && game.gameCheck() == false) {
                add(outcomeD, gbcOutcomeD);
            }
            setVisible(true);
            revalidate();
        }
    }
    
    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setMaximumSize(DimMax);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().add(new TicTacPanel());
        frame.pack();
        frame.setVisible(true);

    }
}

