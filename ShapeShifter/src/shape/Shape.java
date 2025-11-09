/**
 * 
 */
package shape;

/**
 * 
 */
public abstract class Shape {

	// instance variables


	private Colour colour;
	private String name;

	// constructors

	/*
	 * default constructor
	 */
	public Shape() {

	}

	/**
	 * constructor with arguments
	 * 
	 * @param length
	 * @param height
	 * @param colour
	 * @param name
	 */
	public Shape( Colour colour, String name) {
		
		this.colour = colour;
		this.name = name;
	}

	// methods



	/**
	 * @return the colour
	 */
	public Colour getColour() {
		return colour;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(Colour colour) {
		this.colour = colour;
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

}
