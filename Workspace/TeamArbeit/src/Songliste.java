import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Songliste {

	private int anzahl = 0;
	private static int DEFAULT_MAXANZAHL = 1000;
	private int nummerAktueller = 0;
	private java.lang.String pfad = "";
	private Song[] songs;
	
	/**
	 * Konstruktor, der ein privates Array initialisiert 
	 * in welchem maxAnzahl Songs aufgenommen werden k�nnen. 
	 * Ist maxAnzahl <= 0, so wird �ber die interne songs-Variable ein Array angelegt das DEFAULT_MAXANZAHL Songs aufnehmen kann.
	 *  Weiters wird anzahl auf 0 gesetzt weil noch keine Songs in der Liste vorhanden sind und nummerAktueller auf -1, 
	 *  weil noch kein Song angesprungen wurde
	 * @param maxAnzahl
	 */
	Songliste(int maxAnzahl) {
		if (maxAnzahl <=  0) {
			songs = new Song[DEFAULT_MAXANZAHL];
		}
		else {
			songs = new Song[maxAnzahl];
		}
		this.anzahl = 0;
		this.nummerAktueller = -1;;
	}
	
	/**
	 * �ndert den aktuellen Song auf den �bergebenen Song ab und sortiert ihn nicht ein
	 * @param s, der Song der die zu �ndernden Werte enth�lt
	 * @return 0 falls die �nderung erfolgreich durchgef�hrt werden konnte 
	 * 		  -1 falls kein zu �ndernder Song �bergeben wurde
	 * 		  -2 falls der aktuelle Song nicht bekannt ist
	 */
	public int aendernAktuellen(Song s) {
		int ret = -1;
		if (s != null) {
			if (this.nummerAktueller >= 0) {
				songs[this.nummerAktueller] = s;
				ret = 0;
			}
			else {
				ret = -2;
			}
		}
		return ret;
	}

	/**
	 * Tr�gt einen neuen Song am Ende der Songliste ein. Die Anzahl der Songs wird um Eins erh�ht 
	 * und die nummerAktueller wird auf diesen Song gesetzt. 
	 * Der Song wird nicht eingetragen, wenn im Array kein Platz mehr ist.
	 * @param s, der einzutragende Song
	 * @return 0 falls das Eintragen erfolgreich war 
	 * 		  -1 falls kein einzutragender Song �bergeben wurde
	 * 		  -2 falls die Songliste keinen Platz f�r einen weiteren Song hat
	 */
	public int anfuegenNeuen(Song s) {
		int ret = -1;
		if (s != null) {
			System.out.println("nummerA vor anfugen:"+ this.nummerAktueller+" [songliste]");
			for (int i = 0; i < anzahl+10; i++) {
				System.out.println("songs:"+ i+" "+songs[i]);
			}
			if (this.getAnzahl() < this.getMaxAnzahl()) {
				this.nummerAktueller = this.getAnzahl();
				this.anzahl++;
				this.songs[this.nummerAktueller] = s;
				for (int i = 0; i < anzahl+10; i++) {
					System.out.println("songs:"+ i+" "+songs[i]);
				}
				System.out.println("nummerA nach anfugen:"+ this.nummerAktueller+" [songliste]");
				ret = 0;
			}
			else {
				ret = -2;
			}
		}
		return ret;
	}

	/**
	 * Liefert den aktuellen Song zur�ck auf den der Songzeiger nummerAktueller zeigt
	 * @return den aktuellen Song oder null, falls kein Song in der Songliste enthalten ist
	 */
	public Song getAktueller() {
		Song ret = null;
		if (this.nummerAktueller >= 0) {
			ret = songs[this.nummerAktueller];
			System.out.println("aktueller:"+ this.nummerAktueller+" [songliste]");
		}
		return ret;
	}

	/**
	 * Gibt die Anzahl der Songs zur�ck, die momentan im Array vorhanden sind
	 * die Anzahl der Songs die im Array momentan eingetragen sind
	 * 0 falls das Array zwar angelegt wurde aber noch keine Elemente enthalten sind
	 */
	public int getAnzahl() {
		return anzahl;
	}

	/**
	 * Liefert den ersten Song in der Songliste zur�ck und setzt den Songzeiger auf diesen Song. 
	 * Ist die Liste leer, wird null zur�ck geliefert
	 * @return den ersten Song in der Liste
	 */
	public Song getErster() {
		Song ret = null;
		if (this.getAnzahl() > 0) {
			this.nummerAktueller = 0;
			ret = this.songs[this.nummerAktueller];
			System.out.println("erster:"+ this.nummerAktueller+" [songliste]");
		}
		return ret;
	}

	/**
	 * Liefert den letzten Song in der Songliste zur�ck und setzt den Songzeiger auf diesen Song. 
	 * Ist die Liste leer, wird null zur�ck geliefert
	 * @return den letzten Song
	 */
	public Song getLetzter() {
		Song ret = null;
		if (this.getAnzahl() > 0) {
			this.nummerAktueller = this.getAnzahl()-1;
			ret = this.songs[this.nummerAktueller];
			System.out.println("letzter:"+ this.nummerAktueller+" [songliste]");
		}
		return ret;
	}

	/**
	 * Liefert die Maximale Anzahl von Songs zur�ck, die im Array abgespeichert werden k�nnen
	 * @return die Anzahl der im Array maximal eintragbaren Songs
	 */
	public int getMaxAnzahl() {
		return this.songs.length;
	}
	
	/**
	 * Liefert den n�chsten Song - falls vorhanden - zur�ck und erh�ht den Songzeiger nummerAktueller um Eins. 
	 * Gibt es keinen n�chsten Song, wird null zur�ck geliefert und der Songzeiger nicht erh�ht
	 * @return liefert den n�chsten Song zur�ck oder null, falls dieser Song nicht vorhanden ist
	 */
	public Song getNaechster() {
		Song ret = null;
		if (this.songs[this.nummerAktueller+1] != null) {
			this.nummerAktueller++;
			ret = this.songs[this.nummerAktueller];
			System.out.println("Naechster:"+ this.nummerAktueller+" [songliste]");
		}
		return ret;
	}
	
	/**
	 * Liest den Dateipfad aus
	 * @return dateipfad
	 */
	public java.lang.String getPfad() {
		return this.pfad;
	}

	/**
	 * Liefert den vorigen Song - falls vorhanden - zur�ck und vermindert den Songzeiger um Eins. 
	 * Gibt es keinen vorigen Song wird null zur�ck geliefert und der Songzeiger nicht vermidert
	 * @return den vorigen Song
	 */
	public Song getVoriger() {
		Song ret = null;
		if (this.nummerAktueller-1 >= 0) {
			this.nummerAktueller--;
			ret = this.songs[this.nummerAktueller];
			System.out.println("Nummer-Aktueller:"+ this.nummerAktueller+" [songliste]");
		}
		return ret;
	}
	
	/**
	 * L�dt die Songs aus der Textdatei die in pfad vorhanden ist. 
	 * Dabei werden die bereits in der Songliste gespeicherten Songs gel�scht. 
	 * Nach dem Einf�gen sind die Songs in sortierter Reihenfolge vorhanden. 
	 * Als aktueller Song wird der Erste angesprungen
	 * @return 0 falls die Songs erfolgreich ein gef�gt werden konnten
	 * 		  -1 falls der Pfad nicht gesetzt ist
	 * 		  -2 falls die Datei nicht zu finden ist
	 * 		  -3 falls ein Lesefehler in der Datei vorhanden ist
	 * 		  -4 das interner Array kann nicht alle Songs aufnehmen, weil es zu klein dimensioniert ist
	 */
	public int lesenSongs() {
		int ret = 0;
		//Allle l�schen
		this.loeschenAlle();
		if (this.getPfad() != null) {
			int counter = 0;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(this.getPfad()));
				while (true) {
					String zeile = reader.readLine();
					// Dateiende erkannt
					if (zeile == null) {
						break;
					} else {
						counter++;
					}

				}
				reader.close();
			} catch (FileNotFoundException e) {
				ret = -2;
			} catch (IOException e) {
				ret = -3;
			}
			if (counter > this.getMaxAnzahl()) {
				ret = -4;
			}
			anzahl = counter;
			//Falls es noch nicht zum Fehler gekommen ist
			if (ret == 0) {
				String line;
				try {
					BufferedReader reader = new BufferedReader(new FileReader(this.getPfad()));
					// Das Song-Array wird Element f�r Element durchgegangen
					for (int i = 0; i < counter; i++) {
						// Zeile wird gelesen und in der String-Variable zeile gespeichert
						line = reader.readLine();
						// Instanziierung des Song-Objektes an der Stelle i im Array
						songs[i] = new Song();
						/*
						 * Das Song-Objekt erh�lt den Inhalt der zuvor ausgelesenen Zeile. Dazu wird die
						 * Methode setSong aus der Klasse Song verwendet
						 */
						songs[i].setSong(line);
						
						// Hilfsvariable
						int j = i;
						/*
						 * Solange j gr��er, als der kleinste Index 0 ist und das Objekt an der Stelle j
						 * kleiner ist, als das Objekt an der Stelle j-1...
						 */
						while (j > 0 && songs[j].compareTo(songs[j - 1]) == -1) {
							// Ein Hilfs-Objekt vom Typ Song
							Song help = new Song();
							// Die beiden Objekte werden im Array vertauscht
							help = songs[j - 1];
							songs[j - 1] = songs[j];
							songs[j] = help;
							// Fortschaltung
							j--;
						}
					}
					this.nummerAktueller = 0;
					ret = 0;
					reader.close();
				} catch (FileNotFoundException e) {
					ret = -2;
				} catch (IOException e) {
					ret = -3;
				}
			}
		}
		else {
			ret = -1;
		}
		return ret;
	}

	/**
	 * L�scht den aktuellen Song aus der Liste. 
	 * Dies kann nur passieren, wenn die Nummer des aktuellen Songs gesetzt ist. 
	 * Da im Array eine L�cke entsteht, m�ssen alle nachfolgenden Songs um eine Stelle nach vorne geschoben werden. 
	 * Der aktuelle Song wird jener Song der dem zu l�schenden Song folgt. 
	 * Ist der zu l�schende Song der letzte Song in der Liste, so wird der aktuelle Song jener Song der vor dem zu l�schenden 
	 * Song vorhanden ist. Ist der zu l�schende Song der einzige in der Liste, so wird die nummerAktueller auf -1 gesetzt. 
	 * Beim L�schen wird anzahl um Eins verringert
	 * @return 0 falls das L�schen erfolgreich durchgef�hrt werden konnte
	 * 		  -1 falls der aktuelle Song noch nicht gesetzt wurde
	 */
	public int loeschenAktuellen() {
		int ret = -1;
		if (this.nummerAktueller >= 0) {
			if (this.nummerAktueller == this.getAnzahl()-1) {
				System.out.println("loschen1-:"+ this.nummerAktueller+" [songliste]");
				songs[this.nummerAktueller] = null;
				this.nummerAktueller--;
				System.out.println("nach loschen: "+ this.nummerAktueller+" [songliste]");
				this.anzahl--;
				ret = 0;
			}
			else {
				if (this.nummerAktueller == 0 && this.getAnzahl() == 1) {
					songs[this.nummerAktueller] = null;
					this.nummerAktueller = -1;
					this.anzahl--;
					ret = 0;
				}
				else {
					for (int i = this.nummerAktueller; i < this.getAnzahl(); i++) {
						songs[i] = songs[i+1];
					}
					this.anzahl--;
					ret = 0;
				}
			}
		}
		return ret;
	}

	/**
	 * L�scht alle Songs aus der Liste. Setzt die Anzahl auf 0 und die Nummer des aktuellen Songs auf -1
	 * @return 0 falls das L�schen erfolgreich war
	 * 		  -1 falls die Liste bereits leer ist
	 */
	public int loeschenAlle() {
		int ret = -1;
		if (this.getAnzahl() > 0 && this.nummerAktueller > -1) {
			for (int i = 0; i < this.getAnzahl(); i++) {
				songs[i] = null;
			}
			this.nummerAktueller = -1;
			this.anzahl = 0;
			ret = 0;
		}
		return ret;
	}

	/**
	 * Schreibt die Songs in die Textdatei. Dabei werden die in der Datei gespeicherten Songs gel�scht
	 * @return 0 falls die Songs erfolgreich ein gef�gt werden konnten
	 * 		  -1 falls der Pfad nicht gesetzt wurde
	 *        -2 falls die Datei nicht angelegt werden konnte
	 */
	public int schreibenSongs() {
		int ret = -1;
		if (this.getPfad() != null) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(this.getPfad()));
				//Schreiben der Songs
				for (int i = 0; i < anzahl; i++) {
					writer.write(songs[i].toString());
					if (i < anzahl-1) {
						writer.write("\n");
					}
				}
				ret = 0;
				writer.close();
			} catch (IOException e) {
				ret = -2;
			}
		}
		return ret;
	}

	/**
	 * Setzt den Dateipfad auf jene Datei aus welcher die Songs gelesen bzw. in welche die Songs geschrieben werden soll
	 * @param pfad als String
	 */
	public void setPfad(java.lang.String pfad) {
		this.pfad = pfad;
	}
	
	

}
