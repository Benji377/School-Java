
public class VerschlüsselungDrehen {

	public static void main(String[] args) {
		System.out.println("Verschlüsselung durch Drehen");
		System.out.println("============================");
		
		// Aktiviert und deaktiviert die unendliche Schleife
		boolean aktiv = true;
		
		while (aktiv) {
			
			// Nimmt ein String als Eingabe
			String eingabe = readString("Text: ");
			
			// Anfang und Ende der String werden definiert
			int anfang = 0;
			int ende = eingabe.length() - 1;
			
			// Kontrolliert ob die Eingabe leer ist
			if (eingabe.length() >= 1) {
				System.out.print("Verschlüsselt: ");
				
				// Kontrolliert ob die Anzahl an Character gerade ist
				if (eingabe.length()%2 == 0) {
					// Schleife dass solange die Variable anfang kleiner ist als die Hälfte der Strings
					// anfang um eins erhöht und ende um eins verkleinert
					while (anfang < eingabe.length()/2) {
						// anfang liest den String von links nach rechts
						// ende liest den String von rechts nach links
						char a = eingabe.charAt(anfang);
						char b = eingabe.charAt(ende);
						System.out.print(a);
						System.out.print(b);
						ende--;
						anfang++;
					}
				} else {
					
					// Wenn ungerade dann wird das Character in der Mitte herausgeholt
					char middle = eingabe.charAt(eingabe.length()/2);
					while (anfang <= eingabe.length()/2) {
						
						// Das mittlere Character wird hier eingefügt wenn die zwei Variablen ende und anfang
						// in der Mitte angekommen sind
						if (anfang == eingabe.length()/2) {
							System.out.print(middle);
							anfang++;
						} else {
							// Gleich wie oben mit Strings die gerade Zeichenanzahl haben
							char a = eingabe.charAt(anfang);
							char b = eingabe.charAt(ende);
							System.out.print(a);
							System.out.print(b);
							ende--;
							anfang++;
						}	
					}	
				}
				// Geht am Ende der Verschlüsselung neue Zeile
				System.out.print("\n");
				
				// Fragt den Benutzer ob er nochmals ein Text verschlüsseln will
				char versuch = Character.toLowerCase(readChar("Nochmal (j/n)? "));
				if (Character.compare(versuch, 'j') != 0) {
					// Beendet die Schleife wenn der Benutzer etwas anderes von 'j' eingibt
					aktiv = false;
				}
			} else {
				// Wird ausgegeben wenn die Eingabe leer ist
				System.out.println("Text muss mindestens ein Zeichen enthalten");
			}
		}
	}
	public static char readChar(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in).next().charAt(0));
	 }
	public static String readString(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in).nextLine());
	 }

}
