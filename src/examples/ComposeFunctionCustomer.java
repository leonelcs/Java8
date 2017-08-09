package examples;
import java.util.function.Function;

import models.Customer;
import models.Salesman;

public class ComposeFunctionCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer customer = new Customer("bestcustomer@thebestcustomer.com");
		Salesman salesman = new Salesman(customer);
		
		System.out.println(salesman.getBestCustomer().getEmailAddress());
		
		System.out.println(toEmailAddress.apply(salesman));

	}

	static Function<Customer, String> customerToEmailAddress = Customer::getEmailAddress;
	static Function<Salesman, Customer> salesmanToBestCustomer = Salesman::getBestCustomer;
	static Function<Salesman, String> toEmailAddress = salesmanToBestCustomer.andThen(customerToEmailAddress);

}
