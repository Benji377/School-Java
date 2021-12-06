package net.tfobz.lernkartei.frontend;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

import net.tfobz.lernkartei.backend.Karte;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;

public class Kartenliste extends JFrame{
	private JButton back;
	private JButton delete;
	private JButton add;
	private JButton edit;
	private JLabel title;
	private JScrollPane scrollPane;
	private JPanel kartencontent;
	private JRadioButton[] karten;
	private JSpinner spinn;
	private JLabel spinninfo;
	private ButtonGroup radioGroup;
	private List<Karte> kartenListe;
	
	public Kartenliste(JFrame owner, int nummerLernkartei) {
		this.setTitle("Kartenliste");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(owner.getX(), owner.getY(), 500, 500);
		this.setResizable(false);
		
		back = new JButton("Zurück");
		back.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		back.setBounds(10, 10, 80, 27);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				owner.setVisible(true);
				setVisible(false);
			}
		});
		
		ImageIcon icob = new ImageIcon("./images/edit.png");
		edit = new JButton();
		edit.setIcon(icob);
		edit.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		edit.setBounds(385, 10, 45, 45);
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton selected = (JRadioButton) radioGroup.getSelection();
			}
		});
		
		ImageIcon icom = new ImageIcon("./images/trash.png");
		delete = new JButton();
		delete.setIcon(icom);
		delete.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		delete.setBounds(439, 10, 45, 45);
		// TODO: Add Actionlistener
		
		ImageIcon icon = new ImageIcon("./images/add.png");
		add = new JButton();
		add.setIcon(icon);
		add.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		add.setBounds(331, 10, 45, 45);
		// TODO: Add Actionlistener
		
		title = new JLabel("Wählen Sie eine Karte aus");
		title.setFont(new Font("Balsamiq Sans", Font.PLAIN, 24));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(10, 80, 474, 32);
		
		int fachcount = VokabeltrainerDB.getFaecher(nummerLernkartei).size();
		//System.out.println(fachcount);
		SpinnerModel model = new SpinnerNumberModel(1, 1, fachcount+1, 1);
		spinn = new JSpinner(model);
		spinn.setBounds(82, 123, 46, 24);
		spinn.setFont(new Font("Balsamiq Sans", Font.PLAIN, 13));
		
		spinninfo = new JLabel("Fach: ");
		spinninfo.setBounds(32, 120, 50, 24);
		spinninfo.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
		
		kartencontent = new JPanel();
		kartencontent.setLayout(new BoxLayout(kartencontent, BoxLayout.Y_AXIS));
		scrollPane = new JScrollPane(kartencontent);
		scrollPane.setBounds(32, 150, 436, 320);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		radioGroup = new ButtonGroup();
		kartenListe = VokabeltrainerDB.getKarten((int) spinn.getValue());
		if (kartenListe != null) {
			karten = new JRadioButton[kartenListe.size()];
			
			for (int i = 0; i < kartenListe.size(); i++) {
				Karte k = kartenListe.get(i);
				karten[i] = new JRadioButton(k.getNummer() + ". " + k.getWortEins() + " - " + k.getWortZwei());
				karten[i].setFont(new Font("Balsamiq Sans", Font.PLAIN, 20));
				karten[i].setSize(435, 28);
				radioGroup.add(karten[i]);
				kartencontent.add(karten[i]);
			}
		}
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(this.back);
		c.add(this.add);
		c.add(this.delete);
		c.add(this.edit);
		c.add(this.title);
		c.add(this.spinn);
		c.add(this.spinninfo);
		c.add(this.scrollPane);
	}

}

