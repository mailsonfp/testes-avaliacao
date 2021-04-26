package testesavaliacao.model;


import java.math.BigDecimal;
import java.text.DecimalFormat;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product implements Comparable<Product>{
	
	@EqualsAndHashCode.Include
	private String description;
	
	private Integer stockQuantity;
	
	private BigDecimal price;
	
	@Override
	public int compareTo(Product product) {
		if(getDescription().equals(product.getDescription())) {
			return 0;
		}
		
		return -1;
	}
	
	@Override
	public String toString() {
		DecimalFormat formatDecimal = new DecimalFormat(",##0,00");
		return "Product: " + this.getDescription() + ", price: " + formatDecimal.format(getPrice().doubleValue());
	}

}
