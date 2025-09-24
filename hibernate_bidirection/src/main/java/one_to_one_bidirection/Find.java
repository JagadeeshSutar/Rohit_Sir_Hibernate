package one_to_one_bidirection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Car car = em.find(Car.class, 1);
		System.out.println(car);
		
		System.out.println(car.getEngine());
		
		Engine engine = em.find(Engine.class, 1);
		System.out.println(engine.getCar());
	}
}
