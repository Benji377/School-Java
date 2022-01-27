package net.tfobz.groesse;

public class Fussballfeld implements Groesse, Comparable<Groesse> {
	private long laenge = 0;
	private long breite = 0;
	private long hoehe = 0;
	
	public Fussballfeld() {
		this.laenge = 105_000;
		this.breite = 70_000;
		this.hoehe = 0;
	}
	
	public Fussballfeld(long l, long b, long h) {
		this.laenge = l;
		this.breite = b;
		this.hoehe = h;
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

	public void setLaenge(long laenge) {
		this.laenge = laenge;
	}

	public void setBreite(long breite) {
		this.breite = breite;
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
		return "Fussballfelder L = " + this.getLaenge() + " B = " + this.getBreite() + " H = " + this.getHoehe() + " G = " + this.getGrundflaeche();
	}
}
