package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;


public class EffortConsoleController implements Initializable {
	
	@FXML
	private TextField keywords;
	@FXML
	private TextField asA;
	@FXML
	private TextField iWant;
	@FXML
	private TextField soThat;
	@FXML
	private ListView<String> keyWordsList;
	@FXML
	private ListView<String> userStories;
	@FXML
	private ComboBox<String> projectName;
	@FXML
	private ComboBox<String> effortCategory;
	@FXML
	private ComboBox<String> effortSubCategory;
	@FXML
	private Text clock;
	
	long currentTime;
	boolean paused;
	
	String keyWordsRaw;
	String []keyWordsSplit;
	Timer timer = new Timer();

	project historicalProject1 = new project();
	project historicalProject2 = new project();
	
	String []names = {"Historical Project 1", "Historical Project 2"};	
	String projectSelected;
	
	
	//Initializes the 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//keyWordsList.getItems().add("DSAJKL");
		projectName.getItems().addAll(names);
		projectName.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				projectSelected = projectName.getSelectionModel().getSelectedItem();
				//System.out.println(projectSelected);
				if(projectSelected == "Historical Project 1") {
					
					historicalProject1.addUserStories("As a user I would like x so that I can do y");
					historicalProject1.addUserStories("As a user I would like z so that I can do n");
					historicalProject1.addUserStories("As a user I would like a so that I can do b");
					historicalProject1.addKeyWords("Key Word1");
					historicalProject1.addKeyWords("Key Word2");
					historicalProject1.addKeyWords("Key Word3");

					
//					String[] rand = historicalProject1.getUserStories();
//					for(int i=0;i<historicalProject1.getUserStories().length;i++) {
//						System.out.println(rand[i]);
//					}
					
					
					//userStories.getItems().add("Helo");
					userStories.getItems().addAll(historicalProject1.getUserStories());
					keyWordsList.getItems().addAll(historicalProject1.getKeyWords());
				}
				
			}
		});
	}
	
	//Gives user ability to add keywords
	public void addKeyword(ActionEvent event) throws IOException{
		keyWordsRaw = keywords.getText();
		keyWordsSplit = keyWordsRaw.split("[,]",0);
		for(int i=0; i<keyWordsSplit.length;i++) {
			keyWordsList.getItems().add(keyWordsSplit[i]);
			historicalProject1.addKeyWords(keyWordsSplit[i]);
		}
	}
	
	//Gives user ability to add userStories
	public void addUserStory(ActionEvent event) throws IOException{
		String userRaw = "As a "+ asA.getText() +", I want " + iWant.getText() + " so that " + soThat.getText();
		userStories.getItems().add(userRaw);
		historicalProject1.addUserStories(userRaw);
	}
	
	//Starts clock
	public void startClock(ActionEvent event) throws IOException{
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
		
	//Stops clock
	public void stopClock(ActionEvent event) throws IOException{
		timer.cancel();
		clock.setText("00:00");
		
	}
	
	//Pauses clock
	public void pauseClock(ActionEvent event) throws IOException{
		paused = true;
	}	
	
}
