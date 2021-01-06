
public class ZahlenratenUmgekehrt {

	public static void main(String[] args) {
		System.out.println("Umgekehrtes Zahlenraten");
		System.out.println("=======================");
		System.out.println("Suchen Sie sich eine Zahl im Intervall [0, 1000] aus."
				+ " Ich werde sie finden");
		
		// max_tipp und min_tipp definieren wie groß der Bereich der Zahl sein kann
		int max_tipp = 1000;
		int min_tipp = 0;
		boolean aktiv = true;
		
		while (aktiv) {
			// Berechnet den Durchschnitt
			int comptipp = (max_tipp + min_tipp) / 2;
			System.out.println("Mein Tipp: " + comptipp);
			int usertipp = readInt("Zahl kleiner (0), größer (1), gefunden (2): ");
			
			if (usertipp == 0) {
				max_tipp = comptipp;
			} else if (usertipp == 1) {
				min_tipp = comptipp;
			} else if (usertipp == 2) {
				System.out.println("Ich habe die Zahl gefunden!");
				aktiv = false;
			} else {
				aktiv = false;
			}
		}
		
	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}
