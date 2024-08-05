package springdata.bookstore1.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.bookstore1.repositories.BookRepository;

@Service
@AllArgsConstructor
public class BookServiceImpl {

    private final BookRepository bookRepository;
}
