package net.tfobz.programm;
import javax.swing.*;					// Wegen JFrame
import java.awt.*;						// Wegen Container, Graphics, usw.
import java.awt.event.*;			// Wegen WindowAdapter, WindowEvent
import net.tfobz.spielobjekte.*;

/**
 * Programm welches zeigen soll, wie unbewegliche Objekte erstellt, positioniert
 * und dargestellt werden k�nnen. Das Programm zeigt auch, wie auf Tastaturereignisse
 * im Formular reagiert werden kann
 * @author Michael Wild
 */
public class SpielGUI extends JFrame
{
	private final int ANZAHL_UNBEWEGLICHE_OBJEKTE = 10;
	private final int ANZAHL_PIZZA = 5;
	private final int ANZAHL_ZOMBIE = 3;
	/*
	 * Merkt sich die X-Richtung der Verschiebung. Ist richtung negativ, wird nach links
	 * geschoben, ist richtung positiv, dann nach rechts
	 */
	private int xrichtung = 0;
	private int yrichtung = 0;
	
	/**
	 * Konstruktor
	 */
	public SpielGUI() {
		super("SpielVorlageGUI");
		// Original: 10, 10, 400, 400
		setBounds(10,10,700,700);
		setResizable(false);
		
		// Oberfl�che des Fensters auf welcher die Objekte platziert werden sollen
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		setVisible(true);
		
		// Positioniert unbewegliche Objekte im Fenster an zuf�llig ausgew�hlten Positionen
		// so dass diese sich nicht �berdecken
		for (int i = 0; i < ANZAHL_UNBEWEGLICHE_OBJEKTE; i++) {
			Mauer m = new Mauer();
			contentPane.add(m);
			int x = 0;
			int y = 0;
			// Damit Objekte sich nicht überlappen
			do {
				x = (int)(Math.random()*this.getWidth());
				y = (int)(Math.random()*this.getHeight());
			} while (m.getObjektBei(x,y) != null);
			m.setLocation(x,y);
		}
		
		// Positioniert Pizzas an zufälligen Stellen und lasst ihnen freien lauf
		for (int i = 0; i < ANZAHL_PIZZA; i++) {
			Pizza s = new Pizza();
			contentPane.add(s);
			int x = 0;
			int y = 0;
			do {
				x = (int)(Math.random()*this.getWidth());
				y = (int)(Math.random()*this.getHeight());
			} while (s.getObjektBei(x,y) != null);
			s.setLocation(x,y);
		}
		
		// Positioniert Zombies an zufälligen Stellen und lässt ihnen freien lauf
		for (int i = 0; i < ANZAHL_ZOMBIE; i++) {
			Zombie b = new Zombie();
			contentPane.add(b);
			int x = 0;
			int y = 0;
			do {
				x = (int)(Math.random()*this.getWidth());
				y = (int)(Math.random()*this.getHeight());
			} while (b.getObjektBei(x,y) != null);
			b.setLocation(x,y);
		}
		
		// Positioniert den Spieler an einer zufälligen Stelle
		Spieler h = new Spieler();
		contentPane.add(h);
		int x = 0;
		int y = 0;
		do {
			x = (int)(Math.random()*this.getWidth());
			y = (int)(Math.random()*this.getHeight());
		} while (h.getObjektBei(x,y) != null);
		h.setLocation(x,y);
		
		
    // Registrieren des Fenster-Schlie�en-Abh�rers der das Fenster und folglich das
		// Programm beendet
		addWindowListener(
 			new WindowAdapter() {
 				public void windowClosing(WindowEvent e) {
 				  setVisible(false);
 				  dispose();
 				  System.exit(0);
 				}
 			}
 		);
		
    // Registrieren des Tastatur-Abh�rers der die Richtung des Verschiebens bestimmen l�sst
    addKeyListener(
     	new KeyAdapter() {
     		public void keyPressed(KeyEvent e) {
     			switch (e.getKeyCode()) {
     			case 40:
     	            // hoch
     				yrichtung = 1;
     	            break;
     	        case 38:
     	            // runter
     	        	yrichtung = -1;
     	            break;
     	        case 37:
     	            // links
     	        	xrichtung = -1;
     	            break;
     	        case 39:
     	            // rechts
     	        	xrichtung = 1;
     	            break;
    			}
    		}
    	}
    );
	}
	
	/**
	 * Diese Methode wird automatisch aufgerufen und zwar dann, wenn das Fenster neu 
	 * gezeichnet werden muss. Diese Methode ruft automatisch alle paint-Methoden jener
	 * Objekte auf, die dem contentPane des Formulars zugeordnet wurden. Am Ende dieser
	 * Methode wird f�r eine gewisse Zeit das Programm angehalten und dann �ber repaint()
	 * die Methode paint wieder rekursiv gestartet 
	 */
	public void paint(Graphics g) {
		// Hole alle Objekte des contentPanes des Formulars durch
		Component[] komponenten = this.getContentPane().getComponents();
		if (komponenten != null && komponenten.length > 0) {
			for (int i = 0; i < komponenten.length; i = i + 1) {
				// Kontrolliere f�r alle Objekte im Formular ob sie in Richtung richtung
				// verschoben werden k�nnen, ohne dass sie mit anderen Objekten oder dem 
				// Fensterrand kollidieren
				if (komponenten[i].getClass() == new Pizza().getClass()) {
					Pizza p = (Pizza)(komponenten[i]);
					p.bewege();
				} else if (komponenten[i].getClass() == new Mauer().getClass()) {
					Mauer m = (Mauer)(komponenten[i]);
				} else if (komponenten[i].getClass() == new Zombie().getClass()) {
					Zombie z = (Zombie)(komponenten[i]);
					z.bewege();
				} else if (komponenten[i].getClass() == new Spieler().getClass()){
					Spieler s = (Spieler)(komponenten[i]);
					// Wenn der Spieler stirbt wird das Spiel abgebrochen und das Programm beendet
					if (s.getGestorben()) {
						s.stirb();
						setVisible(false);
		 				dispose();
		 				System.exit(0);
					}
					// Spieler gewonnen!
					if (s.getPunkte() == ANZAHL_PIZZA) {
						setVisible(false);
		 				dispose();
		 				System.exit(0);
					}
					// Muss Richtung des Spielers resetten um ihn still zu halten
					s.setyRichtung(yrichtung);
					s.bewege();
					s.setyRichtung(yrichtung=0);
					s.setxRichtung(xrichtung);
					s.bewege();
					s.setxRichtung(xrichtung=0);
				}
			}
		}
		// Dieser Aufruf bewirkt, dass die normale (geerbte) paint-Methode des Formulars 
		// aufgerufen wird, welche ihrerseits daf�r sorgt, dass f�r alle Objekte des 
		// contentPane des Formulars die paint-Methode gestartet wird
		super.paint(g);
		// Programm pausiert
		bremse(100);
		// Sorgt daf�r, dass paint wiederum aufgerufen wird
		repaint();
	}

	/**
	 * L�sst das Programm f�r die angegebene Anzahl von Millisekunden pausieren
	 * @param millis
	 */
	private void bremse(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}	
	}
}
