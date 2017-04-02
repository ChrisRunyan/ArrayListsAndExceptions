 /* 
  * File name: InvalidPatientIdException.java
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
 * Exceptions for invalid patient ids
 * @author Christopher Runyan
 *
 */

@SuppressWarnings("serial")
public class InvalidPatientIdException extends Exception{
	/**
	 * Exception for invalid patient ID accepting no parameters
	 */
	public InvalidPatientIdException(){
		super("Error: invalid patient ID");
	}
	
	/**
	 * Exception for invalid patient ID accepting a String value for ID
	 * @param id: a String containing the patient ID
	 */
	public InvalidPatientIdException(String id){
		super("Error: "+id+" is not a valid patient ID");
	}
}
