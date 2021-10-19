
public class VerschluesselungCaesar {

	public static void main(String[] args) {
		// Titel
		System.out.println("Verschl�sselung nach C�sar");
		System.out.println("==========================");
		
		boolean aktiv = true;
		
		// Unendliche Schleife
		while (aktiv) {
			// Benutzt um Option zu w�hlen
			char option = readChar("V>erschl�sseln, E>ntschl�sseln, A>bbruch: ");
			// Variable steuert geschachtelte unendliche Schleife
			boolean power = true;
			// Verschiebung wird auf 0 gesetzt
			int verschiebung = 0;
			// Option "verschl�sseln" wurde gew�hlt
			if (Character.compare(Character.toLowerCase(option), 'v') == 0) {
				// Geschachtelte Schleife wird aktiviert
				while (power) {
					// Text wird eingegeben
					String verschluss = readString("Text: ");
					// Stellt alle Zeichen klein
					verschluss.toLowerCase();
					// Kontrolliert ob der eingegebene Text g�ltig ist
					if (verschluss.length() >= 1) {
						// Verschiebung wird eigegeben
						verschiebung = readInt("Verschiebung: ");
						// Kontrolliert ob die Verschiebung richtig ist
						if (verschiebung >= 1) {
							System.out.print("Verschl�sselt: ");
							for (int i = 0; i < verschluss.length(); i++) {
								// Variable zum Konvertieren des Chars in int
								int zahlstelle = 0;
								// Sonderzeichen werden ausgelassen
								if (Character.toLowerCase(verschluss.charAt(i)) >= 'a' && Character.toLowerCase(verschluss.charAt(i)) <= 'z') {
									// Character an Stelle i wird zu int konvertiert
									zahlstelle = (int)Character.toUpperCase(verschluss.charAt(i));
									// Character geht verschiebung Stellen nach rechts
									zahlstelle += verschiebung;
									// Schleife Begrenzt die Ausgabe zu Buchstaben
									// Gro�buchstaben gehen von 65 bis 90 (int)
									while (zahlstelle >= 65) {
										// Begrenzt die Ausgabe bis zu z
										if (zahlstelle <= 90) {
											System.out.print((char)zahlstelle);
											zahlstelle = 0;
										// Wenn die Ausgabe keine Gro�buchstaben mehr ist wird es zur�ckgestellt
										} else {
											zahlstelle = 64 + (zahlstelle - 90);
										}
									}
								}
								
							}
							// Geht neue Zeile
							System.out.println();
							// Bricht die verschachtelte Schleife ab
							power = false;
						// Wenn Die Verschiebung ung�ltig ist
						} else {
							System.out.println("Bitte geben Sie eine ganze Zahl gr��er als 0 ein");
						}
					// Wenn der Text ung�ltig ist
					} else {
						System.out.println("Text muss mindestens in Zeichen enthalten");
					}
				}
				// Option "Entschl�sseln" wurde gew�hlt
			} else if (Character.compare(Character.toLowerCase(option), 'e') == 0) {
				// Gleich wie bei Verschl�sseln
				while (power) {
					// Gibt den verschl�sselten Text ein 
					String entschluss = readString("Text: ");
					// Stellt den gesamten Text in Gro�buchstaben
					entschluss.toUpperCase();
					// Pr�ft die L�nge des Texts
					if (entschluss.length() >= 1) {
						// Gibt die Verschiebung ein
						verschiebung = readInt("Verschiebung: ");
						if (verschiebung >= 1) {
							System.out.print("Entschl�sselt: ");
							// Schleife geht jeden Character durch
							for (int i = 0; i < entschluss.length(); i++) {
								// Variable zum Konvertieren des Chars in int
								int zahlstelle = 0;
								// Sonderzeichen werden ausgelassen
								if (Character.toUpperCase(entschluss.charAt(i)) >= 'A' && Character.toUpperCase(entschluss.charAt(i)) <= 'Z') {
									// Character an Stelle i wird zu int konvertiert
									zahlstelle = (int)Character.toUpperCase(entschluss.charAt(i));
									// Character geht verschiebung Stellen nach rechts
									zahlstelle -= verschiebung;
									// Schleife Begrenzt die Ausgabe zu Buchstaben
									// Gro�buchstaben gehen von 65 bis 90 (int)
									while (zahlstelle <= 90) {
										// Begrenzt die Ausgabe bis zu z
										if (zahlstelle >= 65) {
											System.out.print((char)zahlstelle);
											zahlstelle = 91;
										// Wenn die Ausgabe keine Gro�buchstaben mehr ist wird es zur�ckgestellt
										} else {
											zahlstelle = 91 - (65 - zahlstelle);
										}
									}
								}
								
							}
							// Geht neue zeile
							System.out.println();
							// Bricht die verschachtelte Schleife ab
							power = false;
						// Wenn die Verschiebung ung�ltig ist
						} else {
							System.out.println("Bitte geben Sie eine ganze Zahl gr��er als 0 ein");
						}
					// Wenn der Text ung�ltig ist
					} else {
						System.out.println("Text muss mindestens in Zeichen enthalten");
					}
				}
			// Option "Abbruch" wurde gew�hlt
			} else if (Character.compare(Character.toLowerCase(option), 'a') == 0) {
				// Bricht die Schleife ab
				aktiv = false;
			// Wenn keine der Optionen gew�hlt wurde
			} else {
				System.out.println("Bitte geben Sie ein g�ltigen Buchstaben ein");
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
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}
