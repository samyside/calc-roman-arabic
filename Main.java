import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();

		Calc calculator = new Calc();

		String result = calculator.calc(input);
		System.out.println(result);
	}
}

class Calc {
	final String[][] ROMAN_ARRAY = 
	{
		{"M", "1000"},
		{"CM", "900"},
		{"D", "500"},
		{"CD", "400"},
		{"C", "100"},
		{"XC", "90"},
		{"L", "50"},
		{"XL", "40"},
		{"X", "10"},
		{"IX", "9"},
		{"V", "5"},
		{"IV", "4"},
		{"I", "1"}
	};
	boolean romanNumber = false;

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
		// romanNumber = false; // временная заглушка
		if (romanNumber) result = parseArabicToRoman(result);

		return result;
	}

	int parseRomanToArabic(String roman) {
		roman = roman.toUpperCase();
		int arabic = 0;

		for (String[] strings : ROMAN_ARRAY) {
			while (roman.startsWith(strings[0])) {
				roman = roman.replaceFirst(strings[0], "");
				arabic += Integer.valueOf(strings[1]);
			}
		}
		
		return arabic;
	}

	String parseArabicToRoman(String number) {
    	int arabic = Integer.valueOf(number);
        String roman = "";
        for (String[] num : ROMAN_ARRAY) {
            while (arabic >= Integer.valueOf(num[1])) {
                roman += num[0];
                arabic -= Integer.valueOf(num[1]);
            }
        }
        
		return roman;
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
		num = num.toUpperCase();
		String romanNumbers = "IVXLCDM";
		for (int i=0; i<num.length(); i++) {
			String str = String.valueOf(num.charAt(i));
			if (!romanNumbers.contains(str)) return false;
		}

		return true;
	}

	String addition(int a, int b) throws Exception {
		int result = a + b;
		if (result > 3999 && romanNumber) {
			throw new Exception("Result is too much for Roman number");
		}
		return String.valueOf(result);
	}

	String subtract(int a, int b) throws Exception {
		int result = a - b;
		if (result <= 0 && romanNumber) {
			throw new Exception("Result is too few for Roman number");
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
