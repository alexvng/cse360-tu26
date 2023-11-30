package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import application.GlobalObjects;
import application.objects.EffortLog;
import application.objects.Project;
import application.objects.ProjectList;
import javafx.scene.text.Text;

import javafx.scene.control.TextField;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

import javafx.scene.control.ListView;

import javafx.scene.control.ComboBox;

public class EffortLoggerTabController implements Initializable {
	@FXML private TextField asA;
	@FXML private TextField iWant;
	@FXML private TextField soThat;
	@FXML private TextField keywords;
	@FXML private Text clock;
	@FXML private ListView<String> keyWordsList;
	@FXML private ListView<String> userStories;
	@FXML private ComboBox<String> projectName;
	@FXML private ComboBox<String> effortCategory;
	@FXML private ComboBox<String> effortSubCategory;
	@FXML private ComboBox<String> lifeCycleStep;
	
	
	@FXML private MainController mainController; 
	
	long currentTime;
	boolean paused;
	
	String keyWordsRaw;
	String []keyWordsSplit;
	Timer timer = new Timer();
	Date now;
	Project historicalProject1 = new Project();
	Project historicalProject2 = new Project();
	
	//Elements of the EffortLog that is being created
	String projectSelected;
	String lifeCycle;
	String effortCategoryString;
	String effortSubCategoryString;
	
	//Names of projects 
	List<String> names = new ArrayList<String>();
	
	//Creating references to objects so that its easier to use
	Project hp1 = GlobalObjects.proj1;
	Project hp2 = GlobalObjects.proj2;
	Project hp3 = GlobalObjects.proj3;
	Project hp4 = GlobalObjects.proj4;
	Project hp5 = GlobalObjects.proj5;
	Project hp6 = GlobalObjects.proj6;
	Project hp7 = GlobalObjects.proj7;
	ProjectList projList = GlobalObjects.projList;
		
	public void injectMainController(MainController mainController) { 
		this.mainController = mainController; 
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		for(int i=0;i<projList.getProjList().size();i++) {
			names.add(projList.getProjList().get(i).getName());
			//System.out.println(projList.getProjList().get(i).getName());
		}
		
		
		//Loads options into combo boxes
		projectName.getItems().addAll(names);
		effortCategory.getItems().addAll(GlobalObjects.effortCategory);
		lifeCycleStep.getItems().addAll(GlobalObjects.cycleSteps);
		
		//Listeners for combo boxes
		projectName.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {				
				//Check which project we are using and updates accordingly
				projectSelected = projectName.getSelectionModel().getSelectedItem();
			}
		});
		effortCategory.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				effortCategoryString = effortCategory.getSelectionModel().getSelectedItem();
								
				//Loads correct sub effort
		    	switch(effortCategoryString) {
		    	
		    	case "Plans": 
		    		effortSubCategory.getItems().clear();
		    		effortSubCategory.getItems().addAll(GlobalObjects.plansSubCategory);
		    		break;
		    	case "Deliverables":
		    		effortSubCategory.getItems().clear();
		    		effortSubCategory.getItems().addAll(GlobalObjects.deliverablesSubCategory);
		    		break;
		    	case "Interruptions":
		    		effortSubCategory.getItems().clear();
		    		effortSubCategory.getItems().addAll(GlobalObjects.interuptionsSubCategory);
		    		break;
		    	case "Defects":
		    		effortSubCategory.getItems().clear();
		    		effortSubCategory.getItems().addAll(GlobalObjects.defectSubCategory);
		    		break;
		    	case "Other":
		    		effortSubCategory.getItems().clear();
		    		effortSubCategory.getItems().addAll(GlobalObjects.othersSubCategory);
		    		break;
		    	}
	        
	        }
	    });
		lifeCycleStep.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				lifeCycle = lifeCycleStep.getSelectionModel().getSelectedItem();
		    }
		});
		effortSubCategory.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				effortSubCategoryString = effortSubCategory.getSelectionModel().getSelectedItem();

	        }
	    });
	
	
	}
	// Event Listener on Button.onAction starts clock and starts effortlog activity
	@FXML
	public void startClock(ActionEvent event) {
		now = new Date(); //Date when user starts activity
		currentTime = 0;
		
		//Will only happen when start clicked again
		if(paused == true) {
			paused = false;
		}
	
		timer.scheduleAtFixedRate(new TimerTask() {
		public void run() {
			//Returns the date
			
			if(paused == true) {
				
			}else {
				currentTime+=1;
			}
			//Time Conversions
			//long millis = currentTime % 1000;
			long second = currentTime % 60;
			long minute = (currentTime/(60))%60;
			
			String time = String.format("%02d:%02d",minute,second);
			
			clock.setText((time));
			
			
				}
			},0,1000); //Checks every 1 second
	}
	
	// Event Listener on Button.onAction stops clock and creates effortlog
	@FXML
	public void stopClock(ActionEvent event) {
		//Cancels timer and sends end time for effortlog
		timer.cancel();
		Date end = new Date();
		
		//Creates new effortlog
		EffortLog e1 = new EffortLog(lifeCycle,effortCategoryString, effortSubCategoryString);
		//Sets start and end date of effortlog
		e1.setDate(now);
		GlobalObjects.effortLogList.addLog(e1);
		
		//System.out.println(e1.getStartTime());
	
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTime = dateFormat.format(now);
	
	}
	
	// Event Listener on Button.onAction pauses clock
	@FXML
	public void pauseClock(ActionEvent event) {
		paused = true;
	}
		
	// Event Listener on Button.onAction
	@FXML
	public void addUserStory(ActionEvent event) {
		String userRaw = "As a "+ asA.getText() +", I want " + iWant.getText() + " so that " + soThat.getText();
		userStories.getItems().add(userRaw);
		historicalProject1.addUserStories(userRaw);
	}
	
	// Event Listener on Button.onAction adds key word
	@FXML
	public void addKeyword(ActionEvent event) {
		keyWordsRaw = keywords.getText();
		keyWordsSplit = keyWordsRaw.split("[,]",0);
		for(int i=0; i<keyWordsSplit.length;i++) {
			keyWordsList.getItems().add(keyWordsSplit[i]);
			historicalProject1.addKeyWords(keyWordsSplit[i]);
		}
	}
}
	