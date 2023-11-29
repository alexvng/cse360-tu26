package application.objects;

public class Project {
	String userStories[] = new String[3];
	String keyWords[] = new String[3];
	double weight;
	
	public String[] getUserStories() {
		return this.userStories;
	}
	
	public String[] getKeyWords() {
		return this.keyWords;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void setWeight(double weightSet) {
		weight = weightSet;
	}
	
	public void addUserStories(String story) {		
		for(int i=0;i<userStories.length;i++) {
			if(userStories[i] != null) {
				continue;
			}else{
				userStories[i] = story;
				break;
			}
		}
	}

	public void addKeyWords(String keywords){
		for(int i=0;i<keyWords.length;i++) {
			if(keyWords[i] != null) {
				continue;
			}else {
				keyWords[i] = keywords;
				break;
			}
		}
		
		
	}
	

}
