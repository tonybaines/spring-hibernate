package masterclass.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import masterclass.spring.domain.Author;
import masterclass.spring.domain.Book;
import masterclass.spring.persistence.AuthorDAOImpl;

public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAOImpl authorDAO;
	
	
	@Transactional
	public Author getAuthor(Integer authorId) {
		return authorDAO.getAuthor(authorId);
	}
	
	@Transactional
	public Author createAuthor(Author author) {
		return authorDAO.createAuthor(author);
	}

	@Transactional
	public void deleteAuthor(Author author) {
		 authorDAO.deleteAuthor(author);
	}

	@Transactional
	public void updateAuthor(Author author) {
		authorDAO.updateAuthor(author);
	}
	
	@Transactional
	public List<Book> getBooksByAuthor(Author author) {
		return authorDAO.getBookByAuthor(author);
	}

}
