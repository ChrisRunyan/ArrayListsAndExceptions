 /* 
  * File name: Patient.java
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
 * Subclass of Person, holds additional information for id and birthdate
 * @author Christopher Runyan
 *
 */
public class Patient extends Person implements Insurable{
	private String id;
	private String birthdate;
	private InsuranceType insuranceType;
	
	/**
	 * Default constructor
	 */
	public Patient(){
		super();
		id=null;
		birthdate=null;
		insuranceType=null;
	}
	
	/**
	 * Constructor accepting all values
	 * @param firstName: first name of patient as a String object
	 * @param midInitial: middle initial of doctor as a char
	 * @param lastName: last name of doctor as a String object
	 * @param id: patient id
	 * @param birthdate: birthdate of patient
	 * @param insuranceType: type of insurance the patient has
	 */
	public Patient(String firstName, char midInitial, String lastName, String id, String birthdate, InsuranceType insuranceType){
		super(firstName, lastName, midInitial);
		this.id=id;
		this.birthdate=birthdate;
		this.insuranceType=insuranceType;
	}
	
	/**
	 * Sets the value of id to an accepted String
	 * @param id: patient id
	 */
	public void setID(String id){
		this.id=id;
	}
	
	/**
	 * Sets the value of birthdate to an accepted String
	 * @param birthdate: birthdate of patient
	 */
	public void setBirthdate(String birthdate){
		this.birthdate=birthdate;
	}
	
	/**
	 * Sets the value of insuranceType to an accepted String
	 * @param insuranceType: type of insurance the patient has
	 */
	public void setInsuranceType(InsuranceType insuranceType){
		this.insuranceType=insuranceType;
	}
	
	/**
	 * Returns the value of id
	 * @return: id
	 */
	public String getID(){
		return id;
	}
	
	/**
	 * Returns the value of birthdate
	 * @return: birthdate
	 */
	public String getBirthdate(){
		return birthdate;
	}
	
	/**
	 * Returns the value of insuranceType
	 * @return: insuranceType
	 */
	public InsuranceType getInsuranceType(){
		return insuranceType;
	}
	
	/* 
	 *  Overrides the default toString method to a formatted output
	 */
	@Override
	public String toString(){
		Billing billing=new Billing(birthdate);
		return "Patient: "+super.getName()+"\nID: "+id+"\nBirthdate: "+billing.formatDate(birthdate)+"\nInsurance: "+insuranceType;
	}
	
	/**
	 * Compares two instances of Patient to see if they are the same
	 * @param patient: another instance of Patient
	 * @return: true or false
	 */
	public boolean equals(Patient patient){
		boolean same=false;
		if(id.equals(patient.getID())&&super.getName().equals(patient.getName())){
			same=true;
		}
		return same;
	}

	/**
	 * Determines the amount (percentage) that the patient pays depending on the type of insurance the patient has
	 */
	@Override
	public double determineCoPay(){
		double coPay=0;
		if(insuranceType.equals(InsuranceType.HEALTH_ALLIANCE)){
			coPay=0.05;
		}
		else if(insuranceType.equals(InsuranceType.BLUE_CROSS_BLUE_SHIELD)){
			coPay=0.15;
		}
		else if(insuranceType.equals(InsuranceType.CIGNA)){
			coPay=0.1;
		}
		return coPay;
	}
}
