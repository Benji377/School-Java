package net.tfobz.lernkartei.frontend;

import javax.swing.*;
import net.tfobz.lernkartei.backend.Lernkartei;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SprachenAdder extends JDialog {
	JLabel titel;
	JLabel sprache1;
	JLabel sprache2;
	JButton save;
	JTextField insprache1;
	JTextField insprache2;
	Lernkartei lk;
	
	public SprachenAdder(JFrame owner) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), 500, 278);
		this.setTitle("Sprachen hinzufügen");
		this.setResizable(false);
		this.setModal(true);
		
		titel = new JLabel("Hinzufügen der Sprache");
		titel.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
		titel.setHorizontalAlignment(SwingConstants.CENTER);
		titel.setBounds(85, 17, 330, 36);
		
		sprache1 = new JLabel("Erste Sprache:");
		sprache1.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		sprache1.setBounds(15, 80, 170, 28);
		
		sprache2 = new JLabel("Zweite Sprache:");
		sprache2.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		sprache2.setBounds(17, 130, 170, 28);
		
		insprache1 = new JTextField();
		insprache1.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		insprache1.setBounds(201, 77, 280, 34);
		
		insprache2 = new JTextField();
		insprache2.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		insprache2.setBounds(201, 127, 280, 34);
		
		save = new JButton("Speichern");
		save.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		save.setBounds(175, 183, 150, 45);
		save.setHorizontalAlignment(SwingConstants.CENTER);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Man holt sich ganz einfach den Text der Textfelder
				String wortuno = insprache1.getText();
				String wortduo = insprache2.getText();
				// kontrolliert die Gültigkeit
				if (!wortuno.isEmpty() && !wortduo.isEmpty()) {
					// Man legt dann eine neue Karte mit diesen beiden Wörtern an
					lk = new Lernkartei();
					lk.setWortEinsBeschreibung(wortuno);
					lk.setWortZweiBeschreibung(wortduo);
					// speichert die Sprache in der Database ab
					VokabeltrainerDB.hinzufuegenLernkartei(lk);
				}
				// Schließt den Dialog
				dispose();
			}
		});
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(titel);
		c.add(sprache1);
		c.add(sprache2);
		c.add(insprache1);
		c.add(insprache2);
		c.add(save);
	}
}
