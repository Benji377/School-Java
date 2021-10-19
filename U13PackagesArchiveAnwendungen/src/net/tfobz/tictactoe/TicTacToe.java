package net.tfobz.tictactoe;

import java.util.Vector;

public class TicTacToe {
	private int[][] spielfeld;
	public static final int SPIELER1 = -1;
	public static final int SPIELER2 = -2;
	
	public TicTacToe(int feldgroesse) {
		// Wird benutzt um das Array zu füllen
		int counter = 0;
		// Setzt die größe auf drei wenn die eingegebene Zahl zu klein ist
		if (feldgroesse < 3)
			feldgroesse = 3;
		// Stellt die Größe des Spielfelds fest
		setSpielfeld(new int[feldgroesse][feldgroesse]);
		
		// Füllt das Array auf
		for (int i = 0; i < feldgroesse; i++) {
			for (int j = 0; j < feldgroesse; j++) {
				getSpielfeld()[i][j] = counter;
				counter++;
			}
		}
	}
	/**
	 * @return the spielfeld
	 */
	public int[][] getSpielfeld() {
		return spielfeld;
	}
	/**
	 * @param spielfeld the spielfeld to set
	 */
	public void setSpielfeld(int[][] spielfeld) {
		this.spielfeld = spielfeld;
	}
	/**
	 * @return the spieler1
	 */
	public static int getSpieler1() {
		return SPIELER1;
	}
	/**
	 * @return the spieler2
	 */
	public static int getSpieler2() {
		return SPIELER2;
	}



	@Override
	public String toString() {
		String ret = "";
		// TODO: Fehler bei der Ausgabe, siehe nach!
		int groessteZahl = getFeldgroesse() * getFeldgroesse() - 1;
		int anzahlNull = 0;
		int temp_counter = 0;
		int temp_number = 0;
		while (groessteZahl / 10 != 0 || groessteZahl > 0) {
			groessteZahl /= 10;
			anzahlNull++;
		}
		// Liest das gesamte Array aus Zahl für Zahl
		for (int i = 0; i < getSpielfeld().length; i++) {
			for (int j = 0; j < getSpielfeld()[i].length; j++) {
				// Ersetzt Spielerzahlen mit Zeichen
				if (getSpielfeld()[i][j] == getSpieler1()) {
					ret += printZahl(anzahlNull, "X");
				} else if (getSpielfeld()[i][j] == getSpieler2()) {
					ret += printZahl(anzahlNull, "O");
				} else {
					temp_number = getSpielfeld()[i][j];
					if (temp_number == 0) {
						ret += printZahl(anzahlNull, String.valueOf(getSpielfeld()[i][j]));
					} else {
						while (temp_number / 10 != 0 || temp_number > 0) {
							temp_number /= 10;
							temp_counter++;
						}
						ret += printZahl(anzahlNull-temp_counter+1, String.valueOf(getSpielfeld()[i][j]));
					}
					temp_counter = 0;
				}
			}
			// Geht neue Zeile nach jeder ausgegebenen Zeile
			ret+="\n";
		}
		return ret;
	}
	
	/**
	 * Gibt die Feldgröße des Spielfeldes zurück
	 * @return Größe des Spielfeldes
	 */
	public int getFeldgroesse() {
		return getSpielfeld().length;
	}
	
	/**
	 * Ermittelt ob die Zeile und Spalte im Spielfeld existieren und wer sie
	 * eventuell besetzt
	 * @param zeile Die Zeile im Feld
	 * @param spalte Die Spalte im Feld
	 * @return 0 wenn die Zahl frei ist,
	 * 					-3 wenn die Zahl sich außerhalb des Feldes befindet
	 * 					Die Spielernummer des Spieler der das Feld an der Stelle besetzt
	 */
	public int getSpielfeld(int zeile, int spalte) {
		int ret;
		try {
			if (getSpielfeld()[zeile][spalte] == getSpieler1())
				ret = getSpieler1();
			else if (getSpielfeld()[zeile][spalte] == getSpieler2())
				ret = getSpieler2();
			else
				ret = 0;
		} catch (IndexOutOfBoundsException e) {
			ret = -3;
		}
		return ret;
	}
	
