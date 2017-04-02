 /* 
  * File name: Person.java
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
 * Super class containing values for name
 * @author Christopher Runyan
 *
 */

public class Person{
	private Name name;
	
	/**
	 * Default constructor
	 */
	public Person(){
		name=null;
	}
	
	/**
	 * Constructor accepting all values
	 * @param firstName: the first name as a String object
	 * @param lastName: the last name as a String object
	 * @param midInitial: the middle initial as a char
	 */
	public Person(String firstName, String lastName, char midInitial){
		name=new Name(firstName, lastName, midInitial);
	}
	
	/**
	 * Sets the value of all variables at once
	 * @param firstName: the first name as a String object
	 * @param lastName: the last name as a String object
	 * @param midInitial: the middle initial as a char
	 */
	public void setName(String firstName, String lastName, char midInitial){
		name=new Name(firstName, lastName, midInitial);
	}
	
	/**
	 * Returns the toString for Name containing all the variables
	 * @return: the toString for Name containing all the variables
	 */
	public Name getName(){
		return name;
	}
	
	/* 
	 *  Overrides the default toString method to a formatted output
	 */
	@Override
	public String toString(){
		return name.toString();
	}
	
	/**
	 * Compares two instances of the class Person to see if they are the same
	 * @param person: another Person object
	 * @return: true or false
	 */
	public boolean equals(Person person){
		boolean same=false;
		if(name.equals(person.getName())){
			same=true;
		}
		return same;
	}
}
