
public class SchleifenUebersetzung {

	public static void main(String[] args) {
		System.out.println("Originale While-Schleife: ");
		double i = 3;
		while(i < 10) {
			i = i + 0.5;
			System.out.println(i);
		}
		System.out.println("");
		System.out.println("Übersetzte For-Schleife: ");
		for (double j = 3.5; j <= 10; j += 0.5) {
			System.out.println(j);
		}
		System.out.println("");
		System.out.println("Leere For-Schleife");
		double k = 3;
		for ( ; ; ) {
			if (k < 10) {
				k += 0.5;
				System.out.println(k);
			} else {
				break;
			}
		}

	}

}
