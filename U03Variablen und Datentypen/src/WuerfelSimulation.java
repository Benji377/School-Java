
public class WuerfelSimulation {

	public static void main(String[] args) {
		System.out.println("Würfelsimulation\n=================");
		System.out.println("Bitte warten");
		// checkpoint = 1.000.000.000 / 20
		int checkpoint = 50000000;
		int wurfelanzahl = 0;
		int anzahl1 = 0;
		int anzahl2 = 0;
		int anzahl3 = 0;
		int anzahl4 = 0;
		int anzahl5 = 0;
		int anzahl6 = 0;
		
		while (wurfelanzahl < 1000000000) {
			if (wurfelanzahl == checkpoint) {
				// 20 Punkte langer Ladebalken
				System.out.print(".");
				checkpoint += 50000000;
			}
			// Zufallsgenerator
			int wurf = (int) ((Math.random() * 6) + 1);
			// Ergebniss wird überprüft
			if (wurf == 1) {
				anzahl1++;
			} else if (wurf == 2) {
				anzahl2++;
			} else if (wurf == 3) {
				anzahl3++;
			} else if (wurf == 4) {
				anzahl4++;
			} else if (wurf == 5) {
				anzahl5++;
			} else if (wurf == 6) {
				anzahl6++;
			}
			wurfelanzahl++;
		}
		System.out.println();
		System.out.println("Anzahl 1: " + anzahl1);
		System.out.println("Anzahl 2: " + anzahl2);
		System.out.println("Anzahl 3: " + anzahl3);
		System.out.println("Anzahl 4: " + anzahl4);
		System.out.println("Anzahl 5: " + anzahl5);
		System.out.println("Anzahl 6: " + anzahl6);
		System.out.println();
		System.out.println("Anzahl Würfe: " + wurfelanzahl);
		//System.out.println("Debug: " +(int)( anzahl1 + anzahl2 + anzahl3 + anzahl4 + anzahl5 + anzahl6));
	}

}
