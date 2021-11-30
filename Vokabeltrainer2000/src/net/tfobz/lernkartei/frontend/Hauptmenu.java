package net.tfobz.lernkartei.frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import net.tfobz.lernkartei.backend.VokabeltrainerDB;

public class Hauptmenu extends JFrame{
	private JLabel titel;
	private JLabel credits;
	private JComboBox<String> sprachen;
	private JButton einstellungen;
	private ImageIcon front;
	private JLabel front_carrier;
	int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 250;
	int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 250;
	
	public static void main(String[] args) {
		Hauptmenu h = new Hauptmenu();
		h.setVisible(true);
	}
	
	// Balsamiq Koordinaten: X: 412 Y: 66
	public Hauptmenu() {
		this.setTitle("Vokabeltrainer2000");
		this.setBounds(x, y, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon icon = new ImageIcon("./images/setting-lines.png");
		
		this.einstellungen = new JButton();
		this.einstellungen.setBounds(435, 17, 40, 40);
		this.einstellungen.setIcon(icon);
		this.einstellungen.setContentAreaFilled(true);
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
		
		this.sprachen = new JComboBox<String>();
		this.sprachen.setBounds(64, 150, 372, 38);
		this.sprachen.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		this.sprachen.setEditable(false);
		this.sprachen.addItem("Sprachen");
		this.sprachen.addItem("Deutsch-Italienisch");
		this.sprachen.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == e.SELECTED) {
					System.out.println("AAA: " + sprachen.getSelectedIndex());
					VokabeltrainerDB.getLernkartei(sprachen.getSelectedIndex());
				}
			}
		});
		
		this.credits = new JLabel("Created by Mick Christian and Demetz Benjamin");
		this.credits.setBounds(190, 430, 290, 21);
		this.credits.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		
		// Resizing eines Bildes um das Leere zu füllen
		this.front = new ImageIcon("./images/smiley_face.png");
		Image image = this.front.getImage();
		Image newImage = image.getScaledInstance(265, 265, Image.SCALE_SMOOTH);
		this.front.setImage(newImage);
		this.front_carrier = new JLabel(this.front);
		this.front_carrier.setBounds(117, 190, 265, 256);
		this.front_carrier.setVisible(false);
		
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(this.titel);
		c.add(this.sprachen);
		c.add(this.einstellungen);
		c.add(this.credits);
		c.add(this.front_carrier);
	}
}
