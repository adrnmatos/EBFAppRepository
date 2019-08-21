package br.home.adrnmatos;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ClientTest {

	@Test
	public void client_noPlan_isInative() {
		
		Client c = new Client();
				
		assertFalse(c.isActive());
	}
	
	
	@Test
	public void client_activePlan_isActive() {
		
		Client c = new Client();
		
		Plan p = new Plan();
		
		c.assignPlan(p);
		
		assertTrue(c.isActive());
	}
	
	
	@Test
	public void client_inactivePlan_isInative() {
		
		Client c = new Client();
		
		Plan p = new Plan();
		
		c.assignPlan(p);
		
		LocalDate yDay = LocalDate.parse("2019-08-19");
		
		p.setDueDate(yDay);
		
		assertFalse(c.isActive());
	}
	
	@Test
	public void client_activeScheduledRestritePlan_whenBetweenHours_isGrantedAccess() {
		
		Client c = new Client();
		
		Plan p = new Plan();
					
		p.setAccessInterval(p.new Interval(LocalTime.of(10,0), LocalTime.of(15,0)));
		p.setAccessInterval(p.new Interval(LocalTime.of(21,0), LocalTime.of(23,0)));
		
		c.assignPlan(p);
		
		assertTrue(Access.isGrantedAccess(c));
	}

}
