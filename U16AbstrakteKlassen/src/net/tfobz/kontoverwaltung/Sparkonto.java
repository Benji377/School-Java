package net.tfobz.kontoverwaltung;

public class Sparkonto extends Konto {
	
	protected double sparrate;
	
	public Sparkonto(double ersteZahlung, double sparrate) throws KontoException {
		if (ersteZahlung > 0 && sparrate > 0) {
			this.buchen(ersteZahlung);
			this.sparrate = sparrate;
		} else {
			throw new KontoException("Weder die erste Zahlung, noch die Sparrate können 0 sein");
		}
	}
	
	/**
	 * @return the sparrate
	 */
	public double getSparrate() {
		return sparrate;
	}

	/**
	 * @param sparrate the sparrate to set
	 * @throws KontoException 
	 */
	public void setSparrate(double sparrate) throws KontoException {
		if (sparrate > 0)
			this.sparrate = sparrate;
		else
			throw new KontoException("Die Sparrate muss größer als 0 sein");
	}

	@Override
	public double getZinsen() {
		double ret = 0;
		ret = (getKontostand() * getZinssatz()) / 100;
		return ret;
	}

	@Override
	public double getSpesen() {
		double ret = 0;
		ret = getKontostand() * 0.1;
		return ret;
	}
	
	public void buchenSparrate() {
		try {
			this.buchen(this.sparrate);
		} catch (KontoException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void buchen(double betrag) throws KontoException {
		
		if (betrag < -3000) {
			if (this.kontostand + betrag != 0) {
				throw new KontoException("Wenn sie mehr als 3000 abbuchen möchten, müssen Sie das gesamte Konto abbuchen");
			} else {
				this.kontostand = 0;
			}
		} else {
			if (this.kontostand + betrag > 0) {
				this.kontostand += betrag;
			} else {
				throw new KontoException("Sparkonto kann keinen negativen Kontostand haben");
			}
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + " Sparrate: " + getSparrate();
	}

}
