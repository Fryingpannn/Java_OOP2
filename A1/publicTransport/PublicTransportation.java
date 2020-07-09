/*-------------------------------
 * Name: Matthew Pan             |
 * Student ID: 40135588          |
 * Comp 249: Assignment #1       |
 * Driver file: DriverTransport  |
 * Part 1 & 2                    |
 * Due Date: 12 July, 2020       |
 * Professor: Dr. Yuhong Yan     |
 *-------------------------------
 */
package publicTransport;
/**
 * This is the PublicTransportation class which is the superclass of the AirCraft, Ferry and CityBus classes.
 * 
 * It is also the grandparent class of the Metro and tram classes.
 * 
 * @author Matthew Pan 40135588
 */
public class PublicTransportation 
{
	/**Price per ticket*/
	private double ticketPrice;
	/**Number of stops*/
	private int nbStops;
	
	/** Sets price and nb of stops to 0*/
	public PublicTransportation() {
		setTicketPrice(0);
		setNbStops(0);	//number of stops
	}
	
	/**
	 * Sets the price and nb of stops for this PublicTransportation (2 parameters).
	 * 
	 * @param aTicketPrice price per ticket
	 * @param aNbStops	number of stops
	 */
	public PublicTransportation(double aTicketPrice, int aNbStops) {
		setTicketPrice(aTicketPrice);
		setNbStops(aNbStops);
	}

	/**
	 * Copy constructor; copies the values inside aCopy into the new obj.
	 * 
	 * @param aCopy the object to copy from
	 */
	public PublicTransportation(PublicTransportation aCopy) {
		setTicketPrice(aCopy.getTicketPrice());
		setNbStops(aCopy.getNbStops());
	}
	
	/** Overriding equals method. 
	 * 
	 * Null verification is very important. If it isn't included and the equals method is used on a null object,
	 * it will terminate the program and throw a NullPointerException error because null points to nothing.*/
	public boolean equals(Object otherObject) {
		if(otherObject == null) {
			return false;
		}
		else if(getClass() != otherObject.getClass()) {
			return false;
		}
		else {
			PublicTransportation otherObj = (PublicTransportation) otherObject;
			return (getTicketPrice() == otherObj.getTicketPrice() && getNbStops() == otherObj.getNbStops());
			
		}
	}
	
	/**Overriding toString method; displays all properties of this object.*/
	public String toString() {
		return ("This Public Transportation's info --> Ticket Price: " + getTicketPrice() + "$ | Number of Stops: " + getNbStops());
	}
	
	/**mutator methods (2)*/
	public void setTicketPrice(double aTicketPrice) {
		if(aTicketPrice < 0) {
			System.out.println("Input cannot be negative");
		}
		else {
			ticketPrice = aTicketPrice;
		}
	}

	/**mutator methods (2)*/
	public void setNbStops(int aNbStops) {
		if(aNbStops < 0) {
			System.out.println("Input cannot be negative");
		}
		else {
			nbStops = aNbStops;
		}
	}

	/**accessor methods (2)*/
	public double getTicketPrice() {
		return ticketPrice;
	}
	
	/**accessor methods (2)*/
	public int getNbStops() {
		return nbStops;
	}
}
