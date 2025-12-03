/**
 * 
 */
package race;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * app simulates the 2016 100 meters race
 */
public class RaceStart {

	public static SortedMap<Double, String> runners = new TreeMap<Double, String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		runners.put(9.810, "BOLT");
		runners.put(9.890, "GATLIN");
		runners.put(9.910, "DE GRASSE");
		runners.put(9.930, "BLAKE");
		runners.put(9.940, "SIMBINE");
		runners.put(9.960, "MEITE");
		runners.put(10.040, "VICAUT");
		runners.put(10.060, "BROMWELL");

		System.out.println("2016 Olympic 100 meters race simulator");
		System.out.println("--------------------------------------");

		System.out.println();
		System.out.println("Press enter to start the race ...");
		sc.nextLine();

		// starting race
		startRaceCountdown();
		System.out.println();
		startRunners();

	}

	/**
	 * start the runners timers
	 */
	private static void startRunners() {
		// loop over map, and start a thread for each racer
		for (Double time : runners.keySet()) {
			RacerThread athlete = new RacerThread(time, runners.get(time));
			Thread thread = new Thread(athlete);
			thread.start();

		}

	}

	/**
	 * Race count down
	 */
	public static void startRaceCountdown() {
		try {
			System.out.println("ON YOUR MARKS ...");
			Thread.sleep(3000);

			System.out.println("GET SET ...");
			Thread.sleep(3000);

			System.out.println("BANG!");

			System.out.println();
			System.out.println("Race started ...");

		} catch (InterruptedException e) {
			System.err.println("Problem starting race!");
			e.printStackTrace();
		}
	}

}
