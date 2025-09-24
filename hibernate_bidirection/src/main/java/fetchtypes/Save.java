package fetchtypes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Product p = new Product();
		p.setId(1);
		p.setName("Puma");
		
		Review r = new Review();
		r.setId(102);
		r.setFeedback("Good product");
		
		p.setReview(r);
		
		et.begin();
		em.persist(r);
		em.persist(p);
		et.commit();
		
		
		
	}
}
