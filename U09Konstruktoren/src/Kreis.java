
/**
 * Der Kreisobjekt, bestandteil der Klasse KreisGUI
 * Stellt Radius, Umfang und Fläche als Eigenschaften zur Verfügung
 */
public class Kreis {
	
	// Für die Berechnungen der verschiedenen Eigenschaften braucht man nur den Radius
	private double radius;
	
	/**
	 * Gettermethode um den Radius zurückzugeben
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
		// standardmäßig auf 0 gesetzt
		if (radius >= 0) {
			this.radius = radius;
		} else {
			this.radius = 0;
		}
			
	}
	/**
	 * Gettermethode die die Fläche aus dem Radius berechnet und zurückgibt
	 * @return die Fläche aus dem Radius berechnet
	 */
	public double getFlaeche() {
		// Berechnet die Fläche durch den Radius
		double ret = Math.PI * getRadius() * getRadius();
		return ret;
	}
	
	/**
	 * Settermethode um die Fläche zu setzen
	 * Eigentlich wird aus der Fläche den Radius berechnet und gesetzt
	 * @param flaeche Die Fläche des Kreises
	 */
	public void setFlaeche(double flaeche) {
		setRadius(Math.sqrt(flaeche/Math.PI));
	}
	
	/**
	 * Gettermethode um den Umfang aus dem Radius zu berechnen und zurückzugeben
	 * @return den Umfang, berechnet vom Radius
	 */
	public double getUmfang() {
		// Berechnet den Umfang mittels den Radius
		double ret = 2 * Math.PI * getRadius();
		return ret;
	}
	
	/**
	 * Settermethode die den Umfang des Kreises setzt
	 * Eigentlich wird der Radius aus dem übergebenen Umfang berechnet und übergeben
	 * @param umfang den zu übergebenen Umfang
	 */
	public void setUmfang(double umfang) {
		setRadius(umfang/(2*Math.PI));
	}
}
