package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;





@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Science"));
			
			bookRepository.save(new Book("Harry Potter", "Jami Saanu", 1999, "B123", 24, crepository.findByName("Fantasy").get(0)));
			bookRepository.save(new Book("Hobbit", "J.R.R Tolkien", 1975, "C123", 20, crepository.findByName("Fantasy").get(0)));
			
			// admin/admin bgg282/user
			User user1 = new User("bgg282", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "moi@luukku.com");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "moi2@luukku.com");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("Get all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
				
				
			}
		};
	}

}
