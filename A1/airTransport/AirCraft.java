package airTransport;

import publicTransport.PublicTransportation;

public class AirCraft extends PublicTransportation 
{
	private AirType classType;
	private TimeType maintainType;
	
	//default constructor
	public AirCraft() {
		super();
		classType = AirType.NONE;
		maintainType = TimeType.NONE;
	}
	
	//parameterized constructor
	public AirCraft(double aTicketPrice, int aNbStops, AirType aClassType, TimeType aMaintainType) {
		super(aTicketPrice, aNbStops);
		classType = aClassType;
		maintainType = aMaintainType;
	}
	
	//copy constructor
	public AirCraft(AirCraft aCopy) {
		setTicketPrice(aCopy.getTicketPrice());
		setNbStops(aCopy.getNbStops());
		classType = aCopy.classType;
		maintainType = aCopy.maintainType;
	}
	
	//nested enums used for AirCraft attributes (2)
	public enum AirType	{
		NONE,
		HELICOPTER,
		AIRLINE,
		BALLOON,
		GLIDER
	}
	
	public enum TimeType{
		NONE,
		WEEKLY,
		MONTHLY,
		YEARLY
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
			AirCraft otherObj = (AirCraft) otherObject;
			return (getTicketPrice() == otherObj.getTicketPrice() && getNbStops() == otherObj.getNbStops()
					&& classType == otherObj.getClassType() && maintainType == otherObj.getMaintainType());
		}
	}
	
	//overriding toString method
	public String toString() {
		return("This AirCraft's info --> Ticket Price: " + getTicketPrice() + "$ | Number of Stops: " + getNbStops() + " | Class Type: "
				+ classType + " | Maintenance Type: " + maintainType);
	}
	
	//mutator methods (2)
	public void setClassType(AirType aClassType) {
		classType = aClassType;
	}
	
	public void setMaintainType(TimeType aMaintainType) {
		maintainType = aMaintainType;
	}
	
	//accessor methods (2)
	public AirType getClassType() {
		return classType;
	}
	
	public TimeType getMaintainType() {
		return maintainType;
	}
}
