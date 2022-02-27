package design.boilerplate.readingisgood.security.mapper;

import design.boilerplate.readingisgood.model.Book;
import design.boilerplate.readingisgood.model.Book.BookBuilder;
import design.boilerplate.readingisgood.security.dto.BookRequest;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T19:41:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public Book convertToBook(BookRequest bookRequest) {
        if ( bookRequest == null ) {
            return null;
        }

        BookBuilder book = Book.builder();

        book.title( bookRequest.getTitle() );
        book.author( bookRequest.getAuthor() );
        book.stock( bookRequest.getStock() );

        return book.build();
    }
}
