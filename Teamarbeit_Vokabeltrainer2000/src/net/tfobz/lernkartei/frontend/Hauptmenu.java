package net.tfobz.lernkartei.frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.*;

import net.tfobz.lernkartei.backend.Fach;
import net.tfobz.lernkartei.backend.Karte;
import net.tfobz.lernkartei.backend.Lernkartei;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;

// Icons von: https://www.freepik.com/
public class Hauptmenu extends JFrame {
	private JLabel titel;
	private JLabel credits;
	private JComboBox<String> sprachen;
	private JButton einstellungen;
	// Berechnet die Position um das JFrame genau in der Mitte des Bildschirm
	// auszugeben
	int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 250;
	int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 250;
	private JButton kartenedit;
	private JButton sprachedit;
	private JButton lernen;
	private List<Lernkartei> sprachenliste;
	private List<Fach> abgelaufen;

	public static void main(String[] args) {
		Hauptmenu h = new Hauptmenu();
		h.setVisible(true);
	}

	// Ist das Hauptfenster des gesamten Programms
	public Hauptmenu() {
		this.setTitle("Vokabeltrainer2000");
		this.setBounds(x, y, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		// Knopf um auf dem JFrame der Einstellungen über zu gehen
		ImageIcon icon = new ImageIcon("./images/setting-lines.png");
		this.einstellungen = new JButton();
		this.einstellungen.setBounds(435, 17, 40, 40);
		this.einstellungen.setIcon(icon);
		this.einstellungen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Einstellungen einst = new Einstellungen(Hauptmenu.this);
				einst.setVisible(true);
				setVisible(false);
			}
		});

		this.titel = new JLabel("Vokabeltrainer2000");
		this.titel.setBounds(67, 70, 372, 48);
		this.titel.setFont(new Font("Balsamiq Sans", Font.BOLD, 40));
		sprachenliste = VokabeltrainerDB.getLernkarteien();

		// Enthält die Auswahl an allen möglichen Lernkarteien
		this.sprachen = new JComboBox<String>();
		this.sprachen.setBounds(64, 150, 372, 38);
		this.sprachen.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		this.sprachen.setEditable(false);
		this.sprachen.addItem("Sprachen");
		for (int i = 0; sprachenliste.size() > i; i++) {
			sprachen.addItem(sprachenliste.get(i).getWortEinsBeschreibung() + " - "
					+ sprachenliste.get(i).getWortZweiBeschreibung());
		}

		// Nur estetischen Zweck: Wer das Programm gemacht hat
		this.credits = new JLabel("Created by Mick Christian and Demetz Benjamin");
		this.credits.setBounds(190, 430, 290, 21);
		this.credits.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		//DEBUG: System.out.println(sprachenliste);
		
		// Knopf der eine Liste von Karten anzeigt und diese bearbeiten lässt.
		// Man muss dabei zuerst eine Lernkartei auswählen
		kartenedit = new JButton("Karten bearbeiten");
		kartenedit.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		kartenedit.setHorizontalAlignment(SwingConstants.CENTER);
		kartenedit.setBounds(304, 294, 180, 40);
		kartenedit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Kontrolliert dass eine Sprache ausgewählt wurde
				if (sprachen.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(Hauptmenu.this, "Bitte wähle zuerst eine Sprache aus");
				} else {
					int nummer = sprachenliste.get(sprachen.getSelectedIndex() - 1).getNummer();
					//DEBUG: System.out.println(sprachenliste.get(sprachen.getSelectedIndex() - 1));
					//DEBUG: System.out.println(nummer);
					try {
						if (nummer != 0) {
							// Öffnte das JFrame zur Kartenliste
							Kartenliste k = new Kartenliste(Hauptmenu.this, nummer);
							k.setVisible(true);
							setVisible(false);
						} else {
							throw new InputMismatchException("Sie sollen eine Sprache aussuchen");
						}
					} catch (InputMismatchException e1) {
						JOptionPane.showMessageDialog(Hauptmenu.this, e1.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		// Knopf der eine Liste von Lernkarteien anzeigt und diese bearbeiten lässt
		sprachedit = new JButton("Sprachen bearbeiten");
		sprachedit.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		sprachedit.setHorizontalAlignment(SwingConstants.CENTER);
		sprachedit.setBounds(16, 294, 180, 40);
		sprachedit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Sprachenliste s = new Sprachenliste(Hauptmenu.this);
				s.setVisible(true);
				setVisible(false);
			}
		});

		// Knopf der das gesamte lernen eigentlich startet. Es wählt eine zufällige
		// Karte und man kann dann anfangen diese zu lernen
		lernen = new JButton("Zufällige Karte lernen");
		lernen.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		lernen.setHorizontalAlignment(SwingConstants.CENTER);
		lernen.setBounds(150, 360, 200, 40);
		lernen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Kontrolliert wiederum dass eine Sprache ausgewählt wurde
					if (sprachen.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(Hauptmenu.this, "Bitte wähle zuerst eine Sprache aus");
					} else {
						int nummer = sprachenliste.get(sprachen.getSelectedIndex() - 1).getNummer();
						if (nummer != 0) {
							// Kontrolliert ob es Fächer gibt, die man zuerts lernen muss
							abgelaufen = VokabeltrainerDB.getFaecherErinnerung(nummer);
							if (abgelaufen.isEmpty() == false) {
								// Wenn keine Fächer abgelaufen sind wird ganz einfach eine zufällige Karte gelernt
								Karte k = VokabeltrainerDB.getZufaelligeKarte(nummer, abgelaufen.get(0).getNummer());
								if (k != null) {
									// Sicherheitshalber wird noch kontrolliert dass die Karte nicht null ist
									KarteGUI k1 = new KarteGUI(Hauptmenu.this, k, nummer, abgelaufen.get(0).getNummer());
									k1.setVisible(true);
									setVisible(false);
								} else {
									throw new InputMismatchException("Es gibt keine Karten");
								}
								
							} else {
								throw new InputMismatchException("Bei diesem Fach ist die Erinnerung abgelaufen");
							}
						} else {
							throw new InputMismatchException("Sie sollen eine Sprache aussuchen");
						}
					}
				} catch (InputMismatchException e1) {
					JOptionPane.showMessageDialog(Hauptmenu.this, e1.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(this.titel);
		c.add(this.sprachen);
		c.add(this.einstellungen);
		c.add(this.credits);
		c.add(this.sprachedit);
		c.add(this.kartenedit);
		c.add(this.lernen);
	}
}
