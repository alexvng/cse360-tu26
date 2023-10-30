package application; 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 

public class Login extends Application {


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Effort Logger Login");

        // Create elements in stage
        //username elements
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        
        //password elements
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        
        
        Button loginButton = new Button("Login");
        
        Button setPasswordButton = new Button("Set Password");
        
        //Create event handler for login button being pressed ()
        EventHandler<ActionEvent> loginAttempt = new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent e) { 
        		//set variable for inputted password and username
        		String inputUsername = usernameField.getText();
                String inputPassword = passwordField.getText();
                
                //check if username and password are equal 
                if (PasswordHandler.compareData(inputUsername, inputPassword)) {
                    showAlert("Success", "Login Successful!");
                } else {
                    showAlert("Error", "Invalid username or password! Please try again.");
                }
        	}
        }; 
        
        loginButton.setOnAction(loginAttempt); 
        
        /*EventHandler<ActionEvent> setDifferentInfo = new EventHandler<ActionEvent>() { 
        	Stage setPasswordStage = new Stage();
        	
        	void setInfo(Stage setPasswordStage){ 
        		
        	}
        }; 
        
        
        */
    
        // set up the layout 
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton, setPasswordButton);
        
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
    
    /*private void setInfo(Stage setInfoStage) { 
    	setInfoStage.setTitle("Change User Credentials"); 
    	// Create elements in stage
    	
        //username elements
        Label newUsernameLabel = new Label("New Username:");
        TextField newUsernameField = new TextField();
        
        //password elements
        Label newPasswordLabel1 = new Label("New Password:");
        PasswordField newPasswordField1 = new PasswordField();
        
        Label newPasswordLabel2 = new Label("Type Password again: "); 
        PasswordField newPasswordField2 = new PasswordField(); 
        
        Button submit = new Button("Submit"); 
        
        EventHandler<ActionEvent> changeInfo = new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent e) { 
        		//set variable for inputted password and username
        		String inputUsername = newUsernameField.getText();
                String inputPassword1 = newPasswordField1.getText();
                String inputPassword2 = newPasswordField2.getText(); 
               
                //check if username and password are equal 
                if (inputPassword1.equals(inputPassword2) && inputUsername != "") {
                    PasswordHandler.setUsername(inputUsername); 
                    PasswordHandler.setPassword(inputPassword1);
                	
                	showAlert("Success", "user info changed!");
                } else {
                    showAlert("Error", "Invalid inputs or passwords do not match, try again.");
                }
        	}
        }; 
        
        submit.setOnAction(changeInfo);
        
        
        
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(newUsernameLabel, newUsernameField, newPasswordLabel1, newPasswordField1, newPasswordLabel2, newPasswordField2);
        
        Scene scene = new Scene(layout, 300, 250);
        setInfoStage.setScene(scene);
        setInfoStage.show();
        	
        
    }
    */

    public static void main(String[] args) {
        launch(args);
    }

}