package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField UserName;
	@FXML
	private TextField Password;
	
	private long zeroTime;
	
	String user;
	String pass;
	
	public void checkPassword(ActionEvent event) throws IOException {
		
		//Grabs User Name and Password
		user = UserName.getText();
		pass = Password.getText();
		
		if(user.equals("Admin") && pass.equals("Password")) {
			//Switches to main application if username and password is valid
			zeroTime = System.currentTimeMillis();
			root = FXMLLoader.load(getClass().getResource("EffortLoggerV2.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}else {
			//Displays Error Message if UserName and Password is not valid
			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("Incorrect Username or Password");
			error.setContentText("The inputted Username and Password combination is not valid.");
			error.showAndWait();
		}
		

		
	}
	
	
	public void setPassword(ActionEvent event) throws IOException{
		
	}

	public long getZero() {
		return zeroTime;
	}

}
