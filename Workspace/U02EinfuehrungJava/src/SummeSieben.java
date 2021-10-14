// Alle Vielfachen von 7 unter 1000 addieren und summe ausgeben
public class SummeSieben {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0;
		int b = 1000;
		int summe = 0;
		
		while (a <= b) {
			if (a%7 == 0) {
				summe += a;
			}
			a += 1;
		}
		System.out.println(summe);

	}

}
/**
Das Programm zählt alle Zahlen von 0 bis 1000 durch und versucht dabei
jede Zahl durch 7 zu teilen, wenn Rest raus kommt geht die Schleife einfach
weiter, wenn kein Rest raus kommt, wird die Zahl mit der Summe addiert.
Am Ende wird die Gesamtsumme ausgegeben.
*/