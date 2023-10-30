package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			/*
			//BorderPane root = new BorderPane();
			GridPane gridpane = new GridPane();
			gridpane.setVgap(20);
			gridpane.setHgap(20);
			Button startActivity = new Button("Start and Activity");
			Scene scene = new Scene(gridpane,1000,600);
			ArrayList<String> projectList = new ArrayList<String>();
			ComboBox<String> projects = new ComboBox<String>();
			projects.setEditable(true);
			for (int i = 0; i<projectList.size();i++)
			{
				projects.getItems().add(projectList.get(i));
			}
			//gridpane.add(new Label("1. When you want to start a new activity, press the \"start and Activity\" button."),0,0);
			gridpane.add(startActivity, 2, 1);
			gridpane.add(new Label("Projects"),2,2);
			gridpane.add(projects,3,2);
			
			
			startActivity.setOnAction(event -> { //When the button is pressed...
				boolean flag = true;//flag which is made false if another instance of the same string is input
				for (int i = 0; i<projectList.size();i++) //iterate through the list of PROJECTS to see if you are duplicating
				{
					if(projects.getValue().equals(projectList.get(i))) //if duplicate, change flag
					{
						flag = false;
						break;
					}
					
				}
				if (flag) //if flag was not changed, no duplicate, add the value to the arraylist and combobox.
				{
					projects.getItems().add(projects.getValue());
					projectList.add(projects.getValue());
				}
			});
			*/
			updating_combobox consoleWindow = new updating_combobox();
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1000,600);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	        primaryStage.setTitle("Effort Logger ComboBox Updating prototype");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			consoleWindow.openEffortConsole(primaryStage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
