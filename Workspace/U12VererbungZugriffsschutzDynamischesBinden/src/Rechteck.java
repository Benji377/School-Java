import java.awt.*; // Graphics
public class Rechteck extends Punkt {
    private boolean gefuellt;

    public Rechteck(int x, int y, int breite, int hoehe, boolean fuellung) {
        setBounds(x, y, breite, hoehe);
        setGefuellt(fuellung);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getFarbe());
        if (isGefuellt())
            g.fillRect(0,0,this.getWidth() - 1,this.getHeight() - 1);
        else
            g.drawRect(0,0,this.getWidth() - 1,this.getHeight() - 1);
    }

    public boolean isGefuellt() {
        return gefuellt;
    }

    public void setGefuellt(boolean gefuellt) {
        this.gefuellt = gefuellt;
    }

}
