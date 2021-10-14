
public class UmrechnungNachZehn {

	public static void main(String[] args) {
		System.out.println("Umrechnung ins Zehnersystem");
		System.out.println("===========================");
		
		int zahl = readInt("Geben Sie die Zahl ein: ");
		boolean aktiv = true;
		int teiler = 10;
		int summe = 0;
		int hochzahl = 0;
		
		while (aktiv) {
			int basis = readInt("Geben Sie die Basis ein: ");
			// Kontrolliert die Basis-Zahl
			if (basis < 10 && basis > 1) {
				System.out.println();
			} else {
				System.out.println("Basis muss zwischen 2 und 9 liegen");
				continue;
			}
			// Teilt di Zahl
			while (zahl > 0) {
				summe += zahl%teiler * (int)Math.pow(basis, hochzahl);
				zahl /= teiler;
				hochzahl++;
			}
			// Gibt die umgerechnete Zahl aus
			System.out.print("Die Zahl im Zehnersystem lautet " + summe);
			aktiv = false;
		}

	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}
