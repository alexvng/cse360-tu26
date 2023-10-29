package application; 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Login extends Application {

    private final String validUsername = "admin";
    private final String validPassword = "password";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Form");

        // Create form elements
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");

        // Create an action for the login button
        loginButton.setOnAction(event -> {
            String inputUsername = usernameField.getText();
            String inputPassword = passwordField.getText();

            if (inputUsername.equals(validUsername) && inputPassword.equals(validPassword)) {
                showAlert("Success", "Login Successful!");
            } else {
                showAlert("Error", "Invalid username or password!");
            }
        });

        // Set up the form layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);

        Scene scene = new Scene(layout, 300, 200);
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

    public static void main(String[] args) {
        launch(args);
    }

}