/**
 * Programm um die Klasse Quadrat zu testen
 * @author Benjamin
 */
public class QuadratProgramm {

	public static void main(String[] args) {
		// Array mit 50 leere Quadrat Objekte wird erstellt
		Quadrat[] quadrate = new Quadrat[50];
		// Tempor�re Quadrat zum zwischenspeichern von Objekte
		Quadrat temp = new Quadrat();
		System.out.println("Seitenl�nge:");
		// Schleife die das Array durchl�uft und die Quadrate erstellt
		for (int i = 0; i < quadrate.length; i++) {
			// An der Stelle i wird ein neues Quadrat Objekt angelegt
			quadrate[i] = new Quadrat();
			// Der neue Quadrat bekommt eine zuf�llige Seite zwischen 0 und 10
			quadrate[i].setSeiteA(Math.random()*10);
			// Jeder Quadrat wird ausgegeben
			System.out.print(i+1 + "= "+quadrate[i].getSeiteA()+"; \n");
		}
		// Schleife die das Array durchl�uft und die Quadrate sortiert
		for (int i = 0; i < quadrate.length; i++) {
			//j nimmt das n�chste Obkjekt im Array
			for (int j = i+1; j < quadrate.length; j++) {
				// Benutzt compareTo um den gr��eren Quadrat zu suchen
				if(quadrate[i].compareTo(quadrate[j]) == 1) {
					// Der gr��ere Quadrat wird zwischengespeichert
					temp = quadrate[i];
					// Der gr��ere Quadrat wird mit dem kleineren vertauscht
					quadrate[i] = quadrate[j];
					quadrate[j] = temp;
				}
			}
		}
		// max ist der gr��te Quadrat im Array
		Quadrat max = new Quadrat();
		// Der gr��te Quadrat befindet sich nach dem sortieren am Ende des Array
		max = quadrate[quadrate.length-1];
		System.out.println();
		// Gibt die Eigenschaften des gr��ten Quadrat aus
		System.out.println("Gr��te Quadrat: "+max.toString());
	}

}
