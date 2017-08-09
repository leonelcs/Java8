package main.models;

public class Salesman {

	private Customer bestCustomer;

	public Salesman(Customer bestCustomer) {
		this.bestCustomer = bestCustomer;
	}

	public Customer getBestCustomer() {
		return bestCustomer;
	}

}
