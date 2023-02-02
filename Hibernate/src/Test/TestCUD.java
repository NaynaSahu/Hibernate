package Test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestCUD {

	public static void main(String[] args) {
		// TestCreate();
		// TestDelete();
		// TestUpdate();
		TestMerge();

	}

	private static void TestMerge() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Student st = new Student();

		st.setAge(45);
		st.setFname("Ramesh");
		st.setLname("Sharma");
		Transaction tx = s.beginTransaction();

		// s.save(st);

		tx.commit();

		s.close();

		st.setFname("Shreyash");
		st.setAge(23);

		Session s1 = sessionFactory.openSession();

		Transaction tx1 = s1.beginTransaction();

		s1.merge(st);
		tx1.commit();
		s1.close();

	}

	private static void TestUpdate() {
		Student pojo = new Student();
		pojo.setId(3);
		pojo.setAge(17);
		pojo.setFname("Abhay");
		pojo.setLname("Sahu");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Transaction tx = s.beginTransaction();

		s.update(pojo);

		tx.commit();
		s.close();

	}

	private static void TestDelete() {
		Student pojo = new Student();
		pojo.setId(2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Transaction tx = s.beginTransaction();

		s.delete(pojo);

		tx.commit();
		s.close();
	}

	private static void TestCreate() {
		Student pojo = new Student();
		pojo.setAge(12);
		pojo.setFname("Kirti");
		pojo.setLname("Atri");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(pojo);

		tx.commit();
		s.close();

	}

}
