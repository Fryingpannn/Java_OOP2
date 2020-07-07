package groundTransport;

public class Tram extends CityBus
{
	private int maxSpeed;	//max speed of Tram
	
	//default constructor
	public Tram() {
		super();
		maxSpeed = 0;
	}
	
	//parameterized constructor
	public Tram(double aTicketPrice, int aNbStops, long aRouteNb, int aBeganOpYr, String aLineName, String aDriverName, int aMaxSpeed) {
		super(aTicketPrice, aNbStops, aRouteNb, aBeganOpYr, aLineName, aDriverName);
		maxSpeed = aMaxSpeed;
	}
	
	//copy constructor
	public Tram(Tram aCopy) {
		setTicketPrice(aCopy.getTicketPrice());
		setNbStops(aCopy.getNbStops());
		setRouteNb(aCopy.getRouteNb());
		setBeganOpYr(aCopy.getBeganOpYr());
		setLineName(aCopy.getLineName());
		setDriverName(aCopy.getDriverName());
		maxSpeed = aCopy.maxSpeed;
	}
	
	//overriding equals method
	public boolean equals(Object otherObject) {
		if(otherObject == null) {
			return false;
		}
		else if(getClass() != otherObject.getClass()) {
			return false;
		}
		else {
			Tram otherObj = (Tram) otherObject;
			return (getTicketPrice() == otherObj.getTicketPrice() && getNbStops() == otherObj.getNbStops()
					&&  getRouteNb() == otherObj.getRouteNb() && getBeganOpYr() == otherObj.getBeganOpYr()
					&& 	getLineName().equals(otherObj.getLineName()) && getDriverName().equals(otherObj.getDriverName())
					&&	maxSpeed == otherObj.getMaxSpeed());
		}
	}
	
	//overriding toString method
	public String toString() {
		return ("This Metro's info --> Ticket Price: " + getTicketPrice() + "$ | Number of Stops: " + getNbStops() + " | Route Number: " 
				+ getRouteNb() + " | Began Operations Year: " + getBeganOpYr() + " | Line Name: " + getLineName() + " | Driver Name: " + getDriverName()
				+ " | Maximum Speed: " + maxSpeed + "km/h");
	}
	
	//mutator method
	public void setMaxSpeed(int aMaxSpeed) {
		maxSpeed = aMaxSpeed;
	}
	
	//accessor method
	public int getMaxSpeed() {
		return maxSpeed;
	}
}
