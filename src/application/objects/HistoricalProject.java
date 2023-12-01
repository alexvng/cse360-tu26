/*
 * AUTHOR: Cameron Bickley
 * EMAIL: cpbickle@gmail.com
 * COURSE & TEAM: CSE360, Tu26
 * DESCRIPTION: HistoricalProject class is an extension class of Project
 * 				intended for specialized use during planning poker.
 */

package application.objects;

public class HistoricalProject extends Project{
	
	private double weight;
	
	//constructor:
	public HistoricalProject() {
		super();
		this.weight = -1;
	}
	
	//GETTERS:
	
	public double getWeight() {
		return this.weight;
	}
	
	//SETTERS:
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

}
