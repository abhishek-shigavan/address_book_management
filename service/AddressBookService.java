package com.addressbook.service;

import java.util.List;
import com.addressbook.dao.AddressBookDAO;
import com.addressbook.model.ContactDetails;

public class AddressBookService implements AddressBookServiceInterface {

	AddressBookDAO addressDAO = new AddressBookDAO();
	
	@Override
	public boolean isAddressBookPresent(String addrName) {
		
		return addressDAO.isAddressBookPresent(addrName);
	}
	
	@Override
	public void addAddressBook(String addrName, List<ContactDetails> contactList) {
		
		addressDAO.addAddressBook(addrName, contactList);
	}

	@Override
	public boolean isContactPresent(String addrName, String contactName) {
		
		return addressDAO.isContactPresent(addrName, contactName);
	}
	
	@Override
	public List<ContactDetails> getExistingContactList(String addrName) {
		
		return addressDAO.getExistingContactList(addrName);
	}

	@Override
	public void editContactDetails(String addrName, String contactName, ContactDetails contactDetails) {
		
		addressDAO.editContactDetails(addrName, contactName, contactDetails);
	}
	
	@Override
	public void deleteAddressBook(String addrName) {
		
		addressDAO.deleteAddressBook(addrName);
	}
	
	@Override
	public void deleteContact(String addrName, String contactName) {
		
		addressDAO.deleteContact(addrName, contactName);
	}
	
	@Override
	public void viewAddressBook() {
		
		addressDAO.viewAddressBook();
	}

	@Override
	public void viewSpecificAddressBook(String addrName) {
		
		addressDAO.viewSpecificAddressBook(addrName);
	}

	@Override
	public boolean checkCityPresent(String cityName) {
		
		return addressDAO.checkCityPresent(cityName);
	}

	@Override
	public boolean checkStatePresent(String stateName) {
		
		return addressDAO.checkStatePresent(stateName);
	}
	
	@Override
	public void checkContactInCity(String cityName, String contactName) {
		
		addressDAO.checkContactInCity(cityName, contactName);
	}

	@Override
	public void checkContactInState(String stateName, String contactName) {
		
		addressDAO.checkContactInState(stateName, contactName);
	}

	@Override
	public void viewContactsByCityName(String cityName) {
		
		addressDAO.viewContactsByCityName(cityName);
	}

	@Override
	public void viewContactsByStateName(String stateName) {
		
		addressDAO.viewContactsByStateName(stateName);
	}

	@Override
	public void getContactCountByCity(String cityName) {
		
		addressDAO.getContactCountByCity(cityName);
	}

	@Override
	public void getContactCountByState(String stateName) {
		
		addressDAO.getContactCountByState(stateName);
	}
	
}
