package design.boilerplate.readingisgood.security.service;

import design.boilerplate.readingisgood.model.Order;
import design.boilerplate.readingisgood.model.User;
import design.boilerplate.readingisgood.security.dto.OrderRequest;
import design.boilerplate.readingisgood.security.dto.RegistrationResponse;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface OrderService {

	RegistrationResponse placeOrder(OrderRequest orderRequest);

    List<Order> findAllByCreatedDateAfterAndCreatedDateBefore(LocalDateTime after, LocalDateTime before);

    Optional<Order> findByOrderId(Long orderId);

    Page<Order> getOrdersByUser(User user, int page, int size);
}
