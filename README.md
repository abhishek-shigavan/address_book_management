# Address Book Management

## Program Files

1) Controller --  AddressBook --
                      This class handles all user request

2) DAO  --  AddressBookDAO  --
                  This class contains methods of all the operations performed in 

3) File --  I) contactFileTxt --
                    Text file containing AddressBook name & its corresponding contact
            II) contactCSVFile --
                    CSV format file containing AddressBook name & its corresponding contact
            III) contactJSONFile  --
                      Json file containing AddressBook name & its corresponding contact

4) Model  --  ContactDetails  --
                    This class contains methods to get & set properties of contact 

5) ReadWrite  --  I)  CSVReaderWriter --           
                            This class contains methods to read & write contacts into Csv file 
                  II) FileReaderWrite --
                            This class contains methods to read & write contacts into file
                  III) JSONReaderWriter --
                            This class contains methods to read & write contacts into Json file

6) Service  --  I) AddressBookService --
                II) AddressBookServiceInterface --
                          This class contains abstract methods
                          
7)  Util  --  UserInputOutput --
                    This class contains methods to take input from console                


## Opeartions Performed In AddressBook

1)  Create New AddressBook  --  Creating New AddressBook with Contact in it.

2)  Add Contact In Existing AddressBook --  Add New Contact In Existing AddressBook. No Duplicate Entry Allow In Same AddressBook

3)  Edit Contact  --  Editing Existing Contact Of Given AddressBook

4)  Delete AddressBook  --  Deleting AddressBook

5)  Delete Contact  --  Deleting Given Contact Form Given AddressBook

6)  View All AddressBook  --  Displaying All AddressBook 

7)  View Specific Address Book --  Displaying Requested AddressBook

8)  Search Person In City -- Searching Given Contact Name in Given City

9)  Search Person In State  --  Searching Given Contact Name in Given State

10)  View Contacts By City  --  Displaying All the Contact Name Which Having City as Given City Name 

11)  View Contacts By State --  Displaying All the Contact Name Which Having State as Give State Name    

12)  Get Count of Person of Particular City -- Displaying Total of Contacts Having City as Given City Name

13)  Get Count of Person of Particular State -- Displaying Total of Contacts Having State as Given State Name 

14)  Sort AddressBook By Person Name  --  Sorting The AddressBook By Person Name & Displaying It

15)  Sort AddressBook By City Of Person --  Sorting The AddressBook By Persons City & Displaying It

16)  Sort AddressBook By State Of Person  --  Sorting The AddressBook By Persons State & Displaying It

17)  Sort AddressBook By Zip Code Of Person --  Sorting The AddressBook By Persons Zip Code & Displaying It         
