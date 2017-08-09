import java.util.function.Function;

import models.Customer;
import models.Salesman;

public class ComposeFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Function<Integer, Integer> baseFunction = t -> t + 2;
		Function<Integer, Integer> afterFunction = baseFunction.andThen(t -> t * 3);
		System.out.println(afterFunction.apply(5));

		Customer customer = new Customer("bestcustomer@thebestcustomer.com");
		Salesman salesman = new Salesman(customer);
		System.out.println(salesman.getBestCustomer().getEmailAddress());


	}

}
