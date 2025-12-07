/**
 * 
 */
package channel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility methods for the TVGuide class
 */
public class Utilities {

	/**
	 * method displays all details for each show
	 * 
	 * @param shows
	 */
	public static void displayAllProgrammes(List<Programme> shows) {

		System.out.println(TVGuide.BOLD_TEXT + "ALL PROGRAMMES" + TVGuide.RESET_TEXT);
		System.out.println();

		for (Programme programme : shows) {
			programme.displayAll();
		}

	}

	/**
	 * method searches the shows List and prints the given shows details to the
	 * console if it exists.
	 * 
	 * @param title
	 * @param shows
	 */
	public static List<Programme> searchProgrammesByTitle(String title, List<Programme> shows) {

		List<Programme> results = new ArrayList<Programme>();

		for (Programme programme : shows) {
			if (programme.getName().equalsIgnoreCase(title)) {
				results.add(programme);
			}
		}

		return results;

	}

	/**
	 * method searches the shows List and prints the given broadcaster show details
	 * to the console if it exists.
	 * 
	 * @param broadcaster
	 * @param shows
	 * @return
	 */
	public static List<Programme> searchProgrammesByBroadcaster(String broadcaster, List<Programme> shows) {
		List<Programme> results = new ArrayList<Programme>();
		Broadcaster broadCasterENUM = null;

		switch (broadcaster.toUpperCase()) {
		case "BBC":
			broadCasterENUM = Broadcaster.BBC;
			break;
		case "ITV":
			broadCasterENUM = Broadcaster.ITV;
			break;
		case "CHANNEL 4":
			broadCasterENUM = Broadcaster.CHANNEL_4;
			break;
		case "NETFLIX":
			broadCasterENUM = Broadcaster.NETFLIX;
			break;
		case "AMAZON PRIME":
			broadCasterENUM = Broadcaster.AMAZON_PRIME;
			break;
		case "APPLE TV":
			broadCasterENUM = Broadcaster.APPLE_TV;
			break;
		case "HBO":
			broadCasterENUM = Broadcaster.HBO;
			break;
		default:
			broadCasterENUM = null;

		}

		for (Programme programme : shows) {
			if (programme.getBroadcaster().equals(broadCasterENUM)) {
				results.add(programme);
			}
		}

		return results;

	}

	/**
	 * methods returns the shows with rating greater than or equal to the given
	 * argument
	 * 
	 * @param ratingUpper
	 * @param shows
	 * @return
	 */
	public static List<Programme> searchProgrammesByRatingUpper(int ratingUpper, List<Programme> shows) {
		List<Programme> results = new ArrayList<Programme>();

		for (Programme programme : shows) {
			if (programme.getRating() >= ratingUpper) {
				results.add(programme);
			}
		}

		return results;
	}

	/**
	 * methods returns the shows with rating less than or equal to the given
	 * argument
	 * 
	 * @param ratingLower
	 * @param shows
	 * @return
	 */
	public static List<Programme> searchProgrammesByRatingLower(int ratingLower, List<Programme> shows) {
		List<Programme> results = new ArrayList<Programme>();

		for (Programme programme : shows) {
			if (programme.getRating() <= ratingLower) {
				results.add(programme);
			}
		}

		return results;
	}

	/**
	 * method sorts and returns an ArrayList of the sorted shows by rating (high -
	 * low)
	 * 
	 * @param shows
	 * 
	 * @return
	 */
	public static List<Programme> sortShowsByRatingHighToLow(List<Programme> shows) {

		List<Programme> results = new ArrayList<Programme>(shows);

		Collections.sort(results, new CompareProgrammeRatingHighToLow());

		return results;

	}

	/**
	 * method sorts and returns an ArrayList of the sorted shows by rating (low -
	 * high)
	 * 
	 * @param shows
	 * 
	 * @return
	 */
	public static List<Programme> sortShowsByRatingLowToHigh(List<Programme> shows) {
		
		List<Programme> results = new ArrayList<Programme>(shows);

		Collections.sort(results, new CompareProgrammeRatingLowToHigh());
 
		return results;
	}

	/**
	 * method sorts and returns an ArrayList of the sorted shows by average audience (high -
	 * low)
	 * 
	 * @param shows
	 * @return
	 */
	public static List<Programme> sortShowsByAverageAudienceHighToLow(List<Programme> shows) {
		
		List<Programme> results = new ArrayList<Programme>(shows);

		Collections.sort(results, new CompareProgrammeAverageAudienceHighToLow());

		return results;
		
	}
	
	
	/**
	 * method sorts and returns an ArrayList of the sorted shows by average audience (low -
	 * high)
	 * 
	 * @param shows
	 * @return
	 */
	public static List<Programme> sortShowsByAverageAudienceLowToHigh(List<Programme> shows) {
		
		List<Programme> results = new ArrayList<Programme>(shows);

		Collections.sort(results, new CompareProgrammeAverageAudienceLowToHigh());

		return results;
		
	}

}
