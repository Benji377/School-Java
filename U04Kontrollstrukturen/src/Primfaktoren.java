
public class Primfaktoren {

	public static void main(String[] args) {
		System.out.println("Primfaktorzerlegung");
		System.out.println("===================");
		boolean aktiv = true;
		while (aktiv) {
			int n = readInt("Geben Sie die zahl ein: ");
			System.out.print(1);
			int aus = n;
			int teiler = 2;
			if (n > 1) {
				while (n > 1) {
					if (n%teiler == 0) {
						n = n/teiler;
						System.out.print(" * " + teiler);
						
					} else {
						teiler++;
					}
					if (n <= 1) {
						break;
					}
					// System.out.print("* ");
				}
				System.out.print(" = " + aus);
				aktiv = false;
			} else {
				System.out.println("Zahl muss größer als 1 sein");
				continue;
			}
		}

	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}