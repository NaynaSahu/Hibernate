package Association;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestEmployee {
	public static void main(String[] args) {
		testAddress();

	}

	private static void testAddress() {

		/*
		 * Employee emp = new Employee();
		 * 
		 * emp.setName("Nayna");
		 * 
		 * Address address = new Address();
		 * 
		 * address.setCity("Indore"); address.setState("MP");
		 */
		Employee emp1 = new Employee();

		emp1.setName("Abhay");

		Address address1 = new Address();

		address1.setCity("Indore");
		address1.setState("MP");

		emp1.setAddress(address1);
		address1.setEmployee(emp1);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(emp1);
		s.save(address1);

		tx.commit();
		s.close();

	}

}
