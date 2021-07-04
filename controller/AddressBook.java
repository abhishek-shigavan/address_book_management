package com.addressbook.controller;

import java.util.List;
import com.addressbook.model.ContactDetails;
import com.addressbook.service.AddressBookService;
import com.addressbook.service.AddressBookServiceInterface;
import com.addressbook.util.UserInputOutput;
/**
 * AddressBook	--	This class calls method according to
 * 			operation perform in AddressBook chosen by user
 * 
 * @author Abhishek Shigavan
 *
 */
public class AddressBook {
	
	static AddressBookServiceInterface addressBookService = new AddressBookService();

	public void showAddressBookMenu() {
		
		UserInputOutput userIO = new UserInputOutput();
		
		boolean flag = true;
		
		while(flag) {
			
			int option = UserInputOutput.addressBookMenu();
			
			switch(option) {
				
				case 1:{
					
					String addrName = UserInputOutput.getAddressBookName();
					//checking AddressBook is present / not
					boolean isPresent = addressBookService.isAddressBookPresent(addrName);
					
					if (isPresent) {
						
						System.out.println("AddressBook with "+addrName+" is already present");
					}
					else {	
						
						List<ContactDetails> contactList = userIO.getNewContactDetails();
						addressBookService.addAddressBook(addrName,contactList);
					}
					
					break;
				}
				case 2:{
					
					String addrName = UserInputOutput.getAddressBookName();
					//checking AddressBook is present / not
					boolean isPresent = addressBookService.isAddressBookPresent(addrName);
					
					String contactName  = UserInputOutput.getContactNameToCheck();
					//checking contact name is present in address book / not
					boolean isContactPresent = addressBookService.isContactPresent(addrName, contactName);
					
					if(isPresent == true && isContactPresent == false) {
						
						//getting existing contact list
						List<ContactDetails> existingContactList = addressBookService.getExistingContactList(addrName);
						//contact list with newly added contact
						List<ContactDetails> contactList = UserInputOutput.getDetailsForExisting(existingContactList);
						
						addressBookService.addAddressBook(addrName, contactList);
					}
					else if(isContactPresent) {
						
						System.out.println("Contact with Name :"+contactName+" is already present in AddressBook : "+addrName);
					}
					else {
						
						System.out.println("No such AddressBook with name "+addrName);
					}
					
					break;
				}
				case 3:{
					
					String addrName = UserInputOutput.getEditAddressBookName();	
					//checking AddressBook is present / not
					boolean isAddrPresent = addressBookService.isAddressBookPresent(addrName);
					
					String contactName = UserInputOutput.getEditContactName();
					//checking contact is present / not
					boolean isContactPresent = addressBookService.isContactPresent(addrName, contactName);
					
					if(isAddrPresent && isContactPresent) {
						
						//getting new contact details
						ContactDetails contactDetails = UserInputOutput.getEditContactDetails();
						addressBookService.editContactDetails(addrName, contactName, contactDetails);
					}
					else if(isAddrPresent) {
						
						System.out.println("No such Contact with First Name as "+contactName+" Present in AddressBook");
					}
					else {
						
						System.out.println("No such AddressBook with Name : "+addrName);
					}
					
					break;
				}
				case 4:{
					
					System.out.println("\n**** Deleting Address Book ****");
					
					String addrName = UserInputOutput.getAddressBookName();
					//checking AddressBook is present / not
					boolean isAddrPresent = addressBookService.isAddressBookPresent(addrName);
					
					if(isAddrPresent) {
						
						addressBookService.deleteAddressBook(addrName);
					}
					else {
						
						System.out.println("No such AddressBook with Name : "+addrName);
					}
					
					break;
				}
				case 5:{
					
					System.out.println("**** Deleting Contact ****");
					
					String addrName = UserInputOutput.getAddressBookName();	
					//checking AddressBook is present / not
					boolean isAddrPresent = addressBookService.isAddressBookPresent(addrName);
					
					String contactName = UserInputOutput.getDeleteContactName();
					//checking Contact is present / not
					boolean isContactPresent = addressBookService.isContactPresent(addrName, contactName);
					
					if(isAddrPresent && isContactPresent) {
						
						addressBookService.deleteContact(addrName, contactName);
					}
					else if(isAddrPresent) {
						
						System.out.println("No such Contact with First Name as "+contactName+" Present in AddressBook");
					}
					else {
						
						System.out.println("No such AddressBook with Name : "+addrName);
					}

					break;
				}
				case 6:{
					
					System.out.println("\n**** Displaying All AddressBooks ****");
					
					addressBookService.viewAddressBook();
					break;
				}
				case 7:{
					
					System.out.println("\n**** Displaying Specific AddressBook ****");
					
					String addrName = UserInputOutput.getAddressBookName();	
					//checking AddressBook is present / not
					boolean isAddrPresent = addressBookService.isAddressBookPresent(addrName);
					
					if(isAddrPresent) {
						
						addressBookService.viewSpecificAddressBook(addrName);
					}
					else {
						
						System.out.println("No such AddressBook with Name : "+addrName);
					}
					
					break;
				}
				case 8:{
					
					//getting city & contact name
					String cityName = UserInputOutput.getCityName();
					String contactName = UserInputOutput.getSearchContactName();
					
					//checking city is present in AddressBook / not
					boolean isCityPresent = addressBookService.checkCityPresent(cityName);
					
					if(isCityPresent) {
						
						addressBookService.checkContactInCity(cityName, contactName);
					}
					else {
					
						System.out.println("No such City with Name : "+cityName+" present in AddressBook");
					}
					break;
				}
				case 9:{
					
					//getting state & contact name
					String stateName = UserInputOutput.getStateName();
					String contactName = UserInputOutput.getSearchContactName();
					
					//checking state is present in AddressBook / not
					boolean isStatePresent = addressBookService.checkStatePresent(stateName);
					
					if(isStatePresent) {
						
						addressBookService.checkContactInState(stateName, contactName);
					}
					else {
						
						System.out.println("No such State with Name : "+stateName+" present in AddressBook");
					}
					break;
				}
				case 10:{
					
					System.out.println("\n**** View Contacts By City ****");
					String cityName = UserInputOutput.getCityName();
					
					//checking city is present in AddressBook / not
					boolean isCityPresent = addressBookService.checkCityPresent(cityName);
					
					if(isCityPresent) {
						
						addressBookService.viewContactsByCityName(cityName);
					}
					else {
						
						System.out.println("No such City with Name : "+cityName+" present in AddressBook");
					}
					
					break;
				}
				case 11:{
					
					System.out.println("\n**** View Contacts By State ****");
					String stateName = UserInputOutput.getStateName();
					
					//checking state is present in AddressBook / not
					boolean isStatePresent = addressBookService.checkStatePresent(stateName);
					
					if(isStatePresent) {
						
						addressBookService.viewContactsByStateName(stateName);
					}
					else {
						
						System.out.println("No such State with Name : "+stateName+" present in AddressBook");
					}
					
					break;
				}
				case 12:{
					
					System.out.println("\n**** Display Count Of Persons Of City ****");
					
					String cityName = UserInputOutput.getCityName();
					
					//checking city is present in AddressBook / not
					boolean isCityPresent = addressBookService.checkCityPresent(cityName);
					
					if(isCityPresent) {
						
						addressBookService.getContactCountByCity(cityName);
					}
					else {
						
						System.out.println("No such City with Name : "+cityName+" present in AddressBook");
					}
					
					break;
				}
				case 13:{
					
					System.out.println("\n**** Display Count Of Persons Of State ****");
					
					String stateName = UserInputOutput.getStateName();
					
					//checking state is present in AddressBook / not
					boolean isStatePresent = addressBookService.checkStatePresent(stateName);
					
					if(isStatePresent) {
						
						addressBookService.getContactCountByState(stateName);
					}
					else {
						
						System.out.println("No such State with Name : "+stateName+" present in AddressBook");
					}

					break;
				}
				case 14:{
					
					flag = false;
					break;
				}
				default: {
					
					System.out.println("Incorrect Option");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("****Welcome To Address Book Management****");
		
		AddressBook addressBook = new AddressBook();
		
		addressBook.showAddressBookMenu();
	}
}
