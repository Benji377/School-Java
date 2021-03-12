// import wird für den Buffered gebraucht
import java.io.*;

public class Songliste {
	
	public static void main(String[] args) {
		// Von wo die Songs gelesen werden
		String quelle = "D:\\Eclipse TFO\\Workspace\\U08Klassen und Objekte\\src\\tracklist.csv";
		// Wo die Songs geordnet geschrieben werden
		String ziel = "D:\\Eclipse TFO\\Workspace\\U08Klassen und Objekte\\src\\sortlist.csv";
		// Anzahl der Zeilen, am Anfang 0
		int zeilen = 0;
		
		// Try-Block wird benutzt um um Fehler zu vermeiden
		try {
			// Die Datei an der Stelle quelle wird geöffnet und kann gelsesen werden
			BufferedReader reader = new BufferedReader(new FileReader(quelle));
			// Solange die Zeile nicht leer ist, werden die Zeiln gelesen
			while (reader.readLine() != null) {
				zeilen++;
			}
			// Der Leser wird geschlossen
			reader.close();
			//System.out.println("Zeilen: "+zeilen);
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		} catch (IOException e) {
			System.out.println("Lesefehler in Datei");
		}
		// Ein Array mit Song Objekte wird erstellt
		Song[] liste = new Song[zeilen];
		// Ein temporärer Song Objekt wird erstellt zum Zwischenspeichern
		Song temp = new Song();
		// Wiederum wird ein Try-Block benutzt um Fehler zu vermeiden
		try {
			// Die Datei an der Stelle wird wiederum geöffnet
			BufferedReader reader = new BufferedReader(new FileReader(quelle));
			// Schleife zum durchlaufen des Arrays
			for (int i = 0; i <= liste.length-1; i++) {
				// Jede Zeile die gelesen wird, wird zu einem String konvertiert
				String zeile = reader.readLine();
				// Muss zwei entfernen wegen komische doppelkomma fehler
				zeile = zeile.substring(0, zeile.length()-2);
				//System.out.println(i+". "+zeile);
				// An der Stelle i wird ein neues Song Objekt erstellt
				liste[i] = new Song();
				// Die Zeile wird dem Song Objekt übergeben
				liste[i].setSong(zeile);
				// i wird hier zwischengespeichert
				int j = i;
				// Hier wird der Song der größe nach richtig sortiert
				while (i != 0 && liste[i].compareTo(liste[i-1]) == 1) {
					// Der Song Objekt wird temporär zwischengespeichert
					temp = liste[i-1];
					// Der Song davor wird mit dem danach vertauscht
					liste[i-1] = liste[i];
					// Der Song Objekt dass zuvor zwischengespeichert wurde, wird wieder zurückgeschrieben
					liste[i] = temp;
					// i wird somit um eins kleiner, bis es 0 erreicht, oder alle Songs geordnet sind
					i--;
				}
				// Das zuvor zwischnegespeicherte i wird wieder zurückgeschrieben
				i = j;
			}
			// Am Ende wird der Leser geschlossen
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		} catch (IOException e) {
			System.out.println("Lesefehler in Datei");
		}
		//System.out.print("Perfekt: "+liste[liste.length-1].toString());
		
		// Es wird wiederum ein Try-Block benutzt
		try {
			// Diesmal wird die Datei an der Stelle ziel zum schreiben geöffnet
			BufferedWriter writer = new BufferedWriter(new FileWriter(ziel));
			// ACHTUNG: Am Ende jeder Zeile muss eine Zeilenschaltung \n eingefügt werden
			for (int i = 0; i < liste.length-1; i++) {
				// Die Elemente im Array werden zeilenweise in der Datei geschrieben
				writer.write(liste[i].toString()+"\n");
			}
			// Der Schreiber wird geschlossen
			writer.close();
		} catch (IOException e) {
			System.out.println("Datei nicht angelegt");
		}
		// Am Ende, wenn alles geklappt hat, wird "Done" ausgegeben
		System.out.print("Done");
	}
}
