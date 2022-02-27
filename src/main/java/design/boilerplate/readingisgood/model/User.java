package design.boilerplate.readingisgood.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(unique = true)
	private String username;

	private String password;

	private String email;

	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	@OneToMany(fetch = FetchType.EAGER,mappedBy="user",cascade = CascadeType.ALL)
	private Set<Order> orderSet;

}
