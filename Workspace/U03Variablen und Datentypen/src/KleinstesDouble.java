
public class KleinstesDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double minidouble = 1;
		// Schau ob minidouble größer als 0 ist
		while (minidouble > 0) {
			// minidouble soll nicht null werden
			if (minidouble / 2 == 0) {
				System.out.println(minidouble);
				// break unterbricht die Schleife
				break;
			} else {
				minidouble /= 2;
			}
			
		}
		
	}

}
