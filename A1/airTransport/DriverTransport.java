package airTransport;

import publicTransport.PublicTransportation;
import seaTransport.Ferry;
import airTransport.AirCraft.*;
import groundTransport.*;

public class DriverTransport {

	public static void main(String[] args) {
		/** Every class is tested for: 1. default constructor
		 * 							   2. parameterized constructor
		 *                             3. equals and toString methods
		 *                             
		 * For the AirCraft and Metro classes, the copy constructor, accessor and mutator methods are also tested.*/
		
		//testing PublicTransportation class
		System.out.println("----Public Transportation Class--------------------------------------------------");
		PublicTransportation firstPublic = new PublicTransportation();
		PublicTransportation secondPublic = new PublicTransportation(15.5, 5);
		firstPublic.setTicketPrice(60); //mutator
		System.out.println("1. " + firstPublic + "\n" + "2. " + secondPublic + "\n" + "The first public transportation is the same as second: " 
							+ firstPublic.equals(secondPublic) +"\n");
		
		//testing AirCraft class
		System.out.println("----AirCraft Class---------------------------------------------------------------");
		AirCraft firstAir = new AirCraft();
		AirCraft secondAir = new AirCraft(50.9, 10, AirType.HELICOPTER, TimeType.MONTHLY);
		System.out.println("1. " + firstAir + "\n" + "2. " + secondAir + "\n" + "The first aircraft is the same as second aircraft: " + firstAir.equals(secondAir) + "\n");
		
		//testing Ferry class
		System.out.println("----Ferry Class------------------------------------------------------------------");
		Ferry firstBoat = new Ferry();
		Ferry secondBoat = new Ferry(30.5, 4, 1998, "Going Merry");
		Ferry sameBoat = new Ferry(secondBoat);	//copy constructor boat
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
		Metro thirdTrain = new Metro(secondTrain);	//copy constructor train
		System.out.println("1. " + firstTrain + "\n" + "2. " + secondTrain + "\n" + "3. " + thirdTrain + "\nThe first train is the same as second train: " 
							+ firstTrain.equals(secondTrain) + "\nThe second train is the same as third train: " + secondTrain.equals(thirdTrain) + "\n");
		
		//testing Tram class
		System.out.println("----Tram Class-------------------------------------------------------------------");
		Tram firstTram = new Tram();
		Tram secondTram = new Tram(1.99, 10, 500, 2020, "Purple Line", "Good Grades Please", 999);
		System.out.println("1. " + firstTram + "\n" + "2. " + secondTram + "\n" + "The first tram is the same as second tram: " + firstTram.equals(secondTram) +"\n");
		
		/**Creating array of 15 PublicTransportation objects filled with various objects */
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
		
		int cheapestCost = 0;
		int greatestCost = 0;

		/** Setting cheapestCost to the index of the cheapest transport*/
		for(int i = 0; i < 15; i++) {
			if(allTransports[cheapestCost].getTicketPrice() > allTransports[i].getTicketPrice()) {
				cheapestCost = i;
			}
		}
		
		/** Setting greatestCost to the index of the most expensive transport*/
		for(int i = 0; i < 15; i++) {
			if(allTransports[greatestCost].getTicketPrice() < allTransports[i].getTicketPrice()) {
				greatestCost = i;
			}
		}
		
		/** Displaying cheapest and most expensive transports*/
		System.out.println("----Price Analytics---------------------------------------------------------------\n" 
							+ "The most expensive transport is shown below (index " + greatestCost + "): \n* " + allTransports[greatestCost] 
							+ "\n\nThe cheapest transport is shown below (index " + cheapestCost + "): \n* " + allTransports[cheapestCost]);
	
		
		
		
		
		
		
		
		
		
		
		

	}

}
