package net.tfobz.ausdrueckeerw;

public class Logarithmus extends ArgOperation {

	public Logarithmus(Operand operand, Argument argument) {
		super(operand, argument);
	}
	
	public Logarithmus() {
		super();
	}
	
	public double getErgebnis() {
		double ret = 0.0;
		if (this.getOperand() != null && this.getArgument() != null) {
			ret = Math.log(this.getOperand().getErgebnis()) / Math.log(this.getArgument().getErgebnis());
			//ret = Math.round(ret);
		}
		return ret;
	}
	
	public String toString() {
		String ret = null;
		ret = "(Log(" + this.getArgument() + "," + this.getOperand()+ "=" + this.getErgebnis() + "))";
		return ret;	
	}
}
