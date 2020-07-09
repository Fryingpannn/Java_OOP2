/*-------------------------------
 * Name: Matthew Pan             |
 * Student ID: 40135588          |
 * Comp 249: Assignment #1       |
 * Driver file: DriverTransport  |
 * Part 1 & 2                    |
 * Due Date: 12 July, 2020       |
 * Professor: Dr. Yuhong Yan     |
 *-------------------------------
 */
package airTransport;

import publicTransport.PublicTransportation;
import seaTransport.Ferry;
import airTransport.AirCraft.*;
import groundTransport.*;

/**
 * Driver class which creates instances of each class and displays various information regarding each one.
 * 
 * This is the driver class for the PublicTransportation, AirCraft, Ferry, CityBus, Metro and Tram classes.
 * 
 * @author pan
 */
public class DriverTransport {
	/**
	 * Method to duplicate an array of PublicTransportation objects.
	 * 
	 * Every object in the passed array has its class type tested, then the appropriate copy constructor for that class type is used
	 * to copy the object into the newly created array.
	 * 
	 * @param aCopy	the array to be copied
	 * @return	returns the new duplicated array
	 */
	private static PublicTransportation[] copyCityBus(PublicTransportation[] aCopy) {
		PublicTransportation[] copy = new PublicTransportation[aCopy.length];
		
		for(int i = 0; i < aCopy.length; i++) {
			if(aCopy[i] instanceof Tram) {
				copy[i] = new Tram((Tram) aCopy[i]);
			}
			else if(aCopy[i] instanceof Metro){
				copy[i] = new Metro((Metro) aCopy[i]);
			}
			else if(aCopy[i] instanceof CityBus){
				copy[i] = new CityBus((CityBus) aCopy[i]);
			}
			else if(aCopy[i] instanceof Ferry) {
				copy[i] = new Ferry((Ferry) aCopy[i]);
			}
			else if(aCopy[i] instanceof AirCraft) {
				copy[i] = new AirCraft((AirCraft) aCopy[i]);
			}
			else {
				copy[i] = new PublicTransportation(aCopy[i]);
			}
		}
		return copy;
	}
	
	/**
	 * Static method to find the lowest ticket price in an array of PublicTransportation.
	 * 
	 * @param arr array of PublicTransportation objects
	 * @return returns the index of the object with the lowest ticket price in the array
	 */
	private static int minPriceIndex(PublicTransportation[] arr) {
		int cheapestCost = 0;
		
		for(int i = 0; i < 15; i++) {
			if(arr[cheapestCost].getTicketPrice() > arr[i].getTicketPrice()) {
				cheapestCost = i;
			}
		}
		return cheapestCost;
	}
	
	/**
	 * Static method to find the highest ticket price in an array of PublicTransportation.
	 * 
	 * @param arr array of PublicTransportation objects
	 * @return returns the index of the object with the highest ticket price in the array
	 */
	private static int maxPriceIndex(PublicTransportation[] arr) {
		int maxCost = 0;
		
		for(int i = 0; i < 15; i++) {
			if(arr[maxCost].getTicketPrice() < arr[i].getTicketPrice()) {
				maxCost = i;
			}
		}
		return maxCost;
	}

