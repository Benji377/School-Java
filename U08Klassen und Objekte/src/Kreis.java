
public class Kreis {
	// 0 ist standartwert
	private double radius = 0;
	private double umfang = 0;
	private double flaeche = 0;
	
	/**
	 * Methode um den Radius des Kreises zu setzen
	 * @param radius Der radius des Kreises
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	 * Methode um den Radius zurückzugeben
	 * @return den Radius, standardmäßig 0
	 */
	public double getRadius() {
		return radius;
	}
	
	/**
	 * Methode um den Umfang zu setzen
	 * @param umfang der Umfang des Kreises
	 */
	public void setUmfang(double umfang) {
		// Umfang darf nicht 0 sein
		if (umfang != 0) {
			this.umfang = umfang;
			// Radius wird aus dem Unfang berechnet und gesetzt
			setRadius((umfang/Math.PI)/2);
		}
	}
	
	/**
	 * Methode um den Umfang zurückzugeben
	 * @return den Umfang des Kreises
	 */
	public double getUmfang() {
		double ret = getRadius();
		// Umfang wird aus dem Radius berechnet
		ret = ret*Math.PI*2;
		return ret;
	}
	
	/**
	 * Methode um die Fläche zu setzen
	 * @param flaeche Die Fläche des Kreises
	 */
	public void setFlaeche(double flaeche) {
		// Fläche darf nicht 0 sein
		if (flaeche != 0) {
			this.flaeche = flaeche;
			// Radius wird aus der Fläche berechnet
			setRadius(Math.sqrt(flaeche/Math.PI));
		}
	}
	
	/**
	 * Methode um die Fläche zurückzugeben
	 * @return die Fläche des Kreises
	 */
	public double getFlaeche() {
		//ret wird zum radius
		double ret = getRadius();
		// ret wird zur fläche
		ret = Math.PI*Math.pow(ret, 2);
		return ret;
	}
	
	/* (non-Javadoc)
	 * Überschreibt die toString Methode
	 * Gibt die Eigenschaften des Kreises als String zurück
	 * @see java.lang.Object#toString()
	 */
	public java.lang.String toString() {
		// Gibt ein String zurück
		return "r= "+getRadius()+", U= "+getUmfang()+", F= "+getFlaeche();
	}
	
	/* (non-Javadoc)
	 * Überschreibt die clone Methode
	 * Erstellt ein neues Kreis Objekt dass die gleichen Eigenschaften hat wie das alte
	 * @see java.lang.Object#clone()
	 */
	public Kreis clone() {
		// erstellt neue Kreis namens ret
		Kreis ret = new Kreis();
		// gleiche radius = gleiche Kreis
		ret.setRadius(radius);
		return ret;
	}
	
	/**
	 * Methode um zwei Kreise zu vergleichen
	 * @param k der zu vergleichende Kreis
	 * @return true wenn sie geich sind, sonst false
	 */
	public boolean equals(Kreis k) {
		boolean ret = false;
		// wenn radius gleich, kreis gleich
		if (k.getRadius() == radius) {
			ret = true;
		}
		return ret;
	}
	
	/**
	 * Vergleicht zwei Kreise um zu sehen ob der übergebene Kreis größer
	 * oder kleiner ist
	 * @param k der Kreis mit dem verglichen werden soll
	 * @return Wenn der Kreis k größer ist dann -1, wenn kleiner dann 1, sonst 0
	 */
	public int compareTo(Kreis k) {
		int ret = 0;
		// radius bestimmt den Kreis
		if (k.getRadius() > radius) {
			ret--;
		} else if(k.getRadius() < radius) {
			ret++;
		}
		return ret;
	}
}
