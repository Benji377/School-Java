package net.tfobz.tage;

public class Testklasse {

	public static void main(String[] args) {
		Arbeitstage a1 = new Arbeitstage();
		a1.remove(Wochentag.SONNTAG);
		System.out.println(a1);
		System.out.println(a1.getWochenart());
		Arbeitstage a2 = new Arbeitstage(Wochentag.MONTAG, Wochentag.FREITAG);
		System.out.println(a2);
		System.out.println(a2.getWochenart());
		Arbeitstage a3 = new Arbeitstage(Wochentag.MONTAG, Wochentag.SAMSTAG);
		System.out.println(a3);
		System.out.println(a3.getWochenart());
		
		ArbeitstageBeliebtheit b1 = new ArbeitstageBeliebtheit();
		System.out.println(b1);
		ArbeitstageBeliebtheit b2 = new ArbeitstageBeliebtheit(a2,Beliebtheit.MITTEL);
		System.out.println(b2);
		ArbeitstageBeliebtheit b3 = new ArbeitstageBeliebtheit(a3,Beliebtheit.MITTEL);
		b3.put(Wochentag.SAMSTAG,Beliebtheit.KLEIN);
		System.out.println(b3);
	}
}
