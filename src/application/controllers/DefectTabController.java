package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DefectTabController {

	@FXML private MainController mainController; 

	public DefectTabController() {
		// TODO Auto-generated constructor stub
	}

	public void injectMainController(MainController mainController) { 
		this.mainController = mainController; 
	}
	
	@FXML
	public void openDefect(ActionEvent event) {
		
	}
}
