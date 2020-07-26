package Part2;

import java.util.Scanner;

public class DuplicateSerialNumberException extends Exception {
	/**
	 * no args constructor
	 */
	public DuplicateSerialNumberException() {
		super("[Duplicate Serial Number Exception]");
	}
	
	/**
	 * @param msg
	 */
	public DuplicateSerialNumberException(String msg) {
		super(msg);
	}
	
	public static void main(String[] args) {

		
	}
}
