
public class Mastermind {

	public static void main(String[] args) {
		System.out.println("Mastermind");
		System.out.println("==========");
		// Benutzer gibt die Anzahl an Farben ein
		int farbAnzahl = readInt("Anzahl Farben: ");
		boolean aktiv = true;
		// Anzahl an Stellen
		int stellAnzahl = 4;
		// Äußere Schleife generiert jeweils den Code neu
		while (aktiv) {
			System.out.print("=======================> ");
			// Code wird erzeugt
			String code = erzeugeCode(stellAnzahl,farbAnzahl);
			// Tipp bleibt vorerst leer
			String tipp = "";
			// Zählt die Versuche
			int versuch = 1;
			boolean ein = true;
			// Schleife zur eingabe des Tipps
			while (ein) {
				// Tipp wird eingegeben
				tipp = eingabeTipp(stellAnzahl);
				// Ausgabe der jeweiligen Funktionen
				System.out.print(versuch + "): ");
				System.out.print(tipp + " = ");
				System.out.print("(w: " + ermittleWeisse(code, tipp) + ", ");
				System.out.print("s: " + ermittleSchwarz(code, tipp) + "): ");
				// Ermittelt ob ds Spiel beendet werden soll
				if (tipp == "ENDE") {
					// Schaltet beide Schleifen aus
					ein = false;
					aktiv = false;
					System.out.print("Ende");
				
				// Ermittelt ob richtig geraten wurde
				} else if (ermittleWeisse(code, tipp) == 0 && ermittleSchwarz(code, tipp) == stellAnzahl) {
					// Schaltet innere Schleife aus
					ein = false;
					System.out.println("Code gefunden");
				} else {
					tipp = "";
					versuch++;
				}
			}
		}
	}
	
