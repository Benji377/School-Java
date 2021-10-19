
public class Pragmatik {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Gleich +1 addiert
		int n = 11;
		// Gleich +4 addiert
		int i = 1;
		// In der Schleife +4 und +1 entfernt weil bereits addiert
		while (i < n) {
			// Hier +4 entfernt weil bereits oben addiert
			System.out.println(i); 
			// i = i+2 zusammengefasst
			i += 2;
		}

	}

}
