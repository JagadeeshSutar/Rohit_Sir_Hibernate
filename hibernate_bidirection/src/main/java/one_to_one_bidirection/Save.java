package one_to_one_bidirection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car = new Car();
		car.setId(1);
		car.setName("BMW");
		
		Engine engine = new Engine();
		car.setEngine(engine);
		engine.setCar(car);
		engine.setId(1);
		engine.setEngineType("V6");
		
		et.begin();
		em.persist(car);
		em.persist(engine);
		et.commit();
		
	}
}
