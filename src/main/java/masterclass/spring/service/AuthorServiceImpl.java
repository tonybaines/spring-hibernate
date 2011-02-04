package masterclass.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import masterclass.spring.domain.Author;
import masterclass.spring.persistence.AuthorDAOImpl;

public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAOImpl authorDAO;
	
	@Transactional
	public Author createAuthor(Author author) {
		return authorDAO.createAuthor(author);
	}
	
	

}
