
package checkers;

import javax.swing.*;

import sun.applet.Main;

import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.*;

public class CheckerFrame extends JFrame implements ActionListener{
    JButton stB=new JButton("Start Game");
    JPanel gmP=new StartPanel();
  
    CheckerFrame(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this); //changing the appearance of the frame
        }
        catch (Exception e) {
           //no need to handle exception as it only affect the appearance
        }
        setupGUI();        
        new PlaySound("/Start.wav").start();
    }

    private void setupGUI() {
        setLayout(null);
        gmP.setBounds(0,0,508,401);
        add(gmP);
        stB.setHorizontalAlignment(SwingConstants.LEADING);
        stB.setIcon(new ImageIcon("images/checker.png"));
        stB.setBackground(Color.LIGHT_GRAY);
        stB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        stB.setBounds(140,420,200,60);
        stB.setFont(new Font("Times new roman",Font.BOLD,20));
        stB.addActionListener(this);
        stB.setFocusPainted(false);
        add(stB);

        this.setIconImage(new ImageIcon("images/icon.jpg").getImage());

        setSize(600,600); //I was playing with size
        setLocation((int)getToolkit().getScreenSize().getWidth()/2-254,(int)getToolkit().getScreenSize().getHeight()/2-310);
        setResizable(false);
        setVisible(true);
        setTitle("Play Checkers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Start Game")){
            ((JButton)e.getSource()).setText("New Game");
            new PlaySound("/button.wav").start();
            gmP=new Checkers();
            gmP.setBounds(0,0,508,401);
            this.setContentPane(gmP);
        }
    }
}
