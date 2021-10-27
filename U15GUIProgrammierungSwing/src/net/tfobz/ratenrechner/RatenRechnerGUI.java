package net.tfobz.ratenrechner;

import java.awt.*;
import javax.swing.*;

public class RatenRechnerGUI extends JFrame{
	private int pos_x = 500;
	private int pos_y = 500;
	private int window_width = 500;
	private int window_height = 350;
	
	private JLabel titel_label;
	private JLabel barwert_label;
	private JLabel jahreszin_label;
	private JLabel laufzeit_label;
	private JLabel ratenjahre_label;
	private JLabel rate_label;
	
	private JButton barwert_berechnen;
	private JButton laufzeit_berechnen;
	private JButton rate_berechnen;
	private JButton zeige_tilgplan;
	
	private JTextField barwert_text;
	private JTextField jahreszin_text;
	private JTextField laufzeit_text;
	private JTextField rate_text;
	
	private JComboBox<String> raten_pro_jahr;
	
	private ButtonGroup radioGroup;
	private JRadioButton vorschuss;
	private JRadioButton nachschuss;
	
	public static void main(String[] args) {
		RatenRechnerGUI rg = new RatenRechnerGUI();
		rg.setVisible(true);
	}
	
	public RatenRechnerGUI() {
		super("Ratenrechner");
		this.setBounds(pos_x, pos_y, window_width, window_height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		RatenRechner r = new RatenRechner();
		
		titel_label = new JLabel("Ratenrechner");
		titel_label.setFont(new Font("Arial", Font.BOLD, 25));
		titel_label.setBounds(window_width/2-100, 5, 200, 40);
		
		radioGroup = new ButtonGroup();
		vorschuss = new JRadioButton("Vorschüssig");
		vorschuss.setBounds(window_width/2-120, 60, 110, 30);
		nachschuss = new JRadioButton("Nachschüssig");
		nachschuss.setBounds(window_width/2, 60, 120, 30);
		vorschuss.setSelected(true);
		radioGroup.add(vorschuss);
		radioGroup.add(nachschuss);
		
		barwert_label = new JLabel("Barwert:", JLabel.RIGHT);
		barwert_label.setBounds(window_width/2-240, 100, 110, 30);
		jahreszin_label = new JLabel("Jahreszinssatz:", JLabel.RIGHT);
		jahreszin_label.setBounds(window_width/2-240, 135, 110, 30);
		laufzeit_label = new JLabel("Laufzeit in Jahren:", JLabel.RIGHT);
		laufzeit_label.setBounds(window_width/2-240, 170, 110, 30);
		ratenjahre_label = new JLabel("Raten pro Jahr:", JLabel.RIGHT);
		ratenjahre_label.setBounds(window_width/2-240, 205, 110, 30);
		rate_label = new JLabel("Rate:", JLabel.RIGHT);
		rate_label.setBounds(window_width/2-240, 240, 110, 30);
		
		barwert_berechnen = new JButton("Berechne Barwert");
		barwert_berechnen.setBounds(window_width/2, 100, 220, 30);
		laufzeit_berechnen = new JButton("Berechne Laufzeit");
		laufzeit_berechnen.setBounds(window_width/2, 170, 220, 30);
		rate_berechnen = new JButton("Berechne Rate");
		rate_berechnen.setBounds(window_width/2, 240, 220, 30);
		zeige_tilgplan = new JButton("Zeige Tilgungsplan");
		zeige_tilgplan.setBounds(window_width/2+70, 285, 150, 30);
		
		barwert_text = new JTextField();
		barwert_text.setBounds(window_width/2-120, 100, 110, 30);
		jahreszin_text = new JTextField();
		jahreszin_text.setBounds(window_width/2-120, 135, 110, 30);
		laufzeit_text = new JTextField();
		laufzeit_text.setBounds(window_width/2-120, 170, 110, 30);
		rate_text = new JTextField();
		rate_text.setBounds(window_width/2-120, 240, 110, 30);
		
		raten_pro_jahr = new JComboBox<String>();
		raten_pro_jahr.setBounds(window_width/2-120, 205, 110, 30);
		raten_pro_jahr.addItem("1 Rate");
		raten_pro_jahr.addItem("4 Raten");
		raten_pro_jahr.addItem("6 Raten");
		raten_pro_jahr.addItem("12 Raten");
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(titel_label);
		c.add(barwert_label);
		c.add(jahreszin_label);
		c.add(laufzeit_label);
		c.add(ratenjahre_label);
		c.add(rate_label);
		
		c.add(barwert_berechnen);
		c.add(laufzeit_berechnen);
		c.add(rate_berechnen);
		c.add(zeige_tilgplan);
		
		c.add(barwert_text);
		c.add(jahreszin_text);
		c.add(laufzeit_text);
		c.add(rate_text);
		
		c.add(raten_pro_jahr);
		
		c.add(vorschuss);
		c.add(nachschuss);
	}
}
