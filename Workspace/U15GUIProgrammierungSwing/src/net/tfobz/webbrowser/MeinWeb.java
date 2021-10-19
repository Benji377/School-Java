package net.tfobz.webbrowser;

import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkEvent.EventType;
import javax.swing.event.HyperlinkListener;

public class MeinWeb extends JFrame {
	final int screen_height = 500;
	final int screen_width = 1000;
	final String frame_title = "MeinWeb";
	private JLabel adresse_label = null;
	private JTextField input_field = null;
	private JButton confirm_button = null;
	private JEditorPane web_view = null;
	private JScrollPane scroller = null;
	
	public static void main(String[] args) {
		// Startet das Fesnter und macht es sichtbar
		MeinWeb web = new MeinWeb();
		web.setVisible(true);
	}
	
	public MeinWeb() {
		// Ermittelt die Bildschirmgröße und setzt somit die Position des
		// Fensters in der Mitte des Bildschirms
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((int)screen_size.getWidth()/2-screen_width/2, (int)screen_size.getHeight()/2-screen_height/2, screen_width, screen_height);
		// Kann nicht vergrößert werden
		this.setResizable(false);
		this.setTitle(frame_title);
		
		// Label die die Anweisung zur Eingabe enthält
		this.adresse_label = new JLabel("Adresse", JLabel.LEFT);
		this.adresse_label.setBounds(5, 10, 70, 30);
		// Wenn die folgende Tastenkombinationgedrückt wird, erhält das Fesnter den Fokus
		this.adresse_label.setDisplayedMnemonic(KeyEvent.VK_S);
		
		// Das Eingabefeld
		this.input_field = new JTextField();
		this.input_field.setBounds(70, 10, screen_width-120, 30);
		// Das Label wird dem Eingabefeld angewiesen damit das fokus auf das
		// Eingabefeld übergeben werden kann
		this.adresse_label.setLabelFor(input_field);
		// Kontrolliert ob ein Fokus erhalten wurde
		this.input_field.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Das Eingabefeld hat Fokus erhalten, somit soll alles ausgewählt werden
				input_field.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				// EMPTY
			}
		});
		// Knopf zum ausführen der Eingabe
		this.confirm_button = new JButton();
		this.confirm_button.setBounds(screen_width-53, 10, 50, 30);
		this.confirm_button.setText("->");
		// Was passieren soll wenn eine Aktion ausgeführt wird (z. B. Entertaste geklickt)
		this.confirm_button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Es wird ermittelt ob die URL HTTP oder HTTPS enthält und im Fall angehängt
						String url = input_field.getText();
						if (!url.contains("https") && !url.contains("http"))
							url = "http://" + url;
						try {
							// Es wird versucht die übergebene URL zu öffnen
							web_view.setPage(url);
							// Der Titel des Fensters wird auch updated
							setTitle(frame_title+" - "+url);
						} catch (IOException e1) {
							// Bei falschen URLs wird eine Fehlermeldung ausgegeben
							JOptionPane.showMessageDialog(
									MeinWeb.this,
									"URL ist falsch",
									"Fehler",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
		// Beim setzten des default button wird es immer asugeführt wenn eine Aktion
		// abgehört wird, egal wo auf dem Fenster
		this.getRootPane().setDefaultButton(confirm_button);
		
		// Das Fenster dass die Website enthält
		this.web_view = new JEditorPane();
		this.web_view.setBounds(10, 55, screen_width-20, screen_height-90);
		// Verhindert das editen und blendet Javascript aus
		this.web_view.setEditable(false);
		// Ermitelt ob im Fenster ein Link geklickt wurde
		this.web_view.addHyperlinkListener(new HyperlinkListener() {

			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				// Ermittelt ob auf dem Link geklickt wurde (nict nur drübergefahren wurde)
				if (e.getEventType() ==EventType.ACTIVATED) {
					try {
						// Setzt die neue URL im Fenster
						web_view.setPage(e.getURL());
						setTitle(frame_title+" - "+e.getURL());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(
								MeinWeb.this,
								"URL ist falsch",
								"Fehler",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
		});
		
		// Beinhaltet das Fenster dass die Website beinhaltet und gibt dem Fenster
		// die Fähigkeit zu scrollen
		this.scroller = new JScrollPane();
		this.scroller.setBounds(0, 45, screen_width, screen_height-78);
		// Es wird spezifiziert auf welchem Fenster wir scrollen möchten
		this.scroller.add(web_view);
		this.scroller.setViewportView(web_view);
		
		// Fügt alle Komponente auf dem Fenster
		Container container = this.getContentPane();
		container.setLayout(null);
		container.add(adresse_label);
		container.add(input_field);
		container.add(confirm_button);
		container.add(scroller);
	}

}
