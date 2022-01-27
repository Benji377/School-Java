package net.tfobz.groesse;

public class TestSortierung {

	public static void main(String[] args) {
		Groesse[] g = new Groesse[10];
		g[0] = new Auto(4_000, 2_500, 1_500);
		g[1] = new Auto(5_600, 2_800, 1_000);
		g[2] = new Auto(2_200, 2_100, 1_800);
		
		g[3] = new Fussballfeld();
		g[4] = new Fussballfeld();
		
		g[5] = new Papierblatt(0);
		g[6] = new Papierblatt(1);
		g[7] = new Papierblatt(2);
		g[8] = new Papierblatt(3);
		g[9] = new Papierblatt(4);
		
		System.out.println("Ausgabe unsortiert:");
		for (int i = 0; i < g.length; i++)
			System.out.println(i + ". " + g[i].toString());
		
		sort(g);
		
		System.out.println("Ausgabe sortiert");
		for (int i = 0; i < g.length; i++)
			System.out.println(i + ". " + g[i].toString());
		
	}
	
	public static void sort(Groesse arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					Groesse temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
