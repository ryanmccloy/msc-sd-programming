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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class JouneyPlanner {

	public static List<BusRoute> busRoutes = new ArrayList<BusRoute>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Joureny Planner started ");
		System.out.println();

		try {
			readBusJourneys();

		} catch (Exception e) {
			System.out.println("Sorry - connat admin");
		}

		// show menu
		drawMenu();

		
		System.out.println();
		System.out.println("Joureny Planner app close ");
	}

	/**
	 * reads and stores the bus journeys
	 */
	private static void readBusJourneys() {

		// access the csv file
		File file = new File("routes.csv");
		String data;

		// read the csv file
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// skip the first line / header
			bufferedReader.readLine();

			data = bufferedReader.readLine();
//			System.out.println(data);

			while (data != null) {

				// parse
				String[] journeyParts = data.split(",");
//				System.out.println(Arrays.toString(journeyParts));

				// create a BusRoute object
				BusRoute busRoute = new BusRoute();

				// routeId,departureStop,arrivalStop,travelMinutes,operator

				try {
					busRoute.setRouteId(Integer.parseInt(journeyParts[0]));
				} catch (NumberFormatException e) {
					System.out.println("Unable to read number");
					data = bufferedReader.readLine();
					continue;
				}

				busRoute.setDeparture(journeyParts[1]);
				busRoute.setArrival(journeyParts[2]);
				busRoute.setTravelMinutes(Integer.parseInt(journeyParts[3]));

				// op - Ulster ULSTERBUS, IF / SWITCH
				switch (journeyParts[4]) {
				case "Translink":
					busRoute.setOperator(Operator.TRANSLINK);
					break;
				case "Ulsterbus":
					busRoute.setOperator(Operator.ULSTERBUS);
					break;
				case "Bus Eireann":
					busRoute.setOperator(Operator.BUS_EIREANN);
					break;
				default:
					busRoute.setOperator(Operator.OTHER);
					break;
				}

//				busRoute.displayAll();
				// store in arraylist
				busRoutes.add(busRoute);

				data = bufferedReader.readLine();
			}

			bufferedReader.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Problem reading from file");
		}

		System.out.println("Read complete");
		System.out.println("Number of bus routes stored : " + busRoutes.size());
		System.out.println();

	}

	/**
	 * 
	 */
	public static void drawMenu() {
		System.out.println("Menu");

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n___________________________");
			System.out.println();
			System.out.println("Route menu");
			System.out.println("1. Show all routes");
			System.out.println("2. Search for destination");
			System.out.println("0. Quit");
			System.out.println();
			System.out.print("Enter choice: ");

			// check for int entry
			while (!sc.hasNextInt()) {
				System.out.println("Please enter a number:");
				sc.next(); // discard invalid input
			}

			choice = sc.nextInt();
			sc.nextLine(); // clear newline

			switch (choice) {
			case 1:
				displayBusRoutes();
				break;
			case 2:

				System.out.print("Enter destination to search for: ");
				String dest = sc.nextLine().trim();

				List<BusRoute> routes = searchRouteByDestination(dest);

				if (routes.size() == 0) {
					System.out.println();
					System.out.println("No bus routes to " + dest);
				} else {
					for (BusRoute busRoute : routes) {
						busRoute.displayAll();
					}
				}

				break;
			case 0:
				System.out.println("Goodbye!");
				;
				break;
			default:
				System.out.println("Invalid choice - try again.");
				break;
			}

		} while (choice != 0);

		sc.close();

	}

	/**
	 * displays all bus routes
	 */
	public static void displayBusRoutes() {
		System.out.println("All Bus Routes _______________");

		for (BusRoute busRoute : busRoutes) {
			busRoute.displayAll();
		}

	}

	/**
	 * return the bus routes by destination
	 * 
	 * @param destination
	 * @return
	 */
	public static List<BusRoute> searchRouteByDestination(String dest) {

		List<BusRoute> results = new ArrayList<BusRoute>();

		for (BusRoute busRoute : busRoutes) {

			if (busRoute.getArrival().equalsIgnoreCase(dest)) {
				results.add(busRoute);
			}

		}

		return results;

	}

}
