/*
 * AUTHOR: Cameron Bickley
 * EMAIL: cpbickle@gmail.com
 * COURSE & TEAM: CSE360, Tu26
 * DESCRIPTION: ProjectDefinition class for defining all attributes of a user-designed project
 *              needed for implementing the fxnality required in EffortLogger V2.
 *              Aggregated into the Definitions class.
 */

package application;

import java.util.ArrayList;
import java.util.Arrays;

public class Project {
	
	private String userRank;
	private String projectName;
	private int[] lifeCycleSteps;
	private String UserStory;
	private ArrayList<String> keywords;
	
	//constructor:
	public Project() {
		this.lifeCycleSteps = new int[25];
	}

	// SETTERS:

	//takes string and sets that string as the user rank
	public void setUserRank(String userRank) {
		this.userRank = userRank;
	}
	
	// takes a string and sets the name of the project
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/* takes an int index and integer input and sets the life cycle step at that index to the input integer
	 * returns true if the life cycle step is successfully set
	 * returns false if the index is OOB (<0 or >=25) and the set doesnt occur
	 */
	public boolean setLifeCycleStep(int index, int lifeCycleStep) {
		if(index >= 0 && index < 25) {
			this.lifeCycleSteps[index] = lifeCycleStep;
			return true;
		}
		else return false;
	}

	// takes an input string and sets the user story of this project
	public void setUserStory(String UserStory) {
		this.UserStory = UserStory;
	}

	/* takes a string and adds it to the keywords for this project, returns true for
	 * a successful addition
	 * if the string is already in the keywords, returns false
	 */
	public boolean addKeyword(String keyword) {
		if (this.keywords.indexOf(keyword) == -1) {
			this.keywords.add(keyword);
			return true;
		} else
			return false;
	}

	/* takes a string and removes if from the keywords, given it is in the keyword
	 * arraylist, returns true for a successful removal
	 * if the string isnt in the list, does nothing and returns false
	 */
	public boolean removeKeyword(String keyword) {
		return this.keywords.remove(keyword);
	}

	// GETTERS:
	
	/* returns the user rank associated with this project
	 * returns null string if no user rank is set
	 */
	public String getUserRank() {
		return this.userRank;
	}

	/* returns the project name
	 * returns a null string if no project name has been set
	 */
	public String getProjectName() {
		return this.projectName;
	}

	/* takes an int index and returns the life cycle step at that index
	 * if no cycle step has preiously been set, returns 0 (default value)
	 */
	public int getLifeCycleStep(int index) {
		return this.lifeCycleSteps[index];
	}

	/* returns the user story of this project
	 * returns a null value if no user story has been set
	 */
	public String getUserStory() {
		return this.UserStory;
	}

	/*
	 *  returns the arraylist of keywords for this project
	 *  returns null value if no keywords have been added
	 */
	public ArrayList<String> getKeywords() {
		return this.keywords;
	}

	// METHODS:

	/* takes an input string and returns a boolean indicating whether that string is
	 * a keyword for this project
	 * implemented for Planning Poker functionality
	 */
	public boolean isKeyword(String keyword) {
		if (this.keywords.indexOf(keyword) != -1) {
			return true;
		} else
			return false;
	}
	
	// clears the information held in all local variables of this project definition
	public void clear() {
		this.projectName = null;
		Arrays.fill(this.lifeCycleSteps, 0);
		this.UserStory = null;
		this.keywords.clear();
	}

}
