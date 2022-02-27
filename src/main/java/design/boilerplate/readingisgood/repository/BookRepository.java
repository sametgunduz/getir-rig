package design.boilerplate.readingisgood.repository;

import design.boilerplate.readingisgood.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {

}
