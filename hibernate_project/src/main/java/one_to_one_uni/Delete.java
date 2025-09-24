package one_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine e = em.find(Engine.class, 2);
		Query query = em.createQuery("select c from Car c JOIN c.engine e where e = ?1");
		query.setParameter(1, e);
		Car c = (Car)query.getSingleResult();
		c.setEngine(null);
		
		et.begin();
		em.merge(c);
		em.remove(e);
		et.commit();
	}
}
