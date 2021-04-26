package testesavaliacao.test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import testesavaliacao.model.Customer;
import testesavaliacao.model.Order;
import testesavaliacao.model.Product;
import testesavaliacao.service.OrderAnalyzeService;
import testesavaliacao.service.ProviderDataService;

public class ApplicationMainTest {	
	
	Stream<Order> orders = ProviderDataService.getOrders();
	
	@BeforeClass
	public static void init() {
		ProviderDataService.init();
	}	
	
	@Test
	public void testMostPopularProducts() {	
		List<Product> products = OrderAnalyzeService.findMostPopularProducts(orders); 
		Assert.assertEquals(3,products.size());
		System.out.println("Most Popular Products:");
		products.forEach(prd -> System.out.println(prd.toString()));
	}

	@Test
	public void testMostValuableClient() {		
		Optional<Customer> mostValuableCustomer = OrderAnalyzeService.findMostValuableClient(orders);		
		Assert.assertNotNull(mostValuableCustomer);
		System.out.println("\nMost Valuable Client:");
		System.out.println(mostValuableCustomer.get().toString());
	}
	
}
