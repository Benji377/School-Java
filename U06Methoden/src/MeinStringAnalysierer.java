public class MeinStringAnalysierer {
	/**
	 * Liefert true zur�ck, wenn der String nicht null ist und nur Ziffern enth�lt.
	 * Beispiel: hatNurZiffern("12a43") ergibt false 
	 * hatNurZiffern("1242332322129") ergibt true
	 * @param s der zu untersuchende String
	 * @return true, falls der String nicht leer ist und nur aus Ziffern besteht
	 */
	public static boolean hatNurZiffern (String s) {
		boolean ret = false;
		// Z�hlt die Anzahl an Ziffern
		int counter = 0;
		// Wenn der �bergebene String nicht null und nicht leer ist
		if (s != null && s.length() > 0) {
			// Geht alle Character einzeln durch
			for (int i = 0; i < s.length(); i++) {
				// Wenn der Character eine Ziffer ist, wird der Counter um eins erh�ht
				if (Character.isDigit(s.charAt(i))) {
					counter++;
				}
			}
			// Wenn die l�nge des Strings mit dem Counter �bereinstimmt
			// bedeutet das, dass der String nur aus Ziffern besteht
			if (counter == s.length()) {
				ret = true;
			}
		}
		return ret;
	}
	
	/**
	 * liefert den �bergebenen String in umgekehrter Reihenfolge zur�ck. Falls der
	 * String null ist, wird null zur�ck geliefert.
	 * Beispiel: umdrehenString("Rudi") ergibt "iduR"
	 * @param s der umzudrehende String
	 * @return null falls der String s null ist, ansonsten den umgedrehten String
	 */
	public static String umdrehenString (String s) {
		String ret = "";
		// Wenn der �bergebene String nicht null ist
		if (s != null) {
			// Schleife geht jeden Character im String durch,
			// f�ngt aber von hinten an
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
	 * Liefert den um die Leerzeichen befreiten String zur�ck. Wird null �bergeben,
	 * so liefert die Methode null zur�ck.
	 * Beispiel: loeschenLeerzeichen("Susi Sorglos sitzt") ergibt "SusiSorglossitzt"
	 * @param s der von Leerzeichen zu s�ubernde String
	 * @return null falls der �bergebene String null ist, ansonsten den von Leerzeichen
	 * ges�uberten String
	 */
	public static String loeschenLeerzeichen (String s) {
		String ret = "";
		// Wenn der �bergebene String nicht null ist
		if (s != null) {
			// Alle leerzeichen im �bergebenen String werden somit gel�scht,
			// beziehungsweise mit "" ersetzt
			ret = s.replaceAll("\\s+", "");
		} else {
			ret = null;
		}
		return ret;
	}
	
	/**
	 * Testet ob der �bergebene String ein Palidrom ist, d. h. von hinten gelesen das 
	 * Selbe bedeutet wie von vorne gelesen. Falls null �bergeben wurde oder die L�nge
	 * des String 0 ist, wird false zur�ck geliefert.
	 * Bevor auf Palindrom getestet wird, werden alle Leerzeichen aus dem String 
	 * entfernt. Gro�-/Kleinschreibung wird bei der Analyse nicht beachtet
	 * Beispiel: istPalindrom("Otto") ergibt true
	 * istPalindrom("Ei nie") ergibt true
	 * istPalindrom("Ein Neger mit Gazelle zagt im Regen nie") ergibt true
	 * @param s der zu untersuchende String
	 * @return true, falls der String nicht null und eine L�nge gr��er als 0 und ein
	 * Palidrom ist
	 */
	public static boolean istPalindrom (String s) {
		boolean ret = false;
		// Wenn der �bergebene String nicht null und nicht leer ist
		if (s != null && !s.isEmpty()) {
			// Somit werden alle Leerzeichen vom String gel�scht
			s = loeschenLeerzeichen(s);
			// Somit wird der String umgedreht und in Kleinbuchstaben gestellt
			String checker = umdrehenString(s.toLowerCase());
			// Wenn der umgedrehte String gleich dem �bergebenenen String ist,
			// ist es ein Palindrom
			if (checker.equals(s.toLowerCase())) {
				ret = true;
			}
		}
		
		return ret;
	}
	
	/**
	 * Gibt einen String zur�ckgibt, in dem die Zahl zahl linksb�ndig steht. Der String 
	 * soll anzahl Zeichen lang sein. Es m�ssen also rechts solange Leerzeichen erg�nzt 
	 * werden, bis der String die passende L�nge hat.
	 * Ist die Zahl l�nger als anzahl, so wird die Zahl in ihrer gesamten L�nge zur�ck
	 * gegeben
	 * Beispiel: links(15,3) ergibt "15 "
	 * links(15,4) ergibt "15  "
	 * @param zahl die linksb�ndig ausgegeben werden soll
	 * @param anzahl die L�nge des auszugebenden Strings
	 * @return den String, der ganz links die Zahl enth�lt und der auf anzahl Stellen
	 * bei Bedarf aufgef�llt wurde
	 */
	public static String links (int zahl, int anzahl) {
		String ret = "";
		// Die �bergebene Zahl wird gleich dem String hinzugeh�ngt
		ret += zahl;
		// Wenn die L�nge des Strings immer noch kleiner ist als die Anzahl
		// an verlangten Zeichen 
		if (ret.length() < anzahl) {
			// Die L�nge des Strings wird von der gesamten Zeichenanzahl subtrahiert
			anzahl -= ret.length();
			// Schleife die von 0 bis zu anzahl geht
			for (int i = 0; i < anzahl; i++) {
				// Bei jedem Schleifendurchgang wird dem String ein Leerzeichen hinzugeh�ngt
				ret += " ";
			}
		}
		return ret;
	}
	
	/**
	 * Gibt einen String zur�ckgibt, in dem die Zahl zahl rechtsb�ndig steht. Der String 
	 * soll anzahl Zeichen haben. Es m�ssen also links solange Leerzeichen erg�nzt 
	 * werden, bis der String die passende L�nge hat.
	 * Ist die Zahl l�nger als anzahl, so wird die Zahl in ihrer gesamten L�nge zur�ck
	 * gegeben
	 * Beispiel: rechts(15,3) ergibt " 15"
	 * rechts(15,4) ergibt "  15"
	 * @param zahl die im String rechtsb�ndig ausgegeben werden soll
	 * @param anzahl die L�nge des auszugebenden Strings
	 * @return den String, der ganz rechts die Zahl enth�lt und der auf anzahl Stellen
	 * bei Bedarf aufgef�llt wurde
	 */
	public static String rechts (int zahl, int anzahl) {
		String ret = "";
		String check = "";
		//Die Zahl wird dem String check hinzugef�gt
		check += zahl;
		// Wenn die L�nge des Strings kleiner ist als die �bergebene anzahl
		if (check.length() < anzahl) {
			// anzahl wird dann von der Stringl�nge subtrahiert
			anzahl -= check.length();
			// Schleife geht dann von 0 bis anzahl
			for (int i = 0; i < anzahl; i++) {
				// Bei jedem Schleifendurchgang wird dem String ret ein Leerzeichen hinzugef�gt
				ret += " ";
			}
		}
		// Erst vor der Ausgabe wird die Zahl hinzugef�gt, nach alle Leerzeichen
		ret += zahl;
		return ret;
	}
	
	/**
	 * Z�hlt wie viele Buchstaben im String s vorhanden sind. Die deutschen Umlaute 
	 * werden nicht mitgez�hlt. Gro�-/Kleinschreibung wird ignoriert. 
	 * Ist s gleich null, so wird -1 als Ergebnis zur�ck geliefert
	 * Beispiel: zaehleBuchstaben("Hallo M�ller06"))ergibt 10
	 * @param s der auf Buchstaben hin zu testenden String
	 * @return -1 falls s gleich null ist, ansonsten die Anzahl der Buchstaben die in
	 * s zu finden sind 
	 */
	public static int zaehleBuchstaben (String s) {
		int ret = -1;
		// Wenn der �bergebene String nicht null ist
		if (s != null) {
			ret = 0;
			// Schleife geht alle Zeichen im String s durch
			for (int i = 0; i < s.length(); i++) {
				// Wenn der Character an Position i ein Buchstabe ist und kein Umlaut
				if (Character.isLetter(s.charAt(i)) && s.charAt(i) != '�' && s.charAt(i) != '�' && s.charAt(i) != '�') {
					// ret wird um eins erh�ht
					ret++;
				}
			}
		}
		return ret;
	}
	
	/**
	 * Z�hlt wie viele Zeichen im String s keine Buchstaben sind. Die deutschen Umlaute 
	 * werden mit gez�hlt (d.h. als keine Buchstaben interpretiert). Die 
	 * Gro�-/Kleinschreibung wird ignoriert. 
	 * Ist s gleich null, so wird -1 als Ergebnis zur�ck geliefert
	 * Beispiel: zaehleNichtBuchstaben("Hallo M�ller06")) ergibt 4
	 * @param s der auf Buchstaben hin zu testenden String
	 * @return -1 falls s gleich null ist, ansonsten die Anzahl der Zeichen im String,
	 * die nicht Buchstaben sind 
	 */
	public static int zaehleNichtBuchstaben (String s) {
		int ret = -1;
		// Wenn der �bergebene String nicht null ist
		if (s != null) {
			// rest ist gleich die Anzahl an Buchstaben subtrahiert von der L�nge des Strings s
			ret = s.length() - zaehleBuchstaben(s);
		}
		return ret;
	}
	
	/**
	 * Z�hlt wie oft das Zeichen c im String s vorkommt. Die Gro�-/Kleinschreibung 
	 * wird ignoriert.
	 * Ist s gleich null, so wird -1 als Ergebnis zur�ck geliefert
	 * Beispiel: zaehleZeichen("Alle Bananen sind krumm!", 'a') ergibt 3
	 * @param s der zu durchsuchende String
	 * @param c das Zeichen, welches im String gesucht werden soll
	 * @return -1 falls der �bergebenen String null ist, ansonsten die Anzahl wie oft
	 * das Zeichen c im String s vorkommt
	 */
	public static int zaehleZeichen (String s, char c) {
		int ret = -1;
		// Wenn der �bergebene String nicht null ist
		if (s != null) {
			ret = 0;
			// String s wird zu Kleinbuchstaben umgewandelt
			s = s.toLowerCase();
			// Geht alle Character im String s durch
			for (int i = 0; i < s.length(); i++) {
				// Wenn der Character an Index i gelich dem �bergebenen Zeichen c ist
				if (s.charAt(i) == Character.toLowerCase(c)) {
					// ret wird um eins erh�ht
					ret++;
				}
			}
		}
		return ret;
	}
	
	/**
	 * L�scht aus dem String s das Zeichen an der Position p.
	 * Falls der �bergebene String gleich null ist, die �bergebene Position < 0 oder
	 * �ber die L�nge des Strings hinaus geht, wird null zur�ck geliefert 
	 * Beispiel: loescheZeichenAnPosition("Peters@platz", 6) ergibt "Petersplatz"
	 * @param s der String in welchem das Zeichen gel�scht werden soll
	 * @param p die Position an welcher das Zeichen gel�scht werden soll
	 * @return den String, der das zu l�schende Zeichen an der Position nicht mehr
	 * enth�lt
	 */
	public static String loescheZeichenAnPosition (String s, int p) {
		String ret = null;
		String control = "";
		// Wenn der �bergebene String s nicht null ist, p gr��er als 0 und kleiner als
		// die L�nge des String s ist
		if (s != null && p >= 0 && p < s.length()) {
			// Dem String control wird der Character am Index p im Strings �bergeben
			control += s.charAt(p);
			// Dem String ret wird der String s �bergeben, wobei aber der Character im String control
			// im String s mit "" ausgetauscht werden
			ret = s.replace(control, "");
		}
		return ret;
	}
	
	/**
	 * L�scht alle Zeichen c aus dem String s. Gro�-/Kleinschreibung wird dabei beachtet.
	 * Falls als String null �bergeben wird, so wird null zur�ck geliefert
	 * Beispiel: loescheZeichen("Ein Keller", 'e') ergibt "Ein Kllr"
	 * @param s der String in welchem das Zeichen c gel�scht werden soll
	 * @param c das zu l�schende Zeichen
	 * @return der String, der keine Zeichen c mehr enth�lt
	 */
	public static String loescheZeichen (String s, char c) {
		String ret = null;
		String control = "";
		// Wenn der String nicht null ist
		if (s != null) {
			// Dem String control wird das zeichen c hinzugeh�ngt
			control += c;
			// Schleife geht jedes Zeichen im String s durch
			for (int i = 0; i < s.length(); i++) {
				// Wenn Character an Index i im String s gleich dem �bergebenen Character c
				// ist
				if (s.charAt(i) == c) {
					// Der Character c, der im String control steht, wird im String s
					// mit "" ausgetauscht
					s = s.replace(control, "");
				}
			}
			// dem String ret wird dem neuen String s �bergeben
			ret = s;
		}
		return ret;
	}
	
	/**
	 * L�scht aus dem String s einen Teilbereich heraus, der durch die Anfangsposition 
	 * start und durch seine L�nge l gegegeben ist. Werden alle Zeichen gel�scht, so muss
	 * null zur�ck gegeben werden
	 * Liefert null zur�ck, falls der �bergebene String null ist oder falls start
	 * und l �ber den String hinaus greifen.  s muss gr��er oder gleich 0 sein, und
	 * l muss gr��er als 0 sein
	 * Beispiel: loescheStringAnPosition("Hallo Leute!", 6, 5) ergibt "Hallo !"
	 * loeschenStringAnPosition("AG", 0, 2) ergibt null
	 * @param s der String in dem gel�scht werden soll
	 * @param start die Startposition ab der bel�scht werden werden
	 * @param l die Anzahl der zu l�schenden Zeichen
	 * @return der String, in dem mehrer Zeichen gel�scht wurden
	 */
	public static String loescheStringAnPosition (String s, int start, int l) {
		String ret = null;
		String repl = "";
		// Wenn String s nicht null, start gr��er als 0, l kleiner als die L�nge des String s,
		// der String s nicht leer ist, l gr��er als 0 und start gr��er las die L�nge des String s ist
		if (s != null && start > 0 && l < s.length() && s.length() >= 0 && l > 0 && start < s.length()) {
			// Dem String repl wird einem Teil vom String s �bergebene
			// Der Teil startet beim Index start und endet am Index start+l
			repl = s.substring(start, start+l);
			// Dem String ret wird der String s �bergeben, ohne den davor dem String repl
			// �bergebenen Teil
			ret = s.replace(repl, "");
		}
		return ret;
	}

	/**
	 * L�scht aus dem String s jedes Vorkommen des Strings ds. Die Gro�-/Kleinschreibung
	 * wird dabei beachtet. Die beiden �bergebenen Strings d�rfen nicht null sein und
	 * m�ssen Zeichen enthalten. Werden alle Zeichen gel�scht, so wird null zur�ck
	 * geliefert 
	 * Beispiel: loescheString("HHallallo Leute-HALLHallo", "Hall") ergibt
	 * "Hallo Leute-HALLo"
	 * loescheString("HallHall","Hall") ergibt null
	 * @param s der String in dem gel�scht werden soll
	 * @param ls der zu l�schende Teilstring
	 * @return der String, in dem der Teilstring nicht mehr vorkommt
	 */
	public static String loescheString (String s, String ls) {
		String ret = "";
		// Wenn der �bergebene String s nicht null, String ls nicht null,
		// String s nicht leer und String ls nicht leer ist
		if (s != null && ls != null && !s.isEmpty() && !ls.isEmpty()) {
			// Dem String ret wird dem String s �bergeben, wobei aber
			// der String ls im String s mit "" ausgetausch wurde
			ret = s.replace(ls, "");
			// Wenn der String ls den String s komplett l�scht
			if (ret.isEmpty()) {
				// ret wird auf null gesetzt
				ret = null;
			}
		}
		return ret;
	}
}
