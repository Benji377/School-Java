public class MeinStringAnalysierer {
	/**
	 * Liefert true zurück, wenn der String nicht null ist und nur Ziffern enthält.
	 * Beispiel: hatNurZiffern("12a43") ergibt false 
	 * hatNurZiffern("1242332322129") ergibt true
	 * @param s der zu untersuchende String
	 * @return true, falls der String nicht leer ist und nur aus Ziffern besteht
	 */
	public static boolean hatNurZiffern (String s) {
		boolean ret = false;
		// Zählt die Anzahl an Ziffern
		int counter = 0;
		// Wenn der übergebene String nicht null und nicht leer ist
		if (s != null && s.length() > 0) {
			// Geht alle Character einzeln durch
			for (int i = 0; i < s.length(); i++) {
				// Wenn der Character eine Ziffer ist, wird der Counter um eins erhöht
				if (Character.isDigit(s.charAt(i))) {
					counter++;
				}
			}
			// Wenn die länge des Strings mit dem Counter übereinstimmt
			// bedeutet das, dass der String nur aus Ziffern besteht
			if (counter == s.length()) {
				ret = true;
			}
		}
		return ret;
	}
	
	/**
	 * liefert den übergebenen String in umgekehrter Reihenfolge zurück. Falls der
	 * String null ist, wird null zurück geliefert.
	 * Beispiel: umdrehenString("Rudi") ergibt "iduR"
	 * @param s der umzudrehende String
	 * @return null falls der String s null ist, ansonsten den umgedrehten String
	 */
	public static String umdrehenString (String s) {
		String ret = "";
		// Wenn der übergebene String nicht null ist
		if (s != null) {
			// Schleife geht jeden Character im String durch,
			// fängt aber von hinten an
			for (int i = s.length() - 1; i >= 0; i--) {
				// Jeder Character wird dem leeren String dazugegeben
				ret += s.charAt(i);
			}
		} else {
			ret = null;
		}
		return ret;
	}

	/**
	 * Liefert den um die Leerzeichen befreiten String zurück. Wird null übergeben,
	 * so liefert die Methode null zurück.
	 * Beispiel: loeschenLeerzeichen("Susi Sorglos sitzt") ergibt "SusiSorglossitzt"
	 * @param s der von Leerzeichen zu säubernde String
	 * @return null falls der übergebene String null ist, ansonsten den von Leerzeichen
	 * gesäuberten String
	 */
	public static String loeschenLeerzeichen (String s) {
		String ret = "";
		// Wenn der übergebene String nicht null ist
		if (s != null) {
			// Alle leerzeichen im übergebenen String werden somit gelöscht,
			// beziehungsweise mit "" ersetzt
			ret = s.replaceAll("\\s+", "");
		} else {
			ret = null;
		}
		return ret;
	}
	
	/**
	 * Testet ob der übergebene String ein Palidrom ist, d. h. von hinten gelesen das 
	 * Selbe bedeutet wie von vorne gelesen. Falls null übergeben wurde oder die Länge
	 * des String 0 ist, wird false zurück geliefert.
	 * Bevor auf Palindrom getestet wird, werden alle Leerzeichen aus dem String 
	 * entfernt. Groß-/Kleinschreibung wird bei der Analyse nicht beachtet
	 * Beispiel: istPalindrom("Otto") ergibt true
	 * istPalindrom("Ei nie") ergibt true
	 * istPalindrom("Ein Neger mit Gazelle zagt im Regen nie") ergibt true
	 * @param s der zu untersuchende String
	 * @return true, falls der String nicht null und eine Länge größer als 0 und ein
	 * Palidrom ist
	 */
	public static boolean istPalindrom (String s) {
		boolean ret = false;
		// Wenn der übergebene String nicht null und nicht leer ist
		if (s != null && !s.isEmpty()) {
			// Somit werden alle Leerzeichen vom String gelöscht
			s = loeschenLeerzeichen(s);
			// Somit wird der String umgedreht und in Kleinbuchstaben gestellt
			String checker = umdrehenString(s.toLowerCase());
			// Wenn der umgedrehte String gleich dem übergebenenen String ist,
			// ist es ein Palindrom
			if (checker.equals(s.toLowerCase())) {
				ret = true;
			}
		}
		
		return ret;
	}
	
	/**
	 * Gibt einen String zurückgibt, in dem die Zahl zahl linksbündig steht. Der String 
	 * soll anzahl Zeichen lang sein. Es müssen also rechts solange Leerzeichen ergänzt 
	 * werden, bis der String die passende Länge hat.
	 * Ist die Zahl länger als anzahl, so wird die Zahl in ihrer gesamten Länge zurück
	 * gegeben
	 * Beispiel: links(15,3) ergibt "15 "
	 * links(15,4) ergibt "15  "
	 * @param zahl die linksbündig ausgegeben werden soll
	 * @param anzahl die Länge des auszugebenden Strings
	 * @return den String, der ganz links die Zahl enthält und der auf anzahl Stellen
	 * bei Bedarf aufgefüllt wurde
	 */
	public static String links (int zahl, int anzahl) {
		String ret = "";
		// Die übergebene Zahl wird gleich dem String hinzugehängt
		ret += zahl;
		// Wenn die Länge des Strings immer noch kleiner ist als die Anzahl
		// an verlangten Zeichen 
		if (ret.length() < anzahl) {
			// Die Länge des Strings wird von der gesamten Zeichenanzahl subtrahiert
			anzahl -= ret.length();
			// Schleife die von 0 bis zu anzahl geht
			for (int i = 0; i < anzahl; i++) {
				// Bei jedem Schleifendurchgang wird dem String ein Leerzeichen hinzugehängt
				ret += " ";
			}
		}
		return ret;
	}
	
	/**
	 * Gibt einen String zurückgibt, in dem die Zahl zahl rechtsbündig steht. Der String 
	 * soll anzahl Zeichen haben. Es müssen also links solange Leerzeichen ergänzt 
	 * werden, bis der String die passende Länge hat.
	 * Ist die Zahl länger als anzahl, so wird die Zahl in ihrer gesamten Länge zurück
	 * gegeben
	 * Beispiel: rechts(15,3) ergibt " 15"
	 * rechts(15,4) ergibt "  15"
	 * @param zahl die im String rechtsbündig ausgegeben werden soll
	 * @param anzahl die Länge des auszugebenden Strings
	 * @return den String, der ganz rechts die Zahl enthält und der auf anzahl Stellen
	 * bei Bedarf aufgefüllt wurde
	 */
	public static String rechts (int zahl, int anzahl) {
		String ret = "";
		String check = "";
		//Die Zahl wird dem String check hinzugefügt
		check += zahl;
		// Wenn die Länge des Strings kleiner ist als die übergebene anzahl
		if (check.length() < anzahl) {
			// anzahl wird dann von der Stringlänge subtrahiert
			anzahl -= check.length();
			// Schleife geht dann von 0 bis anzahl
			for (int i = 0; i < anzahl; i++) {
				// Bei jedem Schleifendurchgang wird dem String ret ein Leerzeichen hinzugefügt
				ret += " ";
			}
		}
		// Erst vor der Ausgabe wird die Zahl hinzugefügt, nach alle Leerzeichen
		ret += zahl;
		return ret;
	}
	
	/**
	 * Zählt wie viele Buchstaben im String s vorhanden sind. Die deutschen Umlaute 
	 * werden nicht mitgezählt. Groß-/Kleinschreibung wird ignoriert. 
	 * Ist s gleich null, so wird -1 als Ergebnis zurück geliefert
	 * Beispiel: zaehleBuchstaben("Hallo Müller06"))ergibt 10
	 * @param s der auf Buchstaben hin zu testenden String
	 * @return -1 falls s gleich null ist, ansonsten die Anzahl der Buchstaben die in
	 * s zu finden sind 
	 */
	public static int zaehleBuchstaben (String s) {
		int ret = -1;
		// Wenn der übergebene String nicht null ist
		if (s != null) {
			ret = 0;
			// Schleife geht alle Zeichen im String s durch
			for (int i = 0; i < s.length(); i++) {
				// Wenn der Character an Position i ein Buchstabe ist und kein Umlaut
				if (Character.isLetter(s.charAt(i)) && s.charAt(i) != 'ä' && s.charAt(i) != 'ö' && s.charAt(i) != 'ü') {
					// ret wird um eins erhöht
					ret++;
				}
			}
		}
		return ret;
	}
	
	/**
	 * Zählt wie viele Zeichen im String s keine Buchstaben sind. Die deutschen Umlaute 
	 * werden mit gezählt (d.h. als keine Buchstaben interpretiert). Die 
	 * Groß-/Kleinschreibung wird ignoriert. 
	 * Ist s gleich null, so wird -1 als Ergebnis zurück geliefert
	 * Beispiel: zaehleNichtBuchstaben("Hallo Müller06")) ergibt 4
	 * @param s der auf Buchstaben hin zu testenden String
	 * @return -1 falls s gleich null ist, ansonsten die Anzahl der Zeichen im String,
	 * die nicht Buchstaben sind 
	 */
	public static int zaehleNichtBuchstaben (String s) {
		int ret = -1;
		// Wenn der übergebene String nicht null ist
		if (s != null) {
			// rest ist gleich die Anzahl an Buchstaben subtrahiert von der Länge des Strings s
			ret = s.length() - zaehleBuchstaben(s);
		}
		return ret;
	}
	
	/**
	 * Zählt wie oft das Zeichen c im String s vorkommt. Die Groß-/Kleinschreibung 
	 * wird ignoriert.
	 * Ist s gleich null, so wird -1 als Ergebnis zurück geliefert
	 * Beispiel: zaehleZeichen("Alle Bananen sind krumm!", 'a') ergibt 3
	 * @param s der zu durchsuchende String
	 * @param c das Zeichen, welches im String gesucht werden soll
	 * @return -1 falls der übergebenen String null ist, ansonsten die Anzahl wie oft
	 * das Zeichen c im String s vorkommt
	 */
	public static int zaehleZeichen (String s, char c) {
		int ret = -1;
		// Wenn der übergebene String nicht null ist
		if (s != null) {
			ret = 0;
			// String s wird zu Kleinbuchstaben umgewandelt
			s = s.toLowerCase();
			// Geht alle Character im String s durch
			for (int i = 0; i < s.length(); i++) {
				// Wenn der Character an Index i gelich dem übergebenen Zeichen c ist
				if (s.charAt(i) == Character.toLowerCase(c)) {
					// ret wird um eins erhöht
					ret++;
				}
			}
		}
		return ret;
	}
	
	/**
	 * Löscht aus dem String s das Zeichen an der Position p.
	 * Falls der übergebene String gleich null ist, die übergebene Position < 0 oder
	 * über die Länge des Strings hinaus geht, wird null zurück geliefert 
	 * Beispiel: loescheZeichenAnPosition("Peters@platz", 6) ergibt "Petersplatz"
	 * @param s der String in welchem das Zeichen gelöscht werden soll
	 * @param p die Position an welcher das Zeichen gelöscht werden soll
	 * @return den String, der das zu löschende Zeichen an der Position nicht mehr
	 * enthält
	 */
	public static String loescheZeichenAnPosition (String s, int p) {
		String ret = null;
		String control = "";
		// Wenn der übergebene String s nicht null ist, p größer als 0 und kleiner als
		// die Länge des String s ist
		if (s != null && p >= 0 && p < s.length()) {
			// Dem String control wird der Character am Index p im Strings übergeben
			control += s.charAt(p);
			// Dem String ret wird der String s übergeben, wobei aber der Character im String control
			// im String s mit "" ausgetauscht werden
			ret = s.replace(control, "");
		}
		return ret;
	}
	
	/**
	 * Löscht alle Zeichen c aus dem String s. Groß-/Kleinschreibung wird dabei beachtet.
	 * Falls als String null übergeben wird, so wird null zurück geliefert
	 * Beispiel: loescheZeichen("Ein Keller", 'e') ergibt "Ein Kllr"
	 * @param s der String in welchem das Zeichen c gelöscht werden soll
	 * @param c das zu löschende Zeichen
	 * @return der String, der keine Zeichen c mehr enthält
	 */
	public static String loescheZeichen (String s, char c) {
		String ret = null;
		String control = "";
		// Wenn der String nicht null ist
		if (s != null) {
			// Dem String control wird das zeichen c hinzugehängt
			control += c;
			// Schleife geht jedes Zeichen im String s durch
			for (int i = 0; i < s.length(); i++) {
				// Wenn Character an Index i im String s gleich dem übergebenen Character c
				// ist
				if (s.charAt(i) == c) {
					// Der Character c, der im String control steht, wird im String s
					// mit "" ausgetauscht
					s = s.replace(control, "");
				}
			}
			// dem String ret wird dem neuen String s übergeben
			ret = s;
		}
		return ret;
	}
	
	/**
	 * Löscht aus dem String s einen Teilbereich heraus, der durch die Anfangsposition 
	 * start und durch seine Länge l gegegeben ist. Werden alle Zeichen gelöscht, so muss
	 * null zurück gegeben werden
	 * Liefert null zurück, falls der übergebene String null ist oder falls start
	 * und l über den String hinaus greifen.  s muss größer oder gleich 0 sein, und
	 * l muss größer als 0 sein
	 * Beispiel: loescheStringAnPosition("Hallo Leute!", 6, 5) ergibt "Hallo !"
	 * loeschenStringAnPosition("AG", 0, 2) ergibt null
	 * @param s der String in dem gelöscht werden soll
	 * @param start die Startposition ab der belöscht werden werden
	 * @param l die Anzahl der zu löschenden Zeichen
	 * @return der String, in dem mehrer Zeichen gelöscht wurden
	 */
	public static String loescheStringAnPosition (String s, int start, int l) {
		String ret = null;
		String repl = "";
		// Wenn String s nicht null, start größer als 0, l kleiner als die Länge des String s,
		// der String s nicht leer ist, l größer als 0 und start größer las die Länge des String s ist
		if (s != null && start > 0 && l < s.length() && s.length() >= 0 && l > 0 && start < s.length()) {
			// Dem String repl wird einem Teil vom String s übergebene
			// Der Teil startet beim Index start und endet am Index start+l
			repl = s.substring(start, start+l);
			// Dem String ret wird der String s übergeben, ohne den davor dem String repl
			// übergebenen Teil
			ret = s.replace(repl, "");
		}
		return ret;
	}

	/**
	 * Löscht aus dem String s jedes Vorkommen des Strings ds. Die Groß-/Kleinschreibung
	 * wird dabei beachtet. Die beiden übergebenen Strings dürfen nicht null sein und
	 * müssen Zeichen enthalten. Werden alle Zeichen gelöscht, so wird null zurück
	 * geliefert 
	 * Beispiel: loescheString("HHallallo Leute-HALLHallo", "Hall") ergibt
	 * "Hallo Leute-HALLo"
	 * loescheString("HallHall","Hall") ergibt null
	 * @param s der String in dem gelöscht werden soll
	 * @param ls der zu löschende Teilstring
	 * @return der String, in dem der Teilstring nicht mehr vorkommt
	 */
	public static String loescheString (String s, String ls) {
		String ret = "";
		// Wenn der übergebene String s nicht null, String ls nicht null,
		// String s nicht leer und String ls nicht leer ist
		if (s != null && ls != null && !s.isEmpty() && !ls.isEmpty()) {
			// Dem String ret wird dem String s übergeben, wobei aber
			// der String ls im String s mit "" ausgetausch wurde
			ret = s.replace(ls, "");
			// Wenn der String ls den String s komplett löscht
			if (ret.isEmpty()) {
				// ret wird auf null gesetzt
				ret = null;
			}
		}
		return ret;
	}
}
