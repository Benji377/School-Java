import javax.swing.*;
import java.awt.*;

public class RekursiverBaum extends JFrame{
	
	private Turtle t = null;

	public RekursiverBaum() {
		setTitle("RekursiverBaum");
		setSize(800, 800);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		t = new Turtle(this, 400, 700, 90);
	}
	
	public void astZeichner(Graphics g, double a) {
		if (a >= 1) {
			double b = a * 0.75;
			t.vor(a);
			t.drehe(30);
			t.vor(b);
			astZeichner(g, b);
			t.drehe(180);
			t.vor(b);
			t.drehe(120);
			t.vor(b);
			astZeichner(g, b);
			t.drehe(180);
			t.vor(b);
			t.drehe(30);
			t.vor(a);
			t.drehe(180);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		astZeichner(g, 80);
	}
}
