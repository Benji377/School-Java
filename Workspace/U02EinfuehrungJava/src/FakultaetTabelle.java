
public class FakultaetTabelle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		int n = 1;
		int fakul = 1;
		System.out.println("       n      n!");
		System.out.println("================");
		
		while (n <= 10) {
			while (a <= n) {
				fakul *= a;
				a += 1;
			}
			printZahl(n);
			printZahl(fakul);
			System.out.println();
			n += 1;
		}

	}
	/**
	* Gibt die ihr �bergebene Zahl rechtsb�ndig auf vier Stellen aus. So wird
	* beispielsweise die Zahl 5 folgenderma�en ausgegeben: ...5 w�hrend die
	* Zahl 100 so ausgegeben wird .100
	* @param zahl die auszugebende Zahl
	*/
	public static void printZahl(int zahl) {
		if (zahl < 10)
			System.out.print("       " + zahl);
		else
			if (zahl < 100)
				System.out.print("      " + zahl);
			else
				if (zahl < 1000)
					System.out.print("     " + zahl);
				else
					if (zahl < 10000)
						System.out.print("    " + zahl);
					else
						if (zahl < 100000)
							System.out.print("   " + zahl);
						else
							if (zahl < 1000000)
								System.out.print("  " + zahl);
							else
								System.out.print(" " + zahl);
	}

}
