package br.home.adrnmatos;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	private List<Plan> planList = new ArrayList<Plan>();
	
	public boolean isActive() {
		if(planList.isEmpty())
			return false;
		else {
			for(Plan p : planList) {
				if(p.isActive())
					return true;
			}
			return false;
		}
	}

	public void assignPlan(Plan p) {
		this.planList.add(p);
		
	}

}
