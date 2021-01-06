
public class Quersumme {

	public static void main(String[] args) {
		System.out.println("Quersumme\n=========");
		int ganzzahl = readInt("Geben Sie die Zahl ein: ");
		System.out.println("");
		System.out.println("Die Quersumme lautet:");
		int ganzzahlaus = 0;
		int quersumme = 0;
		int reversezahl = 0;
		
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
		

	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}
