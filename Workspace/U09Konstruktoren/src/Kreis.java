
/**
 * Der Kreisobjekt, bestandteil der Klasse KreisGUI
 * Stellt Radius, Umfang und Fl�che als Eigenschaften zur Verf�gung
 */
public class Kreis {
	
	// F�r die Berechnungen der verschiedenen Eigenschaften braucht man nur den Radius
	private double radius;
	
	/**
	 * Gettermethode um den Radius zur�ckzugeben
	 * @return den Radius
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * Settermethode um den Radius zu setzen
	 * @param radius den Radius des Kreises
	 */
	public void setRadius(double radius) {
		// Radius kann nicht kleiner als 0 sein und wird deswegen
		// standardm��ig auf 0 gesetzt
		if (radius >= 0) {
			this.radius = radius;
		} else {
			this.radius = 0;
		}
			
	}
	/**
	 * Gettermethode die die Fl�che aus dem Radius berechnet und zur�ckgibt
	 * @return die Fl�che aus dem Radius berechnet
	 */
	public double getFlaeche() {
		// Berechnet die Fl�che durch den Radius
		double ret = Math.PI * getRadius() * getRadius();
		return ret;
	}
	
	/**
	 * Settermethode um die Fl�che zu setzen
	 * Eigentlich wird aus der Fl�che den Radius berechnet und gesetzt
	 * @param flaeche Die Fl�che des Kreises
	 */
	public void setFlaeche(double flaeche) {
		setRadius(Math.sqrt(flaeche/Math.PI));
	}
	
	/**
	 * Gettermethode um den Umfang aus dem Radius zu berechnen und zur�ckzugeben
	 * @return den Umfang, berechnet vom Radius
	 */
	public double getUmfang() {
		// Berechnet den Umfang mittels den Radius
		double ret = 2 * Math.PI * getRadius();
		return ret;
	}
	
	/**
	 * Settermethode die den Umfang des Kreises setzt
	 * Eigentlich wird der Radius aus dem �bergebenen Umfang berechnet und �bergeben
	 * @param umfang den zu �bergebenen Umfang
	 */
	public void setUmfang(double umfang) {
		setRadius(umfang/(2*Math.PI));
	}
}
