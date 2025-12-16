/**
 * 
 */
package breeds;

/**
 * 
 */
public class Dog {
	
	// instance variables
	private String breed;
	private double weight;
	private double  height;
	private double lifeExpectancy;
	private String color;
	private String originCountry;
	

	/**
	 * Default constructor
	 */
	public Dog() {
		
	}


	/**
	 * Initialised a dog instance with the given instance variables
	 * @param breed
	 * @param weight
	 * @param height
	 * @param lifeExpectancy
	 * @param color
	 * @param originCountry
	 */
	public Dog(String breed, double weight, double height, double lifeExpectancy, String color, String originCountry) {
		this.breed = breed;
		this.weight = weight;
		this.height = height;
		this.lifeExpectancy = lifeExpectancy;
		this.color = color;
		this.originCountry = originCountry;
	}


	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}


	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}


	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}


	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}


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
	 * @return the lifeExpectancy
	 */
	public double getLifeExpectancy() {
		return lifeExpectancy;
	}


	/**
	 * @param lifeExpectancy the lifeExpectancy to set
	 */
	public void setLifeExpectancy(double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}


	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}


	/**
	 * @return the originCountry
	 */
	public String getOriginCountry() {
		return originCountry;
	}


	/**
	 * @param originCountry the originCountry to set
	 */
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}
	
	
	/**
	 * displays all the details of the dog
	 */
	public void displayAll() {
		System.out.println("Breed\t:  " + this.breed.toUpperCase());
		System.out.printf("Weight\t:  %.2fkg%n", this.weight);
		System.out.printf("Height\t:  %.2fcm%n", this.height);
		System.out.printf("Life\t:  %.2f years%n", this.lifeExpectancy);
		System.out.println("Colour\t:  " + this.color);
		System.out.println("Country\t:  " + this.originCountry);
		System.out.println();
		System.out.println("-----------------------");
		System.out.println();
	}
	
	

}
