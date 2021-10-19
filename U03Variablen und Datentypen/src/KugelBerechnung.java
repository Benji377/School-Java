
public class KugelBerechnung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Kugelberechnung");
	    System.out.println("===========");
	    // Liest den eingegebenen Wert
	    double radius = readDouble ("Geben Sie den Radius der Kugel ein: ");
	    // Berechnet den Umfang
	    double umfang = 2*radius*Math.PI;
	    // Berechnet die Oberfläche
	    double oberflaeche = 4*Math.PI*(radius*radius);
	    // Berechnet das Volumen
	    double volumen = (4/3)*Math.PI*(radius*radius*radius);
	    System.out.println("Der Umfang der Kugel beträgt: " +umfang);
	    System.out.println("Die Oberfläche der Kugel beträgt: " +oberflaeche);
	    System.out.println("Das Volumen der Kugel beträgt: " +volumen);

	}
	public static double readDouble(String text) {
		System.out.print(text);
		return (new java.util.Scanner(System.in)).nextDouble();
	}

}
