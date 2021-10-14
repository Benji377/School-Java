
public class SatelllitenZeit {

	public static void main(String[] args) {
		System.out.println("Satellitenzeit \n" + "===============");
		int gesamtsekunden = readInt("Geben Sie die Sekunden ein: ");
		// Ist die Umwandlungszahl von Sekunden in Tage
		final double sekundentag = 1.1574074074074 * Math.pow(10, -5);
		
		double tage = gesamtsekunden * sekundentag;
		// double - int lässt nur noch die Zahlen nach dem Komma übrig
		double stunden = (tage - (int) tage) * 24;
		double minuten = (stunden - (int) stunden) * 60;
		// wird aufgerundet
		double sekunden = Math.round((minuten - (int) minuten) * 60);
		
		System.out.println("Die umgerechnete Zeit ist:");
		//Zahlen alle in Int ausgegeben
		System.out.println("d "+(int)tage+" h "+(int)stunden+" m "+(int)minuten+" s "+(int)sekunden);

	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

}
