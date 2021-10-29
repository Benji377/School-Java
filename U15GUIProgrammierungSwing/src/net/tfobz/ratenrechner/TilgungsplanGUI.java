package net.tfobz.ratenrechner;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
/**
 * Dieses Programm soll das Tilgungsplan von HTML in eine GUI umstellen
 * Dies erfolgt dank des JEditorPane dass HTML versteht und darstellen kann
 * @author Benji
 */
public class TilgungsplanGUI extends JDialog {
	JEditorPane tilplan;
	JScrollPane scroller;
	JButton save;
	JFileChooser filer;
	
	// Diese zwei Komponente brauchen wir zum abspeichern der Datei
	File tilgungsplan;
	FileWriter writer;
	
	public TilgungsplanGUI(JFrame owner) {
		// Da es sich hierbei um ein JDialog handelt brauchen wir ein Besitzer daf�r
		super(owner);
		this.setTitle("Tilgungsplan");
		// Wir wollen nicht das Programm beenden, sondern nur das Fenster unsichtbar machen
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(700, 300, 500, 600);
		this.setResizable(false);
		
		this.tilplan = new JEditorPane();
		// Hiermit sagen wir dem Komponent was f�r ein Texttyp es erwarten soll
		this.tilplan.setContentType("text/html");
		this.tilplan.setEditable(false);
		
		this.scroller = new JScrollPane();
		// Somit f�gen wir der JEditorPane Scrollbars hinzu
		this.scroller.add(this.tilplan);
		this.scroller.setViewportView(this.tilplan);
		this.scroller.setBounds(5, 5, getWidth()-15, getHeight()-80);
		
		// Diese neue Komponente erm�glicht es uns sp�ter dem Benutzer zu fragen,
		// wo er den Tilgungsplan als Datei abspeichern will
		this.filer = new JFileChooser("Speichern");
		this.filer.setBounds(700, 300, 500, 500);
		
		this.save = new JButton("Speichern");
		this.save.setBounds(getWidth()-120, getHeight()-70, 100, 30);
		this.save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Es wird somit ein neues Dialog gezeigt, wo der Benutzer ein Ort ausw�hlen kann
				// in der die Datei angespeichert werden wird. Weiters kann er auch Name und Endung angeben.
				// Der int-Wert gibt uns dabei nur die Entscheidung des Benutzers zur�ck, damit wir ermitteln k�nnen
				// ob der Nutzer ein Ort gew�hlt hat oder nicht
				int chosen = filer.showSaveDialog(TilgungsplanGUI.this);
				// Wenn ein Speicherort gefunden wurde, kann es weitergehen
				if (chosen == JFileChooser.APPROVE_OPTION) {
					// Hier ermitteln wir den ausgew�hlten Pfad und Name der Datei
					File location = filer.getSelectedFile();
					// Diese Methode kontrolliert ob die Datei an dem Ort bereits existiert
					if (location.exists()) {
						// Wenn ja, fragen wir dem Benutzer ob er die Datei �berschreiben will.
						// Wir speichern dabei die Antwort wiederum in ein Integer
						int answer = JOptionPane.showConfirmDialog(TilgungsplanGUI.this,
								"Datei existirt bereits, �berschreiben?",
								"Meldung",
								JOptionPane.YES_NO_OPTION);
						if (answer == JOptionPane.YES_OPTION) {
							// Die Datei soll somit �berschrieben werden.
							// Dabei �bergeben wir der neuen Datei zuerst den Pfad, l�schen dann die alte und
							// schreiben die neuen Daten in die neue Datei und erstellen diese
							tilgungsplan = new File(location.getAbsolutePath());
							location.delete();
							try {
								// Zuerst wird die Datei erstellt und dann den gesamten HTML hineingeschrieben.
								// Deswegen w�re es empfehlenswert die Datei als HTML abzuspeichern
								tilgungsplan.createNewFile();
								writer = new FileWriter(tilgungsplan);
								writer.write(tilplan.getText());
								// DEr Schreiber wird geschlossen um Datenverluste zu vermeiden
								writer.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					} else {
						// Wenn es die Datei noch nicht gibt, m�ssen wir lediglich die alte nicht l�schen
						tilgungsplan = new File(location.getAbsolutePath());
						try {
							tilgungsplan.createNewFile();
							writer = new FileWriter(tilgungsplan);
							writer.write(tilplan.getText());
							writer.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		// Beinhaltet alle Komponenten des Fensters. Einige Komponente, wie der scroller,
		// beinhalten weiters andere Komponente.
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(this.save);
		c.add(this.scroller);
	}
}
