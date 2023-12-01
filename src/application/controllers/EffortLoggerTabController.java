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
	
	String userRaw;
	String keyWordsRaw;
	String []keyWordsSplit;
	Timer timer = new Timer();
	Date now;
	
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
	ProjectList projList = GlobalObjects.projList;
		
	EffortLog e1 = new EffortLog();
	public void injectMainController(MainController mainController) { 
		this.mainController = mainController; 
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		for(Project p: projList.getProjList()) {
			names.add(p.getName());
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
		System.out.println(end);
		//Creates new effortlog
		e1.setLifeCycleStep(lifeCycle);
		e1.setDate(now);
		e1.setEffortSubcategory(effortSubCategoryString);
		e1.setEffortCategory(effortCategoryString);
		//e1.addKeyWords(keyWordsRaw);
		//e1.addUserStory(userRaw);
		//Sets start and end date of effortlog
		e1.setDate(now);
		GlobalObjects.effortLogList.addLog(e1);
		
		//Adds EffortLog to appropriate Project
		for(Project p: projList.getProjList()) {
			if(p.getName().equals(projectSelected)) {
				System.out.println("Checked");
				p.getEffortLogList().add(e1);
				//System.out.println(projectSelected);
				for(EffortLog n: p.getEffortLogList())
					System.out.println("1 "+ n.getKeyWords());
				break;
			}
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTime = dateFormat.format(now);
        e1.setName(formattedTime);
	
	}
	
	// Event Listener on Button.onAction pauses clock
	@FXML
	public void pauseClock(ActionEvent event) {
		paused = true;
	}
		
	// Event Listener on Button.onAction
	@FXML
	public void addUserStory(ActionEvent event) {
		userRaw = "As a "+ asA.getText() +", I want " + iWant.getText() + " so that " + soThat.getText();
		userStories.getItems().add(userRaw);
		e1.addUserStory(keyWordsRaw);
		
		asA.clear();
		iWant.clear();
		soThat.clear();
		//historicalProject1.addUserStories(userRaw);
		
	}
	@FXML
	public void clearFields(ActionEvent event) {
		asA.clear();
		iWant.clear();
		soThat.clear();
		keywords.clear();
		userStories.getItems().clear();
		effortCategory.getItems().clear();
		effortSubCategory.getItems().clear();
		projectName.getItems().clear();
		lifeCycleStep.getItems().clear();
	}
	
	// Event Listener on Button.onAction adds key word
	@FXML
	public void addKeyword(ActionEvent event) {
		keyWordsRaw = keywords.getText();
		keyWordsSplit = keyWordsRaw.split("[,]",0);
		for(int i=0; i<keyWordsSplit.length;i++) {
			keyWordsList.getItems().add(keyWordsSplit[i]);
			e1.addKeyWords(keyWordsSplit[i]);
			//historicalProject1.addKeyWords(keyWordsSplit[i]);
		}
		keywords.clear();
	}
}
	