package masterclass.spring;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import masterclass.spring.domain.Author;
import masterclass.spring.domain.Basket;
import masterclass.spring.domain.Book;
import masterclass.spring.service.AuthorService;
import masterclass.spring.service.BasketService;
import masterclass.spring.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;


public class BootStrapper {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private AuthorService authorService;
	
	@PostConstruct
	public void initialize() {
		
		//create some Authors
		Author author1 = authorService.createAuthor(new Author("Craig", "Walls"));
		Set<Author> authors = new HashSet<Author>();
		authors.add(author1);
		
		//create some Books
		Set<Book> books = new HashSet<Book>();
		Book item1 = bookService.createBook(new Book("Where's Wally", authors));
		books.add(item1);
		
		//create a new basket
		Basket basket1 = new Basket(books);
		basket1 = basketService.createBasket(basket1);
		
		System.out.println("BOOTSTRAP");
	}
	
	
}
