/**
 * 
 */
package timetable;

/**
 * represents a bus route in the journey planner
 */
public class BusRoute {
	
	// instance variables
	
	private int routeId;
	private String departure;
	private String arrival;
	private int travelMinutes;
	private Operator operator;
	
	
	// constructors
	
	/**
	 * default constructor
	 */
	public BusRoute() {
		
	}


	/**
	 * constructor with arguments
	 * @param routeId
	 * @param departure
	 * @param arrival
	 * @param travelMinutes
	 * @param operator
	 */
	public BusRoute(int routeId, String departure, String arrival, int travelMinutes, Operator operator) {
		this.routeId = routeId;
		this.departure = departure;
		this.arrival = arrival;
		this.travelMinutes = travelMinutes;
		this.operator = operator;
	}
	
	// methods


	/**
	 * @return the routeId
	 */
	public int getRouteId() {
		return routeId;
	}


	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}


	/**
	 * @return the departure
	 */
	public String getDeparture() {
		return departure;
	}


	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}


	/**
	 * @return the arrival
	 */
	public String getArrival() {
		return arrival;
	}


	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}


	/**
	 * @return the travelMinutes
	 */
	public int getTravelMinutes() {
		return travelMinutes;
	}


	/**
	 * @param travelMinutes the travelMinutes to set
	 */
	public void setTravelMinutes(int travelMinutes) {
		this.travelMinutes = travelMinutes;
	}


	/**
	 * @return the operator
	 */
	public Operator getOperator() {
		return operator;
	}


	/**
	 * @param operator the operator to set
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	
	/**
	 * displays all details
	 */
	public void displayAll() {
		System.out.println();
		System.out.printf("Route ID: %d%n", this.routeId);
		System.out.printf("Departs: %s%n", this.departure);
		System.out.printf("Arrives: %s%n", this.arrival);
		System.out.printf("Travel Time (mins): %d%n", this.travelMinutes);
		System.out.printf("Operator: %s%n", this.operator);
		System.out.println();
		System.out.println("------------------");
		
		
	}
	
	

}
