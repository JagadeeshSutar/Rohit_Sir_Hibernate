package many_to_many_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		int subId = 101;

		Query query = em.createQuery("SELECT s FROM ManyStudent s JOIN s.subjects sub WHERE sub.id = :subjectId");
		query.setParameter("subjectId", subId);

		List<ManyStudent> students = query.getResultList();
		for (ManyStudent s : students) {
			System.out.println(s);
		}

	}
}
