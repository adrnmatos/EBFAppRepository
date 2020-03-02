package br.home.adrnmatos;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ClientTest {
	
	private static SessionFactory sessionFactory;
	
	@BeforeAll
	public static void setUp() {
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
			e.printStackTrace();
		}
		
	}
	
	
	  
	  @Test public void client_noPlan_isInative() {
	  
	  Client c = new Client();
	  
	  assertFalse(c.isActive()); }
	  
	  
	  @Test public void client_activePlan_isActive() {
	  
	  Client c = new Client();
	  
	  Plano p = new Plano();
	  
	  c.assignPlan(p);
	  
	  assertTrue(c.isActive()); }
	  
	  
	  @Test public void client_inactivePlan_isInative() {
	  
	  Client c = new Client();
	  
	  Plano p = new Plano();
	  
	  c.assignPlan(p);
	  
	  LocalDate yDay = LocalDate.parse("2019-08-19");
	  
	  p.setDueDate(yDay);
	  
	  assertFalse(c.isActive()); }
	  
	  
	  @Test public void
	  client_activeScheduledRestritePlan_whenBetweenHours_isGrantedAccess() {
	  
	  Client c = new Client();
	  
	  Plano p = new Plano();
	  
	  p.setAccessInterval(p.new Interval(LocalTime.of(10,0), LocalTime.of(15,0)));
	  p.setAccessInterval(p.new Interval(LocalTime.of(21,0), LocalTime.of(23,0)));
	  
	  c.assignPlan(p);
	  
	  assertTrue(Access.isGrantedAccess(c)); }
	  
	  
	  @Test public void client_inactive_isNotGrantedAccess() {
	  
	  Client c = new Client();
	  
	  assertTrue(!Access.isGrantedAccess(c)); }
	  
	  
	  @Test public void client_suspendPlan_planIsInactive() {
	  
	  Client c = new Client();
	  
	  Plano p = new Plano();
	  
	  c.assignPlan(p);
	  
	  p.suspendPlan();
	  
	  assertFalse(p.isActive()); }
	  
	 
	
	@Test
	public void client_persist() {
		System.out.println("teste");

		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(new Client("Clara Matos"));
		session.getTransaction().commit();
		session.close();

		session = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery("from Client").list();
		for(Client client : (List<Client>) result) {
			System.out.println(client.getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	
}
