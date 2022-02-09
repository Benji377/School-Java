package net.tfobz.ausdrueckeerw;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MeinDefaultTreeCellRenderer extends DefaultTreeCellRenderer {

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
			Component comp = null;
			comp = super.getTreeCellRendererComponent(tree, value, selected, expanded,
					leaf, row, hasFocus);
			JLabel ret = (JLabel) comp;
			
			if (leaf)
				ret.setIcon(new ImageIcon("./icons/konstante.gif"));
			else if (value.getClass() == Addition.class)
				ret.setIcon(new ImageIcon("./icons/addition.gif"));
			else if (value.getClass() == Subtraktion.class)
				ret.setIcon(new ImageIcon("./icons/subtraktion.gif"));
			else if (value.getClass() == Division.class)
				ret.setIcon(new ImageIcon("./icons/division.gif"));
			else if (value.getClass() == Multiplikation.class)
				ret.setIcon(new ImageIcon("./icons/multiplikation.gif"));
			
			return ret;
	}
}
