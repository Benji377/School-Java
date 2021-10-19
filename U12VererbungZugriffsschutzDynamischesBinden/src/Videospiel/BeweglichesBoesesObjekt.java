package Videospiel;

/**
 * @author benji
 * Klasse die Eigenschaften der beweglichen böse Objekte beinhaltet
 */
public class BeweglichesBoesesObjekt extends BeweglichesGutesObjekt{

	public BeweglichesBoesesObjekt(String dateiname) {
		super(dateiname);
	}
	
	/**
	 * Bewegt das Objekt und vermeidet dabei kollisionen
	 */
	@Override
	public void bewege() {
		// Kontrolliert in welche Richtung das Objekt bewegen kann und bewegt sich je nachdem
		if (getObjektBei(getX()+getxRichtung(), getY()+getyRichtung()) == null) {
			// Normale prozedur bei keine Kollision
			setLocation(getX()+getxRichtung(), getY()+getyRichtung());
		} else if (getObjektBei(getX()-getxRichtung(), getY()+0) == null) {
			setLocation(getX()-getxRichtung(), getY()+0);
		} else if (getObjektBei(getX()+getxRichtung(), getY()+0) == null) {
			setLocation(getX()+getxRichtung(), getY()+0);
		} else if (getObjektBei(getX()+0, getY()-getyRichtung()) == null){
			setLocation(getX()+0, getY()-getyRichtung());
		} else if (getObjektBei(getX()+0, getY()+getyRichtung()) == null){
			setLocation(getX()+0, getY()+getyRichtung());
		} else if (getObjektBei(getX()-getxRichtung(), getY()-getyRichtung()) == null) {
			setLocation(getX()-getxRichtung(), getY()-getyRichtung());
		}
	}

}
