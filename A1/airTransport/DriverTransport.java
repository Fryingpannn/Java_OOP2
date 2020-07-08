package airTransport;

import publicTransport.PublicTransportation;
import seaTransport.Ferry;
import airTransport.AirCraft.*;
import groundTransport.*;

public class DriverTransport {

	public static void main(String[] args) {
		
		//testing PublicTransportation class
		PublicTransportation firstPublic = new PublicTransportation();	//default c
		PublicTransportation secondPublic = new PublicTransportation(15.5, 5);	//parameterized c
		firstPublic.setTicketPrice(60); //mutator
		System.out.println(firstPublic + "\n" + secondPublic + "\n" + firstPublic.equals(secondPublic) +"\n");	//toString + equalsTo
		
		//testing AirCraft class
		AirCraft firstAir = new AirCraft();
		AirCraft secondAir = new AirCraft(50.9, 10, AirType.HELICOPTER, TimeType.MONTHLY);
		System.out.println(firstAir + "\n" + secondAir + "\n" + firstAir.equals(secondAir) + "\n");
		
		//testing Ferry class
		Ferry firstBoat = new Ferry();
		Ferry secondBoat = new Ferry(30.5, 4, 1998, "Going Merry");
		Ferry sameBoat = new Ferry(secondBoat);	//copy constructor boat
		System.out.println(firstBoat + "\n" + secondBoat + "\n" + firstBoat.equals(secondBoat) + "\n" + "Copy Ferry: " + sameBoat + "\n");
		
		//testing CityBus class
		CityBus firstBus = new CityBus();
		CityBus secondBus = new CityBus(5.5, 20, 8, 2001, "All Lines", "Matthew Pan");
		System.out.println(firstBus + "\n" + secondBus + "\n" + firstBus.equals(secondBus) +"\n");
		
		//testing Metro class
		Metro firstTrain = new Metro();
		Metro secondTrain = new Metro(2.99, 40, 6, 1989, "Orange Line", "Frying Pan", 25, "Montreal");
		Metro thirdTrain = new Metro(secondTrain);	//copy constructor train
		System.out.println(firstTrain + "\n" + secondTrain + "\n" + thirdTrain + "\nThe first train is the same as second train: " + firstTrain.equals(secondTrain) 
							+ "\nThe second train is the same as third train: " + secondTrain.equals(thirdTrain) + "\n");
		
		//testing Tram class
		Tram firstTram = new Tram();
		Tram secondTram = new Tram(8.99, 10, 500, 2020, "Purple Line", "Good Grades Please", 999);
		System.out.println(firstTram + "\n" + secondTram + "\n" + firstTram.equals(secondTram) +"\n");
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
