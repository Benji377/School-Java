package net.tfobz.groesse;

public interface Groesse {
	long getLaenge();
	long getBreite();
	long getHoehe();
	long getGrundflaeche();
	
	@Override
	String toString();
	
	int compareTo(Groesse g);
}
