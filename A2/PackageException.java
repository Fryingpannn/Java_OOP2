
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
 * PackageException class which handles the exception messages
 * @author Matthew Pan
 */
@SuppressWarnings("serial")
public class PackageException extends Exception {

	/**
	 * no args constructor
	 */
	public PackageException() {
		super("[Package Exception Error]");
	}
	
	/**
	 * @param msg takes in the message to deliver
	 */
	public PackageException(String msg) {
		super(msg);
	}
}