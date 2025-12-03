/**
 * 
 */
package race;

/**
 * thread for each racer in the 100 meter race
 */
public class RacerThread implements Runnable {

	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	private String name;
	private double time;

	/**
	 * assigning instance variables
	 * 
	 * @param name
	 * @param time
	 */
	public RacerThread(double time, String name) {
		this.time = time;
		this.name = name;
	}

	@Override
	public void run() {

		try {
			Thread.sleep((long) (time * 1000)); // converting time to milliseconds

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.printf("%s%s%s finished : %s%.3f%ss %n", BOLD_TEXT, name, RESET_TEXT, GREEN_TEXT, time, RESET_TEXT);

	}

}
