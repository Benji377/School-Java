
public class Weihnachtsbaum {

	public static void main(String[] args) {
		int n = 0;
		int leerAnzahl = 15;
		int sternAnzahl = 1;
		// Baum
		while (n < 15) {
			leerAnzahl--;
			printLeerzeichen(leerAnzahl);
			printSterne(sternAnzahl);
			printLeerzeichen(leerAnzahl);
			sternAnzahl += 2;
			System.out.println();
			n++;
		}
		// Stamm
		leerAnzahl = 15;
		int m = 0;
		while (m < 3) {
			printLeerzeichen(leerAnzahl - 2);
			printSterne(3);
			printLeerzeichen(leerAnzahl - 2);
			System.out.println();
			m++;
		}
		
	}
	/** Gibt anzahl Leerzeichen nebeneinander am  
	 * Bildschirm aus. Dabei wird nach dem  
	 * letzten ausgegebenen Leerzeichen keine  
	 * Zeilenschaltung gemacht  
	 * @param anzahl der auszugebenden  
	 * Leerzeichen  
	 * @return */ 
	public static int printLeerzeichen(int anzahl) {
		while (anzahl > 0) {
			System.out.print(" ");
			anzahl--;
		}
		return anzahl;
	}
	
	
	/**  * Wie vorige Methode nur mit Sternen  */ 
	public static int printSterne(int anzahl) {
		while (anzahl > 0) {
			System.out.print("*");
			anzahl--;
		}
		return anzahl;
	}

}
