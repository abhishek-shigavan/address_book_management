package com.addressbook.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.addressbook.model.ContactDetails;
/**
 * UserInputOutput	--	Defining methods to take input from user
 * 
 * @author Abhishek Shigavan
 *
 */
public class UserInputOutput {
	
	static Scanner sc = new Scanner(System.in);
/**
 * Method to display menu 
 *  	
 * @return chosen option
 */
	public static int addressBookMenu() {
		
		System.out.println("\n****MENU****");
		System.out.println("1. Create New AddressBook ");
		System.out.println("2. Add New Contact To Existing AddressBook");
		System.out.println("3. Edit Contact");
		System.out.println("4. Delete AddressBook");
		System.out.println("5. Delete Contact");
		System.out.println("6. View All AddressBook");
		System.out.println("7. View Specific AddressBook");
		System.out.println("8. Search Person In City");
		System.out.println("9. Search Person In State");
		System.out.println("10. View Contacts by City");
		System.out.println("11. View Contacts by State");
		System.out.println("12. Get Count of Person of Particular City");
		System.out.println("13. Get Count of Person of Particular State");
		System.out.println("14. Exit");
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
	public static ContactDetails contactDetailsConsole() {
		
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
		contactDetails.setZip_Code(sc.nextInt());
						
		System.out.println("Enter Mobile Number : ");
		contactDetails.setMob_No(sc.nextInt());
						
		System.out.println("Enter Email Id : ");
		contactDetails.setEmail(sc.next());
		
		return contactDetails;
	}
	//method to get AddressBook Name
	public static String getAddressBookName() {
		
		System.out.println("Enter AddressBook Name : ");
		String addrName = sc.next();
		
		return addrName;
	}
	//method to get contact name 
	public static String getContactNameToCheck() {
		
		System.out.println("Enter Contact Name : ");
		String contactName = sc.next();
		
		return contactName;
	}
	//method to get AddressBook name to edit
	public static String getEditAddressBookName() {
		
		System.out.println("Enter Name of AddressBook To Edit : ");
		String addrName = sc.next();
		
		return addrName;
	}
	//method to get Contact name to edit
	public static String getEditContactName() {
		
		System.out.println("Enter Contact Name To Edit : ");
		String contactName = sc.next();
		
		return contactName;
	}
	//method to get Contact name to delete
	public static String getDeleteContactName() {
		
		System.out.println("Enter Contact Name To Delete : ");
		String contactName = sc.next();
		
		return contactName;
	}
	//method to get contact name to search
	public static String getSearchContactName() {
	
		System.out.println("Enter Contact Name To Search In City : ");
		String contactName = sc.next();
		
		return contactName;
	}
	//method to get city name 
	public static String getCityName() {
		
		System.out.println("\nEnter City Name : ");
		String cityName = sc.next();
		
		return cityName;
	}
	//method to get state name
	public static String getStateName() {
		
		System.out.println("Enter State Name : ");
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
	public List<ContactDetails> getNewContactDetails() {
		
		ContactDetails contactDetails = contactDetailsConsole();
		
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
	public static List<ContactDetails> getDetailsForExisting(List<ContactDetails> existingContactList){
		
		//getting new contact details
		ContactDetails contactDetails = contactDetailsConsole();
		//adding new details to existing contact list
		existingContactList.add(contactDetails);
		
		return existingContactList;
	}
/**
 * Method to Take new contact details form user
 * 	
 * @return new contact details
 */
	public static ContactDetails getEditContactDetails() {
		
		System.out.println("\n****Editing Contact****");
		System.out.println("Please Enter New Details...");
		
		ContactDetails contactDetails = contactDetailsConsole();

		return contactDetails;
	} 
}
