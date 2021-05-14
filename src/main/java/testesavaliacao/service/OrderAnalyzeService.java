package testesavaliacao.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import testesavaliacao.model.Customer;
import testesavaliacao.model.Order;
import testesavaliacao.model.Product;

public abstract class OrderAnalyzeService {
	
	public static List<Product> findMostPopularProducts(Stream<Order> orders){
		List<Order> ordersList = orders.collect(Collectors.toList());
		List<Product> productsList = new ArrayList<>(); 
		
		ordersList.forEach(order -> order.getOrderLines().forEach(orderLine -> productsList.add(orderLine.getProduct())));
		
		Map<Product, Integer> popularProducts = new HashMap<>();
		productsList.forEach(p -> popularProducts.merge(p, 1, Integer::sum));
		
		Map<Product, Integer> returnMap = popularProducts.entrySet()
									.stream()
									.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
									.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
		
		Product[] x = returnMap.keySet().toArray(new Product[10]);		
		return Arrays.asList(x[0],x[1],x[2]);
	}
	
	public static Optional<Customer> findMostValuableClient(Stream<Order> orders){
		List<Order> orderList = orders.collect(Collectors.toList());
		Map<Customer,BigDecimal> returnMap = new LinkedHashMap<>();
		
		orderList.forEach(order -> returnMap.merge(order.getCustomer(), order.getTotalOrder(), BigDecimal::add));
		
		Map<Customer,BigDecimal> orderedMap = returnMap.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));		
		
		return Optional.of(orderedMap.keySet().stream().collect(Collectors.toList()).get(0));
	}
}
