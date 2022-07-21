import java.util.Scanner;
import java.util.Arrays;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter splited by spaces : ");
		String input = sc.nextLine();

		String result = calc(input);
		System.out.println(result);
	}

	public static String calc(String input) {
		String[] items = input.split(" ");

		return Arrays.toString(items);
	}
}
