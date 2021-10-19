import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GUI extends JFrame {

	private JLabel l = null; // Private Komponenten des Fensters;
	private JLabel lnr = null;
	private JLabel laus = null;
	private JButton b = null;
	private JButton baus = null;
	private JButton bstart = null;
	private JButton bloe = null;
	private JTextField t = null;
	private String pfad = "D:\\Eclipse TFO\\Workspace\\TeamArbeit2\\zeiten.csv";
	private boolean modus = true;
	private boolean ausgabe = false;

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

	public GUI() { // Konstruktor des Fensters

		setTitle("Sortieralgorithmen"); // Fenstereigenschaften
		setBounds(50, 60, 260, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		l = new JLabel("Heapsort"); // Komponenten anlegen
		l.setBounds(20, 10, 90, 25);

		lnr = new JLabel("Durchgänge:"); // Komponenten anlegen
		lnr.setBounds(20, 50, 90, 25);

		laus = new JLabel("ohne Ausgabe");
		laus.setBounds(20, 85, 90, 25);

		t = new JTextField();
		t.setBounds(120, 50, 100, 25);

		b = new JButton();
		b.setText("Ändern");
		b.setBounds(120, 10, 100, 25);

		baus = new JButton();
		baus.setText("Ändern");
		baus.setBounds(120, 85, 100, 25);

		bstart = new JButton();
		bstart.setText("Start");
		bstart.setBounds(120, 120, 100, 25);
		
		bloe = new JButton();
		bloe.setText("Löschen");
		bloe.setBounds(20, 120, 100, 25);

		Container contentPane = getContentPane();// Komponenten zum Fenster fügen
		contentPane.setLayout(null);
		contentPane.add(l);
		contentPane.add(lnr);
		contentPane.add(laus);
		contentPane.add(b);
		contentPane.add(bstart);
		contentPane.add(baus);
		contentPane.add(bloe);
		contentPane.add(t);

		setVisible(true); // Fenster sichtbar machen

		b.addActionListener( // Ereignis: Knopf drücken
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if (l.getText() == "Heapsort") {
							l.setText("Minimumsuche");
							modus = false;
						} else {
							l.setText("Heapsort");
							modus = true;
						}

					}
				});

		baus.addActionListener( // Ereignis: Knopf drücken
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if (laus.getText() == "ohne Ausgabe") {
							laus.setText("mit Ausgabe");
							ausgabe = true;
						} else {
							laus.setText("ohne Ausgabe");
							ausgabe = false;
						}

					}
				});

		bstart.addActionListener( // Ereignis: Knopf drücken
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {

						int max_rand = 100;
						// Variabeln zum logarithmischen Zählen
						int logaridings = 0;
						try {
							logaridings = Integer.parseInt(t.getText());
						} catch (NumberFormatException e) {
							t.setText("Fehler!");
						}
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
						uhr.setDateiname(pfad);

						if (modus) {
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
									System.out.println("Nr= " + i + " | Elemente= " + tempx + " | " + "zeit= "
											+ uhr.getGestoppteZeit() + "ms");
									// Ausgabe des Arrays
									if (ausgabe == true) {
										printIntArray("Array: ", arr);
									}
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

						} else {

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
									System.out.println("Nr= " + i + " | Elemente= " + tempx + " | " + "zeit= "
											+ uhr.getGestoppteZeit() + "ms");
									// Ausgabe des Arrays
									if (ausgabe == true) {
										printIntArray("Array: ", arr);
									}
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
						}

					}
				});
		
		bloe.addActionListener( // Ereignis: Knopf drücken
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						int counter = 0;
						try {
							BufferedReader reader = new BufferedReader(new FileReader(pfad));
							while (true) {
								String zeile = reader.readLine();
								if (zeile == null)
									// Dateiende erkannt
									break;
								else
									counter++;
									
							}
							reader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						try {
							BufferedWriter writer = new BufferedWriter(new FileWriter(pfad));
							for (int i = 0; i < counter; i++) {
								writer.write("");
							}
							writer.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				});

	} // Ende des Konstruktors
}
