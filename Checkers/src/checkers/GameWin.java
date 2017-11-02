package checkers;

import javax.swing.*;
import java.awt.*;

public class GameWin extends JDialog{
    Point p;
    JLabel massage=new JLabel();
    
    GameWin(String winner,Point p){
        this.p=p;
        massage.setText("          "+winner+" Wins!");
        setupGUI();
	}

	private void setupGUI()
	{
        new PlaySound("sounds/Win.wav").start();
        massage.setFont(new Font("dialog",Font.BOLD,16));
        add(massage);

        setAlwaysOnTop(true);
        setLocation((int)p.getX()+100,(int)p.getY()+200);
        setResizable(false);
        setSize(200,80);
        setTitle("Game Over");
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}

