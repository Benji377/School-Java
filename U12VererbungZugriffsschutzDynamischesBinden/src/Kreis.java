public class Kreis extends Ellipse{

    public Kreis(int x, int y, int breite, boolean fuellung) {
        super(x, y, breite, breite, fuellung);
    }

    @Override
    public void setBounds(int x, int y, int hoehe, int breite) {
        super.setBounds(x, y, breite, breite);
    }
}
