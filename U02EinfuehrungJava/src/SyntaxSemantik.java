
public class SyntaxSemantik {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int i = 0;
		while (i <= n) {
			int j = 0;
			while (j <= i) {
				System.out.print(j);
				// Hinzugefügte Änderung: j += 1;
				j += 1;
			}
			System.out.println();
			// Hinzugefügte Änderung: i += 1;
			i += 1;
		}

	}

}
