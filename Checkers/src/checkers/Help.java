package checkers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;

public class Help extends JDialog {
    JScrollPane hlp=new JScrollPane();
    JTextArea txt=new JTextArea();

    Help(){
        setupGUI();
    }

    private void setupGUI() {
        hlp.setViewportView(txt);
        txt.setEditable(false);
        txt.setLineWrap(true);
        txt.setWrapStyleWord(true);
        txt.setFont(new Font("Dialog",Font.PLAIN,14));
        hlp.getHorizontalScrollBar().setEnabled(false);
        addImage();
        addText();        
        add(hlp);


        setLocation((int)getToolkit().getScreenSize().getWidth()/2-415,(int)getToolkit().getScreenSize().getHeight()/2 - 315);
        setVisible(false);
        add(hlp);
        setSize(830,630);
        setResizable(false);
        setTitle("How To Play");
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }
    
    private void addImage() {
    	ImageIcon redN=new ImageIcon(new ImageIcon("images/red_normal.jpg").getImage());
        ImageIcon redK=new ImageIcon(new ImageIcon("images/red_king.jpg").getImage());
        ImageIcon yellowN=new ImageIcon(new ImageIcon("images/yellow_normal.jpg").getImage());
        ImageIcon yellowK=new ImageIcon(new ImageIcon("images/yellow_king.jpg").getImage());
        ImageIcon soundOn = new ImageIcon(new ImageIcon("images/sound.jpg").getImage());
        ImageIcon soundOff = new ImageIcon(new ImageIcon("images/mute.jpg").getImage());
        
        JLabel redNormIcon = new JLabel(redN);
        JLabel redKingIcon = new JLabel(redK);
        JLabel yellowNormIcon = new JLabel(yellowN);
        JLabel yellowKingIcon = new JLabel(yellowK);
        JLabel soundOnIcon = new JLabel(soundOn);
        JLabel soundOffIcon = new JLabel(soundOff);
        
        redNormIcon.setBounds(0, 8, 50, 50);
        redKingIcon.setBounds(0, 65, 50, 50);
        yellowNormIcon.setBounds(280, 8, 50, 50);
        yellowKingIcon.setBounds(280, 65, 50, 50);
        soundOnIcon.setBounds(585, 8, 50, 50);
        soundOffIcon.setBounds(585, 65, 50, 50);
        
        redNormIcon.setIcon(redN);
        redKingIcon.setIcon(redK);
        yellowNormIcon.setIcon(yellowN);
        yellowKingIcon.setIcon(yellowK);
        soundOnIcon.setIcon(soundOn);
        soundOffIcon.setIcon(soundOff);
       
        this.getContentPane().add(redNormIcon);
        this.getContentPane().add(redKingIcon);
        this.getContentPane().add(yellowNormIcon);
        this.getContentPane().add(yellowKingIcon);
        this.getContentPane().add(soundOnIcon);
        this.getContentPane().add(soundOffIcon);
    }

    private void addText() {
        
        String str;
        try {
            BufferedReader b=new BufferedReader(new FileReader(new File("HowToPlay.txt")));
            try {
                while((str=b.readLine())!=null)
                	txt.append(str+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
