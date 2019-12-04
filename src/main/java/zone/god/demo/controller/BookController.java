package zone.god.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import zone.god.demo.model.Book;
import zone.god.demo.service.BookService;

@Controller

public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/newBook")
    public ModelAndView getNewBookForm(){
        ModelAndView modelAndView = new ModelAndView("create","book",new Book());
        return modelAndView;
    }

    @PostMapping(value = "/newBook",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book createNewBook(@RequestBody Book book){
        return bookService.saveV2(book);
    }

    @GetMapping("")
    public ModelAndView getBookList(Pageable pageable){
        Page<Book> books = bookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("books",books);
        return modelAndView;
    }
//    @GetMapping(value = "{id}/deleteBook", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Book deleteBook(@PathVariable int id){
//        return bookService.deleteV2(id);
//    }

    @PostMapping(value = "{id}/deleteBook", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book deleteBook(@PathVariable Integer id) {
        return bookService.deleteV2(id);
    }

}
