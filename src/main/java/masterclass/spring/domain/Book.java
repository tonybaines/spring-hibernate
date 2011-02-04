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
@Table(name = "BOOK")
public class Book {

	private Integer id;

	@NotNull
	private String title;

	private Set<Author> authors = new HashSet<Author>();

	public Book() {
	}

	public Book(final String title, Set<Author> authors) {
		this.title = title;
		this.authors = authors;
	}

	@SequenceGenerator(name = "Book_Gen", sequenceName = "Book_Seq")
	@Id
	@GeneratedValue(generator = "Book_Gen")
	@Column(name = "BOOK_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToMany(
	        targetEntity=Author.class,
	        cascade={CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(name="AUTHOR_BOOK",joinColumns={@JoinColumn(name="BOOK_ID")},inverseJoinColumns={@JoinColumn(name="AUTHOR_ID")}
    )
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "[Book: " + "ID: " + this.id + ", Title: " + this.title
				+ "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Book))
			return false;
		Book book = (Book) o;
		if (title != null ? !title.equals(book.title)
				: book.getTitle() != null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int hashCode() {
		return title != null ? title.hashCode() : 0;
	}

}
