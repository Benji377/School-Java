package net.tfobz.ausdrueckeerw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

class TreePopup extends JPopupMenu {
	JMenu neu;
	JMenuItem loschen;
	JMenuItem vertausch;
	JMenuItem konst;
	JMenuItem addi;
	JMenuItem subtra;
	JMenuItem divis;
	JMenuItem multi;
	
	public TreePopup(JTree tree) {
		neu = new JMenu("Neu");
		loschen = new JMenuItem("Löschen");
		vertausch = new JMenuItem("Vertauschen");
		
		loschen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
				if (tree.getSelectionPath() != null) {
					MutableTreeNode treeNode = ((MutableTreeNode)tree.getSelectionPath().getLastPathComponent());
					if (treeNode instanceof Konstante) {
						MutableTreeNode parent = ((MutableTreeNode)tree.getSelectionPath().getParentPath().getLastPathComponent());
						System.out.println("Classe: " + treeNode.getClass());
						System.out.println("Classss: " + parent.getClass());
						if (parent instanceof Operation) {
							((Operation) parent).loescheOperand(parent.getIndex(treeNode));
						} else {
							DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode)treeModel.getRoot());
							wurzel.removeAllChildren();
						}
					} else if (treeNode instanceof  Operation){
						System.out.println(treeNode.getParent().getClass());
						treeModel.removeNodeFromParent(treeNode);
					}
						TreePath treePath = tree.getSelectionPath();
						treeModel.reload();
						// Damit wird ausgewählter Knoten aufgeklappt
						tree.expandPath(treePath);
				}
			}
		});
		vertausch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
				if (tree.getSelectionPath() != null) {
					MutableTreeNode treeNode = ((MutableTreeNode)tree.getSelectionPath().getLastPathComponent());
					if (treeNode instanceof Operation) {
						((Operation) treeNode).vertausche();
						TreePath treePath = tree.getSelectionPath();
						treeModel.reload();
						// Damit wird ausgewählter Knoten aufgeklappt
						tree.expandPath(treePath);
					}
				}
			}
		});
		
		konst = new JMenuItem("Konstante");
		addi = new JMenuItem("Addition");
		subtra = new JMenuItem("Subtraktion");
		divis = new JMenuItem("Division");
		multi = new JMenuItem("Multiplikation");
		
		konst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
				if (tree.getSelectionPath() == null) {
					// Hänge neuen Knoten zur Wurzel
					DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode)treeModel.getRoot());
					if (wurzel.getChildCount() == 0) {
						treeModel.insertNodeInto(new Konstante(),wurzel,0);
						// Muss gemacht werden, ansonsten wird neuer Knoten nicht angezeigt
						treeModel.reload();
					}
				} else {
					// Hänge neuen Knoten zum ausgewählten Knoten
					MutableTreeNode treeNode = ((MutableTreeNode)tree.getSelectionPath().getLastPathComponent());
					if (treeNode instanceof Operation && ((Operation)treeNode).getChildCount()<2) {
						treeModel.insertNodeInto(new Konstante(),treeNode,0);
						TreePath treePath = tree.getSelectionPath();
						treeModel.reload();
						// Damit wird ausgewählter Knoten aufgeklappt
						tree.expandPath(treePath);
					}
				}
			}
		});
		addi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
				if (tree.getSelectionPath() == null) {
					// Hänge neuen Knoten zur Wurzel
					DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode)treeModel.getRoot());
					if (wurzel.getChildCount() == 0) {
						treeModel.insertNodeInto(new Addition(),wurzel,0);
						// Muss gemacht werden, ansonsten wird neuer Knoten nicht angezeigt
						treeModel.reload();
					}
				} else {
					// Hänge neuen Knoten zum ausgewählten Knoten
					MutableTreeNode treeNode = ((MutableTreeNode)tree.getSelectionPath().getLastPathComponent());
					System.out.println(treeNode.getChildCount());
					if (treeNode instanceof Operation && ((Operation)treeNode).getChildCount()<2) {
						treeModel.insertNodeInto(new Addition(),treeNode,0);
						TreePath treePath = tree.getSelectionPath();
						treeModel.reload();
						// Damit wird ausgewählter Knoten aufgeklappt
						tree.expandPath(treePath);
					}
				}
			}
		});
		subtra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
				if (tree.getSelectionPath() == null) {
					// Hänge neuen Knoten zur Wurzel
					DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode)treeModel.getRoot());
					if (wurzel.getChildCount() == 0) {
						treeModel.insertNodeInto(new Subtraktion(),wurzel,0);
						// Muss gemacht werden, ansonsten wird neuer Knoten nicht angezeigt
						treeModel.reload();
					}
				} else {
					// Hänge neuen Knoten zum ausgewählten Knoten
					MutableTreeNode treeNode = ((MutableTreeNode)tree.getSelectionPath().getLastPathComponent());
					if (treeNode instanceof Operation && ((Operation)treeNode).getChildCount()<2) {
						treeModel.insertNodeInto(new Subtraktion(),treeNode,0);
						TreePath treePath = tree.getSelectionPath();
						treeModel.reload();
						// Damit wird ausgewählter Knoten aufgeklappt
						tree.expandPath(treePath);
					}
				}
			}
		});
		divis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
				if (tree.getSelectionPath() == null) {
					// Hänge neuen Knoten zur Wurzel
					DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode)treeModel.getRoot());
					if (wurzel.getChildCount() == 0) {
						treeModel.insertNodeInto(new Division(),wurzel,0);
						// Muss gemacht werden, ansonsten wird neuer Knoten nicht angezeigt
						treeModel.reload();
					}
				} else {
					// Hänge neuen Knoten zum ausgewählten Knoten
					MutableTreeNode treeNode = ((MutableTreeNode)tree.getSelectionPath().getLastPathComponent());
					if (treeNode instanceof Operation && ((Operation)treeNode).getChildCount()<2) {
						treeModel.insertNodeInto(new Division(),treeNode,0);
						TreePath treePath = tree.getSelectionPath();
						treeModel.reload();
						// Damit wird ausgewählter Knoten aufgeklappt
						tree.expandPath(treePath);
					}
				}
			}
		});
		multi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
				if (tree.getSelectionPath() == null) {
					// Hänge neuen Knoten zur Wurzel
					DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode)treeModel.getRoot());
					if (wurzel.getChildCount() == 0) {
						treeModel.insertNodeInto(new Multiplikation(),wurzel,0);
						// Muss gemacht werden, ansonsten wird neuer Knoten nicht angezeigt
						treeModel.reload();
					}
				} else {
					// Hänge neuen Knoten zum ausgewählten Knoten
					MutableTreeNode treeNode = ((MutableTreeNode)tree.getSelectionPath().getLastPathComponent());
					if (treeNode instanceof Operation && ((Operation)treeNode).getChildCount()<2) {
						treeModel.insertNodeInto(new Multiplikation(),treeNode,0);
						TreePath treePath = tree.getSelectionPath();
						treeModel.reload();
						// Damit wird ausgewählter Knoten aufgeklappt
						tree.expandPath(treePath);
					}
				}
			}
		});
		
		neu.add(konst);
		neu.add(addi);
		neu.add(subtra);
		neu.add(divis);
		neu.add(multi);
		add(neu);
		add(loschen);
		add(vertausch);
	}
}
