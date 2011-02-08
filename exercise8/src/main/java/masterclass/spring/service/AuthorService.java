package masterclass.spring.service;

import java.util.List;

import masterclass.spring.domain.Author;
import masterclass.spring.domain.Book;

public interface AuthorService {
	
	public Author getAuthor(Integer authorId);
	
	public List<Author> getAll();
	
	public Author createAuthor(Author author);
	
	public void updateAuthor(Author author);
	
	public void deleteAuthor(Author author);
	
	public List<Author> getAuthorByNameLike(String firstName, String lastName);
	
	public List<Book> getBooksByAuthor(Author author);

}
