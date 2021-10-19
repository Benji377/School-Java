
public class Teiler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Eingabe einer Zahl z
		 int z = Integer.parseInt(args[0]);
		 // n speichert die Teiler
		 int n = 1;
		 
		 while (n <= z) {
			 // Wenn das Teilen von z durch n kein Rest gibt ist es einer der Teiler
			 if (z%n == 0) {
				 // Ausgabe der Teiler
				 System.out.print(n + ", ");
			 }
			 // Inkrementierung der varaible außerhalb des if statement
			 n += 1;
		 }

	}

}

// Das Program sucht alle Teiler einer eingegebenen Zahl und gibt diese aus