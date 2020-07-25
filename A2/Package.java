
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
 * This is the abstract class for Letter, Box, WoodCrate and MetalCrate
 * @author Matthew Pan
 */
abstract public class Package {
	private int trackingNb;	//tracking nb, encodes type of pkg + origin and end city
	private double weight;	//pkg weight
	private double shippingCost; //shipping cost based on weight
	private String pkgType; //package type

	/**
	 * no args constructor
	 */
	public Package() {
		weight = 0;
		setShippingCost(computeCost());
		setPkgType();
	}
	
	/**
	 * param constructor
	 * 
	 * @param aTracking tracking nb
	 * @param aWeight weight of package
	 * @param aCost shipping cost of pkg
	 */
	public Package(int aTracking, double aWeight) {
		setTrackingNb(aTracking);
		setWeight(aWeight);
		setShippingCost(computeCost());
		setPkgType();
	}
	
	/**
	 * computes the shipping cost of a given pkg
	 * @return the shipping cost of a package
	 */
	abstract public double computeCost();
	
	/**
	 * Used when loading to truck: tests if package weight is valid
	 * 
	 * @return true if weight is valid, false if invalid.
	 */
	abstract public boolean testWeight();
	

	/**
	 * Used when loading to truck: tests if package tracking nb is valid
	 * 
	 * @return true if valid tracking number, false if invalid.
	 */
	public boolean testTrackNb() {
		try {
			int lastDigit = trackingNb % 10; //extracts last digit
			
			if(trackingNb >= 0 && lastDigit < 4) {
				return true; //setting the tracking nb
			}
			else {
				throw new PackageException("[Invalid tracking number] Package Info: ");
			}
		}
		catch (PackageException e) {
			System.err.println(e.getMessage());
			System.err.println(this);
			return false;
		}
	}
	
	/**
	 * @param weight in pounds
	 * @return weight in ounces 
	 */
	public double toOunces(double w) {
		return (w * 16); 
	}
	
	/**
	 * @param weight in ounces
	 * @return weight in pounds
	 */
	public double toPounds(double w) {
		return (w/16);
	}
	
	/**
	 * display Package
	 */
	public String toString() {
		return ("Tracking Number: " + getTrackingNb() + " | Package Type: " + getPkgType()
		+ " | Shipping Cost: $" + getShippingCost());
	}
	
	/**
	 * @return the trackingNb
	 */
	public int getTrackingNb() {
		return trackingNb;
	}
	
	/**
	 * This setter verifies if the package is valid by checking its last digit and if it's positive
	 * 
	 * @param aTracking new tracking nb
	 */
	public void setTrackingNb(int aTracking) {
		trackingNb = aTracking;
	}
	
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * @param weight sets the weight and checks if it's positive.
	 */
	public void setWeight(double weight) {
		try {
			if(weight >= 0)
				this.weight = weight;
			else {
				throw new PackageException("[Weight cannot be negative] This package will not be added when loading to truck.");
			}
		}
		catch(PackageException e) {
			System.err.println(e.getMessage());
			this.weight = weight;
		}
	}
	
	/**
	 * @return the shippingCost
	 */
	public double getShippingCost() {
		return shippingCost;
	}
	
	/**
	 * @param shippingCost the shippingCost to set
	 */
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	/**
	 * sets the package type depending on the tracking number's last digit
	 */
	public void setPkgType() {
		int lastDigit = trackingNb % 10;
		
		switch(lastDigit) {
		case 0: pkgType = "Letter";
			break;
		case 1: pkgType = "Box";
			break;
		case 2: pkgType = "Wooden Crate";
			break;
		case 3: pkgType = "Metal Crate";
			break;
		default: pkgType = "Unknown Package";
		}
	}
	
	/**
	 * @return package type
	 */
	public String getPkgType() {
		return pkgType;
	}
}
