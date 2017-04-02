/*
 * File name: Driver.java
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver class containing a main method
 * @author Christopher Runyan
 *
 */

public class Driver{
	public static void main(String[] args){
		//ValidationUtility validate=new ValidationUtility();
		Scanner reader=null;
		ArrayList<Billing> billingList=new ArrayList<Billing>();
		
		try{
			reader=new Scanner(new File("ClinicBilling.txt"));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}
		
		while(reader.hasNext()){
			String date=reader.next();
			Doctor doctor=new Doctor(reader.next(), reader.next().charAt(0), reader.next(), Specialty.valueOf(reader.next().toUpperCase()), reader.nextDouble());
			Patient patient=new Patient(reader.next(), reader.next().charAt(0), reader.next(), reader.next(), reader.next(), InsuranceType.valueOf(reader.next().toUpperCase()));
			Billing billing=new Billing(patient, doctor, date);
			billingList.add(billing);
		}
		reader.close();
		billingList.trimToSize();
		
		for(Billing billing:billingList){
			billing.printBill();
//			billing.printToFile();
		}
	}
}
