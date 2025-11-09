/**
 * 
 */
package shape;

/**
 * 
 */
public class Circle extends Shape implements MyShape {

	// instance variables
	private double diameter;

	// constructors

	/**
	 * default constructor
	 */
	public Circle() {

	}

	/**
	 * constructor from arguments
	 * 
	 * @param length
	 * @param height
	 * @param colour
	 * @param name
	 */
	public Circle(Colour colour, String name, double diameter) {
		super(colour, name);
		this.diameter = diameter;
	}

	// methods

	/**
	 * @return the radius
	 */
	public double getDiameter() {
		return diameter;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	@Override
	public double calculatePerimeter() {
		return (2 * (Math.PI * (this.diameter / 2)));
	}

	@Override
	public double calculateArea() {
		return (Math.PI * (Math.pow(this.diameter / 2, 2)));
	}

	@Override
	public String getShapeName() {
		return this.getName();
	}

}
