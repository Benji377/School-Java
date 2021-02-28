
public class Kreis {
	// 0 ist standartwert
	private double radius = 0;
	private double umfang = 0;
	private double flaeche = 0;
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setUmfang(double umfang) {
		// Umfang darf nicht 0 sein
		if (umfang != 0) {
			this.umfang = umfang;
			// Radius wird aus dem Unfang berechnet und gesetzt
			setRadius((umfang/Math.PI)/2);
		}
	}
	
	public double getUmfang() {
		double ret = getRadius();
		// Umfang wird aus dem Radius berechnet
		ret = ret*Math.PI*2;
		return ret;
	}
	
	public void setFlaeche(double flaeche) {
		// Fläche darf nicht 0 sein
		if (flaeche != 0) {
			this.flaeche = flaeche;
			// Radius wird aus der Fläche berechnet
			setRadius(Math.sqrt(flaeche/Math.PI));
		}
	}
	
	public double getFlaeche() {
		//ret wird zum radius
		double ret = getRadius();
		// ret wird zur fläche
		ret = Math.PI*Math.pow(ret, 2);
		return ret;
	}
	
	public java.lang.String toString() {
		// Gibt ein String zurück
		return "r= "+getRadius()+", U= "+getUmfang()+", F= "+getFlaeche();
	}
	
	public Kreis clone() {
		// erstellt neue Kreis namens ret
		Kreis ret = new Kreis();
		// gleiche radius = gleiche Kreis
		ret.setRadius(radius);
		return ret;
	}
	
	public boolean equals(Kreis k) {
		boolean ret = false;
		// wenn radius gleich, kreis gleich
		if (k.getRadius() == radius) {
			ret = true;
		}
		return ret;
	}
	
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
