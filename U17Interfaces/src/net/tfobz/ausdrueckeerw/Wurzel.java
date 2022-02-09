package net.tfobz.ausdrueckeerw;

public class Wurzel extends ArgOperation {

	public Wurzel(Operand operand, Argument argument) {
		super(operand, argument);
	}
	
	public Wurzel() {
		super();
	}
	
	public double getErgebnis() {
		double ret = 0.0;
		if (this.getOperand() != null && this.getArgument() != null) {
			ret = Math.pow(Math.E, (1/this.getArgument().getErgebnis()) * Math.log(this.getOperand().getErgebnis()));
			//ret = Math.round(ret);
		}
		return ret;
	}
	public String toString() {
		String ret = null;
		ret = "(Wurzel(" + this.getArgument() + "," + this.getOperand()+ "=" + this.getErgebnis() + "))";
		return ret;	
	}
	
}
