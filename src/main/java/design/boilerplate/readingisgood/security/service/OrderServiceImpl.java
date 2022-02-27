package design.boilerplate.readingisgood.security.service;

import design.boilerplate.readingisgood.model.Book;
import design.boilerplate.readingisgood.model.Order;
import design.boilerplate.readingisgood.model.OrderItem;
import design.boilerplate.readingisgood.model.User;
import design.boilerplate.readingisgood.repository.BookRepository;
import design.boilerplate.readingisgood.repository.OrderRepository;
import design.boilerplate.readingisgood.security.dto.OrderRequest;
import design.boilerplate.readingisgood.security.dto.RegistrationResponse;
import design.boilerplate.readingisgood.security.mapper.BookMapper;
import design.boilerplate.readingisgood.security.mapper.OrderMapper;
import design.boilerplate.readingisgood.utils.GeneralMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private static final String ORDER_PLACEMENT_SUCCESSFUL = "order_placement_successful";

    private final GeneralMessageAccessor generalMessageAccessor;

    private final OrderRepository orderRepository;

    private final BookRepository bookRepository;


    @Override
    public RegistrationResponse placeOrder(OrderRequest orderRequest) {
        final String successMessage = generalMessageAccessor.getMessage(null, ORDER_PLACEMENT_SUCCESSFUL, orderRequest.getUser());

        final Order order = OrderMapper.INSTANCE.convertToOrder(orderRequest);
        orderRepository.save(order);

        for (OrderItem orderItem : order.getOrderItems()
        ) {
            Book book  = bookRepository.getOne(orderItem.getBook().getId());
            book.setStock(book.getStock() - orderItem.getQuantity());
            bookRepository.save(book);
        }
        log.info("{}'s order placed successfully!", orderRequest.getUser().getUsername());

        return new RegistrationResponse(successMessage);
    }

    @Override
    public List<Order> findAllByCreatedDateAfterAndCreatedDateBefore(LocalDateTime after, LocalDateTime before) {
        return orderRepository.findAllByCreatedDateBetween(Date
                .from(after.atZone(ZoneId.systemDefault())
                        .toInstant()), Date
                .from(before.atZone(ZoneId.systemDefault())
                        .toInstant()));
    }

    @Override
    public Optional<Order> findByOrderId(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public Page<Order> getOrdersByUser(User user, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        return orderRepository.getOrdersByUser(user, paging);

    }

}
