package net.tfobz.lernkartei.frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.tfobz.lernkartei.backend.Lernkartei;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;

public class SprachenBearbeiten extends JDialog {
	JLabel titel;
	JLabel sprache1;
	JLabel sprache2;
	JButton save;
	JTextField insprache1;
	JTextField insprache2;
	
	public SprachenBearbeiten(JFrame owner, Lernkartei l) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), 500, 278);
		this.setTitle("Sprachen bearbeiten");
		this.setResizable(false);
		this.setModal(true);
		
		titel = new JLabel("Bearbeiten der Sprache");
		titel.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
		titel.setBounds(88, 17, 290, 36);
		
		sprache1 = new JLabel("Erste Sprache:");
		sprache1.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		sprache1.setBounds(15, 80, 130, 28);
		
		sprache2 = new JLabel("Zweite Sprache:");
		sprache2.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		sprache2.setBounds(17, 130, 130, 28);
		
		insprache1 = new JTextField();
		// Es wird der Text der ausgewählten Sprache eingesetzt
		insprache1.setText(l.getWortEinsBeschreibung());
		insprache1.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		insprache1.setBounds(151, 77, 333, 34);
		
		insprache2 = new JTextField();
		// Auch hier wird der Text der Sprache eingesetzt
		insprache2.setText(l.getWortZweiBeschreibung());
		insprache2.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		insprache2.setBounds(151, 127, 333, 34);
		
		save = new JButton("Speichern");
		save.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		save.setBounds(185, 183, 110, 45);
		save.setHorizontalAlignment(SwingConstants.CENTER);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ob sich der Text geändert hat oder nicht wird es dennoch nochmals eingespeichert
				String wortuno = insprache1.getText();
				String wortduo = insprache2.getText();
				// Es wird lediglich kontrolliert dass die Felder nicht leer sind
				if (!wortuno.isEmpty() && !wortduo.isEmpty()) {
					l.setWortEinsBeschreibung(wortuno);
					l.setWortZweiBeschreibung(wortduo);
					VokabeltrainerDB.aendernLernkartei(l);
				}
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
