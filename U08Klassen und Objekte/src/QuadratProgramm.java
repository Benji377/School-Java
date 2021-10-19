/**
 * Programm um die Klasse Quadrat zu testen
 * @author Benjamin
 */
public class QuadratProgramm {

	public static void main(String[] args) {
		// Array mit 50 leere Quadrat Objekte wird erstellt
		Quadrat[] quadrate = new Quadrat[50];
		// Temporäre Quadrat zum zwischenspeichern von Objekte
		Quadrat temp = new Quadrat();
		System.out.println("Seitenlänge:");
		// Schleife die das Array durchläuft und die Quadrate erstellt
		for (int i = 0; i < quadrate.length; i++) {
			// An der Stelle i wird ein neues Quadrat Objekt angelegt
			quadrate[i] = new Quadrat();
			// Der neue Quadrat bekommt eine zufällige Seite zwischen 0 und 10
			quadrate[i].setSeiteA(Math.random()*10);
			// Jeder Quadrat wird ausgegeben
			System.out.print(i+1 + "= "+quadrate[i].getSeiteA()+"; \n");
		}
		// Schleife die das Array durchläuft und die Quadrate sortiert
		for (int i = 0; i < quadrate.length; i++) {
			//j nimmt das nächste Obkjekt im Array
			for (int j = i+1; j < quadrate.length; j++) {
				// Benutzt compareTo um den größeren Quadrat zu suchen
				if(quadrate[i].compareTo(quadrate[j]) == 1) {
					// Der größere Quadrat wird zwischengespeichert
					temp = quadrate[i];
					// Der größere Quadrat wird mit dem kleineren vertauscht
					quadrate[i] = quadrate[j];
					quadrate[j] = temp;
				}
			}
		}
		// max ist der größte Quadrat im Array
		Quadrat max = new Quadrat();
		// Der größte Quadrat befindet sich nach dem sortieren am Ende des Array
		max = quadrate[quadrate.length-1];
		System.out.println();
		// Gibt die Eigenschaften des größten Quadrat aus
		System.out.println("Größte Quadrat: "+max.toString());
	}

}
