/**
 * 
 */
package champions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class UtilitiesTest {

	ArrayList<WinningTeam> winners, results;
	WinningTeam team1, team2, team3;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		winners = new ArrayList<WinningTeam>();
		results = new ArrayList<WinningTeam>();

		team1 = new WinningTeam(1970, "Real Madrid", "Spain");
		team2 = new WinningTeam(2005, "Liverpool", "England");
		team3 = new WinningTeam(2004, "Porto", "Portugal");

		winners.add(team1);
		winners.add(team2);
		winners.add(team3);
	}

	/**
	 * Test method for
	 * {@link champions.Utilities#filterByTeam(java.util.Scanner, java.util.ArrayList)}.
	 */
	@Test
	void testFilterByTeam() {
		Scanner sc = new Scanner("Liverpool");

		results = Utilities.filterByTeam(sc, winners);

		assertEquals(1, results.size());
		assertTrue(results.contains(team2));

		sc.close();
	}

	/**
	 * Test method for
	 * {@link champions.Utilities#filterByCountry(java.util.Scanner, java.util.ArrayList)}.
	 */
	@Test
	void testFilterByCountry() {
		Scanner sc = new Scanner("Portugal");

		results = Utilities.filterByCountry(sc, winners);

		assertEquals(1, results.size());
		assertTrue(results.contains(team3));

		sc.close(); 
	} 

}
