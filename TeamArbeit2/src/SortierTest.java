import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SortierTest {

	/**
	 * Gibt das Array aus
	 */
	public static void printIntArray(String msg, int[] a) {
		String ret = "";
		ret += msg + "{";
		for (int i = 0; i < a.length; i++) {
			ret += a[i] + ", ";
		}
		System.out.println(ret.substring(0, ret.length() - 2) + "}");
	}

	/**
	 * Füllt das Array mit anzahl an zufälligen Zahlen im bereich min bis max.
	 * 
	 * @param anzahl
	 *            die anzahl der Zahlen
	 * @param min
	 *            die untere Grenze der Zahlen
	 * @param max
	 *            die obere Grenze der Zahlen
	 */
	public static int[] randomIntArray(int anzahl, int min, int max) {
		int ret[] = new int[anzahl];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = (int) (Math.random() * ((max - min) + 1)) + min;
		}
		return ret;
	}

	/**
	 * Füllt das Array mit bereits sortierten Zahlen.
	 */
	public static int[] fuellen(int anzahl) {
		int ret[] = new int[anzahl];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = i;
		}
		return ret;
	}

	public static void main(String[] args) {
		int max_rand = 100;
		// Variabeln zum logarithmischen Zählen
		// Anzahl Durchgänge
		int logaridings = 46;
		int tempx = 0;
		int tempy = 0;
		int tempz = 10;
		// Erstellt eine Stoppuhr
		Stoppuhr uhr = new Stoppuhr();
		// Erstellt einen Heapsort
		Heapsort heap = new Heapsort();
		// Erstellt eine Minimumsuche
		Minimumsuche min = new Minimumsuche();
		// Legt den Dateipfad fest
		uhr.setDateiname("D:\\Eclipse TFO\\Workspace\\TeamArbeit2\\zeiten.csv");
		// Sortiert das Array mit hilfe des Heapsort Algorithmus
		try {
			// Öffnet die Datei zum schreiben, statt überschriebn wird aber angehängt
			BufferedWriter writer = new BufferedWriter(new FileWriter(uhr.getDateiname(), true));
			// Ist die erste Zeile in der tabelle
			writer.write("Zeiten des Heapsort Algorithmus\n");
			writer.write("Anzahl an Elemente:" + ";" + "Zeit in ms:\n");
			// logaridings = Anzahl 0 der Anzahl an Elemnte * 10
			// zum Beispiel: Anzahl Elemnete = 100, dann ist Anzahl an 0 = 2 und *10 = 20
			// => logaridings = 20
			for (int i = 0; i <= logaridings; i++) {
				// Zwischenspeicherung der Variablen
				tempy = tempx;
				tempx *= tempz;
				// Zufällige Array wird erstellt
				int arr[] = randomIntArray(tempx, 0, max_rand);
				// Stoppuhr wird getsartet
				uhr.starteStoppuhr();
				// Array wird mit Heapsort sortiert
				heap.sort(arr);
				// Stoppuhr wird gestoppt
				uhr.stoppeStoppuhr();
				// Zeiten werden in die Datei geschrieben
				writer.write(tempx + ";" + uhr.getGestoppteZeit());
				writer.newLine();
				// Ausgabe zur KOntrolle
				System.out.println(
						"Nr= " + i + " | Elemente= " + tempx + " | " + "zeit= " + uhr.getGestoppteZeit() + "ms");

				// Bei 9 werden die Variabeln auf 0 gesetzt und die Erhöhung auf *10 erhöht
				if (tempy == 9) {
					tempz *= 10;
					tempx = 0;
					tempy = 0;
				}
				// Zurücksetzen der Variabeln
				tempx = tempy;
				tempx++;
			}
			// Datei geschlossen
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fertig");
		// Zurücksetzten der Variabeln
		tempx = 0;
		tempy = 0;
		tempz = 10;
		// Sortiert das Array mit hilfe des Heapsort Algorithmus
		try {
			// Öffnet die Datei zum schreiben, statt überschriebn wird aber angehängt
			BufferedWriter writer = new BufferedWriter(new FileWriter(uhr.getDateiname(), true));
			// Ist die erste Zeile in der tabelle
			writer.write("Zeiten des Minimumsuche Algorithmus\n");
			writer.write("Anzahl an Elemente:" + ";" + "Zeit in ms:\n");
			// logaridings = Anzahl 0 der Anzahl an Elemnte * 10
			// zum Beispiel: Anzahl Elemnete = 100, dann ist Anzahl an 0 = 2 und *10 = 20
			// => logaridings = 20
			for (int i = 0; i <= logaridings; i++) {
				// Zwischenspeicherung der Variablen
				tempy = tempx;
				tempx *= tempz;
				// Zufällige Array wird erstellt
				int arr[] = randomIntArray(tempx, 0, max_rand);
				// Stoppuhr wird getsartet
				uhr.starteStoppuhr();
				// Array wird mit Heapsort sortiert
				min.sort(arr);
				// Stoppuhr wird gestoppt
				uhr.stoppeStoppuhr();
				// Zeiten werden in die Datei geschrieben
				writer.write(tempx + ";" + uhr.getGestoppteZeit());
				writer.newLine();
				// Ausgabe zur KOntrolle
				System.out.println(
						"Nr= " + i + " | Elemente= " + tempx + " | " + "zeit= " + uhr.getGestoppteZeit() + "ms");

				// Bei 9 werden die Variabeln auf 0 gesetzt und die Erhöhung auf *10 erhöht
				if (tempy == 9) {
					tempz *= 10;
					tempx = 0;
					tempy = 0;
				}
				// Zurücksetzen der Variabeln
				tempx = tempy;
				tempx++;
			}
			// Datei geschlossen
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
