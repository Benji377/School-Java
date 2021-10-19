import java.awt.*;
import javax.swing.JFrame;

public class RekursiveFiguren extends JFrame{
	
	// Custom-Konstruktor 
	public RekursiveFiguren() {
		// Eigenschaften des Fenster
		setTitle("RekursiveFiguren");
		setSize(1000, 1000);
		setVisible(true);
		// Kann somit nicht vergrößert oder verkleiner werden
		setResizable(false);
		// Schließt Programm beim kilcken auf der X
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Zecihnet Vierecke ineinander rekursiv
	 * @param g Graphicoberfläche
	 * @param x Position der oberen liken Ecke des Vierecks auf der X-Achse
	 * @param y Position der oberen liken Ecke des Vierecks auf der Y-Achse
	 * @param länge Die länge der Seite a des Vierecks
	 * @return 1 wenn fertig, sonst rekursiv
	 */
	public int rekursivViereck(Graphics g, int x, int y, int länge) {
		// Zeichnet viereck
		g.drawRect(x, y, länge, länge);
		// Minimale Länge der Seiten
		if (länge >= 24) {
			// Zeichnet nächsten Viereck im vorigen Viereck mit 2px Abstand
			return rekursivViereck(g, x+2, y+2, länge-4);
		} else {
			// Beendet die Rekursion
			return 1;
		}
		
	}
	
	/**
	 * Zeichnet Kreise ineinander rekursiv
	 * @param g Graphicoberfläche
	 * @param x Position der oberen liken Ecke des Vierecks (unsichtbar) um den Kreis auf der X-Achse
	 * @param y Position der oberen liken Ecke des Vierecks (unsichtbar) um den Kreis auf der X-Achse
	 * @param radius Radius der jeweiligen Kreise
	 * @return 1 wenn fertig, ansonsten rekursiv
	 */
	public int rekursivKreis(Graphics g, int x, int y, int radius) {
		// Zeichnet den Kreis
		g.drawOval(x, y, radius, radius);
		// Minimale Radius des Kreis
		if (radius >= 24) {
			// Zeichnet nächsten Kreis im vorigen mit 2px Abstand
			return rekursivKreis(g, x+2, y+2, radius-4);
		} else {
			// Beendet die Rekursion
			return 1;
		}
	}
	
	/**
	 * Zeichnet eine Reihe von immer kleiner werdende Vierecke
	 * @param g Graphicoberfläche
	 * @param x Position der oberen liken Ecke des Vierecks auf der X-Achse
	 * @param y Position der oberen liken Ecke des Vierecks auf der Y-Achse
	 * @param länge Die Seitenlänge des Vierecks
	 * @return 1 wenn fertig, sonst rekursiv
	 */
	public int rekursivReihe(Graphics g, int x, int y, int länge) {
		// Zeichnet den Viereck
		g.drawRect(x, y, länge, länge);
		// Limit bei 800 damit es nicht über der Zeichenfläche hinausgeht
		if (x <= 800) {
			// Zeichnet nächsten Viereck rechts vom vorigen mit 2px Abstand und eine 8px kleinere Seitenlänge
			return rekursivReihe(g, x+länge+2, y, länge-8);
		} else {
			// Beendet die Rekursion
			return 1;
		}
	}
	
	/**
	 * Zeichnet Kreise nebeneinander in einer Rohr form
	 * @param g Graphicoberfläche
	 * @param x Position der oberen liken Ecke des Vierecks um den Kreis auf der X-Achse
	 * @param y Position der oberen liken Ecke des Vierecks um den Kreis auf der -Achse
	 * @param radius Radius der Kreise
	 * @return 1 wenn fertig, sonst rekursiv
	 */
	public int rekursivPipe(Graphics g, int x, int y, int radius) {
		// Zeichnet den Kreis
		g.drawOval(x, y, radius, radius);
		// Limit bei 750 damit es nivht über die Zeichnfläche hinaus läuft
		if (x <= 750) {
			// Zeichnet nächsten Kreis gleich daneben mit 4px Abstand auf X-Achse
			return rekursivPipe(g, x+4, y, radius);
		} else {
			// Beendet die Rekursion
			return 1;
		}
	}
	
	/* (non-Javadoc)
	 * Methode um auf der Zeichenfläche zu zeichnen
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		super.paint(g);
		// Zeichnet die verschiedenen Figuren
		rekursivViereck(g, 20, 40, 400);
		rekursivKreis(g, 440, 40, 400);
		rekursivReihe(g, 20, 460, 175);
		rekursivPipe(g, 40, 700, 200);
	}
	

}
