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
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="AUTHOR")
public class Author {
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	private Set<Book> books = new HashSet<Book>();
	
	private Integer id;
	
	public Author(){}
	
	public Author(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@SequenceGenerator(name="Author_Gen", sequenceName="Author_Seq")
	@Id @GeneratedValue(generator="Author_Gen")
	@Column(name = "AUTHOR_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	@ManyToMany(
	        targetEntity=Book.class,
	        cascade={CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(name="AUTHOR_BOOK",joinColumns={@JoinColumn(name="AUTHOR_ID")},inverseJoinColumns={@JoinColumn(name="BOOK_ID")}
    )
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "[Author: " + "ID: " + this.id + ", Name: " + this.firstName + " " + this.lastName
				+ "]";
	}

}
