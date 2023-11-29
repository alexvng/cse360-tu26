package application.controllers;

import javafx.fxml.FXML;
import application.objects.Project; 

import javafx.scene.text.Text;

import javafx.scene.control.TextField;

import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;

import javafx.scene.control.ListView;

import javafx.scene.control.ComboBox;

public class EffortLoggerTabController {
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
	
	
	@FXML private MainController mainController; 
	
	long currentTime;
	boolean paused;
	
	String keyWordsRaw;
	String []keyWordsSplit;
	Timer timer = new Timer();

	Project historicalProject1 = new Project();
	Project historicalProject2 = new Project();
	
	String []names = {"Historical Project 1", "Historical Project 2"};	
	String projectSelected;
	
	public void injectMainController(MainController mainController) { 
		this.mainController = mainController; 
	}
	
	// Event Listener on Button.onAction starts clock
	@FXML
	public void startClock(ActionEvent event) {
		currentTime = 0;
		
		//Will only happen when start clicked again
		if(paused == true) {
			paused = false;
		}
	
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
			
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
	
	// Event Listener on Button.onAction stops clock
	@FXML
	public void stopClock(ActionEvent event) {
		timer.cancel();
		clock.setText("00:00");
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
	