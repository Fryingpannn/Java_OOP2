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

import java.util.Scanner;

/**
 * This is the CellPhone class. Objects of this class will be stored inside a CellList.
 * 
 * @author pan
 */
public class CellPhone {
	private long serialNum;	//always unique
	private String brand;	//always single word
	private int year;	//manufacturing year
	private double price;
	
	/*Default constructor*/
	public CellPhone() {
		serialNum = 0;
		brand = "None";
		year = 0;
		price = 0;
	}
	
	/**
	 * @param serialNum
	 * @param brand
	 * @param year
	 * @param price
	 */
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	/**
	 * copy constructor
	 * @param a
	 * @param newSerial sets new unique serial nb
	 */
	public CellPhone(CellPhone a, long newSerial) {
		setSerialNum(newSerial);
		setBrand(a.getBrand());
		setYear(a.getYear());
		setPrice(a.getPrice());
	}
	
	/**
	 *clone method which also asks user to enter new serial number
	 */
	public CellPhone clone(){
		Scanner read = new Scanner(System.in);
		System.out.print("Please enter a new serial number for the cloned Cell Phone: ");
		long newSerial = read.nextLong();
		
		return new CellPhone(this, newSerial);
	}
	
	/**
	 * display cell phone 
	 */
	public String toString() {
		return ("Cell Phone Serial Number: " + getSerialNum() + " | Brand: " + getBrand() + " | Year Made: " + getYear() + " | Price: $" + getPrice());
	}
	
	/**
	 * compares if two cell phones are equal, all attributes except serial nb
	 */
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			CellPhone newObj = (CellPhone) obj;
			return (getBrand() == newObj.getBrand() && getYear() == newObj.getYear() && getPrice() == newObj.getPrice());
		}
	}
	
	/**
	 * @return the serialNum
	 */
	public long getSerialNum() {
		return serialNum;
	}
	/**
	 * @param serialNum the serialNum to set
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
