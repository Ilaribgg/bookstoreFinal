package hh.swd20.bookstore;







import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;



@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

@Autowired
private BookRepository repository;



@Test
public void findByAuthornameShouldReturnBook() {
	List<Book> books = repository.findByAuthor("Jami Saanu");
	
assertThat(books).hasSize(1);
assertThat(books.get(0).getTitle()).isEqualTo("Harry Potter");
}
@Test
public void createNewBook() {
	Book book = new Book("Hobbit", "Sami Jaanu", 1999, "D123", 20, new Category("Adventure"));
	repository.save(book);
	assertThat(book.getId()).isNotNull();
}
@Test
public void deleteAllBooks() {
repository.deleteAll();
assertThat(repository.count()).isEqualTo(0);
}
}

