package springdata.bookstore1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.bookstore1.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
