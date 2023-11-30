package application.objects;

import java.util.ArrayList;
import java.util.List;

public class ProjectList {
	private List <Project>projList = new ArrayList<>();

	public void addProj(Project proj) {
		projList.add(proj);
	}

	public List<Project> getProjList() {
		return this.projList;
	}

}
