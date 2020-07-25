
/*---------------------------------
 * Name: Matthew Pan               | 
 * Student ID: 40135588            |
 * Comp 249: Assignment #2         |
 * Part 1                          |
 * Due Date: 25 July, 2020         |
 * Professor: Dr. Yuhong Yan       |
 *---------------------------------
 */
/**
 * CargoTest class which tests the methods of the Truck and Package classes
 * @author Matthew Pan
 */
public class CargoTest {

	/**
	 * Tests truck instantiation, package loading, gross income, truck weight, drives truck to
	 * its destination and unloads weight. There are also three test cases which can be uncommented
	 * to test exception handling: wrong tracking nb/max weight/truck full.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Start message
		System.out.println("--------------------------- Start of Cargo Test ---------------------------\n");
		
		//creating truck: "Name, Start, End, Unloaded Weight (lbs)"
		System.out.println("- Displaying freshly instantiated truck: ");
		Truck truck1 = new Truck("Matthew", "Boston", "Montreal", 7000);
		System.out.println(truck1 + "\n");
	
		//array containing packages to be stored in truck
		Package[] toLoad = new Package[7];
		
		/* Normal test case: No errors */
		toLoad[0] = new Letter(100, 32); 	 //Letter: max weight 32, #0
		toLoad[1] = new Box(101, 35); 		 //Box: max weight 40, #1
		toLoad[2] = new WoodCrate(102, 50);  //WoodCrate: max weight 80, #2
		toLoad[3] = new MetalCrate(103, 90); //MetalCrate: max weight 100, #3
		toLoad[4] = new WoodCrate(112, 80);
		
		/* Error test cases below: simply uncomment to test */
		//toLoad[4] = new Letter(-1, 32);	   //--> Package with wrong tracking number exception
		//toLoad[3] = new Box(101, 41);		   // --> Package exceeding max weight exception
		//toLoad[5] = new MetalCrate(113, 60); //--> Loading an extra package when truck is already full

		//Loading truck with packages chosen
		System.out.println("- Now loading the truck with its packages:");
		System.out.println("\t25%...\n\t50%...\n\t75%...\n\t...100%: Truck has been fully loaded!\n");
		truck1.load(toLoad);
		
		System.out.println("\n");
		truck1.displayPkg();
		
		//Display gross income
		System.out.println("- Gross income earned by the shipping of cargo: ");
		System.out.println("\t-> " + truck1.getGrossCost() + "$\n");
		
		//Display weight of truck after being loaded
		System.out.println("- Gross weight of truck with packages loaded: ");
		System.out.println("\t-> " + truck1.getGrossW());
		
		//Drive the truck
		truck1.drive();
		
		//Unloading the truck
		System.out.println("- Now unloading the truck completely: ");
		for(int i = Truck.maxPkg -1; i >= 0; i--) {
			truck1.unload(i);
		}
		System.out.println();
		truck1.displayPkg();
		
		//End message
		System.out.println("--------------------------- End of Cargo Test ---------------------------");
	}
}
