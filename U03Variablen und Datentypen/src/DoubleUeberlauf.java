
public class DoubleUeberlauf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Double.Max_Value gibt den Maximalwert eines double aus
		double testdouble = Double.MAX_VALUE;
		System.out.println(testdouble);
		int n = 1;
		while (n <= 1000000) {
			testdouble += 1E100;
			n++;
		}
		System.out.println(testdouble);
	}

}
