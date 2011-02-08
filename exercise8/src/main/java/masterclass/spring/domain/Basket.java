package masterclass.spring.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="BASKET")
public class Basket {


	@SequenceGenerator(name="Basket_Gen", sequenceName="Basket_Seq")
	@Id @GeneratedValue(generator="Basket_Gen")
	@Column(name = "BASKET_ID")
    private Integer id;
	
    @OneToMany(
	        targetEntity=Book.class,
	        cascade={CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(name="BASKET_BOOK",joinColumns={@JoinColumn(name="BASKET_ID")},
    		inverseJoinColumns={@JoinColumn(name="BOOK_ID")}
    )
	private Set<Book> books = new HashSet<Book>();
	
	public Basket(){}
	
	public Basket(Set<Book> books) {
		this.books = books;
	}
	
	public Integer getId() {
		return id;
	}
	
	private void setId(Integer id) {
		this.id = id;
	}
	
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}


}
