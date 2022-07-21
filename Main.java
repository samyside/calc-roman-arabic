import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter : ");
		String input = sc.nextLine();
		sc.close();

		String result = calc(input);
		System.out.println(result);
	}

	public static String calc(String input) throws Exception {
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
			case "+": add(a, b); break;
			case "-": minus(a, b); break;
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

	static int parseRomanToArabic(String number) {
		return 0;
	}

	static String parseArabicToRoman() {

		return null;
	}

	static boolean isRomanNumber(String a, String b) {

		return false;
	}

	static int add(int a, int b) throws Exception {
		int result = a + b;
		if (result > 3999) {
			throw new Exception("Result is too much");
		}
		return result;
	}

	static int minus(int a, int b) throws Exception {
		int result = a - b;
		if (result < 0) {
			throw new Exception("Result is too few");
		}
		return result;
	}

	static int multiply(int a, int b) throws Exception {
		int result = a * b;
		if (result > 3999) {
			throw new Exception("Result is too much");
		}
		return result;
	}

	static int division(int a, int b) throws Exception {
		int result = a / b;
		if (a % b > 0) {
			throw new Exception("Result should be Integer");
		}
		return result;
	}
}
