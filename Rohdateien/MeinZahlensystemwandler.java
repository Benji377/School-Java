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
	public static int getDigit (char nr)	
	/**
	 * Wandelt die Nummer der Ziffer nr in ein Zeichen um:
	 * 0 ergibt '0', 1 ergibt '1', ..., 9 ergibt '9', 10 ergibt 'A', 11 ergibt 'B', 
	 * ..., 35 ergibt 'Z'
	 * Sollte eine ungültige Nummer übergeben werden, so gibt die Methode einen Stern 
	 * '*' zurück
	 * @param nr die Nummer welche in ein Zeichen umgewandelt werden soll
	 * @return das Zeichen das für die Nummer steht
	 */
	public static char getDigit (int nr)
	
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
	public static int numToDec(String num, int basis)
	
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
	public static String decToNum(int dec, int basis)
	 
}