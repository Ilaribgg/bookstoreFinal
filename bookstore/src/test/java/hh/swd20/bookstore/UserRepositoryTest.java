package hh.swd20.bookstore;


import static org.assertj.core.api.Assertions.assertThat;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;





@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

@Autowired
private UserRepository repository;



@Test
public void findByUsername() {
	User user = repository.findByUsername("bgg282");
	
	assertThat(user.getEmail()).isEqualTo("moi@luukku.com");

}
@Test
public void createNewUser() {
	User user = new User("newuser", "salasana", "USER", "moi3@luukku.com");
	repository.save(user);
	assertThat(user.getUsername()).isNotNull();
}
@Test
public void deleteAllUsers() {
repository.deleteAll();
assertThat(repository.count()).isEqualTo(0);
}
}