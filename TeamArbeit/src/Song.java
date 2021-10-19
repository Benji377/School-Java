
public class Song {
	private String titel = null;
	private String album = null;
	private String interpret = null;
	private int erscheinungsjahr = 0;
	/**
	 * Methode um den titel zu setzen
	 * @param titel
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}
	/**
	 * Methode um den titel auszugeben
	 * @return titel
	 */
	public String getTitel() {
		return titel;
	}
	/**
	 * Methode um den album zu setzen
	 * @param album
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	/**
	 * Methode um den album auszugeben
	 * @return album
	 */
	public String getAlbum() {
		return album;
	}
	/**
	 * Methode um den interpret zu setzen
	 * @param interpret
	 */
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}
	/**
	 * Methode um den interpret auszugeben
	 * @return interpret
	 */
	public String getInterpret() {
		return interpret;
	}
	/**
	 * Methode um den erscheinungsjahr zu setzen
	 * @param erscheinungsjahr
	 */
	public void setErscheinungsjahr(int erscheinungsjahr) {
		this.erscheinungsjahr = erscheinungsjahr;
	}
	/**
	 * Methode um den erscheinungsjahr auszugeben
	 * @return erscheinungsjahr
	 */
	public int getErscheinungsjahr() {
		return erscheinungsjahr;
	}
	/**
	 * Kontrolliert ob der Song dieselbe länge hat wie jener Song, welcher der
	 * Methode übergeben wird
	 * @param k
	 * @return ret
	 */
	public boolean equals(Song k) {
		boolean ret = false;
		if (k.getAlbum().equals(album) && k.getTitel().equals(titel) && k.getInterpret().equals(interpret) && getErscheinungsjahr() == erscheinungsjahr) {
			ret = true;
		}
		return ret;
	}
	/**
	 * Kontrolliert, ob die länge des Song kleiner als das übergebene Songobjekt k ist
	 * (Rückgabewert = -1), größer (Rückgabewert = 1) oder gleich dem übergebenen
	 * Quadratobjekt k ist (Rückgabewert = 0)
	 * @param k
	 * @return ret
	 */
	public int compareTo(Song k) {
		int ret = 0;
		if (k.getTitel() == null || k.getInterpret() == null || k.getAlbum() == null || k.getErscheinungsjahr() <= 0) {
			ret = 0;
		} else if (k.getAlbum().length() > album.length() && k.getTitel().length() > titel.length() && k.getInterpret().length() > interpret.length()) {
			ret--;
		} else if (k.getAlbum().length() < album.length() && k.getTitel().length() < titel.length() && k.getInterpret().length() < interpret.length()) {
			ret ++;	
		}
		return ret;
	}
	/**
	 * Erstellt ein Duplikat des Song auf den die Methode aufgerufen wird. Das
	 * Duplikat vom Typ Song wird zurück geliefert
	 */
	public Song clone() {
		Song ret = new Song();
		ret.setAlbum(album);
		ret.setTitel(titel);
		ret.setInterpret(interpret);
		ret.setErscheinungsjahr(erscheinungsjahr);
		return ret;
	}
	/**
	 * Gibt die Stringentsprechung des Songs zurück
	 */
	public java.lang.String toString(){
		return (getTitel() + ";" + getAlbum() + ";" + getInterpret() + ";" + getErscheinungsjahr());
	}
	/**
	 * Die Methode setSong zerlegt den ihr übergebenen String in Titel, Album, Interpret und 
	 * Erscheinungsjahr und fügt die Teile in das Song-Objekt ein
	 * Das Trennzeichen ist der Strichpunkt (;). 
	 * @param s
	 */
	public void setSong(String s) {
		int counter= 0;
		String titel = null;
		String album = null;
		String interpret = null;
		String jahr = null;
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ';' || i == s.length()-1){
				if (titel == null) {
					titel = s.substring(counter,i);
				} else if (titel != null && album == null) {
					album = s.substring(counter,i);
				} else if (album != null && interpret == null) {
					interpret = s.substring(counter,i);
				} else if (interpret != null && jahr == null) {
					jahr = s.substring(counter,i+1);
				}
				counter = i+1;
			}
		}
		this.setTitel(titel);
		this.setAlbum(album);
		this.setInterpret(interpret);
		this.setErscheinungsjahr(Integer.parseInt(jahr));
		
		System.out.println("Titel:            " + this.getTitel());
		System.out.println("Album:            " + this.getAlbum());
		System.out.println("Interpret:        " + this.getInterpret());
		System.out.println("Erscheinungsjahr: " + this.getErscheinungsjahr());
		

	}
	

}
