import java.util.Scanner;

public class Fahrzeugverwaltung {

	public static void main(String[] args) {
		boolean guteAntwort = false;
		while (guteAntwort == false) {
			System.out.print("Fahrzeugverwaltung\n"
					+ "==================\n"
					+ "1 - Eingeben\n"
					+ "2 - Suchen\n"
					+ "3 - Ändern\n"
					+ "4 - Löschen\n"
					+ "5 - Liste\n"
					+ "6 - Ende\n");
			Scanner input = new Scanner(System.in);
			System.out.print("Ihre Wahl (1 - 6): ");
			String auswahl = input.nextLine();
			try {
				int int_auswahl = Integer.valueOf(auswahl);
				if (int_auswahl >= 1 && int_auswahl <= 6) {
					System.out.println(int_auswahl);
					guteAntwort = true;
				} else {
					System.out.println("### Ungültige Auswahl ###");
				}
			} catch (NumberFormatException e) {
				System.out.println("### Es werden nur Zahlen akzeptiert! ###");
			}
		}
	}
	
	public void eingeben() {
		// G = geschwindigkeit, P = ps, k = kilo, l = ladeflache, b = Beleuchtung(boolean)
		// Auto: g, k, p
		// Lastwagen: g, k, p, l
		// Fahrrad: g, k, b
	}

}
