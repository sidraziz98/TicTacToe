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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TTTProject extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    //JFrame frame;
    //JLabel label;
    GamePlay game;
    JLabel lizard;
    JButton[] letters;
    JPanel letPanel,panel;
    JLabel label,lComment,lWrong;
    JLabel chance1,chance2,chance3,chance4,chance5;
    
//    TTTProject(){
//        
//        frame = new JFrame("Tic Tac Toe");
//        frame.getContentPane();
//        frame.setSize(1000,1000);
//        label = new JLabel("Tic Tac Toe");
//        label.setBounds(50, 50, 500, 500);
//        
//        frame.add(label);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
    
    public TTTProject() {

        setSize(1450, 1080);
        setTitle("HangKali Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setBackground(new Color(172, 225, 175));
        pane.setLayout(new GridBagLayout());
        
        //game play
        game = new GamePlay();
        
//        //add comments
//        lComment = new JLabel("<HTML><FONT SIZE=+2><B>Let's Get It!!</B>");
//        
//        GridBagConstraints gbcComment = new GridBagConstraints();//position
//        gbcComment.gridx = 0;
//        gbcComment.gridy = 0;
//        gbcComment.anchor = GridBagConstraints.NORTHWEST;
//        gbcComment.insets = new Insets(320, 230, 0, 0);
//        pane.add(lComment, gbcComment);
//
//        //add LIZARD
//        ImageIcon imgIcon1 = new ImageIcon("/Users/sidra/Documents/Documents now/NetBeansProjects/HangKali/src/aminations.gif");
//        ImageIcon imgIcon2 = new ImageIcon(imgIcon1.getImage().getScaledInstance(400,290, java.awt.Image.SCALE_DEFAULT));
//        lizard = new JLabel(imgIcon2);
//        
//        GridBagConstraints gbcLiz = new GridBagConstraints();//position
//        gbcLiz.insets = new Insets(120, 70, 0, 0);
//        gbcLiz.gridx = 0;
//        gbcLiz.gridy = 0;
//        gbcLiz.anchor = GridBagConstraints.NORTHWEST;
//        gbcLiz.weightx = 0.5;
//        gbcLiz.weighty = 1.0;
//        pane.add(lizard, gbcLiz);
//
//        //add Chances Images(X) to Panel
//        ImageIcon imgIcon3 = new ImageIcon("/Users/sidra/Documents/Documents now/NetBeansProjects/HangKali/src/3.png");
//        ImageIcon imgIcon4 = new ImageIcon(imgIcon3.getImage().getScaledInstance(70, 70, java.awt.Image.SCALE_DEFAULT));
//        chance1 = new JLabel(imgIcon4);
//        chance2 = new JLabel(imgIcon4);
//        chance3 = new JLabel(imgIcon4);
//        chance4 = new JLabel(imgIcon4);
//        chance5 = new JLabel(imgIcon4);
//
//        JPanel chance = new JPanel(new GridBagLayout());
//        chance.setBackground(new Color(172, 225, 175));
//        
//        GridBagConstraints gbcChance = new GridBagConstraints();//position
//        gbcChance.gridx = 0;
//        gbcChance.gridy = 0;
//        chance.add(chance1, gbcChance);
//        gbcChance.gridx = 1;
//        gbcChance.gridy = 0;
//        chance.add(chance2, gbcChance);
//        gbcChance.gridx = 2;
//        gbcChance.gridy = 0;
//        chance.add(chance3, gbcChance);
//        gbcChance.gridx = 3;
//        gbcChance.gridy = 0;
//        chance.add(chance4, gbcChance);
//        gbcChance.gridx = 4;
//        gbcChance.gridy = 0;
//        chance.add(chance5, gbcChance);
//
//        //add CHANCES Panel
//        GridBagConstraints gbcCH = new GridBagConstraints();//position
//        gbcCH.gridx = 0;
//        gbcCH.gridy = 0;
//        gbcCH.insets = new Insets(0, 150, 100, 0);
//        gbcCH.anchor = GridBagConstraints.SOUTHWEST;
//        pane.add(chance, gbcCH);
//
//        //add Keyboard to Panel
//        letPanel = new JPanel();
//        letPanel.setLayout(new GridBagLayout());
//        letPanel.setBackground(new Color(172, 225, 175));
//
//        ImageIcon imgIcon7 = new ImageIcon("/Users/sidra/Documents/Documents now/NetBeansProjects/HangKali/src/5.jpg");
//        ImageIcon imgIcon8 = new ImageIcon(imgIcon7.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_DEFAULT));
//        letters = new JButton[26];
//        int i = 0;
//        for (char c = 'A'; c <= 'Z'; c++, i++) {
//            letters[i] = new JButton("<HTML><FONT SIZE=+5><FONT COLOR = WHITE><B>" + c + "</B>",imgIcon8);
//            letters[i].setHorizontalTextPosition(JButton.CENTER);
//            letters[i].setContentAreaFilled(false);
//            letters[i].setMargin( new Insets(0,0,0,0) );
//        }
//        
//        GridBagConstraints gbcLet = new GridBagConstraints();//position
//        for (int j = 0; j < 10; j++) {
//            gbcLet.gridx = j;
//            gbcLet.gridy = 0;
//            letPanel.add(letters[j], gbcLet);
//        }
//
//        for (int j = 1; j < 9; j++) {
//            gbcLet.gridx = j;
//            gbcLet.gridy = 1;
//            letPanel.add(letters[j + 9], gbcLet);
//        }
//
//        for (int j = 1; j < 9; j++) {
//            gbcLet.gridx = j;
//            gbcLet.gridy = 2;
//            letPanel.add(letters[j + 17], gbcLet);
//        }
//        
//        //add KEYBOARD Panel
//        GridBagConstraints gbcKB = new GridBagConstraints();
//
//        gbcKB.gridx = 0;
//        gbcKB.gridy = 0;
//        gbcKB.insets = new Insets(0, 0, 110, 100);
//        gbcKB.anchor = GridBagConstraints.SOUTHEAST;
//        pane.add(letPanel, gbcKB);
//
//        //add Word to Panel
//        panel = new JPanel();
//        panel.setPreferredSize(new Dimension(700,70));
//        panel.setBackground(new Color(172, 225, 175));
//        label = new JLabel("<HTML><FONT SIZE=+15><B>"+game.display()+"</B>",SwingConstants.CENTER);
//        label.setSize(100, 40);
//        
//        //add WORD Panel
//        GridBagConstraints gbcJL = new GridBagConstraints();//position
//        gbcJL.gridx = 0;
//        gbcJL.gridy = 0;
//        gbcJL.anchor = GridBagConstraints.EAST;
//        gbcJL.insets = new Insets(0, 0, 150, 110);
//        panel.add(label);
//        pane.add(panel, gbcJL);
//        
//        //add wrong characters
//        lWrong = new JLabel();
//        lWrong.setSize(100, 40);
//        
//        GridBagConstraints gbcWrong = new GridBagConstraints();//position
//        gbcWrong.gridx = 0;
//        gbcWrong.gridy = 0;
//        gbcWrong.anchor = GridBagConstraints.SOUTHWEST;
//        gbcWrong.insets = new Insets(0, 200, 250, 0);
//        pane.add(lWrong, gbcWrong);
        
        //add actionListener
//        for (JButton button : letters) {
//            button.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent evt) {
//                    Object src = evt.getSource();
//                    if (src instanceof JButton) {
//                        String enteredLetter = ((JButton) src).getText().charAt(43) + "";
//                        mg.checkLetter(enteredLetter);
//                        label.setText("<HTML><FONT SIZE=+15><B>" + mg.printDashes() + "</B>");
//                        lWrong.setText("<HTML><FONT SIZE=+15><FONT COLOR = RED><B>" + mg.getWrongChar() + "</B>");
//                        if(!mg.checkLose()){
//                            if (mg.checkWin()) {
//                                lComment.setText("<HTML><FONT SIZE=+2><B>You Won!!</B>");
//                                playAgain(true);
//                            }
//                        }
//                        else{
//                            lComment.setText("<HTML><FONT SIZE=+2><B>You Lost:(</B>");
//                            playAgain(false);
//                        }
//                        reduceChances();
//                    }
//                }
//            });
    setVisible(true);    
    }
    
//    public static void main(String[] args) {
//        TTTProject project = new TTTProject();
//    }
    
}
