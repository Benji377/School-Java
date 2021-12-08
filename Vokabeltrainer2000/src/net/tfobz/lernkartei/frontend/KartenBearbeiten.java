package net.tfobz.lernkartei.frontend;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.tfobz.lernkartei.backend.Karte;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;

// Dialog der es dem Benutzer ermöglicht eine Karte zu bearbeiten
public class KartenBearbeiten extends JDialog {
	JLabel titel;
	JLabel wort1;
	JLabel wort2;
	JButton save;
	JTextField inwort1;
	JTextField inwort2;
	
	public KartenBearbeiten(JFrame owner, Karte k) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), 500, 278);
		this.setTitle("Karten bearbeiten");
		this.setResizable(false);
		this.setModal(true);
		
		titel = new JLabel("Bearbeiten der Karte");
		titel.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
		titel.setBounds(88, 17, 290, 36);
		
		wort1 = new JLabel("Erstes Wort:");
		wort1.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		wort1.setBounds(15, 80, 130, 28);
		
		wort2 = new JLabel("Zweites Wort:");
		wort2.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		wort2.setBounds(17, 130, 130, 28);
		
		inwort1 = new JTextField();
		// Es wird der Text der ausgewählten Karte eingesetzt
		inwort1.setText(k.getWortEins());
		inwort1.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		inwort1.setBounds(151, 77, 333, 34);
		
		inwort2 = new JTextField();
		// Auch hier wird der Text der Karte ingesetzt
		inwort2.setText(k.getWortZwei());
		inwort2.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		inwort2.setBounds(151, 127, 333, 34);
		
		save = new JButton("Speichern");
		save.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		save.setBounds(185, 183, 110, 45);
		save.setHorizontalAlignment(SwingConstants.CENTER);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ob sich der Text geändert hat oder nciht wird es dennoch nochmals eingespeichert
				String wortuno = inwort1.getText();
				String wortduo = inwort2.getText();
				// Es wird lediglich kontrolliert dass die Felder nicht leer sind
				if (!wortuno.isEmpty() && !wortduo.isEmpty()) {
					k.setWortEins(wortuno);
					k.setWortZwei(wortduo);
					VokabeltrainerDB.aendernKarte(k);
				}
				dispose();
			}
		});
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(titel);
		c.add(wort1);
		c.add(wort2);
		c.add(inwort1);
		c.add(inwort2);
		c.add(save);
	}
}
