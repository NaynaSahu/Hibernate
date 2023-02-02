package Association;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestBid {
	public static void main(String[] args) {
		//testO2M();
		 //testDelete();
		testUpdate();
	}

	private static void testUpdate() {
		/*
		 * Bid bid = new Bid(); bid.setId(2); bid.setAmount(200); bid.setItemId(1);
		 */
		
		AuctionItem item = new AuctionItem();
		item.setId(2);
		item.setDescription("Apple");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Transaction tx = s.beginTransaction();

		s.update(item);;
		//s.delete(item);

		tx.commit();

		s.close();
		
		
	}

	private static void testDelete() {

		/*
		 * AuctionItem item = new AuctionItem(); item.setId(1);
		 */

		Bid bid = new Bid();
		bid.setId(3);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Transaction tx = s.beginTransaction();

		s.delete(bid);
		//s.delete(item);

		tx.commit();

		s.close();

	}

	private static void testO2M() {
		AuctionItem item = new AuctionItem();// create the object of the class

		item.setDescription("iPhone"); // as the id is auto incremented and the Bid is given by the Bid class

		Bid bid1 = new Bid();
		bid1.setAmount(100);// the id is auto incremented and the itemId is cascaded
		Bid bid2 = new Bid();
		bid2.setAmount(200);
		Bid bid3 = new Bid();
		bid3.setAmount(300);

		Set<Bid> set = new HashSet<Bid>();// for 1 to many connection on a single item there are many bids so the bid
											// will
											// of type Set as the bids cannot be repeated
		set.add(bid1);
		set.add(bid2);
		set.add(bid3);

		item.setBid(set);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(item);

		tx.commit();

		s.close();

	}

}
