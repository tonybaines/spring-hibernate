package masterclass.spring.service;

import masterclass.spring.domain.Book;
import masterclass.spring.persistence.BookStoreDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BookServiceImpl implements BookService {

	@Autowired
	private BookStoreDAO bookDao;
	
	@Transactional
	public Book createBook(Book book) {
		return bookDao.createBook(book);
	}
	

}
