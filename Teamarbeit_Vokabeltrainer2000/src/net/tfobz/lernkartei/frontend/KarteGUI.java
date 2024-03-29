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
	private JButton solution;
	private JCheckBox grosklein;
	private JLabel vokabel;
	private JLabel losung;
	private JTextField input;
	private Karte karte;

	// Enth�lt ein visueller �berblick �ber Eigenschaften einer Karte
	// Dabei muss dem Kusntroktor aber alles �bergeben werden:
	// Karte zum visualisiern, Lernkartei in der sich die Karte befindet und n�chste Karte
	public KarteGUI(JFrame owner, Karte k, int lernkartei, int f) {
		this.setTitle("Vokabel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), 500, 500);
		this.setResizable(false);
		this.karte = k;

		// Knopf der es erm�glicht zum Men� zur�ckzukehren
		menu = new JButton("Zum Men�");
		menu.setBounds(16, 17, 105, 27);
		menu.setFont(new Font("Balsamiq Sans", Font.BOLD, 13));
		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Macht den �berrangigen Fenster sichtbar
				owner.setLocation(getX(), getY());
				Hauptmenu h = new Hauptmenu();
				h.setVisible(true);
				dispose();
			}
		});

		// Enth�lt das Wort, dass der Benutzer �bersetzen muss
		vokabel = new JLabel();
		vokabel.setBounds(10, 67, 490, 68);
		vokabel.setFont(new Font("Balsamiq Sans", Font.BOLD, 50));
		vokabel.setHorizontalAlignment(SwingConstants.CENTER);

		// Enth�lt die L�sung. Ist am Anfang nat�rlich ausgeblendet
		losung = new JLabel();
		losung.setBounds(10, 163, 490, 36);
		losung.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
		losung.setHorizontalAlignment(SwingConstants.CENTER);
		losung.setVisible(false);

		// Je nach Richtung werden hier die W�rter gesetzt
		if (karte.getRichtung()) {
			vokabel.setText(karte.getWortEins());
			losung.setText(karte.getWortZwei());
		} else {
			vokabel.setText(karte.getWortZwei());
			losung.setText(karte.getWortEins());
		}

		// Hier kann der Benutzer sein L�sungsvorschlag eingeben
		input = new JTextField();
		input.setBounds(73, 230, 353, 70);
		input.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));

		// Hier kann der Benutzer den Gro�/Kleinschreiben aktivieren
		grosklein = new JCheckBox("Gro�/Kleinschreibung");
		grosklein.setBounds(30, 365, 220, 30);
		grosklein.setFont(new Font("Balsamiq Sans", Font.BOLD, 18));
		grosklein.setSelected(karte.getGrossKleinschreibung());
		grosklein.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Da das Backend dies nicht erlaubt, musste die gesamte Karte neu gemacht
				// werden um es zu erm�glichen
				// Klasse Karte hat kein setGro�Kleinschreiben Methode
				Karte gKarte = new Karte(karte.getNummer(), karte.getWortEins(), karte.getWortZwei(),
						karte.getRichtung(), grosklein.isSelected());
				karte = gKarte;
				revalidate();
				repaint();
			}
		});

		// Knopf um die L�sung anzuzeigen und kontrollieren ob der Benutzer richtig
		// erraten hat
		solution = new JButton("L�sung anzeigen");
		solution.setBounds(110, 410, 280, 35);
		solution.setFont(new Font("Balsamiq Sans", Font.BOLD, 24));
		solution.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// L�sung wird sichtbar
				losung.setVisible(true);
				// Je nach Richtigkeit wird auch die Farbe ver�ndert
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
		// Erm�glicht es dem Benutzer eine Karte weiterzugehen
		forward = new JButton(">>");
		forward.setBounds(400, 410, 70, 35);
		forward.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
		forward.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Holt die n�chste �bergebene Karte 
				Karte front = VokabeltrainerDB.getZufaelligeKarte(lernkartei, f);
				if (front != null && front != karte) {
					KarteGUI k1 = new KarteGUI(KarteGUI.this, front, lernkartei, f);
					setVisible(false);
					k1.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(KarteGUI.this, "Es gibt keine n�chste Karte");
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
		c.add(solution);
		c.add(forward);
	}

}
