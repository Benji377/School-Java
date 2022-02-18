package net.tfobz.tage;

import java.util.*;

public class Arbeitstage implements Iterable<Wochentag> {	
	// EnumSet beinhalten Enums
	private EnumSet<Wochentag> wtage;
	private EnumSet<Wochenart> wart;
	
	public Arbeitstage() {
		// Enth�lt alle Wochentage
		wtage = EnumSet.allOf(Wochentag.class);
	}
	public Arbeitstage(Wochentag start, Wochentag ende) {
		// Enth�lt eine range von Enums
		wtage = EnumSet.range(start, ende);
		// Update der Art der Woche
		updateArt();
	}
	/**
	 * F�gt einen Tag der Woche hinzu, wenn dieser noch nicht
	 * in der Woche existiert
	 * @param tag Der Wochentag den man hinzuf�gen soll
	 */
	public void add(Wochentag tag) {
		if (!wtage.contains(tag))
			wtage.add(tag);
		updateArt();
	}
	
	/**
	 * L�scht einen Tag aus der Woche heraus
	 * @param tag Der Tag de man l�schen m�chte
	 */
	public void remove(Wochentag tag) {
		wtage.remove(tag);
		updateArt();
	}
	
	/**
	 * Kontrolliert ob ein Tag in der Woche enthalten ist
	 * @param tag Der Tag de man �berpr�fen soll
	 * @return true wenn es bereits in der Woche ist, ansonsten false
	 */
	public boolean contains(Wochentag tag) {
		return wtage.contains(tag);
	}
	@Override
	public String toString() {
		return wtage.toString();
	}
	
	/**
	 * Gibt zur�ck um welche Wochenart es sich gerade handelt.
	 * Dabei benutzen wir den Iterator des Enumset um auf den Elemente
	 * zuzugreifen
	 * @return Die Art der Woche wenn vorhanden, ansonsten null
	 */
	public Wochenart getWochenart() {
		if (wart != null && wart.iterator().hasNext())
			return wart.iterator().next();
		else
			return null;
	}
	
	/**
	 * Kleine Helfermethode um Code �bersichtlicher zu machen.
	 * Es updated �ediglich den EnumSet dass die Art der Woche enth�hlt
	 */
	private void updateArt() {
		if (wtage.size() == 5)
			wart = EnumSet.of(Wochenart.FUENFTAGE);
		else if (wtage.size() == 6)
			wart = EnumSet.of(Wochenart.SECHSTAGE);
		else
			wart = null;
	}
	
	@Override
	public Iterator<Wochentag> iterator() {
		return wtage.iterator();
	}
}
