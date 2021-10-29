package net.tfobz.ratenrechner;

/**
 * Diese Klasse beinhaltet alle Rechenoperationen die nötig sind um
 * verschieden Ratenrechnungen durchzuführen.
 * Diese Funktionen werden dann von der GUI in Anspruch genommen,
 * deswegen wird auch alles in String ausgegeben
 * @author Benji
 */
public class RatenRechner {
	private double laufzeitInJahren;
	private int ratenProJahr;
	private double jahreszinssatz;
	private double barwert;
	private double rate;
	private boolean nachschuessig;
	
	/**
	 * @return die Raten pro Jahr als Integer
	 */
	public int getRatenProJahr() {
		return ratenProJahr;
	}

	/**
	 * @param ratenProJahr Die Raten Pro Jahr, dabei gibt es aber nur:
	 * - 1 Rate,
	 * - 4 Raten
	 * - 6 Raten,
	 * - 12 Raten
	 * Nur diese Moglichkeiten werden von der GUI übergeben
	 */
	public void setRatenProJahr(String ratenProJahr) {
		// Die Strings werden dann in Integer umgewandelt und abgespeichert
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
			break;
		}
	}

	/**
	 * @param jahreszinssatz Der zu setztende Jahreszinssatz, wobei es sich dabei maximal
	 * um ein Double handeln kann und größer als 0 sein muss
	 * @throws RatenRechnerException wenn die oben genannte Bedingung nicht erfüllt wurde
	 */
	public void setJahreszinssatz(String jahreszinssatz) throws RatenRechnerException {
		try {
			// Konvertiert den String zu einem Double
			Double j = Double.valueOf(jahreszinssatz);
			if (j > 0)
				this.jahreszinssatz = j;
			else
				throw new RatenRechnerException("Kein  gültiger  Gleitkommawert");
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("Kein  gültiger  Gleitkommawert");
		}
	}

	/**
	 * @return true wenn es Nachscüssig ist, ansonsten false für Vorschüssig
	 */
	public boolean isNachschuessig() {
		return nachschuessig;
	}

	/**
	 * @param nachschuessig Ein Boolean um zu setzen ob es Nachschüssig ist oder nicht
	 */
	public void setNachschuessig(boolean nachschuessig) {
		this.nachschuessig = nachschuessig;
	}

	/**
	 * @param barwert Der zu setzende Barwert, wobei es sich dabei maximal
	 * um ein Double handeln kann und größer als 0 sein muss
	 * @throws RatenRechnerException wenn die oben genannte Bedingung nicht erfüllt wurde
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
	
	/**
	 * Funktion um den Barwert mittels den Jahreszinssatz, die Laufzeit, die Raten pro Jahr und die Raten
	 * zu berechnen
	 * @return den ausgerechneten und auf zwei Stellen gerundete Barwert
	 * @throws RatenRechnerException wenn einer der benötigten Rechenkomponente fehlt
	 */
	public String getBarwert() throws RatenRechnerException {
		try {
			// Formel zum Berechnen des Barwert
			final double n = laufzeitInJahren * ratenProJahr;
			final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
			// Je ob nachschuessig oder vorschüssig müssen wir was wegzählen oder nicht
			if (nachschuessig)
				barwert = rate * (Math.pow(q, n) - 1.) / (Math.pow(q, n) * (q - 1.));
			else
				barwert = rate * (Math.pow(q, n)- 1.) / (Math.pow(q, n - 1.) * (q - 1.));
			// Rundet den Wert auf zwei Stellen und gibt es als String zurück
			barwert = Math.round(barwert * 100.0)/100.0;
			return String.valueOf(barwert);
		} catch (NullPointerException e) {
			throw new RatenRechnerException("Jahreszinssatz,  Laufzeit,  Raten  pro  Jahr oder Rate nicht gesetzt");
		}
	}
	
	/**
	 * @param laufzeitInJahren Die zu setzende Laufzeit, wobei es sich dabei maximal
	 * um ein Double handeln kann und größer als 0 sein muss
	 * @throws RatenRechnerException wenn die oben genannte Bedingung nicht erfüllt wurde
	 */
	public void setLaufzeitInJahren(String laufzeitenJahren) throws RatenRechnerException {
		try {
			Double laufzeit = Double.valueOf(laufzeitenJahren);
			if (laufzeit > 0)
				this.laufzeitInJahren = laufzeit;
			else
				throw new RatenRechnerException("Kein  gültiger  Gleitkommawert");
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("Kein  gültiger  Gleitkommawert");
		}
	}
	
	/**
	 * Funktion zum Ausrechnen der Laufzeit in Jahren
	 * @return die Laufzeit, aufgerundet auf zwei Kommastellen
	 * @throws RatenRechnerException wenn einer oder mehrere Rechenkomponte fehlt
	 */
	public String getLaufzeitInJahren() throws RatenRechnerException {
		// Formel zum ausrechnen der Laufzeit
		final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
		
		// Je nachdem ob es um vorschuss oder nachschuss handelt
		// wird eine andere Funktion angewendet
		if (nachschuessig)
			laufzeitInJahren = (-Math.log((rate - barwert * (q - 1.)) / rate)
					/ Math.log(q)) / ratenProJahr;
		else
			laufzeitInJahren = (1. - Math.log((q * rate - barwert * (q - 1.)) / rate)
					/ Math.log(q)) / ratenProJahr;
		
		// Laufzeit wird auf zwei Stellen gerundet und als String zurückgegeben
		laufzeitInJahren = Math.round(laufzeitInJahren * 100.0)/100.0;
		return String.valueOf(laufzeitInJahren);
	}

	/**
	 * @param rate Die zu setzende Rate, wobei es sich dabei maximal
	 * um ein Double handeln kann und größer als 0 sein muss
	 * @throws RatenRechnerException wenn die oben genannte Bedingung nicht erfüllt wurde
	 */
	public void setRate(String rate) throws RatenRechnerException {
		try {
			Double r = Double.valueOf(rate);
			if (r > 0)
				this.rate = r;
			else
				throw new RatenRechnerException("Kein  gültiger  Gleitkommawert");
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("Kein  gültiger  Gleitkommawert");
		}
	}
	
	/**
	 * Funktion zum Ausrechnen der Rate mithilfe einer Formel
	 * @return die Rate, auf zwei Kommastellen gerundet
	 * @throws RatenRechnerException wenn einer oder mehrere Rechenkomponente fehlen
	 */
	public String getRate() throws RatenRechnerException {
		// Mittels einer Formel wird die Rate auserechnet
		final double n = laufzeitInJahren * ratenProJahr;
		final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
		
		// Je nach Nachschuss oder Vorschuss wird verschieden potenziert
		if (nachschuessig)
			rate = barwert * (Math.pow(q, n) * (q - 1.)) / (Math.pow(q, n) - 1.);
		else
			rate = barwert * (Math.pow(q, n - 1.) * (q - 1.)) / (Math.pow(q, n) - 1.);
		
		// Am Ende wird der Wert auf zwei Stellen gerundet und als String ausgegeben
		rate = Math.round(rate * 100.0)/100.0;
		return String.valueOf(rate);
	}

	/**
	 * Funktion zum bilden eines HTML-String dass den Tilgplan ausgibt. Der Tilgplan kann somit
	 * als Tabelle auf ein JEditorPane angezeigt werden
	 * @return Ein String dass das gesamte HTML enthält
	 * @throws RatenRechnerException wenn die Ratenrechnung noch nocht durchgeführt wurde
	 */
	public String getTilgungsplan() throws RatenRechnerException {
		// Um sicher zu gehen dass alle Komponente gesetzt wurden, wird es gleich am Anfang kontrolliert
		if (getBarwert() == null || jahreszinssatz == 0 || getLaufzeitInJahren() == null || getRatenProJahr() == 0 || getRate() == null)
			throw new RatenRechnerException("Führen  Sie  zuerst  die  Ratenberechnung  durch");
		String ret = null;
		
		// Dies ist der Anfang des HTML, es enthält alle Konstanten und zeigt diese als Tabelle aus
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
				// Mittels diesem Operator könne wir alles bequem in einer Zeile schreiben
				// Es ermittelt ob es Nachschuessig ist oder nicht und setzt es nachdem
				"        <td>" +(nachschuessig ? "Nachschuessig" : "Vorschüssig")+"</td>\r\n" + 
				"      </tr>\r\n" + 
				"      <tr>\r\n" + 
				"        <td>Barwert:</td>\r\n" + 
				"        <td>"+getBarwert()+"</td>\r\n" + 
				"      </tr>\r\n" + 
				"      <tr>\r\n" + 
				"        <td>Jahreszinssatz:</td>\r\n" + 
				"        <td>"+jahreszinssatz+"%</td>\r\n" + 
				"      </tr>\r\n" + 
				"      <tr>\r\n" + 
				"        <td>Laufzeit in Jahren:</td>\r\n" + 
				"        <td>"+getLaufzeitInJahren()+"</td>\r\n" + 
				"      </tr>\r\n" + 
				"      <tr>\r\n" + 
				"        <td>Rückzahlungsart:</td>\r\n" + 
				"        <td>"+getRatenProJahr()+" Raten im Jahr</td>\r\n" + 
				"      </tr>\r\n" + 
				"      <tr>\r\n" + 
				"        <td>Rate:</td>\r\n" + 
				"        <td><b>"+getRate()+"</b></td>\r\n" + 
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
		// Nun werden die Werte für jede Periode ausgerechnet und in der Tabelle eingetragen
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
					"        <td>"+getRate()+"</td>\r\n" + 
					"        <td>"+(Math.round(restkapital*100.0)/100.0)+"</td>\r\n" + 
					"        <td>"+(Math.round(zinsen*100.0)/100.0)+"</td>\r\n" + 
					"      </tr>\r\n";
		}
		// Zu guter letzt wird das HTML abgeschlossen und alles in ein String gepackt
		ret += "    </table>\r\n" + 
				"  </body>\r\n" + 
				"</html>";
		// Der String wird dann zurückgegeben
		return ret;	
	}
}
