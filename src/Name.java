 /* 
  * File name: Name.java
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
 * Class containing variables and methods to create, modify, and store attributes of a name
 * @author Christopher Runyan
 *
 */

public class Name{
	private String firstName;
	private String lastName;
	private char midInitial;
	
	/**
	 * Default constructor
	 */
	public Name(){
		this.firstName=null;
		this.lastName=null;
		this.midInitial=' ';
	}
	
	/**
	 * Constructor acceppting all values
	 * @param firstName: the first name as a String object
	 * @param lastName: the last name as a String object
	 * @param midInitial: the middle initial as a char
	 */
	public Name(String firstName, String lastName, char midInitial){
		this.firstName=firstName;
		this.lastName=lastName;
		this.midInitial=midInitial;
	}
	
	/**
	 * Sets the value of firstName to an accepted String variable
	 * @param firstName: the first name as a String object
	 */
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	
	/**
	 * Sets the value of lastName to an accepted String variable
	 * @param lastName: the last name as a String object
	 */
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	
	/**
	 * Sets the value of midInitial to an accepted char 
	 * @param midInitial: the middle initial as a char
	 */
	public void setMidInitial(char midInitial){
		this.midInitial=midInitial;
	}
	
	/**
	 * Returns the value of firstName
	 * @return: firstName
	 */
	public String getFirstName(){
		return firstName;
	}
	
	/**
	 * Returns the value of lastName
	 * @return: lastName
	 */
	public String getLastName(){
		return lastName;
	}
	
	/**
	 * Returns the value of midInitial
	 * @return: midInitial
	 */
	public char getMidInitial(){
		return midInitial;
	}
	
	/* 
	 *  Overrides the default toString method to a formatted output
	 */
	@Override
	public String toString(){
		return firstName+" "+midInitial+" "+lastName;
	}
	
	/**
	 * Compares two name objects to see if they are equal
	 * @param name: an instance of Name
	 * @return:  true or false
	 */
	public boolean equals(Name name){
		boolean same=false;
		if(firstName.equals(name.getFirstName())&&lastName.equals(name.getLastName())&&midInitial==name.getMidInitial()){
			same=true;
		}
		return same;
	}
}
