package zone.god.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import zone.god.demo.service.BookService;
import zone.god.demo.service.BookServiceImpl;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableWebMvc
@EnableTransactionManagement
public class TestAjaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestAjaxApplication.class, args);
    }
    @Bean
    public BookService bookService(){
        return new BookServiceImpl();
    }
}
