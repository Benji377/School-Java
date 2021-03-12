/**
 * Programm um die Klasse Kreis zu testen
 * @author Benjamin
 */
public class KreisProgramm {

	public static void main(String[] args) {
		// Erstellt ein Kreisobjekt
		Kreis k1 = new Kreis();
		double f = 3;
		// Setzt die Fläche des Kreis k1
		k1.setFlaeche(f);
		// Erstellt ein zweites Kreisobjekt
		Kreis k2 = new Kreis();
		// Der zweite Kreis übernimmt die Eigenschaften des ersten
		k2 = k1.clone();
		// Die Eigenschaften der beiden Kreise wird ausgegeben
		System.out.println(k1.toString());
		System.out.println(k2.toString());
		//Die zwei Kreise werden verglichen ob sie gleich sind
		System.out.println("k1.equals(k2) ergibt " + k1.equals(k2));
		// Der Umfang und Radius des zweiten Kreises wird geändert
		k2.setUmfang(-1);
		k2.setRadius(1);
		// Der Kreis wird verglichen um zu sehen ob er größer, kleiner oder gleich ist
		System.out.println("k1.compareTo(k2) ergibt " + k1.compareTo(k2));
		// Die Eigenschaften der beiden Kreise wird verglichen
		System.out.println(k1.toString());
		System.out.println(k2.toString());

	}

}
