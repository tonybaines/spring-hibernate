package masterclass.spring.service;

import java.util.List;

import masterclass.spring.domain.Book;

public interface BookService {

	public List<Book> listAllBooks();
	
	public Book getBook(String isbn);
	
	public Book createBook(Book book);
	
	public Book getBookByISBN(String isbn);
	
	public void updateBook(Book book);
	
	public void deleteBook(Book book);

}
