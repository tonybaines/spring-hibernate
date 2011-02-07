package masterclass.spring.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.UniqueConstraint;
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
import javax.validation.constraints.Size;

@Entity
@Table(name="BOOK",
	       uniqueConstraints=@UniqueConstraint(columnNames="isbn"))
public class Book {

	private Integer id;

	@NotNull
	private String title;
	
	@NotNull
	@Size(min = 13, max = 13)
	private String isbn;

	private Set<Author> authors = new HashSet<Author>();

	public Book() {
	}

	public Book(final String title, final Set<Author> authors, final String isbn) {
		this.title = title;
		this.authors = authors;
		this.isbn = isbn;
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
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
