package masterclass.spring.persistence;

import masterclass.spring.domain.Author;
import masterclass.spring.domain.Book;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorDAOImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Author createAuthor(Author author) {
		Integer returnId = (Integer) sessionFactory.getCurrentSession().save(author);
		return (Author) sessionFactory.getCurrentSession().get(Author.class, returnId);
	}
	
	public Book getBookByAuthor(Author author) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
