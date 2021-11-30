/**
 * 
 */
package net.tfobz.lernkartei.frontend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.*;
import java.util.InputMismatchException;

import javax.swing.*;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import net.tfobz.lernkartei.backend.VokabeltrainerDB;

public class Einstellungen extends JFrame{
  
  private JLabel titel1;
  private JLabel titel2;
  private JLabel sprache;
  
  private ImageIcon iimport;
  private ImageIcon iexport;
  private JButton bimport;
  private JButton bexport;
  private JButton menu;
  private JComboBox<String> isprache;
  private JComboBox<String> esprache;
  private JCheckBox check;
  
  private JFileChooser chooser;
  private File file;
  

  
  
  //-66,-412
  //private JDataChooser c;
  public Einstellungen(JFrame owner) {
  
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBounds(owner.getX(),owner.getY(),500,500);
    this.setTitle("Vokabeltrainer: Einstellungen");
    this.setResizable(false);
    
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
    bimport.setHorizontalAlignment(SwingConstants.LEFT);
    bimport.setBounds(27,85,115,30);
    bimport.setIcon(iimport);
    bimport.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
      try {
        int nummer = isprache.getSelectedIndex();
        if(nummer != 0) {
          chooser = new JFileChooser();
          int value = chooser.showOpenDialog(Einstellungen.this);
          file = chooser.getSelectedFile();
          VokabeltrainerDB.importierenKarten(nummer, file.getAbsolutePath());
          
          
        }
        else {
          throw new InputMismatchException("Sie sollen eine Sprache aussuchen");
        }
      }catch(InputMismatchException e1) {
        JOptionPane.showMessageDialog(Einstellungen.this, e1.getMessage(), "Fehler",
            JOptionPane.ERROR_MESSAGE);
      }
      
      
    }
  });
    
    isprache = new JComboBox<String>();
    isprache.setBounds(212,85,156,30);
    isprache.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
    isprache.setEditable(false);
    isprache.addItem("Sprache");
    isprache.addItem("Deutsch-Italienisch");
    
    bexport = new JButton("Export");
    bexport.setFont(new Font("Balsamiq Sans",Font.PLAIN,20));
    bexport.setHorizontalAlignment(SwingConstants.LEFT);
    bexport.setBounds(27,137,115,30);
    bexport.setIcon(iexport);
    bexport.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        int nummer = esprache.getSelectedIndex();
        if(nummer != 0) {
          chooser = new JFileChooser();
          chooser.showSaveDialog(Einstellungen.this);
          System.out.println(check.isSelected());
          VokabeltrainerDB.exportierenKarten(nummer, chooser.getSelectedFile().getAbsolutePath(),check.isSelected());  
        }
        else {
          throw new InputMismatchException("Sie sollen eine Sprache aussuchen");
        }
      }catch(InputMismatchException e1) {
        JOptionPane.showMessageDialog(Einstellungen.this, e1.getMessage(), "Fehler",
            JOptionPane.ERROR_MESSAGE);
      }
      
    }
  });
    
    esprache = new JComboBox<String>();
    esprache.setBounds(212,137,156,30);
    esprache.setFont(new Font("Balsamiq Sans", Font.PLAIN, 16));
    esprache.setEditable(false);
    esprache.addItem("Sprache");
    esprache.addItem("Deutsch-Italienisch");

    
    check = new JCheckBox();
    check.setBounds(384, 137, 100, 30);
    check.setText("Mit Fächer");
    check.setFont(new Font("Balsamiq Sans",Font.PLAIN,16));
        
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
    c.add(esprache);
    c.add(isprache);
    c.add(check);
  
  }

}