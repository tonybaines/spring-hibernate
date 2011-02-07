package masterclass.spring.persistence;

import java.util.ArrayList;
import java.util.List;

import masterclass.spring.domain.Author;
import masterclass.spring.domain.Book;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("authorDAO")
public class AuthorDAOImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Author getAuthor(Integer authorId) {
		return (Author) sessionFactory.getCurrentSession().get(Author.class, authorId);
	}
	
	public Author createAuthor(Author author) {
		Integer returnId = (Integer) sessionFactory.getCurrentSession().save(author);
		return getAuthor(returnId);
	}
	
	
	public List<Book> getBookByAuthor(Author author) {
		List<Book> books = new ArrayList<Book>();
		final Session session = sessionFactory.getCurrentSession();
		final String queryString = "SELECT book_id " +
			"FROM book b " +
			"INNER JOIN author_book ab ON b.book_id = ab.book_id " + 
			"INNER JOIN author a ON a.author_id = ab.author_id " + 
			"WHERE a.author_id = :authorid";
		final Query query = session.createSQLQuery(queryString).setParameter("authorid", author.getId());
		List<Integer> ids = (List<Integer>) query.list();
		for (Integer id : ids) {
			books.add((Book)sessionFactory.getCurrentSession().get(Book.class, id));
		}
		
		return books;
	}


	public void deleteAuthor(Author author) {
		sessionFactory.getCurrentSession().delete(author);
	}


	public void updateAuthor(Author author) {
		sessionFactory.getCurrentSession().update(author);
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
