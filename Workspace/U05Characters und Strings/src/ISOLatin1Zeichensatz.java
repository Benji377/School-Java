
public class ISOLatin1Zeichensatz {

	public static void main(String[] args) {
		
		// Variablen werden deklariert. a ist 32 weil die ersten 32 zeichen werden übersprungen
		int a = 32;
		int zeile = 1;
		int spalte = 1;
		
		// Schleife die 28 in horrizontaler Richtung ausgibt
		while (zeile <= 28) {
			spalte = 1;
			
			// Schleife die 8 Zeichen in waagrechter Richtung ausgibt
			while (spalte <= 8) {
				printZahl(a);
				spalte += 1;
				a++;
			}
			// Hier geht es jedes mal neue Zeile
			System.out.println("");
			zeile += 1;
		}

	}
	public static void printZahl(int zahl) {
		if (zahl < 10)
			System.out.print("   " + zahl + " " + (char)zahl + " ");
		else
			if (zahl < 100)
				System.out.print("  " + zahl + " " + (char)zahl + " ");
			else
				System.out.print(" " + zahl + " " + (char)zahl + " ");
	}

}
