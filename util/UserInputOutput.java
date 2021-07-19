package com.addressbook.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.addressbook.dao.AddressBookDAO;
import com.addressbook.model.ContactDetails;
import com.addressbook.readwrite.CSVReaderWriter;
/**
 * UserInputOutput	--	Defining methods to take input from user
 * 
 * @author Abhishek Shigavan
 *
 */
import com.addressbook.readwrite.FileReaderWriter;
public class UserInputOutput {
	
	static Scanner sc = new Scanner(System.in);
	FileReaderWriter fileReadWrite = new FileReaderWriter();
	CSVReaderWriter csvReadWrite = new CSVReaderWriter();
/**
 * Method to display menu & to take user 
 * selected option 
 *  	
 * @return chosen option
 */
	public int addressBookMenu() {
		
		System.out.println("\n****MENU****");
		System.out.println("1. Create New AddressBook ");
		System.out.println("2. Add New Contact To Existing AddressBook");
		System.out.println("3. Edit Contact");
		System.out.println("4. Delete AddressBook");
		System.out.println("5. Delete Contact");
		System.out.println("6. View Options");
		System.out.println("7. Search Person");
		System.out.println("8. View Count of Person");
		System.out.println("9. View In Sorted Order");
		System.out.println("10. Exit");
		System.out.println("Enter ur option : ");
		int option = sc.nextInt();
		
		return option;
	}
/**
 * In this method taking value for contact properties & assigning
 * values to properties.
 * 	
 * @return contact object
 */
	public ContactDetails contactDetailsConsole(String addrName) {
		
		ContactDetails contactDetails = new ContactDetails();
		
		//taking contact details 
		System.out.println("\n*****Contact Details*****");
				
		System.out.println("Enter First Name : ");
		contactDetails.setFirst_Name(sc.next());	//passing value 
						
		System.out.println("Enter Last Name : ");
		contactDetails.setLast_Name(sc.next());
						
		System.out.println("Enter Address : ");
		contactDetails.setAddress(sc.next());
						
		System.out.println("Enter City : ");
		contactDetails.setCity(sc.next());
						
		System.out.println("Enter State : ");
		contactDetails.setState(sc.next());
						
		System.out.println("Enter Zip Code : ");
		contactDetails.setZip_Code(sc.next());
						
		System.out.println("Enter Mobile Number : ");
		contactDetails.setMob_No(sc.next());
						
		System.out.println("Enter Email Id : ");
		contactDetails.setEmail(sc.next());
		//writing AddressBookName & contact details into file
		fileReadWrite.addToFile(addrName, contactDetails);
		//writing AddressBookName & contact details into csv file
		csvReadWrite.writeIntoCSV(addrName, contactDetails);
		
		return contactDetails;
	}
	//method to get AddressBook Name
	public String getAddressBookName() {
		
		System.out.println("Enter AddressBook Name : ");
		String addrName = sc.next();
		
		return addrName;
	}
	//method to get contact name 
	public String getContactNameToCheck() {
		
		System.out.println("Enter Contact Name : ");
		String contactName = sc.next();
		
		return contactName;
	}
	//method to get AddressBook name to edit
	public String getEditAddressBookName() {
		
		System.out.println("Enter Name of AddressBook To Edit : ");
		String addrName = sc.next();
		
		return addrName;
	}
	//method to get Contact name to edit
	public String getEditContactName() {
		
		System.out.println("Enter Contact Name To Edit : ");
		String contactName = sc.next();
		
		return contactName;
	}
	//method to get Contact name to delete
	public String getDeleteContactName() {
		
		System.out.println("Enter Contact Name To Delete : ");
		String contactName = sc.next();
		
		return contactName;
	}
	//method to get contact name to search
	public String getSearchContactName() {
	
		System.out.println("Enter Contact Name To Search In City : ");
		String contactName = sc.next();
		
		return contactName;
	}
	//method to get city name 
	public String getCityName() {
		
		System.out.println("\nEnter City Name : ");
		String cityName = sc.next();
		
		return cityName;
	}
	//method to get state name
	public String getStateName() {
		
		System.out.println("\nEnter State Name : ");
		String stateName = sc.next();
		
		return stateName;
	}
/**
 * Method for adding contact details of new AddressBook
 * 
 * This method takes contact details from user &
 * add it to contact list & returns the same
 *  	
 * @return contact list
 */
	public List<ContactDetails> getNewContactDetails(String addrName) {
		
		ContactDetails contactDetails = contactDetailsConsole(addrName);
		
		List<ContactDetails> contactList = new ArrayList<>(); 
		
		contactList.add(contactDetails);
		
		return contactList;
	}
/**
 * Method for creating new contact in existing AddressBook
 * 
 * This method takes contact details & add this 
 * details in the existing contact list of given AddressBook
 * 	
 * @param existingContactList
 * @return existing contact list with newly added details
 */
	public List<ContactDetails> getDetailsForExisting(List<ContactDetails> existingContactList, String addrName){
		
		//getting new contact details
		ContactDetails contactDetails = contactDetailsConsole(addrName);
		//adding new details to existing contact list
		existingContactList.add(contactDetails);
		
		return existingContactList;
	}
/**
 * Method to Take new contact details form user
 * 	
 * @return new contact details
 */
	public ContactDetails getEditContactDetails(String addrName) {
		
		System.out.println("\n****Editing Contact****");
		System.out.println("Please Enter New Details...");
	
		ContactDetails contactDetails = contactDetailsConsole(addrName);

		return contactDetails;
	}
/**
 * Method to print view menu & to take option 
 * from user & return the same
 *  	
 * @return option selected by user
 */	
	public int getViewMenu() {
		boolean flag = true;
		
		while(flag) {
			System.out.println("\n**** View Options ****");
			System.out.println("\n1. View All AddressBooks");
			System.out.println("2. View Specific AddressBook");
			System.out.println("3. View Contacts By City Name");
			System.out.println("4. View Contacts By State Name");
			System.out.println("Enter Ur Option : ");
			int option = sc.nextInt();
			
			if(option > 0 && option < 5) {
				flag = false;
				return option;
			}
		}
		return 0;
	}
/**
 * Method to print searching options menu & to take option 
 * from user & return the same
 *  	
 * @return option selected by user
 */	
	public int getSearchMenu() {
		boolean flag = true;
		
		while(flag) {
			System.out.println("\n**** Searching Options ****\n");
			System.out.println("\n1. Search Person In City ");
			System.out.println("2. Search Person In State");
			System.out.println("Enter Ur Option :  ");
			int option = sc.nextInt();
			
			if(option > 0 && option < 3) {
				flag = false;
				return option;
			}
		}
		return 0;
	}
/**
 * Method to print view count options menu & to take option 
 * from user & return the same
 *  	
 * @return option selected by user
 */	
	public int getCountOfPersonMenu() {
		boolean flag = true;
		
		while(flag) {
			System.out.println("\n**** View Count Options ****\n");
			System.out.println("\n1. Get Count Of Person Of City");
			System.out.println("2. Get Count Of Person Of State");
			System.out.println("Enter Ur Option : ");
			int option = sc.nextInt();
			
			if(option > 0 && option < 3) {
				flag = false;
				return option;
			}
		}
		return 0;
	}
/**
 * Method to print sorted order menu & to
 * take selected option from user & return the same
 *  	
 * @return option selected by user
 */
	public int getSortedOrderMenu() {
		boolean flag = true;
		
		while(flag) {
			System.out.println("\n**** Sorting Option ****");
			System.out.println("\n1. Sorted By Name");
			System.out.println("2. Sorted By City");
			System.out.println("3. Sorted By State");
			System.out.println("4. Sorted By Zip Code");
			System.out.println("Enter Ur Option : ");
			int option = sc.nextInt();
			
			if(option > 0 && option < 5) {
				flag = false;
				return option;
			}
		}
		return 0;
	}
}
