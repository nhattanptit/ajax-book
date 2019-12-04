package zone.god.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zone.god.demo.model.Book;
import zone.god.demo.repository.BookRepository;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(int id) {
        if(bookRepository.findById(id).isPresent()){
            return bookRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book saveV2(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book deleteV2(int id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.deleteById(id);
        return book;
    }
}
