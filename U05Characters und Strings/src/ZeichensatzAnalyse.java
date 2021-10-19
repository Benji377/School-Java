
public class ZeichensatzAnalyse {

	public static void main(String[] args) {
		// Variable n braucht man um neue Zeile zu gehn 
		int n = 0;
		
		// Titel
		System.out.println("isLetter");
		// Geht alle Zeichen von 32 bis 255 durch
		for (int i = 32; i <= 255; i++) {
			// Prüft ob der Character ein Buchstabe ist
			if (Character.isLetter(i)) {
				// Gibt den Buchstabe aus und ein Leerzeichen dazu
				System.out.print((char)i + " ");
				n++;
				// Nach 30 Buchstaben geht es neue Zeile
				if (n%30 == 0) {
					System.out.println();
				}
			} 
			
		}
		System.out.println();
		//n Zählt die Zeichen und geht somit nach 30 ausgegebene Zeichen neue Zeile
		n = 0;
		// Titel
		System.out.println("isDigit");
		// Schleife geht alle Zeichen von 32 bis 255 durch
		for (int i = 32; i <= 255; i++) {
			// Prüft ob der Character eine Zahl ist
			if (Character.isDigit(i)) {
				// Gibt die Zahl aus und ein Leerzeichen dazu
				System.out.print((char)i + " ");
				n++;
				// Geht nach 30 ausgegebene Zeichen neue Zeile
				if (n%30 == 0) {
					System.out.println();
				}
			}
		}
		System.out.println();
		// n wird wieder auf 0 gesetzt
		n = 0;
		// Titel
		System.out.println("isWhitespace");
		// Schleife geht alle Zeichen von 32 bis 255 durch
		for (int i = 32; i <= 255; i++) {
			// Prüft ob der Zeichen ein Leerzeichen ist
			if (Character.isWhitespace(i)) {
				// Explizite Typkonvertierung: Anstatt das Leerzeichen wird seine Position ausgegeben als integer
				System.out.print((int)i + " ");
				n++;
				// Geht wie immer nach 30 ausgegebenen Zeichen neue Zeile
				if (n%30 == 0) {
					System.out.println();
				}
			}
		}
		System.out.println();
		// n wird wieder auf 0 gesetzt
		n = 0;
		// Titel
		System.out.println("isLowerCase");
		// Schleife geht von 32 bis 255 alle Zeichen durch
		for (int i = 32; i <= 255; i++) {
			// Prüft ob es sich beim Zeichen um ein Kleinbuchstaben handelt
			if (Character.isLowerCase(i)) {
				// Gibt das Zeichen und ein Leerzeichen aus
				System.out.print((char)i + " ");
				n++;
				// Gibt die maximale Zeichen in einer Zeile an
				if (n%30 == 0) {
					System.out.println();
				}
			}
		}
		System.out.println();
		// n wird auf 0 gestellt
		n = 0;
		// Titel
		System.out.println("isUpperCase");
		// Schleife die alle Zeichen von 32 bis 255 durchgeht
		for (int i = 32; i <= 255; i++) {
			// Prüft ob das Zeichen großgeschrieben ist
			if (Character.isUpperCase(i)) {
				// Gibt den Zeichen und ein Leerzeichen aus
				System.out.print((char)i + " ");
				n++;
				// Es werden somit nur 30 Zeichen pro Zeile aus
				if (n%30 == 0) {
					System.out.println();
				}
			}
		}

	}

}
