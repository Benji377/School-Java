package net.tfobz.kurzeTest;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class KurzTest extends JFrame{

	public static void main(String[] args) {
		KurzTest kTest = new KurzTest();
		kTest.setVisible(true);
	}
	
	public KurzTest() {
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		int height = 400;
		int width = 400;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((int)screen_size.getWidth()/2-width/2, (int)screen_size.getHeight()/2-height/2, width, height);
		this.setResizable(false);
		this.setTitle("Kurzer Test");
	}

}