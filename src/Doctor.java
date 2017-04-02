 /* 
  * File name: Doctor.java
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
 * Subclass of Person, holds additional data and methods for specialty and fee
 * @author Christopher Runyan
 *
 */

public class Doctor extends Person{
	private Specialty specialty;
	private double fee;

	/**
	 * Default constructor
	 */
	public Doctor(){
		super();
		specialty=null;
		fee=0;
	}
	
	/**
	 * Constructor accepting all values
	 * @param firstName: first name of doctor as a String object
	 * @param midInitial: middle initial of doctor as a char
	 * @param lastName: last name of doctor as a String object
	 * @param specialty: specialty of doctor as a Specialty (enumeration)
	 * @param fee: doctor fee as a double
	 */
	public Doctor(String firstName, char midInitial, String lastName, Specialty specialty, double fee){
		super(firstName, lastName, midInitial);
		this.specialty=specialty;
		this.fee=fee;
	}
	
	/**
	 * Sets the value of specialty to an accepted specialty
	 * @param specialty: specialty of doctor as a Specialty (enumeration)
	 */
	public void setSpecialty(Specialty specialty){
		this.specialty=specialty;
	}
	
	/**
	 * Sets the value of fee to an accepted double 
	 * @param fee: doctor fee as a double
	 */
	public void setFee(double fee){
		this.fee=fee;
	}
	
	/**
	 * Returns the value of specialty
	 * @return: specialty
	 */
	public Specialty getSpecialty(){
		return specialty;
	}
	
	/**
	 * Returns the value of fee
	 * @return: fee
	 */
	public double getFee(){
		return fee;
	}
	
	/* 
	 *  Overrides the default toString method to a formatted output
	 */
	@Override
	public String toString(){
		return "Doctor: "+super.getName()+", "+specialty;
	}
	
	/**
	 * Compares two instances of Doctor to see if they are the same
	 * @param doctor: another instance of Doctor
	 * @return: true or false
	 */
	public boolean equals(Doctor doctor){
		boolean same=false;
		if(specialty.equals(doctor.getSpecialty())&&super.getName().equals(doctor.getName())&&fee==doctor.getFee()){
			same=true;
		}
		return same;
	}
}
