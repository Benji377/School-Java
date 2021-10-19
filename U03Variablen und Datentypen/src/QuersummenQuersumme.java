
public class QuersummenQuersumme {

	public static void main(String[] args) {
		System.out.println("Quersummenquersumme\n==============");
		int ganzzahl = readInt("Geben Sie die Zahl ein: ");
		System.out.println("");
		System.out.println("Die Quersummenquersumme lautet:");
		int ganzzahlaus = 0;
		int quersumme = 0;
		int reversezahl = 0;
		int quersummeaus = 0;
		
		// Die Schleife dreht die Zahl um
		while (ganzzahl != 0) {
			int ziffer = ganzzahl % 10;
			reversezahl = reversezahl * 10 + ziffer;
			ganzzahl /= 10;
		}
		
		// Schleife berechnet Querdurchschnitt
		do {
			quersumme += reversezahl % 10;
			ganzzahlaus = reversezahl;
			reversezahl /= 10;
			// Z. B. 12345 - 12340 = 5
			System.out.print(ganzzahlaus - reversezahl*10 + " ");
			
			if (reversezahl <= 0) {
				// Bricht ab ansonsten unnötiger "+" am Ende
				break;
			} 
			System.out.print("+ ");
			
		} while (reversezahl > 0);
		
		System.out.print("= " + quersumme);
		
		
		// Quersumme der Quersumme bilden
		if (quersumme >= 10) {
			System.out.print(" = ");
			int neuequersumme = 0;
			// Zahl wird wieder umgedreht; ganzzahl durch quersumme ersetzt
			while (quersumme != 0) {
				int ziffer = quersumme % 10;
				reversezahl = reversezahl * 10 + ziffer;
				quersumme /= 10;
		}
			do {
				neuequersumme += reversezahl % 10;
				quersummeaus = reversezahl;
				reversezahl /= 10;
				// Z. B. 12345 - 12340 = 5
				System.out.print(quersummeaus - reversezahl*10 + " ");
				
				if (reversezahl <= 0) {
					// Bricht ab ansonsten unnötiger "+" am Ende
					break;
				} 
				System.out.print("+ ");
				
			} while (reversezahl > 0);
			
			System.out.print("= " + neuequersumme);
		}
		

	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}
