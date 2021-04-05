import java.awt.*;
import javax.swing.JFrame;

public class CosSinFenster extends JFrame{
	
	/**
	* Festlegen der Weltkoordinaten
	*/
	private final double WELT_X0 = -10.0;
	private final double WELT_Y0 = -1.0;
	private final double WELT_X1 = 10.0;
	private final double WELT_Y1 = 1.0;
	
	/**
	 * Custom-Konstruktor der die Eigenschaften des JFrame festlegt
	 */
	public CosSinFenster() {
		setTitle("Cosinus-, Sinusberechnung");
		setSize(600, 100);
		setVisible(true);
		setDefaultCloseOperation(JumpingBalls.EXIT_ON_CLOSE);
	}
		
	/**
	* Umwandlung Welt-X-Koordinaten in Bildschirmkoordinaten. Da die Methoden
	* getHeight und getWidth auch die Ränder und insbesondere die Titelleiste in die
	* Höhe und Breite des Fensters einrechnen, müssen mit Insets diese Ränder
	* weggezählt werden
	* @param xwert die umzuwandelnde Welt-X-Koordinate
	* @return die Bildschirmkoordinate
	*/
	private int umrechnungX(double xwert) {
		Insets i = getInsets();
		return i.left + (int) ((xwert - WELT_X0) * (getWidth() - i.left - i.right) / (WELT_X1 - WELT_X0));
	}
	private int umrechnungY(double ywert) {
		Insets i = getInsets();
		return i.top + (int) (getHeight() - i.top - i.bottom - (ywert - WELT_Y0) * (getHeight() - i.top - i.bottom) / (WELT_Y1 - WELT_Y0));
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		// Koordinatensystem
		// UmrechnungX(0) = 300
		// UmrechnungY(0) = 61
		
		// Zeichnet die Mittellinien
		g.drawLine(umrechnungX(WELT_X0), umrechnungY(0), umrechnungX(WELT_X1), umrechnungY(0));
		g.drawLine(umrechnungX(0), umrechnungY(WELT_Y0), umrechnungX(0), umrechnungY(WELT_Y1));
		
		/*
		 * Zeichnet die Sinusfunktion(rot) und die Cossinusfunktion(grün)
		 * Es werden insgesamt 15 linien gezeichnet und dadurch die Funktion gezeichnet.
		 * Die Linie verschiebt sich jedes mal um eine Weltkoordinate auf der X-Achse
		 * Die Punkte auf der Y-Achse werden folgendermaßen berechnet:
		 * Y-Achse = Math.sin(i*Math.PI/2)
		 * (Farbe verhält sich komisch
		 */
		for (double i = WELT_X0; i < WELT_X1; i+=0.001) {
			// setzt die Farbe für die Funktionen
			// Zeichnet die Sinuskurve mit roter Farbe
			g.setColor(Color.red);
			g.drawLine(umrechnungX(i), umrechnungY(Math.sin(i)), umrechnungX(i), umrechnungY(Math.sin(i)));
			
			// Zeichnet die Cossinuskurve mit grüner Farbe
			g.setColor(Color.green);
			g.drawLine(umrechnungX(i), umrechnungY(Math.cos(i*Math.PI/2)), umrechnungX(i+1), umrechnungY(Math.cos((i+1)*Math.PI/2)));
		}
	}
}
