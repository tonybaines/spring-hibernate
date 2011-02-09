package masterclass.spring.domain;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import masterclass.spring.persistence.AuthorDAO;
import masterclass.spring.persistence.BookDAO;
import masterclass.spring.persistence.PublisherDAO;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
@Transactional()
public class BookTest {

    private static Validator validator;
    
    private BookDAO bookDAO;
    private AuthorDAO authorDAO;
    private PublisherDAO publisherDAO;
    
    private static final String BOOK1_TITLE = "Spring in Action";
    private static final String BOOK1_ISBN = "9875643215678";
    
    private static final String BOOK2_TITLE = "Java Persistence with Hibernate";
    private static final String BOOK2_ISBN = "1324354657687";
    
    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
    
    @Autowired
    public void setAuthorDAO(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}
    
    @Autowired
    public void setPublisherDAO(PublisherDAO publisherDAO) {
		this.publisherDAO = publisherDAO;
	}

	@Before
    public void preMethodSetup() {
    	Author author1 = new Author("Craig", "Walls");
		Author author2 = new Author("Christian", "Bauer");
		Author author3 = new Author("Gavin", "King");
		
		Set<Author> authors1 = new HashSet<Author>();
		authors1.add(author1);
		
		Set<Author> authors2 = new HashSet<Author>();
		authors2.add(author2);
		
		Publisher publisher1 = publisherDAO.createPublisher(new Publisher("Manning Publications"));
		Publisher publisher2 = publisherDAO.createPublisher(new Publisher("Prentice Hall"));
		
		author1 = authorDAO.createAuthor(author1);
		author2 = authorDAO.createAuthor(author2);
		author3 = authorDAO.createAuthor(author3);
		
		Book book1 = new Book(BOOK1_TITLE, authors1, BOOK1_ISBN, publisher1);
		Book book2 = new Book(BOOK2_TITLE, authors2, BOOK2_ISBN, publisher2);
		
		bookDAO.createBook(book1);
		bookDAO.createBook(book2);
    }
    

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    public void testBookPersisted() {
    	List<Book> books = bookDAO.getAll();
    	assertEquals(2, books.size());
    }
    
    @Test
    public void testGetByISBN() {
    	Book book = bookDAO.getBookByISBN(BOOK2_ISBN);
    	assertNotNull(book);
    	assertEquals(BOOK2_TITLE, book.getTitle());
    }

	@Test
    public void isbnIsTooShortShouldThrowViolation() {
    	Book book = new Book("Spring in Action", new HashSet<Author>(), "123");

    	Set<ConstraintViolation<Book>> constraintViolations =
            validator.validate(book);

        assertEquals(1, constraintViolations.size());
        assertEquals("size must be between 13 and 13", constraintViolations.iterator().next().getMessage());

    }

    @Test
    public void bookIsValid() {
        Book book = new Book("Spring in Action", new HashSet<Author>(), "1324354657687");

        Set<ConstraintViolation<Book>> constraintViolations =
            validator.validate(book);

        assertEquals(0, constraintViolations.size());
    }

}
