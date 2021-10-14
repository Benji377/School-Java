// Programm für das Video!
// Wurde bereits diskutiert

public class Auto {
	int anzahlReifen;
	double leistung;
	String marke;
	
	public static double getPS(double leistung) {
		double ret = leistung;
		ret = ret*1.36;
		return ret;
	}

	public static void main(String[] args) {
		Auto panda = new Auto();
		panda.leistung = 51;
		
		Auto ferrari = new Auto();
		ferrari.leistung = 221;
		
		System.out.println("Panda: " + getPS(panda.leistung) + "\n" +
						   "Ferrari: " + getPS(ferrari.leistung));
	}

}
