package checkers;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel{
    
    StartPanel(){
        setupGUI();
    }

    private void setupGUI(){
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g)
	{
	super.paintComponent(g);
        g.drawLine(0,400,508,400);
        ///////////////////////////////////////////////////////////////////////
        g.setColor(Color.RED);
        g.setFont(new Font("Times new roman",Font.BOLD,30));
        g.drawString("CHECKERS",180,100);
        /////////////////////////////////////////////////////////////////////////
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman",Font.BOLD,14));
        g.drawString("CS 3230 INTELLIGENT SYSTEMS",160,130);
        //////////////////////////////////////////////////////////////////////
        g.setFont(new Font("Times new roman",Font.BOLD,12));
        g.setColor(Color.BLACK);
        g.drawString("A.M.H.H. ABEYKOON",180,180);
        g.drawString("070002V",320,180);
        g.drawString("B.P.P. FERNANDO",180,200);
        g.drawString("070123R",320,200);
        g.drawString("C.S.N.J. FERNANDO",180,220);
        g.drawString("070125B",320,220);
        g.drawString("K.C.B. GAJASINGHE",180,240);
        g.drawString("070137M",320,240);
        ////////////////////////////////////////////////////////////////////////
        g.drawImage(new ImageIcon("images/checkersIcon.jpg").getImage(),350,280,this);//checkersIcon.jpg


        g.setColor(new Color(0,0,0));
        
        for(int i=0;i<8;i++)  {
            if(i%2==0){
                g.fill3DRect(0, i*50, 50, 50, true);
                g.fill3DRect(100, i*50, 50, 50, true);
            }
            else{
                g.fill3DRect(50, i*50, 50, 50, true);
            }

        }
        g.drawLine(150, 0, 150, 400);
    }
}
