/*
 * AUTHOR: Cameron Bickley
 * EMAIL: cpbickle@gmail.com
 * COURSE & TEAM: CSE360, Tu26
 * DESCRIPTION: DefectLog class which holds all info for a sing defect log from the user
 */

package application;

public class DefectLog {

	private String name;
	private String details;
	private long timeInjected;
	private long timeRemoved;
	private String defectCategory;
	private String status;
	private boolean fixed;
	
	//SETTERS:
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
	
	public void setTimeInjected(long timeInjected) {
		this.timeInjected = timeInjected;
	}
	
	public void setTimeRemoved(long timeRemoved) {
		this.timeRemoved = timeRemoved;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}
	
	//GETTERS:
	
	public String getName(){
		return this.name;
	}
	
	public String getDetails() {
		return this.details;
	}
	
	public long getTimeInjected() {
		return this.timeInjected;
	}
	
	public long getTimeRemoved() {
		return this.timeRemoved;
	}
	
	public String getDefectCategory() {
		return this.defectCategory;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	//METHODS
	
	public boolean isFixed() {
		return this.fixed;
	}
	
}
