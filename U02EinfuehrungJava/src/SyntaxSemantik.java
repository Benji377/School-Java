
public class SyntaxSemantik {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int i = 0;
		while (i <= n) {
			int j = 0;
			while (j <= i) {
				System.out.print(j);
				// Hinzugef�gte �nderung: j += 1;
				j += 1;
			}
			System.out.println();
			// Hinzugef�gte �nderung: i += 1;
			i += 1;
		}

	}

}
