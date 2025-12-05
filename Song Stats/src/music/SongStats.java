/**
 * 
 */
package music;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * class reads songs from a CSV and stores them in a Song object within an
 * ArrayList. A menu is printed for the user to analyse the given songs
 */
public class SongStats {
	
	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	public static List<Song> songs = new ArrayList<Song>();

	/**
	 * start point of application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Song Statistics Appliation Started");
		System.out.println("----------------------------------");
		System.out.println();

		try {
			readFromCSV("songlist.csv");
			showMenu();

		} catch (Exception e) {
			System.err.println("Sorry there has been an error! Please contact the admin");
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.println("------------------");
		System.out.println("Application Closed");

	}

	/**
	 * method takes a file path, and reads the songs to a Song object to store
	 * within the songs ArrayList.
	 * 
	 * @param string
	 */
	private static void readFromCSV(String path) {
		File file = new File(path);
		String data;

		System.out.println("Reading songs ...");

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {

			// skip heading line
			br.readLine();

			while ((data = br.readLine()) != null) {

				// storing song data in array
				String[] songParts = data.split(",");

				// create song instance
				Song song = new Song();

				// title
				song.setTitle(songParts[0]);

				// artist
				song.setArtist(songParts[1]);

				// position
				try {
					song.setPosition(Integer.parseInt(songParts[2]));
				} catch (NumberFormatException e) {
					System.out.println();
					System.err.println("Problem formatting position. Skipping song!");
					System.out.println();
					continue;
				}

				// add to songs ArrayList
				songs.add(song);

			}

		} catch (FileNotFoundException e) {
			System.err.println();
			System.err.println("File not found : " + e.getMessage());
		} catch (IOException e) {
			System.out.println();
			System.err.println("Problem reading from file : " + e.getMessage());
		}

		// statistics
		System.out.println("Song read complete! Songs processed : " + songs.size());
		System.out.println();

	}

	/**
	 * 
	 */
	private static void showMenu() {

		Scanner sc = new Scanner(System.in);
		int choice;

		do {

			System.out.println(GREEN_TEXT);
			System.out.println("1. Display all songs");
			System.out.println("2. Search by artist");
			System.out.println("3. Search by title");
			System.out.println("4. Print songs to file");
			;
			System.out.println("0. Quit");
			System.out.println("----------------------");
			System.out.println(RESET_TEXT);

			// check if user enters a number
			if (!sc.hasNextInt()) {
				System.out.println(RED_TEXT + "Please enter a number:" + RESET_TEXT);
				sc.nextLine(); // skip invalid input
			}

			// capture user choice
			choice = sc.nextInt();
			sc.nextLine(); // clear line
			System.out.println();

			switch (choice) {

			case 1:
				System.out.println(BOLD_TEXT + "ALL SONG DETAILS" + RESET_TEXT);
				System.out.println();
				displayAllSongInformation(songs);
				break;
			case 2:
				String artist;

				System.out.println("Please enter the artist you want to search for:");
				artist = sc.nextLine();
				System.out.println();

				List<Song> resultsArtist = searchByArtist(artist);

				if (resultsArtist.size() != 0) {
					System.out.println(BOLD_TEXT + "ALL " + artist.toUpperCase() + " SONG DETAILS" + RESET_TEXT);
					System.out.println();
					displayAllSongInformation(resultsArtist);
				} else {
					System.out.println("No songs by " + artist);
					System.out.println();
				}

				break;
			case 3:
				String title;

				System.out.println("Please enter the title you want to search for:");
				title = sc.nextLine();
				System.out.println();

				List<Song> resultsTitle = searchByTitle(title);

				if (resultsTitle.size() != 0) {
					System.out.println(BOLD_TEXT + "ALL " + title.toUpperCase() + " SONG DETAILS" + RESET_TEXT);
					System.out.println();
					displayAllSongInformation(resultsTitle);
				} else {
					System.out.println("No songs by the title of " + title);
					System.out.println();
				}

				break;
			case 4:
				Thread t = new Thread(new PrintSongsThread());
				t.start();
				break;
			case 0:
				choice = 0;
				System.out.println("Thanks for using the app. Goodbye!");
				break;
			default:
				System.out.println(RED_TEXT + "Invalid choice. Please try again..." + RESET_TEXT);

			}

		} while (choice != 0);

		sc.close();

	}



	/**
	 * prints all song details to the console
	 */
	private static void displayAllSongInformation(List<Song> songs) {

		for (Song song : songs) {
			song.displayAll();
		}

	}

	/**
	 * method searches all songs and returns an ArrayList containing songs from a
	 * given artist
	 * 
	 * @param artist
	 * @return
	 */
	private static List<Song> searchByArtist(String artist) {
		List<Song> results = new ArrayList<Song>();

		for (Song song : songs) {
			if (song.getArtist().equalsIgnoreCase(artist)) {
				results.add(song);
			}
		}

		return results;
	}
	
	/**
	 * method searches all songs and returns an ArrayList containing songs from a
	 * given title
	 * 
	 * @param title
	 * @return
	 */
	private static List<Song> searchByTitle(String title) {
		List<Song> results = new ArrayList<Song>();

		for (Song song : songs) {
			if (song.getTitle().equalsIgnoreCase(title)) {
				results.add(song);
			}
		}

		return results;
	}

}
