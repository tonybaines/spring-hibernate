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
public class AuthorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Author getAuthor(Integer authorId) {
		return (Author) sessionFactory.getCurrentSession().get(Author.class, authorId);
	}
	
	public List<Author> getAll() {
		//TODO: Exercise3 - Write a test in @AuthorTest and modify this to return in ascending order by lastName
		return (List<Author>)sessionFactory.getCurrentSession().createQuery("from Author")
	    .list();
	}
	
	public Author createAuthor(Author author) {
		Integer returnId = (Integer) sessionFactory.getCurrentSession().save(author);
		return getAuthor(returnId);
	}
	
	
	public List<Book> getBookByAuthor(Author author) {
		List<Book> books = new ArrayList<Book>();
		final Session session = sessionFactory.getCurrentSession();
		final String queryString = "SELECT isbn " +
			"FROM book b " +
			"INNER JOIN author_book ab ON b.isbn = ab.isbn " + 
			"INNER JOIN author a ON a.author_id = ab.author_id " + 
			"WHERE a.author_id = :authorid";
		final Query query = session.createSQLQuery(queryString).setParameter("authorid", author.getId());
		List<String> isbns = (List<String>) query.list();
		for (String isbn : isbns) {
			books.add((Book)sessionFactory.getCurrentSession().get(Book.class, isbn));
		}
		
		return books;
	}


	public void deleteAuthor(Author author) {
		sessionFactory.getCurrentSession().delete(author);
	}


	public void updateAuthor(Author author) {
		sessionFactory.getCurrentSession().update(author);
	}
	
    public List<Author> getAuthorsByNameLike(String firstName, String lastName) {
		//TODO: Exercise2 - Write a test in @AuthorTest, and implement code here to return
    	//an author based on firstname/lastname wildcard matches.
    	return new ArrayList<Author>();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
