package com.addressbook.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.addressbook.model.ContactDetails;
/**
 * AddressBookDAO	--	This class contains all the methods of 
 * 						operation performed in AddressBook
 * 
 * @author Abhishek Shigavan
 *
 */
public class AddressBookDAO {
	
	//defining HashMap to store Multiple AddressBook
	HashMap<String, List<ContactDetails>> addressBookList = new HashMap<>();
	
/**
 * This method checks given AddressBook name is present in
 * AddressBook List / not
 * Returns true if present else false
 * 	
 * @param addrName - AddressBook Name
 * @return True - If AddressBook list contains AddressBook with given Name
 * 		   False - If not present
 */
	public boolean isAddressBookPresent(String addrName) {
		
		boolean flag = false;
				
			if( addressBookList.containsKey(addrName) ) {
				
				flag = true;
			}
		
		return flag;
	}
/**
 * This method add AddressBook Name & Contact List
 * into addressBookList
 *  
 * @param addrName -- AddressBook Name
 * @param contactList -- Contact List
 * @return No return
 */
	public void addAddressBook(String addrName, List<ContactDetails> contactList) {
		
		//storing AddressBook name & Contact details 
		addressBookList.put(addrName, contactList);
	}
/**
 * This method checks given contact name present
 * in contact list and returns true if present else
 * return false
 * 
 * @param addrName -- AddressBook Name
 * @param contactName -- Contact Name
 * @return if present -- true else -- false
 */
	public boolean isContactPresent(String addrName, String contactName) {
		
		boolean flag = false;
		
		//getting contact list of given address book
		List<ContactDetails> contactList = addressBookList.get(addrName);
		
		for(int i=0; i < contactList.size(); i++) {
			//searching contact in contact list
			if(contactList.get(i).getFirst_Name().equalsIgnoreCase(contactName)) {
				
				flag = true;
				break;
			}
		}
		
		return flag;
	}
/**
 * This method returns existing contact list of given 
 * address book	
 * 
 * @param addrName -- AddressBook Name
 * @return Contact List of AddressBook
 */
	public List<ContactDetails> getExistingContactList(String addrName) {
		
			//getting contact list of given address book
			return addressBookList.get(addrName);
	}
/**
 * This method fetches contact list of given AddressBook &
 * matches given contact name with contact list & update the 
 * details present in list of given contact name
 * Later store the updated list
 * 	
 * @param addrName - AddressBookName
 * @param contactName - Contact Name
 * @param contactDetails - New Contact Details
 * 
 * @return No return
 */
	public void editContactDetails(String addrName, String contactName, ContactDetails contactDetails) {
		
		//fetching contact list of given AddressBook
		List<ContactDetails> existingContactList = addressBookList.get(addrName);
		
		for(int i=0; i < existingContactList.size(); i++) {
			
			//searching given contact name in contact list
			if(existingContactList.get(i).getFirst_Name().equalsIgnoreCase(contactName)) {
				
				//replacing existing values with new ones
				existingContactList.get(i).setFirst_Name(contactDetails.getFirst_Name());
				existingContactList.get(i).setLast_Name(contactDetails.getLast_Name());
				existingContactList.get(i).setAddress(contactDetails.getAddress());
				existingContactList.get(i).setCity(contactDetails.getCity());
				existingContactList.get(i).setState(contactDetails.getState());
				existingContactList.get(i).setZip_Code(contactDetails.getZip_Code());
				existingContactList.get(i).setMob_No(contactDetails.getMob_No());
				existingContactList.get(i).setEmail(contactDetails.getEmail());
				
				System.out.println("\n Contact Edited Sucessfully...!!!");
				break;
			}
		}

		//storing updated list to AddressBook
		addAddressBook(addrName, existingContactList);
	}
/**
 * This method removes AddressBook of given name from
 * AddressBook List
 * 	
 * @param addrName - AddressBook Name
 */
	public void deleteAddressBook(String addrName) {
		
		addressBookList.remove(addrName);
		System.out.println("Address Book : "+addrName+" is deleted sucessfully...!!!");
	}
/**
 * This method fetches contact list of given address book
 * & search given contact in contact list & remove it from contact list
 * 	
 * @param addrName - AddressBook Name
 * @param contactName - Contact Name
 * @return - No return
 */
	public void deleteContact(String addrName, String contactName) {
		
		//fetching contact list of given address book
		List<ContactDetails> existingContactList = addressBookList.get(addrName);
		
		//searching given contact name in contact list
		for(int i=0; i < existingContactList.size(); i++) {
			
			if(existingContactList.get(i).getFirst_Name().equalsIgnoreCase(contactName)) {
				
				existingContactList.remove(i);
				
				System.out.println("Contact with First Name : "+contactName+" is deleted sucessfully from AddressBook : "+addrName);
			}
		}
	}
/**
 * This method prints All the AddressBooks present in AddressBookList
 * 
 * @return No return	
 */
	public void viewAddressBook() {
		
		for (Map.Entry<String, List<ContactDetails>> e : addressBookList.entrySet())
            
			System.out.println("AddressBook Name : " + e.getKey() + " ContactDetails : " + e.getValue());
	}
/**
 * This method fetches contact list of given address book
 * and print it
 * 	
 * @param addrName - AddressBook Name
 * @return No return
 */
	public void viewSpecificAddressBook(String addrName) {
	
		//contact list of given address book
		List<ContactDetails> contactList = addressBookList.get(addrName);
		System.out.println("\nAddressBook Name : "+addrName);
		//printing contact list
		contactList.stream().forEach(System.out::println);
	}
/**
 * This method stores all keys (i.e AddressBook Name) of hashMap into arraylist
 * & returns the arraylist
 * 	
 * @return List of Keys of HashMap (i.e addressBookList)
 */
	public List<String> getListOfKeys() {
		
		//Finding the Set of keys from the HashMap
		Set<String> keySet = addressBookList.keySet();
						
		//Creating an ArrayList of all AddressBook Name by passing the keySet
		List<String> listOfAddrBookName= new ArrayList<String>(keySet);
		
		return listOfAddrBookName;
	}
/**
 * This method checks for given city name in the 
 * contact list of all the address book & return true if
 * present / false
 * 	
 * @param cityName
 * @return True - If city name present
 * 		   False - If not present
 */
	public boolean checkCityPresent(String cityName) {
		boolean flag = false;
		
		//list of all AddressBook Name
        List<String> listOfAddrBookName= getListOfKeys();
        
        //iterating through AddressBook Names
        for(int i=0; i < listOfAddrBookName.size(); i++) {
        	
        	//contact list of address book
        	List<ContactDetails> contactList = addressBookList.get(listOfAddrBookName.get(i));
        	//searching city name in the contact list
        	for(int j=0; j < contactList.size(); j++) {
        		
        		if(contactList.get(j).getCity().equalsIgnoreCase(cityName)) {
        			flag = true;
        			break;
        		}
        	}
        }
        return flag;
	}
/**
 * This method checks for given state name in the 
 * contact list of all the address book & return true if
 * present / false
 * 	
 * @param stateName
 * @return True - If state name present
 * 		   False - If not present
 */	
	public boolean checkStatePresent(String stateName) {
		boolean flag = false;
        List<String> listOfAddrBookName= getListOfKeys();
        
        //iterating through list of AddressBook Name to get contact list of each AddressBook
        for(int i=0; i < listOfAddrBookName.size(); i++) {
        	
        	List<ContactDetails> contactList = addressBookList.get(listOfAddrBookName.get(i));
        	//searching city name in the contact list
        	for(int j=0; j < contactList.size(); j++) {
        		
        		if(contactList.get(j).getState().equalsIgnoreCase(stateName)) {
        			flag = true;
        			break;
        		}
        	}
        }
        return flag;
	}
/**
 * This method creates dictionary of address book name & contact name
 * present in that address book 
 * 	
 * @return dictionary of address book name & contact name 
 */
	public HashMap<String, List<String>> dictOfAddrBookContactName() {
		//creating dictionary to store all contact name AddressBook wise 
		HashMap<String, List<String>> addrContactList = new HashMap<>();
		//list of AddressBook Name
		List<String> listOfAddrBookName = getListOfKeys();
				
		for(int i=0; i < listOfAddrBookName.size(); i++) {
			//list of contact list of AddressBook
			List<ContactDetails> contactList = addressBookList.get(listOfAddrBookName.get(i));
			//list to store contact name
			List<String> contactNameList = new ArrayList<>();

			//searching city name in contact list
			for(int j=0; j < contactList.size(); j++) {	
				//adding contact name into contactName list 
				contactNameList.add(contactList.get(j).getFirst_Name());
			}	
			//storing contact name list along with AddressBook name  
			addrContactList.put(listOfAddrBookName.get(i), contactNameList);
		}
		return addrContactList;
	}
/**
 * This method adds all the contact name whose city matches with
 * given city into list & then store this list along with city name
 * in dictionary  
 * 	
 * @param cityName
 * @return Dictionary of city & list of contact 
 */
	public HashMap<String, List<String>> dictionaryOfCityAndContact(String cityName) {
		//creating dictionary to store all contact name city wise 
		HashMap<String, List<String>> cityContactList = new HashMap<>();
		//list of AddressBook Name
		List<String> listOfAddrBookName = getListOfKeys();
		//list to store contact name
		List<String> contactNameList = new ArrayList<>();
		
		for(int i=0; i < listOfAddrBookName.size(); i++) {
			
			//list of contact list of AddressBook
			List<ContactDetails> contactList = addressBookList.get(listOfAddrBookName.get(i));
			
			//searching city name in contact list
			for(int j=0; j < contactList.size(); j++) {
			
				if(contactList.get(j).getCity().equalsIgnoreCase(cityName)) {			
					//adding contact name into list having city name same as given
					contactNameList.add(contactList.get(j).getFirst_Name());
				}
			}
			//storing contact name list along with city  
			cityContactList.put(cityName, contactNameList);
		}
		return cityContactList;
	}
/**
 * This method adds all the contact name whose state matches with
 * given state into list & then store this list along with state name
 * in dictionary  
 * 	
 * @param cityName
 * @return Dictionary of state & list of contact 
 */	
	public HashMap<String, List<String>> dictionaryOfStateAndContact(String stateName) {
		//creating dictionary to store all contact name state wise
		HashMap<String, List<String>> stateContactList = new HashMap<>();
		//list of AddressBook Name
		List<String> listOfAddrBookName = getListOfKeys();
		//list to store contact name
		List<String> contactNameList = new ArrayList<>();
		
		for(int i=0; i < listOfAddrBookName.size(); i++) {
			//contact list of address book
			List<ContactDetails> contactList = addressBookList.get(listOfAddrBookName.get(i));
			//searching state name in contact list
			for(int j=0; j < contactList.size(); j++) {
			
				if(contactList.get(j).getState().equalsIgnoreCase(stateName)) {			
					contactNameList.add(contactList.get(j).getFirst_Name());
				}
			}
			//storing contact name list along with state
			stateContactList.put(stateName, contactNameList);
		}
		return stateContactList;
	}
/**
 * This method gets city dictionary (i.e city & its contact name)
 * & finds given contact name in contact name list  & prints the
 * result
 * 	
 * @param cityName
 * @param contactName
 * @return No return
 */
	public void checkContactInCity(String cityName, String contactName) {
		//dictionary of given city name & its contact name
		HashMap<String, List<String>> cityContactList = dictionaryOfCityAndContact(cityName);
		//ContactName list of city
		List<String> contactList = cityContactList.get(cityName);
		boolean isPresent = contactList.contains(contactName);
		
		if(isPresent) {
			System.out.println("In City : "+cityName+" Person with Contact Name : "+contactName+" is present");
		}
		else {
			System.out.println("No such person with Contact Name : "+contactName+" Present in City : "+cityName);
		}
	}
/**
 * This method gets state dictionary (i.e state & its contact name)
 * & finds given contact name in contact name list & prints the
 * result
 * 	
 * @param stateName
 * @param contactName
 * @return No return
 */	
	public void checkContactInState(String stateName, String contactName) {
		//dictionary of given state name & its contact name
		HashMap<String, List<String>> stateContactList = dictionaryOfStateAndContact(stateName);
		//ContactName list of state
		List<String> contactList = stateContactList.get(stateName);
		boolean isPresent = contactList.contains(contactName);
		
		if(isPresent) {
			System.out.println("Person with Contact Name : "+contactName+" is present in State : "+stateName);
		}
		else {
			System.out.println("No such person with Contact Name : "+contactName+" Present in State : "+stateName);
		}
	}
/**
 * This method search city name in contact list of all
 * address book & prints AddressBook, First & Last name of person whose
 * city matches with search
 * 
 * @param cityName
 */
	public void viewContactsByCityName(String cityName) {
		//address books name list
		List<String> listOfAddrBookName= getListOfKeys();
		System.out.println("City Name : "+cityName+"\n");
		
		for(int i=0; i < listOfAddrBookName.size(); i++) {
			//contact list of address book
			List<ContactDetails> contactList = addressBookList.get(listOfAddrBookName.get(i));
			//searching city name in the contact list
			for(int j=0; j < contactList.size(); j++) {
				
				if(contactList.get(j).getCity().equalsIgnoreCase(cityName)) {
					System.out.println("AddressBook Name : "+listOfAddrBookName.get(i)+
							           " First Name : "+contactList.get(j).getFirst_Name()+
						               " Last Name : "+contactList.get(j).getLast_Name());
				}
			}
		}
	}
/**
 * This method search state name in contact list of all
 * address book & prints AddressBook, First & Last name of person whose
 * state matches with search
 * 
 * @param cityName
 */	
	public void viewContactsByStateName(String stateName) {
		//address books name list
		List<String> listOfAddrBookName = getListOfKeys();
		System.out.println("City Name : "+stateName+"\n");
				
		for(int i=0; i < listOfAddrBookName.size(); i++) {
			//getting contact list of address book		
			List<ContactDetails> contactList = addressBookList.get(listOfAddrBookName.get(i));
			//searching state name in the contact list		
			for(int j=0; j < contactList.size(); j++) {
						
				if(contactList.get(j).getState().equalsIgnoreCase(stateName)) {
					System.out.println("AddressBook Name : "+listOfAddrBookName.get(i)+
									   " First Name : "+contactList.get(j).getFirst_Name()+
								       " Last Name : "+contactList.get(j).getLast_Name());
				}
			}		
		}
	}
/**
 * This method searches given city name in contact list of all
 * address book and keep count of searches & prints the total count
 * 	
 * @param cityName
 * @return No return
 */
	public void getContactCountByCity(String cityName) {
		//list of address books name
		List<String> listOfAddrBookName = getListOfKeys();
		int cityCount = 0;
		
		for(int i=0; i < listOfAddrBookName.size(); i++) {
			//contact list of address book
			List<ContactDetails> contactList = addressBookList.get(listOfAddrBookName.get(i));
			//searching city name in contact list
			for(int j=0; j < contactList.size(); j++) {
				
				if(contactList.get(j).getCity().equalsIgnoreCase(cityName)) {
					cityCount++;
				}
			}
		}
		System.out.println("City Name : "+cityName);
		System.out.println("Total No of Person With City as "+cityName+" in All AddressBook : "+cityCount);
	}
/**
 * This method searches given state name in contact list of all
 * address book and keep count of searches & prints the total count
 * 	
 * @param stateName
 * @return No return
 */	
	public void getContactCountByState(String stateName) {
		//list of address books name
		List<String> listOfAddrBookName = getListOfKeys();
		int stateCount = 0;
		
		for(int i=0; i < listOfAddrBookName.size(); i++) {
			//contact list of address book
			List<ContactDetails> contactList = addressBookList.get(listOfAddrBookName.get(i));
			//searching state name in contact list
			for(int j=0; j < contactList.size(); j++) {
				
				if(contactList.get(j).getState().equalsIgnoreCase(stateName)) {
					stateCount++;
				}
			}
		}
		System.out.println("State Name : "+stateName);
		System.out.println("Total No of Person With State as "+stateName+" in All AddressBook : "+stateCount);
	}
/**
 * This method gets contact list of given address book then 
 * sort the contact list according to the first name of person
 * 	
 * @param addrName - address book name
 * @return No return
 */
	public void viewInSortedByName(String addrName) {
		//contact list of given address book
		List<ContactDetails> contactList = addressBookList.get(addrName);
		
		contactList.stream().sorted(Comparator.comparing(ContactDetails::getFirst_Name))
					.forEach(System.out::println);
	}
/**
 * This method gets contact list of given address book then 
 * sort the contact list according to the city name of person
 * 	
 * @param addrName - address book name
 * @return No return
 */	
	public void viewInSortedByCity(String addrName) {
		//contact list of given address book
		List<ContactDetails> contactList = addressBookList.get(addrName);
				
		contactList.stream().sorted(Comparator.comparing(ContactDetails::getCity))
					.forEach(System.out::println);
	}
/**
 * This method gets contact list of given address book then 
 * sort the contact list according to the state name of person
 * 	
 * @param addrName - address book name
 * @return No return
 */	
	public void viewInSortedByState(String addrName) {
		//contact list of given address book
		List<ContactDetails> contactList = addressBookList.get(addrName);
				
		contactList.stream().sorted(Comparator.comparing(ContactDetails::getState))
				.forEach(System.out::println);		
	}
/**
 * This method gets contact list of given address book then 
 * sort the contact list according to the zip code of person
 * 	
 * @param addrName - address book name
 * @return No return
 */	
	public void viewInSortedByZip(String addrName) {
		//contact list of given address book
		List<ContactDetails> contactList = addressBookList.get(addrName);
				
		contactList.stream().sorted(Comparator.comparingInt(ContactDetails::getZip_Code))
					.forEach(System.out::println);		
	}
	
	public void printKeyList() {
		
		List<String>keyList = getListOfKeys();
		System.out.println(keyList.size());
		
		keyList.stream().forEach(System.out::println);
	}
}
