package masterclass.spring.service;

import java.util.List;

import masterclass.spring.domain.Book;
import masterclass.spring.domain.Publisher;

public interface PublisherService {
	
	public Publisher getPublisher(Integer publisherId);
	
	public Publisher createPublisher(Publisher publisher);
	
	public void updatePublisher(Publisher publisher);
	
	public void deletePublisher(Publisher publisher);
	
	public List<Book> getBooksByPublisher(Publisher publisher);

}
