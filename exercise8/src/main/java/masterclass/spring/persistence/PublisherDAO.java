package masterclass.spring.persistence;

import java.util.List;

import masterclass.spring.domain.Book;
import masterclass.spring.domain.Publisher;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("publisherDAO")
public class PublisherDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Publisher getPublisher(Integer publisherId) {
		return (Publisher) sessionFactory.getCurrentSession().get(Publisher.class, publisherId);
	}

	public Publisher createPublisher(Publisher publisher) {
		Integer returnId = (Integer) sessionFactory.getCurrentSession().save(publisher);
		return getPublisher(returnId);
	}

	public void deletePublisher(Publisher publisher) {
		sessionFactory.getCurrentSession().delete(publisher);
	}


	public void updatePublisher(Publisher publisher) {
		sessionFactory.getCurrentSession().update(publisher);
	}

	public List<Book> getBooksByPublisher(Publisher publisher) {
		Query criteria = sessionFactory.getCurrentSession().
			createQuery("from Book book where publisher_fk = :pubfk")
			.setParameter("pubfk", publisher.getId());
		return (List<Book>)criteria.list();

	}
	
}
