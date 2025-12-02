/**
 * 
 */
package champions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * starting point of application
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<WinningTeam> winners = new ArrayList<WinningTeam>();
		String fileName = "champions_league_winners.csv";

		winners = loadFromCSV(fileName);
		displayMenu(sc, winners);

	}

	/**
	 * displays menu
	 * 
	 * @param sc
	 * @param winners
	 */
	private static void displayMenu(Scanner sc, ArrayList<WinningTeam> winners) {

		ArrayList<WinningTeam> results = new ArrayList<WinningTeam>();

		while (true) {

			System.out.println("\n======= CHAMPIONS LEAGUE DATABAS =======");
			System.out.println("1. Print all winners");
			System.out.println("2. Filter by team name");
			System.out.println("3. Filter by country");
			System.out.println("0. Exit");
			System.out.println();
			System.out.println("Choice:");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				Utilities.printAllWinners(winners);
				break;

			case 2:
				results = Utilities.filterByTeam(sc, winners);

				System.out.println();
				System.out.println("-------------------");

				if (results.size() == 0) {
					System.out.println();
					System.out.println("This team has never won!");
					System.out.println();
				} else {
					for (WinningTeam winningTeam : results) {
						System.out.println(winningTeam.toString());
					}
				}
				System.out.println("-------------------");
				System.out.println();
				break;

			case 3:
				results = Utilities.filterByCountry(sc, winners);

				System.out.println();
				System.out.println("-------------------");

				if (results.size() == 0) {
					System.out.println();
					System.out.println("No team from this country has ever won!");
					System.out.println();
				} else {
					for (WinningTeam winningTeam : results) {
						System.out.println(winningTeam.toString());
					}
				}

				System.out.println("-------------------");
				System.out.println();
				break;
			case 0:
				System.out.println();
				System.out.println("Thank you for using the Champions League Winners app! See you next time.");
				return;

			default:
				System.out.println("Invalid option");
				break;
			}

		}

	}

	/**
	 * read in file from CSV
	 * 
	 * @param fileName
	 * @return
	 */
	private static ArrayList<WinningTeam> loadFromCSV(String fileName) {

		ArrayList<WinningTeam> results = new ArrayList<WinningTeam>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;

			// skip header
			br.readLine();

			while ((line = br.readLine()) != null) {

				String[] parts = line.split(",");

				int year = Integer.parseInt(parts[0]);
				String teamName = parts[1].trim();
				String country = parts[2].trim();

				results.add(new WinningTeam(year, teamName, country));

			}

		} catch (Exception e) {
			System.out.println("There's been an error: " + e.getMessage());
		}

		return results;
	}

}
