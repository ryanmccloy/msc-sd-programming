/**
 * 
 */
package music;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class SongTest {
	
	// test data
	Song song;
	String titleValid;
	String artistValid;
	int positionValid;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		song = new Song();
		titleValid = "Nutshell";
		artistValid = "Alice In Chains";
		positionValid = 1;
	}

	/**
	 * Test method for {@link music.Song#Song()}.
	 */
	@Test
	void testSongDefaultConstructor() {
		assertNotNull(song);
	}

	/**
	 * Test method for {@link music.Song#Song(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	void testSongConstructorWithArguments() {
		song = new Song(titleValid, artistValid, positionValid);
		
		assertEquals(titleValid, song.getTitle());
		assertEquals(artistValid, song.getArtist());
		assertEquals(positionValid, song.getPosition());
	}

	/**
	 * Test method for {@link music.Song#getTitle()}.
	 */
	@Test
	void testGetSetTitleValid() {
		song.setTitle(titleValid);
		
		assertEquals(titleValid, song.getTitle());
	}

	/**
	 * Test method for {@link music.Song#getArtist()}.
	 */
	@Test
	void testGetSetArtistValid() {
		song.setArtist(artistValid);
		
		assertEquals(artistValid, song.getArtist());
	}

	/**
	 * Test method for {@link music.Song#getPosition()}.
	 */
	@Test
	void testGetSetPositionValid() {
		song.setPosition(positionValid);
		
		assertEquals(positionValid, song.getPosition());
	}

}
