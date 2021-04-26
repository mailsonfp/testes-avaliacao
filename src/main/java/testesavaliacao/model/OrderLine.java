package testesavaliacao.model;


import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderLine {
	
	private Product product;
	
	private Integer quantity;
	
	public BigDecimal orderLinePrice() {
		return getProduct().getPrice().multiply(new BigDecimal(quantity));
	}
}
