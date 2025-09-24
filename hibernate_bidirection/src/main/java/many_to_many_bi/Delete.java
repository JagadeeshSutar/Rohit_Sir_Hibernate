package many_to_many_bi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
//		
//		Student s = em.find(Student.class, 1);
//		
//		et.begin();
//		em.remove(s);
//		et.commit();
//		
		Subject s = em.find(Subject.class, 106);
		List<Student> students = s.getStudents();
		
		System.out.println(students);
		et.begin();
		for(Student student : students) {
			student.getSubjects().remove(s);
			em.merge(student);
		}
		
		em.remove(s);
		et.commit();
	}
}
