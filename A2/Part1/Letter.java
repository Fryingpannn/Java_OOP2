package Part1;

/*---------------------------------
 * Name: Matthew Pan               | 
 * Student ID: 40135588            |
 * Comp 249: Assignment #2         |
 * Driver file: TruckPackageDriver |
 * Part 1                          |
 * Due Date: 25 July, 2020         |
 * Professor: Dr. Yuhong Yan       |
 *---------------------------------
 */
/**
 * Letter class which inherits from Package and implements testWeight() and computeCost()
 * @author Matthew Pan
 */
public class Letter extends Package{
	
	/**
	 * no args constructor
	 */
	public Letter() {
		super();
		setTrackingNb(0);
	}
	
	/**
	 * @param aTracking tracking nb
	 * @param aWeight weight in ounces
	 */
	public Letter(int aTracking, double aWeight) {
		super(aTracking, aWeight);
	}
	
	/**
	 * Used when loading to truck: tests if package weight is valid
	 * 
	 * @return true if weight is valid, false if invalid.
	 */
	public boolean testWeight() {
		//try block to test weight excess; used when loading Truck
		try {
			if(toOunces(getWeight()) <= 32 && getWeight() >= 0) { //max weight in ounces: 32 (2 pounds)
				return true;
			}
			else {
				throw new PackageException("[Maximum weight reached] Package info: ");
			}
		}
		catch (PackageException e) {
			System.err.println(e.getMessage() + "\n" + this);
			return false;
		}
	}
	
	/**
	 *Calculates the shipping cost of this letter obj 
	 */
	public double computeCost() {
		return (0.05 * getWeight());
	}
	
	/**
	 *Displays this letter
	 */
	public String toString() {
		return ("Letter -> " + super.toString() + " | Weight (oz): " + toOunces(getWeight()));
	}
	
	/**
	 * @return weight of letter in pounds
	 */
	public double getWeight() {
		return (toPounds(super.getWeight()));
	}
	
	/**
	 * Setting the tracking number inappropriately will trigger an exception, and will prevent it from
	 * being successfully loaded in truck.
	 * 
	 *@param aTracking the tracking number to be set to
	 */
	public void setTrackingNb(int aTracking) {
		int lastDigit = aTracking % 10; //extracts last digit
		try {
			if(lastDigit == 0) {
				super.setTrackingNb(aTracking);; //setting the tracking nb
			}
			else {//throws exception if wrong last digit
				throw new PackageException("[A Letter package has the wrong tracking number digit. "
						+ "This package will not be loaded in the Truck and its number will be set to -1. "
						+ "Package Info: ");
			}
		}
		catch (PackageException e) {
			System.err.println(e.getMessage());
			super.setTrackingNb(-1);
		}
	}
}