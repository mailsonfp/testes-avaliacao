package testesavaliacao.model;


import java.math.BigDecimal;
import java.text.DecimalFormat;
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
	
	public BigDecimal getTotalOrder() {
		return getOrderLines().stream().map(x -> x.getOrderLineTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);
		
	}
	
	@Override
	public String toString() {
		DecimalFormat formatDecimal = new DecimalFormat(",##0,00");
		return "Customer order: " + this.getCustomer().getName() + ", totalOrder: " + formatDecimal.format(getTotalOrder().doubleValue());
	}
}
