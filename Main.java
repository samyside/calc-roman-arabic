import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter : ");
		String input = sc.nextLine();
		sc.close();

		Calc calculator = new Calc();

		String result = calculator.calc(input);
		System.out.println(result);
	}
}

class Calc {
	public String calc(String input) throws Exception {
		String result = null;
		String[] items = input.split(" ");
		// Проверить кол-во чисел для арифметики
		if (items.length > 3) throw new Exception("Too many parameters");
		int a = 0, b = 0;
		
		// Числа арабские или римские
		boolean numberRoman = false;
		if (numberRoman = isRomanNumber("", "")) {
			// Преобразовать римские в арабские
			a = parseRomanToArabic(items[0]);
			b = parseRomanToArabic(items[2]);
		} else {
			a = Integer.valueOf(items[0]);
			b = Integer.valueOf(items[2]);
		}

		// Арифметическая операция над числами
		String operation = items[1];
		switch (operation) {
			case "+": addtion(a, b); break;
			case "-": subtract(a, b); break;
			case "*": multiply(a, b); break;
			case "/": division(a, b); break;
			default: throw new Exception("Unable operation");
		}

		// Преобразовать в римские (при необходимости)
		if (numberRoman) {
			result = parseArabicToRoman();
		}

		return result;
	}

	int parseRomanToArabic(String number) {
		String[][] romanNumbers = new String[][] {
			{"I", "1"},
			{"V", "5"},
			{"X", "10"},
			{"L", "50"},
			{"C", "100"},
			{"D", "500"},
			{"M", "1000"}
		};
		// MCCXIIX

		//associative array
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "I");
		map.put("4", "IV");
		map.put("5", "V");
		map.put("9", "IX");
		map.put("10", "X");
		map.put("50", "L");
		map.put("100", "C");
		map.put("500", "D");
		map.put("1000", "M");
		
		return 0;
	}

	String parseArabicToRoman() {

		return null;
	}

	boolean isRomanNumber(String a, String b) {

		return false;
	}

	int addtion(int a, int b) throws Exception {
		int result = a + b;
		if (result > 3999) {
			throw new Exception("Result is too much");
		}
		return result;
	}

	int subtract(int a, int b) throws Exception {
		int result = a - b;
		if (result < 0) {
			throw new Exception("Result is too few");
		}
		return result;
	}

	int multiply(int a, int b) throws Exception {
		int result = a * b;
		if (result > 3999) {
			throw new Exception("Result is too much");
		}
		return result;
	}

	int division(int a, int b) throws Exception {
		int result = a / b;
		if (a % b > 0) {
			throw new Exception("Result should be Integer");
		}
		return result;
	}
}
