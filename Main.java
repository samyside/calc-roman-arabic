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
	final String[][] romanArr = 
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

	public String calc(String input) throws Exception {
		String result = null;
		String[] items = input.split(" ");
		// Проверить кол-во чисел для арифметики
		if (items.length > 3) throw new Exception("Too many parameters");
		else if (items.length < 3) throw new Exception("Too few parameters");

		final String A = items[0];
		final String B = items[2];
		int a = 0, b = 0;
		
		// Числа арабские или римские
		boolean romanNumber = false;
		if (romanNumber = isRomanNumber(A) && isRomanNumber(B)) {
			// Преобразовать римские в арабские
			a = parseRomanToArabic(A);
			b = parseRomanToArabic(B);
		} else if (isArabicNumber(A) && isArabicNumber(B)) {
			a = Integer.valueOf(A);
			b = Integer.valueOf(B);
		} else {
			throw new Exception("Not a number");
		}

		// Арифметическая операция над числами
		String operation = items[1];
		switch (operation) {
			case "+": result = addition(a, b); break;
			case "-": result = subtract(a, b); break;
			case "*": result = multiply(a, b); break;
			case "/": result = division(a, b); break;
			default: throw new Exception("Unable operation");
		}

		// Преобразовать в римские (при необходимости)
		romanNumber = false; // временная заглушка
		if (romanNumber) result = parseArabicToRoman(result);

		return result;
	}

	int parseRomanToArabic(String roman) {
		int arabic = 0;
		// roman = "MCCXIX";

		for (String[] strings : romanArr) {
			while (roman.startsWith(strings[0])) {
				roman = roman.replaceFirst(strings[0], "");
				arabic += Integer.valueOf(strings[1]);
			}
		}
		
		return arabic;
	}

	String parseArabicToRoman(String arabic) {
		//TODO Реализовать метод

		return null;
	}

	boolean isArabicNumber(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			e.getMessage();
			return false;
		}
	}

	boolean isRomanNumber(String num) {
		char[] romanNumbers = {'I','V','X','L','C','D','M'};
		int i = 0;
		for (char c : num.toCharArray()) {
			if (c != romanNumbers[i]) return false;
		}

		return true;
	}

	String addition(int a, int b) throws Exception {
		int result = a + b;
		//TODO Допустимы значения >3999 тольк для арабских чисел
		if (result > 3999) {
			throw new Exception("Result is too much");
		}
		return String.valueOf(result);
	}

	String subtract(int a, int b) throws Exception {
		int result = a - b;
		//TODO Допустимы отрицательные арабские числа, римские - нет
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
