package springdata.bookstore1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.bookstore1.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
