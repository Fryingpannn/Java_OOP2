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
 * This is the Truck class file which encapsulates informations regarding the cargo for packages
 * @author Matthew Pan
 */
public class Truck {
	
	//private variables
	private double unloadedW;//unloaded weight in pounds of truck
	private String driverName; 
	private String origin; 	 //originating city
	private String end;		 //destination city
	private Package[] trunk = new Package[maxPkg]; //array of packages, max 5 pkgs
	/**Maximum nb of packages per truck, using 5 instead of 200 for easier testing*/
	public static final int maxPkg = 5;
	
	/**
	 * no args constructor
	 */
	public Truck() {
		setDriverName("none");
		setOrigin("none");
		setEnd("none");
		setUnloadedW(7000);
	}
	
	/**
	 * @param aName truck driver name
	 * @param origin origin point
	 * @param end destination point
	 */
	public Truck(String aName, String origin, String end, double aUnloadedW) {
		setDriverName(aName);
		setOrigin(origin);
		setEnd(end);
		setUnloadedW(aUnloadedW);
	}
	
	/**
	 * 	Test if each Package in array is:
	 *  1. not null 2. tracking number and weight are correct 3. trunk[] is not full
	 *  It first checks if there is an empty spot, then assigns the package if it's valid.
	 *  If truck is full, and there are still packages unloaded, it will throw an exception.
	 * 
	 * @param pkg Package we want to load
	 */
	public void load(Package[] arr) {	
		int i = 0;
		
		//for loop to test tracking number and weight validity, then adds package to truck
		for(i = 0; i < trunk.length; i++) {
			if(trunk[i] == null) {
				if(arr[i] != null && arr[i].testTrackNb() & arr[i].testWeight()) {
					trunk[i] = arr[i];
				}
				else {
					if(arr[i] != null)
						System.out.println("--> Package not loaded.");
					else
						System.out.println("--> No more packages left to load.");
				}
			}
			else
				continue;
		}
		//If truck is full, and there are still more packages to be loaded, will throw this exception.
		int j = 0;
		for(j = i; j < arr.length; j++) {
			try {
				if(arr.length > trunk.length && arr[j] != null)
					throw new PackageException("Truck is full. Cannot load extra package: ");
			}	//Displays extra packages that could not be loaded
			catch (PackageException e) {
				System.err.println(e.getMessage() + "\n" + arr[j]);
			}
		}
	}

	/**
	 * This method removes the package wanted, as well as rearrange the packages in the array
	 * if the removed package was in the middle of the array.
	 * 
	 * @param d The index of the package the user wants to remove.
	 */
	public void unload(int d) {
		if(d < trunk.length) {
			Package deleted = trunk[d];
			trunk[d] = null; //removing package
			
			//rearrange the elements in order if deleted element was not the last package
			if(d <= trunk.length -2) {
				for(int i = 0; i < trunk.length -1; i++) {
					if(i >= d) {
						trunk[i] = trunk[i+1];
						trunk[i+1] = null;
					}
				}
			}
			System.out.println("-> Successfully unloaded package number " + d + ":");
			System.out.println("[UNLOADED] " + d + ". " + deleted);
		}
		else //if chosen index is invalid, print error
			System.out.println("Invalid package choice: no packages have been unloaded.");
	}
	
	/**
	 *Displays properties of truck
	 */
	public String toString() {
		return ("Truck -> Driver Name: " + getDriverName() + " | Departure: " + getOrigin() + " | Arrival: "
				+ getEnd() + " | Total weight: " + getGrossW() + " | Unloaded Weight: " + unloadedW
				+ " | Total income: $" + getGrossCost());
	}

	/**
	 * Displays all packages in truck
	 */
	public void displayPkg() {
		System.out.println("\n- Displaying packages in truck: \n");
		
		for(int i = 0; i < trunk.length; i++) {
			if(trunk[i] != null)
				System.out.println("- " + i + ". " + trunk[i]);
			else
				System.out.println("- Empty slot.");
		}
		System.out.println();
	}
	
	/**
	 * @param weight in pounds
	 * @return weight in kilograms
	 */
	public double toKilograms(double w) {
		return (w/2.2);
	}
	
	/**
	 * @param weight in kilograms
	 * @return weight in pounds
	 */
	public double toPounds(double w) {
		return (w * 2.2);
	}
	
	public void drive() {
		System.out.println("\n- Driving from " + getOrigin() + " to " + getEnd() + "...");
		System.out.println("\t25%...\n\t50%...\n\t75%...\n\t...100%: Truck has arrived at " + getEnd() + "!\n");
	}
	
	//>> Getters & Setters below <<
	
	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}
	
	/**
	 * @param driverName the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	/**
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}
	
	/**
	 * @param end the end to set
	 */
	public void setEnd(String end) {
		this.end = end;
	}
	
	/**
	 * @return string indicating gross/total weight of truck in pounds and KG
	 */
	public String getGrossW() {
		double totalW = 0;
		
		for(int i = 0; i < trunk.length; i++) {
			if(trunk[i] != null)
				totalW += trunk[i].getWeight();
		}
		return ("Lbs: " + (totalW + unloadedW) + " | Kg: " + toKilograms(totalW + unloadedW));
	}
	
	/**
	 * @return the number of packages in truck
	 */
	public int getNbPkg() {
		int count = 0;
		
		for(int i = 0; i < trunk.length; i++) {
			if(trunk[i] != null)
				count++;
		}
		return count;
	}

	/**
	 * @return the gross income
	 */
	public double getGrossCost() {
		double totalG = 0;
		
		//for loop to add all the shipping costs of each packages
		for(int i = 0; i < trunk.length; i++) {
			if(trunk[i] != null)
				totalG += trunk[i].getShippingCost();
		}
		return totalG;
	}
	
	/**
	 * @return unloaded weight of truck (lbs)
	 */
	public double getUnloadedW() {
		return unloadedW;
	}
	
	/**
	 * @param weight to set to truck
	 */
	public void setUnloadedW(double w) {
		unloadedW = w;
	}
}
