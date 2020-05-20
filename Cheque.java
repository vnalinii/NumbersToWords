package NumbersToWords;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Cheque {

	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Name: ");
		String name = scanner.nextLine();
		System.out.println("Enter the Amount: ");
		int amount = scanner.nextInt();
		if (amount < 0 || amount > 999999999) {
			System.out.println("*****Invalid amount*****");
			System.exit(0);
		}
		scanner.close();

		System.out.println();
		System.out.println("*********************************");
		System.out.println("						    " + dtf.format(now));
		System.out.println();
		System.out.println("Pay " + name + " ----------------------------");
		// System.out.println("Rupees SIXTY SEVEN THOUSAND HUNDRED AND NINTY ONLY
		// "+numberToWord(amount));
		System.out.println("Rupees " + numberToWord(amount) + " ONLY-------------------");
		System.out.println();
		System.out.println("----------------------------------- Rs. " + amount + "/- ");

		System.out.println();

	}

	private static String numberToWord(int number) {
		// variable to hold string representation of number
		String words = "";
		String unitsArray[] = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
				"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
		String tensArray[] = { "Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
				"Ninety" };

		if (number == 0) {
			return "Zero";
		}
		
		// add minus before conversion if the number is less than 0
		if (number < 0) {
			// convert the number to a string
			String numberStr = "" + number;
			// remove minus before the number
			numberStr = numberStr.substring(1);
			// add minus before the number and convert the rest of number
			return "" + numberToWord(Integer.parseInt(numberStr));
		}
		// check if number is divisible by 1 million
		if ((number / 1000000) > 0) {
			words += numberToWord(number / 1000000) + " Million ";
			number %= 1000000;
		}
		// check if number is divisible by 1 thousand
		if ((number / 1000) > 0) {
			words += numberToWord(number / 1000) + " Thousand ";
			number %= 1000;
		}
		// check if number is divisible by 1 hundred
		if ((number / 100) > 0) {
			words += numberToWord(number / 100) + " Hundred ";
			number %= 100;
		}

		if (number > 0) {
			// check if number is within teens
			if (number < 20) {
				// fetch the appropriate value from unit array
				words += unitsArray[number];
			} else {
				// fetch the appropriate value from tens array
				words += tensArray[number / 10];
				if ((number % 10) > 0) {
					words += "-" + unitsArray[number % 10];
				}
			}
		}
		return words;
	}

}
