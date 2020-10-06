package mypack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstProgram {
	/**
	 * Accept a number from keyboard
	 * 
	 * @return integer number
	 */
	public int acceptNumber() {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		boolean isValid = true;
		do {
			System.out.print("Enter x:");
			try {
				x = sc.nextInt();
				break;
			} catch (InputMismatchException ex) {
				isValid = false;
				System.out.println("Invalid number");
				sc.nextLine();
			}
		} while (!isValid);
		return x;
	}

	public static void main(String[] args) {
		FirstProgram obj = new FirstProgram();
		int x = obj.acceptNumber();
		int y = obj.acceptNumber();
		System.out.println("Result:" + (x + y));
	}
}
