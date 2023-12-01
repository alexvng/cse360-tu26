package application;
import application.GlobalObjects;
import application.objects.Project;

public class ProjectsInitialize {	
	
	
	public static void initializeGlobal() {		
		//Sets all Project Names
		GlobalObjects.proj1.setName("proj1");
		GlobalObjects.proj2.setName("proj2");
		GlobalObjects.proj3.setName("proj3");
		GlobalObjects.proj4.setName("proj4");
		GlobalObjects.proj5.setName("proj5");
		GlobalObjects.proj6.setName("proj6");
		GlobalObjects.proj7.setName("proj7");
		GlobalObjects.projList.addProj(GlobalObjects.proj1);
		GlobalObjects.projList.addProj(GlobalObjects.proj2);
		GlobalObjects.projList.addProj(GlobalObjects.proj3);
		GlobalObjects.projList.addProj(GlobalObjects.proj4);
		GlobalObjects.projList.addProj(GlobalObjects.proj5);
		GlobalObjects.projList.addProj(GlobalObjects.proj6);
		GlobalObjects.projList.addProj(GlobalObjects.proj7);
		
		GlobalObjects.effortLogList.addLog(GlobalObjects.effort1);
		GlobalObjects.effortLogList.addLog(GlobalObjects.effort2);
		GlobalObjects.effortLogList.addLog(GlobalObjects.effort3);
		GlobalObjects.effortLogList.addLog(GlobalObjects.effort4);
		GlobalObjects.effortLogList.addLog(GlobalObjects.effort5);
		GlobalObjects.effortLogList.addLog(GlobalObjects.effort6);

		
		//Proj 1
		GlobalObjects.proj1.addKeyWords("keyword1");
		GlobalObjects.proj1.addKeyWords("keyword2");
		GlobalObjects.proj1.addKeyWords("keyword3");
		GlobalObjects.proj1.addUserStories("As a carpenter, I want money so that I spend");
		GlobalObjects.proj1.addUserStories("As a robot, I want weapon so that I can harm");
		GlobalObjects.proj1.addEffortLog(GlobalObjects.effort1);
		GlobalObjects.proj1.addEffortLog(GlobalObjects.effort6);
	}


}
