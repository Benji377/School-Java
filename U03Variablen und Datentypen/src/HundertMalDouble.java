
public class HundertMalDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double summe = 0;
		int n = 1;
		while (n <= 100) {
			summe += 0.1;
			n++;
		}
		System.out.println(summe);

	}

}
// Die Summe ist nicht genau 10 weil nach einigen Durchläufen es nicht mehr genau 0.1 addiert wird
// sondern weniger.
