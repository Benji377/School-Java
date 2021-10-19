package net.tfobz.fahrzeugverwaltung;
import java.util.InputMismatchException;
import java.util.Vector;
import net.tfobz.fahrzeuge.*;

/**
 * Klasse zum verwalten von Fahrzeugen
 * Fahrzeuge werden mittels einen Vector gespeichert
 * @author benbe
 *
 */
public class Fahrzeugverwaltung {
	private static Vector<Object> vector = new Vector<Object>();
	

	/**
	 * Hauptmethode kontrolliert den Programmablauf
	 * @param args
	 */
	public static void main(String[] args) {
		// Solange diese Variable wahr ist, läuft die Schleife
		boolean running = true;
		// Schleife die das gesamte Programm nie zum stehen bleiben lässt
		while (running) {
			// Liste von möglichen Funktionen
			System.out.println("\nFahrzeugverwaltung\n"
					+ "==================\n"
					+ "1 - Eingeben\n"
					+ "2 - Suchen\n"
					+ "3 - Ändern\n"
					+ "4 - Löschen\n"
					+ "5 - Liste\n"
					+ "6 - Ende");
			// Liest den Input
			try {
				int auswahl = readInt("Ihre Wahl (1 - 6): ");
				// Switch case startet Methode je nach Auswahl
				if (auswahl >= 1 && auswahl <= 6) {
					switch (auswahl) {
					case 1:
						eingeben();
						break;
					case 2:
						suchen();
						break;
					case 3:
						aendern();
						break;
					case 4:
						loeschen();
						break;
					case 5:
						liste();
						break;
					case 6:
						running = false;
						break;
					}
				} else {
					System.out.println("### Fehler ###");
				}
			} catch (InputMismatchException e) {
				System.out.println("Falsche eingabe");
			}
		}
	}
	
