
public class Zinsenzinsen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Titel wird ausgegeben
		System.out.println("Zinsenzinsen");
	    System.out.println("===========");
	    // Werte werden eingegeben
	    double anfangskapital = readDouble("Geben Sie das Anfangskapital ein: ");
	    double zinssatz = readDouble("Geben Sie den Zinssatz ein ");
	    int jahre = readInt("Geben Sie die jahre ein: ");
	    // Endkapital wird berechnet
	    int endkapital = (int) Math.round(anfangskapital * Math.pow((1 + zinssatz/100), jahre));
	    System.out.println();
	    // Jahre und Endkapital werden ausgegeben
	    System.out.println("Das Endkapital nach "+jahre+" Jahren beträgt "+endkapital);

	}
	public static int readInt(String text) {
	    System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}
	public static double readDouble(String text) {
		System.out.print(text);
		return (new java.util.Scanner(System.in)).nextDouble();
	}

}
