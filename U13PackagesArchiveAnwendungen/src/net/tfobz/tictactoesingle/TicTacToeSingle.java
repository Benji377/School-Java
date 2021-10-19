package net.tfobz.tictactoesingle;
import net.tfobz.tictactoe.*;

public class TicTacToeSingle {
	public static int feldgroesse;

	public static void main(String[] args) {
		// Wenn true läuft das Spiel
		boolean gamerun = true;
		// Titel und Ausgabe des Feldes
		System.out.println("T i c T a c T o e");
		
		// Schleife um das gesamte Programm mehrmals durchlaufen zu lassen
		while (gamerun) {
			System.out.println("==================");
			feldgroesse = readInt("Größe des Feld: ");
			// Erstellt erstmals ein TicTacToe Feld
			TicTacToe t = new TicTacToe(feldgroesse);
			System.out.print(t.toString());
			// Solange man noch gewinnen kann 
			while (t.getEinerKannGewinnen() && t.getGewonnen() == 0) {
				// Liest den Zug des ersten Spielers
				int zug = readInt("1. Spieler: Ihr Zug: ");
				int gueltigkeit = t.setZugSpieler1(zug);
				// Zug ist gültig
				if (gueltigkeit == 0) {
					System.out.print(t.toString());
					// Ob der erste Spieler bereits gewonnen hat oder nicht
					// Je nachdem kann der zweite Spieler noch ziehen
					boolean zug2 = t.getEinerKannGewinnen() && t.getGewonnen() == 0;
					while(zug2) {
						zug = readInt("2. Spieler: Ihr Zug: ");
						gueltigkeit = t.setZugSpieler2(zug);
						// Prüft den Zug auf seiner Gültigkeit
						if (gueltigkeit == 0) {
							System.out.print(t.toString());
							// Bei gültigem Zug bricht es aus der Schleife heraus
							zug2 = false;
						} else if (gueltigkeit == -2) {
							System.out.println("Zug bereits gesetzt");
						} else if (gueltigkeit == -1) {
							System.out.println("Zug außerhalb des Feldes");
						}
					}
				} else if (gueltigkeit == -2){
					System.out.println("Zug bereits gesetzt");
				} else if (gueltigkeit == -1) {
					System.out.println("Zug außerhalb des Feldes");
				}
			}
			// Ermittelt wer gewonnen hat
			if (!t.getEinerKannGewinnen()) 
				System.out.println("Unentschieden!");
			else if (t.getGewonnen() == t.getSpieler1()) 
				System.out.println("Spieler 1 hat gewonnen!");
			else if (t.getGewonnen() == t.getSpieler2()) 
				System.out.println("Spieler 2 hat gewonnen!");
			else 
				System.out.println("Fehler!");
			
			// Ob noch ein Spiel gespielt werden soll
			char yesno = readChar("Noch ein Spiel (j/n)? ");
			if (yesno == 'j') {
				gamerun = true;
				t = new TicTacToe(feldgroesse);
				t.toString();
			} else {
				gamerun = false;
			}
		}
	}
	
	/**
	 * Liest die vom Nutzer eingegebenen Zahlen ein und kontrolliert
	 * nebenbei auch ob sie gültig sind
	 * @param text Der Text der vor der Eingabe steht
	 * @return Den eingelesenen int-Wert
	 */
	public static int readInt(String text) {
		// Was im Standardfall zurückgegeben wird
	    int ret = 0;
	    // Aktiviert die darunter liegende Schleife
	    boolean aktiv = true;
	    // Geht so lange durch bis eine gültige Eingabe da ist
	    while (aktiv) {
		    try {
		    	// Gibt den Anfangstext aus
		    	System.out.print(text);
		    	// Liest die Nutzereingabe
		    	ret = (new java.util.Scanner(System.in)).nextInt();
		    	// Bei keinem Fehler tritt es aus der Schleife aus
		    	aktiv = false;
		    } catch (Exception e ) {
		    	// Bei Fehlern wird eine Fehlermeldung ausgegeben
		    	System.out.println("Ungültige Eingabe");
		    }
	    }
	    return ret;
	}
	
	/**
	 * Gleich wie die readIt() Methode, nur dass diese natürlich
	 * einen Character einliest
	 * @param text Der Text der vor der Eingabe steht
	 * @return Den eingelesenen char-Wert
	 */
	public static char readChar(String text) {
	    char ret = 'n';
	    boolean aktiv = true;
	    while (aktiv) {
		    try {
		    	System.out.print(text);
		    	ret = (new java.util.Scanner(System.in)).next().charAt(0);
		    	aktiv = false;
		    } catch (Exception e ) {
		    	System.out.println("Ungültige Eingabe");
		    }
	    }
	    return ret;
	}

}
