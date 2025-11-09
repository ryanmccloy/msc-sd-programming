/**
 * 
 */
package shape;

/**
 * 
 */
public class Rectangle extends Shape implements MyShape {

	// instance variables
	double height, length;

	// constructors

	/**
	 * default constructor
	 */
	public Rectangle() {

	}

	/**
	 * constructor from arguments
	 * 
	 * @param length
	 * @param height
	 * @param colour
	 * @param name
	 */
	public Rectangle(Colour colour, String name, double height, double length) {
		super(colour, name);
		this.height = height;
		this.length = length;

	}

	// methods

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

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
		return ((2 * this.height) + (2 * this.length));
	}

	@Override
	public double calculateArea() {
		return this.length * this.height;
	}

	@Override
	public String getShapeName() {
		return this.getName();
	}
}
