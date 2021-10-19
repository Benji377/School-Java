
public class FlexWeihnachtsbaum {

	public static void main(String[] args) {
		System.out.println("Der flexible Weihnachtsbaum");
		System.out.println("===========================");
		int n = 0;
		int baumhohe = readInt("Geben Sie die Höhe des Baumes ein: ");
		int stammhohe = readInt("Geben Sie die Höhe des Stammes ein: ");
		int stammabschnitt = baumhohe - 2;
		int sternAnzahl = 1;
		// Baum
		while (n < baumhohe) {
			baumhohe--;
			printLeerzeichen(baumhohe);
			printSterne(sternAnzahl);
			printLeerzeichen(baumhohe);
			sternAnzahl += 2;
			System.out.println();
		}
		// Stamm
		int m = 0;
		while (m < stammhohe) {
			printLeerzeichen(stammabschnitt);
			printSterne(3);
			printLeerzeichen(stammabschnitt);
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
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}
