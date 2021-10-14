package net.tfobz.brueche;

public class Bruch {
	private int zaehler;
	private int nenner;
	
	/**
	 * @return Den Zähler des Bruches
	 */
	public int getZaehler() {
		return zaehler;
	}
	/**
	 * @param Setzt den Zähler
	 */
	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}
	/**
	 * @return Gibt den Nenner zurück
	 */
	public int getNenner() {
		return nenner;
	}
	/**
	 * @param Den zu setztenden Nenner
	 * @throws BruchException wenn der Nenner 0 ist
	 */
	public void setNenner(int nenner) throws BruchException {
		if (nenner == 0)
			throw new BruchException("Nenner ist Null");
		this.nenner = nenner;
	}

	/**
	 * Erstellt einen Bruch mit Zähler und Nenner
	 * @param zaehler Zähler des Bruches
	 * @param nenner Nenner des Bruches
	 * @throws BruchException wenn der Nenner 0 ist
	 */
	public Bruch(int zaehler, int nenner) throws BruchException {
		setZaehler(zaehler);
		setNenner(nenner);
		kuerze();
	}
	
	/**
	 * Kürzt den Bruch durch das Benutzen des ggT
	 * Brüche werden automatisch nach dem Erstellen und nach jede
	 * Rechenoperation gekürzt
	 * @throws BruchException
	 */
	private void kuerze() throws BruchException {
		int ggT = ggT_rechner(Math.abs(getZaehler()), Math.abs(getNenner()));
		setZaehler(getZaehler()/ggT);
		setNenner(getNenner()/ggT);
	}
	/**
	 * Berechnet den ggT (größte gemeinsame Teiler)
	 * @param z  Zähler vom Bruch
	 * @param n Nenner vom Bruch
	 * @return Den ggT
	 */
	private int ggT_rechner(int z, int n){
			if(z>0)
			    return ggT_rechner(n%z, z);
			else
			    return n;
		   }
	
	@Override
	public String toString() {
		return getZaehler()+"/"+getNenner();
	}
	
	@Override
	/**
	 * Kontrolliert ob zwei Brüche gleich sind
	 */
	public boolean equals(Object o) {
		boolean ret = false;
		// Objekt ist null
		if (o == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		// Objekt ist nicht ein Bruch	
		} else if (!(o instanceof Bruch)) {
			throw new ClassCastException("Typen nicht passend");
		} else {
			// Objekt wird zum Bruch konvertiert
			Bruch b = (Bruch)o;
			// Vergleich Nenner mit Nenner und Zähler mit Zähler
			if (b.getNenner() == getNenner() && b.getZaehler() == getZaehler())
				ret = true;
		}
		return ret;
	}
	
	@Override
	/**
	 * Kopiert den Bruch und git die Kopie zurück
	 */
	public Bruch clone() {
		Bruch ret = null;
		try {
			ret = new Bruch(getZaehler(), getNenner());
		} catch (BruchException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * Addiert den übergebenen Bruch zum Bruch
	 * @param b 
	 * @throws BruchException
	 */
	public void addiere(Bruch b) throws BruchException {
		setZaehler(getZaehler() * b.getNenner() + getNenner() * b.getZaehler());
		setNenner(getNenner() * b.getNenner());
		kuerze();
	}
	
	/**
	 * Subtrahiert den übergebenen Bruch vom Bruch
	 * @param b
	 * @throws BruchException
	 */
	public void subtrahiere(Bruch b) throws BruchException {
		setZaehler(getZaehler() * b.getNenner() - getNenner() * b.getZaehler());
		setNenner(getNenner() * b.getNenner());
		kuerze();
	}
	
	/**
	 * Multipliziert den übergebenen Bruch mit dem Bruch
	 * @param b
	 * @throws BruchException
	 */
	public void multipliziere(Bruch b) throws BruchException {
		setZaehler(getZaehler() * b.getZaehler());
		setNenner(getNenner() * b.getNenner());
		kuerze();
	}
	
	/**
	 * Dividiert den Bruch mit dem übergebenen Bruch
	 * @param b
	 * @throws BruchException
	 */
	public void dividiere(Bruch b) throws BruchException {
		int temp_nenner = b.getNenner();
		b.setNenner(b.getZaehler());
		b.setZaehler(temp_nenner);
		multipliziere(b);
	}
}
