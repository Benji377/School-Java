package net.tfobz.tage;

import java.util.*;

public class ArbeitstageBeliebtheit implements Iterable<Wochentag>{
	
	EnumMap<Wochentag, Beliebtheit> emap;
	
	public ArbeitstageBeliebtheit() {
		emap = new EnumMap<Wochentag, Beliebtheit>(Wochentag.class);
		// Löscht alles von der Map damit sie als leer erscheint
		emap.clear();
	}
	
	public ArbeitstageBeliebtheit(Arbeitstage atage, Beliebtheit b) {
		// Erstellt ein neues Enum
		emap = new EnumMap<Wochentag, Beliebtheit>(Wochentag.class);
		// Holt sich Itaertor von Arbeitstage
		Iterator<Wochentag> it = atage.iterator();
		// Fügt Werte in das EnumMap ein
		while (it.hasNext()) {
			emap.put(it.next(), b);
		}
	}
	/**
	 * Fügt einen Tag mit einer Belibtheit ein, oder aktualisiert die
	 * Beliebtheit des bereits existierenden Tag
	 * @param tag Wochentag
	 * @param b Beliebtheit
	 */
	public void put(Wochentag tag, Beliebtheit b) {
		emap.put(tag, b);
	}
	
	/**
	 * Löscht einen Tag und deren Beliebtheit aus dem EnumMap
	 * @param tag Wochentag
	 * @param b Beliebtheit
	 */
	public void remove(Wochentag tag, Beliebtheit b) {
		emap.remove(tag, b);
	}
	
	/**
	 * Gibt die Beliebtheit für einen bestimmten Tag zurück
	 * @param tag Wochentag
	 * @return Die Beliebtheit des Wochentag
	 */
	public Beliebtheit get(Wochentag tag) {
		return emap.get(tag);
	}
	
	/**
	 * Gibt zurück ob ein bestimmter Tag eine bestimmte Beliebtheit hat
	 * @param tag Wochentag
	 * @param b Beliebtheit
	 * @return true wenn der Wochentag die übergebene Beliebtheit hat, ansonsten false
	 */
	public boolean contains(Wochentag tag, Beliebtheit b) {
		boolean ret = false;
		if (emap.get(tag) == b)
			ret = true;
		return ret;
	}
	
	@Override
	public String toString() {
		return emap.toString();
	}

	@Override
	public Iterator<Wochentag> iterator() {
		return null;
	}

}
