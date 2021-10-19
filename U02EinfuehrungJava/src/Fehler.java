// Das Wort "class" hat gefehlt und die Klammer muss auf die gleiche Zeile stehen
public class Fehler {
	// Das Wort "static" hat gefehlt
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int summe = 0;
		int n = 10;
		int j = n/3;
		int i = 0;
		// i war nicht deklariert
		while (i <= n) {
			//Semicolon hat gefehlt
			summe += i;
			i += j;
		}
		//Zeile befand sich außerhalb der Klammern
		System.out.println(summe);

	}

}
