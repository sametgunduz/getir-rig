package design.boilerplate.readingisgood.security.service;

import design.boilerplate.readingisgood.model.Book;
import design.boilerplate.readingisgood.repository.BookRepository;
import design.boilerplate.readingisgood.security.dto.BookRequest;
import design.boilerplate.readingisgood.security.dto.RegistrationResponse;
import design.boilerplate.readingisgood.security.mapper.BookMapper;
import design.boilerplate.readingisgood.utils.GeneralMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private static final String BOOK_REGISTRATION_SUCCESSFUL = "book_registration_successful";

	private static final String BOOK_STOCK_UPDATE_SUCCESSFUL = "book_stock_update_successful";

	private final BookRepository bookRepository;

	private final GeneralMessageAccessor generalMessageAccessor;


	@Override
	public RegistrationResponse registrationBook(BookRequest bookRequest) {

		final Book book = BookMapper.INSTANCE.convertToBook(bookRequest);

		bookRepository.save(book);

		final String title = bookRequest.getTitle();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, BOOK_REGISTRATION_SUCCESSFUL, title);

		log.info("{} book registered successfully!", title);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	@Override
	public RegistrationResponse updateStock(BookRequest bookRequest, Long id) {

		Book book  = bookRepository.getOne(id);
		book.setStock(bookRequest.getStock());
		bookRepository.save(book);
		final String title = bookRequest.getTitle();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, BOOK_STOCK_UPDATE_SUCCESSFUL, title);

		log.info("{} book stock updated successfully!", title);

		return new RegistrationResponse(registrationSuccessMessage);
	}

}
