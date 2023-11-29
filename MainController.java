package application.controllers;

import javafx.fxml.FXML;

public class MainController {
	
	@FXML private EffortLoggerTabController effortLoggerTabController; 
	@FXML private EditorTabController editorTabController; 
	@FXML private DefectTabController defectTabController; 
	@FXML private LogTabController logTabController; 
	@FXML private DefinitionsTabController definitionsTabController; 
	@FXML private PlanningPokerTabController planningPokerTabController; 
	
	
	@FXML private void initialize(){ 
		effortLoggerTabController.injectMainController(this);
		
	}
//	public MainController(){
//		
//	}
//	
}