	/**
	 * Setzt den Zug für Spieler 2
	 * @param zug den zu setzenden Zug
	 * @return siehe setZug()
	 */
	public int setZugSpieler1(int zug) {
		return setZug(zug, getSpieler1());
	}
	
	/**
	 * Setzt den Zug für Spieler 1
	 * @param zug den zu setzenden Zug
	 * @return siehe setZug()
	 */
	public int setZugSpieler2(int zug) {
		return setZug(zug, getSpieler2());
	}
	
	/**
	 * Setzt den Zug für den übergebenen Spieler
	 * @param zug Der zu setzende Zug
	 * @param spielernummer Die nummer des Spielers
	 * @return 0 wenn der Zug erfolgreich gesetzt wurde,
	 * 					-2 wenn ein Spieler bereits den Zug besetzt
	 * 					-1 wenn sich der Zug außerhalb des Feldes befindet
	 */
	public int setZug(int zug, int spielernummer) {
		int ret;
		// Ermittelt die Zeile und Spalte im Feld
		int zeile = zug/getFeldgroesse();
		int spalte = zug - zeile * getFeldgroesse();
		
		try {
			// Stelle vom Spieler besetzt
			if (getSpielfeld(zeile, spalte) == getSpieler1() || getSpielfeld(zeile, spalte) == getSpieler2()) {
				ret = -2;
			} else {
				// Mache kopie vom Feld
				int[][] s = getSpielfeld();
				// Füge Spielernummer an Position ein
				s[zeile][spalte] = spielernummer;
				// Ersetze das alte Feld mit dem neuen
				setSpielfeld(s);
				ret = 0;
			}
		} catch (IndexOutOfBoundsException e) {
			ret = -1;
		}
		return ret;
	}
	
	/**
	 * Ermittelt ob es einen Gewinner gibt
	 * @return 0 wenn kein Gewinner feststeht, SPIELER1 oder SPIELER2
	 */
	public int getGewonnen() {
		int ret = 0;
		int counter1 = 0;
		int counter2 = 0;
		
		// Kontrolliert ob die Zeile gefüllt ist
		for (int i = 0; i < getFeldgroesse(); i++) {
			for (int j = 0; j < getFeldgroesse(); j++) {
				// Es werden hier die Anzahl an besetzte Felder gezählt
				if (getSpielfeld(i, j) == getSpieler1())
					counter1++;
				if (getSpielfeld(i,j) == getSpieler2())
					counter2++;
			}
			// Ist die Anzahl an besetzte Felder gleich die Anzahl an Felder in eine Zeile
			// hat man gewonnen
			if (counter1 == getFeldgroesse()) {
				ret = getSpieler1();
				i = getFeldgroesse();
			}
			if (counter2 == getFeldgroesse()) {
				ret = getSpieler2();
				i = getFeldgroesse();
			}
			// Ansonsten wird der Zähler auf 0 gesetzt und zur nächsten Zeile übergegangen
			counter1 = counter2 = 0;
		}
		
		// Wenn noch kein Gewinner feststellt
		if (ret == 0) {
			// Kontrolliert ob die Spalte gefüllt ist
			for (int i = 0; i < getFeldgroesse(); i++) {
				for (int j = 0; j < getFeldgroesse(); j++) {
					// Es werden hier die Anzahl an besetzte Felder gezählt
					if (getSpielfeld(j, i) == getSpieler1())
						counter1++;
					if (getSpielfeld(j,i) == getSpieler2())
						counter2++;
				}
				// Ist die Anzahl an besetzte Felder gleich die Anzahl an Felder in eine Spalte
				// hat man gewonnen
				if (counter1 == getFeldgroesse()) {
					ret = getSpieler1();
					i = getFeldgroesse();
				}
				if (counter2 == getFeldgroesse()) {
					ret = getSpieler2();
					i = getFeldgroesse();
				}
				// Ansonsten wird der Zähler auf 0 gesetzt und zur nächsten Spalte übergegangen
				counter1 = counter2 = 0;
			}
		}
		// Kontrolliert nochmalls dass man kein gewinner hat
		if (ret == 0) {
			// Kontrolliert ob die Diagonale  vom linken Eck gefüllt ist
			for (int i = 0; i < getFeldgroesse(); i++) {
				if (getSpielfeld(i, i) == getSpieler1())
					counter1++;
				if (getSpielfeld(i,i) == getSpieler2())
					counter2++;
			}
			if (counter1 == getFeldgroesse()) {
				ret = getSpieler1();
			}
			if (counter2 == getFeldgroesse()) {
				ret = getSpieler2();
			}
			counter1 = counter2 = 0;
		}
		
		if (ret == 0) {
			// Kontrolliert ob die Diagonale vom linken Eck gefüllt ist
			int j = getFeldgroesse();
			for (int i = 0; i < getFeldgroesse(); i++) {
				j--;
				if (getSpielfeld(i, j) == getSpieler1())
					counter1++;
				if (getSpielfeld(i,j) == getSpieler2())
					counter2++;
			}
			if (counter1 == getFeldgroesse()) {
				ret = getSpieler1();
			}
			if (counter2 == getFeldgroesse()) {
				ret = getSpieler2();
			}
			counter1 = counter2 = 0;
		}
		
		return ret;
	}
	
