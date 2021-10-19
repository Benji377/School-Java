
/**
 * @author benbe
 * Fahrradklasse erweitert die Klasse Fahrzeug
 */
public class Fahrrad extends Fahrzeug {
	// Ob das Fahrrad Beluchtung hat oder nicht
	protected boolean beleuchtung;

	/**
	 * Konstruktor f�r die Klasse Fahrrad
	 * @param geschwindigkeit wird von der Klasse Fahrzeug verebt
	 */
	public Fahrrad(int geschwindigkeit) {
		// Vererbung
		super(geschwindigkeit);
		// Setzt Geschwindigkeit neu
		this.setGeschwindigkeit(geschwindigkeit);
	}
	
	/**
	 * Gettermethode f�r Beleuchtung
	 * @return true oder false
	 */
	public Boolean getBeleuchtung() {
		return beleuchtung;
	}

	/**
	 * Settermethode f�r Beleuchtung
	 * @param beleuchtung muss entweder true oder false sein
	 */
	public void setBeleuchtung(Boolean beleuchtung) {
		this.beleuchtung = beleuchtung;
	}


	/* (non-Javadoc)
	 * @see Fahrzeug#setGeschwindigkeit(int)
	 * �berschreibt die Methode in der Fahrzeugklasse und setzt so dass die Geschwindigkeit
	 * sich nur zwischen 0 und 60 befinden kann
	 */
	@Override
	public void setGeschwindigkeit(int geschwindigkeit) {
		if (geschwindigkeit > 0 && geschwindigkeit < 60)
			this.geschwindigkeit = geschwindigkeit;
		else
			// Standardm��ig auf 1
			this.geschwindigkeit = 1;
	}
	
	/* (non-Javadoc)
	 * @see Fahrzeug#toString()
	 * �berschreibt die Methode in der Fahrzeugklasse und erg�nzt Sie mit zus�tzlichen Werte
	 */
	@Override
	public String toString() {
		return super.toString() + ", B: "+getBeleuchtung();
	}

}
