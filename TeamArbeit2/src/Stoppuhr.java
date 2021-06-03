

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Stoppuhr {

	// Membervariablen
	private String dateiname;
	private int i;
	private long startmili;
	private long gestoppteZeit;
	private long[] stoppzeiten = new long[1000];

	/**
	 * Liefert den Dateinamen zurück
	 * 
	 * @return den Namen der Datei
	 */
	public String getDateiname() {
		return dateiname;
	}

	/**
	 * Setzt den Dateinamen
	 * 
	 * @param dateiname
	 *            der zu setzende Dateiname
	 */
	public void setDateiname(String dateiname) {
		this.dateiname = dateiname;
	}

	/**
	 * Liefert die gestoppte Zeit zurück
	 * 
	 * @return die gestoppte Zeit
	 */
	public long getGestoppteZeit() {
		return gestoppteZeit;
	}

	/**
	 * Setzt die gestoppte Zeit
	 * 
	 * @param gestoppteZeit
	 *            die zu setzende gestoppte Zeit
	 */
	public void setGestoppteZeit(long gestoppteZeit) {
		this.gestoppteZeit = gestoppteZeit;
	}

	/**
	 * Speichert die aktuelle Zeit in Millisekunden in die Membervariable stertmili
	 */
	public void starteStoppuhr() {
		this.startmili = new java.util.GregorianCalendar().getTimeInMillis();
	}

	/**
	 * Die Methode errechnet die gestoppte Zeit indem sie die aktuelle Zeit mit
	 * stertmili subtrahiert.
	 */
	public void stoppeStoppuhr() {
		if (this.startmili != 0) {
			this.gestoppteZeit = (new java.util.GregorianCalendar().getTimeInMillis()) - this.startmili;
			this.stoppzeiten[i] = this.gestoppteZeit;
			this.i++;
		}
	}

	/**
	 * Schreibt die errechneten Zeiten in eine csv Datei. Falls ein Fehler auftritt
	 * wird -1 zurückgegeben.
	 * 
	 * @return 0 wenn kein Fehler ist. -1 wenn ein Fehler aufgetreten ist.
	 */
	public int schreibeZeiten() {
		int ret = 0;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(dateiname));
			writer.write("Zeit in ms ; Anzahl der Elemente\n");
			for (int j = 0; j < i; j++) {
				writer.write(stoppzeiten[j] + ";" + "\n");
			}
			writer.close();
		} catch (IOException e) {
			ret = -1;
		}
		return ret;
	}
}
