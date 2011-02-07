package masterclass.spring.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import masterclass.spring.domain.Basket;

public class BasketDAOImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Basket createBasket(Basket basket) {
		Integer returnId = (Integer) sessionFactory.getCurrentSession().save(basket);
		return (Basket) sessionFactory.getCurrentSession().get(Basket.class, returnId);
	}

}
