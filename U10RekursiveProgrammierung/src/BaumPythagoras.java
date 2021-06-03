import javax.swing.*;
import java.awt.*;


public class BaumPythagoras extends JFrame{
	
	private Turtle t = null;

	public BaumPythagoras() {
		setTitle("RekursiverBaum");
		setSize(800, 800);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		t = new Turtle(this, 400, 700, 90);
	}
	
	public void quadrat(Graphics g, double seite) {
		t.vor(seite);
		t.drehe(270);
		t.vor(seite);
		t.drehe(270);
		t.vor(seite);
		t.drehe(270);
		t.vor(seite);
		t.drehe(270);
	}
	
	
	// Dreieck: a: 30, b: 90, y: 60
	public void zeichner(Graphics g, double seite_c) {
		
		double alpha = 60;
		double beta = 30;
		double gamma = 90;
		
		double seite_a = seite_c * (Math.sin(Math.toRadians(alpha)) / Math.sin(Math.toRadians(gamma)));
		double seite_b = seite_c * (Math.sin(Math.toRadians(beta)) / Math.sin(Math.toRadians(gamma)));
		
		quadrat(g, seite_c);
		if (seite_c <= 5) {
			t.zumStartpunkt();
			t.drehe(270);
			t.vor(seite_c);
			t.drehe(270);
		} else {
			t.vor(seite_c);
			t.drehe(30);
			quadrat(g, seite_a);
			t.drehe(270);
			t.vor(seite_a+seite_b);
			t.drehe(270);
			quadrat(g, seite_b);

		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		zeichner(g, 100);
		
	}
}
