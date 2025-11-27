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

/**
 * start point of application - read CSV file etc.
 */
public class JourneyPlanner {

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
		
		// 1. show all routes
		
		// 2. select a destination - show all routes to the destination
		
		// 0. Exit

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
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

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

			bufferedReader.close();
			fileReader.close();

	
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Problem reading from file");
		}

		System.out.println();
		System.out.println("Read complete");
		System.out.println("Number of bus routes stored: " + busRoutes.size());
	}

}