	/**
	 * Ermittelt ob ein Spieler noch gewinnen kann
	 * @return true wenn es noch möglich ist, ansonsten false
	 */
	public boolean getEinerKannGewinnen() {
		/*
		 * Kontrolliere jede Spalte und Zeile, wenn eine Zeile X und O beinhaltet kann man dort nicht mehr gewinnen
		 * Diese Zeile soll an der "ungewinnbare zeile" Vector hinzugefügt werden. Das Gleiche mit Diagonalen und Spalten.
		 * Wenn die Anzahl an nicht gewinnbare Zeilen bzw. Spalten der Anzahl an Spalten und Zeilen des Spielfeld
		 * entspricht wird das Spiel mit unentschieden beendet.
		 * Gleiche mit Diagonalen
		 */
		// Vectoren beinhalten die ungültige Zeilen, Spalten und Diagonalen
		Vector<Integer> besetzteZeilen = new Vector<Integer>();
		Vector<Integer> besetzteSpalten = new Vector<Integer>();
		Vector<Integer> besetzteDiagonalen = new Vector<Integer>();
		// Zählt die Anzahl an von Spieler besetzten Felder
		int counter1 = 0;
		int counter2 = 0;
		// Ob noch gewinnen werden kann
		boolean ret = true;
		
		// Ermittelt ob es noch freie Felder gibt
		for (int i = 0; i < getFeldgroesse(); i++) {
			for (int j = 0; j < getFeldgroesse(); j++) {
				if (getSpielfeld(i, j) == getSpieler1())
					// Zählt die besetzten Felder
					counter1++;
				else if (getSpielfeld(i, j) == getSpieler2())
					counter2++;
			}
		}
		// Wenn alle Felder besetzt sind müssen die unteren Kontrollen nicht ausgeführt werden
		if (counter1+counter2 == getFeldgroesse() * getFeldgroesse())
			ret = false;
		else
			// Counter werden wieder auf 0 gesetzt
			counter1 = counter2 = 0;
		
		// Wenn nicht alle Felder besetzt sind
		if (ret) {
			// Gehe jede Zeile durch
			for (int i = 0; i < getFeldgroesse(); i++) {
				for (int j = 0; j < getFeldgroesse(); j++) {
					// Es werden hier die Anzahl an besetzte Felder gezählt
					if (getSpielfeld(i, j) == getSpieler1())
						counter1++;
					if (getSpielfeld(i, j) == getSpieler2())
						counter2++;
				}
				// Kontrolliert ob mindestens beide Spieler in einer Zeile ein Feld besetzten
				if (counter1 > 0 && counter2 > 0) {
					// Kontrolliert ob die Zeile sich im Vector befindet
					if (!besetzteZeilen.contains(i)) {
						// Wenn nicht, wird es am Ende des Vector hinzugefügt
						besetzteZeilen.add(i);
					}
					// Counter werden zurückgesetzt
					counter1 = counter2 = 0;
				}
			}
			// Geht alle Spalten und deren Felder durch
			for (int i = 0; i < getFeldgroesse(); i++) {
				for (int j = 0; j < getFeldgroesse(); j++) {
					// Es werden hier die Anzahl an besetzte Felder gezählt
					if (getSpielfeld(j, i) == getSpieler1())
						counter1++;
					if (getSpielfeld(j,i) == getSpieler2())
						counter2++;
				}
				// Kontrolliert ob mindestens beide Spieler in einer Spalte ein Feld besetzten
				if (counter1 > 0 && counter2 > 0) {
					// Kontrolliert ob die Spalte sich im Vector befindet
					if (!besetzteSpalten.contains(i)) {
						// Wenn nicht, wird es am Ende des Vector hinzugefügt
						besetzteSpalten.add(i);
					}
					counter1 = counter2 = 0;
				}
			}
			
			// Geht alle Felder in der Diagonale die im linken oberen Eck startet durch
			for (int i = 0; i < getFeldgroesse(); i++) {
				if (getSpielfeld(i, i) == getSpieler1())
					counter1++;
				if (getSpielfeld(i,i) == getSpieler2())
					counter2++;
			}
			// Kontrolliert ob mindestens beide Spieler in der Diagonale ein Feld besetzten
			if (counter1 > 0 && counter2 > 0) {
				// Es gibt nur zwei Diagonalen: 0 und 1
				besetzteDiagonalen.add(0);
				counter1 = counter2 = 0;
			}
			// Geht alle Felder in der Diagonale die im rechten oberen Eck startet durch
			int j = getFeldgroesse();
			for (int i = 0; i < getFeldgroesse(); i++) {
				j--;
				if (getSpielfeld(i, j) == getSpieler1())
					counter1++;
				if (getSpielfeld(i,j) == getSpieler2())
					counter2++;
			}
			// Kontrolliert ob mindestens beide Spieler in der Diagonale ein Feld besetzten
			if (counter1 > 0 && counter2 > 0) {
				// Es gibt nur zwei Diagonalen: 0 und 1 
				besetzteDiagonalen.add(1);
				counter1 = counter2 = 0;
			}
		}
		// Counter werden zurückgsetzt
		counter1 = counter2 = 0;
		// Wenn alle Zeilen, Spalten und Diagonalen besetzt sind, kann man nicht mehr gewinnen
		if (besetzteZeilen.size() == getFeldgroesse() && besetzteSpalten.size() == getFeldgroesse() && besetzteDiagonalen.size() == 2)
			ret = false;
		
		// Ob es noch möglich ist zu gewinnen
		return ret;
	}
	
	/**
	 * Methode um Zahlen untereinander auszugeben
	 * @param anzahlNull Anzahl von Leerzeichen vor dem Text
	 * @param text Text der ausgegeben werden soll
	 * @return String mit leeren Feldern davr
	 */
	public String printZahl(int anzahlNull, String text) {
		String ret = "";
		// Für den Fall dass negative Zahlen eingegeben werden, wird es auf 0 gesetzt
		if (anzahlNull > 0) {
			// Zählt und fügt Leerzeichen dem String hinzu
			for (int i = 0; i < anzahlNull; i++) {
				ret += " ";
			}
		}
		// Fügt dem String text hinzu
		ret += text;
		return ret;
	}
}