package application.controllers;


public class EditorTabController {
	
@FXML private ChoiceBox <String> projectsBox; 
	@FXML private ChoiceBox <String> EffortLogBox; 
	@FXML private ChoiceBox <String> LifeCycleStepsBox; 
	@FXML private ChoiceBox <String> EffortCategoryBox; 
	@FXML private ChoiceBox <String> PlanBox; 
	
	
	List<String> names = new ArrayList<String>();
	List<String> logs = new ArrayList<String>();
	
	public void initialize(URL url, ReourceBundle rb) { 
		
		for(EffortLog log: GlobalObjects.effortLogList.getEffortLogList()) {
			logs.add(log.getName());
			System.out.println(log.getName());
		}
		
		for(Project proj: GlobalObjects.projList.getProjList()) {
			names.add(proj.getName());
		}
		
		
		projectsBox.getItems().addAll(names);
		effortLogBox.getItems().addAll(logs);
		lifeCycleStepsBox.getItems().addAll(GlobalObjects.cycleSteps);
		effortCategoryBox.getItems().addAll(GlobalObjects.effortCategory);
		
	}

}
