
public class Quadrat {
	// Ein Quadrat kann definiert werden in dem mna eine einzige Seite angibt
	private double seiteA;
	
	/**
	 * Methode zum zur�ckgeben der Seite a des Quadrats
	 * @return die Seite a
	 */
	public double getSeiteA() {
		return seiteA;
	}
	
	/**
	 * Methode zum �bergeben der Seite a zum Objekt Quadrat
	 * @param seite die seite a des Quadrats
	 */
	public void setSeiteA(double seite) {
		// die Seite a darf nicht kliener als 0 sein
		if (seite >= 0) {
			this.seiteA = seite;		
		} else {
			// wenn kleiner las 0 wird es auf 0 gesetzt
			this.seiteA = 0;
		}
	}
	/**
	 * Methode zum zur�ckgeben der Seite b des Quadrats
	 * @return die Seite b
	 */
	public double getSeiteB() {
		return seiteA;
	}
	/**
	 * Methode zum �bergeben der Seite b zum Objekt Quadrat
	 * @param seite die seite b des Quadrats
	 */
	public void setSeiteB(double seite) {
		// die Seite b kann nicht kleiner als 0 sein
		if (seite >= 0) {
			this.seiteA = seite;		
		} else {
			// wenn kleiner als 0 dann wird es auf 0 gesetzt
			this.seiteA = 0;
		}
	}
	
	/**
	 * Methode zum zur�ckgeben des Umfamg. Der Umfang wird aus
	 * der Seite a berechnet
	 * @return den Umfang des Quadrats
	 */
	public double getUmfang() {
		return seiteA*4;
	}
	
	
	/**
	 * Methode zum �bergeben des Umfangs.
	 * Durch den �bergebenen Umfang wird die Seite berechnet
	 * @param umfang Der umfang des Quadrats
	 */
	public void setUmfang(double umfang) {
		// Umfang muss gr��er als 0 sein
		if (umfang >= 0) {
			// Hier wird die Seite a berechnet
			setSeiteA(umfang/4);
		} else {
			// Wenn der Umfang kleiner als 0 ist, wird die Seite auf 0 gesetzt
			setSeiteA(0.0);
		}
	}
	
	/**
	 * Methode zum zur�ckgeben der Fl�che.
	 * Die Methode berechnet die Fl�che anhand der Seite a.
	 * @return die Fl�che des Quadrats
	 */
	public double getFlaeche() {
		return Math.pow(seiteA, 2);
	}
	
	
	/**
	 * Methode zum �bergeben der Fl�che.
	 * Anhand der Fl�che wird die Seite a berechnet
	 * @param flaeche die Fl�che des Quadrats
	 */
	public void setFlaeche(double flaeche) {
		// Fl�che kann nicht kleiner als 0 sein
		if (flaeche >= 0) {
			// Die Seite a wird berechnet
			setSeiteA(Math.sqrt(flaeche));
		} else {
			// Wenn die Fl�che kleiner als 0 ist, wird die Seite a auf 0 gesetzt
			setSeiteA(0.0);
		}
	}
	
	
	/* (non-Javadoc)
	 * Erstellt eine Kopie des Quadrats und gibt es zur�ck
	 * @see java.lang.Object#clone()
	 */
	public Quadrat clone() {
		// Neues Objekt wird erstellt
		Quadrat ret = new Quadrat();
		// Seite wird kopiert
		ret.setSeiteA(seiteA);
		return ret;
	}
	
	/**
	 * Vergleicht ein Quadrat mit dem �bergebenen Objekt.
	 * Gibt true zur�ck wenn sie gleich sind, sonst false
	 * @param q Das zu vergleichende Objekt
	 * @return true wenn gleich, sonst false
	 */
	public boolean equals(Quadrat q) {
		boolean ret = false;
		// Vergleicht die Seiten der beiden Quadraten
		if (q.getSeiteA() == seiteA) {
			ret = true;
		}
		return ret;
	}
	
	/**
	 * Kontrolliert, ob das Quadrat kleiner als das �bergebene Objekt q ist (R�ckgabewert = -1),
	 * gr��er (R�ckgabewert = 1) oder gleich dem �bergebenen Objekt q ist (R�ckgabewert = 0)
	 * @param q Das zu vergleichende Objekt
	 * @return -1 falls das Objekt kleiner als das �bergebene Objekt q ist
	 * 0 falls das Objekt gleich dem �bergebenen Objekt q ist
	 * 1 falls das Objekt gr��er als das �bergebene Objekt q ist
	 */
	public int compareTo(Quadrat q) {
		int ret = 0;
		// Wenn die Seite des Objekts kleiner ist
		if (q.getSeiteA() > seiteA) {
			ret--;
		// Wenn die Seite des Objekts gr��er ist
		} else if (q.getSeiteA() < seiteA) {
			ret++;
		}
		return ret;
	}
	
	/* (non-Javadoc)
	 * Gibt einen String zur�ck indem alle Werte abzulesen sind
	 * @see java.lang.Object#toString()
	 */
	public java.lang.String toString() {
		return "a= "+getSeiteA()+", b= "+getSeiteB()+", U= "+getUmfang()+", F= "+getFlaeche();
	}
}
