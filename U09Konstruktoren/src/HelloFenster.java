import java.awt.*;
import javax.swing.*;

public class HelloFenster extends JFrame {
	private static JTextField textField1 = null;
	public HelloFenster() {
		setTitle("Hello World");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,300);
		setFont(new Font("Dialog", Font.BOLD, 20));
		
		
		textField1 = new JTextField();
		textField1.setText("Hello World");
		textField1.setBounds(48,24,193,49);
		textField1.setForeground(new Color(255));
		textField1.setBackground(new Color(12632256));
		textField1.setEditable(false);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.add(textField1);
		setVisible(true);
	 }
	
	public static void main(String args[]) {
		HelloFenster f = new HelloFenster();
	}
}