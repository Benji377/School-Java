package net.tfobz.kontoverwaltung;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Gehaltskonto extends Konto {
	
	protected static double startueberziehung = -5;
	protected double ueberziehung;
	
	/**
	 * Konstruktor, welcher beim Anlegen des Gehaltskontos den �berziehungsrahmen automatisch vergibt. 
	 * Beim Anlegen des Gehaltskontos wird automatisch der �berziehungsrahmen, 
	 * welcher durch setStartueberziehung gesetzt wurde, f�r das Gehaltskonto eingestellt 
	 */
	public Gehaltskonto() {
		this.startueberziehung = Gehaltskonto.startueberziehung;
	}

	/**
	 * @return the startueberziehung
	 */
	public static double getStartueberziehung() {
		return startueberziehung;
	}

	/**
	 * @param startueberziehung the startueberziehung to set
	 * @throws KontoException 
	 */
	public static void setStartueberziehung(double startueberziehung) throws KontoException {
		if (startueberziehung > 0) {
			throw new KontoException("Start�berziehung darf nicht gr��er als 0 sein");
		} else {
			Gehaltskonto.startueberziehung = startueberziehung;
		}
	}

	/**
	 * @return the ueberziehung
	 */
	public double getUeberziehung() {
		return ueberziehung;
	}

	/**
	 * @param ueberziehung the ueberziehung to set
	 * @throws KontoException 
	 */
	public void setUeberziehung(double ueberziehung) throws KontoException {
		if (ueberziehung > 0)
			throw new KontoException("�berziehung darf nicht gr��er als 0 sein.");
		this.ueberziehung = ueberziehung;
	}

	@Override
	public double getZinsen() {
		double ret = 0;
		if (getKontostand() > 0) {
			// Erstelt ein Kalender
			Calendar calOne = Calendar.getInstance();
			// Erh�lt das heutige Datum und Jahr
			int dayOfYear = calOne.get(Calendar.DAY_OF_YEAR);
		    int year = calOne.get(Calendar.YEAR);
		    System.out.println("Current Year: "+year);
		    Calendar calTwo = new GregorianCalendar(year, 11, 31);
		    int day = calTwo.get(Calendar.DAY_OF_YEAR);
		    System.out.println("Days in current year: "+day);
		    int total_days = day - dayOfYear;
		    System.out.println("Total " + total_days + " days remaining in "+year);
		    // Mathematische Formel
		    ret = (getKontostand() * getZinssatz() * total_days) / (100 * day);
		}
		return ret;
	}

	@Override
	public double getSpesen() {
		double ret = 0;
		if (getKontostand() < 0)
			ret = 50;
		return ret;
	}

	@Override
	public void buchen(double betrag) throws KontoException {
		if (betrag < getUeberziehung()) {
			this.kontostand = getKontostand() + betrag;
		} else {
			throw new KontoException("Man kann nur Betr�ge innerhalb der �berziehung buchen");
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + " �berziehung: " + getUeberziehung();
	}
}
