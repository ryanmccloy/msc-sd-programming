/**
 * 
 */
package champions;

/**
 * 
 */
public class WinningTeam {

	// instance variables
	private int year;
	private String name;
	private String nationality;

	// constructors

	/**
	 * default constructor
	 */
	public WinningTeam() {
	}
 
	/**
	 * constructor with arguments
	 * 
	 * @param year
	 * @param name
	 * @param nationality
	 */
	public WinningTeam(int year, String name, String nationality) {
		this.year = year;
		this.name = name;
		this.nationality = nationality;
	}

	// methods

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return year + " - " + name + " (" + nationality + ")";
	}

	
	
}
