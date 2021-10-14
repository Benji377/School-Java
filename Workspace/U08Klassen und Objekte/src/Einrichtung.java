// Programm für das Video!
// Bereits besprochen

public class Einrichtung {
	
	public static class Schrank {
		private String material;
		private double preis;
		private int AnzahlTeile;

		public String getMaterial() {
			return material;
		}

		public void setMaterial(String material) {
			this.material = material;
		}

		public double getPreis() {
			return preis;
		}

		public void setPreis(double preis) {
			this.preis = preis;
		}

		public int getAnzahlTeile() {
			return AnzahlTeile;
		}

		public void setAnzahlTeile(int anzahlTeile) {
			AnzahlTeile = anzahlTeile;
		}
	}
	
	public static class Stuhl {
		private String material;
		private double preis;
		private int AnzahlTeile;
		
		public String getMaterial() {
			return material;
		}
		public void setMaterial(String material) {
			this.material = material;
		}
		public double getPreis() {
			return preis;
		}
		public void setPreis(double preis) {
			this.preis = preis;
		}
		public int getAnzahlTeile() {
			return AnzahlTeile;
		}
		public void setAnzahlTeile(int anzahlTeile) {
			AnzahlTeile = anzahlTeile;
		}
		public static class Polsterung {
			private String material;
			private String farbe;
			
			public String getMaterial() {
				return material;
			}
			public void setMaterial(String material) {
				this.material = material;
			}
			public String getFarbe() {
				return farbe;
			}
			public void setFarbe(String farbe) {
				this.farbe = farbe;
			}
		}
	}
	

	public static void main(String[] args) {
		Einrichtung.Schrank klein = new Einrichtung.Schrank();
		Einrichtung.Schrank kasten = new Einrichtung.Schrank();
		Einrichtung.Stuhl modern = new Einrichtung.Stuhl();
		Einrichtung.Stuhl alt = new Einrichtung.Stuhl();
		
		
		klein.AnzahlTeile = 22;
		klein.material = "Holz";
		klein.preis = 345.99;
		System.out.println("KLEIN: Teile:"+klein.AnzahlTeile+", Material:"+klein.material+", Preis:"+klein.preis+"$");
		
		kasten.AnzahlTeile = 35;
		kasten.material = "Plastik";
		kasten.preis = 245.98;
		System.out.println("KASTEN: Teile:"+kasten.AnzahlTeile+", Material:"+kasten.material+", Preis:"+kasten.preis+"$");
		
		modern.AnzahlTeile = 5;
		modern.material = "Stahl";
		modern.preis = 1000.76;
		System.out.println("MODERN: Teile:"+modern.AnzahlTeile+", Material:"+modern.material+", Preis:"+modern.preis+"$");
		
		alt.AnzahlTeile = 12;
		alt.material = "Holz";
		alt.preis = 45.54;
		Einrichtung.Stuhl.Polsterung polster = new Einrichtung.Stuhl.Polsterung();
		polster.farbe = "Dunkelrot";
		polster.material = "Baumwolle";
		System.out.println("ALT: Teile:"+alt.AnzahlTeile+", Material:"+alt.material+", Preis:"+alt.preis+"$"+ 
				" POLSTER: Farbe:"+polster.farbe+", Material:"+polster.material);
	}
	
//	public static int vergleichen(Object first, Object second) {
//		return first.compareTo(second);
//	}
	
//	public static boolean istGleich (Object first, Object second) {
//		return first.equals(second);
//	}
	
//	public Object kopieren (Object eingabe) {
//		return eingabe.clone();
//	}

}


// Man darauf zugreifen weil eine getterMothode dfür existiert
