package net.tfobz.brueche;

public class BruchTestprogramm {

	public static void main(String args[]) {
		try {
			// Erstelt neue Brüche
			Bruch a = new Bruch(10, 7);
			Bruch b = new Bruch(20, 10);
			
			System.out.println("Bruch a: "+a.toString());
			System.out.println("Bruch b: "+b.toString());
			// Zwischenspeichern des Bruches a um Änderungen rückgängig zu machen
			Bruch c = a.clone();
			System.out.println(a.toString()+" = "+b.toString()+": "+a.equals(b));
			a.addiere(b);
			System.out.println(c.toString()+" + "+b.toString()+" = "+a.toString());
			a = c.clone();
			a.subtrahiere(b);
			System.out.println(c.toString()+" - "+b.toString()+" = "+a.toString());
			a = c.clone();
			a.multipliziere(b);
			System.out.println(c.toString()+" * "+b.toString()+" = "+a.toString());
			a = c.clone();
			a.dividiere(b);
			System.out.println(c.toString()+" / "+b.toString()+" = "+a.toString());
		} catch (BruchException e) {
			e.printStackTrace();
		}
	}
}