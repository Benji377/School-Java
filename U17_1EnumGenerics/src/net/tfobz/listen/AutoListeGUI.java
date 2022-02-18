package net.tfobz.listen;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AutoListeGUI extends JFrame{
	private JLabel name;
	private JLabel jahr;
	private JTextField name_ein;
	private JTextField jahr_ein;
	private JButton next;
	private JButton neu;
	private JButton del;
	private MeineDefaultListe<Auto> autoListe = new MeineDefaultListe<>();
	private MeinIterator<Auto> autoIterator = autoListe.elemente();
	
	public static void main(String[] args) {
		AutoListeGUI ag = new AutoListeGUI();
		ag.setVisible(true);
	}
	
	public AutoListeGUI() {
		this.setTitle("AutoListe");
		this.setBounds(100, 100, 300, 150);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		name = new JLabel("Name:");
		name.setBounds(80, 10, 100, 30);
		jahr = new JLabel("Erstzulassung:");
		jahr.setBounds(30, 40, 100, 30);
		
		name_ein = new JTextField();
		name_ein.setBounds(130, 10, 150, 30);
		jahr_ein = new JTextField();
		jahr_ein.setBounds(130, 40, 100, 30);
		
		/**
		 * Ist die Liste leer, so wird ein entsprechender Hinweis ausgegeben. Ist die Liste nicht leer, so zeigt der
		 * Iterator auf ein Element. Die Inhalte der Eingabefelder werden in das aktuelle Element übernommen.
		 * Dann wird zum nächsten Element der Liste gesprungen. Wird dabei das Ende der Liste erreicht, so wird
		 * eine entsprechende Meldung ausgegeben und dann zum ersten Element der Liste gesprungen und
		 * dessen Werte in die Eingabefelder geschrieben.
		 */
		next = new JButton("Nächstes");
		next.setBounds(30, 80, 100, 30);
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (autoListe.istLeer()) {
					JOptionPane.showMessageDialog(AutoListeGUI.this, "Liste ist leer");
				} else {
					// Wir benutzen ein Regex um zu kontrollieren ob beim Feld nur Zahlen eingegeben werden
					if (name_ein.getText().isEmpty() || jahr_ein.getText().isEmpty() || !jahr_ein.getText().matches("-?\\d+(\\.\\d+)?")) {
						JOptionPane.showMessageDialog(AutoListeGUI.this, "Alle Felder richtig ausfüllen");
					} else {
						Auto a = new Auto(name_ein.getText(), Integer.parseInt(jahr_ein.getText()));
						autoIterator.einfuegenElement(a);
						autoIterator.naechstesElement();
						if (!autoIterator.hatNaechstesElement()) {
							JOptionPane.showMessageDialog(AutoListeGUI.this, "Es wurde das Ende der Liste erreicht");
							Auto aa = autoIterator.naechstesElement();
							if (aa != null) {
								name_ein.setText(aa.getName());
								jahr_ein.setText(String.valueOf(aa.getErstzulassung()));
							} else {
								name_ein.setText("");
								jahr_ein.setText("");
							}
						}
					}
				}
			}
		});
		
		/**
		 * Ist die Liste leer, so wird ein neues Auto über den Iterator eingefügt. Etwaige Eingaben werden dabei
		 * ignoriert. Ist die Liste nicht leer, so zeigt der Iterator bereits auf das aktuelle Element. Bevor nun ein
		 * neues Auto nach diesem Element in die Liste eingehängt wird, werden die in den Eingabefeldern
		 * vorhandenen Werte in das aktuelle Element übernommen. Dann wird nach dem aktuellen Element ein
		 * Element erstellt und die Eingabefelder im Fenster gelöscht.
		 */
		neu = new JButton("Neu");
		neu.setBounds(130, 80, 60, 30);
		neu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (autoListe.istLeer()) {
					autoIterator.einfuegenElement(new Auto());
				} else {
					// Wir benutzen ein Regex um zu kontrollieren ob beim Feld nur Zahlen eingegeben werden
					if (name_ein.getText().isEmpty() || jahr_ein.getText().isEmpty() || !jahr_ein.getText().matches("-?\\d+(\\.\\d+)?")) {
						JOptionPane.showMessageDialog(AutoListeGUI.this, "Alle Felder richtig ausfüllen");
					} else {
						Auto a = new Auto(name_ein.getText(), Integer.parseInt(jahr_ein.getText()));
						autoIterator.setzenAktuellesElement(a);
						autoIterator.einfuegenElement(new Auto());
						name_ein.setText("");
						jahr_ein.setText("");
					}
				}
			}
		});
		
		/**
		 * Ist die Liste leer, so wird ein entsprechender Hinweis ausgegeben. Ist diese nicht leer, so zeigt der
		 * Iterator auf ein Element. Dieses wird gelöscht. Auch die Inhalte der Eingabefelder werden gelöscht. Ist
		 * nach dem Löschen des Elementes die Liste leer, so wird eine entsprechende Meldung ausgegeben. Wenn
		 * nicht, wird das nächste Element der Liste geholt. Wird dabei das Ende der Liste erreicht, wird eine
		 * Meldung ausgegeben und das erste Element der Liste geholt und angezeigt
		 */
		del = new JButton("Löschen");
		del.setBounds(190, 80, 90, 30);
		del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (autoListe.istLeer()) {
					JOptionPane.showMessageDialog(AutoListeGUI.this, "Liste ist leer");
				} else {
					autoIterator.loeschenAktuellesElement();
					name_ein.setText("");
					jahr_ein.setText("");
					if (autoListe.istLeer()) {
						JOptionPane.showMessageDialog(AutoListeGUI.this, "Liste ist jetzt leer");
					} else {
						autoIterator.naechstesElement();
						if (!autoIterator.hatNaechstesElement()) {
							JOptionPane.showMessageDialog(AutoListeGUI.this, "Es wurde das Ende der Liste erreicht");
							Auto a = autoIterator.naechstesElement();
							if (a != null) {
								name_ein.setText(a.getName());
								jahr_ein.setText(String.valueOf(a.getErstzulassung()));
							} else {
								name_ein.setText("");
								jahr_ein.setText("");
							}
						}
					}
				}
			}
		});
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(name);
		c.add(jahr);
		c.add(name_ein);
		c.add(jahr_ein);
		c.add(next);
		c.add(neu);
		c.add(del);
	}
}
