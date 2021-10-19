package net.tfobz.fahrzeuge;

import net.tfobz.fahrzeuge.Fahrzeug;

/**
 * @author benbe
 * Klasse Auto erweitert die Klasse Fahrzeug
 *
 */
public class Auto extends Fahrzeug {
	protected int ps;
	
	/**
	 * Kunstroktur f�r die Klasse Auto
	 * @param geschwindigkeit Die Geschwindigkeit des Autos
	 * @param ps die PS des Autos
	 */
	public Auto(int geschwindigkeit, int ps) {
		super(geschwindigkeit);
		setPs(ps);
	}
	
	/**
	 * Settermethode f�r die PS
	 * @param ps
	 */
	public void setPs(int ps) {
		if (ps > 0)
			this.ps = ps;
		else
			this.ps = 0;
	}
	
	/**
	 * Gettermehode f�r die PS
	 * @return
	 */
	public int getPs() {
		return this.ps;
	}
	
	/* (non-Javadoc)
	 * @see Fahrzeug#toString()
	 * �berschreibt die toString Methode und erg�nzt sie mit weitere Werte
	 */
	@Override
	public String toString() {
		return super.toString()+", P: "+getPs();
	}
}
