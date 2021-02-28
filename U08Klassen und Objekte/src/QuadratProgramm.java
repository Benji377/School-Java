import java.util.Arrays;

public class QuadratProgramm {

	public static void main(String[] args) {
		Quadrat[] quadrate = new Quadrat[50];
		Quadrat temp = new Quadrat();
		System.out.println("Seitenlänge:");
		for (int i = 0; i < quadrate.length; i++) {
			quadrate[i] = new Quadrat();
			quadrate[i].setSeiteA(Math.random()*10);
			System.out.print(i+1 + "= "+quadrate[i].getSeiteA()+"; ");
		}
		for (int i = 0; i < quadrate.length; i++) {
			for (int j = i+1; j < quadrate.length; j++) {
				if(quadrate[i].getSeiteA() > quadrate[j].getSeiteA()) {
					temp = quadrate[i];
					quadrate[i] = quadrate[j];
					quadrate[j] = temp;
				}
			}
		}
		Quadrat max = new Quadrat();
		max = quadrate[quadrate.length-1];
		System.out.println();
		System.out.println("Größte Quadrat: "+max.toString());
	}

}
