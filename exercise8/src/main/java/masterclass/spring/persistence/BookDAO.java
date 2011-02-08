package masterclass.spring.persistence;

import java.util.List;

import masterclass.spring.domain.Book;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO  {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BookDAO() {}
	
	public List<Book> getAll() {
		return (List<Book>)sessionFactory.getCurrentSession().createQuery("from Book")
		    .list();
	}
	
	public Book createBook(Book book) {
		String isbn = (String) sessionFactory.getCurrentSession().save(book);
		return getBook(isbn);
	}
	
	public Book getBook(String isbn) {
		return (Book) sessionFactory.getCurrentSession().get(Book.class, isbn);
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
