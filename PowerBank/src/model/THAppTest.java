package model;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

// This class holds all the main function necessary for the application to function.
public class THAppTest {
	
	// will add new keys & values to the properties file.
	// file along with doing addition operation if the key already exist.
	
	public static void addItem (String Item, String Quantity) throws FileNotFoundException, IOException{
		// grabs the enter by user new key and value
		String New_key = Item.toLowerCase();
		String New_value = Quantity;
		// get integer value of quantity to do math operation later on.
		Integer i = Integer.parseInt(New_value);

		// declaration of hash map h.
		HashMap<String, Integer> h = new HashMap<String, Integer>();

		Properties properties = new Properties();
		properties.load(new FileInputStream("data.properties"));

		// stream in the information from the data.properties file to our
		// hash map h.
		for (String key : properties.stringPropertyNames()) {
			h.put(key, Integer.parseInt(properties.get(key).toString()));
		}
		// close the input stream right away so we can do output stream below.
		new FileInputStream("data.properties").close();

		// check if the key already exist in the hash map. If it does exist,
		// then perform an addition operation on the old + new key value. Update the quantity of that key.
		if (h.containsKey(New_key)) {
			properties.remove(New_key);
			h.replace(New_key, h.get(New_key) + i);
			// System.out.println(h);

			// update is the new updated quantity.
			String update = h.get(New_key).toString().toString();
			properties.remove(New_key);
			// add the updated quantity to hash map h.
			properties.setProperty(New_key, update);
			// finally save it to the properties file.
			FileOutputStream file = new FileOutputStream("data.properties", true);
			properties.store(file, null);
			file.close();
			// if the key does not exist then just add it to the hash map h and
			// save it to the properties file.
		} else {

			properties.setProperty(New_key, New_value);
			FileOutputStream file = new FileOutputStream("data.properties", true);
			properties.store(file, null);
			file.close();

		}
	}
	

	 // Item quantity will be subtracted from bank. If the item is less then 0 or if the item does not exist, then the user will be referred to the main menu to check amount.
	public static void subtractItem (String Item, String Quantity) throws FileNotFoundException, IOException{
		// grabs the enter by user new key and value
		String New_key = Item.toLowerCase();
		String New_value = Quantity;
		// get integer value of the amount to do math operation later on.
		Integer i = Integer.parseInt(New_value);

		HashMap<String, Integer> h = new HashMap<String, Integer>();

		Properties properties = new Properties();
		properties.load(new FileInputStream("data.properties"));

		for (String key : properties.stringPropertyNames()) {
			h.put(key, Integer.parseInt(properties.get(key).toString()));
		}
		new FileInputStream("data.properties").close();
		
		// we will make sure that stock is not negative
       int afterSubtraction = h.get(New_key) - i;
		if (h.containsKey(New_key) && afterSubtraction >= 0) {
			properties.remove(New_key);
	
			// since user is taking and not giving, the amount will be
			// subtracted from a specific club.
			h.replace(New_key, h.get(New_key) - i);

			String update = h.get(New_key).toString().toString();
			properties.remove(New_key);
			properties.setProperty(New_key, update);

			FileOutputStream file = new FileOutputStream("data.properties", true);
			properties.store(file, null);

			file.close();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("It's yours now! Thank you for using PowerBank.");
			alert.showAndWait();
		} else {
			// This lets the user know that the item entered is not in our
			// account. He/she is referred to the main menu to check the
			// amount,
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("Sorry! The club chosen is not available or there is not enough in funds. Return to main menu to check our updated account balance.");
			alert.showAndWait();

		}
	}
	
	// function responsible for getting the amount in bank.
	public static String getNumberOfItemsInInventory(ObservableList<String> listofItems){
		// start to import data from the properties file
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("data.properties"));
		} catch (FileNotFoundException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		// stream in data
		for (String key : properties.stringPropertyNames()) {
			h.put(key, Integer.parseInt(properties.get(key).toString()));
		}
		try {
			new FileInputStream("data.properties").close();
		} catch (FileNotFoundException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}

		String textareaString = "";
	
		for (Object item : listofItems) {
			// check if the list contains any keys that are save in the
			// properties file.
			if (h.containsKey(item)) {
				// grab the key if the word already exist. (they all exist).
				// i will let us grab the value so we can show it in the text
				// area later.
				Integer i = h.get(item);
				// insert key = value in the text area.
				textareaString += String.format("%s = %d %n", (String) item, i);

			}

		}
		return textareaString;
		
	}
	//function responsible for verifying that the userID input is in the correct format.
	public static boolean addUserName(String key){
		
		if(key.matches("[a-zA-z]{3}[0-9]{3}")){
			return true;
		} else {
			return false;	
	}
	}


}
