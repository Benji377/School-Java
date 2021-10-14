import java.awt.*;
import javax.swing.JFrame;

public class RekursiveKreise  extends JFrame{
	
	/**
	 * Custom-Konstruktor
	 */
	public RekursiveKreise() {
		// Eigenschafte des Fenster
		setTitle("RekursiveKreise");
		setSize(700, 700);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Rekursive Funktion um Kreise zu zeichnen
	 * @param g Graphicoberfläche
	 * @param x Position der oberen liken Ecke des Vierecks um den Kreis auf der X-Achse
	 * @param y Position der oberen liken Ecke des Vierecks um den Kreis auf der Y-Achse
	 * @param radius Radius des Kreis
	 */
	public void Kreis(Graphics g, int x, int y, int radius) {
		// Zeichnet den Kreis in der Mitte
		g.drawOval(x, y, radius, radius);
		// Limit um zu kleine Kreise zu vermeiden
		if (radius > 10) {
			// Ruft Funktion auf um inallen vier Richtungen des vorher gezeichneten Kreises weitere Kreise zu zeichnen
			Kreis(g, x+radius/4, y-radius/4, radius/2);
			Kreis(g, x-radius/4, y+radius/4, radius/2);
			Kreis(g, x+3*radius/4, y+radius/4, radius/2);
			Kreis(g, x+radius/4, y+3*radius/4, radius/2);
		}
	}
	// Ruft die Funktion endgültig auf und zeichnet aif die Zeichenoberfläche
	public void paint(Graphics g) {
		super.paint(g);
		Kreis(g, 200, 200, 300);
	}

}
