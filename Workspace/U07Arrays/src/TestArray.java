import java.lang.reflect.Array;
import java.util.Arrays;

public class TestArray {

	public static void main(String[] args) {
		
		int[] a = randomIntArray(5, 1, 10);
		printIntArray("a = ", a);
		printIntArray("", randomIntArray(50, -1, 1));
		System.out.println("Maximum: " + getMinimum(a));
		System.out.println("Minimum: " + getMaximum(a));
		System.out.println("Mittelwert: " + getMittelwert(a));
		System.out.println("IndexOf 4: " + indexOf(a, 4));
		System.out.println("IndexOf 4 ab pos 3: " + indexOf(a, 4, 3));
		System.out.println("MinPos: " + getMinPos(a, 2));
		
		a = randomIntArray(10, 0, 9);
		printIntArray("a = ", a);
		addZahl(a, 100);
		printIntArray("a + 100 = ", a);

		 a = randomIntArray(3, 1, 10);
		 swap(a, 0, 2);
		 printIntArray("vertauscht = ", a);
		 
		 a = randomIntArray(50, 1, 100000);
		 sortMinArray(a);
		 printIntArray("Sortiert = ", a);
		 
		 a = randomIntArray(50, 0, 10);
		 printIntArray("a = ", a);
		 a = delDoppelte(a, 11);
		 printIntArray("deldoppelte = ", a);

	}
	
	/*
	 *  Methode zum ausgeben des �bergebenen Arrays a. Bei der Ausgabe wird
	 *  der String msg noch davor geh�ngt.
	 *  @param msg Der am Anfang der Ausgabe zu h�ngende String
	 *  @param a Der zu ausgebende Array
	 *  @return Kein return
	 */
	public static void printIntArray(String msg, int[] a) {
		String ret = "";
		ret+= msg + "{";
		for(int i = 0; i < a.length; i++) {
			ret += a[i] + ", ";
		}
		System.out.println(ret.substring(0, ret.length() - 2) + "}");
	}
	
	/*
	 * Methode erstellt einen Zahlenarray mit zuf�lligen Zahlen die von von bis bis gehn
	 * Dabei wird auch die Anzahl der erw�nschten Stellen angegeben
	 * @param anzahl Die anzahl an Stellen
	 * @param von Kleinste m�gliche Zahl
	 * @param bis Gr��te m�gliche Zahl
	 * @return Gibt den zuf�llig generierten Array zur�ck
	 */
	public static int[] randomIntArray(int anzahl, int von, int bis) {
		int ret[] = new int[anzahl];
		for(int i = 0; i < ret.length; i++) {
			ret[i] = (int)Math.round((Math.random() * (bis + 1)) + von);
		}
		return ret;
	}
	
	/*
	 * Methode zum ermitteln der kleinsten Zahl im Array a
	 * @param a Der zu �berpr�fende Array
	 * @return Die kleinste Zahl im Array
	 */
	public static int getMinimum(int[] a) {
		int ret = 0;
		Arrays.sort(a);
		ret = a[0];
		return ret;
	}
	
	/*
	 * Methode zum ermitteln der gr��ten Zahl im Array a
	 * @param a Der zu �berpr�fende Array
	 * @return Die gr��te Zahl im Array a
	 */
	public static int getMaximum(int[] a) {
		int ret = 0;
		Arrays.sort(a);
		ret = a[a.length - 1];
		return ret;
	}
	
	/*
	 * Methode zum ermitteln des Mittelwerts eines Array a
	 * @param a Der zu �berpr�fende Array
	 * @return Den Mittelwert
	 */
	public static double getMittelwert(int[] a) {
		double ret = 0;
		int min = getMinimum(a);
		int max = getMaximum(a);
		ret = (max + min)/2;
		return ret;
	}
	
	/*
	 * Methode welche die Zahl z im Array a sucht und die Position zur�ckgibt an welcher die Zahl zum ersten Mal
	 * vorkommt. Falls z nicht gefunden werden kann, wird -1 zur�ckgegeben
	 * @param a der zu �berpr�fende Array
	 * @param z die zu suchende Zahl
	 * @return Die Position an der die Zahl als erste vorkommt
	 */
	public static int indexOf(int[] a, int z) {
	int ret = -1;
	for(int i = 0; i < a.length; i++) {
		if (a[i] == z) {
			ret = i;
			i = a.length;
		}
	}
	return ret;
	}
	
	/*
	 * Methode welche die Zahl z im Array a ab der Position pos sucht und die Position zur�ckgibt.
	 * Falls z nicht gefunden werden kann, wird -1 zur�ckgegeben
	 * @param a Der zu �berpr�fende Array
	 * @param z Die zu suchende Zahl
	 * @param pos Die Position ab der gesucht werden soll
	 *@return Den Index der Zahl ab der Position pos
	 */
	public static int indexOf(int[] a, int z, int pos) {
		int ret = -1;
		for(int i = pos; i < a.length; i++) {
			if (a[i] == z) {
				ret = i;
				i = a.length;
			}
		}
		return ret;
	}
	
	/*
	 * Methode welche im Array a ab der Position pos inklusive die Position des Minimums zur�ckgibt.
	 * @param a Der zu �berpr�fende array
	 * @param pos Die Position ab der die Zahl gesucht werden soll
	 * @return Die Position der kleinsten Zahl ab der Position pos
	 */
	public static int getMinPos(int[] a, int pos) {
		int ret = 0;
		int[] b = a;
		Arrays.sort(b, pos, b.length);
		for(int i = pos; i < a.length; i++) {
			if(a[i] == b[pos]) {
				ret = i;
				i = a.length;
			}
		}
		return ret;
	}
	
	/*
	 * Methode die jede Zahl im Array a um die Zahl z erh�ht
	 * @param a Array von dem die zahlen erh�ht werden sollen
	 * @param z Die zahl um der jede zahl im Array a erh�ht werden soll
	 * @return /
	 */
	public static void addZahl(int[] a, int z) {
		for(int i = 0; i < a.length; i++) {
			a[i] = a[i] + z;
		}
	}
	
	/*
	 * Methode die das Element im Array an Position i mit dem Element an Position j vertauscht
	 * @param a Der zu verarbeitende Array
	 * @param i Die Position an der sich die zu austauschende Zahl liegt
	 * @param j Die Position an der sich die Zahl befindet dass die Zahl an Position i austauschen soll
	 */
	public static void swap(int[] a, int i, int j) {
		if (i <= a.length && j <= a.length) {
			a[i] = a[j];
		}
	}
	/*
	 * Methode die das Array vom kleinsten zum gr��ten sortiert.
	 * Dabei benutzt es das "Sortieren durch Minimumsuchen"
	 * @param a Der zu sortierende Array
	 */
	public static void sortMinArray(int[] a) {
		for (int i = 0; i < a.length -1; i++) {
			int pos = 0;
			pos = getMinPos(a, i);
			swap(a, i, pos);
			
		}
	}
	/*
	 * Die Methode sortiert das array a von klein zu gro�, sucht nach doppelte und
	 * gibt dann ein neues array zur�ck ohne doppelte Zahlen
	 * @param a das zu verarbeitende Array
	 * @return Den von doppelte Zahlen freien Array
	 */
	public static int[] delDoppelte(int[] a, int length) {
		int j = 0;
		Arrays.sort(a);
		int[] ret = new int[length];
		for(int i = 0; i < a.length-1; i++) {
			if (a[i] != a[i+1]) {
				ret[j] = a[i];
				j++;
			}
		}
		return ret;
	}

}
