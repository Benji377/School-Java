package net.tfobz.kontoverwaltung;

import javax.swing.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class KontoGUI extends JFrame {
	private JTextField textf1;
	private JTextField textf2;
	private JTextField textf3;
	private JTextField textf4;
	private JButton neugehaltsk;
	private JButton neuspark;
	private JButton anzeigen;
	private JButton buchen;
	private JButton uberweisen;
	private JTextArea textarea;
	private JScrollPane scroll_pane;
	private JLabel konton1;
	private JLabel konton2;
	private Konto[] konten = null;
	private static final int MAX_KONTEN = 100;
	private static final double STARTZINSSATZ = 0.25;
	private static final double STARTUEBERZIEHUNG = -1000.0;


	public KontoGUI() {
		setTitle("Kontoverwaltung");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 700, 500);
		// Erstellt ein Array mit der maximalen Anzahl an Konten
		konten = new Konto[MAX_KONTEN];

		// Setzt die Startwerte fest.
		try {
			Konto.setStartzinssatz(STARTZINSSATZ);
			Gehaltskonto.setStartueberziehung(STARTUEBERZIEHUNG);
		} catch (KontoException e) {
			JOptionPane.showMessageDialog(KontoGUI.this, e.getMessage(), "Startfehler", JOptionPane.ERROR_MESSAGE);
		}

		textf1 = new JTextField();
		textf1.setBounds(10, 10, 150, 30);

		textf2 = new JTextField();
		textf2.setBounds(180, 10, 150, 30);

		textf3 = new JTextField();
		textf3.setBounds(10, 90, 150, 30);

		textf4 = new JTextField();
		textf4.setBounds(180, 90, 150, 30);

		// Knopf zum erstellen eines neuen Gehaltskonto
		// Braucht keinen Input
		neugehaltsk = new JButton("Neues Gehaltskonto");
		neugehaltsk.setBounds(370, 10, 150, 30);
		neugehaltsk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Zuerst muss kontrolliert werden, ob das Array nicht voll ist
				// Dabei wird eine selbstegschriebene Methode verwendet
				if (isFull()) {
					JOptionPane.showMessageDialog(KontoGUI.this, "Es wurde das maximum von 100 Konten erreicht", "Maximum erreicht", JOptionPane.ERROR_MESSAGE);
				} else {
					// Wir verwenden wiederum eine persönliche Methode die uns die nächste freie Position im Array gibt
					int pos = getFreeSpace();
					// Dort erstellen wir dann ein Gehaltskonto
					konten[pos] = new Gehaltskonto();
					// Und geben die Daten aus
					textarea.setText(textarea.getText() + "\nNeues Gehaltskonto: " + konten[pos].toString());
				}
				// Eine kleine Methode die alle Textfelder zurücksetzt
				clearFields();
			}
		});
		
		// Erstellt einen neuen Sparkonto
		// Braucht eine erste Zahlung (textfeld1) und sparrate (textfeld2)
		neuspark = new JButton("Neues Sparkonto");
		neuspark.setBounds(530, 10, 150, 30);
		neuspark.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Wiederum wird kontrolliert dass das Array nicht voll ist
				if (isFull()) {
					JOptionPane.showMessageDialog(KontoGUI.this, "Es wurde das maximum von 100 Konten erreicht", "Maximum erreicht", JOptionPane.ERROR_MESSAGE);
				} else {
					// Es wird dann kontrolliert dass die nötigen Angaben gegeben sind
					if (!textf1.getText().isEmpty() && !textf2.getText().isEmpty()) {
						try {
							double erstZahlung = Double.parseDouble(textf1.getText());
							double sparrate = Double.parseDouble(textf2.getText());
							int pos = getFreeSpace();
							// Erstellt ein neues Sparkonto an der nächsten freien Stelle
							konten[pos] = new Sparkonto(erstZahlung, sparrate);
							textarea.setText(textarea.getText()+ "\nNeues Sparkonto: " + konten[pos].toString());
						} catch (NumberFormatException f) {
							JOptionPane.showMessageDialog(KontoGUI.this, "Eingegebene Werte sind ungültig", "Ungültige Zahlen", JOptionPane.ERROR_MESSAGE);
						} catch (KontoException e1) {
							JOptionPane.showMessageDialog(KontoGUI.this, e1.getMessage(), "Anlegen von Sparkonto", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(KontoGUI.this, "Geben Sie im ersten Feld die erste Zahlung ein und im zweiten die Sparrate", "Keine Werte eingeben", JOptionPane.ERROR_MESSAGE);
					}
				}
				clearFields();
			}
		});
		
		// Zeigt Daten zu einem bestimmten Konto an
		// Dabei muss man die Nummer des Konto übergeben (textfeld3)
		anzeigen = new JButton("Anzeigen");
		anzeigen.setBounds(370, 50, 310, 30);
		anzeigen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Kontrolliert ob die nötigen Daten übergeben wurden
				if (!textf3.getText().isEmpty()) {
					try {
						int kontonr = Integer.parseInt(textf3.getText());
						// Wir benutzen eine kleine persönliche Methode um das gewünschte Konto zu erhalten
						Konto k = getKonto(kontonr);
						// Wenn kein Konto gefunden wurde, soll ein Fehler ausgegeben werden
						if (k == null) {
							JOptionPane.showMessageDialog(KontoGUI.this, "Kein Konto mit der angegebenen Nummer gefunden", "Nichts gefuden", JOptionPane.ERROR_MESSAGE);
						} else {
							// Zeigt ansonsen Daten zum Konto an
							textarea.setText(textarea.getText() + "\nAnzeigen: " + k.toString());
						}
					} catch (NumberFormatException g) {
						JOptionPane.showMessageDialog(KontoGUI.this, "Geben Sie eine gültige Zahl ein", "Ungültige Zahl", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(KontoGUI.this, "Geben sie im dritten Feld die Nummer des Konto ein", "Keine Kontonummer", JOptionPane.ERROR_MESSAGE);
				}
				clearFields();
			}
		});

		// Funktion um Werte auf ein Konto zu buchen oder abzubuchen
		// Benötigt ein Betrag (textfeld1) und eine Kontonummer (textfeld3)
		buchen = new JButton("Buchen");
		buchen.setBounds(370, 90, 150, 30);
		buchen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Kontrolliert am Anfang dass die Felder ausgefüllt sind
				if (!textf1.getText().isEmpty() && !textf3.getText().isEmpty()) {
					try {
						double buchbetrag = Double.parseDouble(textf1.getText());
						int kontonr = Integer.parseInt(textf3.getText());
						// Wir erhalten wiederum das Konto über eine kleine Helfermethode
						Konto k = getKonto(kontonr);
						if (k == null) {
							JOptionPane.showMessageDialog(KontoGUI.this, "Kein Konto mit der angegebenen Nummer gefunden", "Nichts gefuden", JOptionPane.ERROR_MESSAGE);
						} else {
							// Der Betrag wird dann auf dem Konto gebucht
							// Kann eine Fehlermeldung ausgeben, wenn ungültige Werte gebucht werden
							k.buchen(buchbetrag);
							textarea.setText(textarea.getText() + "\nBuchen: " + k.toString());
						}
					} catch (NumberFormatException h) {
						JOptionPane.showMessageDialog(KontoGUI.this, "Geben Sie gültige Zahlen ein", "Ungültige Zahlen", JOptionPane.ERROR_MESSAGE);
					} catch (KontoException e1) {
						JOptionPane.showMessageDialog(KontoGUI.this, e1.getMessage(), "Buchfehler", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(KontoGUI.this, "Geben Sie im ersten Feld den Buchungsbetrag ein und im dritten Feld die Kontonummer", "Leere Felder", JOptionPane.ERROR_MESSAGE);
				}
				clearFields();
			}
		});

		// Überweist ein Betrag von einem Konto auf dem anderen
		// Benötigt ein etrag (textfeld1), ein Konto von dem abgebucht wird (textfeld3) und ein Konto auf dem angebucht wird (textfeld4)
		uberweisen = new JButton("Überweisen");
		uberweisen.setBounds(530, 90, 150, 30);
		uberweisen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Kontrolliert wiederum dass die Felder ausgefüllt wurden
				if (!textf1.getText().isEmpty() && !textf3.getText().isEmpty() && !textf4.getText().isEmpty()) {
					try {
						double betrag = Double.parseDouble(textf1.getText());
						int konto1 = Integer.parseInt(textf3.getText());
						int konto2 = Integer.parseInt(textf4.getText());
						// Diesmal müssen wir kontrollieren dass beide Konten existieren
						Konto k1 = getKonto(konto1);
						Konto k2 = getKonto(konto2);
						if (k1 == null|| k2 == null) {
							JOptionPane.showMessageDialog(KontoGUI.this, "Kein Konto mit der angegebenen Nummer gefunden", "Nichts gefuden", JOptionPane.ERROR_MESSAGE);
						} else {
							// Wenn beide Konten existieren, können wir buchen
							k1.ueberweisen(k2, betrag);
							// Danach wenn alles erfolgreih war, wird eine Nachricht ausgegeben
							textarea.setText(textarea.getText() + "\n" + "Überweisen von Konto " + k1.getKontoNummer() +
									" nach Konto "+ k2.getKontoNummer() +" Betrag " + betrag + " erfolgreich");
						}
					} catch (NumberFormatException v) {
						JOptionPane.showMessageDialog(KontoGUI.this, "Geben Sie gültige Zahlen ein", "Ungültige Zahlen", JOptionPane.ERROR_MESSAGE);
					} catch (KontoException e1) {
						JOptionPane.showMessageDialog(KontoGUI.this, e1.getMessage(), "Fehler beim Überweisen", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(KontoGUI.this, "Geben sie im ersten Feld den Betrag ein, "
							+ "im dritten Feld die Nummer des ersten Konto und im vierten Feld die Nummer des zweiten ein",
							"Leere Felder", JOptionPane.ERROR_MESSAGE);
				}
				clearFields();
			}
		});

		konton1 = new JLabel("Kontonummer 1:");
		konton1.setBounds(10, 60, 150, 30);
		konton1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));

		konton2 = new JLabel("Kontonummer 2:");
		konton2.setBounds(180, 60, 150, 30);
		konton2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));

		textarea = new JTextArea();
		textarea.setEditable(false);
		textarea.setText("Output:");

		scroll_pane = new JScrollPane(textarea);
		scroll_pane.setBounds(10, 140, 675, 320);

		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(textf1);
		c.add(textf2);
		c.add(textf3);
		c.add(textf4);
		c.add(neugehaltsk);
		c.add(neuspark);
		c.add(anzeigen);
		c.add(buchen);
		c.add(uberweisen);
		c.add(konton1);
		c.add(konton2);
		c.add(scroll_pane);
	}

	/**
	 * Kleine Methode die Kontrolliert ob das Konten-Array voll ist
	 * @return true wenn es voll ist, ansonsten false
	 */
	public boolean isFull() {
		boolean ret = true;
		int i = 0;
		// Geht einfach das gesamte Array durch
		while (ret && i < konten.length) {
			if (konten[i] == null) {
				// Dies bedeutet es gibt noch eine freie Stelle
				ret = false;
			} else {
				i++;
			}
		}
		return ret;
	}

	/**
	 * Kleine Methode um das nächste freie Feld im Array zu finden
	 * @return -1 wenn alles voll ist, ansonsten die Stelle im Array die noch frei ist
	 */
	public int getFreeSpace() {
		int ret = -1;
		int i = 0;
		while(ret == -1 && i < konten.length) {
			if (konten[i] == null) {
				ret = i;
			} else {
				i++;
			}
		}
		return ret;
	}
	
	/**
	 * Kleine Methode um alle Textfeldern zu leeren
	 */
	public void clearFields() {
		textf1.setText("");
		textf2.setText("");
		textf3.setText("");
		textf4.setText("");
	}
	
	/**
	 * Kleine Methode um zu ermitteln ob ein Konto mit der übergebenen Nummer existiert
	 * und es zu finden.
	 * @param nummer Die ID des Konto (Kontonummer)
	 * @return null wenn kein Konto gefunden wurde, ansonsten das Konto selbsts
	 */
	public Konto getKonto(int nummer) {
		Konto ret = null;
		for (int i = 0; i < konten.length; i++) {
			if (konten[i] != null) {
				if (konten[i].getKontoNummer() == nummer) {
					ret = konten[i];
				}
			}
		}
		return ret;
	}
}

