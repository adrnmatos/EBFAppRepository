package br.home.adrnmatos;

import static org.junit.jupiter.api.Assertions.*;

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

}
