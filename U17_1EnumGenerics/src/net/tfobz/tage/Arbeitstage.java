package net.tfobz.tage;

import java.util.*;

public class Arbeitstage implements Iterable<Wochentag> {	
	// EnumSet beinhalten Enums
	private EnumSet<Wochentag> wtage;
	private EnumSet<Wochenart> wart;
	
	public Arbeitstage() {
		// Enthält alle Wochentage
		wtage = EnumSet.allOf(Wochentag.class);
	}
	public Arbeitstage(Wochentag start, Wochentag ende) {
		// Enthält eine range von Enums
		wtage = EnumSet.range(start, ende);
		// Update der Art der Woche
		updateArt();
	}
	/**
	 * Fügt einen Tag der Woche hinzu, wenn dieser noch nicht
	 * in der Woche existiert
	 * @param tag Der Wochentag den man hinzufügen soll
	 */
	public void add(Wochentag tag) {
		if (!wtage.contains(tag))
			wtage.add(tag);
		updateArt();
	}
	
	/**
	 * Löscht einen Tag aus der Woche heraus
	 * @param tag Der Tag de man löschen möchte
	 */
	public void remove(Wochentag tag) {
		wtage.remove(tag);
		updateArt();
	}
	
	/**
	 * Kontrolliert ob ein Tag in der Woche enthalten ist
	 * @param tag Der Tag de man überprüfen soll
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
	 * Gibt zurück um welche Wochenart es sich gerade handelt.
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
	 * Kleine Helfermethode um Code übersichtlicher zu machen.
	 * Es updated öediglich den EnumSet dass die Art der Woche enthählt
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
