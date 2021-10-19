import java.awt.*;
import java.applet.*;


public class GameOfLife extends Applet{
	
	// Statt der main Methode wird die paint Methode verwendet (Ein muss bei Applets)
	public void paint(Graphics g) {
		// Laufvariable
		int n = 0;
		// Gr��e des Sterns
		int stern = 1;
		// Fixe Anzahl von Zeilen und Spalten
		final int ANZAHL_ZEILEN = 7;
		final int ANZAHL_SPALTEN = 7;
		// Maximale Anzahl von Iterationsschritten
		final int MAX_SCHRITTE = 150;
		boolean[][] matrix1 = new boolean[ANZAHL_ZEILEN][ANZAHL_SPALTEN];
		boolean[][] kontrolle = new boolean[ANZAHL_ZEILEN][ANZAHL_SPALTEN];
		//matrix1 = fuellenMatrixZufaellig(matrix1, 0.5);
		// Der Matrix wird erstmals das Stern �bergeben
		matrix1 = fuellenMatrixSternMitte(matrix1, stern);
		// Schleife zum Lebenszyklus der Matrix
		do {
			// Kontrolliert ob die beiden Matrixen gleich sind
			if (!existierenUnterschiede(matrix1, kontrolle)) {
				// Wenn ja, dsnn wird die Schleife abgebrochen
				n = MAX_SCHRITTE;
			} else {
				// Die Matrix wird ausgegeben
				ausgebenMatrix(matrix1, g, ANZAHL_SPALTEN, ANZAHL_ZEILEN);
			}
			// Die matrix1 wird zu kontrolle kopiert
			for (int i = 0; i < matrix1.length; i++) {
				for (int j = 0; j < matrix1[0].length; j++) {
					kontrolle[i][j] = matrix1[i][j];
				}
			}
			// matrix1 wird neu berechnet
			matrix1 = berechneMatrix(matrix1);
			// Dies verlangsamt das Spiel (in millisekunden)
			bremse(100);
			n++;
		} while (n < MAX_SCHRITTE);
	}
	
	/**
	 * Diese Methode f�llt in die �bergebene Matrix einen Stern, der eine
	 * bestimmte Gr��e hat. Die Gr��e des einzuf�genden Sterns wird
	 * der Methode �bergeben. Der Stern wird genau in die Mitte der
	 * Matrix eingef�gt. Wird f�r die Sterngr��e 0 �bergeben, so wird ein
	 * einziges Feld in der Mitte der Matrix gef�llt.
	 * @param matrix Die Matrix in der man den Stern einf�gen soll
	 * @param s Die Gr��e des Sterns
	 * @return Eine Matrix mit dem Stern in der Mitte
	 */
	public static boolean[][] fuellenMatrixSternMitte(boolean matrix[][], int s) {
		// Um Nullpointerexception zu vermeiden
		boolean ret[][] = matrix;
		// Mitte auf der waagrechten Achse
		int waagrecht = (matrix.length - 1) / 2;
		// Mitte auf der senkrechten Achse
		int senkrecht = (matrix[waagrecht].length - 1) / 2;
		// Hier wird die Mitte gef�llt
		ret[waagrecht][senkrecht] = true;
		// Schleife um die restlichen Felder zu f�llen
		for(int i = 0; i < s; i++) {
			// Das untere Feld des Kreuzes
			ret[waagrecht + i + 1][senkrecht] = true;
			// Das obere Feld des Kreuzes
			ret[waagrecht - i - 1][senkrecht] = true;
			// Das rechte Feld des Kreuzes
			ret[waagrecht][senkrecht + i + 1] = true;
			// Das linke Feld des Kreuzes
			ret[waagrecht][senkrecht - i - 1] = true;
		}
		return ret;
	}
	
	
	/**
	 * Durch diese Methode wird die ihr �bergebene Matrix am Bildschirm ausgegeben.
	 * Die Methode erstellt weiteres auch einen Feld mit wei�e Linien.
	 * Lebende Felder werden schwarz ausgegeben und tote Felder grau
	 * @param matrix Die Matrix die ausgegeben werden soll
	 * @param g Die Zeichenfl�che
	 * @param spalte Anzahl der Spalten des Feldes
	 * @param zeile Anzahl der Zeilen des Feldes
	 */
	public void ausgebenMatrix(boolean[][] matrix, Graphics g, int spalte, int zeile) {
		// breite und h�he werden automatisch ermittelt
		int breite = getWidth();
		int hohe = getHeight();
		// Schleife um Alle Felder bis zeile bzw. spalte durchhzugehen
		for(int i = 0; i < zeile; i++) {
			for(int j = 0; j < spalte; j++) {
				// Wenn das Feld am Leben ist soll es somit die farbe schwarz erhalten
				if (matrix[i][j] == true) {
					g.setColor(Color.black);
				} else {
					// Wenn es tot ist dann bleibt es grau
					g.setColor(Color.gray);
				}
				// Hier wird das Feld gef�llt
				g.fillRect((breite/spalte)*j, (hohe/zeile)*i, breite/spalte+1, hohe/zeile+1);
				// Die wei�e Farbe wird gebraucht um die Linien des Feld zu zeichnen
				g.setColor(Color.white);
				// Linien die von der X-Achse aus startne
				g.drawLine((breite/spalte)*j, 0, (breite/spalte)*j, hohe);
				// Linien die von der Y-Achse aus starten
				g.drawLine(0, (hohe/zeile)*i, breite, (hohe/zeile)*i);
			}
		}
	}
	
