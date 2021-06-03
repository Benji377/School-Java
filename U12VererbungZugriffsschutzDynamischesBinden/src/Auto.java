
public class Auto extends Fahrzeug {
	protected int ps = 0;
	
	public Auto(int ps) {
		setPs(ps);
	}
	
	public void setPs(int ps) {
		if (ps > 0)
			this.ps = ps;
		else
			this.ps = 0;
	}
	
	public int getPs() {
		return this.ps;
	}
}
