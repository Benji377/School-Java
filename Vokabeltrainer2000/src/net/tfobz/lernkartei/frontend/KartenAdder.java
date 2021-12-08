package net.tfobz.lernkartei.frontend;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import net.tfobz.lernkartei.backend.Karte;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;

// Dialog dass es dem Benutzer ermöglicht Karten hinzuzufügen
// Karten werden immer dem ersten Fach hinzugefügt
public class KartenAdder extends JDialog {
	JLabel titel;
	JLabel wort1;
	JLabel wort2;
	JButton save;
	JTextField inwort1;
	JTextField inwort2;
	Karte k;
	
	public KartenAdder(JFrame owner, int nummerLernkartei) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), 500, 278);
		this.setTitle("Karten hinzufügen");
		this.setResizable(false);
		this.setModal(true);
		
		titel = new JLabel("Hinzufügen der Karte");
		titel.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
		titel.setHorizontalAlignment(SwingConstants.CENTER);
		titel.setBounds(85, 17, 330, 36);
		
		wort1 = new JLabel("Erstes Wort:");
		wort1.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		wort1.setBounds(15, 80, 130, 28);
		
		wort2 = new JLabel("Zweites Wort:");
		wort2.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		wort2.setBounds(17, 130, 130, 28);
		
		inwort1 = new JTextField();
		inwort1.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		inwort1.setBounds(151, 77, 333, 34);
		
		inwort2 = new JTextField();
		inwort2.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		inwort2.setBounds(151, 127, 333, 34);
		
		save = new JButton("Speichern");
		save.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		save.setBounds(175, 183, 150, 45);
		save.setHorizontalAlignment(SwingConstants.CENTER);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Man holt sich ganz einfach den Text der Textfelder
				String wortuno = inwort1.getText();
				String wortduo = inwort2.getText();
				// kontrolliert die Gültigkeit
				if (!wortuno.isEmpty() && !wortduo.isEmpty()) {
					// Man legt dann eine neue Karte mit diesen beiden Wörtern an
					k = new Karte();
					k.setWortEins(wortuno);
					k.setWortZwei(wortduo);
					// speichert die karte in der Database ab
					VokabeltrainerDB.hinzufuegenKarte(nummerLernkartei, k);
				}
				// Schließt den Dialog
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
