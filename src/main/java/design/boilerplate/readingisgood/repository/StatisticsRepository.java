package design.boilerplate.readingisgood.repository;

import design.boilerplate.readingisgood.model.Order;
import design.boilerplate.readingisgood.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface StatisticsRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserAndCreatedDateBetween(User user, Date after, Date before);
}
