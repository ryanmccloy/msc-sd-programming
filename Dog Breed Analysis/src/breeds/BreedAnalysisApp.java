/**
 * 
 */
package breeds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Application reads dog breed data from a CSV file, instantiates the data in a
 * Dog instance, and then stores each instance in an ArrayList. A menu is shown
 * to allow the user to display all details, order by height or weight, and
 * group by country of origin
 */
public class BreedAnalysisApp {

	// ArrayList to hold all dog instances
	public static final List<Dog> dogs = new ArrayList<Dog>();

	// CSV file path
	private static final String CSV_FILE_NAME = "DogData.csv";

	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	/**
	 * start point for application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("DOG BREED ANALYSIS");
		System.out.println("------------------");
		System.out.println();

		try {

			readFromCSV();
			showMenu();

		} catch (Exception e) {
			System.err.println("Sorry there has been an error. Please contact the admin!");
		}

		System.out.println();
		System.out.println("------------------");
		System.out.println("APPLICATION CLOSED");

	}

	/**
	 * method reads all dog data from a CSV, storing the data within a Dog instance,
	 * and then storing in the dogs ArrayList
	 */
	private static void readFromCSV() {

		File file = new File(CSV_FILE_NAME);
		int skipped = 0;

		System.out.println("Importing dog data...");

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {

			String data;

			br.readLine(); // clear header

			while ((data = br.readLine()) != null) {

				Dog dog = new Dog();
				String[] breedData = data.split(",");

				// breed
				dog.setBreed(breedData[0].trim());

				// weight
				try {
					dog.setWeight(Double.parseDouble(breedData[1]));
				} catch (NumberFormatException e) {
					System.err.println("Problem reading weight! Skipping " + breedData[0].toUpperCase());
					skipped++;
					continue;
				}

				// height
				try {
					dog.setHeight(Double.parseDouble(breedData[2]));
				} catch (NumberFormatException e) {
					System.err.println("Problem reading height! Skipping " + breedData[0].toUpperCase());
					skipped++;
					continue;
				}

				// lifeExpectancy
				try {
					dog.setLifeExpectancy(Double.parseDouble(breedData[3]));
				} catch (NumberFormatException e) {
					System.err.println("Problem reading life expectancy! Skipping " + breedData[0].toUpperCase());
					skipped++;
					continue;
				}

				// colour
				dog.setColor(breedData[4].trim());

				// originCountry
				dog.setOriginCountry(breedData[5].trim());

				// add Dog instance to ArrayList
				dogs.add(dog);

			}

		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem reading from file: " + e.getMessage());
		}

		// statistics
		System.out.println("Dog breeds processed: " + GREEN_TEXT + dogs.size() + RESET_TEXT);
		if (skipped > 0) {
			System.out.println("Dog breeds skipped: " + RED_TEXT + skipped + RESET_TEXT);
		}
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println();

	}

	/**
	 * prints user menu to the console and handles user choice
	 */
	private static void showMenu() {

		// set up
		Scanner sc = new Scanner(System.in);
		int choice;

		// show menu and process input
		do {

			// small delay to allow user time to see output before menu is displayed again
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// menu
			System.out.println(GREEN_TEXT + "1. Show all");
			System.out.println("2. Order and show by height (smallest first)");
			System.out.println("3. Order and show by weight (heaviest first)");
			System.out.println("4. Group and show by country (frequency of breeds from each country)");
			System.out.println("0. Exit");
			System.out.println();
			System.out.println("Please enter your choice:");
			System.out.println(RESET_TEXT);

			// handle invalid input
			while (!sc.hasNextInt()) {
				System.out.println("Please enter a number...");
				sc.nextLine(); // clear invalid input
				System.out.println();
			}

			// capture user selection
			choice = sc.nextInt();
			sc.nextLine(); // clear rest of line
			System.out.println();

			// process user choice
			switch (choice) {
			case 1:
				System.out.println("ALL BREEDS DETAILS");
				System.out.println();
				Utilities.showAllDetails(dogs);
				break;
			case 2:
				System.out.println("ALL BREEDS BY HEIGHT (LOW TO HIGH)");
				System.out.println();
				Utilities.orderBreedsByHeight(dogs);
				Utilities.showAllDetails(dogs);
				break;
			case 3:
				System.out.println("ALL BREEDS BY WEIGHT (LOW TO HIGH)");
				System.out.println();
				Utilities.orderBreedsByWeight(dogs);
				Utilities.showAllDetails(dogs);
				break;
			case 4:
				System.out.println("BREEDS FROM EACH COUNTRY");
				System.out.println();
				Map<String, Integer> countryStatistics = Utilities.breedsByCountry(dogs);
				
				for (String country : countryStatistics.keySet()) {
					System.out.printf("%-16s:   %d%n", country, countryStatistics.get(country));
				}
				System.out.println();
				break;
			case 0:
				System.out.println("See you next time! :)");
				System.out.println();
				break;
			default:
				System.out.println("Invalid choice. Please try again...");
			}

		} while (choice != 0);

		// close scanner
		sc.close();

	}

//	
//	Please select an option:
//		1. Show all
//		2. Order and show by height (smallest first)
//		3. Order and show by weight (heaviest first)
//		4. Group and show by country (frequency of breeds from each country)
//		5. Exit

}
