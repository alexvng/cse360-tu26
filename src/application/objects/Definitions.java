/*
 * AUTHOR: Cameron Bickley
 * EMAIL: cpbickle@gmail.com
 * COURSE & TEAM: CSE360, Tu26
 * DESCRIPTION: Definitions class for EffortLogger V2 proj.
 * 				container for all data needed to implement defintions window
 */

package application.objects;

public class Definitions {
	
	private final int NUM_PROJECT_DEFINITIONS = 10;
	private final int NUM_LIFE_CYCLE_STEPS = 50;
	private final int NUM_EFFORT_CATEGORIES = 5;
	private final int NUM_PLANS = 10;
	private final int NUM_DELIVERABLES = 10;
	private final int NUM_INTERRUPTIONS = 10;
	private final int NUM_DEFECT_CATEGORIES = 15;
	
	private Project[] userProjectDefinitions;
	private LifeCycleStep[] userLifeCycleSteps;
	private String[] userEffortCategories;
	private String[] userPlans;
	private String[] userDeliverables;
	private String[] userInterruptions;
	private String[] userDefectCategories;
			
	//constructor for this effort logger instance's definitions	
	public Definitions() {
		userProjectDefinitions = new Project[NUM_PROJECT_DEFINITIONS];
		userLifeCycleSteps = new LifeCycleStep[NUM_LIFE_CYCLE_STEPS];
		userEffortCategories = new String[NUM_EFFORT_CATEGORIES];
		userPlans = new String[NUM_PLANS];
		userDeliverables = new String[NUM_DELIVERABLES];
		userInterruptions = new String[NUM_INTERRUPTIONS];
		userDefectCategories = new String[NUM_DEFECT_CATEGORIES];
		
		for(int i = 0; i < NUM_PROJECT_DEFINITIONS; i++) userProjectDefinitions[i] = new Project();
		for(int i = 0; i < NUM_LIFE_CYCLE_STEPS; i++) userLifeCycleSteps[i] = new LifeCycleStep();
		
		setDefaultDefinitions();
	}
	
	/*clears all user created definitions and inputs the default definitions
	 *the default definitions are specified as the same defaults as the original EffortLogger
	 */
	public void setDefaultDefinitions() {
		
		//clearing any current definitions
		/*
		for(int i = 0; i < NUM_PROJECT_DEFINITIONS; i++) this.userProjectDefinitions[i].clear();
		for(int i = 0; i < NUM_LIFE_CYCLE_STEPS; i++) this.userLifeCycleSteps[i].clear();
		Arrays.fill(userEffortCategories, null);
		Arrays.fill(userPlans, null);
		Arrays.fill(userDeliverables, null);
		Arrays.fill(userInterruptions, null);
		Arrays.fill(userDefectCategories, null);
		*/
		
		//setting predefined project definition values
		if(NUM_PROJECT_DEFINITIONS > 0) this.userProjectDefinitions[0].setName("Business Project");
		for(int i = 0; i < 10; i++) {
			if(i < NUM_PROJECT_DEFINITIONS) this.userProjectDefinitions[0].setLifeCycleStep(i, i + 17);
		}
		if(NUM_PROJECT_DEFINITIONS > 1) this.userProjectDefinitions[1].setName("Development Project");
		for(int i = 0; i < 16; i++) {
			if(i < NUM_PROJECT_DEFINITIONS) this.userProjectDefinitions[1].setLifeCycleStep(i, i + 1);
		}
		
		//defining all the default definitions from EffortLogger V1 and setting the first user definitions to them
		final String[] LIFE_CYCLE_STEPS = new String[]
			{"Problem Understanding", "Conceptual Design Plan", "Requirements", "Conceptual Design", "Conceptual Design Review",
			"Detailed Design Plan", "Detailed Design/Prototype", "Detailed Design Review", "Implementation Plan", "Test Case Generation",
			"Solution Specification", "Solution Review", "Solution Implementation", "Unit/System Test", "Reflection",
			"Repository Update", "Planning", "Information Gathering", "Information Understanding", "Verifying",
			"Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting",
			"Stakeholder Meeting"};
		final int[] DEFAULT_EC = new int[]
			{2, 1, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2};
		final int[] DEFAULT_D = new int[]
			{1, 3, 1, 1, 1, 4, 2, 2, 5, 3, 4, 4, 4, 4, 4, 4, 1, 1, 1, 1, 6, 7, 8, 1, 1, 1};
		for(int i = 0; i < LIFE_CYCLE_STEPS.length; i++) {
			if(i < NUM_LIFE_CYCLE_STEPS) {
				this.userLifeCycleSteps[i].setName(LIFE_CYCLE_STEPS[i]);
				this.userLifeCycleSteps[i].setDefaultEC(DEFAULT_EC[i]);
				this.userLifeCycleSteps[i].setDefaultD(DEFAULT_D[i]);
			}
		}
		
		final String[] EFFORT_CATEGORIES = new String[]
			{"Plans", "Deliverables", "Interruptions", "Defects", "Others"};
		for(int i = 0; i < EFFORT_CATEGORIES.length; i++) {
			if(i < NUM_EFFORT_CATEGORIES) this.userEffortCategories[i] = EFFORT_CATEGORIES[i];
		}
		
		final String[] PLANS = new String[]
			{"Project Plan", "Risk Management Plan", "Conceptual Design Plan", "Detailed Design Plan", "Implementation Plan"};
		for(int i = 0; i < PLANS.length; i++) {
			if(i < NUM_PLANS) this.userPlans[i] = PLANS[i];
		}
		
		final String[] DELIVERABLES = new String[]
			{"Conceptual Design", "Detailed Design", "Test Cases", "Solution", "Reflection",
			"Outline", "Draft", "Report", "User Defined", "Other"};
		for(int i = 0; i < DELIVERABLES.length; i++) {
			if(i < NUM_DELIVERABLES) this.userDeliverables[i] = DELIVERABLES[i];
		}
		
		final String[] INTERRUPTIONS = new String[]
			{"Break", "Phone", "Teammate", "Visitor", "Other"};
		for(int i = 0; i < INTERRUPTIONS.length; i++) {
			if(i < NUM_INTERRUPTIONS) this.userInterruptions[i] = INTERRUPTIONS[i];
		}
		
		final String[] DEFECT_CATEGORIES = new String[]
			{"Not specified", "10 Documentation", "20 Syntax", "30 Build, Package", "40 Assignment",
			"50 Interface", "60 Checking", "70 Data", "80 Function", "90 System",
			"100 Environment"};
		for(int i = 0; i < DEFECT_CATEGORIES.length; i++) {
			if(i < NUM_DEFECT_CATEGORIES) this.userDefectCategories[i] = DEFECT_CATEGORIES[i];
		}
		
	}

