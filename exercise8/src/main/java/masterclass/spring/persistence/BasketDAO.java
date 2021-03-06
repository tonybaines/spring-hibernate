package masterclass.spring.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import masterclass.spring.domain.Basket;

@Repository("basketDAO")
public class BasketDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Basket createBasket(Basket basket) {
		Integer returnId = (Integer) sessionFactory.getCurrentSession().save(basket);
		return (Basket) sessionFactory.getCurrentSession().get(Basket.class, returnId);
	}

}
