package one_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Engine e=new Engine();
		e.setId(2);
		e.setEngineType("V8");
		
		Car c=new Car();
		
		c.setEngine(e);
		
		//COMPOSITION AGGREGATAION DEPENDING DEPENDENT
		
		//CODE FIRST APPROACH
		
		
		et.begin();
		em.persist(e);
		em.persist(c);
		et.commit();
	}

}