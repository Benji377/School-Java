package net.tfobz.ratenrechner;


public class RatenRechner {
	private double laufzeitInJahren;
	private int ratenProJahr;
	private double jahreszinssatz;
	private double barwert;
	private double rate;
	private boolean nachschuessig;
	
	/**
	 * @return the ratenProJahr
	 */
	public int getRatenProJahr() {
		return ratenProJahr;
	}

	/**
	 * @param ratenProJahr the ratenProJahr to set
	 */
	public void setRatenProJahr(String ratenProJahr) {
		switch(ratenProJahr) {
		case "1 Rate":
			this.ratenProJahr = 1;
			break;
		case "4 Raten":
			this.ratenProJahr = 4;
			break;
		case "6 Raten":
			this.ratenProJahr = 6;
			break;
		case "12 Raten":
			this.ratenProJahr = 12;
		}
	}


	/**
	 * @param jahreszinssatz the jahreszinssatz to set
	 * @throws RatenRechnerException 
	 */
	public void setJahreszinssatz(String jahreszinssatz) throws RatenRechnerException {
		try {
			Double j = Double.valueOf(jahreszinssatz);
			if (j > 0)
				this.jahreszinssatz = j;
			else
				throw new RatenRechnerException("Jahreszinssatz falsch gesetzt");
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("Jahreszinssatz falsch gesetzt");
		}
	}


	/**
	 * @return the nachschuessig
	 */
	public boolean isNachschuessig() {
		return nachschuessig;
	}


	/**
	 * @param nachschuessig the nachschuessig to set
	 */
	public void setNachschuessig(boolean nachschuessig) {
		this.nachschuessig = nachschuessig;
	}


	/**
	 * @param barwert the barwert to set
	 */
	public void setBarwert(String barwert) throws RatenRechnerException{
		try {
			Double b = Double.valueOf(barwert);
			if (b > 0)
				this.barwert = b;
			else
				throw new RatenRechnerException("Kein  gültiger  Gleitkommawert");
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("Kein  gültiger  Gleitkommawert");
		}
	}
	
	public String getBarwert() throws RatenRechnerException {
		try {
			final double n = laufzeitInJahren * ratenProJahr;
			final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
			if (nachschuessig)
				barwert = rate * (Math.pow(q, n) - 1.) / (Math.pow(q, n) * (q - 1.));
			else
				barwert = rate * (Math.pow(q, n)- 1.) / (Math.pow(q, n - 1.) * (q - 1.));
			return String.valueOf(barwert);
		} catch (NullPointerException e) {
			throw new RatenRechnerException("Jahreszinssatz,  Laufzeit,  Raten  pro  Jahr oder Rate nicht gesetzt");
		}
	}

	
	/**
	 * @param laufzeitInJahren the laufzeitInJahren to set
	 * @throws RatenRechnerException 
	 */
	public void setLaufzeitInJahren(double laufzeitInJahren) throws RatenRechnerException {
		try {
			Double l = Double.valueOf(laufzeitInJahren);
			if (l > 0)
				this.laufzeitInJahren = l;
			else
				throw new RatenRechnerException("Jahreszinssatz falsch gesetzt");
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("Jahreszinssatz falsch gesetzt");
		}
	}
	
	public String getLaufzeitInJahren() throws RatenRechnerException {
		final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
		
		if (nachschuessig)
			laufzeitInJahren = (-Math.log((rate - barwert * (q - 1.)) / rate)
					/ Math.log(q)) / ratenProJahr;
		else
			laufzeitInJahren = (1. - Math.log((q * rate - barwert * (q - 1.)) / rate)
					/ Math.log(q)) / ratenProJahr;
		return String.valueOf(laufzeitInJahren);
	}

	/**
	 * @param rate the rate to set
	 * @throws RatenRechnerException 
	 */
	public void setRate(double rate) throws RatenRechnerException {
		try {
			Double r = Double.valueOf(rate);
			if (r > 0)
				this.rate = rate;
			else
				throw new RatenRechnerException("Jahreszinssatz falsch gesetzt");
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("Jahreszinssatz falsch gesetzt");
		}
	}
	
	public String getRate() throws RatenRechnerException {
		final double n = laufzeitInJahren * ratenProJahr;
		final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
		if (nachschuessig)
			rate = barwert * (Math.pow(q, n) * (q - 1.)) / (Math.pow(q, n) - 1.);
		else
			rate = barwert * (Math.pow(q, n - 1.) * (q - 1.)) / (Math.pow(q, n) - 1.);
		return String.valueOf(rate);
	}


	public String getTilgungsplan() throws RatenRechnerException {
		String ret = null;
		try {
			ret = "<!DOCTYPE html>\r\n" + 
					"<html lang=\"de\">\r\n" + 
					"  <head>\r\n" + 
					"    <meta charset=\"utf-8\">\r\n" + 
					"    <title></title>\r\n" + 
					"  </head>\r\n" + 
					"  <body>\r\n" + 
					"    <h1>T I L G U N G S P L A N</h1>\r\n" + 
					"    <table border=\"1\">\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Zahlungsart:</td>\r\n" + 
					"        <td>" +(nachschuessig ? "Nachschuessig" : "Vorschüssig")+"</td>\r\n" + 
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Barwert:</td>\r\n" + 
					"        <td>"+barwert+"</td>\r\n" + 
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Jahreszinssatz:</td>\r\n" + 
					"        <td>"+jahreszinssatz+"</td>\r\n" + 
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Laufzeit in Jahren:</td>\r\n" + 
					"        <td>"+laufzeitInJahren+"</td>\r\n" + 
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Rückzahlungsart:</td>\r\n" + 
					"        <td>"+ratenProJahr+" Raten im Jahr</td>\r\n" + 
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Rate:</td>\r\n" + 
					"        <td><b>"+rate+"</b></td>\r\n" + 
					"      </tr>\r\n" + 
					"    </table>\r\n" + 
					"    <hr>\r\n" + 
					"    <table border=\"1\">\r\n" + 
					"      <tr>\r\n" + 
					"        <th>Periode</th>\r\n" + 
					"        <th>Rate</th>\r\n" + 
					"        <th>Restkapital</th>\r\n" + 
					"        <th>Zinsen</th>\r\n" + 
					"      </tr>\r\n";
			
			final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
			double restkapital = barwert;
			for (int i = 1; i <= (int)(laufzeitInJahren*ratenProJahr); ++i) {
				final double zinsen;
				if (nachschuessig) {
					zinsen = restkapital * (q - 1.);
					restkapital = restkapital * q - rate;
				} else {
					zinsen = (restkapital - rate) * (q - 1.);
					restkapital = restkapital - rate + zinsen;
				}
				ret += "      <!--FOR-Schleife-->\r\n" + 
						"      <tr>\r\n" + 
						"        <td>"+i+"</td>\r\n" + 
						"        <td>"+rate+"</td>\r\n" + 
						"        <td>"+restkapital+"</td>\r\n" + 
						"        <td>"+zinsen+"</td>\r\n" + 
						"      </tr>\r\n";
			}
			
			ret += "    </table>\r\n" + 
					"  </body>\r\n" + 
					"</html>";
			
			return ret;
		} catch (NullPointerException e) {
			throw new RatenRechnerException("Führen  Sie  zuerst  die  Ratenberechnung  durch");
		}		
	}
}
