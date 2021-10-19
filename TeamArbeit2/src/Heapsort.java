/*
 *  Heapsort ist Selectionsort ähnlich, man nimmt zuerst das kleinste Element
 *  und platzietrt es am Anfang. Dann macht man das gleiche für die restlichen Elemente
 */

public class Heapsort {
	
	public void sort(int arr[]) {
		int n = arr.length;
		// Baut den heap auf indem es die erste Hälfte des Arrays nimmt
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// Extrahiert einzeln jedes Element vom Heap
		for (int i = n - 1; i > 0; i--) {
			// Aktuelle Wurzel wird ans Ende verschoben und heap wird verkleinert
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			// Ruft heap nochmals auf den verkleinerten heap auf
			heapify(arr, i, 0);
		}
	}
	// Heap wird ausgeführt, dabei fängt man von der Wurzel an und ermittelt die Äste
	// Kann man sich auch als umgekehrtes Baumschema vorstellen
	void heapify(int arr[], int n, int i) {
		int largest = i; // Größte wird zur Wurzel
		int l = 2 * i + 1; // linker Ast = 2*i + 1
		int r = 2 * i + 2; // rechter Ast = 2*i + 2

		// Wenn linker Ast größer als die Wurzel
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// Wenn rechter Ast größer als Wurzel
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// Wenn der größte nicht die Wurzel ist
		if (largest != i) {
			// wird mit größtem ausgetauscht
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Rekursiver Sortieraufruf
			heapify(arr, n, largest);
		}
	}
}
