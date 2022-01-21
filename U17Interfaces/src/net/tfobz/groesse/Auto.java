package net.tfobz.groesse;

public class Auto implements Groesse {
	private long laenge = 0;
	private long breite = 0;
	private long hoehe = 0;

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

	public void setHoehe(long hoehe) {
		this.hoehe = hoehe;
	}
	
	public long getGrundflaeche() {
		return this.breite * this.laenge;
	}

}
