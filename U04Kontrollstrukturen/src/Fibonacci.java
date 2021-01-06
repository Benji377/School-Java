
public class Fibonacci {

	public static void main(String[] args) {
		boolean aktiv = true;
		int n = 1;
		int fibozahl1 = 0;
		int fibozahl2 = 1;
		int ergebnis = 0;
		System.out.println("Fibonacci-Zahlen");
		System.out.println("================");
		while (aktiv) {
			int zahl = readInt("Die wievielte Zahl? ");
			if (zahl >= 0 && zahl != 1) {
				while (n < zahl) {
					ergebnis = fibozahl1 + fibozahl2;
					fibozahl1 = fibozahl2;
					fibozahl2 = ergebnis;
					n++;
				}
				System.out.println("Die " + zahl + ". Fibonacci-Zahl lautet " + ergebnis);
				aktiv = false;
			} else if (zahl == 1) {
				System.out.println("Die " + zahl + ". Fibonacci-Zahl lautet " + (ergebnis+1));
				aktiv = false;
			} else {
				System.out.println("Die Zahl muss größer oder gleich Null sein");
				continue;
			}
		}

	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}
