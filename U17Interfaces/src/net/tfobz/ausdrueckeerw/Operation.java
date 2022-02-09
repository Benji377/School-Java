package net.tfobz.ausdrueckeerw;

import java.util.Enumeration;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * Achtung: Die Operanden werden immer der Reihe nach in die Operation gehängt. Mit
 * setOperand kann man beim ersten Aufruf den ersten Operanden füllen, ruft man
 * setOperand nochmals auf, so wird der zweite Operand gefüllt. Beim Löschen werden 
 * die Operanden unter Umständen nach vorne verschoben.
 * @author Michael Wild
 */
public abstract class Operation extends Operand
{
	private Operand[] operand = new Operand[2];
	private MutableTreeNode parent = null;
	
	public Operation(Operand operand0, Operand operand1) {
		this.setOperand(operand0);
		this.setOperand(operand1);
	}
	public Operation() {
		super();
	}
	public void setOperand(Operand operand) {
		if (this.operand[0] == null)
			this.operand[0] = operand;
		else
			if (this.operand[1] == null)
				this.operand[1] = operand;
	}
	public Operand getOperand(int position) {
		if (position >= 0 && position <= 1)
			return this.operand[position];
		else
			return null;
	}
	public void vertausche() {
		if (this.operand[0] != null && this.operand[1] != null) {
			Operand operand = this.operand[0];
			this.operand[0] = this.operand[1];
			this.operand[1] = operand;
		}
	}
	public void loescheOperand(int position) {
		if (position == 0) {
			this.operand[0] = this.operand[1];
			this.operand[1] = null;
		} else if (position == 1)
				this.operand[1] = null;
	}
	
	@Override
	public TreeNode getChildAt(int childIndex) {
		return this.getOperand(childIndex);
	}
	@Override
	public int getChildCount() {
		int count = 0;
		if (this.getOperand(0) != null)
			count++;
		if (this.getOperand(1) != null)
			count++;
		return count;
	}
	@Override
	public TreeNode getParent() {
		return parent;
	}
	@Override
	public int getIndex(TreeNode node) {
		int ret = 0;
		if (node.equals(this.getOperand(1)))
			ret = 1;
		return ret;
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
		this.setOperand(((Operand)child));
		child.setParent(this);
	}
	@Override
	public void remove(int index) {
		this.loescheOperand(index);
	}
	@Override
	public void remove(MutableTreeNode node) {
		
	}
	@Override
	public void setUserObject(Object object) {
	}
	@Override
	public void removeFromParent() {
		this.setParent(null);
	}
	@Override
	public void setParent(MutableTreeNode newParent) {
		this.parent = newParent;
	}
}
