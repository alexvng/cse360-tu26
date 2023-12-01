package application.controllers;

import javafx.fxml.FXML;

public class LogTabController {

	@FXML private MainController mainController; 
	
	public void injectMainController(MainController mainController) { 
		this.mainController = mainController; 
	}
	
	public LogTabController() {
		// TODO Auto-generated constructor stub
	}

	
}
