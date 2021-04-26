package testesavaliacao.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import testesavaliacao.model.Customer;
import testesavaliacao.model.Order;
import testesavaliacao.model.Product;

public class OrderAnalyzeService {
	
	public static List<Product> findMostPopularProducts(Stream<Order> orders){
		
		return new ArrayList<Product>();
	}
	
	public static Optional<Customer> findMostValuableClient(Stream<Order> orders){
		return Optional.of(Customer.builder()
					.name("Teste")
					.email("teste@gmail.com").build());
	}
}
