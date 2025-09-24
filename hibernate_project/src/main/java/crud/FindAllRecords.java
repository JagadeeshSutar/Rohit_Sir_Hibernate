package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAllRecords {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		
		Query query = em.createQuery("select s from Student s");
		List<Student> students = query.getResultList();
		System.out.println(students);
		
	}
}
