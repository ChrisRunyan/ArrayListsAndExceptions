 /* 
  * File name: Billing.java
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

//import java.io.IOException;
//import java.io.PrintWriter;

/**
 * Controls the calculations for billing, creates methods to print the bill and format the date
 * @author Christopher Runyan
 *
 */

public class Billing{
	Patient patient=null;
	Doctor doctor=null;
	String date=null;
	ValidationUtility validate=new ValidationUtility(date, patient);
	
	/**
	 * Default constructor
	 */
	public Billing(){
		patient=null;
		doctor=null;
		date=null;
	}
	
	/**
	 * Constructor accepting values only for the date
	 * @param date: a String containing the date
	 */
	public Billing(String date){
		patient=null;
		doctor=null;
		this.date=date;
	}
	
	/**
	 * Constructor accepting all values
	 * @param patient: an instance of the class Patient
	 * @param doctor: an instance of the class Doctor
	 * @param date: a String containing the date
	 */
	public Billing(Patient patient, Doctor doctor, String date){
		this.patient=patient;
		this.doctor=doctor;
		this.date=date;
	}
	
	/**
	 *  Method that determines the amount of the visit bill the customer has to pay (copay)
	 * @return: copay amount
	 */
	public double determineCoPayAmount(){
		return patient.determineCoPay()*doctor.getFee();
	}
	
	/**
	 * Method that determines the amount of the visit bill that insurance covers 
	 * @return: covered amount
	 */
	public double determineCoveredAmount(){
		return doctor.getFee()-determineCoPayAmount();
	}
	
	/**
	 * Prints the formatted bill to the console 
	 */
	public void printBill(){
		try{
			validate.isValidPatientId(patient.getID());
		}catch (InvalidPatientIdException e){
			patient.setID("unknown");
		}
		try{
			validate.isValidDate(date);
		}catch(InvalidDateException e){
			date="00000000";
		}
		try{
			validate.isValidDate(patient.getBirthdate());
		}catch(InvalidDateException e){
			patient.setBirthdate("00000000");
		}
		System.out.println("---------------------------------------------");
		System.out.println("Service Date: "+formatDate(date)+"\n"+doctor+"\n\n"+patient+"\n"+"");
		System.out.printf("Amount Billed:  $%6.2f", doctor.getFee());
		System.out.printf("\nCovered Amount: $%6.2f", determineCoveredAmount());
		System.out.printf("\nCoinsurace:     $%6.2f", determineCoPayAmount());
		System.out.println("\n---------------------------------------------\n\n");
	}
	
//	/**
//	 * Prints the formatted bill to unique files for each customer
//	 */
//	public void printToFile(){
//		PrintWriter writer=null;
//		
//		try{
//			validate.isValidPatientId(patient.getID());
//		}catch (InvalidPatientIdException e){
//			patient.setID("unknown");
//		}
//		try{
//			validate.isValidDate(date);
//		}catch(InvalidDateException e){
//			date="00000000";
//		}
//		try{
//			validate.isValidDate(patient.getBirthdate());
//		}catch(InvalidDateException e){
//			patient.setBirthdate("00000000");
//		}
//		try{
//			writer=new PrintWriter(patient.getPatientName()+" Bill.txt");
//		}catch(IOException e){
//			e.printStackTrace();
//			System.exit(1);
//		}
//		writer.println("---------------------------------------------");
//		writer.println("Service Date: "+formatDate(date)+"\n"+doctor+"\n\n"+patient+"\n"+"");
//		writer.printf("Amount Billed:  $%6.2f", doctor.getFee());
//		writer.printf("\nCovered Amount: $%6.2f", determineCoveredAmount());
//		writer.printf("\nCoinsurace:     $%6.2f", determineCoPayAmount());
//		writer.println("\n---------------------------------------------\n\n");
//		
//		writer.close();
//	}
	
	/**
	 * Accepts a value for the unformatted date and returns the formatted date
	 * @param date: unformatted date
	 * @return: formatted date as a String object
	 */
	public String formatDate(String date){
		return date.substring(0, 2)+"/"+date.substring(2, 4)+"/"+date.substring(4, 8);
	}
}
