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
package groundTransport;

/**
 * This is the Tram class file which extends CityBus, and it's the grandchild class of the PublicTransportation class.
 * 
 * @author Matthew Pan 40135588
 */
public class Tram extends CityBus
{
	/**Maximum speed*/
	private int maxSpeed;	//max speed of Tram
	
	/**Sets values to default for this Tram*/
	public Tram() {
		super();
		setMaxSpeed(0);
	}
	
	/**
	 * Sets the 7 parameters for this Tram.
	 * 
	 * @param aTicketPrice
	 * @param aNbStops
	 * @param aRouteNb
	 * @param aBeganOpYr
	 * @param aLineName
	 * @param aDriverName
	 * @param aMaxSpeed
	 */
	public Tram(double aTicketPrice, int aNbStops, long aRouteNb, int aBeganOpYr, String aLineName, String aDriverName, int aMaxSpeed) {
		super(aTicketPrice, aNbStops, aRouteNb, aBeganOpYr, aLineName, aDriverName);
		setMaxSpeed(aMaxSpeed);
	}
	
	/**
	 * Copy constructor; copies the values inside aCopy to the new obj. 
	 * 
	 * In addition, the instance variables used here that are exclusively part 
	 * of this class have been changed to their getters/setters instead (e.g.: aCopy.maxSpeed -> aCopy.getMaxSpeed()). Although the former is also safe here, 
	 * the latter would be better since if there are any modification to those methods, they will also be applied here.
	 * 
	 * @param aCopy object to copy from
	 */
	public Tram(Tram aCopy) {
		super(aCopy);
		setMaxSpeed(aCopy.getMaxSpeed());
	}
	
	/** 
	 * Overriding equals method. 
	 * 
	 * Null verification is very important. If it isn't included and the equals method is used on a null object,
	 * it will terminate the program and throw a NullPointerException error because null points to nothing. 
	 * 
	 * In addition, the instance variables used here that are exclusively part of this class have been changed to their getters instead 
	 * (e.g.: maxSpeed -> getMaxSpeed()). Although the former is also safe here, the latter would be better since if there are any 
	 * modification to those methods, they will also be applied here. 
	 * */
	public boolean equals(Object otherObject) {
		if(otherObject == null) {
			return false;
		}
		else if(getClass() != otherObject.getClass()) {
			return false;
		}
		else {
			Tram otherObj = (Tram) otherObject;
			return (super.equals(otherObject) && getMaxSpeed() == otherObj.getMaxSpeed());
		}
	}
	
	/**
	 *Overriding toString method; displays all properties of this object.
	 *
	 *In addition, the instance variables used here that are exclusively part of this class have been changed to their getters instead 
	 *(e.g.: maxSpeed -> getMaxSpeed()). Although the former is also safe here, the latter would be better since if there are any modification 
	 *to those methods, they will also be applied here.
	 */
	public String toString() {
		return ("This Tram's info --> Ticket Price: " + getTicketPrice() + "$ | Number of Stops: " + getNbStops() + " | Route Number: " 
				+ getRouteNb() + " | Began Operations Year: " + getBeganOpYr() + " | Line Name: " + getLineName() + " | Driver Name: " + getDriverName()
				+ " | Maximum Speed: " + getMaxSpeed() + "km/h");
	}
	
	/**mutator method*/
	public void setMaxSpeed(int aMaxSpeed) {
		if(aMaxSpeed < 0) {
			System.out.println("Input cannot be negative");
		}
		else {
			maxSpeed = aMaxSpeed;
		}
	}
	
	/**accessor method*/
	public int getMaxSpeed() {
		return maxSpeed;
	}
}
