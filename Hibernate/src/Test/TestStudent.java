package Test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

public class TestStudent {
	public static void main(String[] args) {

		// TestSave();
		testAuthentication("Nayna" , "Sahu ");

	}

	private static void testAuthentication(String fname , String lname) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		Criteria crit =  s.createCriteria(Student.class);
		crit.add(Restrictions.eq("fname", fname.trim()));
		crit.add(Restrictions.eq("lname", lname.trim()));
		
		List list = crit.list();
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			Student st = (Student) it.next();
			
			System.out.println(st.getAge());
			System.out.println(st.getFname());
			System.out.println(st.getLname());
			
		}
		if(list.isEmpty()) {
			System.out.println("Authentication failed No data found");
		}
		s.close();
		

	}

	private static void TestSave() {
		Student pojo = new Student();
		pojo.setAge(19);
		pojo.setFname("Nayna");
		pojo.setLname("Sahu");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(pojo);

		tx.commit();
		s.close();

	}

}
