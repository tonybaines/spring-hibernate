package masterclass.spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BOOKS")
public class Book {

  @SequenceGenerator(name = "Book_Gen", sequenceName = "Book_Seq")
  @Id
  @GeneratedValue(generator = "Book_Gen")
  private Integer id;

  @NotNull
  private String title;

  public Integer getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "[Book: " + "ID: " + this.id + ", Title: " + this.title + "]";
  }

}
