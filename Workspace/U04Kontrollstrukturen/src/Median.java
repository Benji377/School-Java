
public class Median {

	public static void main(String[] args) {
		System.out.println("Median \n ======");
		int zahl1 = readInt("1. Zahl: ");
		int zahl2 = readInt("2. Zahl: ");
		int zahl3 = readInt("3. Zahl: ");
		System.out.println();
		
		if ((zahl1 >= zahl2 && zahl1 <= zahl3) || (zahl1 <= zahl2 && zahl1 <= zahl3)) {
			if (zahl2 <= zahl3) {
				System.out.println("Der Median lautet " + zahl2);
			} else {
				System.out.println("Der Median lautet " + zahl3);
			}
			
		} else if ((zahl2 >= zahl1 && zahl2 <= zahl3) || (zahl2 <= zahl1 && zahl2 >= zahl3)) {
			if (zahl1 <= zahl3) {
				System.out.println("Der Median lautet " + zahl1);
			} else {
				System.out.println("Der Median lautet " + zahl3);
			}

		} else if ((zahl3 >= zahl1 && zahl3 <= zahl2) || (zahl3 <= zahl1 && zahl3 <= zahl2)) {
			if (zahl2 <= zahl1) {
				System.out.println("Der Median lautet " + zahl2);
			} else {
				System.out.println("Der Median lautet " + zahl1);
			}

		} else {
			System.out.println("Ungültige Zahl");
		}

	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}
