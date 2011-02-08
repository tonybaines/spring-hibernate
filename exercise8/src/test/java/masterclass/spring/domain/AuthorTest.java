package masterclass.spring.domain;

import static org.junit.Assert.assertEquals;

import java.util.List;

import masterclass.spring.persistence.AuthorDAO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
@Transactional()
public class AuthorTest {

	private AuthorDAO authorDAO;

	@Autowired
	public void setAuthorDAO(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}

	@Before
	public void preMethodSetup() {
		Author author1 = new Author("Craig", "Walls");
		Author author2 = new Author("Christian", "Bauer");
		Author author3 = new Author("Gavin", "King");
		author1 = authorDAO.createAuthor(author1);
		author2 = authorDAO.createAuthor(author2);
		author3 = authorDAO.createAuthor(author3);
	}

	@Test
	public void testBookPersisted() {
		List<Author> authors = authorDAO.getAll();
		assertEquals(3, authors.size());
	}
	
	//TODO: Write a test for finding an Author based on name like....
	

}
