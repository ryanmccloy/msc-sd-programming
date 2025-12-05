/**
 * 
 */
package music;

/**
 * class represents a song
 */
public class Song {
	
	// SOS,Avicii,6
	
	String title;
	String artist;
	int position;

	/**
	 * Default constructor
	 */
	public Song() {
	 
	}

	/**
	 * Constructor with arguments. Initialises a song object using the provided fields
	 * @param title
	 * @param artist
	 * @param position
	 */
	public Song(String title, String artist, int position) {
		this.title = title;
		this.artist = artist;
		this.position = position;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * method prints all song details to the console
	 */
	public void displayAll() {
		System.out.println("Title : " + this.title.toUpperCase());
		System.out.println("Artist : " + this.artist);
		System.out.println("Position : " + this.position);
		System.out.println("------------------------");
		System.out.println();
	}
	

}
