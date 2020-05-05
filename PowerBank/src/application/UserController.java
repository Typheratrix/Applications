package application;


// This controller was used to control the "receive" functionality (User.fxml file). 
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.THAppTest;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class UserController {
	@FXML

	private AnchorPane mainPane2;
	

//takes us back to the main menu
	@FXML
	void handle2Screen(ActionEvent event) throws IOException {
	
		mainPane2 = FXMLLoader.load(getClass().getResource("Main.fxml"));// pane
																			// you
																			// are
																			// GOING
																			// TO
		Scene scene = new Scene(mainPane2);// pane you are GOING TO show
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

	// The comments for this function is the same as the one in the saveMe()
	// function in GiveController.java file. Please refer to that file to follow
	// the code.
	@FXML
	private void saveMe(ActionEvent event) throws IOException {
		String key= UserID.getText().toString();
		String New_key = Item.getText().toString().toLowerCase();
		String New_value = Quantity.getText().toString();
		if(THAppTest.addUserName(key)){
		THAppTest.subtractItem(New_key, New_value);
		UserID.clear();
		Item.clear();
		Quantity.clear();

	}else{
		UserID.clear();
		Item.clear();
		Quantity.clear();
		
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText("Sorry! Enter the user name in the correct format \"ABC123\".");
		alert.showAndWait();
	}
	}


}

