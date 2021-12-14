
package net.tfobz.lernkartei.frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.*;
import net.tfobz.lernkartei.backend.*;

public class Einstellungen extends JFrame {
	private JLabel titel1;
	private JLabel titel2;
	private ImageIcon iimport;
	private ImageIcon iexport;
	private JButton bimport;
	private JButton bexport;
	private JButton menu;
	private JComboBox<String> isprache;
	private JComboBox<String> esprache;
	private JCheckBox check;
	private JFileChooser chooser;
	private File file;
	private JPanel panel;
	private JScrollPane scroll;
	private List<Lernkartei> sprachen;
	private JLabel[] lsprache;
	private JButton[] bsprache;

	// Beinhaltet alle Einstellungen zur App (Import, Export, Erinnerung, ...)
	public Einstellungen(JFrame owner) {
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Wird an der gleichen Position wie der Besitzer ausgegeben
		this.setBounds(owner.getX(),owner.getY(),500,500);
		this.setTitle("Vokabeltrainer: Einstellungen");
		this.setResizable(false);
		
		// Setzt den Pfad zu den Icons
		iimport = new ImageIcon("./images/import.png");
		iexport = new ImageIcon("./images/export.png");

		// Ermöglicht s zum Menü zurückzukehren
		menu = new JButton("Zum Menü");
		menu.setBounds(10, 12, 104, 27);
		menu.setFont(new Font("Balsamiq Sans",Font.PLAIN,13));
		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Damit die Position immer übereinstimmt, wird die aktuelle Position dem owner übergeben
				// Somit erscheint dieser in der gleichen Position und erschafft eine elegante Transaktion
				owner.setLocation(getX(), getY());
				Hauptmenu a = new Hauptmenu();
				a.setVisible(true);
				// Dieser Fesnter wird nicht mehr gebraucht und kann deswegen frei gelegt werden
				dispose();
			}
		});

		titel1 = new JLabel("Import - Export");
		titel1.setFont(new Font("Balsamiq Sans",Font.PLAIN,32));
		titel1.setBounds(140,8,216,36);

		// Ermöglicht es Karten zu importieren
		bimport = new JButton("Import");
		bimport.setFont(new Font("Balsamiq Sans",Font.PLAIN,20));
		bimport.setHorizontalAlignment(SwingConstants.LEFT);
		bimport.setBounds(27,85,115,30);
		bimport.setIcon(iimport);
		bimport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Versucht Karten über ein festgelegten Pfad zu importieren
				try {
					int nummer = sprachen.get(isprache.getSelectedIndex()-1).getNummer();
					if(nummer != 0) {
						// Gibt dem Benutzer die Möglichkeit die Datei auszuwählen von der die Karten eingelsen werden
						chooser = new JFileChooser();
						chooser.showOpenDialog(Einstellungen.this);
						// Danach kümmert sich das backend um den Import
						file = chooser.getSelectedFile();
						VokabeltrainerDB.importierenKarten(nummer, file.getAbsolutePath());
					} else {
						throw new InputMismatchException("Sie sollen eine Sprache aussuchen");
					}
				}catch(InputMismatchException e1) {
					JOptionPane.showMessageDialog(Einstellungen.this, e1.getMessage(), "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// Beinhaltet eine Liste aller Lernkarteien (Sprachen)
		sprachen = new ArrayList<Lernkartei>();
		sprachen = VokabeltrainerDB.getLernkarteien();
		
		// Präsentiert eine Liste an möglichen Sprachen zu denen man etwas importieren kann
		isprache = new JComboBox<String>();
		isprache.setBounds(212,85,156,30);
		isprache.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		isprache.setEditable(false);
		isprache.addItem("Sprache");
		// Für jede Sprache im Array soll diese dem Combobox hinzugefügt werden
		for(int i = 0;sprachen.size()>i;i++) {
			isprache.addItem(sprachen.get(i).getWortEinsBeschreibung()+" - "+sprachen.get(i).getWortZweiBeschreibung());
		}
		// Knopf um Karten und Fächer zu exportieren
		bexport = new JButton("Export");
		bexport.setFont(new Font("Balsamiq Sans",Font.PLAIN,20));
		bexport.setHorizontalAlignment(SwingConstants.LEFT);
		bexport.setBounds(27,137,115,30);
		bexport.setIcon(iexport);
		bexport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Versucht Karten zu exportieren
				try {
					int nummer = sprachen.get(esprache.getSelectedIndex()-1).getNummer();
					if(nummer != 0) {
						// Öffnet wiederum ein Fenster um den Zielort des Exports festzulegen
						chooser = new JFileChooser();
						chooser.showSaveDialog(Einstellungen.this);
						VokabeltrainerDB.exportierenKarten(nummer, chooser.getSelectedFile().getAbsolutePath(),check.isSelected());	
					} else {
						throw new InputMismatchException("Sie sollen eine Sprache aussuchen");
					}
				} catch(InputMismatchException e1) {
					JOptionPane.showMessageDialog(Einstellungen.this, e1.getMessage(), "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// Enthält eine Liste an möglichen Sprachen zum export
		esprache = new JComboBox<String>();
		esprache.setBounds(212,137,156,30);
		esprache.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		esprache.setEditable(false);
		esprache.addItem("Sprache");
		
		for(int i = 0;sprachen.size()>i;i++) {
			esprache.addItem(sprachen.get(i).getWortEinsBeschreibung()+" - "+sprachen.get(i).getWortZweiBeschreibung());
		}
		
		// Ermöglicht dem Benutzer den Export mit oder ohne Fächer durchzuführen
		check = new JCheckBox();
		check.setBounds(384, 137, 100, 30);
		check.setText("Mit Fächer");
		check.setFont(new Font("Balsamiq Sans",Font.PLAIN,16));

		// Stellt lediglich eine Linie dar, die nur estetische Zwecke erfüllt
		JSeparator s = new JSeparator();
		s.setBounds(0, 198, 500, 2);

		titel2 = new JLabel("Erinnerungsdatum");
		titel2.setFont(new Font("Balsamiq Sans",Font.PLAIN,32));
		titel2.setBounds(116,208,268,36);

		// Stellt eine Liste von Lernkarteien dar, jede mit einem  Knopf daneben um ihren Erinnerungsintervall zu ändern
		// Praktisch eine Liste auf ein JPanel in ein ScrollPane
		int size = sprachen.size();
		panel = new JPanel();
		panel.setLayout(new GridLayout(size,2));
		scroll = new JScrollPane(panel);
		scroll.setBounds(27,264,441,170);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		lsprache = new JLabel[size];
		bsprache = new JButton[size];
		int hohe = 266;
		
		// Legt dynamisch Elemente im JPanel fest
		for(int i = 0;i<size;i++) {
			Lernkartei l = sprachen.get(i);
			lsprache[i] = new JLabel(" "+l.getWortEinsBeschreibung()+" - "+l.getWortZweiBeschreibung());
			lsprache[i].setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
			lsprache[i].setBounds(27,hohe+34,290,25);

			bsprache[i] = new JButton("Datum einstellen");
			bsprache[i].setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
			bsprache[i].setBounds(317,hohe+34,130,25);
			final int x = sprachen.get(i).getNummer();
			bsprache[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// Beim klicken auf dem Knopf wird ein neues Dialog aufgemacht dass es lediglich ermöglicht 
					// Fächer in der Lernkartei zu bearbeiten
					Fachliste f = new Fachliste(Einstellungen.this,x);
					f.setVisible(true);
					setVisible(false);
				}
			});
			panel.add(lsprache[i]);
			panel.add(bsprache[i]);
			hohe+=34;
		}
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(menu);
		c.add(titel1);
		c.add(bimport);
		c.add(bexport);
		c.add(s);
		c.add(titel2);
		c.add(esprache);
		c.add(isprache);
		c.add(check);
		c.add(scroll);
	}
}