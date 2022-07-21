import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter splited by spaces : ");
		String input = sc.nextLine();
		sc.close();

		String result = calc(input);
		System.out.println(result);
	}

	public static String calc(String input) {
		String[] items = input.split(" ");
		// Проверить кол-во чисел для арифметики
		// Числа арабские или римские
		// Преобразовать римские в арабские
		// Арифметическая операция над числами
		// Преобразовать в римские (при необходимости)
		int a = Integer.valueOf(items[0]);
		int b = Integer.valueOf(items[1]);

		return String.valueOf(a+b);
	}
}
