package hh.swd20.bookstore;







import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

@Autowired
private CategoryRepository repository;



@Test
public void findByCategoryName() {
	List<Category> category = repository.findByName("Fantasy");
	
assertThat(category).hasSize(1);
assertThat(category.get(0).getCategoryid()).isEqualTo(1);
}
@Test
public void createNewCategory() {
	Category category = new Category("Romance");
	repository.save(category);
	assertThat(category.getCategoryid()).isNotNull();
}
@Test
public void deleteAllCategories() {
repository.deleteAll();
assertThat(repository.count()).isEqualTo(0);
}
}


