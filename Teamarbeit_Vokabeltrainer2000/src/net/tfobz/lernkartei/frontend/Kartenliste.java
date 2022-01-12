package net.tfobz.lernkartei.frontend;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.junit.experimental.theories.ParameterSignature;

import net.tfobz.lernkartei.backend.Fach;
import net.tfobz.lernkartei.backend.Karte;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;

public class Kartenliste extends JFrame{
	private JButton back;
	private JButton delete;
	private JButton add;
	private JButton edit;
	private JLabel title;
	private JScrollPane scrollPane;
	private JPanel kartencontent;
	private JRadioButton[] karten;
	private JSpinner spinn;
	private JLabel spinninfo;
	private ButtonGroup radioGroup;
	private List<Karte> kartenListe;
	
	// Stellt eine Liste an alle Karten in der Lernkartei dar, noch genauer aber für jedes Fach in der Lernkartei
	public Kartenliste(JFrame owner, int nummerLernkartei) {
		this.setTitle("Kartenliste");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), 500, 500);
		this.setResizable(false);
		
		// Ermöglicht es zum Hauptmenü zurückzukehren
		back = new JButton("Zurück");
		back.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		back.setBounds(10, 10, 80, 27);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Macht den überrangigen Fenster sichtbar
				owner.setLocation(getX(), getY());
				owner.setVisible(true);
				dispose();
			}
		});
		// Funktion um die ausgewählte Karten zu bearbeiten
		ImageIcon icob = new ImageIcon("./images/edit.png");
		edit = new JButton();
		edit.setIcon(icob);
		edit.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		edit.setBounds(385, 10, 45, 45);
		edit.setToolTipText("Wähle eine Karte aus um sie zu bearbeiten");
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean contro = true;
				// Credits: https://stackoverflow.com/a/13232816
				// Sucht aus der Liste an Knöpfe nur das ausgewählte RadioButton aus
				for (Enumeration<AbstractButton> buttons = radioGroup.getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();
					
					if (button.isSelected()) {
						contro = false;
						// Aus dem Text der Karte wird die Nummer also der Index geholt
						String stext = button.getText().replaceAll("(\\d+).+", "$1");
						// Damit wird die Karte in der Liste gefunden
						Karte kk = VokabeltrainerDB.getKarte(Integer.parseInt(stext));
						// Dann öffnet sich ein Fenster wo der Nutzer die Karte bearbeiten kann
						KartenBearbeiten kb = new KartenBearbeiten(Kartenliste.this, kk);
						kb.setVisible(true);
					}
				}
				if (contro) {
					JOptionPane.showMessageDialog(Kartenliste.this, "Sie müssen zuerst eine Karte auswählen");
				} else {
					// Lädt den JFrame neu
					reloadContent();
				}
			}
		});
		// Funktion um eine ausgewählte Karte zu löschen
		ImageIcon icom = new ImageIcon("./images/trash.png");
		delete = new JButton();
		delete.setIcon(icom);
		delete.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		delete.setBounds(439, 10, 45, 45);
		delete.setToolTipText("Wähle eine Karte aus um sie zu löschen");
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Um zu kontrollieren ob ein RadioButton ausgewählt wurde
				boolean contro = true;
				// Gleich wie beim Bearbeiten einer Karte
				for (Enumeration<AbstractButton> buttons = radioGroup.getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();
					
					if (button.isSelected()) {
						contro = false;
						String stext = button.getText().replaceAll("(\\d+).+", "$1");
						Karte kk = VokabeltrainerDB.getKarte(Integer.parseInt(stext));
						// Es wird ein Dialog zum Bestätigung der Aktion ausgerufen
						int ans = JOptionPane.showConfirmDialog(Kartenliste.this, "Wollen Sie wirklich diese Karte löschen? \n "
								+ "Dies kann nicht rückgängig gemacht werden");
						// Nur wenn der Nutzer auf "Ja" Klickt wird die Karte gelöscht
						if (ans == JOptionPane.YES_OPTION) {
							VokabeltrainerDB.loeschenKarte(kk.getNummer());
						}
					}
				}
				// Dies bedeutet es wurde kein Knopf ausgewählt
				if (contro) {
					JOptionPane.showMessageDialog(Kartenliste.this, "Sie müssen zuerst eine Karte auswählen");
				} else {
					reloadContent();
				}
			}
		});
		// Funktion um eine neue Karte einzufügen
		ImageIcon icon = new ImageIcon("./images/add.png");
		add = new JButton();
		add.setIcon(icon);
		add.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		add.setBounds(331, 10, 45, 45);
		add.setToolTipText("Füg dem ersten Fach eine Karte hinzu");
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Wir brauchen hier kein Index und können deswegen den Dialog gliech öffnen
				KartenAdder ka = new KartenAdder(Kartenliste.this, nummerLernkartei);
				ka.setVisible(true);
				reloadContent();
			}
		});
		
		title = new JLabel("Wählen Sie eine Karte aus");
		title.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(10, 80, 474, 32);
		
		// Ein Spinner um die Karten nach Fächer durchzugehen
		List<Fach> fachcount = VokabeltrainerDB.getFaecher(nummerLernkartei);
		
		// Modell: standard, minimu, maximum, step
		SpinnerModel model = new SpinnerNumberModel(fachcount.get(0).getNummer(), fachcount.get(0).getNummer(), fachcount.get(fachcount.size()-1).getNummer(), 1);
		spinn = new JSpinner(model);
		spinn.setBounds(82, 123, 46, 24);
		spinn.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		spinn.setToolTipText("Sortiere Karten bei Fächer");
		spinn.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// Da das neuladen des JFrames lange dauern könnte, wird der Spinner temporär deaktiviert
				spinn.setEnabled(false);
				reloadContent();
				spinn.setEnabled(true);
			}
		});
		
		spinninfo = new JLabel("Fach: ");
		spinninfo.setBounds(32, 120, 50, 24);
		spinninfo.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		
		// JPanel beinhaltet all dass, was auf dem scrollPane kommt
		kartencontent = new JPanel();
		kartencontent.setLayout(new BoxLayout(kartencontent, BoxLayout.Y_AXIS));
		scrollPane = new JScrollPane(kartencontent);
		scrollPane.setBounds(32, 150, 436, 320);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		reloadContent();
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(this.back);
		c.add(this.add);
		c.add(this.delete);
		c.add(this.edit);
		c.add(this.title);
		c.add(this.spinn);
		c.add(this.spinninfo);
		c.add(this.scrollPane);
	}
	// Methode um die Komponente auf dem JFrame neu aufzufüllen
	private void reloadContent() {
		// Zuerst werden die Behälter neu angelegt
		radioGroup = new ButtonGroup(); 		// Enthält alle Knöpfe
		kartencontent.removeAll();		// Enthält alles was man im scrollPane sieht
		// Karten werden neue aus dem databse geholt
		kartenListe = VokabeltrainerDB.getKarten((int) spinn.getValue());
		if (kartenListe != null) {
			// Es wird ein neuer Array an JRadioButtons erstellt
			karten = new JRadioButton[kartenListe.size()];
			// Die bUttons werden dann einzeln angelegt
			for (int i = 0; i < kartenListe.size(); i++) {
				Karte k = kartenListe.get(i);
				karten[i] = new JRadioButton(k.getNummer() + ". " + k.getWortEins() + " - " + k.getWortZwei());
				karten[i].setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
				karten[i].setSize(435, 28);
				// und ihren Behältern übergeben
				radioGroup.add(karten[i]);
				kartencontent.add(karten[i]);
			}
		}
		// Lädt den JFrame neu
		revalidate();
		repaint();
	}

}

