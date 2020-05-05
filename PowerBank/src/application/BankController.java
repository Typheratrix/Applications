package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.THAppTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import javafx.scene.layout.VBox;


//This class will take care of the bank system. The user is able to check the amount of each club.
public class BankController implements Initializable {

	@FXML
	private VBox vb;

	@FXML
	private ListView<String> listview;

	@FXML
	private TextArea textarea;

	@FXML
	private AnchorPane mainPane4;

	@FXML
	void handle2Screen(ActionEvent event) throws IOException {
		
		mainPane4 = FXMLLoader.load(getClass().getResource("Main.fxml"));// pane
																			// you
																			// are
																			// GOING
																			// TO
		Scene scene = new Scene(mainPane4);// pane you are GOING TO show
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();// pane
																					// you
																					// are
																					// ON
		window.setScene(scene);
		window.show();
	}

	// call to getNuberOfItemsInInventory() functions. It shows the user what is currently in the bank.
	@FXML
	void saveMe(ActionEvent event) {
		
		ObservableList<String> listofItems = listview.getSelectionModel().getSelectedItems();
		textarea.setText(THAppTest.getNumberOfItemsInInventory(listofItems));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//  Auto-generated method stub

		// starting to read from the properties file to get the keys
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
		// go through and grab all the content
		for (String key : properties.stringPropertyNames()) {
			h.put(key, Integer.parseInt(properties.get(key).toString()));
		}
		try {
			new FileInputStream("data.properties").close();
		} catch (FileNotFoundException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}

		

		// this will go through the for loop and insert all the keys from the
		// hash map into the the list view.
		List<String> keylist = new ArrayList<String>(h.keySet());
		for (String key : keylist) {
			//System.out.println(key);
			//turn the key to a string.
			String New_key = key.toString();
			listview.getItems().addAll(New_key);
		}
		// allows for multiple selection
		listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}

}