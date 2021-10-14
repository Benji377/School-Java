package net.tfobz.tictactoe.client;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;

import net.tfobz.tictactoe.TicTacToe;
import net.tfobz.tictactoe.gui.TicTacToeJFrame;
/**
 * Klasse stellt den Client fest. Der client wird nach dem Server gestartet und kann
 * als erster seinen Zug setzen. Die ipAdresse wird dabei in der main Methode übergeben.
 * @author Benjamin Demetz
 */
public class TicTacToeClient extends TicTacToe{
	private static final int FELDGROESSE = 3;
	private static String ipAdresse;
	private static final int PORT = 65000;
	private Socket client;
	
	/**
	 * Konstruktor des Clients
	 * Ruft hauptsächlich den TicTacToe Konstruktor auf und
	 * stellt die Feldgröße fest
	 * @param feldgroesse Die Feldgröße des Spielfelds
	 */
	public TicTacToeClient(int feldgroesse) {
		super(feldgroesse);
	}
	
	public static void main(String[] args) {
		TicTacToeClient t = new TicTacToeClient(FELDGROESSE);
		TicTacToeJFrame tFenster = new TicTacToeJFrame("TicTacToeClientGUI", t);
		// Wenn true läuft das Spiel
		boolean gamerun = true;
		// Ermittelt ob eine ipAdresse übergeben worden ist
		if (args == null || args.length <= 0) {
			gamerun = false;
			tFenster.setStatusleistentext("Keine ipAdresse übergeben!");
		} else {
			// ipAdresse = "127.0.0.1";
			ipAdresse = args[0];
		}
		// Schleife um das gesamte Programm durchlaufen zu lassen
		while (gamerun) {
			// Solange man noch gewinnen kann 
			while (t.getEinerKannGewinnen() && t.getGewonnen() == 0) {
				// Liest den Zug des clients
				tFenster.setStatusleistentext("Sie sind am Zug");
				int zug = tFenster.getGewaehlteFeldnummer();
				// Zahl darf nicht 0, -1, -2 oder -3 sein da die danach gesetzt werden
				int gueltigkeit = -4;
				try {
					// Kontrolliert somit ob es ein gültiger Zug ist (gueltigkeit = 0)
					gueltigkeit = t.setMeinZug(zug);
				} catch (IOException f) {
					// Gibt Fehlermeldung aus
					tFenster.setStatusleistentext("Ein Fehler ist aufgetreten");
					f.printStackTrace();
				}
				// Zug ist gültig
				if (gueltigkeit == 0) {
					tFenster.repaint();
					// Ob der erste Spieler bereits gewonnen hat oder nicht
					// Je nachdem kann der zweite Spieler noch ziehen
					boolean zug2 = t.getEinerKannGewinnen() && t.getGewonnen() == 0;
					while(zug2) {
						try {
							// Der client muss auf eine Antwort des servers warten
							tFenster.setStatusleistentext("Warten auf Zug des Gegners...");
							gueltigkeit = t.getGegnerZug();
						} catch (IOException e) {
							e.printStackTrace();
							tFenster.setStatusleistentext("Ein Fehler ist aufgetreten");
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
				tFenster.setStatusleistentext("Sie haben gewonnen!");
			else if (t.getGewonnen() == t.getSpieler2())
				tFenster.setStatusleistentext("Gegner hat gewonnen!");
			else if (!t.getEinerKannGewinnen())
				tFenster.setStatusleistentext("Unentschieden!");
			else
				tFenster.setStatusleistentext("Fehler!");
			
			// Spiel wird am Ende beendet
			gamerun = false;
			try {
				// Client wird geschlossen
				t.close();
			} catch (IOException g) {
				tFenster.setStatusleistentext("Ein Fehler ist aufgetreten");
				g.printStackTrace();
			}
		}
	}
	/**
	 * Schließt den clientSocket
	 * @throws IOException wenn der client bereits geschlossen ist
	 * oder nicht geschlossen werden kann
	 */
	public void close() throws IOException {
		client.close();
	}
	/**
	 * Setzt den Zug im Spielfeld. Wenn der Zug korrekt gesetzt werden konnte, 
	 * dann nimmt die Methode die Verbindung mit dem Server auf und sendet den Zug. 
	 * Wenn der Zug gesendet wurde, wird der ClientSocket nicht geschlossen, 
	 * denn der Server analysiert den Zug und schickt seinen Zug über denselben Socket zurück zum Client
	 * @param zug Der zu setzende Zug
	 * @return 0 falls Zug erfolgreich gesetzt werden konnte
	 * -1 falls der Zug außerhalb des Spielfeldes liegt
	 * -2 falls der Zug bereits gesetzt wurde
	 * -3 falls Clientsocket bereits existiert
	 * @throws IOException Wenn beim Erstellen des clients etwas schief läuft
	 * @throws UnknownHostException Wenn ipAdresse nicht stimmt
	 */
	public int setMeinZug(int zug) throws IOException, UnknownHostException{
		int ret;
		// Kontrolliert dass es nicht bereits ein client gibt
		if (client == null || client.isClosed()) {
			// Setzt den Zug im eigenen Spielfeld
			ret = setZugSpieler1(zug);
			// Wenn der Zug erfolgreich gesetzt wurde
			if (ret == 0) {
				// Sendet den Zug zum Server
				client = new Socket(ipAdresse, PORT);
				OutputStream out = client.getOutputStream();
				out.write(zug);
			}
		} else {
			ret = -3;
		}
		return ret;
	}
	/**
	 * Es wird über den bereits vorhandenen Socket auf den Zug des Servers gewartet. 
	 * Dabei muss der Socket existieren. Nach dem Empfangen wird der Socket geschlossen. 
	 * Weiters wird der empfangene Zug ins Spielfeld eingetragen
	 * @return 0 oder größer falls Zug erfolgreich geholt werden konnte
	 * -1 falls der Zug außerhalb des Spielfeldes liegt
	 * -2 falls der Zug bereits gesetzt wurde
	 * -3 falls kein Socket vorhanden ist
	 * @throws IOException
	 */
	public int getGegnerZug() throws IOException {
		int ret;
		// Kontrolliert dass der client noch existiert
		if (!client.isClosed()) {
			// Liest dann den Zug vom Server ein
			InputStream in = client.getInputStream();
			int zug = (byte)in.read();
			// Und versucht ihn einzutragen
			ret = setZugSpieler2(zug);
			// Danach wird der client geschlossen
			client.close();
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
		    } catch (InputMismatchException e ) {
		    	// Bei Fehlern wird eine Fehlermeldung ausgegeben
		    	System.out.println("Ungültige Eingabe");
		    }
	    }
	    return ret;
	}
}
