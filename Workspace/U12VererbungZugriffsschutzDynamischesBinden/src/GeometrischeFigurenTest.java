import java.awt.*;
import java.util.Random;
import javax.swing.*;


/**
 * @author benji
 * Klasse zum testen des Generieren von geometrische Figuren
 */
public class GeometrischeFigurenTest extends JFrame{
    Random random = new Random();

    /**
     * Stellt Eigenschaften des Fensters fest
     */
    public GeometrischeFigurenTest() {
    	int height = 480;
    	int width = 400;
        setBounds(0,0,height,width);
        height = height / 10;
        width = width / 10;
        Container contentPane = getContentPane();
        
        // Erstellt zufällige geometrische Figuren
        for (int i = 0; i < 20; i++) {
        	generateRandomPunkt(contentPane, height, width);
        	generateRandomRechteck(contentPane, height, width);
        	generateRandomQuadrat(contentPane, height, width);
        	generateRandomKreis(contentPane, height, width);
        	generateRandomEllipse(contentPane, height, width);
        }
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Hauptklasse um das Programm zu starten
     * @param args
     */
    public static void main(String[] args) {
        new GeometrischeFigurenTest();
    }

    /**
     * Generiert Punkte mit zufälligen Eigenschaften
     * @param c Container dass alle Objekte beinhaltet die auf dem Fenster sichtabr sind
     * @param maxH Maximale Höhe des Objekts
     * @param maxB Maximale Breite des Objekts
     */
    public void generateRandomPunkt(Container c, int maxH, int maxB) {
    	// Rechnet die position, höhe und breite des Objekts
        int x = random.nextInt(maxB);
        int y = random.nextInt(maxH);
        int width = random.nextInt(maxB/2);
        int height = random.nextInt(maxH/2);
        Punkt p = new Punkt(x,y);
        x = random.nextInt(maxB);
        y = random.nextInt(maxH);
        p.setFarbe(Color.RED);
        p.setBounds(x,y,width,height);
        c.add(p);
    }

    /**
     * Generiert Rechtecke mit zufälligen Eigenschaften
     * @param c Container dass alle Objekte beinhaltet die auf dem Fenster sichtabr sind
     * @param maxH Maximale Höhe des Objekts
     * @param maxB Maximale Breite des Objekts
     */
    public void generateRandomRechteck(Container c, int maxH, int maxB) {
        int x = random.nextInt(maxB);
        int y = random.nextInt(maxH);
        int width = random.nextInt(maxB/2);
        int height = random.nextInt(maxH/2);
        boolean fuellung = random.nextBoolean();
        Rechteck r = new Rechteck(x,y, width, height, fuellung);
        x = random.nextInt(maxB);
        y = random.nextInt(maxH);
        r.setFarbe(Color.RED);
        r.setBounds(x,y,width,height);
        c.add(r);
    }

    /**
     * Generiert Quadrate mit zufälligen Eigenschaften
     * @param c Container dass alle Objekte beinhaltet die auf dem Fenster sichtabr sind
     * @param maxH Maximale Höhe des Objekts
     * @param maxB Maximale Breite des Objekts
     */
    public void generateRandomQuadrat(Container c, int maxH, int maxB) {
        int x = random.nextInt(maxB);
        int y = random.nextInt(maxH);
        int width = random.nextInt(maxB/2);
        int height = random.nextInt(maxH/2);
        boolean fuellung = random.nextBoolean();
        Quadrat q = new Quadrat(x,y, width, fuellung);
        x = random.nextInt(maxB);
        y = random.nextInt(maxH);
        q.setFarbe(Color.RED);
        q.setBounds(x,y,width,height);
        c.add(q);
    }

    /**
     * Generiert Ellipsen mit zufälligen Eigenschaften
     * @param c Container dass alle Objekte beinhaltet die auf dem Fenster sichtabr sind
     * @param maxH Maximale Höhe des Objekts
     * @param maxB Maximale Breite des Objekts
     */
    public void generateRandomEllipse(Container c, int maxH, int maxB) {
        int x = random.nextInt(maxB);
        int y = random.nextInt(maxH);
        int width = random.nextInt(maxB/2);
        int height = random.nextInt(maxH/2);
        boolean fuellung = random.nextBoolean();
        Ellipse e = new Ellipse(x,y, width, height, fuellung);
        x = random.nextInt(maxB);
        y = random.nextInt(maxH);
        e.setFarbe(Color.RED);
        e.setBounds(x,y,width,height);
        c.add(e);
    }

    /**
     * Generiert Kreise mit zufälligen Eigenschaften
     * @param c Container dass alle Objekte beinhaltet die auf dem Fenster sichtabr sind
     * @param maxH Maximale Höhe des Objekts
     * @param maxB Maximale Breite des Objekts
     */
    public void generateRandomKreis(Container c, int maxH, int maxB) {
        int x = random.nextInt(maxB);
        int y = random.nextInt(maxH);
        int width = random.nextInt(maxB/2);
        int height = random.nextInt(maxH/2);
        boolean fuellung = random.nextBoolean();
        Kreis k = new Kreis(x,y, width, fuellung);
        x = random.nextInt(maxB);
        y = random.nextInt(maxH);
        k.setFarbe(Color.RED);
        k.setBounds(x,y,width,height);
        c.add(k);
    }
}
