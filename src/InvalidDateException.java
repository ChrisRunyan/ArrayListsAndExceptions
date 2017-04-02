 /* 
  * File name: InvalidDateException.java
  * 
  * Programmer: Christopher Runyan
  * ULID: caruny1
  * 
  * Date: 2/21/2016
  * 
  * Class: IT 179
  * Lecture Section: 03
  * Lecture Instructor: Cathy Holbrook
  */

package edu.ilstu;

/**
 * Exceptions for invalid dates
 * @author Christopher Runyan
 *
 */

@SuppressWarnings("serial")
public class InvalidDateException extends Exception{
	/**
	 * Exception for invalid date accepting no parameters
	 */
	public InvalidDateException(){
		super("Error: invalid date");
	}
	
	/**
	 * Exception for invalid date accepting a String value for date
	 * @param date: a String containing the date
	 */
	public InvalidDateException(String date){
		super("Error: "+date+" is an invalid date");
	}
}
