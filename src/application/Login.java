package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {
	
	InactivityTimer time = new InactivityTimer();

	
	@Override
	public void start(Stage stage) {
		try {
			ProjectsInitialize.initializeGlobal();
			Parent root = FXMLLoader.load(getClass().getResource("ELLogin.fxml"));
			Scene scene1 = new Scene(root);
			stage.setScene(scene1);
			time.tracker(stage);
			stage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}


}
