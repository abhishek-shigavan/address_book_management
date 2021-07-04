package com.addressbook.service;

import java.util.List;
import com.addressbook.model.ContactDetails;
/**
 * AddressBookServiceInterface	--	Defining Abstract methods of all operations 
 * 					performed in AddressBook
 * 
 * @author Abhishek Shigavan
 *
 */
public interface AddressBookServiceInterface {
	
	public abstract boolean isAddressBookPresent(String addrName);
	
	public abstract void addAddressBook(String addrName, List<ContactDetails> contactList);
	
	public abstract boolean isContactPresent(String addrName, String contactName);
	
	public abstract List<ContactDetails> getExistingContactList(String addrName);
	
	public abstract void editContactDetails(String addrName, String contactName, ContactDetails contactDetails);
	
	public abstract void deleteAddressBook(String addrName);
	
	public abstract void deleteContact(String addrName, String contactName);
	
	public abstract void viewAddressBook();
	
	public abstract void viewSpecificAddressBook(String addrName);

	public abstract boolean checkCityPresent(String cityName);

	public abstract boolean checkStatePresent(String stateName);
	
	public abstract void checkContactInCity(String cityName, String contactName);
	
	public abstract void checkContactInState(String stateName, String contactName);
	
	public abstract void viewContactsByCityName(String cityName);

	public abstract void viewContactsByStateName(String stateName);

	public abstract void getContactCountByCity(String cityName);

	public abstract void getContactCountByState(String stateName);
	
}
