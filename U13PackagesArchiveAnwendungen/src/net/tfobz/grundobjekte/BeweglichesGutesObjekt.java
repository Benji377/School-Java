package net.tfobz.grundobjekte;
import java.util.Random;

/**
 * @author benji
 * Klasse die Eigenschaften zu bewegliche gute Objekte beinhaltet
 */
public class BeweglichesGutesObjekt extends UnbeweglichesObjekt{
	// Geschwindigkeit kann manuell eingestellt werden
	protected static int geschwindigkeit = 1;
	protected int xRichtung;
	protected int yRichtung;
	
	/**
	 * Kunstroktur dass zufällige Richtungen generiert
	 * @param dateiname
	 */
	public BeweglichesGutesObjekt(String dateiname) {
		super(dateiname);
		// Erstellt zufällige Richtung und bestimmt max + min
		Random r = new Random();
		int min = (getGeschwindigkeit()-1)*10+1;
		int max = getGeschwindigkeit()*10;
		int richtung = r.nextInt(max-min)+min;
		// Bestimmt zufällige negative oder positive Richtung
		if (r.nextBoolean()) {
			richtung *= -1;
		}
		setxRichtung(richtung);
		if (r.nextBoolean()) {
			richtung *= -1;
		}
		setyRichtung(richtung);
	}
	
	/**
	 * Bewegt das gute Objekt in eine bestimmte Anzahl an Schritte
	 */
	public void bewege() {
		// Bestimmt die Anzahl an Schritte
		int richtungSchritte = getxRichtung();
		if (Integer.signum(getxRichtung()) < 0 ) { 
			richtungSchritte = getxRichtung() * -1;
		}
		for (int j = 0; j < richtungSchritte; j++) {
			// Kontrolliert kollisionen und bewegt sich demnach
			if (getObjektBei(getX()+Integer.signum(getxRichtung()), getY()+Integer.signum(getyRichtung())) == null) {
				// Normale prozedur bei keine Kollision
				setLocation(getX()+Integer.signum(getxRichtung()), getY()+Integer.signum(getyRichtung()));
				
			} else if (getObjektBei(getX()-Integer.signum(getxRichtung()), getY()+0) == null) {
				setLocation(getX()-Integer.signum(getxRichtung()), getY()+0);
			} else if (getObjektBei(getX()+Integer.signum(getxRichtung()), getY()+0) == null) {
				setLocation(getX()+Integer.signum(getxRichtung()), getY()+0);
			} else if (getObjektBei(getX()+0, getY()-Integer.signum(getyRichtung())) == null){
				setLocation(getX()+0, getY()-Integer.signum(getyRichtung()));
			} else if (getObjektBei(getX()+0, getY()+Integer.signum(getyRichtung())) == null){
				setLocation(getX()+0, getY()+Integer.signum(getyRichtung()));
				// Versuch zurückzukehren
			} else if (getObjektBei(getX()-Integer.signum(getxRichtung()), getY()-Integer.signum(getyRichtung())) == null) {
				setLocation(getX()-Integer.signum(getxRichtung()), getY()-Integer.signum(getyRichtung()));
			}
		}
	}
	
	/**
	 * Gibt die Geschwindigket zurück
	 * @return die Geschwindigkeit
	 */
	public static int getGeschwindigkeit() {
		return geschwindigkeit;
	}
	
	
	/**
	 * Setzt die Geschwindigkeit
	 * @param geschwindigkeit muss größer als 0 sein
	 */
	public static void setGeschwindigkeit(int geschwindigkeit) {
		if (geschwindigkeit > 0)
			BeweglichesGutesObjekt.geschwindigkeit = geschwindigkeit;
		else
			// Wenn kleiner als 0 dann auf 1 gesetzt
			BeweglichesGutesObjekt.geschwindigkeit = 1;
	}
	
	/**
	 * Gibt den aktuellen Wert der xRichtung zurück
	 * @return xRichtung
	 */
	public int getxRichtung() {
		return this.xRichtung;
	}
	/**
	 * Setzt den Wert für die xRichtung
	 * @param xRichtung
	 */
	public void setxRichtung(int xRichtung) {
		// yRichtung = betrag von xRichtung
		this.yRichtung = xRichtung;
		this.xRichtung = xRichtung;
	}
	/**
	 * Gibt den Wert der yRichtung zurück
	 * @return die yRichtung
	 */
	public int getyRichtung() {
		return this.yRichtung;
	}
	/**
	 * Setzt die yRichtung
	 * @param yRichtung
	 */
	public void setyRichtung(int yRichtung) {
		// xRichtung = betrag von yRichtung
		this.xRichtung = yRichtung;
		this.yRichtung = yRichtung;
	}
	
	

}
