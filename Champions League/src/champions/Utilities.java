/**
 * 
 */
package champions;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */
public class Utilities {

	/**
	 * prints all winners to the console
	 * 
	 * @param winners
	 */
	public static void printAllWinners(ArrayList<WinningTeam> winners) {

		System.out.println();
		System.out.println("ALL WINNING TEAMS");
		System.out.println("-------------------");

		for (WinningTeam winningTeam : winners) {
			System.out.println(winningTeam.getYear() + " : " + winningTeam.getName());
		}

		System.out.println("-------------------");
		System.out.println();

	}

	/**
	 * filters winners by team
	 * 
	 * @param sc
	 * @param winners
	 * @return
	 */
	public static ArrayList<WinningTeam> filterByTeam(Scanner sc, ArrayList<WinningTeam> winners) {

		ArrayList<WinningTeam> result = new ArrayList<WinningTeam>();

		System.out.println("Which team do you want to filter by?");
		String team = sc.nextLine();

		for (WinningTeam winningTeam : winners) {

			if (winningTeam.getName().equalsIgnoreCase(team)) {
				result.add(winningTeam);
			}

		}

		return result;
	}
 
	/**
	 * filters winners by country
	 *  
	 * @param sc
	 * @param winners
	 * @return
	 */
	public static ArrayList<WinningTeam> filterByCountry(Scanner sc, ArrayList<WinningTeam> winners) {
		
		ArrayList<WinningTeam> result = new ArrayList<WinningTeam>();

		System.out.println("Which country do you want to filter by?");
		String country = sc.nextLine();

		for (WinningTeam winningTeam : winners) {

			if (winningTeam.getNationality().equalsIgnoreCase(country)) {
				result.add(winningTeam);
			}

		}

		return result;
	}

}
