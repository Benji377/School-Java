package net.tfobz.lernkartei.frontend;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.tfobz.lernkartei.backend.Karte;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;

public class KartenBearbeiten extends JDialog {
	JLabel titel;
	JLabel wort1;
	JLabel wort2;
	JButton save;
	JTextField inwort1;
	JTextField inwort2;
	// TODO: Change size of elements
	public KartenBearbeiten(JFrame owner, Karte k) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), 500, 278);
		this.setTitle("Karten bearbeiten");
		this.setResizable(false);
		this.setModal(true);
		
		titel = new JLabel("Bearbeiten der Karte");
		titel.setFont(new Font("Balsamiq Sans", Font.BOLD, 28));
		titel.setBounds(88, 17, 273, 36);
		
		wort1 = new JLabel("Erstes Wort:");
		wort1.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		wort1.setBounds(15, 80, 122, 28);
		
		wort2 = new JLabel("Zweites Wort:");
		wort2.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		wort2.setBounds(17, 130, 122, 28);
		
		inwort1 = new JTextField();
		inwort1.setText(k.getWortEins());
		inwort1.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		inwort1.setBounds(151, 77, 333, 34);
		
		inwort2 = new JTextField();
		inwort2.setText(k.getWortZwei());
		inwort2.setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
		inwort2.setBounds(151, 127, 333, 34);
		
		save = new JButton("Save");
		save.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		save.setBounds(185, 183, 110, 45);
		save.setHorizontalAlignment(SwingConstants.CENTER);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String wortuno = inwort1.getText();
				String wortduo = inwort2.getText();
				k.setWortEins(wortuno);
				k.setWortZwei(wortduo);
				VokabeltrainerDB.aendernKarte(k);
				// TODO: Add dispose()
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
