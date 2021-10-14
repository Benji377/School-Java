
public class PythagoreischeTripel {

	public static void main(String[] args) {
		System.out.println("Pythagoreische Tripel");
		System.out.println("Seite a; Seite b; Seite c");
		
		// Alle Zahlen von 0 bis 1000
		int minimum = 0;
		int maximum = 1000;
		
		// Berechnet die a-Seite
		for (int a = minimum; a <= maximum; a++) {
			
			// Berechnet die b-Seite
			for (int b = a+1; b <= maximum; b++) {
				
				// Berechnet die c-Seite
				for (int c = b+1; c <= maximum; c++) {
					
					// Ermittelt mit pythagoras ob es sich um ein pythagoreische Dreieck handelt
					if (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) {
						System.out.println(a + "; " + b + "; " + c);
					}
				}
			}
		}
		System.out.print("Ende!");
	}

}

//Problem! Kann irgendwie nicht in Dokument schreiben!

/*
 * try {
// Umleiten der Standardausgabe in die Datei welche unter dem angegebenen
// Laufwerk und Pfad gespeichert wird. Ist die Datei dort nicht vorhanden,
// wird sie angelegt
System.setOut(new java.io.PrintStream("H:\\PythagoreischeTripel.csv"));
} catch (java.io.FileNotFoundException e) {
// Es ist ein Fehler beim Erstellen oder Öffnen der Datei aufgetreten
System.out.println("Fehler beim Erstellen der Datei");
} 
 */