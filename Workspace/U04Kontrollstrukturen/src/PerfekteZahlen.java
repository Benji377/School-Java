
public class PerfekteZahlen {

	public static void main(String[] args) {
		int zahl = 2;
		int zahlencounter = 0;
		int summe = 1;
		
		// Schleife zählt die perfekte Zahlen
		while (zahlencounter < 5) {
			int teiler = 2;
			// Schleife vergrößert den Teiler
			while (teiler <= zahl) {
				if (zahl%teiler == 0) {
					summe += teiler;
					teiler++;
				} else {
					teiler++;
				}
			}
			// Gibt die perfekten Zahlen aus
			if ((summe - zahl) == zahl) {
				System.out.print(zahl + " ; ");
				zahl++;
				zahlencounter++;
				summe = 1;
			} else {
				zahl++;
				summe = 1;
			}
			// Notbremse nach 5. Zahl
			if (zahl > 33550336) { 
				break;
			}
		}
	}

}
