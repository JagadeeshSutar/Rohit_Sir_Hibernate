package many_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchData {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Review r = em.find(Review.class, 102);
		System.out.println(r);

		System.out.println(r.getProduct());
	}
}
