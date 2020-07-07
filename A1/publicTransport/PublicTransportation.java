package publicTransport;

public class PublicTransportation 
{
	private double ticketPrice;
	private int nbStops;
	
	//default constructor
	public PublicTransportation() {
		ticketPrice = 0;
		nbStops = 0;	//number of stops
	}
	
	//parameterized constructor
	public PublicTransportation(double aTicketPrice, int aNbStops) {
		ticketPrice = aTicketPrice;
		nbStops = aNbStops;
	}
	
	//copy constructor
	public PublicTransportation(PublicTransportation aCopy) {
		ticketPrice = aCopy.ticketPrice;
		nbStops = aCopy.nbStops;
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
			PublicTransportation otherObj = (PublicTransportation) otherObject;
			return (ticketPrice == otherObj.ticketPrice && nbStops == otherObj.nbStops);
			
		}
	}
	
	//overriding toString method
	public String toString() {
		return ("This Public Transportation's info --> Ticket Price: " + ticketPrice + "$ | Number of Stops: " + nbStops);
	}
	
	//mutator methods (2)
	public void setTicketPrice(double aTicketPrice) {
		ticketPrice = aTicketPrice;
	}
	
	public void setNbStops(int aNbStops) {
		nbStops = aNbStops;
	}
	
	//accessor methods (2)
	public double getTicketPrice() {
		return ticketPrice;
	}
	
	public int getNbStops() {
		return nbStops;
	}
}
