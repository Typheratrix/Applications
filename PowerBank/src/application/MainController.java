package application;

//Main controller takes us to the different Panes. (Considered the main menu/home).
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

	@FXML
	private AnchorPane mainPane;
	

	//take you to the "Need" pane.
	@FXML
	public void handle1(ActionEvent event) throws IOException {

		mainPane = FXMLLoader.load(getClass().getResource("User.fxml"));// pane
																		// you
																		// are
																		// GOING
																		// TO
		Scene scene = new Scene(mainPane);// pane you are GOING TO show
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();// pane
																					// you
																					// are
																					// ON
		window.setScene(scene);
		window.show();
	
	}
	//takes user to the donate pane
	public void handle2(ActionEvent event) throws IOException {

		mainPane = FXMLLoader.load(getClass().getResource("Give.fxml"));// pane
																		// you
																		// are
																		// GOING
																		// TO
		Scene scene = new Scene(mainPane);// pane you are GOING TO show
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();// pane
																					// you
																					// are
																					// ON
		window.setScene(scene);
		window.show();

	}
	//take user to the bank look up pane
	public void handle3(ActionEvent event) throws IOException {

		mainPane = FXMLLoader.load(getClass().getResource("LookUpInventory.fxml"));// pane
																					// you
																					// are
																					// GOING
																					// TO
		Scene scene = new Scene(mainPane);// pane you are GOING TO show
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();// pane
																					// you
																					// are
																					// ON
		window.setScene(scene);
		window.show();

	}
	//takes user to the about pane
	public void about(ActionEvent event) throws IOException {

		mainPane = FXMLLoader.load(getClass().getResource("About.fxml"));// pane
																					// you
																					// are
																					// GOING
																					// TO
		Scene scene = new Scene(mainPane);// pane you are GOING TO show
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();// pane
																					// you
																					// are
																					// ON
		window.setScene(scene);
		window.show();

	}

}