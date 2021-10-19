public class Song {
	// Eigenschaften des Songs werden festgesetzt
	private String titel;
	private String interpreter;
	private String album;
	private int erscheinungsjahr;
	
	
	/**
	 * Methode um den Titel des Songs zurückzugeben
	 * @return den Titel des Songs
	 */
	public String getTitel() {
		return titel;
	}
	
	/**
	 * Methode um den Titel des Songs zu setzen
	 * @param titel den Titel des Songs
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}
	/**
	 * Methode um den Interpreter des Songs zurückzugeben
	 * @return den Interpreter des Songs
	 */
	public String getInterpreter() {
		return interpreter;
	}
	/**
	 * Methode um den Interpreter des Songs zu setzen
	 * @param interpreter Der Interpreter des Songs
	 */
	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}
	/**
	 * Methode um das Erscheinungsjahr des Songs zurückzugeben
	 * @return das Erscheinungsjahr des Songs
	 */
	public int getErscheinungsjahr() {
		return erscheinungsjahr;
	}
	/**
	 * Methode um das Erscheinungsjahr des Songs zu setzen
	 * @param erscheinungsjahr das Erscheinungsjahr des Songs
	 */
	public void setErscheinungsjahr(int erscheinungsjahr) {
		// Da das Jahr nicht kleiner als null sin darf, wird es wenn es negativ ist einfach
		// in einer positiven Zahl verwandelt
		if (erscheinungsjahr < 0) {
			erscheinungsjahr *= -1;
		}
		this.erscheinungsjahr = erscheinungsjahr;
	}
	/**
	 * Methode um den Album des Songs zurückzugeben
	 * @return den Album des Songs
	 */
	public String getAlbum() {
		return album;
	}
	/**
	 * Methode um den Album des Songs zu setzen
	 * @param album der Album des Songs
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	
	/**
	 * Methode um zu vergleichen ob zwei Songs gleich sind
	 * @param s der zu vergleichende Song
	 * @return true wenn gleich, sonst false
	 */
	public boolean equals(Song s) {
		boolean ret = false;
		// Vergleicht die Eigenschaften der beiden Songs
		if(s.getErscheinungsjahr() == getErscheinungsjahr()
				&& s.getInterpreter().equals(getInterpreter())
				&& s.getTitel().equals(getTitel())
				&& s.getAlbum().equals(getAlbum())) {
			ret = true;
		}
		return ret;
	}

	/**
	 * Vergleicht den übergebenen Song s um zu ermitteln ob
	 * es größer(ergibt 1), kleiner(ergibt -1) oder gleich ist(ergibt 0)
	 * @param s der zu vergleichende Song
	 * @return 1 wenn Song s größer ist, -1 wenn kleiner und sonst 0
	 */
	public int compareTo(Song s) {
		int ret = 0;
		// Die Länge der Strings bestimmt die Größe eines Songs
		if (s.getAlbum().length()+s.getInterpreter().length()+s.getTitel().length()
				>getAlbum().length()+getInterpreter().length()+getTitel().length()) {
			ret = 1;
		} else if (s.getAlbum().length()+s.getInterpreter().length()+s.getTitel().length()
				<getAlbum().length()+getInterpreter().length()+getTitel().length()) {
			ret = -1;
		}
		return ret;
	}
	
	/* (non-Javadoc)
	 * Überschreibt die clone Methode
	 * Erstellt einen neuen Song Objekt, der die gleichen Eigenschaften hat wie der alte
	 * @see java.lang.Object#clone()
	 */
	public Song clone() {
		// neuer Song Objekt
		Song ret = new Song();
		// Alle Eigenschaften des alten Objekt werdem dem neuen übergeben
		ret.setAlbum(getAlbum());
		ret.setErscheinungsjahr(getErscheinungsjahr());
		ret.setInterpreter(getInterpreter());
		ret.setTitel(getTitel());
		return ret;
	}
	
	/* (non-Javadoc)
	 * Überschreibt die toString Methode
	 * Gibt die Eigenschaften als String zurück
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getTitel()+";"+getAlbum()+";"+getInterpreter()+";"+getErscheinungsjahr();
	}
	
	/**
	 * Methode die einen in String-Form übergebenen Song geordnet zurückgibt
	 * @param s DEr String in dem alle Informationen des Songs steht
	 * @return Die Informationen des Songs in geordneter Form
	 */
	public String setSong(String s) {
		// Am Anfang ist der String leer
		String ret = "";
		// Temporäre String zum zwischenspeichern
		String temp = "";
		// Wichtige Kontrollvariabeln
		int n = 0;
		int j = 0;
		// Geht jeden Character im String durch
		for (int i = 0; i < s.length(); i++) {
			// Wenn das Trennzeichen gefunden wird, in diesem Fall ';' oder die Schleife am Ende angekommen ist
			if (s.charAt(i) == ';' || i == s.length()-1) {
				// n wird um eins erhöht für den switch case darunter
				n++;
				// Mit substring wird nur der Teil des Strings herausgeschnitten, der gebraucht wird
				if (i == s.length()-1) {
					temp = s.substring(j, i+1);
				} else {
					temp = s.substring(j, i);
				}
				// j wird gebraucht um beim substring richtig zu schneiden
				j = i+1;
				// n wird gebraucht um zu bestimmen was ist was
				switch(n) {
				case 1:
					// Der erste Teil des Strings ist der Titel
					setTitel(temp);
					break;
				case 2:
					// Der zweite Teil des Strings ist der Album
					setAlbum(temp);
					break;
				case 3:
					// Der dritte Teil des Strings ist der Interpreter
					setInterpreter(temp);
					break;
				case 4:
					// Der letzte Teil des Strings ist der Erscheinungsjahr
					// Man benutzt parseInt um es von String zu einem Integer zu konvertieren
					setErscheinungsjahr(Integer.parseInt(temp));
					break;
				}	
			}

		}
		// So wird es geordnet ausgegeben
		ret = "Titel:            "+getTitel()+"\n"+
			  "Album:            "+getAlbum()+"\n"+
			  "Interpreter:      "+getInterpreter()+"\n"+
			  "Erscheinungsjahr: "+getErscheinungsjahr();
		return ret;
	}
}
