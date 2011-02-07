package masterclass.spring.persistence;

import java.util.List;

import masterclass.spring.domain.Book;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl  {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BookDAOImpl() {}
	
	public List<Book> listBooks() {
		return (List<Book>)sessionFactory.getCurrentSession().createQuery("from Books")
		    .list();
	}
	
	public Book createBook(Book book) {
		Integer returnId = (Integer) sessionFactory.getCurrentSession().save(book);
		return getBook(returnId);
	}
	
	public Book getBook(Integer id) {
		return (Book) sessionFactory.getCurrentSession().get(Book.class, id);
	}

	public void deleteBook(Book book) {
		sessionFactory.getCurrentSession().delete(book);
	}

	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
	}

	public Book getBookByISBN(String isbn) {
		return (Book) sessionFactory.getCurrentSession().createCriteria(Book.class)
	    .add( Restrictions.eq("isbn", isbn )).uniqueResult();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}
