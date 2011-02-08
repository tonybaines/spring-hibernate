package masterclass.spring;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import masterclass.spring.domain.Author;
import masterclass.spring.domain.Basket;
import masterclass.spring.domain.Book;
import masterclass.spring.domain.Publisher;
import masterclass.spring.service.AuthorService;
import masterclass.spring.service.BasketService;
import masterclass.spring.service.BookService;
import masterclass.spring.service.PublisherService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	

	public static void main(String[] args) {

	    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bookService = context.getBean(BookService.class);
		BasketService basketService = context.getBean(BasketService.class);
		AuthorService authorService = context.getBean(AuthorService.class);
		PublisherService publisherService = context.getBean(PublisherService.class);
		
		//create some Authors
		Author author1 = authorService.createAuthor(new Author("Craig", "Walls"));
		Author author2 = authorService.createAuthor(new Author("Bill", "Bryson"));
		
		//create some Publishers
		Publisher publisher1 = publisherService.createPublisher(new Publisher("Manning Publications"));
		
		//create some Books
		Set<Book> books = new HashSet<Book>();
		Set<Author> authors1 = new HashSet<Author>();
		authors1.add(author1);
		Book book1 = bookService.createBook(new Book("Where's Wally", authors1, "1430226323", publisher1));
		
		Set<Author> authors2 = new HashSet<Author>();
		authors2.add(author2);
		Book book2 = new Book("Spring in Action", authors2, "9887766554432", publisher1);
		book2 = bookService.createBook(book2);
		
		
		books.add(book1);
		books.add(book2);
		
		//create a new basket
		Basket basket1 = new Basket(books);
		basket1 = basketService.createBasket(basket1);
		
		
		System.out.println("getBook for id " + book1.getIsbn() + ":");
		System.out.println(bookService.getBook(book1.getIsbn()));
		
		System.out.println("Books by author " + author1);
		List<Book> authorBooks = authorService.getBooksByAuthor(author1);
		for (Book book : authorBooks) {
			System.out.println(book);
		}
		
		System.out.println("Books with ISBN '1430226323'");
		System.out.println(bookService.getBookByISBN("1430226323"));
		
		System.out.println("Books by publisher " + publisher1);
		List<Book> publisherBooks = publisherService.getBooksByPublisher(publisher1);
		for (Book book : publisherBooks) {
			System.out.println(book);
		}

	}
	
	
}
