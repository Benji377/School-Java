package net.tfobz.tictactoe.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import net.tfobz.tictactoe.TicTacToe;
import net.tfobz.tictactoe.gui.TicTacToeJFrame;
/**
 * Stellt den Server im Spiel dar
 * Dabei ist er der zweite am Zug und wartet zuerst
 * eine Verbindung vom Client ab.
 * @author Benjamin Demetz
 */
public class TicTacToeServer extends TicTacToe{
	private static final int FELDGROESSE  = 3;
	private static final int PORT = 65000;
	private ServerSocket server;
	private Socket clientSocket;
	
	/**
	 * Konstruktor für den Server
	 * Ruft dabei hauptsächlich den TicTacToe Kunstroktor auf
	 * und stellt die Feldröße fest. danach wird ein ServerSocket
	 * erstellt
	 * @param feldgroesse Die Feldgröße des Spielfelds
	 * @param port Port auf dem der Server auf Verbindungen hören soll
	 * @throws IOException Wenn beim Erstellen des Servers etwas schief geht
	 */
	public TicTacToeServer(int feldgroesse, int port) throws IOException{
		super(feldgroesse);
		server = new ServerSocket(PORT);
	}
	
	public static void main(String[] args) {
		// Wenn true läuft das Spiel
		boolean gamerun = true;
		// Schleife um das gesamte Programm durchlaufen zu lassen
		while (gamerun) {
			// Erstellt erstmals ein TicTacToe Server
			TicTacToeServer t = null;
			TicTacToeJFrame tFenster = null;
			try {
				t = new TicTacToeServer(FELDGROESSE, PORT);
				tFenster = new TicTacToeJFrame("TicTacToeServerGUI", t);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			// Solange man noch gewinnen kann 
			while (t.getEinerKannGewinnen() && t.getGewonnen() == 0) {
				// Wartet dass sich der client verbindet und ein Zug setzt
				tFenster.setStatusleistentext("Warte auf Zug des Gegners...");
				int gueltigkeit = -4;
				try {
					gueltigkeit = t.getGegnerZug();
				} catch (IOException e) {
					tFenster.setStatusleistentext("Ein Fehler ist aufgetreten");
					e.printStackTrace();
				}
				// Zug ist gültig
				if (gueltigkeit == 0) {
					tFenster.repaint();
					// Ob der erste Spieler bereits gewonnen hat oder nicht
					// Je nachdem kann der zweite Spieler noch ziehen
					boolean zug2 = t.getEinerKannGewinnen() && t.getGewonnen() == 0;
					while(zug2) {
						// Der Server kann jetzt ein Zug setzen
						tFenster.setStatusleistentext("Sie sind am Zug");
						int zug = tFenster.getGewaehlteFeldnummer();
						try {
							gueltigkeit = t.setMeinZug(zug);
						} catch (IOException e) {
							tFenster.setStatusleistentext("Ein Fehler ist aufgetreten");
							e.printStackTrace();
						}
						// Prüft den Zug auf seiner Gültigkeit
						if (gueltigkeit == 0) {
							tFenster.repaint();
							// Bei gültigem Zug bricht es aus der Schleife heraus
							zug2 = false;
						} else if (gueltigkeit == -2) {
							tFenster.setStatusleistentext("Zug bereits gesetzt");
						} else if (gueltigkeit == -1) {
							tFenster.setStatusleistentext("Zug außerhalb des Feldes");
						} else if (gueltigkeit == -3) {
							tFenster.setStatusleistentext("Client existiert bereits oder wurde nicht richtig beendet");
						}
			}
				} else if (gueltigkeit == -2){
					tFenster.setStatusleistentext("Zug bereits gesetzt");
				} else if (gueltigkeit == -1) {
					tFenster.setStatusleistentext("Zug außerhalb des Feldes");
				} else if (gueltigkeit == -3) {
					tFenster.setStatusleistentext("Client existiert bereits oder wurde nicht richtig beendet");
				}
			}
			// Ermittelt wer gewonnen hat
			if (t.getGewonnen() == t.getSpieler1())
				tFenster.setStatusleistentext("Gegner hat gewonnen!");
			else if (t.getGewonnen() == t.getSpieler2())
				tFenster.setStatusleistentext("Sie haben gewonnen!");
			else if (!t.getEinerKannGewinnen())
				tFenster.setStatusleistentext("Unentschieden!");
			else
				tFenster.setStatusleistentext("Fehler!");
			// Beendet das Spiel und schließt den Server
			gamerun = false;
			try {
				t.close();
			} catch (IOException e) {
				tFenster.setStatusleistentext("Ein Fehler ist aufgetreten");
				e.printStackTrace();
			}
		}
	}
	/**
	 * Schließt den Serversocket und clientSocket
	 * @throws IOException
	 */
	public void close() throws IOException {
		server.close();
		clientSocket.close();
	}
	/**
	 * Wartet dass der Client die Verbindung mit dem Server aufnimmt und einen Zug sendet. 
	 * Wenn der Zug gesendet wurde, wird der ClientSocket nicht geschlossen, 
	 * denn der Server analysiert den Zug, trägt ihn ins Spielfeld ein und schickt seinen Zug 
	 * über denselben ClientSocket zurück zum Client
	 * @return 0 falls erfolgreich empfangen oder Zug 0 geschickt
	 * -1 falls der empfangene Zug außerhalb des Spielfeldes liegt
	 * -2 falls der empfangene Zug bereits gesetzt wurde
	 * -3 falls Clientsocket bereits existiert
	 * @throws IOException Wenn beim Erstellen eines clientSocket etwas schief läuft
	 */
	public int getGegnerZug() throws IOException {
		int ret;
		// Wenn es noch keinen clientSocket gibt
		if (clientSocket == null || clientSocket.isClosed()) {
			// Wartet die Verbindung des client ab
			clientSocket = server.accept();
			// Liest den ersten Zug ein un trägt es im eigenen Spielfeld ein
			InputStream in = clientSocket.getInputStream();
			int zug = (byte)in.read();
			ret = setZugSpieler1(zug);
		} else {
			ret = -3;
		}
		return ret;
	}
	/**
	 * Es wird über den bereits vorhandenen ClientSocket der Zug des Servers an den Client geschickt. 
	 * Dabei muss der ClientSocket existieren. Nach dem Schicken wird der ClientSocket geschlossen
	 * @param zug Der zu setzende Zug
	 * @return 0 falls Zug erfolgreich gesetzt werden konnte
	 * -1 falls der Zug außerhalb des Spielfeldes liegt
	 * -2 falls der Zug bereits gesetzt wurde
	 * -3 falls kein ClientSocket vorhanden ist
	 * @throws IOException Falls beim Senden ein Fehler auftritt
	 */
	public int setMeinZug(int zug) throws IOException{
		int ret;
		// Es muss bereits ein client vorhanden sein, ansonten kann man nicht antworten
		if (clientSocket != null || !clientSocket.isClosed()) {
			// Setzt den Zug zuerst im eigenen Feld und prüft die Gültigkeit
			ret = setZugSpieler2(zug);
			if (ret == 0) {
				// Beim Erfolgreichem Setzen wird es am client weitergeschickt
				OutputStream out = clientSocket.getOutputStream();
				out.write(zug);
				// Der client kann somit geschlossen werden
				clientSocket.close();
			}
		} else {
			ret = -3;
		}
		return ret;
	}
	/**
	 * Erweiterte readInt Methode die nicht nur eine Zahl einliest,
	 * sondern auch auf ihre Richtigkeit reagieren kann.
	 * @param text Text der die Eingabe auffordert
	 * @return den eingelesenen Wert
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
}
