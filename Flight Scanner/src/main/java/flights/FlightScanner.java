/**
 * Ryan McCloy
 */
package flights;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Application fetches and processes any flights currently overhead the stored
 * coordinates
 */
public class FlightScanner {

	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	/**
	 * Map to hold the users coordinates. These coordinates and range will be used
	 * to search for flights overhead
	 */
	private static Map<String, Double> coordinates = new HashMap<String, Double>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("WHAT FLIGHTS ARE OVERHEAD?");
		System.out.println("--------------------------");
		System.out.println();

		try {
			// get lat and long from config file
			getLatAndLong();
			delayThread(2000);
			
			// start new Thread for Empty Sky Message whilst initially searching for flights
			Thread t = new Thread(new EmptySkyThread());
			t.start();
			

			// get the flight data from the OpenSky API call
			JsonNode flightData = OpenSkyClient.getLiveFlights(coordinates.get("latitude"),
					coordinates.get("longitude"));

			// configure the JsonNode response
			List<String> parsedFlightData = configureFlightDataResponse(flightData);
			
			if (parsedFlightData != null) {
				t.interrupt();
				System.out.println(parsedFlightData.toString());
			} else {
				// start new Thread if no flights overhead
				t = new Thread(new EmptySkyThread());
				t.start();
			}
		

		} catch (Exception e) {
			System.err.println("Sorry there has been a problem: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("--------------------------");
		System.out.println("SEE YOU NEXT TIME! :)");

	}

	/**
	 * gets the latitude and longitude properties from the config file
	 */
	private static void getLatAndLong() {

		Properties prop = new Properties();

		System.out.println("Fetching cooridinates...");

		try (FileReader fr = new FileReader("config.properties"); BufferedReader br = new BufferedReader(fr)) {

			prop.load(br);

			String latitude = prop.getProperty("latitude");
			String longitude = prop.getProperty("longitude");
			String scanRange = prop.getProperty("scan_range");

			coordinates.put("latitude", Double.parseDouble(latitude));
			coordinates.put("longitude", Double.parseDouble(longitude));
			coordinates.put("range", Double.parseDouble(scanRange));

			System.out.println("Coordinates initialised!");
			System.out.println();
			System.out.println(GREEN_TEXT + "Latitude: " + latitude);
			System.out.println("Longitude: " + longitude);
			System.out.println(RESET_TEXT);
			System.out.println("--------------------------");
			System.out.println();

		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem reading from file: " + e.getMessage());
		}

	}

	/**
	 * method to simulate a delay in the thread
	 * 
	 * @param i
	 */
	private static void delayThread(int i) {

		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			System.err.println("Problem sleeping thread!");
			e.printStackTrace();
		}

	}

	/**
	 * method parses the JsonNode object into an ArrayList of strings containing the
	 * flight call sign
	 * 
	 * @param flightData
	 * @return
	 */
	private static List<String> configureFlightDataResponse(JsonNode flightData) {

		List<String> results = new ArrayList<String>();
		JsonNode statesNode = flightData.get("states");

		if (statesNode == null) {
			return null;
		}

		for (JsonNode flight : statesNode) {
			results.add(flight.get(1).asText().trim());
		}

		return results;

	}

}
