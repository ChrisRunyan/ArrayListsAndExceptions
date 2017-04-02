 /* 
  * File name: ValidationUtility.java
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
 *  Utility for validating variables that could be incorrect
 * @author Christopher
 *
 */

public class ValidationUtility{
	String date;
	Patient patient;
	
	/**
	 * Default constructor 
	 */
	public ValidationUtility(){
		date=null;
		patient=null;
	}
	
	/**
	 * Constructor accepting values for date and patient
	 * @param date: a String containing the date
	 * @param patient: an instance of the class Patient
	 */
	public ValidationUtility(String date, Patient patient){
		this.date=date;
		this.patient=patient;
	}
	
	/**
	 * Sets the value of date to an accepted String
	 * @param date: a String containing the date
	 */
	public void setDate(String date){
		this.date=date; 
	}
	
	/**
	 * Returns the value of date
	 * @return: date
	 */
	public String getDate(){
		return date;
	}
	
	/**
	 * Determines if an accepted String contains numerical values
	 * @param str: String being tested for numerical values
	 * @return: true or false
	 */
	private boolean isNumeric(String str){
		boolean valid = true;
		String regex = "[0-9/.]*";
		valid=str.matches(regex);
		if(!valid){
			valid=false;;
		}
		return valid;
	}
	
	/**
	 * Tests if a given patient id is valid or not
	 * @param str: patient id being tested
	 * @return: true or false
	 * @throws InvalidPatientIdException: throws if invalid id
	 */
	public boolean isValidPatientId(String str) throws InvalidPatientIdException{
		boolean valid=true;
		if(!isNumeric(str)){
			valid=false;
			throw new InvalidPatientIdException("ID not all numeric. "+str);
		}
		else if(!(str.length()==5)){
			valid=false;
			throw new InvalidPatientIdException("ID not five characters. "+str);
		}
		return valid;
	}
	
	/**
	 * Tests if a given date is valid or not
	 * @param str: date being tested
	 * @return: true or false
	 * @throws InvalidDateException: throws if invalid date
	 */
	public boolean isValidDate(String str) throws InvalidDateException{
		boolean valid=false;
		if(isNumeric(str)){
			valid=true;
		}else{throw new InvalidDateException("Birthdate not all numeric. "+str);}
		if(valid){
			int j=Integer.parseInt(str.substring(0, 2));
			if(j==1||j==3||j==5||j==7||j==8||j==10||j==12){
				if(Integer.parseInt(str.substring(2, 4))<=31){
					valid=true;
				}else{valid=false;}
			}
			else if(j==4||j==6||j==9||j==11){
				if(Integer.parseInt(str.substring(2, 4))<=30){
					valid=true;
				}else{valid=false;}
			}
			else if(j==2){
				if(Integer.parseInt(str.substring(2, 4))<=28){
					valid=true;
				}else{valid=false;}
			}
			else{valid=false;}
			if(valid==false){
				throw new InvalidDateException("Birthdate has incorrect dates. "+str);
			}
		}
		return valid;
	}
}
