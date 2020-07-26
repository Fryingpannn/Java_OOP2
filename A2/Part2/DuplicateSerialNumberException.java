/*---------------------------------
 * Name: Matthew Pan               | 
 * Student ID: 40135588            |
 * Comp 249: Assignment #2         |
 * Driver file: CargoshipInventory1|
 * Part 2                          |
 * Due Date: 25 July, 2020         |
 * Professor: Dr. Yuhong Yan       |
 *---------------------------------
 */
package Part2;
/**
 * DuplicateSerialNumberException class which handles the error thrown when user inputs a serial number 
 * that already exists.
 * 
 * @author pan
 */
@SuppressWarnings("serial")
public class DuplicateSerialNumberException extends Exception {
	/**
	 * no args constructor
	 */
	public DuplicateSerialNumberException() {
		super("[Duplicate Serial Number Exception]");
	}
	
	/**
	 * @param msg error message
	 */
	public DuplicateSerialNumberException(String msg) {
		super(msg);
	}
}