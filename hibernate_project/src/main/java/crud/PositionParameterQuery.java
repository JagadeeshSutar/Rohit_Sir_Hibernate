package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PositionParameterQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Student s where s.name = ?1 AND s.age>= ?2");
		query.setParameter(1,"Jagadeesh");
		query.setParameter(2, 23);
		
		List<Student> list = query.getResultList();
		System.out.println(list);
	}
}
