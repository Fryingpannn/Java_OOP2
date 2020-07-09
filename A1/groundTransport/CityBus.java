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
package groundTransport;

import publicTransport.PublicTransportation;

/**
 * This is the CityBus class file which extends PublicTransportation, and is the superclass of the Metro and Tram classes.
 * <p>
 * Comments on using restrictive access: <br>
 * These attributes are changed from protected to private to enforce encapsulation. This is important
 * because if they were protected instead, and the driver class was also in the same package, then any user could directly 
 * access the instance variables of this object and modify their values through the driver class. This also leads to changing
 * every method which accesses/mutates these variables to use getters/setters. This may add an extra step but the tradeoff is
 * mandatory in order to ensure encapsulation for security/privacy.</p>
 * 
 * @author Matthew Pan 40135588
 */
public class CityBus extends PublicTransportation 
{
	/**Route number*/
	private long routeNb;
	/**Began operation year*/
	private int beganOpYr;	
	/**Name of line*/
	private String lineName;
	/**Driver's name*/
	private String driverName;

	/**Sets the values to default for this Citybus.*/
	public CityBus() {
		super();
		setRouteNb(0);
		setBeganOpYr(0);
		setLineName("None");
		setDriverName("None");
	}
	
	/**
	 * Sets the values to the 6 parameters for this CityBus.
	 * 
	 * @param aTicketPrice price of a ticket
	 * @param aNbStops number of stops
	 * @param aRouteNb route number
	 * @param aBeganOpYr began operation year
	 * @param aLineName name of line
	 * @param aDriverName name of driver
	 */
	public CityBus(double aTicketPrice, int aNbStops, long aRouteNb, int aBeganOpYr, String aLineName, String aDriverName) {
		super(aTicketPrice, aNbStops);
		setRouteNb(aRouteNb);
		setBeganOpYr(aBeganOpYr);
		setLineName(aLineName);
		setDriverName(aDriverName);
	}
	
	/**
	 * Copy constructor; copies the values inside aCopy to the new object. 
	 * 
	 * In addition, the instance variables used here that are exclusively part 
	 * of this class have been changed to their getters instead (e.g.: aCopy.routeNb -> aCopy.getRouteNb()). Although the former is also safe here, 
	 * the latter would be better since if there are any modification to those methods, they will also be applied here.
	 * 
	 * @param aCopy the object to copy from
	 */
	public CityBus(CityBus aCopy) {
		setTicketPrice(aCopy.getTicketPrice());
		setNbStops(aCopy.getNbStops());
		setRouteNb(aCopy.getRouteNb());
		setBeganOpYr(aCopy.getBeganOpYr());
		setLineName(aCopy.getLineName());
		setDriverName(aCopy.getDriverName());
	}
	
	/** 
	 * Overriding equals method.
	 * Null verification is very important. If it isn't included and the equals method is used on a null object,
	 * it will terminate the program and throw a NullPointerException error because null points to nothing. 
	 * 
	 * In addition, the instance variables used here that are exclusively part of this class have been changed to their getters instead 
	 * (e.g.: routeNb -> getRouteNb()). Although the former is also safe here, the latter would be better since if there are any modification 
	 * to those methods, they will also be applied here. 
	 * */
	public boolean equals(Object otherObject) {
		if(otherObject == null) {
			return false;
		}
		else if(getClass() != otherObject.getClass()) {
			return false;
		}
		else {
			CityBus otherObj = (CityBus) otherObject;
			return (getTicketPrice() == otherObj.getTicketPrice() && getNbStops() == otherObj.getNbStops()
					&&  getRouteNb() == otherObj.getRouteNb() && getBeganOpYr() == otherObj.getBeganOpYr()
					&& 	getLineName().equals(otherObj.getLineName()) && getDriverName().equals(otherObj.getDriverName()));
		}
	}
	
	/**
	 *Overriding toString method; displays all properties of this object.
	 *
	 *In addition, the instance variables used here that are exclusively part of this class have been changed to their getters instead 
	 *(e.g.: routeNb -> getRouteNb()). Although the former is also safe here, the latter would be better since if there are any modification 
	 *to those methods, they will also be applied here.
	 */
	public String toString() {
		return ("This City Bus' info --> Ticket Price: " + getTicketPrice() + "$ | Number of Stops: " + getNbStops() + " | Route Number: " 
				+ getRouteNb() + " | Began Operations Year: " + getBeganOpYr() + " | Line Name: " + getLineName() + " | Driver Name: " + getDriverName());
	}
		
	
	/**mutator methods (4)*/
	public void setRouteNb(long aRouteNb) {
		if(aRouteNb < 0) {
			System.out.println("Input cannot be negative");
		}
		else {
			routeNb = aRouteNb;
		}
	}

	/**mutator methods (4)*/
	public void setBeganOpYr(int aBeganOpYr) {
		if(aBeganOpYr < 0) {
			System.out.println("Input cannot be negative");
		}
		else {
			beganOpYr = aBeganOpYr;
		}
	}

	/**mutator methods (4)*/
	public void setLineName(String aLineName) {
		lineName = aLineName;
	}
	
	/**mutator methods (4)*/
	public void setDriverName(String aDriverName) {
		driverName = aDriverName;
	}
	
	/**accessor methods (4)*/
	public long getRouteNb() {
		return routeNb;
	}
	
	/**accessor methods (4)*/
	public int getBeganOpYr() {
		return beganOpYr;
	}
	
	/**accessor methods (4)*/
	public String getLineName() {
		return lineName;
	}
	
	/**accessor methods (4)*/
	public String getDriverName() {
		return driverName;
	}
}
