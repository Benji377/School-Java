
/**
 * @author benbe
 * Basisklasse f�r Fahrrad, Auto und Lastwagen
 */
public class Fahrzeug {
	// Parameter f�r jedes Fahrzeug
	protected int geschwindigkeit;
	protected int kilometerstand;
	
	
	/**
	 * Kunstroktur f�r die Klasse Fahrzeug, setzt gleich die Geschwindigkeit fest
	 * @param geschwindigkeit Geschwindigkeit des Fahrzeugs
	 */
	public Fahrzeug(int geschwindigkeit) {
		setGeschwindigkeit(geschwindigkeit);
	}
	
	/**
	 * Settermethode um die Geschwindigkeit festzulegen
	 * @param geschwindigkeit Die Geschwindigkeit des Fahrzeugs
	 */
	public void setGeschwindigkeit(int geschwindigkeit) {
		if (geschwindigkeit > 0)
			this.geschwindigkeit = geschwindigkeit;
		else
			this.geschwindigkeit = 0;
	}
	
	/**
	 * Gettermethode f�r Geschwindigkeit
	 * @return Geschwindigkeit des Fahrzeugs, standard = 0
	 */
	public int getGeschwindigkeit() {
		return this.geschwindigkeit;
	}

	/**
	 * Gettermethode f�r den Kilometerstand eines Fahrzeugs
	 * @return
	 */
	public int getKilometerstand() {
		return kilometerstand;
	}

	/**
	 * Settermethode f�r den Kilometerstand
	 * @param kilometerstand
	 */
	public void setKilometerstand(int kilometerstand) {
		if (kilometerstand > 0)
			this.kilometerstand = kilometerstand;
		else
			this.kilometerstand = 1;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * �brschreibt die urspr�ngliche Methode und gibt die Werte der Klasse zur�ck
	 */
	@Override
	public String toString() {
		return "G: "+getGeschwindigkeit()+", K: "+getKilometerstand();
	}
	
	

}
