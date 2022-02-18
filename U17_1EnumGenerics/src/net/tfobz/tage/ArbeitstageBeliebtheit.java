package net.tfobz.tage;

import java.util.*;

public class ArbeitstageBeliebtheit implements Iterable<Wochentag>{
	
	EnumMap<Wochentag, Beliebtheit> emap;
	
	public ArbeitstageBeliebtheit() {
		emap = new EnumMap<Wochentag, Beliebtheit>(Wochentag.class);
		// L�scht alles von der Map damit sie als leer erscheint
		emap.clear();
	}
	
	public ArbeitstageBeliebtheit(Arbeitstage atage, Beliebtheit b) {
		// Erstellt ein neues Enum
		emap = new EnumMap<Wochentag, Beliebtheit>(Wochentag.class);
		// Holt sich Itaertor von Arbeitstage
		Iterator<Wochentag> it = atage.iterator();
		// F�gt Werte in das EnumMap ein
		while (it.hasNext()) {
			emap.put(it.next(), b);
		}
	}
	/**
	 * F�gt einen Tag mit einer Belibtheit ein, oder aktualisiert die
	 * Beliebtheit des bereits existierenden Tag
	 * @param tag Wochentag
	 * @param b Beliebtheit
	 */
	public void put(Wochentag tag, Beliebtheit b) {
		emap.put(tag, b);
	}
	
	/**
	 * L�scht einen Tag und deren Beliebtheit aus dem EnumMap
	 * @param tag Wochentag
	 * @param b Beliebtheit
	 */
	public void remove(Wochentag tag, Beliebtheit b) {
		emap.remove(tag, b);
	}
	
	/**
	 * Gibt die Beliebtheit f�r einen bestimmten Tag zur�ck
	 * @param tag Wochentag
	 * @return Die Beliebtheit des Wochentag
	 */
	public Beliebtheit get(Wochentag tag) {
		return emap.get(tag);
	}
	
	/**
	 * Gibt zur�ck ob ein bestimmter Tag eine bestimmte Beliebtheit hat
	 * @param tag Wochentag
	 * @param b Beliebtheit
	 * @return true wenn der Wochentag die �bergebene Beliebtheit hat, ansonsten false
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
