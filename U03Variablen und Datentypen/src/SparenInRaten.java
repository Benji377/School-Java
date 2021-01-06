
public class SparenInRaten {

	public static void main(String[] args) {
		// Eingabe vom Benutzer
		int guthaben = readInt("Geben Sie das Guthaben am Jahresanfang ein: ");
		int monatsrate = readInt("Geben Sie die Monatsrate ein: ");
		double jahreszinssatz = readDouble("Geben Sie den Jahreszinssatz ein: ");
		
		
		double gesamtzinsen = 0;
		int n = 12;
		while (n >= 1) {
			gesamtzinsen += jahreszinssatz * n/12.;
			n--;
		}
		// Formel zur Berechnung des Endguthaben
		double endguthaben = guthaben + (guthaben * jahreszinssatz)/100 + 12 * monatsrate + gesamtzinsen/2;
		System.out.println();
		// Ausgabe des Endguthaben mit zwei Nachkommastellen
		System.out.println("Das Guthaben am Ende des Jahres beträgt: "+ Math.floor(endguthaben*100)/100.0);

	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}
	public static double readDouble(String text) {
		System.out.print(text);
		return (new java.util.Scanner(System.in)).nextDouble();
	}

}
