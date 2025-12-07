/**
 * 
 */
package channel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class UtilitiesTest {

	// test data
	Programme p1, p2, p3, p4, p5;
	List<Programme> shows;
	List<Programme> results;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		shows = new ArrayList<Programme>();
		results = new ArrayList<Programme>();

		p1 = new Programme("F1", Broadcaster.BBC, 6, 7);
		p2 = new Programme("The Office", Broadcaster.NETFLIX, 8, 17);
		p3 = new Programme("Silo", Broadcaster.APPLE_TV, 9, 12);
		p4 = new Programme("Severance", Broadcaster.APPLE_TV, 10, 15);
		p5 = new Programme("The Gorge", Broadcaster.AMAZON_PRIME, 1, 2);

		shows.add(p1);
		shows.add(p2);
		shows.add(p3);
		shows.add(p4);
		shows.add(p5);

	}

	/**
	 * Test method for
	 * {@link channel.Utilities#searchProgrammesByTitle(java.lang.String, java.util.List)}.
	 */
	@Test
	void testSearchProgrammesByTitle() {
		results = Utilities.searchProgrammesByTitle("Severance", shows);
		assertTrue(results.contains(p4));

		results = Utilities.searchProgrammesByTitle("Silo", shows);
		assertTrue(results.contains(p3));

		results = Utilities.searchProgrammesByTitle("The Office", shows);
		assertTrue(results.contains(p2));

		results = Utilities.searchProgrammesByTitle("F1", shows);
		assertTrue(results.contains(p1));

		results = Utilities.searchProgrammesByTitle("The Gorge", shows);
		assertTrue(results.contains(p5));

	}

	/**
	 * Test method for
	 * {@link channel.Utilities#searchProgrammesByBroadcaster(java.lang.String, java.util.List)}.
	 */
	@Test
	void testSearchProgrammesByBroadcaster() { 
		results = Utilities.searchProgrammesByBroadcaster("Apple Tv", shows);
		assertTrue(results.contains(p3));
		assertTrue(results.contains(p4));

		results = Utilities.searchProgrammesByBroadcaster("Netflix", shows);
		assertTrue(results.contains(p2));

		results = Utilities.searchProgrammesByBroadcaster("BBC", shows);
		assertTrue(results.contains(p1));

		results = Utilities.searchProgrammesByBroadcaster("Amazon Prime", shows);
		assertTrue(results.contains(p5));

	}

	/**
	 * Test method for
	 * {@link channel.Utilities#searchProgrammesByRatingUpper(int, java.util.List)}.
	 */
	@Test
	void testSearchProgrammesByRatingUpper() {
		results = Utilities.searchProgrammesByRatingUpper(7, shows);
		assertTrue(results.contains(p2));
		assertTrue(results.contains(p3)); 
		assertTrue(results.contains(p4));

		assertFalse(results.contains(p1));
		assertFalse(results.contains(p5));

	}
 
	/**
	 * Test method for
	 * {@link channel.Utilities#searchProgrammesByRatingLower(int, java.util.List)}.
	 */
	@Test
	void testSearchProgrammesByRatingLower() {
		results = Utilities.searchProgrammesByRatingLower(6, shows);
		assertFalse(results.contains(p2));
		assertFalse(results.contains(p3));
		assertFalse(results.contains(p4));

		assertTrue(results.contains(p1));
		assertTrue(results.contains(p5));
	}

	/**
	 * Test method for
	 * {@link channel.Utilities#sortShowsByRatingHighToLow(java.util.list)}.
	 */
	@Test
	void testSortProgrammesByRatingHIghToLow() {
		results = Utilities.sortShowsByRatingHighToLow(shows);

		assertTrue(results.get(0).equals(p4));
		assertTrue(results.get(1).equals(p3));
		assertTrue(results.get(2).equals(p2));
		assertTrue(results.get(3).equals(p1));
		assertTrue(results.get(4).equals(p5));

	}

	/** 
	 * Test method for
	 * {@link channel.Utilities#sortShowsByRatingLowToHigh(java.util.list)}.
	 */
	@Test
	void testSortProgrammesByRatingLowToHIgh() {
		results = Utilities.sortShowsByRatingLowToHigh(shows);
		
		assertTrue(results.get(0).equals(p5));
		assertTrue(results.get(1).equals(p1));
		assertTrue(results.get(2).equals(p2));
		assertTrue(results.get(3).equals(p3));
		assertTrue(results.get(4).equals(p4)); 
 
	}

	/**
	 * Test method for
	 * {@link channel.Utilities#sortShowsByAverageAudienceHighToLow(java.util.list)}.
	 */
	@Test
	void testSortProgrammesByAudienceHighToLow() {
		results = Utilities.sortShowsByAverageAudienceHighToLow(shows);
		
		
		assertTrue(results.get(0).equals(p2));
		assertTrue(results.get(1).equals(p4));
		assertTrue(results.get(2).equals(p3));
		assertTrue(results.get(3).equals(p1)); 
		assertTrue(results.get(4).equals(p5)); 
		
	}
 
	/**
	 * Test method for
	 * {@link channel.Utilities#sortShowsByAverageAudienceLowToHigh(java.util.list)}.
	 */
	@Test
	void testSortProgrammesByAudienceLowToHigh() {
		results = Utilities.sortShowsByAverageAudienceLowToHigh(shows);
		
		assertTrue(results.get(0).equals(p5));
		assertTrue(results.get(1).equals(p1));
		assertTrue(results.get(2).equals(p3));
		assertTrue(results.get(3).equals(p4)); 
		assertTrue(results.get(4).equals(p2)); 
	}

}
