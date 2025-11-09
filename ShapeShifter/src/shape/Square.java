/**
 * 
 */
package shape;

/**
 * 
 */
public class Square extends Shape implements MyShape {

	// instance variables
	private double length;

	// constructors

	/**
	 * default constructor
	 */
	public Square() {

	}

	/**
	 * constructor from arguments
	 * 
	 * @param length
	 * @param height
	 * @param colour
	 * @param name
	 */
	public Square(Colour colour, String name, double length) {
		super(colour, name);
		this.length = length;

	}

	// methods

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double calculatePerimeter() {
		return 4 * this.length;
	}

	@Override
	public double calculateArea() {
		return Math.pow(this.length, 2);
	}

	@Override
	public String getShapeName() {
		return this.getName();
	}

}
