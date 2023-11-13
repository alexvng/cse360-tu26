/*
 * AUTHOR: Cameron Bickley
 * EMAIL: cpbickle@gmail.com
 * COURSE & TEAM: CSE360, Tu26
 * DESCRIPTION: EffortLog class which holds all info of a single log for the user
 */

package application;

import java.util.Date;

public class EffortLog {

	private Date date;
	private long startTime;
	private long endTime;
	private String lifeCycleStep;
	private String effortCategory;
	private String effortSubcategory;
	
	//constructor:
	public EffortLog(String lifeCycleStep, String effortCategory, String effortSubcategory) {
		this.date = new Date();
		this.startTime = date.getTime();
		this.lifeCycleStep = lifeCycleStep;
		this.effortCategory = effortCategory;
		this.effortSubcategory = effortSubcategory;
	}
	
	//SETTERS
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	
	public void setLifeCycleStep(String lifeCycleStep) {
		this.lifeCycleStep = lifeCycleStep;
	}
	
	public void setEffortCategory(String effortCategory) {
		this.effortCategory = effortCategory;
	}
	
	public void setEffortSubcategory(String effortSubcategory) {
		this.effortSubcategory = effortSubcategory;
	}
	
	//GETTERS
	
	public Date getDate() {
		return this.date;
	}
	
	public long getStartTime() {
		return this.startTime;
	}
	
	public long getEndTime() {
		return this.endTime;
	}
	
	public String getLifeCycleStep() {
		return this.lifeCycleStep;
	}
	
	public String getEffortCategory() {
		return this.effortCategory;
	}
	
	public String getEffortSubcategory() {
		return this.effortSubcategory;
	}
	
	//METHODS
	
	public long getDeltaTime() {
		return this.endTime - this.startTime;
	}
	
}
