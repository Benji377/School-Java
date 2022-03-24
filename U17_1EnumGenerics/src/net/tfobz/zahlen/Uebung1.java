package net.tfobz.zahlen;

import java.util.Hashtable;

public class Uebung1 {
	
	public static void rechne(Object... args) {
		double summe = 0;
		double zwischensumme = 0;
		String ausgabe = "";
		
		// Filtert die Objekte der Parameter nach Typ
		for (Object o : args) {
			if (o instanceof String) {
				// Strings bedeuten das Ende der Zwischensumme
				ausgabe += o + ": " + zwischensumme + "\n";
				zwischensumme = 0;
			} else {
				// Bei andere Zahlen (Integer, Double, Float, ...)
				summe += Double.parseDouble(o.toString());
				zwischensumme += Double.parseDouble(o.toString());
			}
		}
		System.out.print(ausgabe);
		System.out.println("Gesamtsumme: " + summe);
	}
	
	public static void zaehlezahlen(int... i) {
		// Hastable beinhaltet Zahlen -> Anzahl
		Hashtable<Integer, Integer> ht = new Hashtable<>();
		// Wenn eine Zahl bereits als Key im Hashtable existiert wird es addiert,
		// ansonsten neu angelegt
		for (int j : i) {
			if (ht.containsKey(j)) {
				ht.put(j, ht.get(j)+1);
			} else {
				ht.put(j, 1);
			}
		}
		System.out.println(ht.toString());
	}

	public static void main(String[] args) {
		rechne(1.45,0.79,19.9,"Ware",-3.0,1.5,"Pfand",-10,"Gutschein");
		zaehlezahlen(6, 43542, 3, 2, 4, 0, 1, 8, 1, 4);
	}

}
