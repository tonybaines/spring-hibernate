package masterclass.spring.service;

import masterclass.spring.domain.Basket;
import masterclass.spring.persistence.BasketDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BasketServiceImpl implements BasketService {
	
	@Autowired
	private BasketDAO basketDAO;
	
	@Transactional
	public Basket createBasket(Basket basket) {
		return basketDAO.createBasket(basket);
	}

}
