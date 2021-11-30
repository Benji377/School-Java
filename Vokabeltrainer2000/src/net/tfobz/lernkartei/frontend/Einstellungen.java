/**
 * 
 */
package net.tfobz.lernkartei.frontend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Einstellungen extends JFrame{
	
	private JLabel titel1;
	private JLabel titel2;
	private JLabel sprache;
	
	private ImageIcon iimport;
	private ImageIcon iexport;
	private JButton bimport;
	private JButton bexport;
	private JButton menu;
	
	//-66,-412
	//private JDataChooser c;
	public Einstellungen(JFrame owner) {
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(owner.getX(),owner.getY(),500,500);
		this.setTitle("Vokabeltrainer: Einstellungen");
		
		iimport = new ImageIcon("./images/import.png");
		iexport = new ImageIcon("./images/export.png");
		
		menu = new JButton("Zum Menü");
		menu.setBounds(10, 12, 104, 27);
		menu.setFont(new Font("Balsamiq Sans",Font.PLAIN,13));
		menu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				owner.setVisible(true);
				setVisible(false);
			}
		});
				
		titel1 = new JLabel("Import - Export");
		titel1.setFont(new Font("Balsamiq Sans",Font.PLAIN,32));
		titel1.setBounds(140,8,216,36);
				
		bimport = new JButton("Import");
		bimport.setFont(new Font("Balsamiq Sans",Font.PLAIN,20));
		bimport.setHorizontalAlignment(SwingConstants.RIGHT);
		bimport.setBounds(27,88,127,28);
		bimport.setIcon(iimport);
		
		bexport = new JButton("Export");
		bexport.setFont(new Font("Balsamiq Sans",Font.PLAIN,20));
		bexport.setHorizontalAlignment(SwingConstants.RIGHT);
		bexport.setBounds(27,138,127,28);
		bexport.setIcon(iexport);
				
		JSeparator s = new JSeparator();
		s.setBounds(0, 198, 500, 2);
				
		titel2 = new JLabel("Erinnerungsdatum");
		titel2.setFont(new Font("Balsamiq Sans",Font.PLAIN,32));
		titel2.setBounds(116,208,268,36);
				
		sprache = new JLabel("Deutsch-Italienisch");
		sprache.setFont(new Font("Balsamiq Sans",Font.PLAIN,16));
		sprache.setBounds(27,274,150,24);
				
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(250,273,200,25);
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(menu);
		c.add(titel1);
		c.add(bimport);
		c.add(bexport);
		c.add(s);
		c.add(titel2);
		c.add(sprache);
		c.add(datePicker);
		
	
	}

}
