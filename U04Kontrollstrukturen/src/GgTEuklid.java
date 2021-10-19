
public class GgTEuklid {

	public static void main(String[] args) {
		System.out.println("GgT von Euklid \n ============");
		int zahl1 = readInt("Erste Zahl: ");
		int zahl2 = readInt("Zweite Zahl: ");
		System.out.println();
		
		if (zahl1 == 0) {
			System.out.println("Der größte gemeinsame Teiler lautet " + zahl2);
		} else {
			while (zahl2 != 0) {
				if (zahl1 > zahl2) {
					zahl1 -= zahl2;
				} else {
					zahl2 -= zahl1;
				}
			}
			System.out.println("Der größte gemeinsame Teiler lautet " + zahl1);
		}

	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}
