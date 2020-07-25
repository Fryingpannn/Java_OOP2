
/*---------------------------------
 * Name: Matthew Pan               | 
 * Student ID: 40135588            |
 * Comp 249: Assignment #2         |
 * Class files: Truck, Package..   |
 * Part 1                          |
 * Due Date: 25 July, 2020         |
 * Professor: Dr. Yuhong Yan       |
 *---------------------------------
 */
import java.util.Scanner;

/**
 * TruckPackageDriver class which prompts a menu for user to manipulate a cargo truck and its packages.
 * Class files used: Truck, Package, Letter, Box, WoodCrate, MetalCrate, PackageException.
 * 
 * @author Matthew Pan
 */
public class TruckPackageDriver {

	/**
	 * Main method which displays the menu and allows user to pick the action they want.
	 * Most menu options are linked to a static method below the main method which 
	 * performs the demanded action.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//initializing variables
		Scanner read = new Scanner(System.in);
		boolean loop = true;	//keep looping menu if true
		Truck trucker = null;	//declaring the truck to load
		
		//while loop to keep the menu going until user quits
		while(loop) {
			//Display menu
			System.out.println("\n---------------- Truck Cargo Management Program ----------------\n");
			System.out.println("What would you like to do?");
			
			System.out.println("\t1. Start a cargo");
			System.out.println("\t\ta. Driver name");
			System.out.println("\t\tb. Unloaded weight");
			System.out.println("\t\tc. Departure city");
			System.out.println("\t\td. Arrival city");
			
			System.out.println("\t2. Load the truck with all packages");
			System.out.println("\t\ta. Package tracking number");
			System.out.println("\t\tb. Package weight (oz; lbs)");
			System.out.println("\t\tc. Package shipping cost");
			
			System.out.println("\t3. Unload a package");
			System.out.println("\t4. The number of packages loaded");
			System.out.println("\t5. Display the packages in side truck");
			System.out.println("\t6. The gross income earned by shipping of the cargo");
			System.out.println("\t7. Weight the truck (after loading packages)");
			System.out.println("\t8. Drive the truck to destination");
			System.out.println("\t-. Any other number: Quit program");
			System.out.print("\n--> Please enter your number choice and press <Enter>: ");
			
			//prompts user to input first choice of menu
			int choice;
			while(!read.hasNextInt()) {
				System.err.println("\n--> Please enter a valid number choice.");
				read.nextInt();
			}
			choice = read.nextInt();
			
			switch(choice) {
			case 1: trucker = startCargo(trucker);
				break;
			case 2: trucker = loadTruck(trucker);
				break;
			case 3: trucker = unloadTruck(trucker);
				break;
			case 4: displayNbPkg(trucker);
				break;
			case 5: trucker.displayPkg();
				break;
			case 6: displayGrossIncome(trucker);
				break;
			case 7: displayWeight(trucker);
				break;
			case 8: trucker.drive();
				break;
			default: loop = false;
					System.out.println("\n----------------- [END] Thank you for using the program [END] --------------------");
			}
		}
		read.close();
	}
	
	/**method to start cargo*/
	public static Truck startCargo(Truck trucker) {
		trucker = new Truck("Matthew Pan", "Boston", "Montreal", 7000);
		
		System.out.println("\n--> [A cargo has been started] Truck info: ");
		System.out.println("\t- Driver name: " + trucker.getDriverName());
		System.out.println("\t- Unloaded weight (lbs): " + trucker.getUnloadedW());
		System.out.println("\t- Departure city: " + trucker.getOrigin());
		System.out.println("\t- Arrival city: " + trucker.getEnd());
		
		return trucker;
	}
	
	/**method to load truck with all packages*/
	public static Truck loadTruck(Truck trucker) {
		//creating packages to load in truck
		Package[] toLoad = new Package[8];
		
		toLoad[0] = new Letter(100, 32); 	//Letter: max weight 32, 		#0
		toLoad[1] = new Box(101, 35); 		//Box: max weight 40, 			#1
		toLoad[2] = new WoodCrate(102, 50); 	//WoodCrate: max weight 80, #2
		toLoad[3] = new MetalCrate(103, 90); //MetalCrate: max weight 100, 	#3
		toLoad[4] = new WoodCrate(112, 80);
		
		System.out.println("\n--> [Now loading the truck with its packages]:");
		System.out.println("\t25%...\n\t50%...\n\t75%...\n\t...100%: Truck has been fully loaded!\n");
		//loading truck with these packages and displaying inventory
		trucker.load(toLoad);
		trucker.displayPkg();
	
		return trucker;
	}
	
	/**method to unload one package of the truck*/
	public static Truck unloadTruck(Truck trucker) {
		Scanner input = new Scanner(System.in);
		System.out.println("\n--> [Please enter the number of the package you wish to unload]");
		trucker.displayPkg();
		
		//prompting user for valid input number and validating
		int choiceNb;
		do {
			System.out.print("  --> Please enter a valid number: ");
		while(!input.hasNextInt()) {
			System.out.println("Please enter a valid number");
			input.nextInt();
		}
		choiceNb = input.nextInt();
		} while(choiceNb > Truck.maxPkg -1 || choiceNb < 0);
		System.out.println();
		
		//unloading the package chosen
		trucker.unload(choiceNb);
		
		return trucker;
	}
	
	/**method to display number of packages*/
	public static void displayNbPkg(Truck trucker) {
		System.out.println("\n--> [Number of packages currently loaded in truck]: " + trucker.getNbPkg());
	}
	
	/**method to display the gross income earned by the shipping*/
	public static void displayGrossIncome(Truck trucker) {
		System.out.println("\n--> [Total gross income earned]: $" + trucker.getGrossCost());
	}
	
	/**method to display weight of loaded truck*/
	public static void displayWeight(Truck trucker) {
		System.out.println("\n--> [Current total weight of truck]: \n" + trucker.getGrossW());
	}
}
