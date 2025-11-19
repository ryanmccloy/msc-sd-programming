/**
 * 
 */
package checker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * class checks if a user entered password is stored in rockyou.txt (not included in commit) Based on
 * this, it informs user if password is strong or weak
 */
public class PasswordChecker {

	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// variables
		String password;
		boolean passwordFound = false;
		File file = new File("rockyou.txt");

		System.out.println("Password Checker");
		System.out.printf("%s%s%s%n", BOLD_TEXT, "Enter a password to check for common usage", RESET_TEXT);

		// prompt user for input
		Scanner sc = new Scanner(System.in);
		password = sc.nextLine();

		// read contents of rockyou.txt and check password
		if (!file.exists()) {
			System.err.println("File doesn't exist!");
		} else {

			try {

				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				String line = bufferedReader.readLine();

				// read next line
				while (line != null && !passwordFound) {

					if (line.equals(password)) {
						passwordFound = true;
					}
					line = bufferedReader.readLine();
				}

				bufferedReader.close();
				fileReader.close();

			} catch (IOException e) {
				System.err.println("Problem with file!");
				e.printStackTrace();
			}

		}

		// output of result
		System.out.printf("%s%s%s%n", BOLD_TEXT, "Ok let's check that one...", RESET_TEXT);
		System.out.printf("%s%s%s%n", (!passwordFound ? GREEN_TEXT : RED_TEXT),
				(!passwordFound ? "Password not found! Could be a good one" : "Weak Password! Try another"),
				RESET_TEXT);

		// close scanner
		sc.close();

	}

}
