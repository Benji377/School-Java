package net.tfobz.lernkartei.frontend;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import net.tfobz.lernkartei.backend.Fach;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;

public class Fachliste extends JFrame{
	private JButton back;
	private JButton delete;
	private JButton add;
	private JLabel title;
	private JScrollPane scrollPane;
	private JPanel fachcontent;
	private JLabel[] facher;
	private List<Fach> facherListe;
	
	public Fachliste(JFrame owner, int nummerLernkartei) {
		this.setTitle("Fächerliste");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), 500, 500);
		this.setBounds(10, 10, 500, 500);
		this.setResizable(false);
		
		back = new JButton("Zurück");
		back.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		back.setBounds(10, 10, 80, 27);
		
		ImageIcon icom = new ImageIcon("./images/trash.png");
		delete = new JButton();
		delete.setIcon(icom);
		delete.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		delete.setBounds(439, 10, 45, 45);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(Fachliste.this, "Achtung! Sie sind dabei alle Fächer und die Karten darin zu lösschen \n"
						+ "Diese Aktion kann nicht rückgängig gemacht werden.");
				if (option == JOptionPane.YES_OPTION) {
					VokabeltrainerDB.loeschenAlleFaecher(nummerLernkartei);
					facherListe = VokabeltrainerDB.getFaecher(nummerLernkartei);
					validate();
					repaint();
				}
			}
		});
		
		ImageIcon icon = new ImageIcon("./images/add.png");
		add = new JButton();
		add.setIcon(icon);
		add.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		add.setBounds(385, 10, 45, 45);
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Fach f = new Fach(facherListe.size(), "Fach", 100, new Date());
				VokabeltrainerDB.hinzufuegenFach(nummerLernkartei, f);
				validate();
				repaint();
			}
		});
		
		title = new JLabel("Erinnerungsdatum für Fächer");
		title.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(10, 80, 474, 32);
		
		fachcontent = new JPanel();
		fachcontent.setLayout(new BoxLayout(fachcontent, BoxLayout.Y_AXIS));
		scrollPane = new JScrollPane(fachcontent);
		scrollPane.setBounds(32, 142, 436, 320);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		facherListe = VokabeltrainerDB.getFaecher(nummerLernkartei);
		facher = new JLabel[facherListe.size()];
		
		for (int i = 0; i < facherListe.size(); i++) {
			Fach f = facherListe.get(i);
			facher[i] = new JLabel(f.getNummer() + ". " + f.getBeschreibung() + ": Erinnerung in " + f.getErinnerungsIntervall() + " Tag(e)");
			facher[i].setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
			facher[i].setSize(435, 28);
			fachcontent.add(facher[i]);
		}
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(this.back);
		c.add(this.add);
		c.add(this.delete);
		c.add(this.title);
		c.add(this.scrollPane);
	}

}
