
public class Person {
	// Membervariabeln für eine Person
	private String vorname;
	private String nachname;
	private boolean weiblich;
	// Kann nur einmal vergeben werden
	private final int PERSON_NUMBER;
	// Wird um 1 ehöht wenn neue Person angelegt wird
	private static int nextNumber = 0;
	// Eltern für jede person
	private Person mutter;
	private Person vater;
	
	/**
	 * Custom-Konstruktor ohne Eltern
	 * @param vorname Vorname der Person
	 * @param nachname Nachname der Person
	 * @param weiblich Geschlecht der Person (true oder false)
	 */
	public Person(String vorname, String nachname, boolean weiblich) {
		this.PERSON_NUMBER = nextNumber;
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setWeiblich(weiblich);
		nextNumber++;
	}
	
	/**
	 * Custom-Konstruktor um eine Person mit Vater und Mutter zu setzen
	 * @param vorname den Vorname einer Person
	 * @param nachname den Nachname einer Person
	 * @param weiblich die Weiblichkeit einer Person
	 * @param vater den vater der Person
	 * @param mutter die Mutter der Person
	 */
	public Person(String vorname, String nachname, boolean weiblich, Person vater, Person mutter) {
		this.PERSON_NUMBER = nextNumber;
		this.mutter = mutter;
		this.setVater(vater);
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setWeiblich(weiblich);
		nextNumber++;
	}
	
	/**
	 * Custom-Konstruktor um eine Person zu kopieren
	 * @param copy die zu kopierende Person
	 */
	public Person(Person copy) {
		this(copy.vorname, copy.nachname, copy.weiblich);
		this.mutter = null;
		this.vater = null;
	}
	/**
	 * Methode um die Nächste Personennummer zu bekommen
	 * @return die nächste Personnennummer
	 */
	public static int getNextNumber() {
		return nextNumber;
	}
	/**
	 * Methode um die Nummer einer Person zurückzugeben
	 * @return die Nummer einer Person (nicht veränderbar)
	 */
	public int getPersonNumber() {
		return this.PERSON_NUMBER;
	}
	/**
	 * Methode um nur den Vorname einer Person zurückzugeben
	 * @return den Vorname einer Person
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * Metjode um nur den Vornamen einer Person zu verändern
	 * @param vorname den Vorname einer Person
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	/**
	 * Methode um den Nachname einer Person zurückzugeben
	 * @return den Nachname einer Person
	 */
	public String getNachname() {
		return nachname;
	}
	/**
	 * Methode um den Nachname einer Person zu setzen
	 * @param nachname den Nachname einer Person
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	/**
	 * Methode um die Weiblichkeit einer Person zurückzugeben
	 * @return true wenn eine Person weiblich ist, sonst false
	 */
	public boolean isWeiblich() {
		return weiblich;
	}

	/**
	 * Methode um die Weiblichkeit einer Person zu setzen
	 * @param weiblich Ob eine Person weiblich ist
	 */
	public void setWeiblich(boolean weiblich) {
		this.weiblich = weiblich;
	}
	
	/**
	 * Wenn Vorname und nachname nicht null sind, werden sie zusammengefügt
	 * und mittels dieser Methode zurückgegeben
	 * @return den vollstaändigen name einer Person
	 */
	public String getName() {
		// Gibt im standardzustand null zurück
		String ret = null;
		// Wenn Vorname und Nachname bereits gesetzt wurden wird ret auch gesetzt
		if (getVorname() != null && getNachname() != null) {
			ret = "";
			// ret ist einfach nur Vorname + Nachname
			ret = getVorname()+" "+getNachname();
		}
		return ret;
	}

	/**
	 * Methode um die Mutter einer Person zurückzugeben
	 * @return die Mutter einer Person
	 */
	public Person getMutter() {
		return mutter;
	}

	/**
	 * Kontrolliert ob die Mutter weiblich ist und setzt diese
	 * Wenn sie nicht weiblich ist, und deswegen ungültig,
	 * wird die Mutter auf null gesetzt
	 * @param mutter die Mutter einer Person
	 */
	public void setMutter(Person mutter) {
		this.mutter = null;
		if (mutter.weiblich == true) {
			this.mutter = mutter;
		}
	}

