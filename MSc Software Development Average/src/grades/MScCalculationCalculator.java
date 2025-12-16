/**
 * Ryan McCloy
 */
package grades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class calculates my average grade over all modules to get my current
 * classification
 */
public class MScCalculationCalculator {

	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	/**
	 * ArrayList to store module objects
	 */
	public static List<Module> modules = new ArrayList<Module>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Programming results. Map key is the assessment, and the array contains the
		 * marks attained, followed by the total marks available
		 */
		Map<Integer, int[]> programmingResults = new TreeMap<Integer, int[]>();
		int[] programmingP1 = { 9, 10 };
		int[] programmingP2 = { 10, 10 };
		int[] programmingP3 = { 28, 30 };
		int[] programmingP4 = { 35, 50 };
		programmingResults.put(1, programmingP1);
		programmingResults.put(2, programmingP2);
		programmingResults.put(3, programmingP3);
		programmingResults.put(4, programmingP4); // update once official result received

		/**
		 * Computing foundations results. Map key is the assessment, and the array
		 * contains the marks attained, followed by the total marks available
		 */
		Map<Integer, int[]> computingFoundationsResults = new TreeMap<Integer, int[]>();
		int[] computingFoundationsP1 = { 30, 30 };
		int[] computingFoundationsP2 = { 60, 70 };
		computingFoundationsResults.put(1, computingFoundationsP1);
		computingFoundationsResults.put(2, computingFoundationsP2); // update once official result received

		// Databases

		// Web Development

		// Software Engineering

		// create module instances
		Module programming = new Module("Programming", true, programmingResults);
		Module computingFoundations = new Module("Computing Foundations", false, computingFoundationsResults);

		// add modules to ArrayList
		modules.add(programming);
		modules.add(computingFoundations);

		// calculate each modules average, total module weights, and the course average
		calculateModuleAverage();
		int moduleWeights = calculateModuleWeights(modules);
		double courseAverage = calculateCourseAverage(moduleWeights);

		// display all details
		displayAllModules();
		displayCourseAverage(courseAverage);

	}

	/**
	 * method calculates the average for each module
	 */
	private static void calculateModuleAverage() {

		for (Module module : modules) {
			module.calculateAverage();
		}

	}

	/**
	 * method displays all module details to the console
	 */
	private static void displayAllModules() {

		System.out.println(BOLD_TEXT + "MSc Software Development 25/26" + RESET_TEXT);
		System.out.println();
		System.out.println();
		
		for (Module module : modules) {
			module.displayAll();
		}

	}

	/**
	 * calculates the overall average of the course and the classification received
	 */
	private static double calculateCourseAverage(int weights) {

		double totalAverage = 0;

		for (Module module : modules) {
			if (module.isDoubleWeighted()) {
				totalAverage += (module.getAverage() * 2);
			} else {

				totalAverage += module.getAverage();
			}
		}

		return totalAverage / weights;

	}

	/**
	 * calculates total modules weighting to divide by to get the course average
	 * 
	 * @param modules2
	 * @return
	 */
	private static int calculateModuleWeights(List<Module> modules) {

		int total = 0;

		for (Module module : modules) {

			total += (module.isDoubleWeighted() ? 2 : 1);

		}

		return total;
	}

	/**
	 * displays the course average to the console
	 * 
	 * @param calculateCourseAverage
	 */
	private static void displayCourseAverage(double courseAverage) {

		int roundedAverage = (int) Math.round(courseAverage);
		String classification;

		if (roundedAverage >= 0 && roundedAverage <= 50) {
			classification = "Fail";
		} else if (roundedAverage >= 50 && roundedAverage <= 60) {
			classification = "Pass";
		} else if (roundedAverage >= 60 && roundedAverage <= 70) {
			classification = "Merit";
		} else if (roundedAverage >= 70 && roundedAverage <= 100) {
			classification = "Distinction";
		} else {
			classification = "Error";
		}

		System.out.println(BOLD_TEXT + "COURSE AVERAGE" + RESET_TEXT);
		System.out.println();
		System.out.printf("%s%.2f%s\t:  %s%s%n", GREEN_TEXT, courseAverage, "%", classification.toUpperCase(), RESET_TEXT);
		System.out.println();

	}

}
