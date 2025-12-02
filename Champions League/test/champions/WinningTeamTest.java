/**
 * 
 */
package champions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class WinningTeamTest {

	// test data
	WinningTeam winningTeam;
	int yearValid;
	String nameValid;
	String nationalityValid;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		winningTeam = new WinningTeam();
		yearValid = 2019;
		nameValid = "Liverpool";
		nationalityValid = "England";

	}

	/**
	 * Test method for {@link champions.WinningTeam#WinningTeam()}.
	 */
	@Test
	void testWinningTeamDefaultConstructor() {
		assertNotNull(winningTeam);
	}

	/**
	 * Test method for
	 * {@link champions.WinningTeam#WinningTeam(int, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testWinningTeamConstructorWithArgs() {
		winningTeam = new WinningTeam(yearValid, nameValid, nationalityValid);

		assertEquals(yearValid, winningTeam.getYear());
		assertEquals(nameValid, winningTeam.getName());
		assertEquals(nationalityValid, winningTeam.getNationality());
	}

	/**
	 * Test method for {@link champions.WinningTeam#setYear(int)}.
	 */
	@Test
	void testGetSetYear() {
		winningTeam.setYear(yearValid);
		assertEquals(yearValid, winningTeam.getYear());
	}

	/**
	 * Test method for {@link champions.WinningTeam#setName(java.lang.String)}.
	 */
	@Test
	void testGetSetName() {
		winningTeam.setName(nameValid);
		assertEquals(nameValid, winningTeam.getName());
	}

	/**
	 * Test method for
	 * {@link champions.WinningTeam#setNationality(java.lang.String)}.
	 */
	@Test
	void testGetSetNationality() {
		winningTeam.setNationality(nationalityValid);
		assertEquals(nationalityValid, winningTeam.getNationality());
	}

	/**
	 * Test method for {@link champions.WinningTeam#toString()}.
	 */
	@Test
	void testToString() {
		winningTeam = new WinningTeam(yearValid, nameValid, nationalityValid);
		String expected = yearValid + " - " + nameValid + " (" + nationalityValid + ")";
		assertEquals(expected, winningTeam.toString());
	}

}
