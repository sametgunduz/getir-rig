package design.boilerplate.readingisgood.controller;

import design.boilerplate.readingisgood.security.dto.BookRequest;
import design.boilerplate.readingisgood.security.dto.RegistrationResponse;
import design.boilerplate.readingisgood.security.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

	private final BookService bookService;

	@PostMapping
	public ResponseEntity<RegistrationResponse> registrationRequest(@Valid @RequestBody BookRequest bookRequest) {

		final RegistrationResponse registrationResponse = bookService.registrationBook(bookRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<RegistrationResponse> updateStock(
			@RequestBody BookRequest bookRequest, @PathVariable("id") Long id) {

		final RegistrationResponse registrationResponse =  bookService.updateStock(bookRequest, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
	}

}
