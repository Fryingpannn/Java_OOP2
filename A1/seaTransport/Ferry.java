/*-------------------------------
 * Name: Matthew Pan             | 
 * Student ID: 40135588          |
 * Comp 249: Assignment #1       |
 * Driver file: DriverTransport  |
 * Part 2                    |
 * Due Date: 12 July, 2020       |
 * Professor: Dr. Yuhong Yan     |
 *-------------------------------
 */
package seaTransport;

import publicTransport.PublicTransportation;
/**
 * This is the Ferry class file which extends PublicTransportation.
 * 
 * @author Matthew Pan 40135588
 */
public class Ferry extends PublicTransportation
{
	/**Year built*/
	private int buildYr;
	/**Name of ship*/
	private String shipName;
	

	/**Sets values to default*/
	public Ferry() {
		super();
		setBuildYr(0);
		setShipName("None");
	}

	/**
	 * Sets the 4 parameter values for this Ferry.
	 * 
	 * @param aTicketPrice price per ticket
	 * @param aNbStops number of stops
	 * @param aBuildYr year built
	 * @param aShipName name of ship
	 */
	public Ferry(double aTicketPrice, int aNbStops, int aBuildYr, String aShipName) {
		super(aTicketPrice, aNbStops);
		setBuildYr(aBuildYr);
		setShipName(aShipName);
	}
	
	/**
	 * Copy constructor; copies the values inside aCopy to the new obj.
	 * 
	 * @param aCopy object to copy from
	 */
	public Ferry(Ferry aCopy) {
		setTicketPrice(aCopy.getTicketPrice());
		setNbStops(aCopy.getNbStops());
		setBuildYr(aCopy.getBuildYr());
		setShipName(aCopy.getShipName());
	}
	
	/**Overriding equals method. 
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
			Ferry otherObj = (Ferry) otherObject;
			return (getTicketPrice() == otherObj.getTicketPrice() && getNbStops() == otherObj.getNbStops()
					&&  getBuildYr() == otherObj.getBuildYr() && getShipName().equals(otherObj.getShipName()));
		}
	}
	
	/**Overriding toString method: displaying all properties of this object*/
	public String toString() {
		return ("This Ferry's info --> Ticket Price: " + getTicketPrice() + "$ | Number of Stops: " + getNbStops() + " | Build Year: "
				+ getBuildYr() + " | Ship Name: " + getShipName());
	}
	
	/**mutator methods (2)*/
	public void setBuildYr(int aBuildYr) {
		if(aBuildYr < 0) {
			System.out.println("Input cannot be negative");
		}
		else {
			buildYr = aBuildYr;
		}
	}
	
	/**mutator methods (2)*/
	public void setShipName(String aShipName) {
		shipName = aShipName;
	}
	
	/**accessor methods (2)*/
	public int getBuildYr() {
		return buildYr;
	}
	
	/**accessor methods (2)*/
	public String getShipName() {
		return shipName;
	}
	
	
}
