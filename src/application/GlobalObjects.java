package application;

import application.objects.EffortLog;
import application.objects.EffortLogList;
import application.objects.Project;
import application.objects.ProjectList;

public class GlobalObjects {
	public static Project proj1 = new Project();
	public static Project proj2 = new Project();
	public static Project proj3 = new Project();
	public static Project proj4 = new Project();
	public static Project proj5 = new Project();
	public static Project proj6 = new Project();
	public static Project proj7 = new Project();
	public static ProjectList projList = new ProjectList();
	
	//Creating effort logs with 
	public static EffortLog effort1 = new EffortLog("Problem Understanding", "Plans", "ProjectPlan", 10);
	public static EffortLog effort2 = new EffortLog("Conceptual Design Plan", "Deliverables", "Conceptual Design", 3);
	public static EffortLog effort3 = new EffortLog("Implementation Plan", "Defects", "Documentation", 5);
	public static EffortLog effort4 = new EffortLog("Solution Review", "Deliverables", "Implementation Plan", 2);
	public static EffortLog effort5 = new EffortLog("Unit/System Test", "Interruptions", "ProjectPlan", 4);
	public static EffortLog effort6 = new EffortLog("Repository Update", "Other", "Refactor", 1);
	public static EffortLogList effortLogList = new EffortLogList();
	
	//Different Options for EffortLog
	public static String[] cycleSteps = {"Problem Understanding", "Conceptual Design Plan", "Requirements", "Conceptual Design", "Conceptual Design Review", "Detailed Design Plan",
			"Implementation Plan", "Test Case Generation", "Solution Specification", "Solution Review", "Solution Implementation", "Unit/System Test" ,"Reflection", "Repository Update",
			"Planning", "Information Gathering", "Information Understanding", "Verifying", "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting"};
	public static String[] effortCategory = {"Plans", "Deliverables", "Interruptions", "Defects", "Other"};
	public static String[] plansSubCategory = {"Project Plan", "Risk Management Plan", "Conceptual Design Plan", "Detailed Design Plan", "Implementation Plan"};
	public static String[] deliverablesSubCategory = {"Conceptual Design", "Detailed Design", "Test Cases", "Solution", "Reflection", "Outline", "Draft", "Report", "User Defined", "Other"};
	public static String[] interuptionsSubCategory = {"Break", "Phone", "Teamate", "Visitor", "Other"};
	public static String[] defectSubCategory = {"Not Specified", "Documentation", "Syntax", "Build", "Package", "Assignment", "Interface", "Checking", "Data", "Function", "System", "Environment"};
	public static String[] othersSubCategory = {"Refactor"};
}
