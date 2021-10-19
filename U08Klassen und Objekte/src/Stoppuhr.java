import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.GregorianCalendar;

public class Stoppuhr {
	// Variabeln werden initialisiert
	private String dateiname;
	private long gestoppteZeit;
	// ueiten ist ein Array dass bis zu einem maximum von 1000 gestoppte Zeiten speichern kann
	private long[] zeiten = new long[1000];
	
	/**
	 * Methode um den Dateiname zurückzugeben
	 * @return den Pfad zur Datei in der die Werte gespeichert werden sollen, bzw. den Dateiname
	 */
	public String getDateiname() {
		return dateiname;
	}
	/**
	 * Methode um den Dateiname zu setzen
	 * @param dateiname den Pfad zur Datei in der die Zeiten gespeichert werden sollen, bzw. den Dateinamen 
	 */
	public void setDateiname(String dateiname) {
		this.dateiname = dateiname;
	}
	/**
	 * Methode um die gestoppte Zeit zurückzugeben
	 * @return die gestoppte Zeit
	 */
	public long getGestoppteZeit() {
		return gestoppteZeit;
	}
	/**
	 * Methode um die gestoppte Zeit zu setzen
	 * @param gestopptezeit die Zeit in Millisekunden
	 */
	public void setGestoppteZeit(long gestopptezeit) {
		this.gestoppteZeit = gestopptezeit;
	}
	
	
	/**
	 * Methode um die Stoppuhr zu starten
	 * Dabei wird die Aktuelle Zeit in Millisekunden gespeichert
	 */
	public void starteStoppuhr() {
		// Konvertiert die aktuelle Zeit in Millisekunden
		long millis = new java.util.GregorianCalendar().getTimeInMillis();
		// Die aktuelle Zeit ist auch die aktuelle Stoppzeit
		setGestoppteZeit(millis);
		
	}
	/**
	 * Methode um die Stoppuhr zu stoppen
	 * Dabei wird wiederum die aktuelle Zeit in Millisekunden gespeichert,
	 * diesmla wird sie aber mit der vorherigen subtrahiert
	 */
	public void stoppeStoppuhr() {
		// Konvertiert die aktuelle Zeit in Millisekunden
		long stopped = new java.util.GregorianCalendar().getTimeInMillis();
		// Hier wird die Zeit subtrahiert, und da es sich dann um einen negativen Wert handelt, 
		// mit -1 multipliziert
		setGestoppteZeit((getGestoppteZeit() - stopped)*-1);
		// Die Schleife durchläuft das Array und sucht nach freie Stellen
		for(int i = 0; i < zeiten.length; i++) {
			// Wenn eine freie Stelle gefunden wurde, wird der Wert eingetragen
			// und die Schleife abgebrochen
			if(zeiten[i] == 0) {
				zeiten[i] = getGestoppteZeit();
				i += zeiten.length;
			}
		}
	}
	
	/**
	 * Methode um die im Array gespeicherte Zeiten in eine Datei zu schreiben.
	 * Dabei wird die Datei am Pfad "Dateiname" geöffnet,
	 * dann geht eine Schleife das Array durch und schrebt alle Werte in die Datei
	 * @return 0 wenn alles gut gelaufen ist, sonst 1
	 */
	public int schreibeZeiten() {
		// 1 bedeutet dass es nicht erfolgreich war
		int ret = 1;
		// Es wird ein Try-Block benutzt um Fehler vorzubeugen
		try {
			// Die Datei am Pfad Dateiname wird zum schreiben geöffnet
			BufferedWriter writer = new BufferedWriter(new FileWriter(getDateiname()));
			// Die Schleife geht den Array zeit durch und kontrolliert ob es Werte gespeichert hat
			for (int i = 0; i < zeiten.length; i++) {
				// Wenn an der Stelle i ein Wert vorhanden ist, bzw. nicht 0 ist, dann soll es in 
				//die Datei geschrieben werden
				if (zeiten[i] != 0) {
					writer.write(zeiten[i] + "\n");
				}
			}
			// Die Datei und somit der Schreiber werden geschlossen
			writer.close();
			// Wenn ret 0 ist, dann ist alles gut gelaufen
			ret = 0;
		} catch (IOException e) {
			System.out.println("Datei nicht gefunden");
			ret = 1;
		}
		return ret;
	}
	
}
