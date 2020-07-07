package groundTransport;

public class Metro extends CityBus
{
	private int nbVehicule;	//number of vehicules
	private String cityName;
	
	//default constructor
	public Metro() {
		super();
		nbVehicule = 0;
		cityName = "None";
	}
	
	//parameterized constructor
	public Metro(double aTicketPrice, int aNbStops, long aRouteNb, int aBeganOpYr, String aLineName, String aDriverName, int aNbVehicule, String aCityName) {
		super(aTicketPrice, aNbStops, aRouteNb, aBeganOpYr, aLineName, aDriverName);
		nbVehicule = aNbVehicule;
		cityName = aCityName;
	}
	
	//copy constructor
	public Metro(Metro aCopy) {
		setTicketPrice(aCopy.getTicketPrice());
		setNbStops(aCopy.getNbStops());
		setRouteNb(aCopy.getRouteNb());
		setBeganOpYr(aCopy.getBeganOpYr());
		setLineName(aCopy.getLineName());
		setDriverName(aCopy.getDriverName());
		nbVehicule = aCopy.nbVehicule;
		cityName = aCopy.cityName;
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
			Metro otherObj = (Metro) otherObject;
			return (getTicketPrice() == otherObj.getTicketPrice() && getNbStops() == otherObj.getNbStops()
					&&  getRouteNb() == otherObj.getRouteNb() && getBeganOpYr() == otherObj.getBeganOpYr()
					&& 	getLineName().equals(otherObj.getLineName()) && getDriverName().equals(otherObj.getDriverName())
					&&  nbVehicule == otherObj.getNbVehicule() && cityName == otherObj.getCityName());
		}
	}
	
	//overriding toString method
	public String toString() {
		return ("This Metro's info --> Ticket Price: " + getTicketPrice() + "$ | Number of Stops: " + getNbStops() + " | Route Number: " 
				+ getRouteNb() + " | Began Operations Year: " + getBeganOpYr() + " | Line Name: " + getLineName() + " | Driver Name: " + getDriverName()
				+ " | Number of Vehicules: " + nbVehicule + " | City Name: " + cityName);
		
	}

	//mutator methods (2)
	public void setNbVehicule(int aNbVehicule) {
		nbVehicule = aNbVehicule;
	}
	
	public void setCityName(String aCityName) {
		cityName = aCityName;
	}
	
	//accessor methods (2)
	public int getNbVehicule() {
		return nbVehicule;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	
}
