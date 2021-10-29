package net.tfobz.kurzeTest;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
/**
 * Dies soll lediglich als ein kurzer Test dienen. Dabei wird getestet ob es möglich ist
 * das Fenster zentral am Fenster ausgeben kann, ohne fixe Werte anzugeben.
 * @author Benji
 */
public class KurzTest extends JFrame{

	public static void main(String[] args) {
		KurzTest kTest = new KurzTest();
		kTest.setVisible(true);
	}
	
	public KurzTest() {
		// Wir ermitteln zuerst die Größe des Bildschirms
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		int height = 400;
		int width = 400;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Behalten sie vor Augen, dass sich in der oberen linken Ecke die Koordinaten P(0|0) befinden.
		// Zuerst gehen wir also die Hälfte der Bildschirmbreite nach links, gehen dann aber die Hälfte der Breite
		// des Fensters wieder zurück. Somit ist es horizontal zentriert.
		// Nun gehen wir die Hälfte des Bildschirms nach unten und dann die Hälfte der Höhe des Fensters wieder nach oben,
		// jetzt ist es vertikal auch noch zentriert.
		// Die letzten zwei Parameter sind lediglich die Breite und Höhe des Fensters
		this.setBounds((int)screen_size.getWidth()/2-width/2, (int)screen_size.getHeight()/2-height/2, width, height);
		this.setResizable(false);
		this.setTitle("Kurzer Test");
	}

}
