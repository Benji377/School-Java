
public class NullStellenSuche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 4;
		int b = -7;
		int c = 3;
		
		double x1 = (-b + Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a);
		double x2 = (-b - Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a);
		
		System.out.println("Die erste Nullstelle ist: "+x1+ 
				"\nDie zweite Nullstelle ist: "+x2);

	}

}
