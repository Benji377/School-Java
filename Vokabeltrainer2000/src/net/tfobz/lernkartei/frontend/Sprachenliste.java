package net.tfobz.lernkartei.frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import javax.swing.*;
import net.tfobz.lernkartei.backend.Lernkartei;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;

public class Sprachenliste extends JFrame {
	private JButton back;
	private JButton delete;
	private JButton add;
	private JButton edit;
	private JLabel title;
	private JScrollPane scrollPane;
	private JPanel sprachencontent;
	private JRadioButton[] sprachen;
	private ButtonGroup radioGroup;
	private List<Lernkartei> sprachenListe;
	
	
	public Sprachenliste(JFrame owner) {
		this.setTitle("Kartenliste");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), 500, 500);
		this.setResizable(false);
		
		// Erm�glicht es zum Hauptmen� zur�ckzukehren
		back = new JButton("Zur�ck");
		back.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		back.setBounds(10, 10, 80, 27);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Macht den �berrangigen Fenster sichtbar
				owner.setLocation(getX(), getY());
				owner.setVisible(true);
				dispose();
			}
		});
		
		// Funktion um die ausgew�hlte Sprache zu bearbeiten
		ImageIcon icob = new ImageIcon("./images/edit.png");
		edit = new JButton();
		edit.setIcon(icob);
		edit.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		edit.setBounds(385, 10, 45, 45);
		edit.setToolTipText("W�hle eine Sprache aus um sie zu bearbeiten");
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean contro = true;
				// Credits: https://stackoverflow.com/a/13232816
				// Sucht aus der Liste an Kn�pfe nur das ausgew�hlte RadioButton aus
				for (Enumeration<AbstractButton> buttons = radioGroup.getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();
					
					if (button.isSelected()) {
						contro = false;
						// Aus dem Text der Sprache wird die Nummer also der Index geholt
						String stext = button.getText().replaceAll("(\\d+).+", "$1");
						// Damit wird die Karte in der Liste gefunden
						Lernkartei lk = sprachenListe.get(Integer.parseInt(stext)-1);
						// Dann �ffnet sich ein Fenster wo der Nutzer die Sprache bearbeiten kann
						SprachenBearbeiten sb = new SprachenBearbeiten(Sprachenliste.this, lk);
						sb.setVisible(true);
					}
				}
				if (contro) {
					JOptionPane.showMessageDialog(Sprachenliste.this, "Sie m�ssen zuerst eine Sprache ausw�hlen");
				} else {
					// L�dt den JFrame neu
					reloadContent();
				}
			}
		});
		// Funktion um eine ausgew�hlte Sprache zu l�schen
		ImageIcon icom = new ImageIcon("./images/trash.png");
		delete = new JButton();
		delete.setIcon(icom);
		delete.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		delete.setBounds(439, 10, 45, 45);
		delete.setToolTipText("W�hle eine Sprache aus um sie zu l�schen");
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Um zu kontrollieren ob ein RadioButton ausgew�hlt wurde
				boolean contro = true;
				// Gleich wie beim Bearbeiten einer Karte
				for (Enumeration<AbstractButton> buttons = radioGroup.getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();
					
					if (button.isSelected()) {
						contro = false;
						String stext = button.getText().replaceAll("(\\d+).+", "$1");
						Lernkartei lk = sprachenListe.get(Integer.parseInt(stext)-1);
						// Es wird ein Dialog zum Best�tigung der Aktion ausgerufen
						int ans = JOptionPane.showConfirmDialog(Sprachenliste.this, "Wollen Sie wirklich diese Sprache l�schen? \n "
								+ "Dies kann nicht r�ckg�ngig gemacht werden");
						// Nur wenn der Nutzer auf "Ja" Klickt wird die Karte gel�scht
						if (ans == JOptionPane.YES_OPTION) {
							VokabeltrainerDB.loeschenLernkartei(lk.getNummer());
						}
					}
				}
				// Dies bedeutet es wurde kein Knopf ausgew�hlt
				if (contro) {
					JOptionPane.showMessageDialog(Sprachenliste.this, "Sie m�ssen zuerst eine Sprache ausw�hlen");
				} else {
					reloadContent();
				}
			}
		});
		// Funktion um eine neue Karte einzuf�gen
		ImageIcon icon = new ImageIcon("./images/add.png");
		add = new JButton();
		add.setIcon(icon);
		add.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		add.setBounds(331, 10, 45, 45);
		add.setToolTipText("F�g eine neue Sprache ein");
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Wir brauchen hier kein Index und k�nnen deswegen den Dialog gliech �ffnen
				SprachenAdder sa = new SprachenAdder(Sprachenliste.this);
				sa.setVisible(true);
				reloadContent();
			}
		});
		
		title = new JLabel("W�hlen Sie eine Sprache aus");
		title.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(10, 80, 474, 32);
		
		// JPanel beinhaltet all dass, was auf dem scrollPane kommt
		sprachencontent = new JPanel();
		sprachencontent.setLayout(new BoxLayout(sprachencontent, BoxLayout.Y_AXIS));
		scrollPane = new JScrollPane(sprachencontent);
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
		c.add(this.scrollPane);
	}
	
	// Methode um die Komponente auf dem JFrame neu aufzuf�llen
	private void reloadContent() {
		// Zuerst werden die Beh�lter neu angelegt
		radioGroup = new ButtonGroup(); 		// Enth�lt alle Kn�pfe
		sprachencontent.removeAll();		// Enth�lt alles was man im scrollPane sieht
		// Karten werden neue aus dem databse geholt
		sprachenListe = VokabeltrainerDB.getLernkarteien();
		if (sprachenListe != null) {
			// Es wird ein neuer Array an JRadioButtons erstellt
			sprachen = new JRadioButton[sprachenListe.size()];
			// Die bUttons werden dann einzeln angelegt
			for (int i = 0; i < sprachenListe.size(); i++) {
				Lernkartei lk = sprachenListe.get(i);
				sprachen[i] = new JRadioButton(lk.getNummer() + ". " + lk.getWortEinsBeschreibung() + " - " + lk.getWortZweiBeschreibung());
				sprachen[i].setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
				sprachen[i].setSize(435, 28);
				// und ihren Beh�ltern �bergeben
				radioGroup.add(sprachen[i]);
				sprachencontent.add(sprachen[i]);
			}
		}
		// L�dt den JFrame neu
		revalidate();
		repaint();
	}

}
