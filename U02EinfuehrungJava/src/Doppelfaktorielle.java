
public class Doppelfaktorielle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		// Übung 11 ersetzt "int n = 10"
		int n = Integer.parseInt(args[0]);
		int ergebnis = 1;
		
		if (n%2<=0) {
			// Wenn die Zahl gerade ist muss von 2 beginnen
			a += 1;
			while (a <= n) {
				ergebnis *= a;
				// Bei Doppelfaktorielle wird a um 2 erhöht
				a += 2;
			}
		} else {
			// Wenn die Zahl ungerade ist startet die Zahl von 1
			while (a <= n) {
				ergebnis *= a;
				a += 2;
			}
		}
		// Das Ergebnis wird ausgegeben
		System.out.println(ergebnis);

	}

}

/**
 * a ist der Wert mit dem das ergebnis multipliziert wird.
 * n ist die vom Benutzer gewählte Zahl und soll doppelfakultiert werden
 */