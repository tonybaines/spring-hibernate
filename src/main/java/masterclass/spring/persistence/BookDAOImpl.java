package masterclass.spring.persistence;

import java.util.List;

import masterclass.spring.domain.Book;

import org.hibernate.SessionFactory;
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
		return (Book) sessionFactory.getCurrentSession().get(Book.class, returnId);
	}

	public Book getBookByISBN(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		
	}

}