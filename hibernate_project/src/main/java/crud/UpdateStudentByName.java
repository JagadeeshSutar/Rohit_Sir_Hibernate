package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateStudentByName {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		Query query = em.createQuery("select s from Student s where s.name = ?1");
		query.setParameter(1, "Jagadeesh");
		Student students = (Student) query.getSingleResult();
		System.out.println(students);
		
		students.setAge(29);
		
		et.begin();
		em.merge(students);
		et.commit();
	}
}
