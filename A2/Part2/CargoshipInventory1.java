package Part2;

import java.io.*;
import java.util.Scanner;

public class CargoshipInventory1 {
	public static Cargoship[] wsArr; //array of cargoships
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("--------------------- Cargoships Info Correction Program ---------------------\n");
		
		Scanner read = new Scanner(System.in);
		String initialCargo = "Initial_Cargoship_Info.txt"; //initial file name
		
		//prompting user for new file name
		boolean loop = true;
		String newCargo = null;	//Name of new file
		File exist;	//used to check if initial file exists
		System.out.print("Enter new file name to store the correct information in (include file format): ");
		while(loop) {
			newCargo = read.next();
			if(!newCargo.equalsIgnoreCase(initialCargo)) {
				loop = false;
			}
			else {
				exist = new File(newCargo);
				System.out.println("This file name already exist - File size: " + exist.length() + " bytes");
				System.out.print("Please enter a non-existing file name: ");
			}
		}
		
		System.out.println("\n\t[Opening file and detecting number of duplicate serial numbers...]\n");
		try {
			//counting number of objects in file
			int count = cargosCount(initialCargo);
			
			if(count <= 1) {
				System.out.println("\n\t[Terminating program - File has no duplicated serial number, all is well!]");
			}
			else {
				//extract cargos into array from original file (nb of cargos, initial file name, new file name)
				fixInventory(count, initialCargo, newCargo);
				
				//displaying fix msg
				System.out.println("\n\t[Currently replacing duplicate serial numbers with newly entered numbers...]");
				
				//displaying original file
				System.out.println("\n=================== Displaying the contents of the original file: ===================\n");
				displayFileContents(initialCargo);
				
				//displaying new file
				System.out.println("\n=================== Displaying the contents of the new file: =========================\n");
				displayFileContents(newCargo);
				System.out.println();
				
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("- File could not be found: ");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("[IOException error] Stack Trace:");
			e.printStackTrace();
		}
		finally {
			System.out.println("---------- [Program terminated] Files having been saved and closed. Thank you "
					+ "for using Cargoship Info Correction ----------");
		}
			
	}
	
	/**
	 * counts the number of cargoship objects in a file
	 * @param initialCargo original file
	 * @return number of cargoships in file
	 * @throws FileNotFoundException if cannot find original file
	 */
	private static int cargosCount(String initialCargo) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(initialCargo));
		
		//counting number of objects in file
		int count = 0;
		while(in.hasNextLine()) {
			count++;
			in.nextLine();
		}
		in.close();
		
		return count;
	}
	
	/**
	 * extract cargos into array
	 * @param count length of array / nb of cargo objs
	 * @param initialCargo file name we are reading from
	 * @param newCargo file name we are writing to
	 * @throws FileNotFoundException 
	 * @throws IOException if cannot read from file
	 */
	private static void fixInventory(int count, String initialCargo, String newCargo) throws IOException {
		Scanner in = new Scanner(new FileReader(initialCargo));
		PrintWriter out = new PrintWriter(new PrintWriter(newCargo));
		
		//initializing array with empty cargoships
		wsArr = new Cargoship[count];
		for(int i = 0; i < wsArr.length; i++) {
			wsArr[i] = new Cargoship();
		}
		
		int j = 0;
		//filling the cargoships with the extracted information
		while(in.hasNext()) {
			wsArr[j].setSerialNb(Integer.parseInt(in.next()));
			wsArr[j].setName(in.next());
			wsArr[j].setCreationYr(Integer.parseInt(in.next()));
			wsArr[j].setOwnerCountry(in.next());
			wsArr[j].setPrice(Double.parseDouble(in.next()));
			wsArr[j].setSpeed(Integer.parseInt(in.next()));
			j++;
		}
		in.close();
		
		//check if there are duplicate serial numbers, and if so, prompt use to replace them
		checkDuplicate();	
		
		//write the newly corrected cargoship objects into the new file
			for(int i = 0; i < wsArr.length; i++) {
				out.println(wsArr[i].toString());
			}
			out.close();
	}
	
	/**
	 * check if there are duplicate serial numbers, and if so, prompt use to replace them
	 */
	private static void checkDuplicate() {
		Scanner prompt = new Scanner(System.in);
		//checking to see if there are any duplicate serial numbers, and if so, prompt user to replace it
		int newNb = 0;
		for(int b = 0; b < wsArr.length; b++) {
			for(int i = 0; i < wsArr.length; i++) {
				if(wsArr[i].getSerialNb() == wsArr[b].getSerialNb() && i != b) {
					//duplicate found, prompt user to enter new nb
					boolean loop = true;
					System.out.print("  -> [Duplicate serial number found: " + wsArr[b].getSerialNb() 
							+ "] Enter new serial number: ");
					while(loop) { //continue asking until user inputs unique nb
						newNb = prompt.nextInt();
						try {
							for(int k = 0; k < wsArr.length; k++) {
								if(wsArr[k].getSerialNb() == newNb) {
									throw new DuplicateSerialNumberException("  -> [Duplicate serial number] Try again: ");
								}
							}
							loop = false;
						}
						catch (DuplicateSerialNumberException e) {
							System.err.print(e.getMessage());
						}
					}
					wsArr[b].setSerialNb(newNb); //set new serial nb
				}
			}
		}
		prompt.close();
	}

	/**
	 * displays content of a given file
	 * @param fileName file name to read from
	 */
	public static void displayFileContents(String fileName) throws FileNotFoundException {
			Scanner in = new Scanner(new FileReader(fileName));

			int count = 1;
			while(in.hasNextLine()) {
				System.out.println("[" + count + "] - " + in.nextLine());
				count++;
			}
			in.close();
	}
}
