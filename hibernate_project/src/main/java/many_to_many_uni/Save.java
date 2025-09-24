package many_to_many_uni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		ManyStudent s1 = new ManyStudent();
		s1.setId(1);
		s1.setName("Rocky");
		
		ManyStudent s2 = new ManyStudent();
		s2.setId(2);
		s2.setName("Rakshit");
		
		
		ManySubject sub1 = new ManySubject();
		sub1.setId(101);
		sub1.setName("Java");
		
		ManySubject sub2 = new ManySubject();
		sub2.setId(102);
		sub2.setName("SQL");
		
		ManySubject sub3 = new ManySubject();
		sub3.setId(103);
		sub3.setName("CSS");
		
		ManySubject sub4 = new ManySubject();
		sub4.setId(104);
		sub4.setName("HTML");
		
		ManySubject sub5 = new ManySubject();
		sub5.setId(105);
		sub5.setName("Python");
		
		List<ManySubject> firstManyStudent = new ArrayList<>();
		Collections.addAll(firstManyStudent, sub1, sub2, sub3, sub4);

		List<ManySubject> secondManyStudent = new ArrayList<>();
		Collections.addAll(secondManyStudent, sub1, sub4, sub5);

		s1.setSubjects(firstManyStudent);
		s2.setSubjects(secondManyStudent);
		
		et.begin();
		em.persist(sub1);
		em.persist(sub2);
		em.persist(sub3);
		em.persist(sub4);
		em.persist(sub5);
		em.persist(s1);
		em.persist(s2);
		et.commit();
		
	}
}
