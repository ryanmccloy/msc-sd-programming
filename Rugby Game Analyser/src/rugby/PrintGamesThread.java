/**
 * 
 */
package rugby;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */
public class PrintGamesThread implements Runnable {

	@Override
	public void run() {
		System.out.println();
		System.out.println("Printing games to file...");
		printToFile();
		System.out.println("Done! Games all printed to file");
		System.out.println();
		
	}

	/**
	 * method prints the contents of the games ArrayList to a new file
	 */
	private void printToFile() {
		
		File file = new File("All_games.txt");
		
		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw);) {
			
			for (RugbyGame game : GameAnalysisApp.games) {
				
				StringBuilder data = new StringBuilder();
				data.append(game.getTeam1());
				data.append(",");
				data.append(game.getTeam1Score());
				data.append(",");
				data.append(game.getTeam2());
				data.append(",");
				data.append(game.getTeam2Score());
				data.append("\n");
				bw.append(data.toString());
				
			}
			
			
		} catch(IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}
		
	}

}
