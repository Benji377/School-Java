package net.tfobz.eurorechner;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class EuroUmrechnerGUI extends JFrame{
	final int screen_height = 520;
	final int screen_width = 450;
	private JLabel[] jLabels = null;
	private JTextField[] jTextFields = null;
	private EuroUmrechner eRechner = new EuroUmrechner();
	
	public static void main(String[] args) {
		EuroUmrechnerGUI eGui = new EuroUmrechnerGUI();
		eGui.setVisible(true);
	}
	
	public EuroUmrechnerGUI() {
		// Eigenschaften des Fenster
		this.setTitle("Euroumrechner");
		this.setSize(screen_width, screen_height);
		this.setLocation(10, 10);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jLabels = new JLabel[13];
		jTextFields = new JTextField[13];
		MeinTastaturAbhoerer m = new MeinTastaturAbhoerer();
		
		// Der erste Label liegt höher als die anderen und muss deswegen separat eingebunden werden
		jLabels[0] = new JLabel(eRechner.WAEHRUNGEN[0]+":", SwingConstants.RIGHT);
		jLabels[0].setBounds(5, 5, 200, 30);
		jTextFields[0] = new JTextField();
		jTextFields[0].setBounds(210, 5, 195, 30);
		jTextFields[0].addKeyListener(m);
		jTextFields[0].setName(eRechner.WAEHRUNGEN[0]);
		
		// Setzt den ersten Abstand vom ersten Label fest, wird danach um 35 erhöht
		int y_achse = 55;
		for (int i = 1; i < jLabels.length; i++) {
			// Namen der Label sind in der EuroUmrechner Klasse dokumentiert
			jLabels[i] = new JLabel(eRechner.WAEHRUNGEN[i]+":",  SwingConstants.RIGHT);
			jLabels[i].setBounds(5, y_achse, 200, 30);
			jTextFields[i] = new JTextField();
			jTextFields[i].setBounds(210, y_achse, 195, 30);
			// Setzt den Listener und Name
			// Der Name dient zur späteren Erkennung des Feldes
			jTextFields[i].addKeyListener(m);
			jTextFields[i].setName(eRechner.WAEHRUNGEN[i]);
			// Abstand zwischen den Labels und TextFelder
			y_achse+=35;
		}
		// Fügt alle Komponenten dem Container hinzu
		Container c = this.getContentPane();
		c.setLayout(null);
		for (int i = 0; i < jLabels.length; i++) {
			c.add(jTextFields[i]);
			c.add(jLabels[i]);
		}
	}
	/**
	 * Benutzerdefiniertder Abhörer der alle TextFelder automatisch ausfüllt
	 * Dabei wird das vom Nutzer benutzte TextFeld mithilfe des Namen erkannt
	 */
	private class MeinTastaturAbhoerer extends KeyAdapter {
		
		@Override
		public void keyReleased(KeyEvent e) {
			// Das ausgerufene Textfeld wird an seinem Namen erkannt
			JTextField text = (JTextField) e.getComponent();
			String name = text.getName();
			for (int i = 0; i < eRechner.WAEHRUNGEN.length; i++) {
				// Je nachdem welcher sein Name ist, wird die Währung festgelegt
				if (name.equals(eRechner.WAEHRUNGEN[i])) {
					eRechner.setWaehrung(i);
					// Der Betrag wird von String in Double umgewandelt und ebenfalls gesetzt
					eRechner.setBetrag(Double.parseDouble(text.getText()));
				}
			}
			// Man geht dann alle TextFelder durch und ersetzt den Text mit dem
			// umgerechneten Betrag
			for (int j = 0; j < jTextFields.length; j++) {
				if (j != eRechner.getWaehrung()) {
					Double betrag = eRechner.getBetrag(j);
					betrag = Math.round(betrag * 100.0) / 100.0;
					String bString = betrag.toString();
					// Punkte werden in Kommas umgewandelt
					jTextFields[j].setText(bString.replace(".", ","));
				}	
			}
		}
	}
}
