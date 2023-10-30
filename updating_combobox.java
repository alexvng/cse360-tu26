package application;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


// 	How to use:
// 	1) create an instnce of "updating_combobox"
//	ex: updating_combobox consoleWindow = new updating_combobox();
//	2) call the function "openEffortConsole" and pass the primary stage
//	ex: consoleWindow.openEffortConsole(primaryStage);
//
public class updating_combobox {
	ArrayList<String> projectList = new ArrayList<String>();
	ArrayList<String> lifecycleList = new ArrayList<String>();
	ArrayList<String> effortCategoryList = new ArrayList<String>();
	ArrayList<String> deliverableList = new ArrayList<String>();

	ComboBox<String> projects = new ComboBox<String>();
	ComboBox<String> lifecycles = new ComboBox<String>();
	ComboBox<String> effortCategories = new ComboBox<String>();
	ComboBox<String> deliverables = new ComboBox<String>();

	BorderPane root = new BorderPane();
	GridPane gridpaneDropdowns = new GridPane();

	VBox verticalAlignment = new VBox();
	Button startActivity = new Button("Start an Activity");
	Button stopActivity = new Button("Stop this Activity");
	Scene scene = new Scene(root,1000,600);
	boolean effortLoggerRunning = false;
	
	public void openEffortConsole(Stage primaryStage) {
		//reinitialize each element
		effortLoggerRunning = false;
		root = new BorderPane();
		gridpaneDropdowns = new GridPane();

		verticalAlignment = new VBox();
		startActivity = new Button("Start an Activity");
		stopActivity = new Button("Stop this Activity");
		scene = new Scene(root,1000,600);
		//set characteristics of every element
		
		root.setCenter(verticalAlignment);
		verticalAlignment.setSpacing(20);
	    root.setPadding(new Insets(10, 60, 10, 60));
		//verticalAlignment.setAlignment(Pos.TOP_CENTER);
		gridpaneDropdowns.setVgap(20);
		gridpaneDropdowns.setHgap(20);
		

		projects.setEditable(true);
		lifecycles.setEditable(true);
		effortCategories.setEditable(true);
		deliverables.setEditable(true);
		
		projects.setDisable(false);
		lifecycles.setDisable(false);
		effortCategories.setDisable(false);
		deliverables.setDisable(false);
		

		startActivity.setDisable(false);
		stopActivity.setDisable(true);

		gridpaneDropdowns.add(new Label("Project:"),2,2);
		gridpaneDropdowns.add(projects,3,2);
		gridpaneDropdowns.add(new Label("Life Cycle Step:"),4,2);
		gridpaneDropdowns.add(lifecycles,5,2);
		
		gridpaneDropdowns.add(new Label("Effort Category:"),2,3);
		gridpaneDropdowns.add(effortCategories,3,3);
		
		gridpaneDropdowns.add(new Label("Deliverable:"),4,3);
		gridpaneDropdowns.add(deliverables,5,3);
		
		verticalAlignment.getChildren().add(new Label("1. When you start a new activity, press the \"Start an Activity\" button."));
		verticalAlignment.getChildren().add(startActivity);
		verticalAlignment.getChildren().add(new Label("2. Select the project, life cycle step, effort category, and deliverable from the following lists:"));
		verticalAlignment.getChildren().add(gridpaneDropdowns);
		verticalAlignment.getChildren().add(new Label("3. Press the \"Stop Activity\" to generate an effort log entry using the attributes above" ));
		verticalAlignment.getChildren().add(stopActivity);

		//populate the dropdowns with stored values
		for (int i = 0; i<projectList.size();i++)
		{
			projects.getItems().add(projectList.get(i));
		}

		//populate the dropdowns with stored values
		for (int i = 0; i<lifecycleList.size();i++)
		{
			lifecycles.getItems().add(lifecycleList.get(i));
		}

		//populate the dropdowns with stored values
		for (int i = 0; i<effortCategoryList.size();i++)
		{
			effortCategories.getItems().add(effortCategoryList.get(i));
		}

		//populate the dropdowns with stored values
		for (int i = 0; i<deliverableList.size();i++)
		{
			deliverables.getItems().add(deliverableList.get(i));
		}
		//gridpane.add(new Label("1. When you want to start a new activity, press the \"start and Activity\" button."),0,0);
		
		
		startActivity.setOnAction(event -> { //When the button is pressed...
			if(!effortLoggerRunning)
			{
				startActivity.setDisable(true);
				stopActivity.setDisable(false);
				boolean flag = true;//flag which is made false if another instance of the same string is input
				effortLoggerRunning = true;
	
				projects.setDisable(true);
				lifecycles.setDisable(true);
				effortCategories.setDisable(true);
				deliverables.setDisable(true);
				
				//Check projectList for duplicates
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
				flag = true;
				
				//Check lifecycleList for duplicates
				for (int i = 0; i<lifecycleList.size();i++) //iterate through the list of PROJECTS to see if you are duplicating
				{
					if(lifecycles.getValue().equals(lifecycleList.get(i))) //if duplicate, change flag
					{
						flag = false;
						break;
					}
					
				}
				if (flag) //if flag was not changed, no duplicate, add the value to the arraylist and combobox.
				{
					lifecycles.getItems().add(lifecycles.getValue());
					lifecycleList.add(lifecycles.getValue());
				}
				flag = true;
				
				
				//Check effortCategoryList for duplicates
				for (int i = 0; i<effortCategoryList.size();i++) //iterate through the list of PROJECTS to see if you are duplicating
				{
					if(effortCategories.getValue().equals(effortCategoryList.get(i))) //if duplicate, change flag
					{
						flag = false;
						break;
					}
					
				}
				if (flag) //if flag was not changed, no duplicate, add the value to the arraylist and combobox.
				{
					effortCategories.getItems().add(effortCategories.getValue());
					effortCategoryList.add(effortCategories.getValue());
				}
				flag = true;
				
				//Check lifecycleList for duplicates
				for (int i = 0; i<deliverableList.size();i++) //iterate through the list of PROJECTS to see if you are duplicating
				{
					if(deliverables.getValue().equals(deliverableList.get(i))) //if duplicate, change flag
					{
						flag = false;
						break;
					}
					
				}
				if (flag) //if flag was not changed, no duplicate, add the value to the arraylist and combobox.
				{
					deliverables.getItems().add(deliverables.getValue());
					deliverableList.add(deliverables.getValue());
				}
				flag = true;
				
			}

			
		});
		stopActivity.setOnAction(event -> { //When the button is pressed...

			effortLoggerRunning = false;
			projects.setDisable(false);
			lifecycles.setDisable(false);
			effortCategories.setDisable(false);
			deliverables.setDisable(false);
			startActivity.setDisable(false);
			stopActivity.setDisable(true);
			
		});

        primaryStage.setScene(scene);
		
	}
}