	/**
	 * Diese Methode ermittelt in der �bergebenen Matrix, wie viele lebende Nachbaren ein
	 * Feld hat. Das zu analysierende Feld wird durch seine Zeilen- und Spaltenposition
	 * �bergeben.
	 * @param matrix Die zu kontrollierende Matrix
	 * @param spalte die Position in der Spalte
	 * @param zeile die Position in der Zeile
	 * @return Anzahl an Lebende Nachbarn
	 */
	public static int anzahlLebendeNachbarn(boolean[][]matrix, int spalte, int zeile) {
		// Wenn keine Nachbarn leben dann wird 0 zur�ckgegeben
		int ret = 0;
		// Nur Nachbarn im Umfeld werden kontrolliert
		for (int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				// Wenn das Feld sich an einer g�ltigen Position befindet
				if (spalte + j >= 0 && spalte + j < matrix.length && zeile + i >= 0 && zeile + i < matrix.length) {
					// Wenn das Feld am leben ist
					if (matrix[zeile+i][spalte+j] == true) {
						// Wenn beide auf 0 stehen dann wird nichs unternommen
						if (i == 0 && j == 0) {
							
						} else {
							// Bei lebende Nachbarn:
							ret++;
						}
					}
				}
			}
		}
		return ret;
	}
	
	/**
	 * Diese Methode kontrolliert ob die beiden ihr �bergebenen Matrizen unterschiedlich sind oder nicht. Sie
	 * liefert true zur�ck, falls die Matrizen an unterschiedlichen Stellen gef�llt sind.
	 * @param matrix Die erste der beiden zu kontrollierenden Matrixen
	 * @param kontrolle die zweite Matrix
	 * @return true wenn sie unterschiedlich sind, sonst false
	 */
	public static boolean existierenUnterschiede (boolean[][]matrix, boolean[][]kontrolle) {
		// false wenn beide gleich sind
		boolean ret = false;
		// !ret ist gleich true
		while (!ret) {
			// Geht die erste Matrix komplett durch
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
					// Kontrolliert ob die beiden Matrixen gleich sind
					if(matrix[i][j] != kontrolle[i][j]) {
						// Wenn nicht, wird die Schleife unterbrochen und true zur�ckgegeben
						ret = true;
					}
				}
			}
		}
		
		return ret;
	}
	
	/**
	 * Diese Methode verwendet die vorige Methode, um einen neuen Lebenszyklus f�r die ihr
	 * �bergebene Matrix zu berechnen. Das neu berechnete Leben wird in einer neuen Matrix
	 * zur�ck geliefert.
	 * @param matrix Die alte Matrix
	 * @return eine neue Matrix
	 */
	public static boolean[][] berechneMatrix (boolean[][]matrix) {
		boolean[][]ret = matrix;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// Ein lebendes Feld bleibt lebend, wenn es genau 2 oder 3 lebende Nachbarfelder hat, ansonsten stirbt es
				if (matrix[i][j] == true && (anzahlLebendeNachbarn(matrix, j, i) == 2 || anzahlLebendeNachbarn(matrix, j, i) == 3 )) {
					matrix[i][j] = true;
				// Neues Leben entsteht, wenn ein totes Feld genau 3 lebende Nachbarfelder hat.
				} else if (matrix[i][j] == false && anzahlLebendeNachbarn(matrix, j, i) == 3) {
					matrix[i][j] = true;
				// Hat ein lebendes Feld weniger als 2 lebende Nachbarfelder, dann geht es aus Einsamkeit zugrunde.
				} else if (matrix[i][j] == true && anzahlLebendeNachbarn(matrix, j, i) < 2) {
					matrix[i][j] = false;
				// Hat ein lebendes Feld mehr als 3 lebende Nachbarfelder, dann stirbt es wegen �berbev�lkerung.
				} else if (matrix[i][j] == true && anzahlLebendeNachbarn(matrix, j, i) > 3){
					matrix[i][j] = false;
				}
			}
		}
		return ret;
	}
	
	/**
	* Veranlasst dass das Programm millis Millisekunden pausiert
	* @param millis Anzahl der Millisekunden die gewartet werden
	*/
	public void bremse(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
	
	/**
	 * Die Methode die in der ihr �bergebenen Matrix an zuf�lligen Positionen Leben einf�gt
	 * Der Methode wird auch ein Verh�ltnis �bergeben, das ihr sagt wie das Verh�ltnis zwischen gef�llten und nicht gef�llten
	 * Positionen sein soll.
	 * @param matrix Die Matrix an der Leben eingef�gt werden soll
	 * @param prozent Das Verh�ltnis in dem Leben eingef�gt werden soll
	 * @return Matrix mit Leben an zuf�lligen Positionen
	 */
	public static boolean[][] fuellenMatrixZufaellig (boolean[][]matrix, double prozent) {
		// Um Nullpointerexception zu vermeiden
		boolean[][]ret = matrix;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				ret[(int)(Math.random() * (i/prozent))][(int)(Math.random()*(j/prozent))] = true;	
			}
		}
		return ret;
	}


}
