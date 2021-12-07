package net.tfobz.lernkartei.frontend;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		this.setResizable(false);
		
		// Ein Knopf um zum Einstellungsfenster zurückzukehren
		back = new JButton("Zurück");
		back.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		back.setBounds(10, 10, 80, 27);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Macht den überrangigen Fenster sichtbar und diesen unsichtbar
				owner.setVisible(true);
				setVisible(false);
			}
		});
		// Ein Knopf um alle Fächer zu löschen (Wegen Backend kann man nicht einzelne köschen)
		ImageIcon icom = new ImageIcon("./images/trash.png");
		delete = new JButton();
		delete.setIcon(icom);
		delete.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		delete.setBounds(439, 10, 45, 45);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Warnmeldung
				int option = JOptionPane.showConfirmDialog(Fachliste.this, "Achtung! Sie sind dabei alle Fächer und die Karten darin zu löschen \n"
						+ "Diese Aktion kann nicht rückgängig gemacht werden.");
				// Nur wenn auf Ja geklickt wird, werden alle gelöscht
				if (option == JOptionPane.YES_OPTION) {
					VokabeltrainerDB.loeschenAlleFaecher(nummerLernkartei);
					facherListe = VokabeltrainerDB.getFaecher(nummerLernkartei);
					// Fenster wird neu geladen
					addContent(nummerLernkartei);
				}
			}
		});
		// Knopf um ein Fach der Liste hinzuzufügen
		ImageIcon icon = new ImageIcon("./images/add.png");
		add = new JButton();
		add.setIcon(icon);
		add.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		add.setBounds(385, 10, 45, 45);
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Es wird nach dem Erinnerungsintervall gefragt
				// (Anzahl an Tage von dem Tag ab an dem man das letzte mal das Fach gelernt hat)
				String inp = JOptionPane.showInputDialog("Erinnerungsintervall eingeben: ");
				Fach f;
				// Wenn die Eingabe gültig ist wird ein neues Fach angelegt
				// Ansonsten wird standardmäßig 100 Tage verwendet
				if (inp != null && inp.length() > 0)
					f = new Fach(-1, null, Integer.parseInt(inp), null);
				else
					f = new Fach(-1, null, 0, null);
				VokabeltrainerDB.hinzufuegenFach(nummerLernkartei, f);
				addContent(nummerLernkartei);
			}
		});
		
		title = new JLabel("Liste von Fächer");
		title.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(10, 80, 474, 32);
		
		// Beinhaltet alles das was auf dem Scrollpane stehen soll
		fachcontent = new JPanel();
		// Layout um es untereinander anzureihen
		fachcontent.setLayout(new BoxLayout(fachcontent, BoxLayout.Y_AXIS));
		scrollPane = new JScrollPane(fachcontent);
		scrollPane.setBounds(10, 142, 480, 320);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.addContent(nummerLernkartei);
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(this.back);
		c.add(this.add);
		c.add(this.delete);
		c.add(this.title);
		c.add(this.scrollPane);
	}
	
	private void addContent(int nummerLernkartei) {
		fachcontent.removeAll();
		// Holt eine Liste aller Fächer aus dem Database
		facherListe = VokabeltrainerDB.getFaecher(nummerLernkartei);
		facher = new JLabel[facherListe.size()];
		// Für jedes Fach in der Liste wird ein Jlable erstellt und diese auf dem Scrollpane gesetzt
		for (int i = 0; i < facherListe.size(); i++) {
			Fach f = facherListe.get(i);
			facher[i] = new JLabel(i+1 + ". Fach (" + f.getGelerntAmEuropaeischString()+ ")" + " |  Intervall: " + f.getErinnerungsIntervall() + " Tag(e)");
			facher[i].setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
			facher[i].setSize(435, 28);
			facher[i].setToolTipText("Click drauf um das Intervall zu ändern");
			// Dies ermöglicht es beim Klicken auf einem Fach das Intervall zu ändern
			facher[i].addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// Zuerst wird das Komponent geholt
					JLabel jl = (JLabel) e.getComponent();
					// Aus dem JLabel wird der Index des vorigen Fach geholt
					String inde = jl.getText().replaceAll("(\\d+).+", "$1");
					// Dann wird der Benutzer nach einem neuen Intervall gefragt
					String inp = JOptionPane.showInputDialog("Neue Erinnerungsintervall eingeben: ");
					// Nun nehmen wir die Liste mit allen Fächer aus dem Databse
					List<Fach> listenf = VokabeltrainerDB.getFaecher(nummerLernkartei);
					// Es wird nach der Gültigkeit des Intervalls kontrolliert
					if (inp != null && inp.length() > 0) {
						int num = Integer.parseInt(inp);
						if (num > 0) {
							// Wenn alles richtig ist wird ein neues Fach angelegt mit dem neuen Intervall
							// Diese Fach wird mittels dem ermitteltne Index aus der Liste geholt
							Fach newF = listenf.get(Integer.parseInt(inde)-1);
							newF.setErinnerungsIntervall(num);
							VokabeltrainerDB.aendernFach(newF);
						}
					}
					addContent(nummerLernkartei);
				}
			});
			fachcontent.add(facher[i]);
		}
		revalidate();
		repaint();
	}

}
