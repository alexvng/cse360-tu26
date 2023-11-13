/*
 * AUTHOR: Cameron Bickley
 * EMAIL: cpbickle@gmail.com
 * COURSE & TEAM: CSE360, Tu26
 * DESCRIPTION: Log class which holds all log info for a single project
 */

package application;

public class Log {
	
	private final int NUM_LOGS = 1000;
	private int CURR_NUM_EFFORT_LOGS;
	private int CURR_NUM_DEFECT_LOGS;
	private Project project;
	private EffortLog[] efforts;
	private DefectLog[] defects;
	
	//constructor
	public Log() {
		CURR_NUM_EFFORT_LOGS = 0;
		CURR_NUM_DEFECT_LOGS = 0;
		this.project = new Project();
		this.efforts = new EffortLog[NUM_LOGS];
		this.defects = new DefectLog[NUM_LOGS];
	}
	
	//SETTERS:
	
	public void addEffortLog(EffortLog effort) {
		if(CURR_NUM_EFFORT_LOGS < NUM_LOGS) {
			int index = CURR_NUM_EFFORT_LOGS;
			this.efforts[index] = effort;
			CURR_NUM_EFFORT_LOGS++;
		}
	}
	
	public void addDefectLog(DefectLog defect) {
		if(CURR_NUM_EFFORT_LOGS < NUM_LOGS) {
			int index = CURR_NUM_EFFORT_LOGS;
			this.defects[index] = defect;
			CURR_NUM_EFFORT_LOGS++;
		}
	}
	
	//GETTERS:
	
	public Project getProject() {
		return this.project;
	}
	
	public EffortLog getEffortLog(int index) {
		if(index >= 0 && index < CURR_NUM_EFFORT_LOGS) {
			return this.efforts[index];
		}
		else return null;
	}
	
	public DefectLog getDefectLog(int index) {
		if(index >= 0 && index < CURR_NUM_DEFECT_LOGS) {
			return this.defects[index];
		}
		else return null;
	}
	
	public int getNumEffortLogs() {
		return CURR_NUM_EFFORT_LOGS;
	}
	
	public int getNumDefectLogs() {
		return CURR_NUM_EFFORT_LOGS;
	}
	
}
