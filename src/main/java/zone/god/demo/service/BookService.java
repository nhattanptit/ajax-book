package zone.god.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zone.god.demo.model.Book;

public interface BookService {
    Page<Book> findAll(Pageable pageable);
    Book findById(int id);
    void save(Book book);
    void delete(int id);
    Book saveV2(Book book);
    Book deleteV2(int id);
}
