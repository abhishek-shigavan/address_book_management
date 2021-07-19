package com.addressbook.readwrite;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.addressbook.model.ContactDetails;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
/**
 * CSVReaderWriter	-	Writing Contact & Name of AddressBook into CSV file & reading the same
 * 
 * @author Abhishek Shigavan
 *
 */
public class CSVReaderWriter {
	//defining path of file to write data 
	public static final File filePath = new File("./src/com/addressbook/file/contactCSVFile.csv");
/**
 * This methods reads the contact details & addressbook name & writes it into csv file
 * 
 * @param addrName - AddressBook name
 * @param contact - contact details
 */
	public void writeIntoCSV(String addrName, ContactDetails contact){
	    try {
	    	FileWriter fileWriter = new FileWriter(filePath, true);
	    	FileReader fileReader = new FileReader(filePath);
	    	CSVWriter csvWriter = new CSVWriter(fileWriter);
	    	
	    	String[] header = {"ADDRESS_BOOK_NAME", "FIRST_NAME", "LAST_NAME", "ADDRESS", "CITY", "STATE", "PHONE", "ZIP", "EMAIL"};
	    	
	    	String[] contacts = {addrName, contact.getFirst_Name(), contact.getLast_Name(), contact.getAddress(),
	    							contact.getCity(), contact.getState(), contact.getMob_No(), contact.getZip_Code(), 
	    							contact.getEmail()};
	    	//checking it is first entry to file / not
	    	if((fileReader.read()) < 0) {
	    		csvWriter.writeNext(header);
	    		csvWriter.writeNext(contacts);
	    	}
	    	else {
	    		csvWriter.writeNext(contacts);
	    	}
	    	csvWriter.close();
	    }
	    catch(IOException e){
	    	System.out.println("Writing CSV error!!!");
	    	e.printStackTrace();
	    }
	}
/**
 * This method reads the given csv file & store the data into list &
 * then print the list
 * 	
 * @param file - path of csv file
 */
	public void readCSVFile(String file) {
		try {
			FileReader fileReader = new FileReader(file);
			CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
			List<String []> addressBookContact = csvReader.readAll();
			
			for(String[] allContacts : addressBookContact) {
				for(String contact : allContacts) {
					System.out.print(contact+"\t");
				}
				System.out.println();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
