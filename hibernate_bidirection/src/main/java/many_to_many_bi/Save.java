package many_to_many_bi;

import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Create Students
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Rohit");

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Rakshit");

        // Create Subjects
        Subject sub1 = new Subject();
        sub1.setId(101);
        sub1.setName("Java");

        Subject sub2 = new Subject();
        sub2.setId(102);
        sub2.setName("Python");

        Subject sub3 = new Subject();
        sub3.setId(103);
        sub3.setName("C++");

        Subject sub4 = new Subject();
        sub4.setId(104);
        sub4.setName("HTML");

        Subject sub5 = new Subject();
        sub5.setId(105);
        sub5.setName("CSS");

        Subject sub6 = new Subject();
        sub6.setId(106);
        sub6.setName("JavaScript");

        // Assign students to subjects
        sub1.setStudents(Arrays.asList(s1));
        sub2.setStudents(Arrays.asList(s1));
        sub3.setStudents(Arrays.asList(s1));

        sub4.setStudents(Arrays.asList(s2));
        sub5.setStudents(Arrays.asList(s2));
        sub6.setStudents(Arrays.asList(s2));

        // Assign subjects to students
        s1.setSubjects(Arrays.asList(sub1, sub2, sub3));
        s2.setSubjects(Arrays.asList(sub4, sub5, sub6));

        // Save
        et.begin();
        em.persist(s1);
        em.persist(s2);
        em.persist(sub1);
        em.persist(sub2);
        em.persist(sub3);
        em.persist(sub4);
        em.persist(sub5);
        em.persist(sub6);
        et.commit();

        em.close();
        emf.close();
    }
}
