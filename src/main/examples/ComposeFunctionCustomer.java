package main.examples;

import java.util.function.Function;

import main.models.Customer;
import main.models.Manager;
import main.models.Salesman;

public class ComposeFunctionCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer customer = new Customer("bestcustomer@thebestcustomer.com");
		Salesman salesman = new Salesman(customer);
		processEmailAddress(salesman, toEmailAddress);

//		System.out.println(salesman.getBestCustomer().getEmailAddress());
//		System.out.println(toEmailAddress.apply(salesman));

		Manager manager = new Manager("manager@thecompany.com");
		Salesman salesman2 = new Salesman(manager);
		processEmailAddress(salesman2,toManagerEmailAddress);
//		System.out.println(toManagerEmailAddress.apply(salesman2));
//		System.out.println(salesman2.getManager().getEmailAddress());

	}

	static public void processEmailAddress(Salesman salesman, Function<Salesman, String> toEmailAddress) {
		System.out.println(toEmailAddress.apply(salesman));
	}

	static Function<Customer, String> customerToEmailAddress = Customer::getEmailAddress;
	static Function<Salesman, Customer> salesmanToBestCustomer = Salesman::getBestCustomer;
	static Function<Salesman, String> toEmailAddress = salesmanToBestCustomer.andThen(customerToEmailAddress);

	static Function<Manager, String> managerToEmailAddress = Manager::getEmailAddress;
	static Function<Salesman, Manager> salesmanToManager = Salesman::getManager;
	static Function<Salesman, String> toManagerEmailAddress = salesmanToManager.andThen(managerToEmailAddress);
}
