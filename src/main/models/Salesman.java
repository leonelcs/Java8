package main.models;

public class Salesman {

	private Customer bestCustomer;

	private Manager manager;

	public Salesman(Manager manager) {
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}

	public Salesman(Customer bestCustomer) {
		this.bestCustomer = bestCustomer;
	}

	public Customer getBestCustomer() {
		return bestCustomer;
	}

}
