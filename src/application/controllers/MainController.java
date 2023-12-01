package application.controllers;

import javafx.fxml.FXML;

public class MainController {
	
	@FXML private EffortLoggerTabController effortLoggerTabController; 
	@FXML private EditorTabController editorTabController; 
	@FXML private DefectTabController defectTabController; 
	@FXML private LogTabController LogTabController; 
	@FXML private DefinitionsTabController definitionsTabController; 
	@FXML private PlanningPokerTabController PlanningPokerTabController; 
	
	
	@FXML private void initialize(){ 
		effortLoggerTabController.injectMainController(this);
		
	}
//	public MainController(){
//		
//	}
//	
}
