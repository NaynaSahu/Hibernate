package Test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestSelect {

	public static void main(String[] args) {
		 TestRead();//in read transaction is not required
		// TestList();
		// TestListColumn();
		// TestListMultiColumn();
		// TestConditionalSelect(); // where like
		 TestGroupBy();
		//TestAgregate();

	}

	private static void TestAgregate() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Query q = s.createQuery(" select count(*), AVG(AGE) from Student ");
		
		List list = q.list();
		
		long it = (long) list.get(0);
		int i = (int)list.get(1);
		
		System.out.println(it);
		System.out.println(i);
		
		s.close();
		
	}

	private static void TestGroupBy() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Query q = s.createQuery("select st.age , count(age) ,avg(age) from Student st group by age having age>12");

		List list = q.list();
		
		int i = (int) list.get(2);
		
		//long l = (long)list.get(1);
		Iterator it = list.iterator();

		Object[] ob;
		System.out.println("AGE : COUNT");
		while (it.hasNext()) {
			ob = (Object[]) it.next();

			int age = (int) ob[0];
			
			long count = (long) ob[1];
			
			System.out.print(age + "  : ");
			System.out.print(count);
			System.out.println("");

		}
		System.out.println("average is = "+ i);
		s.close();

	}

	private static void TestConditionalSelect() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Query q = s.createQuery("from Student where fname like '%a'");

		List list = q.list();
		Iterator it = list.iterator();

		Student st;
		while (it.hasNext()) {
			st = (Student) it.next();

			System.out.println(st.getAge());
			System.out.println(st.getFname());
			System.out.println(st.getLname());

		}

	}

	private static void TestListMultiColumn() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Query q = s.createQuery("Select st.fname , st.lname from Student as st");

		List list = q.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			Object[] object = (Object[]) it.next();
			String st = (String) object[0];
			String st1 = (String) object[1];

			System.out.println(st);
			System.out.println(st1);

		}
		s.close();

	}

	private static void TestListColumn() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Query q = s.createQuery("select st.fname from Student st");

		List list = q.list();
		Iterator it = list.iterator();

		String str;
		while (it.hasNext()) {
			str = (String) it.next();

			System.out.println(str);

		}
		s.close();

	}

	private static void TestList() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Query q = s.createQuery("from Student");

		List list = q.list();

		Iterator it = list.iterator();

		Student pojo;
		while (it.hasNext()) {
			pojo = (Student) it.next();

			System.out.println(pojo.getAge());
			System.out.println(pojo.getFname());
			System.out.println(pojo.getLname());

		}
		s.close();

	}

	private static void TestRead() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Student std = (Student) s.load(Student.class, 1);

		System.out.println(std.getAge());
		System.out.println(std.getFname());
		System.out.println(std.getLname());

		s.close();

	}

}
