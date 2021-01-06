
public class Fakultaet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		int n = 6;
		int fakultaet = 1;
		
		while (a <= n) {
			fakultaet *= a;
			a += 1;
		}
		System.out.println("Die Fakultaet von "+n+ " ist "+fakultaet);

	}

}
/**
 * Das Program nimmt n als Eingabe und schaut wie groß die Fakultät ist.
 * Solange a kleiner gleich n ist wird die variable fakultät mit a multipliziert
 * und danach wird a um 1 vergrößert. Am Ende der Schleife wird die Fakultät von n ausgegeben
 */