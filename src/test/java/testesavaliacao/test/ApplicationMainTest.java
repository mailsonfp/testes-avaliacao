package testesavaliacao.test;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import testesavaliacao.model.Order;
import testesavaliacao.service.OrderAnalyzeService;
import testesavaliacao.service.ProviderDataService;

public class ApplicationMainTest {	
	
	@BeforeClass
	public static void init() {
		ProviderDataService.init();
	}	
	
	@Test
	public void testMostPopularProducts() {
		Stream<Order> orders = ProviderDataService.getOrders();
	
		Assert.assertNotNull(OrderAnalyzeService.findMostPopularProducts(orders));
	}

	@Test
	public void testMostValuableClient() {
		Stream<Order> orders = Stream.ofNullable(null);
		
		Assert.assertNotNull(OrderAnalyzeService.findMostValuableClient(orders));
	}
	
	
}