	/**
	 * Application's entry-point.
	 * 
	 * In Part 1, every class is tested for:  1. default constructor
	 * 							  			  2. parameterized constructor
	 *                             			  3. equals and toString methods
     *                             
	 * For the AirCraft and Metro classes, the copy constructor also tested.
	 * For the AirCraft class, accessor and mutator methods are also tested.
	 * 
	 * In Part 2, the classes' have been modified to the most restrictive/secure access rights.
	 * In addition, the copyCityBus static method is tested on an array of objects.
	 * 
	 * @param args an array of command-line arguments for the application.
	 */
	public static void main(String[] args) {
		/*---> Begin Part 1 <---*/
		System.out.println("------------------------------------*** Part 1 ***-----------------------------------------------------------------------------------------------\n\n");
		
		//displaying test description
		System.out.println("Every class is tested for 1. default constructor 2. parameterized constructor 3. equals and toString methods.");
		System.out.println("In addition, the AirCraft and Metro classes' copy constructors are also tested.");
		System.out.println("Finally, for the AirCraft class, its accessor and mutator methods are also tested.\n");
		
		//testing PublicTransportation class
		System.out.println("----Public Transportation Class--------------------------------------------------");
		PublicTransportation firstPublic = new PublicTransportation();
		PublicTransportation secondPublic = new PublicTransportation(15.5, 5);
		System.out.println("1. " + firstPublic + "\n" + "2. " + secondPublic + "\n" + "The first public transportation is the same as second: " 
							+ firstPublic.equals(secondPublic) +"\n");
		
		/* Null verification is very important for equals method. If it isn't included and the equals method is used on a null object,
		 * it will terminate the program and throw a NullPointerException error because null points to nothing.*/
		
		//testing AirCraft class
		System.out.println("----AirCraft Class---------------------------------------------------------------");
		AirCraft firstAir = new AirCraft();
		AirCraft secondAir = new AirCraft(60.9, 10, AirType.HELICOPTER, TimeType.MONTHLY);
		firstAir.setClassType(AirType.BALLOON);	//mutator method
		System.out.println("1. " + firstAir + "\n" + "2. " + secondAir + "\n" + "The first aircraft is the same as second aircraft: " + firstAir.equals(secondAir) + "\n"
							+ "The aircraft type of the first aircraft is: " + firstAir.getClassType() + "\n");	//also includes accessor method
		
		//testing Ferry class
		System.out.println("----Ferry Class------------------------------------------------------------------");
		Ferry firstBoat = new Ferry();
		Ferry secondBoat = new Ferry(30.5, 4, 1998, "Going Merry");
		Ferry sameBoat = new Ferry(secondBoat);	//copy constructor
		System.out.println("1. " + firstBoat + "\n" + "2. " + secondBoat + "\n" + "Copy Ferry: " + sameBoat + "\n" + "The first boat is the same as second boat: " 
							+ firstBoat.equals(secondBoat) + "\n");
		
		//testing CityBus class
		System.out.println("----CityBus Class----------------------------------------------------------------");
		CityBus firstBus = new CityBus();
		CityBus secondBus = new CityBus(5.5, 20, 8, 2001, "All Lines", "Matthew Pan");
		System.out.println("1. " + firstBus + "\n" + "2. " + secondBus + "\n" + "The first bus is the same as second bus: " + firstBus.equals(secondBus) +"\n");
		
		//testing Metro class
		System.out.println("----Metro Class------------------------------------------------------------------");
		Metro firstTrain = new Metro();
		Metro secondTrain = new Metro(2.99, 40, 6, 1989, "Orange Line", "Frying Pan", 25, "Montreal");
		Metro thirdTrain = new Metro(secondTrain);	//copy constructor
		System.out.println("1. " + firstTrain + "\n" + "2. " + secondTrain + "\n" + "3. " + thirdTrain + "\nThe first train is the same as second train: " 
							+ firstTrain.equals(secondTrain) + "\nThe second train is the same as third train: " + secondTrain.equals(thirdTrain) + "\n");
		
		//testing Tram class
		System.out.println("----Tram Class-------------------------------------------------------------------");
		Tram firstTram = new Tram();
		Tram secondTram = new Tram(1.99, 10, 500, 2020, "Purple Line", "Good Grades Please", 999);
		System.out.println("1. " + firstTram + "\n" + "2. " + secondTram + "\n" + "The first tram is the same as second tram: " + firstTram.equals(secondTram) +"\n");
		
		//Creating array of 15 PublicTransportation objects
		PublicTransportation[] allTransports = new PublicTransportation[15];
		
		allTransports[0] = secondPublic;
		allTransports[1] = secondAir;
		allTransports[2] = secondBoat;
		allTransports[3] = sameBoat;
		allTransports[4] = secondBus;
		allTransports[5] = secondTrain;
		allTransports[6] = secondTram;
		for(int i = 7; i < 15; i++) {
			allTransports[i] = thirdTrain;
		}
		
		//Using static methods to find min and max ticket price indexes
		int cheapestCost = minPriceIndex(allTransports);
		int greatestCost = maxPriceIndex(allTransports);
		
		//Displaying cheapest and most expensive transports
		System.out.println("----Price Analytics---------------------------------------------------------------\n" 
							+ "The most expensive transport is shown below (index " + greatestCost + "): \n* " + allTransports[greatestCost] 
							+ "\n\nThe cheapest transport is shown below (index " + cheapestCost + "): \n* " + allTransports[cheapestCost]);
		
		/*--> Begin Part 2 <---
		* Changes to more restrictive access have been made to the classes. Such as, changing "protected" to "private" for the instance variables of
		* CityBus class, and using getters/setters to access/mutate all elements. Specific comments regarding the changes made are in the CityBus class
		* and the other Javadoc comments made for various methods.
		*/
		System.out.println("\n\n------------------------------------*** Part 2 ***-----------------------------------------------------------------------------------------------\n\n");
		
		//displaying test description for Part 2
		System.out.println("In Part 2, changes to more restrictive accesses have been made to the classes. For example, changing \"protected\" to "
							+ "\"private\" for the instance variables of CityBus class, \nas well as using getters/setters to access/mutate all elements."
							+ " Specific comments regarding the changes made are in the CityBus class and the other Javadoc comments \n" 
							+ "made for various methods in the different classes.\n");
		
		//Creating array of 12 PublicTransportation objects
		PublicTransportation[] toCopyTransport = new PublicTransportation[12];
		
		toCopyTransport[0] = secondPublic;
		toCopyTransport[1] = secondAir;
		toCopyTransport[2] = secondBoat;
		toCopyTransport[3] = secondBus;
		toCopyTransport[4] = secondTrain;
		toCopyTransport[5] = secondTram;
		for(int i = 6; i < 12; i++) {
			toCopyTransport[i] = firstPublic;
		}
		
		//Displaying the toCopyTransport array
		System.out.println("--> Below are the objects of the array toCopyTransport: \n");
		for(int i = 0; i < 12; i++) {
			System.out.println(toCopyTransport[i]);
		}

		//Copying the toCopyTransport array into the copiedTransport array
		PublicTransportation[] copiedTransport = new PublicTransportation[12];
		copiedTransport = copyCityBus(toCopyTransport);
		
		//Displaying the successfully duplicated array
		System.out.println("\n--> Below are the objects of the array copiedTransport, which are copied from the previous by using the static method copyCityBus: \n");
		for(int i = 0; i < 12; i++) {
			System.out.println(copiedTransport[i]);
		}
		
		//Testing if the objects have been properly copied and not just reference copied
		//This is done by changing the same property of the objects at index 11 for both arrays and displaying the change.
		toCopyTransport[10].setTicketPrice(20);
		System.out.println("\n--> To show that the actual objects, and not the references, have been copied, object at index 11 of the first array (toCopyTransport)"
							+ " has its ticket price changed to 20$.\n\n1. toCopyTransport array index 11 object: " + toCopyTransport[11] 
							+ "\n2. copiedTransport array index 11 object: " + copiedTransport[11]);
		System.out.println("\n--> As we can see, the second array's object at index 11's ticket price has not changed. Thus, the objects have been properly copied"
						 + " into the new array.\n\n");
		System.out.print("------------------------------------------------------[END] Thank you and have a nice day [END]------------------------------------------------------");
	}
}