	// SETTERS: 
	
	/* Takes an int index and string, and sets the user effort category at that index to the new string
	 * Returns true if the index was in bounds and the set occurred successfully
	 * Returns false for an OOB index.
	 */
	public boolean setEffortCategory(int index, String effortCategory) {
		if(index >= 0 && index < NUM_EFFORT_CATEGORIES) {
			this.userEffortCategories[index] = effortCategory;
			return true;
		}
		return false;
	}
	
	/* Takes an int index and string, and sets the user plan at that index to the new string
	 * Returns true if the index was in bounds and the set occurred successfully
	 * Returns false for an OOB index.
	 */
	public boolean setPlan(int index, String plan) {
		if(index >= 0 && index < NUM_PLANS) {
			this.userPlans[index] = plan;
			return true;
		}
		return false;
	}
	
	/* Takes an int index and string, and sets the user deliverable at that index to the new string
	 * Returns true if the index was in bounds and the set occurred successfully
	 * Returns false for an OOB index.
	 * RETURNS FALSE for index 9 or 10, EVEN IF not OOB, since these indices are reserved for the special definitions "User Defined" and "Other".
	 */
	public boolean setDeliverable(int index, String deliverable) {
		if(index == 8 || index == 9) return false; //reserved indices
		if(index >= 0 && index < NUM_DELIVERABLES) {
			this.userDeliverables[index] = deliverable;
			return true;
		}
		return false;
	}

	/* Takes an int index and string, and sets the user interruption at that index to the new string
	 * Returns true if the index was in bounds and the set occurred successfully
	 * Returns false for an OOB index.
	 */
	public boolean setInterruption(int index, String interruption) {
		if(index >= 0 && index < NUM_INTERRUPTIONS) {
			this.userInterruptions[index] = interruption;
			return true;
		}
		return false;
	}
	
	/* Takes an int index and string, and sets the user defect category at that index to the new string
	 * Returns true if the index was in bounds and the set occurred successfully
	 * Returns false for an OOB index.
	 */
	public boolean setDefectCategory(int index, String defectCategory) {
		if(index >= 0 && index < NUM_DEFECT_CATEGORIES) {
			this.userDefectCategories[index] = defectCategory;
			return true;
		}
		return false;
	}

	//	GETTERS:

	public Project[] getProjectDefinitions() {
		return this.userProjectDefinitions;
	}
	
	public LifeCycleStep[] getLifeCycleSteps() {
		return this.userLifeCycleSteps;
	}
	
	public String[] getEffortCategories() {
		return this.userEffortCategories;
	}
	
	public String[] getPlans() {
		return this.userPlans;
	}
	
	public String[] getDeliverables() {
		return this.userDeliverables;
	}
	
	public String[] getInterruptions() {
		return this.userInterruptions;
	}
	
	public String[] getDefectCategories() {
		return this.userDefectCategories;
	}
	
}
