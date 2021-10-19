
public class SchleifenAbbruch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double n = 10;
		double i = 0;
		while (i != n) {
			i += 0.1;
		}

	}

}
// Diese Schleife bricht nie ab da double ungenau ist und deswegen i nie gleich n sein wird
