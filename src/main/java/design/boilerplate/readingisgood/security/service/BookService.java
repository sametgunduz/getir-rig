package design.boilerplate.readingisgood.security.service;

import design.boilerplate.readingisgood.security.dto.BookRequest;
import design.boilerplate.readingisgood.security.dto.RegistrationResponse;


public interface BookService {

	RegistrationResponse registrationBook(BookRequest bookRequest);

    RegistrationResponse updateStock(BookRequest bookRequest, Long id);
}
