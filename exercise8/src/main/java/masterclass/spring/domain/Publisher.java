package masterclass.spring.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PUBLISHER")
public class Publisher {

	@SequenceGenerator(name = "Publisher_Gen", sequenceName = "Publisher_Seq")
	@Id
	@GeneratedValue(generator = "Publisher_Gen")
	@Column(name = "PUBLISHER_ID")
	private Integer id;

	@NotNull
	private String name;

	@OneToMany(mappedBy="publisher")
	private Set<Book> books = new HashSet<Book>();

	public Publisher() {
	}
	
	public Publisher(String name) {
		this(name, null);
	}

	public Publisher(String name, Set<Book> books) {
		this.name = name;
		this.books = books;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
