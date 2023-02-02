package Test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.mysql.cj.x.protobuf.MysqlxCrud.Projection;

public class TestThroughCriteria {
	public static void main(String[] args) {
		// testList(); // Restrictions
		// testLike(); // Restriction with Condition
		//testSelectCoulmns(); // Projection

	}

	private static void testSelectCoulmns() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Criteria crit = s.createCriteria(Student.class);

		ProjectionList list = Projections.projectionList();
		list.add(Projections.property("id"));
		list.add(Projections.property("fname"));

		crit.setProjection(list);
		
		List l = crit.list();
		Iterator it = l.iterator();
		
		while (it.hasNext()) {
			Object[] ob = (Object[]) it.next();
			String fname = (String) ob[1];
			int id = (int) ob[0];
			
			System.out.print(id);
			System.out.print(fname);
			System.out.println("");
			
		}

	}

	private static void testLike() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Criteria crit = s.createCriteria(Student.class);
		crit.add(Restrictions.like("fname", "%a"));
		// crit.add(Restrictions.eq("id", 1));

		List list = crit.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			Student st = (Student) it.next();
			System.out.println(st.getAge());
			System.out.println(st.getFname());
			System.out.println(st.getLname());

		}

		s.close();

	}

	private static void testList() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Criteria crit = s.createCriteria(Student.class);

		List list = crit.list();
		Iterator it = list.iterator();

		Student st;
		while (it.hasNext()) {
			st = (Student) it.next();

			System.out.println(st.getAge());
			System.out.println(st.getFname());
			System.out.println(st.getLname());

		}
		s.close();

	}

}
