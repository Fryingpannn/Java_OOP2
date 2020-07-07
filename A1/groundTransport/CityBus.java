package groundTransport;

import publicTransport.PublicTransportation;

public class CityBus extends PublicTransportation 
{
	private long routeNb;	//route number
	private int beganOpYr;	//begin operation year
	private String lineName;
	private String driverName;

	//default constructor
	public CityBus() {
		super();
		routeNb = 0;
		beganOpYr = 0;
		lineName = "None";
		driverName = "None";
	}
	
	//parameterized constructor
	public CityBus(double aTicketPrice, int aNbStops, long aRouteNb, int aBeganOpYr, String aLineName, String aDriverName) {
		super(aTicketPrice, aNbStops);
		routeNb = aRouteNb;
		beganOpYr = aBeganOpYr;
		lineName = aLineName;
		driverName = aDriverName;
	}
	
	//copy constructor
	public CityBus(CityBus aCopy) {
		setTicketPrice(aCopy.getTicketPrice());
		setNbStops(aCopy.getNbStops());
		routeNb = aCopy.routeNb;
		beganOpYr = aCopy.beganOpYr;
		lineName = aCopy.lineName;
		driverName = aCopy.driverName;
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
			CityBus otherObj = (CityBus) otherObject;
			return (getTicketPrice() == otherObj.getTicketPrice() && getNbStops() == otherObj.getNbStops()
					&&  routeNb == otherObj.getRouteNb() && beganOpYr == otherObj.getBeganOpYr()
					&& 	lineName.equals(otherObj.getLineName()) && driverName.equals(otherObj.getDriverName()));
		}
	}
	
	//overriding toString method
	public String toString() {
		return ("This City Bus' info --> Ticket Price: " + getTicketPrice() + "$ | Number of Stops: " + getNbStops() + " | Route Number: " 
				+ routeNb + " | Began Operations Year: " + beganOpYr + " | Line Name: " + lineName + " | Driver Name: " + driverName);
	}
		
	//mutator methods (4)
	public void setRouteNb(long aRouteNb) {
		routeNb = aRouteNb;
	}
	
	public void setBeganOpYr(int aBeganOpYr) {
		beganOpYr = aBeganOpYr;
	}
	
	public void setLineName(String aLineName) {
		lineName = aLineName;
	}
	
	public void setDriverName(String aDriverName) {
		driverName = aDriverName;
	}
	
	//accessor methods (4)
	public long getRouteNb() {
		return routeNb;
	}
	
	public int getBeganOpYr() {
		return beganOpYr;
	}
	
	public String getLineName() {
		return lineName;
	}
	
	public String getDriverName() {
		return driverName;
	}
}
