package com.addressbook.readwrite;

import com.addressbook.model.ContactDetails;
import java.io.*;
/**
 * FileReaderWriter	-	Writing Contact & Name of AddressBook into file & reading that file
 *
 * @author Abhishek Shigavan
 */
public class FileReaderWriter {
    //defining path of file to write data
    public static final File fileAsDatabase = new File("./src/main/java/com/addressbook/file/contactFileTxt.txt");

    /**
     * This method writes contact details along with its AddressBook name into the file
     * whenever new contact is added to addressBook
     *
     * @param addrName - AddressBook name
     * @param person - contact details
     */
    public void addToFile(String addrName, ContactDetails person) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileAsDatabase , true))) {
            writer.write("+++++\n" +
                    "AddressBook Name :- "+addrName + "\n"
                    +"First Name :- "+ person.getFirst_Name() + "\n"
                    +"Last Name :- "+ person.getLast_Name() + "\n"
                    +"Address :- "+ person.getAddress() + "\n"
                    +"City :- "+person.getCity() + "\n"
                    +"State :- "+ person.getState() + "\n"
                    +"Email :- "+ person.getEmail() + "\n"
                    +"Zip Code :- "+ person.getZip_Code() + "\n"
                    +"Mobile No :- "+ person.getMob_No() + "\n"
                    + "-----\n");
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    /**
     * This method reads the files containing addressBook name & its contacts
     *
     * @param filePath -- path of file
     */
    public void readData(File filePath){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
