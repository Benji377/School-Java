package net.tfobz.groesse;

public class Papierblatt implements Groesse, Comparable<Groesse> {
	private long laenge = 0;
	private long breite = 0;
	private long hoehe = 0;
	
	public Papierblatt(int format) {
		// Formate:
		// Länge Breite
		// A0 1189 mm 841 mm
		// A1 841 mm 594 mm
		// A2 594 mm 420 mm
		// A3 420 mm 297 mm
		// A4 297 mm 210 mm
		switch (format) {
		case 0:
			this.laenge = 1189;
			this.breite = 841;
			break;
		case 1:
			this.laenge = 841;
			this.breite = 594;
			break;
		case 2:
			this.laenge = 594;
			this.breite = 420;
			break;
		case 3:
			this.laenge = 420;
			this.breite = 297;
			break;
		case 4:
			this.laenge = 297;
			this.breite = 210;
			break;
		default:
			this.laenge = 0;
			this.breite = 0;
			break;
		}
	}

	@Override
	public long getLaenge() {
		return this.laenge;
	}

	@Override
	public long getBreite() {
		return this.breite;
	}

	@Override
	public long getHoehe() {
		return this.hoehe;
	}
	
	@Override
	public long getGrundflaeche() {
		return this.breite * this.laenge;
	}
	
	@Override
	public int compareTo(Groesse g) {
		int ret = 0;
		if (this.getGrundflaeche() > g.getGrundflaeche())
			ret = 1;
		else if (this.getGrundflaeche() < g.getGrundflaeche())
			ret = -1;
		return ret;
	}
	
	@Override
	public String toString() {
		return "Papierblatt L = " + this.getLaenge() + " B = " + this.getBreite() + " H = " + this.getHoehe() + " G = " + this.getGrundflaeche();
	}

}
