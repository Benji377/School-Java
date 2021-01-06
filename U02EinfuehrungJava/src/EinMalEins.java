
public class EinMalEins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int zeile = 1;
		int spalte = 1;
		// Titel der Tabelle
		System.out.println("Einmaleins-Tabelle" + "\n" + "==================");
		
		while (zeile <= 10) {
			spalte = 1;
			while (spalte <= 10) {
				printZahl(zeile*spalte);
				spalte += 1;
			}
			System.out.println("");
			zeile += 1;
		}

	}
	/**
	* Gibt die ihr übergebene Zahl rechtsbündig auf vier Stellen aus. So wird
	* beispielsweise die Zahl 5 folgendermaßen ausgegeben: ...5 während die
	* Zahl 100 so ausgegeben wird .100
	* @param zahl die auszugebende Zahl
	*/
	public static void printZahl(int zahl) {
		if (zahl < 10)
			System.out.print("   " + zahl);
		else
			if (zahl < 100)
				System.out.print("  " + zahl);
			else
				System.out.print(" " + zahl);
	}

}
