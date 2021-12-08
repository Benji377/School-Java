package net.tfobz.lernkartei.frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.*;

import net.tfobz.lernkartei.backend.Fach;
import net.tfobz.lernkartei.backend.Karte;
import net.tfobz.lernkartei.backend.Lernkartei;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;

// Icons from: https://www.freepik.com/
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
	private ArrayList<Lernkartei> sprachenliste;
	private List<Fach> abgelaufen;

	public static void main(String[] args) {
		Hauptmenu h = new Hauptmenu();
		h.setVisible(true);
	}

	// Balsamiq Koordinaten: X: 412 Y: 66
	public Hauptmenu() {
		this.setTitle("Vokabeltrainer2000");
		this.setBounds(x, y, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		// Knopf um auf dem JFrame der Einstellungen �ber zu gehen
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
		sprachenliste = new ArrayList<Lernkartei>();
		sprachenliste = (ArrayList<Lernkartei>) VokabeltrainerDB.getLernkarteien();


		// Enth�lt die Auswahl an allen m�glichen Lernkarteien
		this.sprachen = new JComboBox<String>();
		this.sprachen.setBounds(64, 150, 372, 38);
		this.sprachen.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		this.sprachen.setEditable(false);

		this.sprachen.addItem("Sprachen");
		for(int i = 0;sprachenliste.size()>i;i++) {
			sprachen.addItem(sprachenliste.get(i).getWortEinsBeschreibung()+" - "+sprachenliste.get(i).getWortZweiBeschreibung());
			sprachen.addItem(sprachenliste.get(i).getWortZweiBeschreibung()+" - "+sprachenliste.get(i).getWortEinsBeschreibung());
		}

		this.credits = new JLabel("Created by Mick Christian and Demetz Benjamin");
		this.credits.setBounds(190, 430, 290, 21);
		this.credits.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));

		// Knopf der eine Liste von Karten anzeigt und diese bearbeiten l�sst.
		// Man muss dabei zuerst eine Lernkartei ausw�hlen
		kartenedit = new JButton("Karten bearbeiten");
		kartenedit.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		kartenedit.setHorizontalAlignment(SwingConstants.CENTER);
		kartenedit.setBounds(304, 294, 180, 40);
		kartenedit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int nummer = sprachen.getSelectedIndex();
				int auswahl = 0;
				try {
					if(nummer != 0) {
						if (nummer % 2 == 0) {
							auswahl = nummer / 2;
						} else {
							auswahl = (nummer + 1) / 2;
						}
						Kartenliste k =  new Kartenliste(Hauptmenu.this,auswahl);
						k.setVisible(true);
						setVisible(false);
					}else {
						throw new InputMismatchException("Sie sollen eine Sprache aussuchen");
					}
				}catch(InputMismatchException e1) {
					JOptionPane.showMessageDialog(Hauptmenu.this, e1.getMessage(), "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Knopf der eine Liste von Lernkarteien anzeigt und diese bearbeiten l�sst
		sprachedit = new JButton("Sprachen bearbeiten");
		sprachedit.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		sprachedit.setHorizontalAlignment(SwingConstants.CENTER);
		sprachedit.setBounds(16, 294, 180, 40);
		sprachedit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Sprachenliste sl = new Sprachenliste(Hauptmenu.this);
				sl.setVisible(true);
				setVisible(false);
			}
		});

		// Knopf der das gesamte lernen eigentlich startet. Es w�hlt eine zuf�llige Karte 
		// und man kann dann anfangen diese zu lernen
		lernen = new JButton("Zuf�llige Karte lernen");
		lernen.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		lernen.setHorizontalAlignment(SwingConstants.CENTER);
		lernen.setBounds(150,360,200,40);
		lernen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abgelaufen = VokabeltrainerDB.getFaecherErinnerung(sprachen.getSelectedIndex());
				Karte k = VokabeltrainerDB.getKarte(1);
				// Karte k = VokabeltrainerDB.getZufaelligeKarte(sprachen.getSelectedIndex(), abgelaufen.get(0).getNummer());
				if (k != null ) {
					KarteGUI k1 = new KarteGUI(Hauptmenu.this, k);
					k1.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(Hauptmenu.this, "Leider ist ein Fehler aufgetreten, versuchen Sie es sp�ter erneut");
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
