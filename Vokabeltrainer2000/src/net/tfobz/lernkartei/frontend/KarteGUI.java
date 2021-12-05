package net.tfobz.lernkartei.frontend;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.tfobz.lernkartei.backend.Karte;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;

public class KarteGUI extends JFrame {
	private JButton menu;
	private JButton forward;
	private JButton backward;
	private JButton solution;
	private JCheckBox grosklein;
	private JLabel vokabel;
	private JLabel losung;
	private JTextField input;
	private Karte karte;
	
	// Balsamiq Koordinaten: X: 412 Y: 66
	public KarteGUI(JFrame owner, Karte k) {
		this.setTitle("Vokabel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), 500, 500);
		this.setResizable(false);
		this.karte = k;
		
		menu = new JButton("Zum Menü");
		menu.setBounds(16, 17, 105, 27);
		menu.setFont(new Font("Balsamiq Sans", Font.BOLD, 13));
		
		vokabel = new JLabel();
		vokabel.setBounds(10, 67, 490, 68);
		vokabel.setFont(new Font("Balsamiq Sans", Font.BOLD, 50));
		vokabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		losung = new JLabel();
		losung.setBounds(10, 163, 490, 36);
		losung.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
		losung.setHorizontalAlignment(SwingConstants.CENTER);
		losung.setVisible(false);
		
		if (karte.getRichtung()) {
			vokabel.setText(karte.getWortEins());
			losung.setText(karte.getWortZwei());
		} else {
			vokabel.setText(karte.getWortZwei());
			losung.setText(karte.getWortEins());
		}
		
		input = new JTextField();
		input.setBounds(73, 230, 353, 70);
		input.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
		
		grosklein = new JCheckBox("Groß/Kleinschreibung");
		grosklein.setBounds(30, 365, 220, 30);
		grosklein.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
		grosklein.setSelected(karte.getGrossKleinschreibung());
		grosklein.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("1. "+karte.toString());
				Karte gKarte = new Karte(karte.getNummer(), karte.getWortEins(), karte.getWortZwei(), karte.getRichtung(), grosklein.isSelected());
				karte = gKarte;
				System.out.println("2. "+karte.toString());
			}
		});
		
		backward = new JButton("<<");
		backward.setBounds(30, 410, 70, 35);
		backward.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
		backward.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Karte kback = VokabeltrainerDB.getKarte(karte.getNummer()-1);
				if (kback != null) {
					karte = kback;
					validate();
					repaint();
				} else {
					JOptionPane.showMessageDialog(KarteGUI.this, "Man kann nicht weiter zurück gehen");
				}
			}
		});
		
		solution = new JButton("Lösung anzeigen");
		solution.setBounds(110, 410, 280, 35);
		solution.setFont(new Font("Balsamiq Sans", Font.BOLD, 24));
		solution.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				losung.setVisible(true);
				if (k.getRichtig(input.getText())) {
					VokabeltrainerDB.setKarteRichtig(karte);
					getContentPane().setBackground(Color.GREEN);
					grosklein.setBackground(Color.GREEN);
				} else {
					VokabeltrainerDB.setKarteFalsch(karte);
					getContentPane().setBackground(Color.RED);
					grosklein.setBackground(Color.RED);
				}
			}
		});
		
		forward = new JButton(">>");
		forward.setBounds(400, 410, 70, 35);
		forward.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
		forward.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Karte kfront = VokabeltrainerDB.getKarte(karte.getNummer()+1);
				if (kfront != null) {
					karte = kfront;
					validate();
					repaint();
				} else {
					JOptionPane.showMessageDialog(KarteGUI.this, "Man kann nicht weiter vor gehen");
				}
			}
		});
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(menu);
		c.add(vokabel);
		c.add(losung);
		c.add(input);
		c.add(grosklein);
		c.add(backward);
		c.add(solution);
		c.add(forward);
	}

}
