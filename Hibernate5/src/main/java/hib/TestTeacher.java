package hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestTeacher {
	
	public static void main(String[] args) {
		
		save();
		//delete();
		
		
		
	}

	private static void delete() {
		Teacher teacher = new Teacher();
		
		teacher.setId(1);
		
		SessionFactory sessionFactory = HibUtil.getSessionFactory();
		
		Session s = sessionFactory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.delete(teacher);
		
		tx.commit();
		
		s.close();
		
	}

	private static void save() {
		Teacher user = new Teacher();
		user.setFname("NAYNA");
		
		SessionFactory sessionFactory = HibUtil.getSessionFactory();
		Session s = sessionFactory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(user);
		
		
		tx.commit();
		s.close();
		
		HibUtil.shutdown();
		
	}

}