	/**
	 * Gibt den Vater einer Person zurück
	 * @return den vater einer Person
	 */
	public Person getVater() {
		return vater;
	}

	/**
	 * Wenn der vater nicht weiblich ist, wird der Vater gesetzt,
	 * ansonsten ist der Vater ungültig und wird deswegen auf null
	 * gesetzt
	 * @param vater den Vater einer Person
	 */
	public void setVater(Person vater) {
		this.vater = null;
		if (vater.weiblich != true) {
			this.vater = vater;
		}
	}
	
	/**
	 * Eine Methode die beide Elternteile, wenn bekannt, einer Person zurückgeben.
	 * Die Eltern werden zuerst aber kopiert, somit werden die Eltern der Eltern auf null gesetzt.
	 * Die Methode speichert beide Elternteile in ein Array ab.
	 * @return ein Array dass beide Elternteile enthält
	 */
	public Person[] getEltern() {
		// Kleines Array um beide Eltern zurückzugeben
		Person ret[] = new Person[2];
		// Kontrolliert ob eine Mutter der Person vorhanden ist
		if (getMutter() != null) {
			// Wen ja dann wird sie kopiert und dem Array übergeben
			ret[0] = new Person(getMutter());
		} else {
			// Wenn nicht, wird das Array an dieser Stelle auf null gesetzt
			ret[0] = null;
		}
		// Kontrolliert on ein Vater der übergebenen Person vorhanden ist
		if (getVater() != null) {
			// Wenn ja, wird der Vater kopiert und dem array übergeben
			ret[1] = new Person(getVater());
		} else {
			// Wenn nicht, wird das Array auf null gesetzt
			ret[1] = null;
		}
		return ret;
	}
	
	/**
	 * Eine Methode um alle vier Großelternteile, wenn bekannt, einer Person
	 * in form eines Arrays zurückzugeben. Wenn die Großeltern nicht
	 * bekannt sind, wird null an ihrer Stelle gespeichert
	 * @return ein Array dass alle Großeltern einer Person enthält
	 */
	public Person[] getGrosseltern() {
		// Es wird ein Array für alle vier Großelternteile erstellt
		Person ret[] = new Person[4];
		
		// Diese Array enthählt die Großeltern mütterlicherseits
		Person elternmutter[] = getMutter().getEltern();
		// Die Großeltern werden von den Eltern der Eltern hervorgenommen
		// und dann einfach dem Array übergeben
		ret[0] = elternmutter[0];
		ret[1] = elternmutter[1];
		
		// Das Array enthält hier Großeltern väterlicherseits
		Person elternvater[] = getVater().getEltern();
		// Gleich wie oben, werden die Eltern der Eltern der Person genommen
		// und einfach im Array eingesetzt
		ret[2] = elternvater[0];
		ret[3] = elternvater[1];
		
		return ret;
	}
	
	/**
	 * Methode um alle Vorfahren einer Person die im Stammbaum eingetragen sind
	 * als String zurückzugeben. Die Methode funktioniert rekursiv!
	 * @return Alle Personen zeilenweise als String
	 */
	public String getListe() {
		// Hier wird jeweils die Person zurückgegeben die die Methode aufruft
		String ret = toString();
		// Wenn die Mutter der Person vorhanden ist und deswegen nicht null ist
		if (getMutter() != null) {
			// wird die Mutter ausgegeben und ruft dann die Methode selbst auf
			// Somit wird zum Beispiel die Mutter der Mutter gesucht
			ret += getMutter().getListe();
		}
		// Falls keine Mutter vorhanden ist, wird der obere Code übersprungen und man sucht nach dem Vater
		if (getVater() != null) {
			// Gleich wie bei der Mutter, wird jetzt der Vater ausgegeben und führt dann selbst die Methode aus
			ret += getVater().getListe();
		}
		return ret;
	}
		
	/* (non-Javadoc)
	 * Methode um die Eigenschaften einer Person als String auszugeben
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String mutter = null;
		String vater = null;
		if (getMutter() != null) {
			mutter = getMutter().getName();
		}
		if (getVater() != null) {
			vater = getVater().getName();
		}
		return getPersonNumber() + ": " + getName() + " w = " + isWeiblich()
				+ " m = "+ mutter + " v = "+ vater + "\n";
	}
}
