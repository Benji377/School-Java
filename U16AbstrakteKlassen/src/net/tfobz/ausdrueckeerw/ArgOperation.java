package net.tfobz.ausdrueckeerw;

public abstract class ArgOperation extends Operand {
	
	private Argument argument = null;
	private Operand operand = null;
	
	public ArgOperation(Operand operand, Argument argument) {
		this.setOperand(operand);
		this.setArgument(argument);
	}
	public ArgOperation() {
		super();
	}
	
	public void setOperand(Operand operand) {
		if (this.operand == null)
			this.operand = operand;
	}
	
	public void setArgument(Argument argument) {
		if (this.argument == null)
			this.argument = argument;
	}
	
	public Operand getOperand() {
		return this.operand;
	}
	
	public Argument getArgument() {
		return this.argument;
	}
	
	public void loescheOperand() {
		this.operand = null;
	}
	
	public void loescheArgument() {
		this.argument = null;
	}
}
