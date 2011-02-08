package masterclass.spring.service;

import java.util.List;

import masterclass.spring.domain.Book;
import masterclass.spring.persistence.BookDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDao;
	
	
	@Transactional
	public Book createBook(Book book) {
		return bookDao.createBook(book);
	}

	@Transactional
	public Book getBook(String isbn) {
		return bookDao.getBook(isbn);
	}

	@Transactional
	public void deleteBook(Book book) {
		bookDao.deleteBook(book);
	}

	@Transactional
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Transactional
	public Book getBookByISBN(String isbn) {
		return bookDao.getBookByISBN(isbn);
	}

	@Override
	public List<Book> listAllBooks() {
		return bookDao.getAll();
	}

}
