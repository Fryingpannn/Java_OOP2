/*---------------------------------
 * Name: Matthew Pan               | 
 * Student ID: 40135588            |
 * Comp 249: Assignment #3         |
 * Part 1                          |
 * Due Date: August 6th, 2020      |
 * Professor: Dr. Yuhong Yan       |
 *---------------------------------
 */

package Part1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;

/**
 * This Dictionary class' program allows the user to input a file. The file is subsequently read from, formatted, and stored inside an
 * Array List which is then sorted. Then, a new SubDictionary.txt file is created to uniquely store the vocabulary from the previous 
 * file alphabetically.
 * Practiced: File IO, ArrayList, Sorting, etc.
 * @author pan
 *
 */
public class Dictionary {
	
	//list of words extracted from text file
	private static ArrayList<String> wordList = new ArrayList<String>();
	
	/**
	 * utilizes storeArrayList() and writeArrayList() static methods to read from file and write to file.
	 * @param args
	 */
	public static void main(String[] args) {
		//file to read from: PersonOfTheCentury.txt
		
		Scanner read = new Scanner(System.in);
		
		//prompt user to enter the file to be read from
		System.out.println("=================================== Sub-Dictionary Creator ===================================\n");
		System.out.println("How the program works: Creates a unique dictionary of all the words contained in the chosen file.\n");
		System.out.print("Please enter the name of the file you would like to create a sub-dictionary of (.txt): ");
		String txt = read.next(); //name of file to read from
		
		//formats the words in the text file and stores it in the ArrayList
		storeArrayList(txt);
		
		//writes the words in the arraylist to SubDitionary.txt
		writeArrayList();
		
		//displays what's in the array list
		//displayWordList();
		
		//completion message
		System.out.println("\nSub-dictionary has been created. Please verify SubDictionary.txt to see result.");
		
		//exit message
		System.out.println("\n=================================== Sub-Dictionary Creator ===================================");
	}
	
	/**
	 * writes what's in the arraylist into the txt file
	 */
	private static void writeArrayList() {
		
		try(PrintWriter out = new PrintWriter(new FileOutputStream("SubDictionary.txt"))){
			out.println("The document chosen produced this sub-dictionary, which includes " + wordList.size() + " entries.");
			
			//iterates through the 26 alphabet letters and sees if for each letter there are existing words
			for(int i = 65; i <= 90; i++) {
				char letter = (char) i;
				out.println("\n" + letter + "\n==\n");
				boolean none = true;
				
				//writing the word to txt file if letter matches the given alphabet letter
				for(int j = 0; j < wordList.size(); j++) {
					if(wordList.get(j).charAt(0) == letter) {
						out.println(wordList.get(j));
						none = false;
					}
				}
				if(none)
					out.println("None");	
			}
		}
		catch(FileNotFoundException e) {
			System.err.println("[Error]: Cannot write to file. Please restart the program.");
		}
	}
	
	/**
	 * formats the words in the text file and stores it in an ArrayList
	 * @param txt textfile to read from
	 */
	private static void storeArrayList(String txt){
		
		//reads in the words from the txt file, and formats them to upper case, as well as letters only
		try(Scanner in = new Scanner(new FileInputStream(txt))){
			String word;
			while(in.hasNext()) {
				word = in.next();
				word = word.toUpperCase().replaceAll("[^A-Z-]+.*", ""); //regex to filter out non-letters
				
				if(!wordList.contains(word)) {	//does not add duplicates into list
					if(word.length() > 1 || word.equals("A") || word.equals("I"))
						wordList.add(word);
				}
				else
					continue;
			}
			
			//sort the arraylist alphabetically (bubble sort)
			if(!wordList.isEmpty()) {
				
				for(int i = 0; i < wordList.size(); i++) {
					boolean swap = false;
					for(int j = 0; j < wordList.size() - i - 1; j++) {
						if(wordList.get(j).compareTo(wordList.get(j + 1)) > 0) {
							String temp = wordList.get(j);
							wordList.set(j, wordList.get(j+1));
							wordList.set(j+1, temp);
							swap = true;
						}
					}
					if(!swap)
						break;
				}
			}
		}
		catch(FileNotFoundException e) {
			System.err.println("[Error]: File does not exist, please restart the program and enter an existing .txt file.");
		}
	}
	
	/**
	 * displays the words stored in the arraylist
	 */
	private static void displayWordList() {
		System.out.println();
		for(String var : wordList)
			System.out.println(var);
	}
}