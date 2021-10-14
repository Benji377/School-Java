import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KreisGUI  extends JFrame {
	// Das Fenster besteht aus drei Label, drei Textfelder und ein Knopf
	private JLabel radiusLabel = null;
	private JLabel umfangLabel = null;
	private JLabel flaecheLabel = null;
	
	private JTextField radiusText = null;
	private JTextField umfangText = null;
	private JTextField flaecheText = null;
	
	private JButton berechne = null;
	
	// Hier wird der eigentliche Konstruktor erstellt
	public KreisGUI() {
		// Eigenschaften des Fensters werden festgelegt
		setTitle("Kreisberechnung");
		setBounds(100, 100, 220, 185);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Alle Label werden istanziert und auf dem Fenster platziert
		radiusLabel = new JLabel("Radius:");
		radiusLabel.setBounds(5, 15, 50, 25);
		umfangLabel = new JLabel("Umfang:");
		umfangLabel.setBounds(5, 45, 50, 25);
		flaecheLabel = new JLabel("Fläche:");
		flaecheLabel.setBounds(5, 75, 50, 25);
		
		// Alle Textfelder werden istanziert und auf dem Fenster platziert
		radiusText = new JTextField();
		radiusText.setBounds(65, 15, 135, 25);
		umfangText = new JTextField();
		umfangText.setBounds(65, 45, 135, 25);
		flaecheText = new JTextField();
		flaecheText.setBounds(65, 75, 135, 25);
		
		// Der Knopf wird istanziert und platziert
		berechne = new JButton("Berechne");
		berechne.setBounds(5, 105, 190, 25);
		
		// Durch dem Container werden die Elemente auf dem Fenster angezeigt
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.add(radiusLabel);
		contentPane.add(umfangLabel);
		contentPane.add(flaecheLabel);
		
		contentPane.add(radiusText);
		contentPane.add(umfangText);
		contentPane.add(flaecheText);
		
		contentPane.add(berechne);
		
		// Damit kann man die Größe des Fensters nicht mehr verändern
		setResizable(false);
		
		// Somit wird das gesamte JFrame sichtbar
		setVisible(true);
		
		// Hier wird ein neues Kresiobjekt erstellt
		Kreis k = new Kreis();
		
		// Hiermit werden die aktionen des Knopf festgelegt
		berechne.addActionListener(
				new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					try {
						// Je nachdem welches Feld ausgefüllt worden ist, werden bestimmte Werte gesetzt
						if (!radiusText.getText().isEmpty()) {
							k.setRadius(Double.parseDouble(radiusText.getText()));
						} else if (!umfangText.getText().isEmpty()) {
							k.setUmfang(Double.parseDouble(umfangText.getText()));
						} else if (!flaecheText.getText().isEmpty()) {
							k.setFlaeche(Double.parseDouble(flaecheText.getText()));
						}
						// Die Werte werden dann neu berechnet und zurückgegeben
						radiusText.setText(String.valueOf(k.getRadius()));
						umfangText.setText(String.valueOf(k.getUmfang()));
						flaecheText.setText(String.valueOf(k.getFlaeche()));
					} catch (NumberFormatException e) {
						// Wird nur dann ausgeführt wenn Fehler auftreten
						radiusText.setText("Fehler");
						umfangText.setText("Fehler");
						flaecheText.setText("Fehler");
					}
				}
			}
		);
		
	}
}
