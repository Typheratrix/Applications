package application;


//This class is in charge of adding/updating items with their respective quantity to the properties file.
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.THAppTest;

public class DonateController {
	
	@FXML
	private AnchorPane mainPane3;

	//lets us go back to the main menu
	@FXML
	void handle2Screen(ActionEvent event) throws IOException {
		
		mainPane3 = FXMLLoader.load(getClass().getResource("Main.fxml"));// pane
																			// you
																			// are
																			// GOING
																			// TO
		Scene scene = new Scene(mainPane3);// pane you are GOING TO show
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();// pane
																					// you
																					// are
																					// ON
		window.setScene(scene);
		window.show();
	}

	@FXML
	private TextField Item;

	@FXML
	private TextField UserID;

	@FXML
	private TextField Quantity;

	// function used when button save is hit. It will call the addItem() function to update our database.
	//Firstly, the format of the userID input will be verified by calling addItem() function.
	@FXML
	private void saveMe(ActionEvent event) throws IOException {
		String key= UserID.getText().toString();
		
	
		// grab all the input from text field and turn into string.
		String New_key = Item.getText().toString().toLowerCase();
		String New_value = Quantity.getText().toString();
		if(THAppTest.addUserName(key)){
        // call to perform the adding and updating.
		THAppTest.addItem(New_key, New_value);
		// clear the text field
		UserID.clear();
		Item.clear();
		Quantity.clear();
		// give confirmation
		Alert alert = new Alert(AlertType.CONFIRMATION);
		// adding my own text to the alert.
		alert.setContentText("Thank you! The amount will be added to your bank.");
		alert.showAndWait();

	} else {
			
		UserID.clear();
		Item.clear();
		Quantity.clear();
		
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText("Sorry! Enter the user name in the correct format \"ABC123\".");
		alert.showAndWait();
	}
	}

}


