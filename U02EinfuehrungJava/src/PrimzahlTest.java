
public class PrimzahlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int z = Integer.parseInt(args[0]);
		 // a zählt wie oft die eingegebenen Zahl geteilt werden kann
		 int a = 0;
		 // b ist die Zahl mit der die eingegebene Zahl dividiert wird
		 int b = 1;
		 
		 // Solange b kleiner ist als die eingegebenen Zahl wird geschaut ob die zahl durch b teilbar ist
		 while (b <= z) {
			 if (z%b == 0) {
				 // Wenn die zahl teilbar ist wird sie als Teileranzahl der Variable dazugezählt
				 a += 1;
			 }
			 b += 1;
		 }
		 // Eine Primzahl hat nur zwei Teiler: 1 und sich selbst, wenn es mehr sind ist es keine Primzahl
		 if (a == 2) {
			 System.out.println("Die Zahl ist eine Primzahl");
		 } else {
			 System.out.println("Die zahl ist keine Primzahl");
		 }
	}

}
