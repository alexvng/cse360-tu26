package application.objects;

import java.util.ArrayList;
import java.util.List;

public class EffortLogList {
	private List<EffortLog> effortLogList = new ArrayList<>();
	
	public void addLog(EffortLog log) {
		effortLogList.add(log);
	}

	public List<EffortLog> getEffortLogList() {
		return this.effortLogList;
	}
	
}
