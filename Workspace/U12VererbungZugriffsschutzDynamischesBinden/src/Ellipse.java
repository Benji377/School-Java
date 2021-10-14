import java.awt.*;

public class Ellipse extends Rechteck {

    public Ellipse(int x, int y, int breite, int hoehe, boolean fuellung) {
        super(x, y, breite, hoehe, fuellung);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(this.farbe);
        if (isGefuellt())
            g.fillOval(0,0,this.getWidth() - 1,this.getHeight() - 1);
        else
            g.drawOval(0,0,this.getWidth() - 1,this.getHeight() - 1);
    }
}
