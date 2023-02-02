package Test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestCreate {
	
	
	public static void main(String[] args) {
		User pojo = new User();
		pojo.setFname("NAYNA1");
		pojo.setLname("SAHU1");
		//pojo.setId(1);
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(pojo);
		
		tx.commit();
		s.close();
		
		
		
		
	}

}
