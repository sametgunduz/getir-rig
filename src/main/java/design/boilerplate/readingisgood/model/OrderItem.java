package design.boilerplate.readingisgood.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_ITEMS")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity")
	private @NotNull Integer quantity;

	@Column(name = "price")
	private @NotNull Double price;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "total_price")
	private Double totalPrice;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "id",insertable = false,updatable = false)
	private Order order;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id", referencedColumnName = "id",insertable = false,updatable = false)
	private Book book;
	

}
