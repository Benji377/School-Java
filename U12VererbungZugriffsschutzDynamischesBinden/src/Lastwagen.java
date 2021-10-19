
/**
 * @author benbe
 * Klasse wird von der Klasse Auto erweitert
 *
 */
public class Lastwagen extends Auto {
	protected int ladeflaeche;
	

	/**
	 * Kunstroktur der Klasse Lastwagen überschreibt der der Klasse Auto
	 * @param ps PS des Lastwagen
	 * @param geschwindigkeit Geschwindigkeit des Lastwagen
	 * @param ladeflaeche Ladefläche des Lastwagen
	 */
	public Lastwagen(int ps, int geschwindigkeit, int ladeflaeche) {
		super(ps, geschwindigkeit);
		this.setPs(ps);
		setLadeflaeche(ladeflaeche);
	}

	
	/**
	 * Gettermethode für die Ladefläche
	 * @return die Ladefläche
	 */
	public int getLadeflaeche() {
		return ladeflaeche;
	}

	/**
	 * Settermethode fü die Ladefläche
	 * @param ladeflaeche die Ladefläche als ganze Zahl
	 */
	public void setLadeflaeche(int ladeflaeche) {
		if (ladeflaeche > 0)
			this.ladeflaeche = ladeflaeche;
		else
			this.ladeflaeche = 1;
	}
	
	/* (non-Javadoc)
	 * @see Auto#setPs(int)
	 * Überschreibt die Methode in der Klasse Auto
	 * PS müssen mindestens 150 sein
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
	 * Überschreibt die Methode in der Auto Klasse und ergänzt sie mit weitere Werte
	 */
	@Override
	public String toString() {
		return super.toString()+", L: "+getLadeflaeche();
	}
}
