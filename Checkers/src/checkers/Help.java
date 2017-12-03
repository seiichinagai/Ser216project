package checkers;

import java.awt.Font;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import sun.applet.Main;

public class Help extends JDialog {
	JScrollPane hlp = new JScrollPane();
	JTextArea txt = new JTextArea();

	Help() {
		setupGUI();
	}

	private void setupGUI() {
		hlp.setViewportView(txt);
		txt.setEditable(false);
		txt.setLineWrap(true);
		txt.setWrapStyleWord(true);
		txt.setFont(new Font("Dialog", Font.PLAIN, 14));
		hlp.getHorizontalScrollBar().setEnabled(false);
		addText();
		addImage();
		add(hlp);

		setLocation((int) getToolkit().getScreenSize().getWidth() / 2 - 415,
				(int) getToolkit().getScreenSize().getHeight() / 2 - 315);
		setVisible(false);
		add(hlp);
		setSize(830, 630);
		setResizable(false);
		setTitle("How To Play");
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	}

	private void addImage() {
		URL rednurl = Main.class.getResource("/red_normal.jpg");
		ImageIcon redN = new ImageIcon(rednurl);// red_normal.jpg
		URL yellownurl = Main.class.getResource("/yellow_normal.jpg");
		ImageIcon yellowN = new ImageIcon(yellownurl);// yellow_normal.jpg
		URL redkurl = Main.class.getResource("/red_king.jpg");
		ImageIcon redK = new ImageIcon(redkurl);// red_king.jpg
		URL yellowkurl = Main.class.getResource("/yellow_king.jpg");
		ImageIcon yellowK = new ImageIcon(yellowkurl);// yellow_king.jpg
		URL onurl = Main.class.getResource("/sound.jpg");
		ImageIcon soundOn = new ImageIcon(onurl);
		URL offurl = Main.class.getResource("/mute.jpg");
		ImageIcon soundOff = new ImageIcon(offurl);

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

		Scanner scan = new Scanner(getClass().getResourceAsStream("/HowToPlay.txt"));
		String store = "";

		while (scan.hasNextLine()) {
			String temp = scan.nextLine() + "\n";
			store += temp;
		}
		txt.setText(store);

	}
}