	// Benutzereingabe
	public static String readString(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in).nextLine());
	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	  }
	
	/**
	 * Dieser Methode wird die Anzahl der Stellen des Codes und  die Anzahl der Farben übergeben.
	 * Sie liefert den zufällig ermittelten Code zurück,
	 * wobei anstelle von Farben Großbuchstaben von A beginnend zurückgeliefert werden.
	 * Die Methode sorgt dafür, dass im Code keine doppelten Farben bzw. Buchstaben vorhanden sind.
	 * Die Methode liefert nur dann ein Ergebnis ungleich null zurück, falls die Farbenanzahl
	 * größer oder gleich der Stellenanzahl ist. Die Methode darf keine Bildschirmausgabe machen.
	 * Wird der Methode als Stellenanzahl 4 und als Farbenanzahl 6 übergeben,
	 * so kann sie beispielsweise den Text "ACFD" zurück liefern. 
	 * @param stellAnzahl Länge des Farbcodes
	 * @param farbAnzahl Anzahl verschieden möglicher Farben
	 * @return zufälliger Code
	 */
	public static String erzeugeCode(int stellAnzahl, int farbAnzahl) {
		String ret = null;
		// Beinhaltet alle mögliche Farben
		String farben = "ABCDEFGHIJKLMOPQRSTUVWXYZ";
		// Schaut ob es eine gültige eingabe ist
		if (farbAnzahl >= stellAnzahl && farbAnzahl <= farben.length()) {
			ret = "";
			// Dient zum Kontrollieren von doppeleten
			String control = "";
			int n = 0;
			String farben2 = farben.substring(0,farbAnzahl-1);
			while (n < stellAnzahl) {
				int random = (int)Math.round(Math.random() * farben2.length());
				// -1 bedeutet es beinhaltet nicht den Character
				if (ret.indexOf(farben.charAt(random)) == -1) {
					ret += farben.charAt(random);
					n++;
				}
			}
		}
		return ret;
	}
	
	/**
	 * Dieser Methode wird ein String übergeben, und sie kontrolliert, ob im String Buchstaben doppelt vorkommen.
	 * Ist das der Fall, so wird true zurück geliefert. Die Methode liefert immer dann false zurück,
	 * falls der übergebene String null oder die Länge des Strings gleich 0 ist. Bei der Kontrolle auf
	 * doppelte Buchstaben wird die Groß-/Kleinschreibung nicht beachtet. In der Methode selbst dürfen keine
	 * Bildschirmausgaben erfolgen. Wird der Methode beispielsweise der String "ACFD" übergeben so wird
	 * false zurück geliefert, wird "ACAD" übergeben, so wird true zurück geliefert. 
	 * @param s Der zu überprüfende String
	 * @return true wenn doppelete vorkommen, sonst false
	 */
	public static boolean enthaeltDoppelte(String s) {
		boolean ret = false;
		for(int i = 0; i < s.length(); i++) {
			int n = 0;
			for(int j = 0; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					n++;
					if (n > 1) {
						i = s.length() + 1;
						j = s.length() + 1;
						ret = true;
					}
				}
			}
		}
		return ret;
	}
	
	/**
	 * Durch diese Methode wird dem Benutzer die Möglichkeit gegeben, seinen Tipp einzugeben.
	 * Wie lang der einzugebende Tipp sein darf, wird der Methode übergeben.
	 * Der vom Benutzer eingegebene Tipp wird von der Methode zurück geliefert.
	 * Innerhalb der Methode wird der Text "Ihr Tipp:" ausgegeben.
	 * Die Eingabe muss in der Methode automatisch wiederholt werden, falls der Benutzer keinen Tipp eingibt,
	 * der Tipp nicht die geforderte Länge hat und falls doppelte Buchstaben im Tipp vorhanden sind.
	 * Gibt der Benutzer den Text "ende" ein, so muss die Eingabe abgebrochen und der eingegebene Text zurück
	 * geliefert werden. Der eingegebene Text muss in Großbuchstaben konvertiert und zurückgegeben werden. 
	 * @param lange Länge des zu eingegeben Strings
	 * @return der eingegebene Strimg in Großbuchstaben
	 */
	public static String eingabeTipp(int lange) {
		String ret = null;
		boolean aktiv = true;
		while (aktiv) {
			ret = "";
			String eingabe = readString("Ihr Tipp: ");
			if (eingabe.toLowerCase().equals("ende")) {
				aktiv = false;
				ret = "ENDE";
			} else if (!enthaeltDoppelte(eingabe) && eingabe.length() == lange) {
				ret = eingabe.toUpperCase();
				aktiv = false;
			}
		}
		return ret;
	}
	
	/**
	 * Anhand dieser Methode soll ermittelt werden wie viele Buchstaben sich am richtigen Platz befinden.
	 * Dazu werden der Methode der zu erratende Code und der Tipp übergeben. Die Methode liefert die
	 * Anzahl der Richtigen zurück. Der übergebene Code und der Tipp müssen gefüllt sein und dieselbe Länge
	 * haben, ansonsten wird -1 zurück geliefert. Wird der Methode beispielsweise "ABCD" und "BACF"
	 * übergeben, so liefert sie 1 zurück. 
	 * @param code der von der erzeugeCode() methode zurückgegebene String
	 * @param tipp der von der eingabeTipp() methode zurückgegebene String
	 * @return Anzahl von Farben an richtiger Position
	 */
	public static int ermittleSchwarz(String code, String tipp) {
		int ret = -1;
		if (!code.isEmpty() && !tipp.isEmpty() && code != null && tipp != null) {
			ret = 0;
			for (int i = 0; i < code.length(); i++) {
				if (code.charAt(i) == tipp.charAt(i)) {
					ret++;
				}
			}
		}
		return ret;
	}
	
	/**
	 * Diese Methode soll die Anzahl der richtigen Buchstaben, die sich noch am falschen Platz befinden,
	 * ermitteln. Dabei werden wiederum der zu erratende Code und der Tipp übergeben. Die Methode liefert
	 * wiederum die Anzahl der Richtigen Buchstaben zurück. Der übergebene Code und der Tipp müssen
	 * gefüllt sein und dieselbe Länge haben, ansonsten wird -1 zurück geliefert. Wird der Methode
	 * beispielsweise "ABCD" und "BACF" übergeben, so liefert sie 2 zurück. 
	 * @param code der von der erzeugeCode() methode zurückgegebene String
	 * @param tipp der von der eingabeTipp() methode zurückgegebene String
	 * @return Anzahl von richtiger farben an falscher Position
	 */
	public static int ermittleWeisse(String code, String tipp) {
		int ret = -1;
		if (code.length() == tipp.length() && code != null && tipp != null) {
			ret = 0;
			for (int i = 0; i < code.length(); i++) {
				for (int j = 0; j < tipp.length(); j++) {
					if (code.charAt(i) == tipp.charAt(j) && i != j) {
						ret++;
					}
				}
			}
		}
		return ret;
		
	}

}
