package seaTransport;

import publicTransport.PublicTransportation;

public class Ferry extends PublicTransportation
{
	private int buildYr;
	private String shipName;
	
	//default constructor
	public Ferry() {
		super();
		buildYr = 0;
		shipName = "None";
	}
	
	//parameterized constructor
	public Ferry(double aTicketPrice, int aNbStops, int aBuildYr, String aShipName) {
		super(aTicketPrice, aNbStops);
		buildYr = aBuildYr;
		shipName = aShipName;
	}
	
	//copy constructor
	public Ferry(Ferry aCopy) {
		setTicketPrice(aCopy.getTicketPrice());
		setNbStops(aCopy.getNbStops());
		buildYr = aCopy.buildYr;
		shipName = aCopy.shipName;
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
			Ferry otherObj = (Ferry) otherObject;
			return (getTicketPrice() == otherObj.getTicketPrice() && getNbStops() == otherObj.getNbStops()
					&&  buildYr == otherObj.getBuildYr() && shipName.equals(otherObj.getShipName()));
		}
	}
	
	//overriding toString method
	public String toString() {
		return ("This Ferry's info --> Ticket Price: " + getTicketPrice() + "$ | Number of Stops: " + getNbStops() + " | Build Year: "
				+ buildYr + " | Ship Name: " + shipName);
	}
	
	//mutator methods (2)
	public void setBuildYr(int aBuildYr) {
		buildYr = aBuildYr;
	}
	
	public void setShipName(String aShipName) {
		shipName = aShipName;
	}
	
	//accessor methods (2)
	public int getBuildYr() {
		return buildYr;
	}
	
	public String getShipName() {
		return shipName;
	}
	
	
}
