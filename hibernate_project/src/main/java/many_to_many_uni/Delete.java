package many_to_many_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

//		ManyStudent s = em.find(ManyStudent.class, 3);
//		et.begin();
//		em.remove(s);
//		et.commit();

		// deleting subject assigned to student with Id 3 after deleting student

//		ManySubject sub = em.find(ManySubject.class, 101);
//		et.begin();
//		em.refresh(sub);
//		et.commit();

		// deleting a subject which is refernced to a student
		ManySubject sub = em.find(ManySubject.class, 101);

		Query query = em.createQuery("select s from ManyStudent s JOIN s.subjects sub where sub = :subject");
		query.setParameter("subject", sub);

		List<ManyStudent> students = query.getResultList();

		et.begin();

		for (ManyStudent s : students) {
			s.getSubjects().remove(sub);
			em.merge(s);
		}

		em.remove(sub);
		et.commit();

	}
}
