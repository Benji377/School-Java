package net.tfobz.grundobjekte;

import java.awt.Component;
import net.tfobz.spielobjekte.*;


/**
 * @author benji
 * Klasse dient als basis für den Spieler, damit er sich frei bewegen kann
 */
public class SteuerbaresObjekt extends BeweglichesGutesObjekt{
	protected int punkte = 0;

	public SteuerbaresObjekt(String dateiname) {
		super(dateiname);
		// Am Anfang bewegt sich der Spieler nicht
		setxRichtung(0);
		setyRichtung(0);
	}
	
	/**
	 * Je nachdem, mit was der Spieler zusammenstoßt, werden bestimmte Aktionen ausgeführt
	 */
	public void bewege() {
		Component comp = getObjektBei(getX()+getxRichtung(), getY()+getyRichtung());
		if (comp == null) {
			// Normale prozedur bei keine Kollision
			setLocation(getX()+getxRichtung(), getY()+getyRichtung());
		} else if (comp instanceof Pizza) {
			// Isst die Pizza und gibt einen Punkt dem Spieler
			punkte++;
			this.getParent().remove(comp);
		} else if (comp instanceof Mauer) {
			// Beim zusammenstoß mit einer Mauer darf der Spieler nicht weitergehen
			setxRichtung(0);
			setyRichtung(0);
		} else if (comp instanceof Zombie){
			// Beim zusammenprall mit einem Zombie stirb der Spieler
			this.gestorben = true;
		}
	}
	/**
	 * Anzahl an Punkt die ein Spieler hat
	 * @return Anzahl an Punkte
	 */
	public int getPunkte() {
		return this.punkte;
	}
	/**
	 * Überschreibt und setzt die xRichtung neu.
	 * Darauf wird immer die maximale Geschwindigkeit benutzt
	 */
	@Override
	public void setxRichtung(int xRichtung) {
		if (xRichtung < 0) {
			this.xRichtung = -10*geschwindigkeit;
			this.yRichtung = 0;
		} else if (xRichtung > 0) {
			this.xRichtung = 10 * geschwindigkeit;
			this.yRichtung = 0;
		} else {
			this.xRichtung = 0;
			this.yRichtung = 0;
		}
	}
	/**
	 * Überschreibt und setzt die yRichtung neu.
	 * Darauf wird immer die maximale Geschwindigkeit benutzt
	 */
	@Override
	public void setyRichtung(int yRichtung) {
		if (yRichtung < 0) {
			this.yRichtung = -10*geschwindigkeit;
			this.xRichtung = 0;
		} else if (yRichtung > 0) {
			this.yRichtung = 10 * geschwindigkeit;
			this.xRichtung = 0;
		} else {
			this.yRichtung = 0;
			this.xRichtung = 0;
		}
	}

}
