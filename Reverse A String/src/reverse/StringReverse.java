/**
 * 
 */
package reverse;

import java.util.Scanner;

/**
 * class reverses a given string
 */
public class StringReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 1. setup
		Scanner sc = new Scanner(System.in);

		System.out.println("STRING REVERSAL");
		System.out.println("---------------");
		System.out.println();
		System.out.println("Please enter the string you want to reverse:");
		System.out.println();

		// 2. Get input & reversal logic
		String originalInput = sc.nextLine();
		StringBuilder sb = new StringBuilder(originalInput);
		String reversedString = sb.reverse().toString();
		
		// 3. Palindrome check
		boolean isPalindrome = originalInput.equalsIgnoreCase(reversedString);
		
		// 4. Output results to console
		System.out.println("REVERSED STRING:");
		System.out.println(reversedString);
		System.out.println();
		System.out.println(isPalindrome ? "Your string is a palindrome!" : "Your string is NOT a palindrome!");
		
		
		// 5. Cleanup
		sc.close();

	}

}
