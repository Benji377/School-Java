// Import wird für die Farbe gebraucht
import java.awt.*;

public class Ball {
	// Standardwerte werden vergeben
	private int radius = 0;
	private int xposition = 60;
	private int yposition = 80;
	private int xrichtung = 0;
	private int yrichtung = 0;
	private java.awt.Color farbe = java.awt.Color.BLACK;
	
	/**
	 * Methode um den Radius zurückzugeben
	 * @return den radius, standardmäßig 0
	 */
	public int getRadius() {
		return radius;
	}	
	
	/**
	 * Methode um den Radius zu setzen
	 * @param radius der radius des balles
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/**
	 * Methode um die Position des Balles auf der X-Achse zurückzugeben
	 * @return die Position des Balles auf der X-Achse, standardmäßig 60
	 */
	public int getXposition() {
		return xposition;
	}

	/**
	 * Methode um die Position des Balles auf der X-Achse zu setzen
	 * @param xposition die position auf der X-Achse
	 */
	public void setXposition(int xposition) {
		this.xposition = xposition;
	}

	/**
	 * Methode um die Position des Balles auf der Y-Achse zurückzugeben
	 * @return die Position des Balles auf der X-Achse, standardmäßig 80
	 */
	public int getYposition() {
		return yposition;
	}

	/**
	 * Methode um die Position des Balles auf der Y-Achse zu setzen
	 * @param yposition die position auf der Y-Achse
	 */
	public void setYposition(int yposition) {
		this.yposition = yposition;
	}

	/**
	 * Methode um die Verschiebung des Balles auf der X-Achse zurückzugeben
	 * @return die Verschiebung auf der X-Achse, standardmäßig 0
	 */
	public int getXrichtung() {
		return xrichtung;
	}

	/**
	 * Methode um die Verschiebung des Balles auf der X-Achse zu setzen
	 * @param xrichtung Die Verschiebung auf der X-Achse
	 */
	public void setXrichtung(int xrichtung) {
		this.xrichtung = xrichtung;
	}

	/**
	 * Methode um die Verschiebung des Balles auf der Y-Achse zurückzugeben
	 * @return die Verschiebung auf der Y-Achse, standardmäßig 0
	 */
	public int getYrichtung() {
		return yrichtung;
	}

	/**
	 * Methode um die Verschiebung des Balles auf der Y-Achse zu setzen
	 * @param yrichtung Die Verschiebung auf der Y-Achse
	 */
	public void setYrichtung(int yrichtung) {
		this.yrichtung = yrichtung;
	}

	/**
	 * Methode um die Farbe des Balles zurückzugeben
	 * @return die farbe des Balles
	 */
	public java.awt.Color getFarbe() {
		return farbe;
	}

	/**
	 * Methode um die Frabe des Balles zu setzen
	 * @param farbe Die farbe in Hex-code
	 */
	public void setFarbe(java.awt.Color farbe) {
		this.farbe = farbe;
	}
	
	/* (non-Javadoc)
	 * Methode um die Informationen des Blles als String zurückzugeben
	 * Überschreibt die toString Methode
	 * @see java.lang.Object#toString()
	 */
	public java.lang.String toString() {
		return "r = "+getRadius()+", xposition = "+getXposition()+", yposition = "+getYposition()
		+", xrichtung = "+getXrichtung()+", yrichtung = "+getYrichtung();
	}
	
	/**
	 * Methode um dem Ball zufällige Eigenschaften zu geben.
	 * Der Radius wird zufällig zwischen 2 und 40 ausgesucht
	 * Die X und Y-Richtung werden zufällig zwischen -10 und 20 ausgesucht
	 * Die Farbe wird auch zufällig ausgesucht
	 */
	public void setZufaellig() {
		// SEtzt den zufälligen Radius
		setRadius((int) (Math.random()*40+2));
		// Solange keine X-Richtung gesetzt wurde, wird eine neue generiert
		while(getXrichtung() == 0) {
			setXrichtung((int) (Math.random()*20-10));
		}
		// Solange keine Y-Richtung gesetzt wurde, wird eine neue generiert
		while(getYrichtung() == 0) {
			setYrichtung((int) (Math.random()*20-10));
		}
		// Generiert eine zufällige Freb, indem drei verschiedene Werte
		// für den Hex-Code generiert werden. Die Zahlen gehen von 0 bis 255
		farbe = new Color((int) (Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
		// Die Farbe wird gesetzt
		setFarbe(farbe);
	}
	
	/**
	 * Methode um den Ball auf die Graphicoberfläche zu bewegen.
	 * Die Methode addiert zu den alten X und Y-Positionen die X und Y-
	 * Richtung und ermittelt somit die neue Position
	 * @param g Die Graphicoberfläche (Applet)
	 * @param hoehe Die Höhe der Graphicoberfläche
	 * @param breite Die Breite der Graphicoberfläche
	 */
	public void bewege(Graphics g, int hoehe, int breite) {
		// Um alternativ Rechtecke zu zeichnen:
		// Wenn der Ball an den Rand stoßt, wird somit die Richtung gespiegelt
		if (getXposition() >= breite-getRadius() || getXposition() <= 0) {
			// Durch die Multiplikation mit -1 wird das Vorzeichen geändert
			setXrichtung(getXrichtung()*-1);
		}
		if (getYposition() >= hoehe-getRadius() || getYposition() <= 0) {
			// So wie bei der X-Achse, muss auch die Y-Achse gespiegelt werden
			setYrichtung(getYrichtung()*-1);
		}
		// Hier werden die neue Werte gesetzt
		setXposition(getXposition()+getXrichtung());
		setYposition(getYposition()+getYrichtung());
		g.setColor(getFarbe());
		// Somit werden die Bälle gezeichnet
		//g.fillRect(getXposition(), getYposition(), getRadius(), getRadius());
		g.fillOval(getXposition(), getYposition(), getRadius(), getRadius());
	}
}
