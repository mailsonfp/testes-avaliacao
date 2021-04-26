package testesavaliacao.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Customer implements Comparable<Customer> {
	
	private String name;
	
	private String email;

	@Override
	public int compareTo(Customer customer) {
		if(this.getName().equals(customer.getName())){
			return 0;
		}
		
		return -1;
	}
	
	@Override
	public String toString() {		
		return "Customer: " + getName() + ", e-mail:" + getEmail();
	}
}
