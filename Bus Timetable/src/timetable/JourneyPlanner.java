/**
 * 
 */
package timetable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * start point of application - read CSV file etc.
 */
public class JourneyPlanner {

	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	// array to store bus routes
	public static List<BusRoute> busRoutes = new ArrayList<BusRoute>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Journey Planner Started");
		System.out.println("_______________________");

		try {
			readBusJourneys();

		} catch (Exception e) {
			System.out.println("Sorry - contact admin");
		}

		// show menu
		showMenu();

		System.out.println("_______________________");
		System.out.println();
		System.out.println("Journey Planner Closed");
	}

	/**
	 * reads and stores the bus journeys
	 */
	private static void readBusJourneys() {

		// access the CSV file
		File file = new File("routes.csv");
		String data;

		// read the CSV file
		try (FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {

			// skip first line / header
			bufferedReader.readLine();

			// start from line 2
			data = bufferedReader.readLine();

			while (data != null) {

				// parse
				String[] journeyParts = data.split(",");

				// create BusRoute object
				BusRoute busRoute = new BusRoute();

				// routeId,departureStop,arrivalStop,travelMinutes,operator

				busRoute.setRouteId(Integer.parseInt(journeyParts[0]));
				busRoute.setDeparture(journeyParts[1]);
				busRoute.setArrival(journeyParts[2]);
				busRoute.setTravelMinutes(Integer.parseInt(journeyParts[3]));

				switch (journeyParts[4]) {
				case "Ulsterbus":
					busRoute.setOperator(Operator.ULSTERBUS);
					break;
				case "Translink":
					busRoute.setOperator(Operator.TRANSLINK);
					break;
				case "Bus Eireann":
					busRoute.setOperator(Operator.BUS_EIREANN);
					break;
				default:
					busRoute.setOperator(Operator.OTHER);

				}

				// store in ArrayList
				busRoutes.add(busRoute);

				// read next line
				data = bufferedReader.readLine();

			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Problem reading from file");
		}

		System.out.println();
		System.out.println("Read complete");
		System.out.println("Number of bus routes stored: " + busRoutes.size());
		System.out.println();
		System.out.println("_______________________");
		System.out.println();
	}

	/**
	 * prints and displays menu to console
	 */
	private static void showMenu() {

		boolean showing = true;
		int userSelection;
		String destination;

		try (Scanner sc = new Scanner(System.in);) {

			do {
				System.out.println(BOLD_TEXT + GREEN_TEXT);
				System.out.println("1. Show all routes");
				System.out.println("2. Select a destination");
				System.out.println("0. Exit");
				System.out.println();
				System.out.println("Please enter the number of your selection:");
				System.out.println(RESET_TEXT);
				userSelection = sc.nextInt();
				sc.nextLine();
				System.out.println();
				
				

				switch (userSelection) {
				case 1:
					showAllRoutes(busRoutes);
					break;
				case 2:
					System.out.printf("%s%sPlease enter the destination you would like to search:%s%n", BOLD_TEXT,
							RED_TEXT, RESET_TEXT);
					destination = sc.nextLine();
					if (destination.trim().isBlank() || destination == null) {
						throw new IllegalArgumentException();
					}
					searchByDestination(busRoutes, destination);
					break;
				case 0:
					showing = false;
					break;
				default:
					throw new IllegalArgumentException();
				}

				System.out.println();

			} while (showing);

		} catch (IllegalArgumentException e) {
			System.out.println("Invalid input. Please try again");

		} 
	}

	/**
	 * displays all bus routes to console
	 * 
	 * @param routes
	 */
	private static void showAllRoutes(List<BusRoute> routes) {

		System.out.println("_______________________");
		System.out.println();
		System.out.println("ALL BUS ROUTES:");

		for (BusRoute route : routes) {
			route.displayAll();
		}

	}

	/**
	 * displays bus routes given user input destination
	 * 
	 * @param routes
	 */
	private static void searchByDestination(List<BusRoute> routes, String destination) {

		ArrayList<BusRoute> results = new ArrayList<BusRoute>();

		for (BusRoute route : routes) {

			if (route.getArrival().equals(destination)) {
				results.add(route);
			}
		}

		if (results.size() > 0) {

			for (BusRoute route : results) {
				route.displayAll();
			}

		} else {
			System.out.println();
			System.out.println("No bus routes to this destination. Sorry!");
		}

	}

}
