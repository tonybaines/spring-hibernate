package masterclass.spring.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import masterclass.spring.domain.Book;
import masterclass.spring.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = { "Accept=application/json" })
	public @ResponseBody
	Map getBook(@PathVariable("id") long id) {
		System.out.println("GET a book");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Greeting", "Hello world");
		return map;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = { "Accept=application/json" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void putBook(@PathVariable("id") long id, Book book) {
		System.out.println("PUT a book");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBook(@PathVariable("id") long id) {
		System.out.println("DELETE a book");
	}

	@RequestMapping(method = RequestMethod.POST, headers = { "Accept=application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody
	Book createBook(Book book, BindingResult result,
			HttpServletResponse response) throws BindException {
		System.out.println("POST a book");
		if (result.hasErrors()) {
			throw new BindException(result);
		}
		// Do save here
		response.setHeader("Location", "/books/" + book.getId());
		return book;

	}

}
