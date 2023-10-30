/*
 * AUTHOR: Cameron Bickley
 * EMAIL: cpbickle@gmail.com
 * COURSE & TEAM: CSE360, Tu26
 * DESCRIPTION: LifeCycleStep class for defining the fields required for a life cycle step in the user's definitions
 * 				Composed into the definitions class
 */

package application;

public class LifeCycleStep {
	
	private String name;
	private int defaultEC = 0;
	private int defaultD = 0;
	
	//SETTERS:
	
	//sets the name of this life cycle step to the input string
	public void setName(String name) {
		this.name = name;
	}
	
	/*sets the default Effort Category of this LSS to the input int
	 *returns true for a valid input Effort Category index 1-5 and a successful set
	 *returns false for an invalid int
	 */
	public boolean setDefaultEC(int defaultEC) {
		if(defaultEC > 0 && defaultEC <= 5) {
			this.defaultEC = defaultEC;
			return true;
		}
		else return false;
	}
	
	/*sets the default Deliverable Category of this LCS to the input int
	 *returns true for a valid Deliverable Category index 1-10 and a successful set
	 *returns false for an invalid int
	 */
	public boolean setDefaultD(int defaultD) {
		if(defaultD > 0 && defaultD <= 10) {
			this.defaultD = defaultD;
			return true;
		}
		else return false;
	}
	
	// GETTERS:
	
	//returns the name of this LCS
	public String getName() {
		return this.name;
	}
	
	/*returns the default effort category of this LCS
	 *returns initial value 0 if no defaultEC has been set
	 */
	public int getDefaultEC() {
		return this.defaultEC;
	}
	
	/*returns the default deliverable category of this LCS
	 *returns initial value 0 if no defaultD has been set
	 */
	public int getDefaultD() {
		return this.defaultD;
	}
	
	// clears the information held in all local variables of this project definition
	public void clear() {
		this.name = null;
		this.defaultEC = 0;
		this.defaultD = 0;
	}
	
}
