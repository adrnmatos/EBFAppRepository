package br.home.adrnmatos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Plan {
	
	private LocalDate dueDate;
	private List<Interval> intervalList = new ArrayList<Interval>();
	
	public Plan() {
		this.dueDate = LocalDate.now();
	}
	
	public boolean isActive() {
		
		Period period = Period.between(LocalDate.now(), dueDate);
		if(period.getDays() < 0)
			return false;
		return true;
	}

	public void setDueDate(LocalDate date) {
		this.dueDate = date;
	}
	
	public void setAccessInterval(Interval interval) {
		this.intervalList.add(interval);
	}
	
	public List<Interval> getIntervals() {
		return intervalList;
	}
	
	public class Interval {
		
		private LocalTime intervalInit;
		private LocalTime intervalEnd;
		
		public Interval(LocalTime init, LocalTime end) {
			this.intervalInit = init;
			this.intervalEnd = end;
		}

		public LocalTime getIntervalInit() {
			return this.intervalInit;
		}

		public LocalTime getIntervalEnd() {
			return this.intervalEnd;
		}
		
	}	
	
}
