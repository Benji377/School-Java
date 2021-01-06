
public class Zahlenraten {

	public static void main(String[] args) {
		System.out.println("Zahlenraten");
		System.out.println("===========");
		
		boolean aktiv = true;
		int zufall = (int)(Math.random() * 1000);
		System.out.println("Ich habe mir eine Zahl im Intervall [0,1000] ausgedacht."
				+ " Versuchen Sie diese zu erraten");
		
		// Schleife nimmt die Eingabe des Benutzers und vergleicht es mit der Zufallszahl
		while (aktiv) {
			int benutzer = readInt("Ihr Tipp: ");
			if (benutzer > zufall) {
				System.out.println("Ihre Zahl ist zu groﬂ");
				continue;
			}
			if (benutzer < zufall) {
				System.out.println("Ihre Zahl ist zu klein");
				continue;
			}
			if (benutzer == zufall) {
				System.out.println("Mein Kompliment! Sie haben die Zahl gefunden");
				aktiv = false;
			}
		}
	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}
