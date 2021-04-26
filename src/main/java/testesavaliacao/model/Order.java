package testesavaliacao.model;


import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

@Getter
@Setter
@Builder
public class Order {
	
	private Customer customer;
	
	@Singular
	private Set<OrderLine> orderLines;
}
