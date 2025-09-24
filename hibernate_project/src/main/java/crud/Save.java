package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Student s = new Student();
		s.setId(2);
		s.setNamee("Ramesh");
		s.setAge(23);
		
		et.begin();
		em.persist(s);
		et.commit();
	}
}
