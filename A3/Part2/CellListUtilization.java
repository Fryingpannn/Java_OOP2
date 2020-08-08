/*---------------------------------
 * Name: Matthew Pan               | 
 * Student ID: 40135588            |
 * Comp 249: Assignment #3         |
 * Part 2                          |
 * Due Date: August 9th, 2020      |
 * Professor: Dr. Yuhong Yan       |
 *---------------------------------
 */
package Part2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class contains the main method which utilizes the CellPhone and CellList classes.
 * 
 * This program's purpose is practice LinkedList concept theory. It reads from a text file with multiple cell phone information, then
 * puts them into CellPhone objects which are added into a linked list. From this linked list, many of its methods are tested.
 * 
 * Concepts: LinkedList data structure; creating a linked list, nodes/references and its methods + File I/O; reading data from text file into objects.
 * 
 * @author pan
 */
public class CellListUtilization {

	public static void main(String[] args) {
		System.out.println("======================== LinkedList: Cell Phones Program ========================\n");
		//initializing 2 lists
		CellList list1 = new CellList();
		CellList list2 = new CellList();
		
		//reading from file into linked list 'list1'
		System.out.println("- Attemping to open and read from 'Cell_Info.txt'");
		try (Scanner in = new Scanner(new FileReader("Cell_Info.txt"))){
			while(in.hasNext()) {
				CellPhone phone = new CellPhone();
				phone.setSerialNum(in.nextLong());
				phone.setBrand(in.next());
				phone.setPrice(in.nextDouble());
				phone.setYear(in.nextInt());
				if(!list1.contains(phone.getSerialNum()))
					list1.addToStart(phone); //adds phone to list if does not already exist
			}
		}
		catch(FileNotFoundException e) {
			System.err.println("[Error]: File not found, please restart program.");
		}
		
		//displaying content of linked list
		System.out.println("\n- Text file has been successfully imported into a linked list. (Note: Phones with duplicate serial numbers were discarded)");
		list1.showContents();
		
		//prompt user to enter 3 serial numbers to search in list
		Scanner read = new Scanner(System.in);
		System.out.println("\n- Enter 3 serial numbers you would like to search for in the list. ");
		System.out.print("\tFirst serial number: ");
		long nb1 = read.nextLong();
		System.out.print("\tSecond serial number: ");
		long nb2 = read.nextLong();
		System.out.print("\tThird serial number: ");
		long nb3 = read.nextLong();
		
		//searching input numbers in list
		System.out.println();
		if(list1.contains(nb1)) {
			System.out.println("- Serial number " + nb1 + " was found after " + list1.getCount() + " iterations.");
		}
		else
			System.out.println("- Serial number " + nb1 + " could not be found.");
		if(list1.contains(nb2)) {
			System.out.println("- Serial number " + nb2 + " was found after " + list1.getCount() + " iterations.");
		}
		else
			System.out.println("- Serial number " + nb2 + " could not be found.");
		if(list1.contains(nb3)) {
			System.out.println("- Serial number " + nb3 + " was found after " + list1.getCount() + " iterations.");
		}
		else
			System.out.println("- Serial number " + nb3 + " could not be found.");
		
		//testing all methods from CellPhone class
		System.out.println("\n========= Testing clone & equals method from CellPhone class: ========= \n");
		System.out.println("\t== [test.clone();] ==");
		CellPhone test = new CellPhone(122, "Google", 500, 2008);
		CellPhone clonedTest = test.clone();
		System.out.println("Displaying both Cell Phones: ");
		System.out.println(test);
		System.out.println(clonedTest);
		System.out.println("\n\t== [test.equals(clonedTest)] ==");
		System.out.println("Are these two cell phones equal? --> " + test.equals(clonedTest));
		
		//testing deleteFromStart() & deleteFromIndex()
		list2.addToStart(test);
		list2.addToStart(clonedTest);
		list2.addToStart(new CellPhone(123, "Apple", 999, 2018));
		list2.addToStart(new CellPhone(124, "Huawei", 700, 2020));
		System.out.println("\n========= Testing deleteFromStart() & deleteFromIndex(1) ========= \n");
		System.out.println("\t == [Original list] ==");
		list2.showContents();
		System.out.println("\n\t == [After deleteFromStart() ==");
		list2.deleteFromStart();
		list2.showContents();
		System.out.println("\n\t == [After deleteFromIndex(1) ==");
		list2.deleteFromIndex(1);
		list2.showContents();
		
		//testing insertAtIndex()
		System.out.println("\n========= Testing insertAtIndex(1) ========= \n");
		list2.insertAtIndex(new CellPhone(8888, "InsertedBrand", 1, 2020), 1);
		System.out.println("\t == [Displaying contents after insertAtIndex(1)] ==");
		list2.showContents();
		
		//testing replaceAtIndex()
		System.out.println("\n========= Testing replaceAtIndex(1) ========= \n");
		list2.replaceAtIndex(new CellPhone(6666, "ReplacedBrand", 2, 2019), 1);
		System.out.println("\t == [Displaying contents after replaceAtIndex(1)] ==");
		list2.showContents();
		
		//testing equals method for list
		System.out.println("\n========= Testing equals(CellList e) ========= \n");
		System.out.println("\t- Is list1 equal to list2? [list1.equals(list2);] --> " + list1.equals(list2));
		
		//testing copy constructor for list
		System.out.println("\n========= Testing CellList copy constructor ========= \n");
		System.out.println("\t- Now copying list2 and displaying content: [new CellList(list2);]\n");
		new CellList(list2).showContents();
		
		System.out.println("\n======================== [End] LinkedList: Cell Phones Program ========================");
	}
}
