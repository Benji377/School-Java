import java.awt.Graphics;
import javax.swing.JFrame;

public class JumpingBalls extends JFrame
{
	/** 
	 * Statische Membervariable, welche sich in einem Array die zu bewegenden Bälle
	 * merkt. Diese Variable darf nicht als lokale Variable innerhalb der paint-Methode
	 * definiert werden, weil sie ansonsten nach jedem Aufruf der Methode zerstört 
	 * würde. Da aber die einzelnen Ballobjekte nach dem Ende der Methode und beim
	 * nächten Auruf der paint-Methode noch leben müssen, werden diese in einer
	 * statischen Membervariable der Klasse Applet abgelegt, die auch dann noch
	 * existiert und ihre Inhalte behält, wenn ein Aufruf der paint-Methode fertig 
	 * abgearbeitet wurde 
	 */
	private static Ball[] ball = null;
	/**
	 * Statische Konstante, welche sich die Anzahl der zu bewegenden Bälle merkt
	 */
	private static	final int ANZAHL_BAELLE = 10; 

	
	/**
	 * Costum-Konstruktor um ein JFrame mit den folgenden Eigenschaften zu starten:
	 * Titel: JumpingBalls
	 * Position des Fenster: 10, 10
	 * Breite: 400
	 * Höhe: 300
	 */
	public JumpingBalls() {
		// Setzt die oben aufgezählte Eigenschaften fest
		setTitle("JumpingBalls");
		setBounds(10, 10, 400, 300);
		// Muss auf true gesetzt werden damit das Fenster sichtbar ist
		setVisible(true);
		// Wird benutzt damit beim Schließen des Fensters auch das Programm beendet wird
		setDefaultCloseOperation(JumpingBalls.EXIT_ON_CLOSE);
	}
	
	/**
	 * Diese Methode wird immer dann aufgerufen, wenn der Inhalt des Applets neu 
	 * gezeichnet werden soll
	 */
	public void paint(Graphics g) {
		// Falls noch keine Bälle vorhanden sind, wird ein Array angelegt, und
		// dieses Array nimmt dann die Ballobjekte auf, welche mit zufälligen Werten
		// gefüllt werden
		super.paint(g);
		if (ball == null) {
			ball = new Ball[ANZAHL_BAELLE];
			for (int i = 0; i < ANZAHL_BAELLE; i = i + 1) {
				ball[i] = new Ball();
				ball[i].setZufaellig();
				System.out.println(ball[i].toString());
			}
		}

		// Dann werden die Bälle um einen Schritt über den Zeichenbereich bewegt
		for (int i = 0; i < ANZAHL_BAELLE; i = i + 1)
			ball[i].bewege(g, getWidth(), getHeight());
		// Das Programm wartet eine gewisse Anzahl von Millisekunden
		bremse(100);
		// Dann wird die repaint-Methode aufgerufen, welche nichts anderes macht als
		// die paint-Methode wieder zu starten
		repaint();
	}
	
	/**
	 * Veranlasst dass das Programm millis Millisekunden pausiert
	 * @param millis Anzahl der Millisekunden die gewartet werden
	 */
	public void bremse(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}	
}