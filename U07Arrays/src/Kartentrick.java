
public class Kartentrick {

	public static void main(String[] args) {
		// Titel
		System.out.println("Kartentrick");
		System.out.println("===========");
		
		// Schliefe um eine Eingabe vom Benutzer zu holen
		// Ruft die jeweiligen Methoden auf um den Kartentrick auszuführen 
		do {
			// Die Karten werden jedes mal neu angeordnet
			int[][]karten = null;
			// Erstellt den Karten array, wäre sonst null
			karten = fuellen(karten, 0);
			// Gibt den Kartenarray aus
			ausgeben(karten);
			// Der Benutzer gibt die Spalte ein, in der sich seine karte befindet
			int spalte = readInt("Spalte der Karte: ");
			
			// Die Karten werden neu sortiert: Die ausgewählte Spalte kommt in der Mitte.
			karten = fuellen(karten, spalte);
			// Die Karten werden neu ausgelegt
			ausgeben(karten);
			// Der Benutzer gibt wieder die Spalte an in der sich die Karte befindet
			// Insgesamt dreimal
			spalte = readInt("Spalte der Karte: ");
			
			karten = fuellen(karten, spalte);
			ausgeben(karten);
			spalte = readInt("Spalte der Karte: ");
			
			karten = fuellen(karten, spalte);
			ausgeben(karten);
			// Am Ende befindet sich die Karte in der Mitte, also
			// in der 4. Zeile und 2. Spalte
			System.out.println("Karte " + karten[3][1] + " wurde gewählt");
			
			// Der Benutzer kann aussuchen, ob er nochmals spielen möchte
			} while (Character.toLowerCase(readChar("Nochmals (j/n)? ")) == 'j');
	}
	
