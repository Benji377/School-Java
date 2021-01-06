
public class WortRatespiel {

	public static void main(String[] args) {
		// Titel
		System.out.println("Wortratespiel");
		System.out.println("=============");
		
		boolean aktiv = true;
		
		// Unendliche Schleife des Programms
		while (aktiv) {
			// Z�hlt die Versuche
			int versuche = 0;
			// Das gesuchte Word wird hier eingegeben
			String such_wort = readString("Gesuchtes Wort: ");
			// Das eingegebene Wort wird in Gro�buchstaben gestellt
			such_wort = such_wort.toUpperCase();
			boolean power = true;
			// Leere String wird danach das Bichstabe/Wort des Benutzer beinhalten
			String kontrolle = "";
			String finde_wort = "";
			// Kontrolliert ob der String lang genug ist
			if (such_wort.length() >= 1) {
				// Unendliche Schleife wird aktiv
				while (power) {
					System.out.print("Ihr Wort:       ");
					// Schleife geht durch jeden Character der ersten String
					for (int i = 0; i < such_wort.length(); i++) {
						// F�r jeden Ducrchgang der ersten Schleife geht es durch alle Character der zweiten String 
						for (int j = 0; j < kontrolle.length(); j++) {
							// Vergleicht die Beiden Character
							if (Character.compare(such_wort.charAt(i), kontrolle.charAt(j)) == 0) {
								// Wenn sie gleich sind wird der Character ausgegeben
								System.out.print(such_wort.charAt(j));
							} else {
								// Dort wo die Character nicht gleich sind wird ein Punkt ausgegeben
								System.out.print(".");
							}
							//System.out.print(kontrolle + ";");
						}
					}
					System.out.println();
					// Unendliche Schleife f�r die Eingabe des Benutzers wird aktiviert
					boolean raten = true;
					while (raten) {
						// Das geratene Wort oder Buchstabe wird hier eingegeben
						finde_wort = readString("Buchstabe/Wort: ");
						// Kontrolliert ob es richtig eingegeben worden ist
						if (finde_wort.length() >= 1) {
							// Das gesamte Wort wird gro�geschrieben
							finde_wort = finde_wort.toUpperCase();
							// Wort oder Buchstabe wird hier hinzugef�gt
							kontrolle = kontrolle.concat(finde_wort);
							// Anzahl an Versuche wird hier um eins erh�ht
							versuche++;
							// Schleife wird unterbrochen
							raten = false;
						} else {
							// Wenn es nicht richtig eingegeben worden ist 
							System.out.println("Geben Sie mindestens ein Zeichen ein");
						}	
					}
					// Pr�ft ob das eingegebene Wort gleich dem gesuchten Wort ist
					if (finde_wort.equals(such_wort)) {
						// Gibt auch die Anzahl an Versuche aus
						System.out.println("Sie haben in " + versuche + " Schritten das Wort erraten!");
						// Bricht aus der Schleife aus
						power = false;
					}
				}
				// Aktiviert unendliche Schleife um zu kontrollieren ob der Benutzer nochmals spielen will
				boolean aussuchen = true;
				while (aussuchen) {
					// Fragt nach ob man nochmals spielen m�chte
					char weiter = readChar("Nochmal (j/n)? ");
					weiter = Character.toLowerCase(weiter);
					// Kontrolliert die Eingabe
					if (Character.compare(weiter, 'n') == 0) {
						// Bei "nein" wird aus der Schleife ausgebrochen
						aussuchen = false;
						aktiv = false;
					} else if (Character.toLowerCase(weiter) != 'j') {
						// Bei ung�ltiger Eingabe wird nochmals nachgefragt
						System.out.println("Versuchen Sie es erneut");
					} else {
						aussuchen = false;
					}
				}
				// Wenn das gesuchte Wort ung�ltig ist
			} else {
				System.out.println("Das gesuchte Wort muss mindestens ein Character lang sein");
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
