package application;

import java.io.IOException;
import java.util.Timer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PlanningPokerController {
	@FXML
	private TextField keywords;
	@FXML
	private TextField asA;
	@FXML
	private TextField iWant;
	@FXML
	private TextField soThat;
	@FXML
	private ListView<String> keyWordsListPoker;
	@FXML
	private ListView<String> userStoriesPoker;

	String keyWordsRaw;
	String []keyWordsSplit;
	Timer timer = new Timer();

	public void addKeyword(ActionEvent event) throws IOException{
		keyWordsRaw = keywords.getText();
		keyWordsSplit = keyWordsRaw.split("[,]",0);
		for(int i=0; i<keyWordsSplit.length;i++) {
			keyWordsListPoker.getItems().add(keyWordsSplit[i]);
		}
	}
	
	public void addUserStory(ActionEvent event) throws IOException{
		String userRaw = "As a "+ asA.getText() +", I want " + iWant.getText() + " so that " + soThat.getText();
		userStoriesPoker.getItems().add(userRaw);
	}


}
