package com.addressbook.controller;

import com.addressbook.model.ContactDetails;
import com.addressbook.service.AddressBookService;
import com.addressbook.service.AddressBookServiceInterface;
import com.addressbook.util.UserInputOutput;
import java.util.List;
/**
 * AddressBook	--	This class calls method according to
 * 					operation perform in AddressBook chosen by user
 *
 * @author Abhishek Shigavan
 */
public class AddressBook {
    AddressBookServiceInterface addressBookService = new AddressBookService();

    public void showAddressBookMenu() {
        UserInputOutput userIO = new UserInputOutput();
        boolean flag = true;
        int choice = 0;
        while(flag) {
            int option = userIO.addressBookMenu();
            switch(option) {
                case 1:{
                    String addrName = userIO.getAddressBookName();
                    //checking AddressBook is present / not
                    boolean isPresent = addressBookService.isAddressBookPresent(addrName);

                    if (isPresent) {
                        System.out.println("AddressBook with "+addrName+" is already present");
                    }
                    else {
                        List<ContactDetails> contactList = userIO.getNewContactDetails(addrName);
                        addressBookService.addAddressBook(addrName,contactList);
                    }
                    break;
                }
                case 2:{
                    String addrName = userIO.getAddressBookName();
                    //checking AddressBook is present / not
                    boolean isAddrPresent = addressBookService.isAddressBookPresent(addrName);
                    String contactName  = userIO.getContactNameToCheck();
                    //checking contact name is present in address book / not
                    boolean isContactPresent = addressBookService.isContactPresent(addrName, contactName);

                    if(isAddrPresent == true && isContactPresent == false) {
                        //getting existing contact list
                        List<ContactDetails> existingContactList = addressBookService.getExistingContactList(addrName);
                        //contact list with newly added contact
                        List<ContactDetails> contactList = userIO.getDetailsForExisting(existingContactList, addrName);
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
                    System.out.println("\n**** Editing Contact ****\n");
                    String addrName = userIO.getEditAddressBookName();
                    //checking AddressBook is present / not
                    boolean isAddrPresent = addressBookService.isAddressBookPresent(addrName);
                    String contactName = userIO.getEditContactName();
                    //checking contact is present / not
                    boolean isContactPresent = addressBookService.isContactPresent(addrName, contactName);

                    if(isAddrPresent && isContactPresent) {
                        //getting new contact details
                        ContactDetails contactDetails = userIO.getEditContactDetails(addrName);
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
                    String addrName = userIO.getAddressBookName();
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
                    String addrName = userIO.getAddressBookName();
                    //checking AddressBook is present / not
                    boolean isAddrPresent = addressBookService.isAddressBookPresent(addrName);
                    String contactName = userIO.getDeleteContactName();
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
                    System.out.println("\n**** View ****");
                    choice = userIO.getViewMenu();
                    switch(choice) {
                        case 1:{
                            System.out.println("\n**** Displaying All AddressBook ****");
                            addressBookService.viewAddressBook();
                            break;
                        }
                        case 2:{
                            System.out.println("\n**** Displaying Specific AddressBook ****");
                            String addrName = userIO.getAddressBookName();
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
                        case 3:{
                            System.out.println("\n**** View Contacts By City ****");
                            String cityName = userIO.getCityName();
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
                        case 4:{
                            System.out.println("\n**** View Contacts By State ****");
                            String stateName = userIO.getStateName();
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
                    }
                    break;
                }
                case 7:{
                    System.out.println("\n**** Searching Person ****");
                    choice = userIO.getSearchMenu();
                    switch(choice) {
                        case 1:{
                            System.out.println("\n**** Searching Person By City Name ****");
                            //getting city & contact name
                            String cityName = userIO.getCityName();
                            String contactName = userIO.getSearchContactName();
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
                        case 2:{
                            System.out.println("\n**** Searching Person By State Name ****");
                            //getting state & contact name
                            String stateName = userIO.getStateName();
                            String contactName = userIO.getSearchContactName();
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
                    }
                    break;
                }
                case 8:{
                    System.out.println("\n**** View Count Of Person ****");
                    choice = userIO.getCountOfPersonMenu();
                    switch(choice) {
                        case 1:{
                            System.out.println("\n**** Displaying Count Of Persons Of City ****\n");
                            String cityName = userIO.getCityName();
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
                        case 2:{
                            System.out.println("\n**** Displaying Count Of Persons Of State ****");
                            String stateName = userIO.getStateName();
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
                    }
                    break;
                }
                case 9:{
                    System.out.println("\n**** View AddressBook In Sorted Order ****");
                    String addrName = userIO.getAddressBookName();
                    //checking AddressBook is present / not
                    boolean isAddrPresent = addressBookService.isAddressBookPresent(addrName);

                    if(isAddrPresent) {
                        choice = userIO.getSortedOrderMenu();
                        switch(choice) {
                            case 1:{
                                System.out.println("\n**** AddressBook Sorted By Name Of Person ****\n");
                                addressBookService.viewInSortedByName(addrName);
                                break;
                            }
                            case 2:{
                                System.out.println("\n**** AddressBook Sorted By City Name ****\n");
                                addressBookService.viewInSortedByCity(addrName);
                                break;
                            }
                            case 3:{
                                System.out.println("\n**** AddressBook Sorted By State Name ****\n");
                                addressBookService.viewInSortedByState(addrName);
                                break;
                            }
                            case 4:{
                                System.out.println("\n**** AddressBook Sorted By Zip Code ****\n");
                                addressBookService.viewInSortedByZip(addrName);
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("No such AddressBook with name : "+addrName);
                    }
                    break;
                }
                case 10:{
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
