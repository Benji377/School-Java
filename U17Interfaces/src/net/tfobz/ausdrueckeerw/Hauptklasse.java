package net.tfobz.ausdrueckeerw;

public class Hauptklasse {

	public static void main(String[] args) {
		
		Operation o1 = new Addition(new Konstante(12), new Konstante(13));
		System.out.println(o1.toString());
		
		Operation o2 = new Subtraktion(new Konstante(25), new Konstante(13));
		System.out.println(o2.toString());
		
		Operation o3 = new Multiplikation(new Konstante(5), new Konstante(5));
		System.out.println(o3);
		
		Operation o4 = new Division(new Konstante(25), new Konstante(5));
		System.out.println(o4);
		
		Operation o5 = new Potenz(new Konstante(5), new Konstante(2));
		System.out.println(o5.toString());
		
		ArgOperation o6 = new Wurzel(new Konstante(16), new Argument(2));
		System.out.println(o6.toString());
		
		ArgOperation o7 = new Logarithmus(new Konstante(16), new Argument(10));
		System.out.println(o7.toString());
		
		Operation finale = new Potenz(
				new Division(
						new Multiplikation(
								new Konstante(3), 
								new Potenz(
										new Addition(
												new Konstante(6),
												new Konstante(7)),
										new Konstante(5))), 
						new Logarithmus(
								new Wurzel(
										new Addition(
												new Division(
														new Konstante(70), 
														new Konstante(4)), 
												new Division(
														new Konstante(990), 
														new Konstante(8))), 
										new Argument(2)), 
								new Argument(10)
								)), new Konstante(4));
		// Kontrolle: 
		System.out.println(finale.toString());
		System.out.println("(((3.0*((6.0+7.0=13.0)^5.0=371293.0)=1113879.0)/(Log(10.0,(Wurzel(2.0,((70.0/4.0=17" + 
				".5)+(990.0/8.0=123.75)=141.25))=11.884864324004713))=1.074994228245738)=1036172.074" + 
				"9121762)^4.0=1.1527298385505436E24)");
	}

}
