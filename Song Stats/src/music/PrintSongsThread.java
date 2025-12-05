/**
 * 
 */
package music;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * thread prints all songs to a new file
 */
public class PrintSongsThread implements Runnable {

	@Override
	public void run() {
		printSongs();
		
	}

	/**
	 * prints songs to new file
	 */
	private void printSongs() {
		
		File file = new File("All_Songs.txt");
		
		System.out.println("Song printing started");
		System.out.println();
		
		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw);) {
			
			for (Song song : SongStats.songs) {
				StringBuilder data = new StringBuilder();
				
				data.append(song.getTitle());
				data.append(",");
				data.append(song.getArtist());
				data.append(",");
				data.append(song.getPosition());
	
				bw.append(data.toString());
				bw.newLine();
			}
			
		} catch (IOException e) {
			System.err.println("Problem writing to file : " + e.getMessage());
		} 
		
		
		System.out.println("Song print completed!");
		System.out.println();
		
	}

}