	/**
	 *  Nachdem der Benutzer ausgewählt hat, ob er ein Fahrrad, Auto oder
	 *  einen Lastwagen eingeben will, muss er die Datenelemente des
	 *  Objektes eingeben. Dieses neue Objekt wird am Ende des Vektors
	 *  eingetragen.
	 */
	public static void eingeben() {
		// Schleife geht so lange durch bis eine gültige Eingabe steht
		boolean guteAntwort = false;
		while (!guteAntwort) {
			// Liste von möglichen Optionen
			System.out.println("1. Eingeben\n"
					+ "===========\n"
					+ "1. Fahrrad\n"
					+ "2. Auto\n"
					+ "3. Lastwagen");
			// Speichert die Eingabe des Benutzers
			int input = readInt("Ihre Wahl (1-3): ");
			// Switch case kontrolliert die Eingabe 
			switch (input) {
			case 1:
				// Fahrrad wird eingegeben
				System.out.println("1. Fahrrad\n"
						+ "==========");
				int f_geschw = readInt("Geschwindigkeit: ");
				boolean f_bel = readBoolean("Beleuchtung: ");
				int f_kil = readInt("Kilometerstand: ");
				// Neues Fahrrad Objekt
				Fahrrad fahrrad = new Fahrrad(f_geschw);
				fahrrad.setBeleuchtung(f_bel);
				fahrrad.setKilometerstand(f_kil);
				// Zum Vector hinzugefügt
				vector.add(fahrrad);
				guteAntwort = true;
				break;
			case 2:
				// Auto wird eingegeben
				System.out.println("2. Auto\n"
						+ "====");
				int a_geschw = readInt("Geschwindigkeit: ");
				int a_ps = readInt("PS: ");
				int a_kil = readInt("Kilometerstand: ");
				// Neues Auto Objekt
				Auto auto = new Auto(a_geschw, a_ps);
				auto.setKilometerstand(a_kil);
				// Wird dem Vektor hinzugefügt
				vector.add(auto);
				guteAntwort = true;
				break;
			case 3:
				// Lastwagen wird hinzugefügt
				System.out.println("1. Lastwagen\n"
						+ "=========");
				int l_geschw = readInt("Geschwindigkeit: ");
				int l_ps = readInt("PS: ");
				int l_lade = readInt("Ladefläche: ");
				int l_kil = readInt("KIlometerstand: ");
				// Erstellt ein neues Objekt
				Lastwagen lastwagen = new Lastwagen(l_ps, l_geschw, l_lade);
				lastwagen.setKilometerstand(l_kil);
				// Fügt es dem Vektor hinzu
				vector.add(lastwagen);
				guteAntwort = true;
				break;	
			}
		}
	}
	
	
	/**
	 * Der Benutzer gibt die Nummer d. h. die Position des zu suchenden Objektes im Vektor - an,
	 * welches dann aus dem Vektor geholt und angezeigt wird. Ist kein Objekt mit dieser Nummer im
	 * Vektor vorhanden, wird eine Fehlermeldung ausgegeben.
	 */
	public static void suchen() {
		System.out.println("2. Suchen"
				+ "=========");
		// Eingabe des Benutzers
		int position = readInt("Position im Vector: ");
		try {
			// Versucht die Position im Vector zu finden
			Object obj = vector.get(position);
			System.out.println(obj.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			// Wenn die Position fehlt
			System.out.println("Nichts gefunden");
		}
		
	}
	
	
	/**
	 * Der Benutzer gibt die Nummer des zu ändernden Objektes an. Dieses wird gesucht und angezeigt.
	 * Der Benutzer kann die Datenelemente des Objektes ändern, und die Änderungen werden in den
	 * Vektor an derselben Stelle eingetragen.
	 */
	public static void aendern() {
		System.out.println("3. Ändern\n"
				+ "=========");
		// Eingabe des Benutzers
		int pos = readInt("Position im Vector");
		try {
			Object obj = vector.get(pos);
			// Gibt das gefundene Objekt als String aus
			System.out.println(obj.toString());
			// Kontrolliert die Klasse des Objekts
			if (obj instanceof Fahrrad) {
				// Fahrrad wird bearbeitet
				System.out.println("Neue Werte: ");
				int f_geschw = readInt("Geschwindigkeit: ");
				boolean f_bel = readBoolean("Beleuchtung: ");
				int f_kil = readInt("Kilometerstand: ");
				// Erstellt ein neues Objekt und übergibt ihm die euen Werte
				Fahrrad fahrrad = new Fahrrad(f_geschw);
				fahrrad.setBeleuchtung(f_bel);
				fahrrad.setKilometerstand(f_kil);
				// Altes Objekt wird gelöscht um Duplikate zu vermeiden
				vector.remove(pos);
				vector.add(pos, fahrrad);
			} else if (obj instanceof Auto) {
				System.out.println("Neue Werte: ");
				int a_geschw = readInt("Geschwindigkeit: ");
				int a_ps = readInt("PS: ");
				int a_kil = readInt("Kilometerstand: ");
				// Erstellt ein neues Objekt und übergibt ihm die euen Werte
				Auto auto = new Auto(a_geschw, a_ps);
				auto.setKilometerstand(a_kil);
				// Altes Objekt wird gel�scht um Duplikate zu vermeiden
				vector.remove(pos);
				vector.add(pos, auto);
			} else if (obj instanceof Lastwagen) {
				System.out.println("Neue Werte: ");
				int l_geschw = readInt("Geschwindigkeit: ");
				int l_ps = readInt("PS: ");
				int l_lade = readInt("Ladefläche: ");
				int l_kil = readInt("Kilometerstand: ");
				// Erstellt ein neues Objekt und übergibt ihm die euen Werte
				Lastwagen lastwagen = new Lastwagen(l_ps, l_geschw, l_lade);
				lastwagen.setKilometerstand(l_kil);
				// Altes Objekt wird gelöscht um Duplikate zu vermeiden
				vector.remove(pos);
				vector.add(pos, lastwagen);
			} else {
				System.out.println("Invalid obj = "+obj.getClass());
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nichts gefunden");
		}
	}
	
	
	/**
	 * Der Benutzer gibt die Nummer des zu löschenden Objektes ein. Falls ein Objekt an dieser Stelle im
	 * Vektor vorhanden ist, wird es gelöscht.
	 */
	public static void loeschen() {
		System.out.println("4. Löschen"
				+ "==========");
		int pos = readInt("Position im Vector: ");
		try {
			// Löscht das Objekt an der gegebenen Position, wenn gegeben
			vector.remove(pos);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nichts gefunden");
		}
	}
	
	
	/**
	 * Es wird eine Liste aller im Vektor enthaltenen Objekte ausgegeben. Dabei wird jedes Objekt in einer
	 * einzelnen Zeile platziert. Am Beginn der Zeile wird die Nummer des Objektes, der Typ und die
	 * Datenelemente ausgegeben
	 */
	public static void liste() {
		// Kontrolliert ob die Liste nicht leer ist
		if (!vector.isEmpty()) {
			// Verbesserte for Schleife -> Geht durch alle Elemente im vector durch
			for (Object obj : vector) {
				
				// Ermittelt den Klasssenname und löscht eventuell den Package name raus
				String className = obj.getClass().getName();
			    int firstChar = className.lastIndexOf('.') + 1;
			    if (firstChar > 0) {
			      className = className.substring(firstChar);
			    }
				
				// Gibt Daten des Objektes zurück
				System.out.println(vector.indexOf(obj)+": "+className+" "+obj.toString());
			}
		} else {
			System.out.println("Liste ist leer");
		}
	}
	
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}
	public static boolean readBoolean(String text) {
		System.out.print(text);
		return (new java.util.Scanner(System.in)).nextBoolean();
	}

}
