package net.tfobz.ausdrueckeerw;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;

public class TreeGUI extends JFrame {
	JTree tree;

	public static void main(String[] args) {
		TreeGUI tg = new TreeGUI();
		tg.setVisible(true);
	}
	
	public TreeGUI() {
		this.setTitle("BaumOperand");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 400, 400);
		
		Operation oper = new Division(
				new Multiplikation(
						new Konstante(2.0), 
						new Addition(
								new Konstante(3.0), 
								new Konstante(4.0))
						),
				new Subtraktion(
						new Konstante(7.0),
						new Konstante(5.0)));

		
		DefaultMutableTreeNode mutablenode = new DefaultMutableTreeNode("Node");
		mutablenode.add(oper);
		TreeModel treeModel = new DefaultTreeModel(mutablenode);
		TreeCellRenderer meinRenderer = new MeinDefaultTreeCellRenderer();
		tree = new JTree(treeModel);
		tree.setCellRenderer(meinRenderer);
		tree.setEditable(true);
		tree.setRootVisible(false);
		
		TreePopup tpop = new TreePopup(tree);
		tree.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger()) {
					tpop.show(e.getComponent(), e.getX(), e.getY());
	            }
	         }
		});
		
		Container c = this.getContentPane();
		// Wir fügen ein Layout und ein Scrollpane hinzu
		// Scrollpane wird uns helfen, wenn der Baum zu groß für das Fenster wird
		// und das Layout hilft uns das Fenster ganz auszufüllen
		c.add(new JScrollPane(tree), BorderLayout.NORTH);
	}

}
