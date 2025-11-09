package shape;

import java.util.Random;

/**
 * class for testing shapes interface and OOP
 */
public class AdHoc {

	// constants
	private static final int NUMBER_OF_SHAPES = 10;
	private static final String BOLD_TEXT = "\033[1m";
	private static final String RESET_TEXT = "\033[0m";
	private static final String RED = "\033[31m";
	private static final String GREEN = "\033[32m";
	private static final String YELLOW = "\033[33m";
	private static final String BLUE = "\033[34m";
	private static final String PINK = "\033[35m";
	private static final String ORANGE_BASIC = "\033[33m";

	/*
	 * 
	 */
	public static void main(String[] args) {

		MyShape shapes[] = shapesArrayCreator(NUMBER_OF_SHAPES);

		displayShapeDetails(shapes);

	}

	/**
	 * method creates and returns an array of random shapes
	 * 
	 * @param number of shapes to add to array
	 * @return
	 */
	public static MyShape[] shapesArrayCreator(int numOfShapes) {

		// array to hold shapes of all types
		MyShape myShapes[] = new MyShape[numOfShapes];

		// create random number generator
		Random generator = new Random();

		int temp = 0;

		for (int shape = 0; shape < myShapes.length; shape++) {
			temp = generator.nextInt(3);

			switch (temp) {

			case 0:
				myShapes[shape] = new Circle(Colour.BLUE, "Circle", generator.nextDouble() * generator.nextInt(10));
				break;
			case 1:
				myShapes[shape] = new Square(Colour.RED, "Square", generator.nextDouble() * generator.nextInt(10));
				break;
			case 2:
				myShapes[shape] = new Rectangle(Colour.ORANGE, "Rectangle",
						generator.nextDouble() * generator.nextInt(10), generator.nextDouble() * generator.nextInt(10));
				break;

			default:
				System.err.println("Invalid random number");

			}
		}

		return myShapes;

	}

	/**
	 * method prints out all details of each shape in the array
	 * 
	 * @param shapes
	 */
	public static void displayShapeDetails(MyShape[] shapes) {

		for (MyShape shape : shapes) {

			System.out.printf("%s%s%s%n", BOLD_TEXT, shape.getShapeName(), RESET_TEXT);

			if (shape instanceof Circle) {
				Circle circle = (Circle) shape;

				String colorCode = getAnsiColor(circle.getColour());
				System.out.printf("Colour : \t%s%s%s%n", colorCode, circle.getColour(), RESET_TEXT);
				System.out.printf("Diameter : \t%.2f%n", circle.getDiameter());
				System.out.printf("Radius : \t%.2f%n", circle.getDiameter() / 2);
			}

			if (shape instanceof Square) {
				Square square = (Square) shape;
				String colorCode = getAnsiColor(square.getColour());
				System.out.printf("Colour : \t%s%s%s%n", colorCode, square.getColour(), RESET_TEXT);
				System.out.printf("Length : \t%.2f%n", square.getLength());

			}

			if (shape instanceof Rectangle) {
				Rectangle rect = (Rectangle) shape;
				String colorCode = getAnsiColor(rect.getColour());
				System.out.printf("Colour : \t%s%s%s%n", colorCode, rect.getColour(), RESET_TEXT);
				System.out.printf("Length : \t%.2f%n", rect.getLength());
				System.out.printf("Height : \t%.2f%n", rect.getHeight());

			}

			System.out.printf("Area : \t\t%.2f%n", shape.calculateArea());
			System.out.printf("Perimeter : \t%.2f%n", shape.calculatePerimeter());
			System.out.println();

		}

	}

	/**
	 * Converts a Colour enum to its corresponding ANSI color code string.
	 */
	private static String getAnsiColor(Colour colour) {
		switch (colour) {
		case RED:
			return RED;
		case GREEN:
			return GREEN;
		case BLUE:
			return BLUE;
		case YELLOW:
			return YELLOW;
		case PINK:
			return PINK;
		case ORANGE:
			return ORANGE_BASIC;
		default:
			return RESET_TEXT; // Fallback if a colour is missing
		}
	}

}
