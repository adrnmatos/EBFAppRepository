package br.home.adrnmatos;

import java.time.LocalTime;

public class Access {

	public static boolean isGrantedAccess(Client c) {
		
		if(c.getActivePlan().getIntervals().isEmpty())
			return true;
		else {
			for(Plan.Interval interval : c.getActivePlan().getIntervals()) {
				if(LocalTime.now().isAfter(interval.getIntervalInit()) && LocalTime.now().isBefore(interval.getIntervalEnd()) )
					return true;
			}
		}
		return false;
	}

}
