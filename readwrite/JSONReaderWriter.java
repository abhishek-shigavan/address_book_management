package com.addressbook.readwrite;

import com.addressbook.model.ContactDetails;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;

/**
 * JSONReaderWriter - Using JSON to read & write AddressBookName & contact details
 *                    into JSON file
 *
 */
public class JSONReaderWriter {
    //defining path of file to write data
    public static final File filePath = new File("./src/main/java/com/addressbook/file/contactJSONFile.json");
    //defining array to store Json objects
    JsonArray jsonElements = new JsonArray();
    /**
     * This method writes AddressBook name & contacts details into Json file
     *
     * @param addrName - addressBook name
     * @param contactDetails - persons contact details
     */
    public void writeJsonFile(String addrName, ContactDetails contactDetails) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("AddressBook Name ",addrName);
            jsonObject.addProperty("First Name ", contactDetails.getFirst_Name());
            jsonObject.addProperty("Last Name ", contactDetails.getLast_Name());
            jsonObject.addProperty("Address ", contactDetails.getAddress());
            jsonObject.addProperty("City Name ", contactDetails.getCity());
            jsonObject.addProperty("State Name ", contactDetails.getState());
            jsonObject.addProperty("Mobile Number ", contactDetails.getMob_No());
            jsonObject.addProperty("Pin Code ", contactDetails.getZip_Code());
            jsonObject.addProperty("Email Id ", contactDetails.getEmail());
            jsonElements.add(jsonObject);

            FileWriter file = new FileWriter(filePath);
            file.write(jsonElements.toString());
            file.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * This method reads the Json file & prints Json objects i.e AddressBook Name & Contact details
     * store in Json array
     */
    public void readJSonFile() {
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonElements = null;
        try {
            FileReader reader = new FileReader(filePath);
            jsonElements = (JsonArray) jsonParser.parse(reader);
            System.out.println(jsonElements);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
