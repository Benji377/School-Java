
public class DreieckEigenschaften {

	public static void main(String[] args) {
		System.out.println("Eigenschaften eines Dreiecks");
		System.out.println("============================");
		
		// Allgemeine Variablen werden deklariert
		int versuch = 0;
		double umfang = 0;
		double heron = 0;
		double flache = 0;
		double hypothenuse = 0;
		
		// Werden für das ermitteln des rechtwinklige Dreieck benutzt
		double recht_a = 0;
		double recht_b = 0;
		
		// Unendliche Schleife
		while (versuch == 0) {
			
			// Eingabe aller Seiten
			double seite_a = readDouble("Seite a: ");
			double seite_b = readDouble("Seite b: ");
			double seite_c = readDouble("Seite c: ");
			
			// Ermittelt ob das Dreieck möglich ist
			if (seite_a + seite_b > seite_c && seite_a + seite_c > seite_b && seite_b + seite_c > seite_a) {
				
				// Berechnet Umfang und Fläche
				umfang = seite_a + seite_b + seite_c;
				heron = umfang/2;
				flache = Math.sqrt(heron * (heron - seite_a) * (heron - seite_b) * (heron - seite_c));
				
				// Ermittelt die Hypothenuse
				if (seite_a > seite_b && seite_a > seite_c) {
					hypothenuse = seite_a;
					recht_a = seite_b;
					recht_b = seite_c;
				} else if (seite_b > seite_a && seite_b > seite_c){
					hypothenuse = seite_b;
					recht_a = seite_c;
					recht_b = seite_a;
				} else {
					hypothenuse = seite_c;
					recht_a = seite_a;
					recht_b = seite_b;
				}
				
				System.out.println();
				System.out.println("Umfang: " + umfang);
				System.out.println("Fläche: " + flache);
				
				
				// Ermittelt ob es gleichseitig ist
				if (seite_a == seite_b && seite_b == seite_c) {
					System.out.println("Gleichseitige Dreieck");
				
				// Ermittelt ob es gleichschenklig ist
				} else if (seite_a == seite_b && seite_a == seite_c || seite_b == seite_a && seite_b == seite_c || seite_c == seite_b && seite_c == seite_a) {
					System.out.println("Gleichschenklige Dreieck");
				
				// Ermittelt ob es ein rechtwinklig ist
				} else if (Math.pow(hypothenuse, 2) == Math.pow(recht_a, 2) + Math.pow(recht_b, 2)) {
					
					// Ermittelt ob es pythagorisch ist
					if (seite_a%(int)seite_a == 0 && seite_b%(int)seite_b == 0 && seite_c%(int)seite_c == 0) {
						System.out.println("Pythagoreische Dreieck");
					} else {
						System.out.println("Rechtwinkliges Dreieck");
					}
					System.out.println("Hypothenuse: " + hypothenuse);
				}
				
			} else {
				System.out.println("Unmögliches Dreieck");
			}
			System.out.println();		
			versuch = (int)readDouble("Nochmal (0), Beenden (1): ");
			System.out.println();
		}
	}
	  public static double readDouble(String text) {
		    System.out.print(text);
		    return (new java.util.Scanner(System.in)).nextDouble();
		  }

}
