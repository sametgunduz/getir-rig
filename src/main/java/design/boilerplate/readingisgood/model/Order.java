package design.boilerplate.readingisgood.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date createdDate;

	@Column(name = "total_price")
	private Double totalPrice;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_item_id", referencedColumnName = "id",insertable = false,updatable = false)
	private List<OrderItem> orderItems;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id",insertable = false,updatable = false)
	private User user;

}
