package masterclass.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import masterclass.spring.domain.Book;
import masterclass.spring.domain.Publisher;
import masterclass.spring.persistence.PublisherDAO;

@Service("publisherService")
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherDAO publisherDAO;
	
	@Transactional
	public Publisher createPublisher(Publisher publisher) {
		return publisherDAO.createPublisher(publisher);
	}

	@Transactional
	public void deletePublisher(Publisher publisher) {
		publisherDAO.deletePublisher(publisher);
	}

	@Transactional
	public Publisher getPublisher(Integer publisherId) {
		return publisherDAO.getPublisher(publisherId);
	}

	@Transactional
	public void updatePublisher(Publisher publisher) {
		publisherDAO.updatePublisher(publisher);
	}

	@Transactional
	public List<Book> getBooksByPublisher(Publisher publisher) {
		return publisherDAO.getBooksByPublisher(publisher);
	}
	
}
