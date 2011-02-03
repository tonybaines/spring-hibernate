package masterclass.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="BOOKS")
public class Book {
	
	
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;

	public Integer getId() {
		return id;
	}
	
	

}
