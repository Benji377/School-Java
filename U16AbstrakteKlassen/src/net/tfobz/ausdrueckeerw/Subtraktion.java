package net.tfobz.ausdrueckeerw;

public class Subtraktion extends Operation
{
	public Subtraktion(Operand operand0, Operand operand1) {
		super(operand0, operand1);
	}
	public Subtraktion() {
		super();
	}
	public double getErgebnis() {
		double ret = 0.0;
		if (this.getOperand(0) != null)
			ret = this.getOperand(0).getErgebnis();
		if (this.getOperand(1) != null)
			ret = ret - this.getOperand(1).getErgebnis();
		return ret;
	}
	public String toString() {
		String ret = null;
		ret = "(" + this.getOperand(0) + "-" + this.getOperand(1) + "=" + this.getErgebnis() + ")";
		return ret;	
	}

}
