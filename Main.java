import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String input = "XII + VI";
		System.out.println("enter : " + input);
		// String input = sc.nextLine();
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
		if (numberRoman = isRomanNumbers("", "")) {
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
			case "+": result = addtion(a, b); break;
			case "-": result = subtract(a, b); break;
			case "*": result = multiply(a, b); break;
			case "/": result = division(a, b); break;
			default: throw new Exception("Unable operation");
		}

		// Преобразовать в римские (при необходимости)
		numberRoman = false; // временная заглушка
		if (numberRoman) {
			result = parseArabicToRoman();
		}

		return result;
	}

	int parseRomanToArabic(String roman) {
		int arabic = 0;

		// for test only
		// roman = "MCCXIX";

		String[][] romanArr = 
		{
			{"M", "1000"},
			{"MC", "900"},
			{"D", "500"},
			{"DC", "400"},
			{"C", "100"},
			{"CX", "90"},
			{"L", "50"},
			{"LX", "40"},
			{"X", "10"},
			{"IX", "9"},
			{"V", "5"},
			{"IV", "4"},
			{"I", "1"}
		};

		for (String[] strings : romanArr) {
			while (roman.startsWith(strings[0])) {
				roman = roman.replaceFirst(strings[0], "");
				arabic += Integer.valueOf(strings[1]);
			}
		}
		
		return arabic;
	}

	String parseArabicToRoman() {

		return null;
	}

	boolean isRomanNumbers(String a, String b) {
		return isRoman(a) && isRoman(b) ? true : false;
	}

	boolean isRoman(String num) {
		char[] romanNumbers = {'I','V','X','L','C','D','M'};
		int i = 0;
		for (char c : num.toCharArray()) {
			if (c != romanNumbers[i]) return false;
		}

		return true;
	}

	String addtion(int a, int b) throws Exception {
		int result = a + b;
		if (result > 3999) {
			throw new Exception("Result is too much");
		}
		return String.valueOf(result);
	}

	String subtract(int a, int b) throws Exception {
		int result = a - b;
		if (result < 0) {
			throw new Exception("Result is too few");
		}
		return String.valueOf(result);
	}

	String multiply(int a, int b) throws Exception {
		int result = a * b;
		if (result > 3999) {
			throw new Exception("Result is too much");
		}
		return String.valueOf(result);
	}

	String division(int a, int b) throws Exception {
		int result = a / b;
		if (a % b > 0) {
			throw new Exception("Result should be Integer");
		}
		return String.valueOf(result);
	}
}
