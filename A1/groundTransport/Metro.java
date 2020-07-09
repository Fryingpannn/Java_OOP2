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

/**
 * This is the Metro class file which extends CityBus, and it's the grandchild class of the PublicTransportation class.
 * 
 * @author Matthew Pan 40135588
 */
public class Metro extends CityBus
{
	/**Number of vehicules*/
	private int nbVehicule;
	/**Name of city*/
	private String cityName;
	
	/**Sets the values to default for this Metro*/
	public Metro() {
		super();
		setNbVehicule(0);
		setCityName("None");
	}
	
	/**
	 * Sets the values to these 8 parameters for this Metro.
	 * 
	 * @param aTicketPrice price per ticket
	 * @param aNbStops number of stops
	 * @param aRouteNb route number
	 * @param aBeganOpYr began operation year
	 * @param aLineName name of line
	 * @param aDriverName driver's name
	 * @param aNbVehicule number of vehicules
	 * @param aCityName name of city
	 */
	public Metro(double aTicketPrice, int aNbStops, long aRouteNb, int aBeganOpYr, String aLineName, String aDriverName, int aNbVehicule, String aCityName) {
		super(aTicketPrice, aNbStops, aRouteNb, aBeganOpYr, aLineName, aDriverName);
		setNbVehicule(aNbVehicule);
		setCityName(aCityName);
	}
	
	/**
	 * Copy constructor; copies the values inside aCopy to the new obj. 
	 * 
	 * In addition, the instance variables used here that are exclusively part of this class have been changed to their getters instead 
	 * (e.g.: aCopy.nbVehicule -> aCopy.getNbVehicule()). Although the former is also safe here, the latter would be better since if there 
	 * are any modification to those methods, they will also be applied here.
	 * 
	 * @param aCopy object to copy from
	 */
	public Metro(Metro aCopy) {
		setTicketPrice(aCopy.getTicketPrice());
		setNbStops(aCopy.getNbStops());
		setRouteNb(aCopy.getRouteNb());
		setBeganOpYr(aCopy.getBeganOpYr());
		setLineName(aCopy.getLineName());
		setDriverName(aCopy.getDriverName());
		setNbVehicule(aCopy.getNbVehicule());
		setCityName(aCopy.getCityName());
	}
	
	/** 
	 * Overriding equals method. 
	 * 
	 * Null verification is very important. If it isn't included and the equals method is used on a null object,
	 * it will terminate the program and throw a NullPointerException error because null points to nothing. 
	 * 
	 * In addition, the instance variables used here that are exclusively part of this class have been changed to their getters instead 
	 * (e.g.: aCopy.nbVehicule -> aCopy.getNbVehicule()). Although the former is also safe here, the latter would be better since if there 
	 * are any modification to those methods, they will also be applied here. 
	 * */
	public boolean equals(Object otherObject) {
		if(otherObject == null) {
			return false;
		}
		else if(getClass() != otherObject.getClass()) {
			return false;
		}
		else {
			Metro otherObj = (Metro) otherObject;
			return (getTicketPrice() == otherObj.getTicketPrice() && getNbStops() == otherObj.getNbStops()
					&&  getRouteNb() == otherObj.getRouteNb() && getBeganOpYr() == otherObj.getBeganOpYr()
					&& 	getLineName().equals(otherObj.getLineName()) && getDriverName().equals(otherObj.getDriverName())
					&&  getNbVehicule() == otherObj.getNbVehicule() && getCityName() == otherObj.getCityName());
		}
	}
	
	/**
	 *Overriding toString method; displays all properties of this object.
	 *
	 *In addition, the instance variables used here that are exclusively part of this class have been changed to their getters instead 
	 *(e.g.: nbVehicule -> getNbVehicule()). Although the former is also safe here, the latter would be better since if there are any modification 
	 *to those methods, they will also be applied here.
	 */
	public String toString() {
		return ("This Metro's info --> Ticket Price: " + getTicketPrice() + "$ | Number of Stops: " + getNbStops() + " | Route Number: " 
				+ getRouteNb() + " | Began Operations Year: " + getBeganOpYr() + " | Line Name: " + getLineName() + " | Driver Name: " + getDriverName()
				+ " | Number of Vehicules: " + getNbVehicule() + " | City Name: " + getCityName());
		
	}

	/**mutator methods (2)*/
	public void setNbVehicule(int aNbVehicule) {
		if(aNbVehicule < 0) {
			System.out.println("Input cannot be negative");
		}
		else {
			nbVehicule = aNbVehicule;
		}
	}
	
	/**mutator methods (2)*/
	public void setCityName(String aCityName) {
		cityName = aCityName;
	}
	
	/**accessor methods (2)*/
	public int getNbVehicule() {
		return nbVehicule;
	}
	
	/**accessor methods (2)*/
	public String getCityName() {
		return cityName;
	}
	
	
}
