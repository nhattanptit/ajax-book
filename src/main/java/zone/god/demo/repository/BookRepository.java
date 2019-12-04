package zone.god.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import zone.god.demo.model.Book;

public interface BookRepository extends PagingAndSortingRepository<Book,Integer> {
}
