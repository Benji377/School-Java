package net.tfobz.ausdrueckeerw;

public class Argument extends Konstante {

	public Argument(double ergebnis) {
		super(ergebnis);
	}
	
	public Argument() {
		super();
	}
	
	public void setErgebnis(double ergebnis) {
		int erg = (int) ergebnis;
		if (erg < 0)
			erg = erg * -1;
		super.setErgebnis(erg);
	}
}
