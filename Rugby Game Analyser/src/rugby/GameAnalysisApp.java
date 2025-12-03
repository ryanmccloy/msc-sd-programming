/**
 * 
 */
package rugby;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * analysing a set of rugby games provided from a CSV
 */
public class GameAnalysisApp {

	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	// array to hold rugby games
	public static List<RugbyGame> games = new ArrayList<RugbyGame>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("RUGBY GAME APP");
		System.out.println("--------------");
		System.out.println();

		readGamesFromCSV("Scores.csv");
		showMenu();

	}

	/**
	 * displays the menu options until the user quits application
	 */
	private static void showMenu() {
		Scanner sc = new Scanner(System.in);
		int choice;

		do {

			System.out.println(BOLD_TEXT);
			System.out.println("1. Display all results");
			System.out.println("2. Search results by country");
			System.out.println("3. Search results by winner");
			System.out.println("4. Print results to file");
			System.out.println("0. Quit");
			System.out.printf(RESET_TEXT);
			System.out.println("-----------------------------");
			System.out.println();
			System.out.println("Enter choice:");

			if (!sc.hasNextInt()) {
				System.out.println(RED_TEXT);
				System.out.println("Please enter a number:" + RESET_TEXT);
				sc.nextLine(); // discard invalid input
			}

			choice = sc.nextInt();
			sc.nextLine(); // clear new line
			System.out.println();

			switch (choice) {
			case 1:
				showAllResults(games);
				break;
			case 2:
				System.out.println("Enter the country you want to search for:");
				String country = sc.nextLine().trim();
				System.out.println();

				List<RugbyGame> resultsByCountry = searchResultsByCountry(country);

				for (RugbyGame game : resultsByCountry) {
					System.out.println(game.toString());
				}

				break;
			case 3:
				System.out.println("Enter the winner you want to search for:");
				String winner = sc.nextLine().trim();
				System.out.println();

				List<RugbyGame> resultsByWinner = searchResultsByWinner(winner);

				for (RugbyGame game : resultsByWinner) {
					System.out.println(game.toString());
				}

				break;
			case 0:
				System.out.println("----------------------------");
				System.out.println("Goodbye! See you next time :)");
				break;
			default:
				System.out.println("Invalid choice - try again.");
			}

		} while (choice != 0);

		sc.close();

	}

	/**
	 * searches and returns the results by winner
	 * 
	 * @param winner
	 * @return
	 */
	private static List<RugbyGame> searchResultsByWinner(String winner) {
		List<RugbyGame> results = new ArrayList<RugbyGame>();

		// safety check to prevent crashing
		if (winner == null || winner.isEmpty()) {
			System.err.println("Invalid country");
			return results;
		}

		for (RugbyGame game : games) {

			if (game.getWinner().equalsIgnoreCase(winner)) {
				results.add(game);
			}
		}

		if (results.size() == 0) {
			System.out.println(formatCountryText(winner) + " hasn't won any games ...");
		}

		return results;
	}

	/**
	 * searches and returns the results by country
	 * 
	 * @param country
	 */
	private static List<RugbyGame> searchResultsByCountry(String country) {

		List<RugbyGame> results = new ArrayList<RugbyGame>();

		// safety check to prevent crashing
		if (country == null || country.isEmpty()) {
			System.err.println("Invalid country");
			return results;
		}

		for (RugbyGame game : games) {

			if (game.getTeam1().equalsIgnoreCase(country) || game.getTeam2().equalsIgnoreCase(country)) {
				results.add(game);
			}
		}

		if (results.size() == 0) {
			System.out.println(formatCountryText(country) + " hasn't played any games ...");
		}

		return results;

	}

	/**
	 * displays all results to the console
	 * 
	 * @param games
	 */
	private static void showAllResults(List<RugbyGame> games) {

		for (RugbyGame game : games) {
			System.out.println(game.toString());
		}

	}

	/**
	 * reads games from a given path to a CSV, and stores as a RugbyGame object in
	 * the games ArrayList
	 * 
	 * @param string
	 */
	private static void readGamesFromCSV(String path) {

		File file = new File(path);
		String data;

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {

			// skip first line
			br.readLine();

			// add next line to string
			data = br.readLine();

			while (data != null) {

				RugbyGame game = new RugbyGame();

				// parse string into array
				String[] gameData = data.split(",");

				// add elements to RugbyGame class
				game.setTeam1(gameData[0]);

				try {
					game.setTeam1Score(Integer.parseInt(gameData[1]));
				} catch (NumberFormatException e) {
					System.err.println("Unable to read number :" + e.getMessage());
					data = br.readLine();
					continue;
				}

				game.setTeam2(gameData[2]);

				try {
					game.setTeam2Score(Integer.parseInt(gameData[3]));
				} catch (NumberFormatException e) {
					System.err.println("Unable to read number :" + e.getMessage());
					data = br.readLine();
					continue;
				}

				game.calculateWinner();

				// add class to ArrayList
				games.add(game);

				// read next line and add to data string
				data = br.readLine();

			}

		} catch (FileNotFoundException e) {
			System.err.println("File cannot be found! " + e.getMessage());

		} catch (IOException e) {
			System.err.println("Problem reading from file! " + e.getMessage());
		}

		System.out.println("File read complete");
		System.out.println("Number of games processed : " + games.size());
		System.out.println("-------------------------------");
		System.out.println();

	}

	/**
	 * formats the country to capitalise first letter
	 * 
	 * @param country
	 * @return
	 */
	public static String formatCountryText(String country) {

		StringBuilder result = new StringBuilder();
		result.append(country.substring(0, 1).toUpperCase());
		result.append(country.substring(1).toLowerCase());
		return result.toString();
	}

}
