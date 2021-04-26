package testesavaliacao.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import testesavaliacao.model.Customer;
import testesavaliacao.model.Order;
import testesavaliacao.model.OrderLine;
import testesavaliacao.model.Product;

public class ProviderDataService {
	
	static Customer firstCustomer;
	static Customer secondCustomer;
	static Customer thirdCustomer;
	static Customer fourthCustomer;
	static Customer fifthCustomer;
	
	static Product productA;
	static Product productB;
	static Product productC;
	static Product productD;
	static Product productE;
	
	static List<Order> ordersList;
	
	public static void init() {
		initCustomers();		
		initProducts();
		initOrders();
	}
	
	public static Stream<Order> getOrders(){
		return ordersList.stream();
	}
	
	private static void initCustomers() {
		firstCustomer = Customer.builder()
							.name("First Customer")
							.email("firstcst@gmail.com")
							.build();
		
		secondCustomer = Customer.builder()
							.name("Second Customer")
							.email("secondcst@gmail.com")
							.build();
		
		thirdCustomer = Customer.builder()
							.name("Third Customer")
							.email("thirdcst@gmail.com")
							.build();
		
		fourthCustomer = Customer.builder()
							.name("Fourth Customer")
							.email("fourthcst@gmail.com")
							.build();
		
		fifthCustomer = Customer.builder()
							.name("Fifth Customer")
							.email("fifthcst@gmail.com")
							.build();
	}
	
	private static void initProducts() {
		productA = Product.builder()
						.description("Product A")
						.price(BigDecimal.valueOf(10.5))
						.build();
		
		productB = Product.builder()
				.description("Product B")
				.price(BigDecimal.valueOf(20.5))
				.build();
		
		productC = Product.builder()
				.description("Product C")
				.price(BigDecimal.valueOf(30.5))
				.build();
		
		productD = Product.builder()
				.description("Product D")
				.price(BigDecimal.valueOf(40.5))
				.build();
		
		productE = Product.builder()
				.description("Product E")
				.price(BigDecimal.valueOf(50.5))
				.build();
	}
	
	private static void initOrders() {
		ordersList = new ArrayList<Order>();
		
		for(Integer i = 1; i<=5; i++) {
			
			Customer c = Customer.builder().build();
			List<Product> products = new ArrayList<Product>();
			
			if(i==1) {
				c = firstCustomer;
				products.add(productA);
				products.add(productB);
				
			}else if (i==2) {
				c = secondCustomer;
				
				products.add(productB);
				products.add(productC);			
				products.add(productD);				
			}else if (i==3) {
				c = thirdCustomer;
				
				products.add(productB);
				products.add(productE);
				products.add(productD);
			}else if (i==4) {
				c = fourthCustomer;
				
				products.add(productB);
				products.add(productD);
				products.add(productE);
			}else if (i==5) {
				c = fifthCustomer;
				
				products.add(productA);
				products.add(productB);
				products.add(productC);
				products.add(productD);
				products.add(productE);				
			}
			
			Set<OrderLine> lines = new HashSet<OrderLine>();
			products.forEach(p -> {
				OrderLine orderLine = OrderLine.builder()
										.product(p)
										.quantity(Integer.valueOf(1))
										.build();
				
				 lines.add(orderLine);
			});
			
			Order order = Order.builder()
							.customer(c)
							.orderLines(lines)
							.build();					
			
			ordersList.add(order);
		}
		
		Order order = Order.builder()
						.customer(firstCustomer)
						.orderLine(OrderLine.builder().product(productE).quantity(10).build())
						.build();
		ordersList.add(order);
	}
}
