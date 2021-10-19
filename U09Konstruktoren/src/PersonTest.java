
public class PersonTest {

	public static void main(String[] args) {
		/**
		 *  Hiermit werden alle Personen der Reihe nach eingetragen, um den
		 *  in der Übung 9 abgebildeten Stammbaum festzulegen
		 */
		Person franz_amonn = new Person("Franz", "Amonn", false);
		Person astrid_prenn = new Person("Astrid", "Prenn", true);
		
		Person erwin_pircher = new Person("Erwin", "Pircher", false);
		Person edda_huber = new Person("Edd", "Huber", true);
		
		Person martin_seeber = new Person("Martin", "Seeber", false);
		Person resi_ruepel = new Person("Resi", "Rüpel", true);
		
		Person edi_greif = new Person("Edi", "Greif", false);
		Person anna_huber = new Person("Anna", "Huber", true);
		
		Person sepp_amonn = new Person("Sepp", "Amonn", false, franz_amonn, astrid_prenn);
		Person elsa_pircher = new Person("Elsa", "Pircher", true, erwin_pircher, edda_huber);
		
		Person hans_seeber = new Person("Hans", "Seeber", false, martin_seeber, resi_ruepel);
		Person berta_greif = new Person("Berta", "Greif", true, edi_greif, anna_huber);
		
		Person rudi_amonn = new Person("Rudi", "Amonn", false, sepp_amonn, elsa_pircher);
		Person anna_seeber = new Person("Anna", "Seeber", true, hans_seeber, berta_greif);
		
		Person adam_amonn = new Person("Adam", "Amonn", false, rudi_amonn, anna_seeber);
		
		// Der Name des Vaters von der Person adam_amonn wird ausgegeben
		System.out.print("Vater von " +adam_amonn.getName()+": ");
		System.out.println((adam_amonn.getVater()).getName());
		
		// Der Name des Großvaters mütterlicherseits von der Person rudi_amonn wird ausgegeben
		System.out.print("Großvaters mütterlicherseits von "+ rudi_amonn.getName()+": ");
		System.out.println(((rudi_amonn.getMutter()).getVater()).getName() + "\n");
		
		// Die Eltern der Person adam_amonn werden in ein Array gespeichert
		// und dann mit toString ausgegeben
		Person eltern[] = adam_amonn.getEltern();
		System.out.println("Eltern von " + adam_amonn.getName());
		System.out.println(eltern[0].toString() + eltern[1].toString());
		
		// Die Großeltern von der Person adam-amonn werden in ein Array gespeichert
		// und dann mit toString ausgegeben
		Person grosseltern[] = adam_amonn.getGrosseltern();
		System.out.println("Großeltern von "+ adam_amonn.getName());
		System.out.println(grosseltern[0].toString() + grosseltern[1].toString()
				+ grosseltern[2].toString() + grosseltern[3].toString());
		
		// Code um die Methode getListe() zu testen
		System.out.println(anna_seeber.getListe());
	}

}
