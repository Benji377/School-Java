
public class PrimzahlenTabelle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int zahl = 90;
		int n = 120;
		System.out.println("Primzahlentabelle" + "\n" + "==================");
		while (zahl <= n) {
			printZahl(zahl);
			istPrimzahl(zahl);
			zahl = zahl + 1;	
		}
		

	}
	public static void printZahl(int zahl) {
		if (zahl < 100) 
			System.out.print("  " + zahl);
		else
			System.out.print(" " + zahl);	
	}
	public static void istPrimzahl(int z) {
		int a = 0;
		int b = 1;
		while (b <= z) {
			if (z%b == 0) {
				a += 1;
			}
			b += 1;
		}
		if (a == 2) {
			System.out.println(" ist Primzahl");
		} else {
			System.out.println(" ist nicht Primzahl");
		}
	}

}
