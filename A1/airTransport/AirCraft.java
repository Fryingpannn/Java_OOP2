/*-------------------------------
 * Name: Matthew Pan             | 
 * Student ID: 40135588          |
 * Comp 249: Assignment #1       |
 * Driver file: DriverTransport  |
 * Part 2                        |
 * Due Date: 12 July, 2020       |
 * Professor: Dr. Yuhong Yan     |
 *-------------------------------
 */
package airTransport;

import publicTransport.PublicTransportation;
/**
 * This is the AirCraft class file which extends PublicTransportation.
 * 
 * @author Matthew Pan 40135588
 */
public class AirCraft extends PublicTransportation 
{
	/**Enum type which specifies type of aircraft*/
	private AirType classType;
	/**Enum type which specifies aircraft maintenance interval time*/
	private TimeType maintainType;
	

	/**Sets values to default for this AirCraft*/
	public AirCraft() {
		super();
		setClassType(AirType.NONE);
		setMaintainType(TimeType.NONE);
	}
	
	/**
	 * Sets the 4 parameters values for this AirCraft.
	 * 
	 * @param aTicketPrice price per ticket
	 * @param aNbStops number of stops
	 * @param aClassType type of aircraft
	 * @param aMaintainType maintenance time interval required for this aircraft
	 */
	public AirCraft(double aTicketPrice, int aNbStops, AirType aClassType, TimeType aMaintainType) {
		super(aTicketPrice, aNbStops);
		setClassType(aClassType);
		setMaintainType(aMaintainType);
	}
	
	/**
	 * Copy constructor; copies the values inside aCopy to the new obj
	 * 
	 * @param aCopy object to copy from
	 */
	public AirCraft(AirCraft aCopy) {
		super(aCopy);
		setClassType(aCopy.getClassType());
		setMaintainType(aCopy.getMaintainType());
	}
	
	/**nested enum used for AirCraft classType*/
	enum AirType {
		NONE,
		HELICOPTER,
		AIRLINE,
		BALLOON,
		GLIDER
	}
		
	/**nested enum used for AirCraft MaintainType*/
	enum TimeType {
		NONE,
		WEEKLY,
		MONTHLY,
		YEARLY
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
			AirCraft otherObj = (AirCraft) otherObject;
			return (super.equals(otherObject) && getClassType() == otherObj.getClassType() && getMaintainType() == otherObj.getMaintainType());
		}
	}
	
	/**Overriding toString method: displaying all properties of this object*/
	public String toString() {
		return("This AirCraft's info --> Ticket Price: " + getTicketPrice() + "$ | Number of Stops: " + getNbStops() + " | Class Type: "
				+ getClassType() + " | Maintenance Type: " + getMaintainType());
	}
	
	/**mutator methods (2)*/
	public void setClassType(AirType aClassType) {
		classType = aClassType;
	}
	
	/**mutator methods (2)*/
	public void setMaintainType(TimeType aMaintainType) {
		maintainType = aMaintainType;
	}
	
	/**accessor methods (2)*/
	public AirType getClassType() {
		return classType;
	}
	
	/**accessor methods (2)*/
	public TimeType getMaintainType() {
		return maintainType;
	}
}
