package Test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

public class testCache {
	public static void main(String[] args) {
		 testSearch1();
		//testSecLevel();
	}

	private static void testSecLevel() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Student st = (Student) s.get(Student.class, 1);
		System.out.println(st.getAge());
		System.out.println(st.getFname());

		s.close();

		Session s1 = sessionFactory.openSession();
		Student st1 = (Student) s1.get(Student.class, 2);
		System.out.println(st1.getAge());
		System.out.println(st1.getFname());

		s1.close();

	}

	private static void testSearch() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Student st = (Student) s.get(Student.class, 1);
		System.out.println(st.getAge());
		System.out.println(st.getFname());
		
		


		Student st1 = (Student) s.get(Student.class, 1);
		System.out.println(st1.getAge());
		System.out.println(st1.getFname());
	}




	private static void testSearch1() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Query q = s.createQuery("from Student st where st.id = 1").setCacheable(true);
		/*
		 * Criteria crit = s.createCriteria(Student.class);
		 * 
		 * crit.add(Restrictions.like("fname", "%a"));
		 */
		
		

		List list = q.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Student st = (Student) it.next();
			System.out.println(st.getAge());
			System.out.println(st.getFname());
			System.out.println(st.getLname());
		}

	
	//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	//Session s1 = sessionFactory.openSession();
		//Query q1 = s.createQuery("from Student where fname like '%a'");
		//crit.add(Restrictions.like("fname", "%a"));
		List list1 = q.list();
		Iterator it1 = list1.iterator();
		Student st1;
		while (it1.hasNext()) {
			 st1 = (Student) it1.next();
			System.out.println(st1.getAge());
			System.out.println(st1.getFname());
			System.out.println(st1.getLname());

		}
		
	}

}