package masterclass.spring.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//TODO: Exercise1 - Add a new 'description' property
//TODO: Exercise1 - Add a validation constraint of a max size of 255 to the new description property. This can be tested in @BookTest

@Entity
@Table(name="BOOK",
	       uniqueConstraints=@UniqueConstraint(columnNames="isbn"))
public class Book {

	@Id
	@NotNull
	@Size(min = 13, max = 13)
	@Column(name = "ISBN", unique = true, nullable = false, length = 13)
	private String isbn;
	
	@NotNull
	private String title;
	
	@ManyToOne
    @JoinColumn(name="publisher_fk")
	private Publisher publisher;

	@ManyToMany(
	        targetEntity=Author.class,
	        cascade={CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(name="AUTHOR_BOOK",joinColumns={@JoinColumn(name="ISBN")},
    		inverseJoinColumns={@JoinColumn(name="AUTHOR_ID")}
    )
	private Set<Author> authors = new HashSet<Author>();

	public Book(){}
	
	public Book(final String title, final Set<Author> authors, final String isbn)  {
		this(title, authors, isbn, null);
	}

	public Book(final String title, final Set<Author> authors, final String isbn, final Publisher publisher) {
		this.title = title;
		this.authors = authors;
		this.isbn = isbn;
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "[Book: " + "ID: " + this.isbn + ", Title: " + this.title
				+ "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Book)) {
			return false;
		}
			
		Book book = (Book) o;
		if (isbn != null ? !isbn.equals(book.getIsbn()): book.getIsbn() != null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int hashCode() {
		return isbn != null ? isbn.hashCode() : 0;
	}

}
