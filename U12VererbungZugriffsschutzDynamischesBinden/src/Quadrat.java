public class Quadrat extends Rechteck
{
    public Quadrat(int x, int y, int breite, boolean fuellung) {
        super(x, y, breite, breite, fuellung);
    }

    @Override
    public void setBounds(int x, int y, int breite, int hoehe) {
        super.setBounds(x, y, breite, breite);
    }
}