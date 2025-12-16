/**
 * 
 */
package breeds;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * 
 */
public class Utilities {

	/**
	 * displays all the details of the given dogs List
	 * 
	 * @param dogs
	 */
	public static void showAllDetails(List<Dog> dogs) {

		for (Dog dog : dogs) {
			dog.displayAll();
		}

	}

	/**
	 * method orders the given dog list by height
	 * 
	 * @param dogs
	 */
	public static void orderBreedsByHeight(List<Dog> dogs) {

		Collections.sort(dogs, new OrderByHeight());

	}

	/**
	 * method orders the given dog list by weight
	 * 
	 * @param dogs
	 */
	public static void orderBreedsByWeight(List<Dog> dogs) {

		Collections.sort(dogs, new OrderByWeight());

	}

	/**
	 * method returns a map with the country key, and the number of breeds from the country as the value
	 * @param dogs
	 * @return
	 */
	public static Map<String, Integer> breedsByCountry(List<Dog> dogs) {

		Map<String, Integer> results = new TreeMap<String, Integer>();

		for (Dog dog : dogs) {

			String country = dog.getOriginCountry().toUpperCase();

			if (results.containsKey(country)) {
				results.put(country, (results.get(country) + 1));
			} else {
				results.put(country, 1);
			}

		}

		return results;

	}

}
