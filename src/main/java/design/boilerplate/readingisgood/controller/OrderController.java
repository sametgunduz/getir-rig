package design.boilerplate.readingisgood.controller;

import design.boilerplate.readingisgood.model.Order;
import design.boilerplate.readingisgood.security.dto.OrderRequest;
import design.boilerplate.readingisgood.security.dto.RegistrationResponse;
import design.boilerplate.readingisgood.security.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping("/place")
	public ResponseEntity<RegistrationResponse> placeOrder(@Valid @RequestBody OrderRequest orderRequest) {

		final RegistrationResponse registrationResponse = orderService.placeOrder(orderRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
	}

	@GetMapping("/orders")
	public List<Order> getOrders(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime after, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime before) {
		return orderService.findAllByCreatedDateAfterAndCreatedDateBefore(after, before);
	}


	@GetMapping("/{id}")
	public Optional<Order> findOne(@PathVariable Long id) {
		return orderService.findByOrderId(id);
	}

}
