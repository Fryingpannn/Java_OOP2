package Part2;

public class Cargoship {
	private long serialNb;
	private String name;		 //continuous string, or separated by _
	private int creationYr;
	private String ownerCountry; //continuous string, or separated by _
	private double price;
	private int speed;
	
	/**
	 * no args constructor
	 */
	public Cargoship() {
		this.serialNb = 0;
		this.name = "none";
		this.creationYr = 0;
		this.ownerCountry = "none";
		this.price = 0;
		this.speed = 0;
	}
	
	/**
	 * @return the serialNb
	 */
	public long getSerialNb() {
		return serialNb;
	}
	/**
	 * @param serialNb the serialNb to set
	 */
	public void setSerialNb(long serialNb) {
		this.serialNb = serialNb;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the creationYr
	 */
	public int getCreationYr() {
		return creationYr;
	}
	/**
	 * @param creationYr the creationYr to set
	 */
	public void setCreationYr(int creationYr) {
		this.creationYr = creationYr;
	}
	/**
	 * @return the ownerCountry
	 */
	public String getOwnerCountry() {
		return ownerCountry;
	}
	/**
	 * @param ownerCountry the ownerCountry to set
	 */
	public void setOwnerCountry(String ownerCountry) {
		this.ownerCountry = ownerCountry;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String toString() {
		return (serialNb + " " + name + " " + creationYr + " " + ownerCountry + " " + price + " " + speed + " ");
	}
}
