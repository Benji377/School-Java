package net.tfobz.lernkartei.frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.tfobz.lernkartei.backend.Karte;

// Icons from: https://www.freepik.com/
public class Hauptmenu extends JFrame{
	private JLabel titel;
	private JLabel credits;
	private JComboBox<String> sprachen;
	private JButton einstellungen;
	private ImageIcon front;
	private JLabel front_carrier;
	// Berechnet die Position um das JFrame genau in der Mitte des Bildschirm auszugeben
	int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 250;
	int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 250;
	private JButton kartenedit;
	private JButton sprachedit;
	private JButton lernen;
	
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
		
		// Enthält die Auswahl an allen möglichen Lernkarteien
		this.sprachen = new JComboBox<String>();
		this.sprachen.setBounds(64, 150, 372, 38);
		this.sprachen.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		this.sprachen.setEditable(false);
		// TODO: Hole liste an Lernkarteien von DB
		this.sprachen.addItem("Sprachen");
		
		this.credits = new JLabel("Created by Mick Christian and Demetz Benjamin");
		this.credits.setBounds(190, 430, 290, 21);
		this.credits.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		
		// Knopf der eine Liste von Karten anzeigt und diese bearbeiten lässt.
		// Man muss dabei zuerst eine Lernkartei auswählen
		kartenedit = new JButton("Karten bearbeiten");
		kartenedit.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		kartenedit.setHorizontalAlignment(SwingConstants.CENTER);
		kartenedit.setBounds(304, 294, 180, 40);
		// TODO: Add Actionlistener
		
		// Knopf der eine Liste von Lernkarteien anzeigt und diese bearbeiten lässt
		sprachedit = new JButton("Sprachen bearbeiten");
		sprachedit.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		sprachedit.setHorizontalAlignment(SwingConstants.CENTER);
		sprachedit.setBounds(16, 294, 180, 40);
		// TODO: Add Actionlistener
		
		// Knopf der das gesamte lernen eigentlich startet. Es wählt eine zufällige Karte 
		// und man kann dann anfangen diese zu lernen
		lernen = new JButton("Zufällige Karte lernen");
		lernen.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		lernen.setHorizontalAlignment(SwingConstants.CENTER);
		lernen.setBounds(150,360,200,40);
		lernen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Karte von DB generieren
				Karte k = new Karte(0, "Autobahn", "Autostrada", false, true);
				KarteGUI k1 = new KarteGUI(Hauptmenu.this, k);
				k1.setVisible(true);
				setVisible(false);
			}
		});
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(this.titel);
		c.add(this.sprachen);
		c.add(this.einstellungen);
		c.add(this.credits);
		c.add(this.front_carrier);
		c.add(this.sprachedit);
		c.add(this.kartenedit);
		c.add(this.lernen);
	}
}
