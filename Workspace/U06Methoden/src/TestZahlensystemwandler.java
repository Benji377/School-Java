
public class TestZahlensystemwandler {

	public static void main(String[] args) {
		System.out.println("Zahl von Zeichen 0 ist " + MeinZahlensystemwandler.getDigit('0'));
		System.out.println("Zahl von Zeichen 9 ist " + MeinZahlensystemwandler.getDigit('9'));
		System.out.println("Zahl von Zeichen A ist " + MeinZahlensystemwandler.getDigit('A'));
		System.out.println("Zahl von Zeichen Z ist " + MeinZahlensystemwandler.getDigit('Z'));
		System.out.println("Zahl von Zeichen a ist " + MeinZahlensystemwandler.getDigit('a'));
		System.out.println("Zahl von Zeichen z ist " + MeinZahlensystemwandler.getDigit('z'));
		System.out.println("Zahl von Zeichen # ist " + MeinZahlensystemwandler.getDigit('#'));
		
		System.out.println("Zeichen von Zahl 0 ist " + MeinZahlensystemwandler.getDigit(0));
		System.out.println("Zeichen von Zahl 9 ist " + MeinZahlensystemwandler.getDigit(9));
		System.out.println("Zeichen von Zahl 10 ist " + MeinZahlensystemwandler.getDigit(10));
		System.out.println("Zeichen von Zahl 35 ist " + MeinZahlensystemwandler.getDigit(35));
		System.out.println("Zeichen von Zahl -1 ist " + MeinZahlensystemwandler.getDigit(-1));
		
		System.out.println("Die Zahl 01110110 ist im Dezimalsystem: " + MeinZahlensystemwandler.numToDec("01110110", 2));
		System.out.println("Die Zahl 170712 ist im Dezimalsystem: " + MeinZahlensystemwandler.numToDec("170712", 8));
		System.out.println("Die Zahl 170712 ist im Dezimalsystem: " + MeinZahlensystemwandler.numToDec("170712", 7));
		System.out.println("Die Zahl 170712 ist im Dezimalsystem: " + MeinZahlensystemwandler.numToDec("170712", 6));
		
		System.out.println("Die Zahl 118 vom Dezimalsystem umgewandelt: " + MeinZahlensystemwandler.decToNum(118,2));
		System.out.println("Die Zahl 61898 vom Dezimalsystem umgewandelt: " + MeinZahlensystemwandler.decToNum(61898,8));
		System.out.println("Die Zahl 61898 vom Dezimalsystem umgewandelt: " + MeinZahlensystemwandler.decToNum(61898,1));
		System.out.println("Die Zahl -1 vom Dezimalsystem umgewandelt: " + MeinZahlensystemwandler.decToNum(-1,8));
	}

}
