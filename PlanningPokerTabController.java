package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

//import application.objects.HProject;
import application.objects.Project;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlanningPokerTabController implements Initializable{
	@FXML private TextField keywords;
	@FXML private TextField asA;
	@FXML private TextField iWant;
	@FXML private TextField soThat;
	@FXML private ListView<String> keyWordsListPoker;
	@FXML private ListView<String> userStoriesPoker;
	@FXML private ComboBox<String> projectName;
	@FXML private ListView<String> similarHP;
	@FXML private ListView<String> pStories;
	@FXML private ListView<String> pKeyWords;
	@FXML private Slider weightSlider;
	
	@FXML private MainController mainController; 

	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private int totalkeys;
	private int totalstories;
	
	String keyWordsRaw;
	String []keyWordsSplit;
	Timer timer = new Timer();
	String []keyWordListArr = new String[5];
	String[]userStoryListArr = new String[5];
	Project hp1 = new Project();
	Project hp2 = new Project();
	Project hp3 = new Project();
	String[] names = {"hp1","hp2","hp3"};
	String projectSelected;
	
	public void injectMainController(MainController mainController) { 
		this.mainController = mainController; 
	}
	
	//Initializes ComboBox with the options
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		hp1.addKeyWords("KeyWord1");
		hp1.addKeyWords("KeyWord2");
		hp2.addKeyWords("KeyWord3");
		hp3.addKeyWords("KeyWord3");
		hp1.addUserStories("As a X, I want Y so that Z");
		hp2.addUserStories("As a Z, I want X so that Y");
		projectName.getItems().addAll(names);
		weightSlider.valueProperty().addListener((observalbe,oldValue,newValue)-> {
			//System.out.println((int)newValue);
		});
		projectName.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				int sKeys;
				int sStories;
				double weightedVal;
				
				//Check which project we are using and updates accordingly
				projectSelected = projectName.getSelectionModel().getSelectedItem();
				if(projectSelected.equals("hp1")) {
					System.out.println("TotalKeys: " + totalkeys);
					pStories.getItems().clear();
					pKeyWords.getItems().clear();
					pStories.getItems().addAll(hp1.getUserStories());
					pKeyWords.getItems().addAll(hp1.getKeyWords());
					sKeys = checkKeyWords(hp1);
					sStories = checkStories(hp1);
					System.out.println("sKeys: "+ sKeys);
					if(totalkeys == 0) {
						if(totalstories == 0) {
							weightedVal = 0;
						}else {
							weightedVal = (double)((double)sStories/(double)totalstories);
						}
					}else if(totalstories == 0) {
						if(totalkeys == 0) {
							weightedVal = 0;
						}else {
							System.out.println("dSJAL");
							weightedVal = (double)((double)sKeys/(double)totalkeys);
							System.out.println(weightedVal + "= "+sKeys +"/" + totalkeys);
						}
					}else {
						weightedVal = (double)((((double)sKeys/(double)totalkeys) / 2.0) + (((double)sStories/(double)totalstories)/2.0)); 
					}
					weightedVal*=100.00;
					System.out.println("weight: "+weightedVal);
					hp1.setWeight(weightedVal);
					weightSlider.setValue((double)hp1.getWeight());

				}
				if(projectSelected.equals("hp2")) {
					System.out.println("TotalKeys: " + totalkeys);
					pStories.getItems().clear();
					pKeyWords.getItems().clear();
					pStories.getItems().addAll(hp2.getUserStories());
					pKeyWords.getItems().addAll(hp2.getKeyWords());
					sKeys = checkKeyWords(hp2);
					sStories = checkStories(hp2);
					System.out.println("sKeys: "+ sKeys);

					if(totalkeys == 0) {
						if(totalstories == 0) {
							weightedVal = 0;
						}else {
							weightedVal = (double)((double)sStories/(double)totalstories);
						}
					}else if(totalstories == 0) {
						if(totalkeys == 0) {
							weightedVal = 0;
						}else {
							System.out.println("dSJAL");
							weightedVal = (double)((double)sKeys/(double)totalkeys);
							System.out.println(weightedVal + "= "+sKeys +"/" + totalkeys);
						}
					}else {
						weightedVal = (double)((((double)sKeys/(double)totalkeys) / 2.0) + (((double)sStories/(double)totalstories)/2.0)); 
					}
					weightedVal*=100;
					System.out.println("weight: "+weightedVal);
					hp2.setWeight(weightedVal);
					weightSlider.setValue((double)hp2.getWeight());

				}
				if(projectSelected.equals("hp3")){
					pStories.getItems().clear();
					pKeyWords.getItems().clear();
					pStories.getItems().addAll(hp3.getUserStories());
					pKeyWords.getItems().addAll(hp3.getKeyWords());
					sKeys = checkKeyWords(hp3);
					sStories = checkStories(hp3);
					if(totalkeys == 0) {
						if(totalstories == 0) {
							weightedVal = 0;
						}else {
							weightedVal = (double)((double)sStories/(double)totalstories);
						}
					}else if(totalstories == 0) {
						if(totalkeys == 0) {
							weightedVal = 0;
						}else {
							weightedVal = (double)((double)sKeys/(double)totalkeys);
						}
					}else {
						weightedVal = (double)((((double)sKeys/(double)totalkeys) / 2) + (((double)sStories/(double)totalstories)/2)); 
					}
					weightedVal*=100;
					hp3.setWeight(weightedVal);
					weightSlider.setValue((double)hp3.getWeight());

				}
				
			}
		});
	}
	
	public void loadPoker(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("EffortLoggerV2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void findSimilar(ActionEvent event) throws IOException{
		ObservableList<String> keyWordList = keyWordsListPoker.getItems();
		ObservableList<String> userStoriesList = userStoriesPoker.getItems();
		
		//System.out.println(keyWordList);
		int i = 0;
		int j = 0;
		int compareWords = 0;
		int compareStories = 0;
		
		
		//Grabs user Stories and KeyWords and puts them into arrays
		for(String word: keyWordList) {
			keyWordListArr[i] = word;
			i++;
		}
		for(String item: userStoriesList) {
			userStoryListArr[j] = item;
			j++;
		}
		
		//Compares user stories and keywords to past projects
		
	}
	//Returns the ammount of similar key words
	public int checkKeyWords(Project hp){
		int similar = 0;
		String [] h = hp.getKeyWords();
		for(int i = 0;i<keyWordListArr.length;i++) {
			for(int j = 0;j<h.length;j++) {
				
				if(keyWordListArr[i] == null || h[j] == null) {
					continue;
				}else {
					if(keyWordListArr[i].equals(h[j])) similar++;
				}
			}
		}
		return similar;
	}
	
	//Returns the ammount of similar user stories
	public int checkStories(Project hp){
		int similar = 0;
		String [] h = hp.getUserStories();
		for(int i = 0;i<userStoryListArr.length;i++) {
			for(int j = 0;j<h.length;j++) {
				if(userStoryListArr[i] == null || h[j] == null) {
					continue;
				}else {
					if(userStoryListArr[i].equals(h[j])) similar++;
				}
			}
		}
		return similar;
	}
	
	public void addKeyword(ActionEvent event) throws IOException{
		keyWordsRaw = keywords.getText();
		keyWordsSplit = keyWordsRaw.split("[,]",0);
		for(int i=0; i<keyWordsSplit.length;i++) {
			keyWordsListPoker.getItems().add(keyWordsSplit[i]);
			totalkeys++;
		}
	}
	
	public void addUserStory(ActionEvent event) throws IOException{
		String userRaw = "As a "+ asA.getText() +", I want " + iWant.getText() + " so that " + soThat.getText();
		userStoriesPoker.getItems().add(userRaw);
		totalstories++;
	}


}