	// In TestScannerErweitert: Methode zur Benutzereingabe von Character
	public static char readChar(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in).next().charAt(0));
	}
	
	// In TestScannerErweitert: Methode zur Benutzereingabe von Integer
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}
	
	// in FlexWeihnachtsbaum: Methode um Zahlen geordnet auszugeben
	public static void printZahl(int zahl) {
		if (zahl < 10)
			System.out.print("  " + zahl);
		else
			if (zahl < 100)
				System.out.print(" " + zahl);
			else
				System.out.print(" " + zahl);
	}
	
	/**
	 * Methode um das Array karten[][] aufzufüllen.
	 * Je nach spalte gibt es ein neues Array zurück dass der Reihenfolge der
	 * Karten entspricht. Hier wird der Kartentrick ausgeführt.
	 * @param karten Das Array dass entweder aufgefüllt oder geändert werden soll
	 * @param spalte Wenn 0 dann wird das array neu generiert, ansonsten bestimmt es
	 * welche Spalte in der Mitte sein wird
	 * @return ein neues Array wo die Karten sortiert wurden
	 */
	public static int[][] fuellen(int[][]karten, int spalte) {

		
		// Der zu ausgebende Array wird definiert
		int[][] ret = new int[7][3];
		
		// Jede Spalte ist ein eindimensionales Array
		int[] spalte1 = new int[7];
		int[] spalte2 = new int[7];
		int[] spalte3 = new int[7];
		
		// Wenn die Spalte 0 ist, dann muss das Array erst definiert werden
		if (spalte == 0) {
			// Das Array wird deklariert, ist aber noch leer
			karten = new int[7][3];
			// Man geht alle Zeilen des Arrays durch
			for(int i = 0; i < 7; i++) {
				// Jede Spalte beinhaltet somit alle nötigen Werte
				spalte1[i] = i+1;
				spalte2[i] = i+8;
				spalte3[i] = i+15;
			}
			// Noch eine Schleife um die eindimensionale Arrays in das zweidimensionale Array
			// zu konvertieren
			for (int i = 0; i < 7; i++) {
				karten[i][0] = spalte1[i];
				karten[i][1] = spalte2[i];
				karten[i][2] = spalte3[i];
			}
			// Der Ausgabearray wird definiert
			// Hier ist ret gleich wie karten
			ret = karten;
			
			// Hier muss die Spalte 1 in der Mitte gestellt werden
		} else if (spalte == 1) {
			// Wie bei Spalte == 0
			for(int i = 0; i < 7; i++) {
				spalte1[i] = karten[i][2];
				spalte2[i] = karten[i][0];
				spalte3[i] = karten[i][1];	
			}
			
			for (int i = 0; i < 7; i++) {
				karten[i][0] = spalte1[i];
				karten[i][1] = spalte2[i];
				karten[i][2] = spalte3[i];
			}
			// Karten werden hier nochmals richtig ausgelegt
			ret = auslage(karten);
		// Hier passiert das gleiche wi in den anderen If-Statements.
		} else if (spalte == 2) {
			for(int i = 0; i < 7; i++) {
				// Der Unterschied liegt immer nur in der Reihenfolge
				// in der sich die Spalten befinden
				spalte1[i] = karten[i][0];
				spalte2[i] = karten[i][1];
				spalte3[i] = karten[i][2];
			}
			for (int i = 0; i < 7; i++) {
				karten[i][0] = spalte1[i];
				karten[i][1] = spalte2[i];
				karten[i][2] = spalte3[i];
			}
			ret = auslage(karten);
		// Gleich wie oben
		} else if (spalte == 3) {
			for(int i = 0; i < 7; i++) {
				spalte1[i] = karten[i][1];
				spalte2[i] = karten[i][2];
				spalte3[i] = karten[i][0];
			}
			for (int i = 0; i < 7; i++) {
				karten[i][0] = spalte1[i];
				karten[i][1] = spalte2[i];
				karten[i][2] = spalte3[i];
			}
			ret = auslage(karten);
		} else {
			// Wenn der eingegebene Integer nicht 1, 2 oder 3 ist
			System.out.println("Es gibt nur drei Spalten");
		}
		
		
		return ret;
	}


	/**
	 * Methode um den übergebenen Array als Tabelle auszugeben
	 * Die Tabelle besteht aus 7 Zeilen und 3 Spalten
	 * @param karten der zu ausgebenden Array
	 */
	public static void ausgeben(int[][]karten) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 3; j++) {
				printZahl(karten[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * Methode um die die Karten in den übergebenen Array richtig auszugeben.
	 * Dabei werden alle parameter eines zweidimensionales Array neu angeordnet.
	 * Die Methode gibt dann den sortierten Array zurück.
	 * @param karten der zu sortierende Array
	 * @return der sortierte Array
	 */
	public static int[][] auslage(int[][]karten) {
		int[][]ret = new int[karten.length][karten[0].length];
		// Diese Variablen werden gebraucht um die Karten waagrecht auszugeben
		// n ist der Index der Zeile im Array ret
		int n = 0;
		// m ist der Index der Spalte im Array ret
		int m = 0;
		// x ist der Index der Zeile im Array karten
		int x = 0;
		// y ist der Index der Spalte im Array karten
		int y = 0;
		
		for(int i = 1; i < 22; i++) {
			// Die Startwerte sind alle 0 und maximal 6 oder 2 groß
			ret[n][m] = karten[x][y];
			
			// Jeden dritten Durchgang wird eine neue zeile gewählt.
			// 3 weil es 3 Spalten gibt
			if (i%3 == 0 && i != 0) {
				n++;
			}
			// Wenn m 2 ist und somit alle spalten gefüllt sind, wird es auf 0
			// zurückgesetzt, ansonsten um eins erhöht
			if (m == 2) {
				m = 0;
			} else {
				m++;
			}
			// Geht jeden Index der Zeile durh, 6 weil es 7 Zeilen gibt.
			// Wenn 6 erreicht wird, wird es auf 0 gesetzt und fängt von vorne an
			if (x < 6) {
				x++;
			} else {
				x = 0;
			}
			// Wenn x auf 0 gesetzt wird dann muss Spalte gewechselt werden,
			// das erfolgt in dem man y um eins erhöht
			if (x == 0) {
				y++;
			}
		}
		// Anschließend wird der neu sortierte Array zurückgegeben
		return ret;
	}
}
