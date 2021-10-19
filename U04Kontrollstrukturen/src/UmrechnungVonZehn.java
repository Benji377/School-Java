
public class UmrechnungVonZehn {

	public static void main(String[] args) {
		System.out.println("Umrechnung vom Zehnersystem");
		System.out.println("===========================");
		
		// Zahl wird eingegeben
		int zahl = readInt("Geben Sie die Zahl ein: ");
		// Varablen werden festgelegt
		boolean aktiv = true;
		int multiplikator = 1;
		int summe = 0;
		
		// Bleibt aktiv bis der Benutzer eine gültige Basis eingetragen hat
		while (aktiv) {
			int basis = readInt("Geben Sie die Basis ein: ");
			if (basis > 1 && basis < 10) {
				System.out.println();
			} else {
				System.out.println("Basis muss zwischen 2 und 9 liegen");
				continue;
			}
			// Rechnet die Zahl um
			while (zahl > 0) {
				summe += (zahl%basis) * multiplikator;
				zahl /= basis;
				multiplikator *= 10;
			}
			// Gibt die Zahl aus
			System.out.print("Die zahl im " + basis + "-ersystem lautet " + summe);
			aktiv = false;
		}
	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}
