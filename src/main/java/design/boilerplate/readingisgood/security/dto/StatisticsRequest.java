package design.boilerplate.readingisgood.security.dto;

import design.boilerplate.readingisgood.model.OrderItem;
import design.boilerplate.readingisgood.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class StatisticsRequest {

	private Integer month;

	private User user;


}
