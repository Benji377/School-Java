import java.awt.*;
import javax.swing.JFrame;

public class RekursiveFiguren extends JFrame{
	
	// Custom-Konstruktor 
	public RekursiveFiguren() {
		// Eigenschaften des Fenster
		setTitle("RekursiveFiguren");
		setSize(1000, 1000);
		setVisible(true);
		// Kann somit nicht vergr��ert oder verkleiner werden
		setResizable(false);
		// Schlie�t Programm beim kilcken auf der X
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Zecihnet Vierecke ineinander rekursiv
	 * @param g Graphicoberfl�che
	 * @param x Position der oberen liken Ecke des Vierecks auf der X-Achse
	 * @param y Position der oberen liken Ecke des Vierecks auf der Y-Achse
	 * @param l�nge Die l�nge der Seite a des Vierecks
	 * @return 1 wenn fertig, sonst rekursiv
	 */
	public int rekursivViereck(Graphics g, int x, int y, int l�nge) {
		// Zeichnet viereck
		g.drawRect(x, y, l�nge, l�nge);
		// Minimale L�nge der Seiten
		if (l�nge >= 24) {
			// Zeichnet n�chsten Viereck im vorigen Viereck mit 2px Abstand
			return rekursivViereck(g, x+2, y+2, l�nge-4);
		} else {
			// Beendet die Rekursion
			return 1;
		}
		
	}
	
	/**
	 * Zeichnet Kreise ineinander rekursiv
	 * @param g Graphicoberfl�che
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
			// Zeichnet n�chsten Kreis im vorigen mit 2px Abstand
			return rekursivKreis(g, x+2, y+2, radius-4);
		} else {
			// Beendet die Rekursion
			return 1;
		}
	}
	
	/**
	 * Zeichnet eine Reihe von immer kleiner werdende Vierecke
	 * @param g Graphicoberfl�che
	 * @param x Position der oberen liken Ecke des Vierecks auf der X-Achse
	 * @param y Position der oberen liken Ecke des Vierecks auf der Y-Achse
	 * @param l�nge Die Seitenl�nge des Vierecks
	 * @return 1 wenn fertig, sonst rekursiv
	 */
	public int rekursivReihe(Graphics g, int x, int y, int l�nge) {
		// Zeichnet den Viereck
		g.drawRect(x, y, l�nge, l�nge);
		// Limit bei 800 damit es nicht �ber der Zeichenfl�che hinausgeht
		if (x <= 800) {
			// Zeichnet n�chsten Viereck rechts vom vorigen mit 2px Abstand und eine 8px kleinere Seitenl�nge
			return rekursivReihe(g, x+l�nge+2, y, l�nge-8);
		} else {
			// Beendet die Rekursion
			return 1;
		}
	}
	
	/**
	 * Zeichnet Kreise nebeneinander in einer Rohr form
	 * @param g Graphicoberfl�che
	 * @param x Position der oberen liken Ecke des Vierecks um den Kreis auf der X-Achse
	 * @param y Position der oberen liken Ecke des Vierecks um den Kreis auf der -Achse
	 * @param radius Radius der Kreise
	 * @return 1 wenn fertig, sonst rekursiv
	 */
	public int rekursivPipe(Graphics g, int x, int y, int radius) {
		// Zeichnet den Kreis
		g.drawOval(x, y, radius, radius);
		// Limit bei 750 damit es nivht �ber die Zeichnfl�che hinaus l�uft
		if (x <= 750) {
			// Zeichnet n�chsten Kreis gleich daneben mit 4px Abstand auf X-Achse
			return rekursivPipe(g, x+4, y, radius);
		} else {
			// Beendet die Rekursion
			return 1;
		}
	}
	
	/* (non-Javadoc)
	 * Methode um auf der Zeichenfl�che zu zeichnen
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
