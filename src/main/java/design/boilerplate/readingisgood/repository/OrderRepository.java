package design.boilerplate.readingisgood.repository;

import design.boilerplate.readingisgood.model.Order;
import design.boilerplate.readingisgood.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByCreatedDateBetween(Date after, Date before);

    Optional<Order> findById(Long orderId);

    Page<Order> getOrdersByUser(User user, Pageable pageable);
}
