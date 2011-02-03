package masterclass.spring.persistence;

import java.util.List;

import masterclass.spring.domain.Author;
import masterclass.spring.domain.Book;

public interface BookStoreDAO {

	public List<Book> listBooks();
	
	public Book createBook(Book book);

	public Book getBookByISBN(long id);
	
	public Book getBookByAuthor(Author author);

	public void saveBook(Book book);


}
