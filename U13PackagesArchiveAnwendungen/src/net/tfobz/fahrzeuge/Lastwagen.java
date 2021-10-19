package net.tfobz.fahrzeuge;

import net.tfobz.fahrzeuge.Auto;

/**
 * @author benbe
 * Klasse wird von der Klasse Auto erweitert
 *
 */
public class Lastwagen extends Auto {
	protected int ladeflaeche;
	

	/**
	 * Kunstroktur der Klasse Lastwagen �berschreibt der der Klasse Auto
	 * @param ps PS des Lastwagen
	 * @param geschwindigkeit Geschwindigkeit des Lastwagen
	 * @param ladeflaeche Ladefl�che des Lastwagen
	 */
	public Lastwagen(int ps, int geschwindigkeit, int ladeflaeche) {
		super(ps, geschwindigkeit);
		this.setPs(ps);
		setLadeflaeche(ladeflaeche);
	}

	
	/**
	 * Gettermethode f�r die Ladefl�che
	 * @return die Ladefl�che
	 */
	public int getLadeflaeche() {
		return ladeflaeche;
	}

	/**
	 * Settermethode f� die Ladefl�che
	 * @param ladeflaeche die Ladefl�che als ganze Zahl
	 */
	public void setLadeflaeche(int ladeflaeche) {
		if (ladeflaeche > 0)
			this.ladeflaeche = ladeflaeche;
		else
			this.ladeflaeche = 1;
	}
	
	/* (non-Javadoc)
	 * @see Auto#setPs(int)
	 * �berschreibt die Methode in der Klasse Auto
	 * PS m�ssen mindestens 150 sein
	 */
	@Override
	public void setPs(int ps) {
		if (ps > 150)
			this.ps = ps;
		else
			this.ps = 150;
	}
	
	/* (non-Javadoc)
	 * @see Auto#toString()
	 * �berschreibt die Methode in der Auto Klasse und erg�nzt sie mit weitere Werte
	 */
	@Override
	public String toString() {
		return super.toString()+", L: "+getLadeflaeche();
	}
}
