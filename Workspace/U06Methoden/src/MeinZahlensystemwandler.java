public class MeinZahlensystemwandler
{
	/**
	 * Wandelt das Zeichen nr in eine Zahl um, wobei die Groß-/Klein-schreibung 
	 * ignoriert wird:
	 * '0' ergibt 0, '1' ergibt 1, ... '9' ergbit 9, 'A' ergibt 10, 'B' ergibt 11, ...,
	 * 'Z' ergibt 35
	 * Sollte ein ungültiges Zeichen übergeben werden, so gibt die Methode -1 zurück
	 * @param nr das umzuwandelnde Zeichen
	 * @return die Zahl für die das Zeichen steht
	 */
	public static int getDigit (char nr) {
		int ret = -1;
		// Wandelt den Character nr in Großbuchstabe um
		nr = Character.toUpperCase(nr);
		// In der Asci Tabelle sind die Zahlen von 0 bis 9 folgendermaßen
		// von 48 bis 57 numeriert
		if ((int)nr >= 48 && (int)nr <= 57) {
			// Somit wird einfach nur der numerische Wert übergeben und nicht 
			// die Stelle in der Ascii Tabelle
			ret = Character.getNumericValue(nr);
		// Die Großbuchstaben von A bis Z gehen in der Ascii Tabelle
		// von 65 bis 90
		} else if ((int)nr >= 64 && (int)nr <= 90) {
			// Damit 10 A entspricht, muss dem Wert in der asci Tabelle 55
			// subtrahiert werden
			ret = (int)nr - 55;
		}
		return ret;
	}
	/**
	 * Wandelt die Nummer der Ziffer nr in ein Zeichen um:
	 * 0 ergibt '0', 1 ergibt '1', ..., 9 ergibt '9', 10 ergibt 'A', 11 ergibt 'B', 
	 * ..., 35 ergibt 'Z'
	 * Sollte eine ungültige Nummer übergeben werden, so gibt die Methode einen Stern 
	 * '*' zurück
	 * @param nr die Nummer welche in ein Zeichen umgewandelt werden soll
	 * @return das Zeichen das für die Nummer steht
	 */
	public static char getDigit (int nr) {
		char ret = '*';
		// Wenn der übergebene Integer eine Ziffer zwischen 0 und 9 ist
		if (nr >= 0 && nr <= 9) {
			// Der Character ret ist gleich dem übergebenen Integer
			ret = (char)(nr + '0');
		// Wenn der übergebene Integer in ein Buchstabe umgewandelt werden soll
		} else if (nr >= 10 && nr <= 35 ) {
			// Der Character ret ist der Ascii wert nr + 55
			ret = (char)(nr + 55);
		}
		return ret;
	}
	
	/**
	 * Wandelt die Zahl num mit der Basis basis in eine Dezimalzahl um und liefert
	 * diese zurück. Falls die übergebene Zahl num gleich null oder deren Länge gleich
	 * 0 ist oder die Basis kleiner als 2 ist, wird -1 zurück geliefert. Wenn eine
	 * Ziffer der übergebenen Zahl nicht zur Basis pass, wird ebenfalls -1 zurück
	 * geliefert
	 * Beispiel: numToDec("01110110", 2) ergibt 118
	 * numToDec("170712", 8) ergibt 61898
	 * numToDec("170712", 7) ergibt -1
	 * @param num die umzuwandelnde Zahl als String übergeben
	 * @param basis die Basis der umzuwandelnden Zahl
	 * @return das Ergebnis im Dezimalsystem
	 */
	public static int numToDec(String num, int basis) {
		int ret = -1;
		if (!num.isEmpty() && num != null && basis >= 2) {
			int zahl = Integer.parseInt(num);
			int hochzahl = 0;
			ret = 0;
			while (zahl > 0) {
				if (zahl%10 >= basis) {
					zahl = 0;
					ret = -1;
				} else {
					ret += zahl%10 * (int)Math.pow(basis, hochzahl);
					zahl /= 10;
					hochzahl++;
				}
				
			}
		}
		return ret;
	}
	
	/**
	 * Wandelt die Dezimalzahl dec in eine Zahl mit der Basis basis um und gibt diese
	 * zurück. Dabei muss die Dezimalzahl dec größer oder gleich 0 sein und die Basis
	 * muss größer als 1 sein, ansonsten wird null zurück geliefert.
	 * Beispiel: decToNum(118,2) ergibt 1110110
	 * decToNum(61898,8) ergibt 170712
	 * @param dec die umzuwandelnde Dezimalzahl
	 * @param basis nach welcher umgewandelt wird
	 * @return die umgewandelte Zahl
	 */
	public static String decToNum(int dec, int basis) {
		String ret = "";
		int multiplikator = 1;
		int summe = 0;
		if (dec >= 0 && basis > 1) {
			while (dec > 0) {
				summe += (dec%basis) * multiplikator;
				dec /= basis;
				multiplikator *= 10;
			}
			ret += summe;
		} else {
			ret = null;
		}
		return ret;
	}
	
	/**
	 * Wandelt die Hexadezimalzahl hex in einer Dezimalzahl um und gibt diese
	 * zurück. Dabei muss die Dezimalzahl hex größer oder gleich 0 sein,
	 * ansonsten wird 0 zurück geliefert.
	 * Beispiel: hexToDec(16) ergibt 22
	 * hexToDec(189) ergibt 393
	 * @param hex die umzuwandelnde Hexadezimalzahl
	 * @return die umgewandelte Zahl
	 */
	public static int hexToDec(String hex) {
		int ret = 0;
		ret = Integer.parseInt(hex, 16);
		return ret;
	}
	
	/**
	 * Wandelt die Dezimalzahl dec in eine Hexadezimalzahl um und gibt diese
	 * zurück. Dabei muss die Dezimalzahl dec größer oder gleich 0 sein,
	 * ansonsten wird null zurück geliefert.
	 * Beispiel: decToHex(22) ergibt 16
	 * decToHex(393) ergibt 189
	 * @param dec die umzuwandelnde Dezimalzahl
	 * @return die umgewandelte Zahl
	 */
	public static String decToHex(int dec) {
		String ret = null;
		if (dec >= 0) {
			ret = Integer.toHexString(dec);
		}
		return ret;
	}
	
	/**
	 * Wandelt die Dualzahl dual in eine Dezimalzahl um und gibt diese
	 * zurück. Dabei muss die Duallzahl dual größer oder gleich 0 sein,
	 * ansonsten wird null zurück geliefert.
	 * Beispiel: dualToDec(1110110) ergibt 118
	 * dualToDec(11011010) ergibt 218
	 * @param dual die umzuwandelnde Dualzahl
	 * @return die umgewandelte Zahl
	 */
	public static int dualToDec(String dual) {
		int ret = 0;
		ret = Integer.parseInt(dual, 2);
		return ret;
	}
	
	/**
	 * Wandelt die Dezimalzahl dec in eine Dualzahl um und gibt diese
	 * zurück. Dabei muss die Dezimalzahl dec größer oder gleich 0 sein,
	 * ansonsten wird null zurück geliefert.
	 * Beispiel: decToDual(118) ergibt 1110110
	 * decToDual(218) ergibt 11011010
	 * @param dec die umzuwandelnde Dezimalzahl
	 * @return die umgewandelte Zahl
	 */
	public static String decToDual(int dec) {
		String ret = null;
		if (dec >= 0) {
			ret = Integer.toBinaryString(dec);
		}
		return ret;
	}
	
	/**
	 * Wandelt die Zahl num in eine Zahl mit der Basis basis im Zahlensystem sys 
	 * um und gibt diese zurück. Dabei muss die Zahl num größer oder gleich 0 sein,
	 * die Basis muss größer als 1 sein und das zahlensystem sys muss größer als 1 sein, 
	 * ansonsten wird null zurück geliefert.
	 * Beispiel: numToNum(125,8,16) ergibt 55
	 * numToNum(123,10,11) ergibt 102
	 * @param dec die umzuwandelnde Dezimalzahl
	 * @param basis nach welcher umgewandelt wird
	 * @return die umgewandelte Zahl
	 */
	public static String numToNum(String num, int basis, int sys) {
		String ret = null;
		int deci = Integer.parseInt(num, basis);
		if (sys == 2) {
			ret = Integer.toBinaryString(deci);
		} else if (sys == 8) {
			ret = Integer.toOctalString(deci);
		} else if (sys == 16) {
			ret = Integer.toHexString(deci);
		}
		return ret;
	}
	 
}