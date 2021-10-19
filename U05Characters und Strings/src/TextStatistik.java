
public class TextStatistik {

	public static void main(String[] args) {
		
		// Variablen deklarieren
		boolean aktiv = true;
		int selbstlaute = 0;
		int buchstaben = 0;
		int leerzeichen = 0;
		
		// Titel
		System.out.println("Textstatistik");
		System.out.println("=============");
		
		// Unendliche Schleife
		while (aktiv) {
			
			// Nimmt eine String als Eingabe
			String eingabe = readString("Text: ");
			int n = 0;
			
			// Schaut ob die Eingabe lang genug ist
			if (eingabe.length() >= 1) {
				
				// Iteriert durch den String, wo n der jeweilige Index ist
				while (n < eingabe.length()) {
					
					// Gibt den Character an Stelle n
					char a = Character.toLowerCase(eingabe.charAt(n));
					if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
						selbstlaute++;
					}
					// Wenn der Character ein Leerzeichen ist wird leerzeichen um 1 erhöht
					if (Character.isWhitespace(a)) {
						leerzeichen++;
					// Wenn der Character ein Buchstabe ist wird buchstaben um eins erhöht
					} else if (Character.isLetter(a)){
						buchstaben++;
					}
					// n wirdum eins erhöht und somit wird der nächste Index geholt
					n++;
				}
				// Gibt jeweils die Anzahl an Selbstlaute, Buchstaben und Leerzeihen aus.
				System.out.println();
				System.out.println("Selbstlaute: " + selbstlaute);
				System.out.println("Buchstaben: " + buchstaben);
				System.out.println("Leerzeichen: " + leerzeichen);
				// Anzahl der Zeichen entspricht der Länge des Strings
				System.out.println("Zeichen: " + eingabe.length());
				
				// Bricht unendliche Schleife ab
				aktiv = false;
			} else {
				// Wird ausgegeben wenn der Benutzer keinen Text eingegeben hat
				System.out.println("Text muss mindestens ein Zeichen enthalten");
			}
		}

	}
	
	public static String readString(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in).nextLine());
	}

}
