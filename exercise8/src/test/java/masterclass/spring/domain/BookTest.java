package masterclass.spring.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class BookTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    public void isbnIsTooShort() {
    	Book book = new Book("Spring in Action", new HashSet<Author>(), "345345345365746746545635434535");

    	Set<ConstraintViolation<Book>> constraintViolations =
            validator.validate(book);

        assertEquals(1, constraintViolations.size());
        assertEquals("size must be between 13 and 13", constraintViolations.iterator().next().getMessage());

    }

    @Test
    public void bookIsValid() {
        Book book = new Book("Spring in Action", new HashSet<Author>(), "13243546576867");

        Set<ConstraintViolation<Book>> constraintViolations =
            validator.validate(book);

        assertEquals(0, constraintViolations.size());
    }
}
