package net.tfobz.ausdrueckeerw;

import java.util.Enumeration;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

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
	
	@Override
	public TreeNode getChildAt(int childIndex) {
		if (childIndex == 0)
			return this.getOperand();
		else
			return this.getArgument();
	}
	@Override
	public int getChildCount() {
		int count = 0;
		if (this.getOperand() != null)
			count++;
		if (this.getArgument() != null)
			count++;
		return count;
	}
	@Override
	public TreeNode getParent() {
		return null;
	}
	@Override
	public int getIndex(TreeNode node) {
		return 0;
	}
	@Override
	public boolean getAllowsChildren() {
		return false;
	}
	@Override
	public boolean isLeaf() {
		return false;
	}
	@Override
	public Enumeration children() {
		return null;
	}

	@Override
	public void insert(MutableTreeNode child, int index) {
	}
	@Override
	public void remove(int index) {
	}
	@Override
	public void remove(MutableTreeNode node) {
	}
	@Override
	public void setUserObject(Object object) {
	}
	@Override
	public void removeFromParent() {
	}
	@Override
	public void setParent(MutableTreeNode newParent) {
	}
}
